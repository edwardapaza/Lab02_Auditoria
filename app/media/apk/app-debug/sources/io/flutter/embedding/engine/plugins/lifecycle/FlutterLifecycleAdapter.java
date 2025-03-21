package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
/* loaded from: classes2.dex */
public class FlutterLifecycleAdapter {
    public static Lifecycle getActivityLifecycle(ActivityPluginBinding activityPluginBinding) {
        HiddenLifecycleReference reference = (HiddenLifecycleReference) activityPluginBinding.getLifecycle();
        return reference.getLifecycle();
    }
}
