package io.flutter.plugins.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class FlutterFirebaseMessagingBackgroundService extends JobIntentService {
    private static final String TAG = "FLTFireMsgService";
    private static FlutterFirebaseMessagingBackgroundExecutor flutterBackgroundExecutor;
    private static final List<Intent> messagingQueue = Collections.synchronizedList(new LinkedList());

    @Override // io.flutter.plugins.firebase.messaging.JobIntentService
    public /* bridge */ /* synthetic */ boolean isStopped() {
        return super.isStopped();
    }

    @Override // io.flutter.plugins.firebase.messaging.JobIntentService, android.app.Service
    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override // io.flutter.plugins.firebase.messaging.JobIntentService, android.app.Service
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // io.flutter.plugins.firebase.messaging.JobIntentService, android.app.Service
    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // io.flutter.plugins.firebase.messaging.JobIntentService
    public /* bridge */ /* synthetic */ boolean onStopCurrentWork() {
        return super.onStopCurrentWork();
    }

    public static void enqueueMessageProcessing(Context context, Intent messageIntent, boolean isHighPriority) {
        enqueueWork(context, FlutterFirebaseMessagingBackgroundService.class, 2020, messageIntent, isHighPriority);
    }

    public static void startBackgroundIsolate(long callbackHandle, FlutterShellArgs shellArgs) {
        if (flutterBackgroundExecutor != null) {
            Log.w(TAG, "Attempted to start a duplicate background isolate. Returning...");
            return;
        }
        FlutterFirebaseMessagingBackgroundExecutor flutterFirebaseMessagingBackgroundExecutor = new FlutterFirebaseMessagingBackgroundExecutor();
        flutterBackgroundExecutor = flutterFirebaseMessagingBackgroundExecutor;
        flutterFirebaseMessagingBackgroundExecutor.startBackgroundIsolate(callbackHandle, shellArgs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onInitialized() {
        Log.i(TAG, "FlutterFirebaseMessagingBackgroundService started!");
        List<Intent> list = messagingQueue;
        synchronized (list) {
            for (Intent intent : list) {
                flutterBackgroundExecutor.executeDartCallbackInBackgroundIsolate(intent, null);
            }
            messagingQueue.clear();
        }
    }

    public static void setCallbackDispatcher(long callbackHandle) {
        FlutterFirebaseMessagingBackgroundExecutor.setCallbackDispatcher(callbackHandle);
    }

    public static void setUserCallbackHandle(long callbackHandle) {
        FlutterFirebaseMessagingBackgroundExecutor.setUserCallbackHandle(callbackHandle);
    }

    @Override // io.flutter.plugins.firebase.messaging.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (flutterBackgroundExecutor == null) {
            flutterBackgroundExecutor = new FlutterFirebaseMessagingBackgroundExecutor();
        }
        flutterBackgroundExecutor.startBackgroundIsolate();
    }

    @Override // io.flutter.plugins.firebase.messaging.JobIntentService
    protected void onHandleWork(final Intent intent) {
        if (!flutterBackgroundExecutor.isDartBackgroundHandlerRegistered()) {
            Log.w(TAG, "A background message could not be handled in Dart as no onBackgroundMessage handler has been registered.");
            return;
        }
        List<Intent> list = messagingQueue;
        synchronized (list) {
            if (flutterBackgroundExecutor.isNotRunning()) {
                Log.i(TAG, "Service has not yet started, messages will be queued.");
                list.add(intent);
                return;
            }
            final CountDownLatch latch = new CountDownLatch(1);
            new Handler(getMainLooper()).post(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterFirebaseMessagingBackgroundService.flutterBackgroundExecutor.executeDartCallbackInBackgroundIsolate(intent, latch);
                }
            });
            try {
                latch.await();
            } catch (InterruptedException ex) {
                Log.i(TAG, "Exception waiting to execute Dart callback", ex);
            }
        }
    }
}
