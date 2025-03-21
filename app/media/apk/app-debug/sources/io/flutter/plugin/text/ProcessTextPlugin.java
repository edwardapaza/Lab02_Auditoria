package io.flutter.plugin.text;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.google.firebase.messaging.Constants;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.systemchannels.ProcessTextChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ProcessTextPlugin implements FlutterPlugin, ActivityAware, PluginRegistry.ActivityResultListener, ProcessTextChannel.ProcessTextMethodHandler {
    private static final String TAG = "ProcessTextPlugin";
    private ActivityPluginBinding activityBinding;
    private final PackageManager packageManager;
    private final ProcessTextChannel processTextChannel;
    private Map<Integer, MethodChannel.Result> requestsByCode = new HashMap();
    private Map<String, ResolveInfo> resolveInfosById;

    public ProcessTextPlugin(ProcessTextChannel processTextChannel) {
        this.processTextChannel = processTextChannel;
        this.packageManager = processTextChannel.packageManager;
        processTextChannel.setMethodHandler(this);
    }

    @Override // io.flutter.embedding.engine.systemchannels.ProcessTextChannel.ProcessTextMethodHandler
    public Map<String, String> queryTextActions() {
        if (this.resolveInfosById == null) {
            cacheResolveInfos();
        }
        Map<String, String> result = new HashMap<>();
        for (String id : this.resolveInfosById.keySet()) {
            ResolveInfo info = this.resolveInfosById.get(id);
            result.put(id, info.loadLabel(this.packageManager).toString());
        }
        return result;
    }

    @Override // io.flutter.embedding.engine.systemchannels.ProcessTextChannel.ProcessTextMethodHandler
    public void processTextAction(String id, String text, boolean readOnly, MethodChannel.Result result) {
        if (this.activityBinding == null) {
            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Plugin not bound to an Activity", null);
        } else if (Build.VERSION.SDK_INT < 23) {
            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Android version not supported", null);
        } else {
            Map<String, ResolveInfo> map = this.resolveInfosById;
            if (map == null) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Can not process text actions before calling queryTextActions", null);
                return;
            }
            ResolveInfo info = map.get(id);
            if (info == null) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Text processing activity not found", null);
                return;
            }
            Integer requestCode = Integer.valueOf(result.hashCode());
            this.requestsByCode.put(requestCode, result);
            Intent intent = new Intent();
            intent.setClassName(info.activityInfo.packageName, info.activityInfo.name);
            intent.setAction("android.intent.action.PROCESS_TEXT");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.PROCESS_TEXT", text);
            intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", readOnly);
            this.activityBinding.getActivity().startActivityForResult(intent, requestCode.intValue());
        }
    }

    private void cacheResolveInfos() {
        List<ResolveInfo> infos;
        this.resolveInfosById = new HashMap();
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        Intent intent = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        if (Build.VERSION.SDK_INT >= 33) {
            infos = this.packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L));
        } else {
            infos = this.packageManager.queryIntentActivities(intent, 0);
        }
        for (ResolveInfo info : infos) {
            String id = info.activityInfo.name;
            info.loadLabel(this.packageManager).toString();
            this.resolveInfosById.put(id, info);
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (!this.requestsByCode.containsKey(Integer.valueOf(requestCode))) {
            return false;
        }
        String result = null;
        if (resultCode == -1) {
            result = intent.getStringExtra("android.intent.extra.PROCESS_TEXT");
        }
        this.requestsByCode.remove(Integer.valueOf(requestCode)).success(result);
        return true;
    }

    public void destroy() {
        this.processTextChannel.setMethodHandler(null);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        this.activityBinding = binding;
        binding.addActivityResultListener(this);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.activityBinding.removeActivityResultListener(this);
        this.activityBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        this.activityBinding = binding;
        binding.addActivityResultListener(this);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.activityBinding.removeActivityResultListener(this);
        this.activityBinding = null;
    }
}
