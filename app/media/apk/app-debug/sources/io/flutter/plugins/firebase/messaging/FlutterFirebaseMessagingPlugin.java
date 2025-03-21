package io.flutter.plugins.firebase.messaging;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.messaging.FlutterFirebasePermissionManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public class FlutterFirebaseMessagingPlugin implements FlutterFirebasePlugin, MethodChannel.MethodCallHandler, PluginRegistry.NewIntentListener, FlutterPlugin, ActivityAware {
    private MethodChannel channel;
    private RemoteMessage initialMessage;
    private Map<String, Object> initialMessageNotification;
    private Activity mainActivity;
    FlutterFirebasePermissionManager permissionManager;
    private Observer<RemoteMessage> remoteMessageObserver;
    private Observer<String> tokenObserver;
    private final HashMap<String, Boolean> consumedInitialMessages = new HashMap<>();
    private final LiveData<RemoteMessage> liveDataRemoteMessage = FlutterFirebaseRemoteMessageLiveData.getInstance();
    private final LiveData<String> liveDataToken = FlutterFirebaseTokenLiveData.getInstance();

    private void initInstance(BinaryMessenger messenger) {
        MethodChannel methodChannel = new MethodChannel(messenger, "plugins.flutter.io/firebase_messaging");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.permissionManager = new FlutterFirebasePermissionManager();
        this.remoteMessageObserver = new Observer() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlutterFirebaseMessagingPlugin.this.m151x60a054b4((RemoteMessage) obj);
            }
        };
        this.tokenObserver = new Observer() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlutterFirebaseMessagingPlugin.this.m152x9980b553((String) obj);
            }
        };
        this.liveDataRemoteMessage.observeForever(this.remoteMessageObserver);
        this.liveDataToken.observeForever(this.tokenObserver);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_messaging", this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initInstance$0$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin  reason: not valid java name */
    public /* synthetic */ void m151x60a054b4(RemoteMessage remoteMessage) {
        Map<String, Object> content = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage);
        this.channel.invokeMethod("Messaging#onMessage", content);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initInstance$1$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin  reason: not valid java name */
    public /* synthetic */ void m152x9980b553(String token) {
        this.channel.invokeMethod("Messaging#onTokenRefresh", token);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        initInstance(binding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.liveDataToken.removeObserver(this.tokenObserver);
        this.liveDataRemoteMessage.removeObserver(this.remoteMessageObserver);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        binding.addOnNewIntentListener(this);
        binding.addRequestPermissionsResultListener(this.permissionManager);
        Activity activity = binding.getActivity();
        this.mainActivity = activity;
        if (activity.getIntent() != null && this.mainActivity.getIntent().getExtras() != null && (this.mainActivity.getIntent().getFlags() & 1048576) != 1048576) {
            onNewIntent(this.mainActivity.getIntent());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        binding.addOnNewIntentListener(this);
        this.mainActivity = binding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.mainActivity = null;
    }

    private Task<Void> deleteToken() {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$deleteToken$2(TaskCompletionSource.this);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$deleteToken$2(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(FirebaseMessaging.getInstance().deleteToken());
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Map<String, Object>> getToken() {
        final TaskCompletionSource<Map<String, Object>> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.this.m150x3d7973d3(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getToken$3$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin  reason: not valid java name */
    public /* synthetic */ void m150x3d7973d3(TaskCompletionSource taskCompletionSource) {
        try {
            String token = (String) Tasks.await(FirebaseMessaging.getInstance().getToken());
            taskCompletionSource.setResult(new HashMap<String, Object>(token) { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin.1
                final /* synthetic */ String val$token;

                {
                    this.val$token = token;
                    put("token", token);
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> subscribeToTopic(final Map<String, Object> arguments) {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$subscribeToTopic$4(arguments, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$subscribeToTopic$4(Map arguments, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessaging = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(arguments);
            String topic = (String) Objects.requireNonNull(arguments.get("topic"));
            Tasks.await(firebaseMessaging.subscribeToTopic(topic));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> unsubscribeFromTopic(final Map<String, Object> arguments) {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$unsubscribeFromTopic$5(arguments, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$unsubscribeFromTopic$5(Map arguments, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessaging = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(arguments);
            String topic = (String) Objects.requireNonNull(arguments.get("topic"));
            Tasks.await(firebaseMessaging.unsubscribeFromTopic(topic));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> sendMessage(final Map<String, Object> arguments) {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$sendMessage$6(arguments, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$sendMessage$6(Map arguments, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessaging = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(arguments);
            RemoteMessage remoteMessage = FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(arguments);
            firebaseMessaging.send(remoteMessage);
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Map<String, Object>> setAutoInitEnabled(final Map<String, Object> arguments) {
        final TaskCompletionSource<Map<String, Object>> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.this.m155x1419fe12(arguments, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setAutoInitEnabled$7$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin  reason: not valid java name */
    public /* synthetic */ void m155x1419fe12(Map arguments, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessaging = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(arguments);
            Boolean enabled = (Boolean) Objects.requireNonNull(arguments.get("enabled"));
            firebaseMessaging.setAutoInitEnabled(enabled.booleanValue());
            taskCompletionSource.setResult(new HashMap<String, Object>(firebaseMessaging) { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin.2
                final /* synthetic */ FirebaseMessaging val$firebaseMessaging;

                {
                    this.val$firebaseMessaging = firebaseMessaging;
                    put("isAutoInitEnabled", Boolean.valueOf(firebaseMessaging.isAutoInitEnabled()));
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> setDeliveryMetricsExportToBigQuery(final Map<String, Object> arguments) {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$setDeliveryMetricsExportToBigQuery$8(arguments, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setDeliveryMetricsExportToBigQuery$8(Map arguments, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessaging = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(arguments);
            Boolean enabled = (Boolean) Objects.requireNonNull(arguments.get("enabled"));
            firebaseMessaging.setDeliveryMetricsExportToBigQuery(enabled.booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Map<String, Object>> getInitialMessage() {
        final TaskCompletionSource<Map<String, Object>> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.this.m148x6a1ec711(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getInitialMessage$9$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin  reason: not valid java name */
    public /* synthetic */ void m148x6a1ec711(TaskCompletionSource taskCompletionSource) {
        try {
            RemoteMessage remoteMessage = this.initialMessage;
            if (remoteMessage != null) {
                Map<String, Object> remoteMessageMap = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage);
                Map<String, Object> map = this.initialMessageNotification;
                if (map != null) {
                    remoteMessageMap.put("notification", map);
                }
                taskCompletionSource.setResult(remoteMessageMap);
                this.initialMessage = null;
                this.initialMessageNotification = null;
                return;
            }
            Activity activity = this.mainActivity;
            if (activity == null) {
                taskCompletionSource.setResult(null);
                return;
            }
            Intent intent = activity.getIntent();
            if (intent != null && intent.getExtras() != null) {
                String messageId = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
                if (messageId == null) {
                    messageId = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
                }
                if (messageId != null && this.consumedInitialMessages.get(messageId) == null) {
                    RemoteMessage remoteMessage2 = FlutterFirebaseMessagingReceiver.notifications.get(messageId);
                    Map<String, Object> notificationMap = null;
                    if (remoteMessage2 == null) {
                        Map<String, Object> messageMap = FlutterFirebaseMessagingStore.getInstance().getFirebaseMessageMap(messageId);
                        if (messageMap != null) {
                            remoteMessage2 = FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(messageMap);
                            if (messageMap.get("notification") != null) {
                                notificationMap = uncheckedCastToMap(messageMap.get("notification"));
                            }
                        }
                        FlutterFirebaseMessagingStore.getInstance().removeFirebaseMessage(messageId);
                    }
                    if (remoteMessage2 == null) {
                        taskCompletionSource.setResult(null);
                        return;
                    }
                    this.consumedInitialMessages.put(messageId, true);
                    Map<String, Object> remoteMessageMap2 = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage2);
                    if (remoteMessage2.getNotification() == null && notificationMap != null) {
                        remoteMessageMap2.put("notification", notificationMap);
                    }
                    taskCompletionSource.setResult(remoteMessageMap2);
                    return;
                }
                taskCompletionSource.setResult(null);
                return;
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Map<String, Integer>> requestPermissions() {
        final TaskCompletionSource<Map<String, Integer>> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.this.m154x7111fdcf(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$requestPermissions$12$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin  reason: not valid java name */
    public /* synthetic */ void m154x7111fdcf(final TaskCompletionSource taskCompletionSource) {
        final HashMap hashMap = new HashMap();
        try {
            boolean areNotificationsEnabled = checkPermissions().booleanValue();
            if (!areNotificationsEnabled) {
                this.permissionManager.requestPermissions(this.mainActivity, new FlutterFirebasePermissionManager.RequestPermissionsSuccessCallback() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda9
                    @Override // io.flutter.plugins.firebase.messaging.FlutterFirebasePermissionManager.RequestPermissionsSuccessCallback
                    public final void onSuccess(int i) {
                        FlutterFirebaseMessagingPlugin.lambda$requestPermissions$10(hashMap, taskCompletionSource, i);
                    }
                }, new ErrorCallback() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda10
                    @Override // io.flutter.plugins.firebase.messaging.ErrorCallback
                    public final void onError(String str) {
                        TaskCompletionSource.this.setException(new Exception(str));
                    }
                });
            } else {
                hashMap.put("authorizationStatus", 1);
                taskCompletionSource.setResult(hashMap);
            }
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$requestPermissions$10(Map permissions, TaskCompletionSource taskCompletionSource, int notificationsEnabled) {
        permissions.put("authorizationStatus", Integer.valueOf(notificationsEnabled));
        taskCompletionSource.setResult(permissions);
    }

    private Boolean checkPermissions() {
        return Boolean.valueOf(ContextHolder.getApplicationContext().checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0);
    }

    private Task<Map<String, Integer>> getPermissions() {
        final TaskCompletionSource<Map<String, Integer>> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.this.m149x6f4ba4c7(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getPermissions$13$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin  reason: not valid java name */
    public /* synthetic */ void m149x6f4ba4c7(TaskCompletionSource taskCompletionSource) {
        boolean areNotificationsEnabled;
        try {
            HashMap hashMap = new HashMap();
            if (Build.VERSION.SDK_INT >= 33) {
                areNotificationsEnabled = checkPermissions().booleanValue();
            } else {
                areNotificationsEnabled = NotificationManagerCompat.from(this.mainActivity).areNotificationsEnabled();
            }
            hashMap.put("authorizationStatus", Integer.valueOf(areNotificationsEnabled ? 1 : 0));
            taskCompletionSource.setResult(hashMap);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, final MethodChannel.Result result) {
        char c;
        long pluginCallbackHandle;
        long userCallbackHandle;
        Task<?> methodCallTask;
        String str = call.method;
        switch (str.hashCode()) {
            case -1704007366:
                if (str.equals("Messaging#getInitialMessage")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1661255137:
                if (str.equals("Messaging#setAutoInitEnabled")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -657665041:
                if (str.equals("Messaging#deleteToken")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 421314579:
                if (str.equals("Messaging#unsubscribeFromTopic")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 506322569:
                if (str.equals("Messaging#subscribeToTopic")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 607887267:
                if (str.equals("Messaging#setDeliveryMetricsExportToBigQuery")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 928431066:
                if (str.equals("Messaging#startBackgroundIsolate")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1165917248:
                if (str.equals("Messaging#sendMessage")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1231338975:
                if (str.equals("Messaging#requestPermission")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1243856389:
                if (str.equals("Messaging#getNotificationSettings")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1459336962:
                if (str.equals("Messaging#getToken")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                Map<String, Object> arguments = (Map) call.arguments;
                Object arg1 = arguments.get("pluginCallbackHandle");
                Object arg2 = arguments.get("userCallbackHandle");
                if (arg1 instanceof Long) {
                    pluginCallbackHandle = ((Long) arg1).longValue();
                } else if (arg1 instanceof Integer) {
                    pluginCallbackHandle = Long.valueOf(((Integer) arg1).intValue()).longValue();
                } else {
                    throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'pluginCallbackHandle'.");
                }
                if (arg2 instanceof Long) {
                    userCallbackHandle = ((Long) arg2).longValue();
                } else if (arg2 instanceof Integer) {
                    userCallbackHandle = Long.valueOf(((Integer) arg2).intValue()).longValue();
                } else {
                    throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'userCallbackHandle'.");
                }
                FlutterShellArgs shellArgs = null;
                Activity activity = this.mainActivity;
                if (activity != null) {
                    shellArgs = FlutterShellArgs.fromIntent(activity.getIntent());
                }
                FlutterFirebaseMessagingBackgroundService.setCallbackDispatcher(pluginCallbackHandle);
                FlutterFirebaseMessagingBackgroundService.setUserCallbackHandle(userCallbackHandle);
                FlutterFirebaseMessagingBackgroundService.startBackgroundIsolate(pluginCallbackHandle, shellArgs);
                Task<?> methodCallTask2 = Tasks.forResult(null);
                methodCallTask = methodCallTask2;
                break;
            case 1:
                methodCallTask = getInitialMessage();
                break;
            case 2:
                methodCallTask = deleteToken();
                break;
            case 3:
                methodCallTask = getToken();
                break;
            case 4:
                methodCallTask = subscribeToTopic((Map) call.arguments());
                break;
            case 5:
                methodCallTask = unsubscribeFromTopic((Map) call.arguments());
                break;
            case 6:
                methodCallTask = sendMessage((Map) call.arguments());
                break;
            case 7:
                methodCallTask = setAutoInitEnabled((Map) call.arguments());
                break;
            case '\b':
                methodCallTask = setDeliveryMetricsExportToBigQuery((Map) call.arguments());
                break;
            case '\t':
                if (Build.VERSION.SDK_INT >= 33) {
                    methodCallTask = requestPermissions();
                    break;
                } else {
                    methodCallTask = getPermissions();
                    break;
                }
            case '\n':
                methodCallTask = getPermissions();
                break;
            default:
                result.notImplemented();
                return;
        }
        methodCallTask.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda13
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseMessagingPlugin.this.m153xbbae7b76(result, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onMethodCall$14$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingPlugin  reason: not valid java name */
    public /* synthetic */ void m153xbbae7b76(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        Exception exception = task.getException();
        result.error("firebase_messaging", exception != null ? exception.getMessage() : null, getExceptionDetails(exception));
    }

    private Map<String, Object> getExceptionDetails(Exception exception) {
        Map<String, Object> details = new HashMap<>();
        details.put("code", EnvironmentCompat.MEDIA_UNKNOWN);
        if (exception != null) {
            details.put("message", exception.getMessage());
        } else {
            details.put("message", "An unknown error has occurred.");
        }
        return details;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        Map<String, Object> map;
        Map<String, Object> messageMap;
        if (intent.getExtras() == null) {
            return false;
        }
        String messageId = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
        if (messageId == null) {
            messageId = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
        }
        if (messageId == null) {
            return false;
        }
        RemoteMessage remoteMessage = FlutterFirebaseMessagingReceiver.notifications.get(messageId);
        Map<String, Object> notificationMap = null;
        if (remoteMessage == null && (messageMap = FlutterFirebaseMessagingStore.getInstance().getFirebaseMessageMap(messageId)) != null) {
            remoteMessage = FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(messageMap);
            notificationMap = FlutterFirebaseMessagingUtils.getRemoteMessageNotificationForArguments(messageMap);
        }
        if (remoteMessage == null) {
            return false;
        }
        this.initialMessage = remoteMessage;
        this.initialMessageNotification = notificationMap;
        FlutterFirebaseMessagingReceiver.notifications.remove(messageId);
        Map<String, Object> message = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage);
        if (remoteMessage.getNotification() == null && (map = this.initialMessageNotification) != null) {
            message.put("notification", map);
        }
        this.channel.invokeMethod("Messaging#onMessageOpenedApp", message);
        this.mainActivity.setIntent(intent);
        return true;
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(final FirebaseApp firebaseApp) {
        final TaskCompletionSource<Map<String, Object>> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.lambda$getPluginConstantsForFirebaseApp$15(FirebaseApp.this, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getPluginConstantsForFirebaseApp$15(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        try {
            HashMap hashMap = new HashMap();
            if (firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
                hashMap.put("AUTO_INIT_ENABLED", Boolean.valueOf(firebaseMessaging.isAutoInitEnabled()));
            }
            taskCompletionSource.setResult(hashMap);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                TaskCompletionSource.this.setResult(null);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Map<String, Object> uncheckedCastToMap(Object obj) {
        Map<String, Object> result = (Map) obj;
        return result;
    }
}
