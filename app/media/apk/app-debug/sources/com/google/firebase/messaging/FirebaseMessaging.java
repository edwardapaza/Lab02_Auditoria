package com.google.firebase.messaging;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class FirebaseMessaging {
    private static final String EXTRA_DUMMY_P_INTENT = "app";
    static final String GMS_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final long MIN_DELAY_SEC = 30;
    private static final String SEND_INTENT_ACTION = "com.google.android.gcm.intent.SEND";
    private static final String SUBTYPE_DEFAULT = "";
    static final String TAG = "FirebaseMessaging";
    private static Store store;
    static ScheduledExecutorService syncExecutor;
    static TransportFactory transportFactory;
    private final AutoInit autoInit;
    private final Context context;
    private final Executor fileExecutor;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi fis;
    private final GmsRpc gmsRpc;
    private final FirebaseInstanceIdInternal iid;
    private final Executor initExecutor;
    private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private final Metadata metadata;
    private final RequestDeduplicator requestDeduplicator;
    private boolean syncScheduledOrRunning;
    private final Executor taskExecutor;
    private final Task<TopicsSubscriber> topicsSubscriberTask;

    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(FirebaseApp.getInstance());
        }
        return firebaseMessaging;
    }

    private static synchronized Store getStore(Context context) {
        Store store2;
        synchronized (FirebaseMessaging.class) {
            if (store == null) {
                store = new Store(context);
            }
            store2 = store;
        }
        return store2;
    }

    static synchronized void clearStoreForTest() {
        synchronized (FirebaseMessaging.class) {
            store = null;
        }
    }

    static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal iid, Provider<UserAgentPublisher> userAgentPublisher, Provider<HeartBeatInfo> heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber) {
        this(firebaseApp, iid, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi, transportFactory2, subscriber, new Metadata(firebaseApp.getApplicationContext()));
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal iid, Provider<UserAgentPublisher> userAgentPublisher, Provider<HeartBeatInfo> heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber, Metadata metadata) {
        this(firebaseApp, iid, firebaseInstallationsApi, transportFactory2, subscriber, metadata, new GmsRpc(firebaseApp, metadata, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi), FcmExecutors.newTaskExecutor(), FcmExecutors.newInitExecutor(), FcmExecutors.newFileIOExecutor());
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal iid, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber, Metadata metadata, GmsRpc gmsRpc, Executor taskExecutor, Executor initExecutor, Executor fileExecutor) {
        this.syncScheduledOrRunning = false;
        transportFactory = transportFactory2;
        this.firebaseApp = firebaseApp;
        this.iid = iid;
        this.fis = firebaseInstallationsApi;
        this.autoInit = new AutoInit(subscriber);
        Context applicationContext = firebaseApp.getApplicationContext();
        this.context = applicationContext;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.lifecycleCallbacks = fcmLifecycleCallbacks;
        this.metadata = metadata;
        this.taskExecutor = taskExecutor;
        this.gmsRpc = gmsRpc;
        this.requestDeduplicator = new RequestDeduplicator(taskExecutor);
        this.initExecutor = initExecutor;
        this.fileExecutor = fileExecutor;
        Context appContext = firebaseApp.getApplicationContext();
        if (appContext instanceof Application) {
            Application app = (Application) appContext;
            app.registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            Log.w("FirebaseMessaging", "Context " + appContext + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (iid != null) {
            iid.addNewTokenListener(new FirebaseInstanceIdInternal.NewTokenListener() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda2
                @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener
                public final void onNewToken(String str) {
                    FirebaseMessaging.this.m108lambda$new$0$comgooglefirebasemessagingFirebaseMessaging(str);
                }
            });
        }
        initExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.m109lambda$new$1$comgooglefirebasemessagingFirebaseMessaging();
            }
        });
        Task<TopicsSubscriber> createInstance = TopicsSubscriber.createInstance(this, metadata, gmsRpc, applicationContext, FcmExecutors.newTopicsSyncExecutor());
        this.topicsSubscriberTask = createInstance;
        createInstance.addOnSuccessListener(initExecutor, new OnSuccessListener() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseMessaging.this.m110lambda$new$2$comgooglefirebasemessagingFirebaseMessaging((TopicsSubscriber) obj);
            }
        });
        initExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.m111lambda$new$3$comgooglefirebasemessagingFirebaseMessaging();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-google-firebase-messaging-FirebaseMessaging  reason: not valid java name */
    public /* synthetic */ void m109lambda$new$1$comgooglefirebasemessagingFirebaseMessaging() {
        if (isAutoInitEnabled()) {
            startSyncIfNecessary();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-google-firebase-messaging-FirebaseMessaging  reason: not valid java name */
    public /* synthetic */ void m110lambda$new$2$comgooglefirebasemessagingFirebaseMessaging(TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.startTopicsSyncIfNecessary();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$3$com-google-firebase-messaging-FirebaseMessaging  reason: not valid java name */
    public /* synthetic */ void m111lambda$new$3$comgooglefirebasemessagingFirebaseMessaging() {
        ProxyNotificationInitializer.initialize(this.context);
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.isEnabled();
    }

    public void setAutoInitEnabled(boolean enable) {
        this.autoInit.setEnabled(enable);
    }

    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
    }

    public void setDeliveryMetricsExportToBigQuery(boolean enable) {
        MessagingAnalytics.setDeliveryMetricsExportToBigQuery(enable);
    }

    public boolean isNotificationDelegationEnabled() {
        return ProxyNotificationInitializer.isProxyNotificationEnabled(this.context);
    }

    public Task<Void> setNotificationDelegationEnabled(boolean enable) {
        return ProxyNotificationInitializer.setEnableProxyNotification(this.initExecutor, this.context, enable);
    }

    public Task<String> getToken() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.getTokenTask();
        }
        final TaskCompletionSource<String> taskCompletionSource = new TaskCompletionSource<>();
        this.initExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.m107x6bb67082(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getToken$4$com-google-firebase-messaging-FirebaseMessaging  reason: not valid java name */
    public /* synthetic */ void m107x6bb67082(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingGetToken());
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    public Task<Void> deleteToken() {
        if (this.iid != null) {
            final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
            this.initExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseMessaging.this.m105xd6d6bd74(taskCompletionSource);
                }
            });
            return taskCompletionSource.getTask();
        }
        Store.Token token = getTokenWithoutTriggeringSync();
        if (token == null) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource<Void> taskCompletionSource2 = new TaskCompletionSource<>();
        ExecutorService executorService = FcmExecutors.newNetworkIOExecutor();
        executorService.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.m106xd6605775(taskCompletionSource2);
            }
        });
        return taskCompletionSource2.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$deleteToken$5$com-google-firebase-messaging-FirebaseMessaging  reason: not valid java name */
    public /* synthetic */ void m105xd6d6bd74(TaskCompletionSource taskCompletionSource) {
        try {
            this.iid.deleteToken(Metadata.getDefaultSenderId(this.firebaseApp), INSTANCE_ID_SCOPE);
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$deleteToken$6$com-google-firebase-messaging-FirebaseMessaging  reason: not valid java name */
    public /* synthetic */ void m106xd6605775(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(this.gmsRpc.deleteToken());
            getStore(this.context).deleteToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    public Task<Void> subscribeToTopic(final String topic) {
        return this.topicsSubscriberTask.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task subscribeToTopic;
                subscribeToTopic = ((TopicsSubscriber) obj).subscribeToTopic(topic);
                return subscribeToTopic;
            }
        });
    }

    public Task<Void> unsubscribeFromTopic(final String topic) {
        return this.topicsSubscriberTask.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task unsubscribeFromTopic;
                unsubscribeFromTopic = ((TopicsSubscriber) obj).unsubscribeFromTopic(topic);
                return unsubscribeFromTopic;
            }
        });
    }

    @Deprecated
    public void send(RemoteMessage message) {
        if (TextUtils.isEmpty(message.getTo())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent(SEND_INTENT_ACTION);
        Intent dummyIntent = new Intent();
        dummyIntent.setPackage("com.google.example.invalidpackage");
        intent.putExtra(EXTRA_DUMMY_P_INTENT, PendingIntent.getBroadcast(this.context, 0, dummyIntent, Build.VERSION.SDK_INT >= 23 ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 0));
        intent.setPackage("com.google.android.gms");
        message.populateSendMessageIntent(intent);
        this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    Task<TopicsSubscriber> getTopicsSubscriberTask() {
        return this.topicsSubscriberTask;
    }

    public static TransportFactory getTransportFactory() {
        return transportFactory;
    }

    static void clearTransportFactoryForTest() {
        transportFactory = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isGmsCorePresent() {
        return this.metadata.isGmscorePresent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getApplicationContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean value) {
        this.syncScheduledOrRunning = value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void syncWithDelaySecondsInternal(long delaySeconds) {
        long retryDelaySeconds = Math.min(Math.max((long) MIN_DELAY_SEC, 2 * delaySeconds), MAX_DELAY_SEC);
        SyncTask syncTask = new SyncTask(this, retryDelaySeconds);
        enqueueTaskWithDelaySeconds(syncTask, delaySeconds);
        this.syncScheduledOrRunning = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueueTaskWithDelaySeconds(Runnable task, long delaySeconds) {
        synchronized (FirebaseMessaging.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            syncExecutor.schedule(task, delaySeconds, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSyncIfNecessary() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.getToken();
            return;
        }
        Store.Token token = getTokenWithoutTriggeringSync();
        if (tokenNeedsRefresh(token)) {
            startSync();
        }
    }

    private synchronized void startSync() {
        if (!this.syncScheduledOrRunning) {
            syncWithDelaySecondsInternal(0L);
        }
    }

    Store.Token getTokenWithoutTriggeringSync() {
        return getStore(this.context).getToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String blockingGetToken() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e) {
                throw new IOException(e);
            }
        }
        final Store.Token cachedToken = getTokenWithoutTriggeringSync();
        if (!tokenNeedsRefresh(cachedToken)) {
            return cachedToken.token;
        }
        final String senderId = Metadata.getDefaultSenderId(this.firebaseApp);
        Task<String> tokenTask = this.requestDeduplicator.getOrStartGetTokenRequest(senderId, new RequestDeduplicator.GetTokenRequest() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda7
            @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
            public final Task start() {
                return FirebaseMessaging.this.m103xb9ac49c0(senderId, cachedToken);
            }
        });
        try {
            return (String) Tasks.await(tokenTask);
        } catch (InterruptedException | ExecutionException e2) {
            throw new IOException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$blockingGetToken$10$com-google-firebase-messaging-FirebaseMessaging  reason: not valid java name */
    public /* synthetic */ Task m103xb9ac49c0(final String senderId, final Store.Token cachedToken) {
        return this.gmsRpc.getToken().onSuccessTask(this.fileExecutor, new SuccessContinuation() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return FirebaseMessaging.this.m104xa77f119c(senderId, cachedToken, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$blockingGetToken$9$com-google-firebase-messaging-FirebaseMessaging  reason: not valid java name */
    public /* synthetic */ Task m104xa77f119c(String senderId, Store.Token cachedToken, String token) throws Exception {
        getStore(this.context).saveToken(getSubtype(), senderId, token, this.metadata.getAppVersionCode());
        if (cachedToken == null || !token.equals(cachedToken.token)) {
            m108lambda$new$0$comgooglefirebasemessagingFirebaseMessaging(token);
        }
        return Tasks.forResult(token);
    }

    private String getSubtype() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            return "";
        }
        return this.firebaseApp.getPersistenceKey();
    }

    boolean tokenNeedsRefresh(Store.Token token) {
        return token == null || token.needsRefresh(this.metadata.getAppVersionCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeOnTokenRefresh */
    public void m108lambda$new$0$comgooglefirebasemessagingFirebaseMessaging(String token) {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.firebaseApp.getName());
            }
            Intent messagingIntent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            messagingIntent.putExtra("token", token);
            new FcmBroadcastProcessor(this.context).process(messagingIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AutoInit {
        private static final String AUTO_INIT_PREF = "auto_init";
        private static final String FCM_PREFERENCES = "com.google.firebase.messaging";
        private static final String MANIFEST_METADATA_AUTO_INIT_ENABLED = "firebase_messaging_auto_init_enabled";
        private Boolean autoInitEnabled;
        private EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        private boolean initialized;
        private final Subscriber subscriber;

        AutoInit(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        synchronized void initialize() {
            if (this.initialized) {
                return;
            }
            Boolean readEnabled = readEnabled();
            this.autoInitEnabled = readEnabled;
            if (readEnabled == null) {
                EventHandler<DataCollectionDefaultChange> eventHandler = new EventHandler() { // from class: com.google.firebase.messaging.FirebaseMessaging$AutoInit$$ExternalSyntheticLambda0
                    @Override // com.google.firebase.events.EventHandler
                    public final void handle(Event event) {
                        FirebaseMessaging.AutoInit.this.m112x1061f0b8(event);
                    }
                };
                this.dataCollectionDefaultChangeEventHandler = eventHandler;
                this.subscriber.subscribe(DataCollectionDefaultChange.class, eventHandler);
            }
            this.initialized = true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$initialize$0$com-google-firebase-messaging-FirebaseMessaging$AutoInit  reason: not valid java name */
        public /* synthetic */ void m112x1061f0b8(Event event) {
            if (isEnabled()) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
        }

        synchronized boolean isEnabled() {
            boolean isDataCollectionDefaultEnabled;
            initialize();
            Boolean bool = this.autoInitEnabled;
            if (bool == null) {
                isDataCollectionDefaultEnabled = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
            } else {
                isDataCollectionDefaultEnabled = bool.booleanValue();
            }
            return isDataCollectionDefaultEnabled;
        }

        synchronized void setEnabled(boolean enable) {
            initialize();
            EventHandler<DataCollectionDefaultChange> eventHandler = this.dataCollectionDefaultChangeEventHandler;
            if (eventHandler != null) {
                this.subscriber.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                this.dataCollectionDefaultChangeEventHandler = null;
            }
            SharedPreferences.Editor preferencesEditor = FirebaseMessaging.this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            preferencesEditor.putBoolean(AUTO_INIT_PREF, enable);
            preferencesEditor.apply();
            if (enable) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
            this.autoInitEnabled = Boolean.valueOf(enable);
        }

        private Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            Context applicationContext = FirebaseMessaging.this.firebaseApp.getApplicationContext();
            SharedPreferences preferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (preferences.contains(AUTO_INIT_PREF)) {
                return Boolean.valueOf(preferences.getBoolean(AUTO_INIT_PREF, false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey(MANIFEST_METADATA_AUTO_INIT_ENABLED)) {
                    return Boolean.valueOf(applicationInfo.metaData.getBoolean(MANIFEST_METADATA_AUTO_INIT_ENABLED));
                }
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        }
    }
}
