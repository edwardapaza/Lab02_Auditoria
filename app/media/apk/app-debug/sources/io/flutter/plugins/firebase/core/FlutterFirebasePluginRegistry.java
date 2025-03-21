package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class FlutterFirebasePluginRegistry {
    private static final Map<String, FlutterFirebasePlugin> registeredPlugins = new WeakHashMap();

    public static void registerPlugin(String channelName, FlutterFirebasePlugin flutterFirebasePlugin) {
        registeredPlugins.put(channelName, flutterFirebasePlugin);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Task<Map<String, Object>> getPluginConstantsForFirebaseApp(final FirebaseApp firebaseApp) {
        final TaskCompletionSource<Map<String, Object>> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebasePluginRegistry.lambda$getPluginConstantsForFirebaseApp$0(FirebaseApp.this, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getPluginConstantsForFirebaseApp$0(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        try {
            Map<String, FlutterFirebasePlugin> map = registeredPlugins;
            HashMap hashMap = new HashMap(map.size());
            for (Map.Entry<String, FlutterFirebasePlugin> entry : map.entrySet()) {
                String channelName = entry.getKey();
                FlutterFirebasePlugin plugin = entry.getValue();
                hashMap.put(channelName, Tasks.await(plugin.getPluginConstantsForFirebaseApp(firebaseApp)));
            }
            taskCompletionSource.setResult(hashMap);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebasePluginRegistry.lambda$didReinitializeFirebaseCore$1(TaskCompletionSource.this);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$didReinitializeFirebaseCore$1(TaskCompletionSource taskCompletionSource) {
        try {
            for (Map.Entry<String, FlutterFirebasePlugin> entry : registeredPlugins.entrySet()) {
                FlutterFirebasePlugin plugin = entry.getValue();
                Tasks.await(plugin.didReinitializeFirebaseCore());
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }
}
