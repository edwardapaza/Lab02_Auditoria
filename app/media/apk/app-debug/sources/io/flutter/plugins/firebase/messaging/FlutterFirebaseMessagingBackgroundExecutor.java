package io.flutter.plugins.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.RemoteMessage;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.FlutterCallbackInformation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class FlutterFirebaseMessagingBackgroundExecutor implements MethodChannel.MethodCallHandler {
    private static final String CALLBACK_HANDLE_KEY = "callback_handle";
    private static final String TAG = "FLTFireBGExecutor";
    private static final String USER_CALLBACK_HANDLE_KEY = "user_callback_handle";
    private MethodChannel backgroundChannel;
    private FlutterEngine backgroundFlutterEngine;
    private final AtomicBoolean isCallbackDispatcherReady = new AtomicBoolean(false);

    public static void setCallbackDispatcher(long callbackHandle) {
        Context context = ContextHolder.getApplicationContext();
        SharedPreferences prefs = context.getSharedPreferences("io.flutter.firebase.messaging.callback", 0);
        prefs.edit().putLong(CALLBACK_HANDLE_KEY, callbackHandle).apply();
    }

    public boolean isNotRunning() {
        return !this.isCallbackDispatcherReady.get();
    }

    private void onInitialized() {
        this.isCallbackDispatcherReady.set(true);
        FlutterFirebaseMessagingBackgroundService.onInitialized();
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        String method = call.method;
        try {
            if (method.equals("MessagingBackground#initialized")) {
                onInitialized();
                result.success(true);
            } else {
                result.notImplemented();
            }
        } catch (PluginRegistrantException e) {
            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Flutter FCM error: " + e.getMessage(), null);
        }
    }

    public void startBackgroundIsolate() {
        if (isNotRunning()) {
            long callbackHandle = getPluginCallbackHandle();
            if (callbackHandle != 0) {
                startBackgroundIsolate(callbackHandle, null);
            }
        }
    }

    public void startBackgroundIsolate(final long callbackHandle, final FlutterShellArgs shellArgs) {
        if (this.backgroundFlutterEngine != null) {
            Log.e(TAG, "Background isolate already started.");
            return;
        }
        final FlutterLoader loader = new FlutterLoader();
        final Handler mainHandler = new Handler(Looper.getMainLooper());
        Runnable myRunnable = new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundExecutor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingBackgroundExecutor.this.m147x4717c52b(loader, mainHandler, shellArgs, callbackHandle);
            }
        };
        mainHandler.post(myRunnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startBackgroundIsolate$1$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingBackgroundExecutor  reason: not valid java name */
    public /* synthetic */ void m147x4717c52b(final FlutterLoader loader, Handler mainHandler, final FlutterShellArgs shellArgs, final long callbackHandle) {
        loader.startInitialization(ContextHolder.getApplicationContext());
        loader.ensureInitializationCompleteAsync(ContextHolder.getApplicationContext(), null, mainHandler, new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundExecutor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingBackgroundExecutor.this.m146x18665b0c(loader, shellArgs, callbackHandle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startBackgroundIsolate$0$io-flutter-plugins-firebase-messaging-FlutterFirebaseMessagingBackgroundExecutor  reason: not valid java name */
    public /* synthetic */ void m146x18665b0c(FlutterLoader loader, FlutterShellArgs shellArgs, long callbackHandle) {
        String appBundlePath = loader.findAppBundlePath();
        AssetManager assets = ContextHolder.getApplicationContext().getAssets();
        if (isNotRunning()) {
            if (shellArgs == null) {
                Log.i(TAG, "Creating background FlutterEngine instance.");
                this.backgroundFlutterEngine = new FlutterEngine(ContextHolder.getApplicationContext());
            } else {
                Log.i(TAG, "Creating background FlutterEngine instance, with args: " + Arrays.toString(shellArgs.toArray()));
                this.backgroundFlutterEngine = new FlutterEngine(ContextHolder.getApplicationContext(), shellArgs.toArray());
            }
            FlutterCallbackInformation flutterCallback = FlutterCallbackInformation.lookupCallbackInformation(callbackHandle);
            DartExecutor executor = this.backgroundFlutterEngine.getDartExecutor();
            initializeMethodChannel(executor);
            DartExecutor.DartCallback dartCallback = new DartExecutor.DartCallback(assets, appBundlePath, flutterCallback);
            executor.executeDartCallback(dartCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDartBackgroundHandlerRegistered() {
        return getPluginCallbackHandle() != 0;
    }

    public void executeDartCallbackInBackgroundIsolate(Intent intent, final CountDownLatch latch) {
        if (this.backgroundFlutterEngine == null) {
            Log.i(TAG, "A background message could not be handled in Dart as no onBackgroundMessage handler has been registered.");
            return;
        }
        MethodChannel.Result result = null;
        if (latch != null) {
            result = new MethodChannel.Result() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundExecutor.1
                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void success(Object result2) {
                    latch.countDown();
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void error(String errorCode, String errorMessage, Object errorDetails) {
                    latch.countDown();
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void notImplemented() {
                    latch.countDown();
                }
            };
        }
        byte[] parcelBytes = intent.getByteArrayExtra("notification");
        if (parcelBytes != null) {
            Parcel parcel = Parcel.obtain();
            try {
                parcel.unmarshall(parcelBytes, 0, parcelBytes.length);
                parcel.setDataPosition(0);
                RemoteMessage remoteMessage = RemoteMessage.CREATOR.createFromParcel(parcel);
                Map<String, Object> remoteMessageMap = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage);
                this.backgroundChannel.invokeMethod("MessagingBackground#onMessage", new HashMap<String, Object>(remoteMessageMap) { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundExecutor.2
                    final /* synthetic */ Map val$remoteMessageMap;

                    {
                        this.val$remoteMessageMap = remoteMessageMap;
                        put("userCallbackHandle", Long.valueOf(FlutterFirebaseMessagingBackgroundExecutor.this.getUserCallbackHandle()));
                        put("message", remoteMessageMap);
                    }
                }, result);
                return;
            } finally {
                parcel.recycle();
            }
        }
        Log.e(TAG, "RemoteMessage byte array not found in Intent.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getUserCallbackHandle() {
        SharedPreferences prefs = ContextHolder.getApplicationContext().getSharedPreferences("io.flutter.firebase.messaging.callback", 0);
        return prefs.getLong(USER_CALLBACK_HANDLE_KEY, 0L);
    }

    public static void setUserCallbackHandle(long callbackHandle) {
        Context context = ContextHolder.getApplicationContext();
        SharedPreferences prefs = context.getSharedPreferences("io.flutter.firebase.messaging.callback", 0);
        prefs.edit().putLong(USER_CALLBACK_HANDLE_KEY, callbackHandle).apply();
    }

    private long getPluginCallbackHandle() {
        SharedPreferences prefs = ContextHolder.getApplicationContext().getSharedPreferences("io.flutter.firebase.messaging.callback", 0);
        return prefs.getLong(CALLBACK_HANDLE_KEY, 0L);
    }

    private void initializeMethodChannel(BinaryMessenger isolate) {
        MethodChannel methodChannel = new MethodChannel(isolate, "plugins.flutter.io/firebase_messaging_background");
        this.backgroundChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }
}
