package io.flutter.embedding.engine.systemchannels;

import android.content.pm.PackageManager;
import com.google.firebase.messaging.Constants;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class ProcessTextChannel {
    private static final String CHANNEL_NAME = "flutter/processtext";
    private static final String METHOD_PROCESS_TEXT_ACTION = "ProcessText.processTextAction";
    private static final String METHOD_QUERY_TEXT_ACTIONS = "ProcessText.queryTextActions";
    private static final String TAG = "ProcessTextChannel";
    public final MethodChannel channel;
    public final PackageManager packageManager;
    public final MethodChannel.MethodCallHandler parsingMethodHandler;
    private ProcessTextMethodHandler processTextMethodHandler;

    /* loaded from: classes.dex */
    public interface ProcessTextMethodHandler {
        void processTextAction(String str, String str2, boolean z, MethodChannel.Result result);

        Map<String, String> queryTextActions();
    }

    public ProcessTextChannel(DartExecutor dartExecutor, PackageManager packageManager) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.ProcessTextChannel.1
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall call, MethodChannel.Result result) {
                if (ProcessTextChannel.this.processTextMethodHandler == null) {
                    return;
                }
                String method = call.method;
                Object args = call.arguments;
                char c = 65535;
                switch (method.hashCode()) {
                    case -574662592:
                        if (method.equals(ProcessTextChannel.METHOD_PROCESS_TEXT_ACTION)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -462843718:
                        if (method.equals(ProcessTextChannel.METHOD_QUERY_TEXT_ACTIONS)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        try {
                            Map<String, String> actions = ProcessTextChannel.this.processTextMethodHandler.queryTextActions();
                            result.success(actions);
                            return;
                        } catch (IllegalStateException exception) {
                            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, exception.getMessage(), null);
                            return;
                        }
                    case 1:
                        try {
                            ArrayList<Object> argumentList = (ArrayList) args;
                            String id = (String) argumentList.get(0);
                            String text = (String) argumentList.get(1);
                            boolean readOnly = ((Boolean) argumentList.get(2)).booleanValue();
                            ProcessTextChannel.this.processTextMethodHandler.processTextAction(id, text, readOnly, result);
                            return;
                        } catch (IllegalStateException exception2) {
                            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, exception2.getMessage(), null);
                            return;
                        }
                    default:
                        result.notImplemented();
                        return;
                }
            }
        };
        this.parsingMethodHandler = methodCallHandler;
        this.packageManager = packageManager;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, CHANNEL_NAME, StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    public void setMethodHandler(ProcessTextMethodHandler processTextMethodHandler) {
        this.processTextMethodHandler = processTextMethodHandler;
    }
}
