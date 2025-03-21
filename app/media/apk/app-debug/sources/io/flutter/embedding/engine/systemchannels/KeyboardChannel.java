package io.flutter.embedding.engine.systemchannels;

import com.google.firebase.messaging.Constants;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class KeyboardChannel {
    public final MethodChannel channel;
    private KeyboardMethodHandler keyboardMethodHandler;
    public final MethodChannel.MethodCallHandler parsingMethodHandler;

    /* loaded from: classes.dex */
    public interface KeyboardMethodHandler {
        Map<Long, Long> getKeyboardState();
    }

    public KeyboardChannel(BinaryMessenger messenger) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.KeyboardChannel.1
            Map<Long, Long> pressedState = new HashMap();

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall call, MethodChannel.Result result) {
                if (KeyboardChannel.this.keyboardMethodHandler == null) {
                    result.success(this.pressedState);
                    return;
                }
                String str = call.method;
                char c = 65535;
                switch (str.hashCode()) {
                    case 1063286068:
                        if (str.equals("getKeyboardState")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        try {
                            this.pressedState = KeyboardChannel.this.keyboardMethodHandler.getKeyboardState();
                        } catch (IllegalStateException exception) {
                            result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, exception.getMessage(), null);
                        }
                        result.success(this.pressedState);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        };
        this.parsingMethodHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(messenger, "flutter/keyboard", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    public void setKeyboardMethodHandler(KeyboardMethodHandler keyboardMethodHandler) {
        this.keyboardMethodHandler = keyboardMethodHandler;
    }
}
