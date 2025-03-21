package io.flutter.plugins.firebase.core;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class FlutterFirebaseCorePlugin implements FlutterPlugin, GeneratedAndroidFirebaseCore.FirebaseCoreHostApi, GeneratedAndroidFirebaseCore.FirebaseAppHostApi {
    public static Map<String, String> customAuthDomain = new HashMap();
    private Context applicationContext;
    private boolean coreInitialized = false;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.setup(binding.getBinaryMessenger(), this);
        GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.setup(binding.getBinaryMessenger(), this);
        this.applicationContext = binding.getApplicationContext();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.applicationContext = null;
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.setup(binding.getBinaryMessenger(), null);
        GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.setup(binding.getBinaryMessenger(), null);
    }

    private GeneratedAndroidFirebaseCore.PigeonFirebaseOptions firebaseOptionsToMap(FirebaseOptions options) {
        GeneratedAndroidFirebaseCore.PigeonFirebaseOptions.Builder firebaseOptions = new GeneratedAndroidFirebaseCore.PigeonFirebaseOptions.Builder();
        firebaseOptions.setApiKey(options.getApiKey());
        firebaseOptions.setAppId(options.getApplicationId());
        if (options.getGcmSenderId() != null) {
            firebaseOptions.setMessagingSenderId(options.getGcmSenderId());
        }
        if (options.getProjectId() != null) {
            firebaseOptions.setProjectId(options.getProjectId());
        }
        firebaseOptions.setDatabaseURL(options.getDatabaseUrl());
        firebaseOptions.setStorageBucket(options.getStorageBucket());
        firebaseOptions.setTrackingId(options.getGaTrackingId());
        return firebaseOptions.build();
    }

    private Task<GeneratedAndroidFirebaseCore.PigeonInitializeResponse> firebaseAppToMap(final FirebaseApp firebaseApp) {
        final TaskCompletionSource<GeneratedAndroidFirebaseCore.PigeonInitializeResponse> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseCorePlugin.this.m142x5526557c(firebaseApp, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$firebaseAppToMap$0$io-flutter-plugins-firebase-core-FlutterFirebaseCorePlugin  reason: not valid java name */
    public /* synthetic */ void m142x5526557c(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        try {
            GeneratedAndroidFirebaseCore.PigeonInitializeResponse.Builder initializeResponse = new GeneratedAndroidFirebaseCore.PigeonInitializeResponse.Builder();
            initializeResponse.setName(firebaseApp.getName());
            initializeResponse.setOptions(firebaseOptionsToMap(firebaseApp.getOptions()));
            initializeResponse.setIsAutomaticDataCollectionEnabled(Boolean.valueOf(firebaseApp.isDataCollectionDefaultEnabled()));
            initializeResponse.setPluginConstants((Map) Tasks.await(FlutterFirebasePluginRegistry.getPluginConstantsForFirebaseApp(firebaseApp)));
            taskCompletionSource.setResult(initializeResponse.build());
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private <T> void listenToResponse(TaskCompletionSource<T> taskCompletionSource, final GeneratedAndroidFirebaseCore.Result<T> result) {
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseCorePlugin.lambda$listenToResponse$1(GeneratedAndroidFirebaseCore.Result.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$listenToResponse$1(GeneratedAndroidFirebaseCore.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        Exception exception = task.getException();
        result.error(exception);
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi
    public void initializeApp(final String appName, final GeneratedAndroidFirebaseCore.PigeonFirebaseOptions initializeAppRequest, GeneratedAndroidFirebaseCore.Result<GeneratedAndroidFirebaseCore.PigeonInitializeResponse> result) {
        final TaskCompletionSource<GeneratedAndroidFirebaseCore.PigeonInitializeResponse> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseCorePlugin.this.m143xc7a7cd8a(initializeAppRequest, appName, taskCompletionSource);
            }
        });
        listenToResponse(taskCompletionSource, result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initializeApp$2$io-flutter-plugins-firebase-core-FlutterFirebaseCorePlugin  reason: not valid java name */
    public /* synthetic */ void m143xc7a7cd8a(GeneratedAndroidFirebaseCore.PigeonFirebaseOptions initializeAppRequest, String appName, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder().setApiKey(initializeAppRequest.getApiKey()).setApplicationId(initializeAppRequest.getAppId()).setDatabaseUrl(initializeAppRequest.getDatabaseURL()).setGcmSenderId(initializeAppRequest.getMessagingSenderId()).setProjectId(initializeAppRequest.getProjectId()).setStorageBucket(initializeAppRequest.getStorageBucket()).setGaTrackingId(initializeAppRequest.getTrackingId()).build();
            try {
                Looper.prepare();
            } catch (Exception e) {
            }
            if (initializeAppRequest.getAuthDomain() != null) {
                customAuthDomain.put(appName, initializeAppRequest.getAuthDomain());
            }
            FirebaseApp firebaseApp = FirebaseApp.initializeApp(this.applicationContext, options, appName);
            taskCompletionSource.setResult((GeneratedAndroidFirebaseCore.PigeonInitializeResponse) Tasks.await(firebaseAppToMap(firebaseApp)));
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi
    public void initializeCore(GeneratedAndroidFirebaseCore.Result<List<GeneratedAndroidFirebaseCore.PigeonInitializeResponse>> result) {
        final TaskCompletionSource<List<GeneratedAndroidFirebaseCore.PigeonInitializeResponse>> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseCorePlugin.this.m144x57de4071(taskCompletionSource);
            }
        });
        listenToResponse(taskCompletionSource, result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initializeCore$3$io-flutter-plugins-firebase-core-FlutterFirebaseCorePlugin  reason: not valid java name */
    public /* synthetic */ void m144x57de4071(TaskCompletionSource taskCompletionSource) {
        try {
            if (!this.coreInitialized) {
                this.coreInitialized = true;
            } else {
                Tasks.await(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
            }
            List<FirebaseApp> firebaseApps = FirebaseApp.getApps(this.applicationContext);
            ArrayList arrayList = new ArrayList(firebaseApps.size());
            for (FirebaseApp firebaseApp : firebaseApps) {
                arrayList.add((GeneratedAndroidFirebaseCore.PigeonInitializeResponse) Tasks.await(firebaseAppToMap(firebaseApp)));
            }
            taskCompletionSource.setResult(arrayList);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi
    public void optionsFromResource(GeneratedAndroidFirebaseCore.Result<GeneratedAndroidFirebaseCore.PigeonFirebaseOptions> result) {
        final TaskCompletionSource<GeneratedAndroidFirebaseCore.PigeonFirebaseOptions> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseCorePlugin.this.m145x1f536d83(taskCompletionSource);
            }
        });
        listenToResponse(taskCompletionSource, result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$optionsFromResource$4$io-flutter-plugins-firebase-core-FlutterFirebaseCorePlugin  reason: not valid java name */
    public /* synthetic */ void m145x1f536d83(TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseOptions options = FirebaseOptions.fromResource(this.applicationContext);
            if (options == null) {
                taskCompletionSource.setException(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
            } else {
                taskCompletionSource.setResult(firebaseOptionsToMap(options));
            }
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi
    public void setAutomaticDataCollectionEnabled(final String appName, final Boolean enabled, GeneratedAndroidFirebaseCore.Result<Void> result) {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseCorePlugin.lambda$setAutomaticDataCollectionEnabled$5(appName, enabled, taskCompletionSource);
            }
        });
        listenToResponse(taskCompletionSource, result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setAutomaticDataCollectionEnabled$5(String appName, Boolean enabled, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseApp firebaseApp = FirebaseApp.getInstance(appName);
            firebaseApp.setDataCollectionDefaultEnabled(enabled);
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi
    public void setAutomaticResourceManagementEnabled(final String appName, final Boolean enabled, GeneratedAndroidFirebaseCore.Result<Void> result) {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseCorePlugin.lambda$setAutomaticResourceManagementEnabled$6(appName, enabled, taskCompletionSource);
            }
        });
        listenToResponse(taskCompletionSource, result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setAutomaticResourceManagementEnabled$6(String appName, Boolean enabled, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseApp firebaseApp = FirebaseApp.getInstance(appName);
            firebaseApp.setAutomaticResourceManagementEnabled(enabled.booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi
    public void delete(final String appName, GeneratedAndroidFirebaseCore.Result<Void> result) {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseCorePlugin.lambda$delete$7(appName, taskCompletionSource);
            }
        });
        listenToResponse(taskCompletionSource, result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$delete$7(String appName, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseApp firebaseApp = FirebaseApp.getInstance(appName);
            try {
                firebaseApp.delete();
            } catch (IllegalStateException e) {
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }
}
