package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StringCodec;
import java.util.Locale;
/* loaded from: classes.dex */
public class LifecycleChannel {
    private static final String CHANNEL_NAME = "flutter/lifecycle";
    private static final String TAG = "LifecycleChannel";
    private final BasicMessageChannel<String> channel;
    private AppLifecycleState lastAndroidState;
    private AppLifecycleState lastFlutterState;
    private boolean lastFocus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum AppLifecycleState {
        DETACHED,
        RESUMED,
        INACTIVE,
        HIDDEN,
        PAUSED
    }

    public LifecycleChannel(DartExecutor dartExecutor) {
        this(new BasicMessageChannel(dartExecutor, CHANNEL_NAME, StringCodec.INSTANCE));
    }

    public LifecycleChannel(BasicMessageChannel<String> channel) {
        this.lastAndroidState = null;
        this.lastFlutterState = null;
        this.lastFocus = true;
        this.channel = channel;
    }

    private void sendState(AppLifecycleState state, boolean hasFocus) {
        AppLifecycleState appLifecycleState = this.lastAndroidState;
        if (appLifecycleState == state && hasFocus == this.lastFocus) {
            return;
        }
        if (state == null && appLifecycleState == null) {
            this.lastFocus = hasFocus;
            return;
        }
        AppLifecycleState newState = null;
        switch (AnonymousClass1.$SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState[state.ordinal()]) {
            case 1:
                newState = hasFocus ? AppLifecycleState.RESUMED : AppLifecycleState.INACTIVE;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                newState = state;
                break;
        }
        this.lastAndroidState = state;
        this.lastFocus = hasFocus;
        if (newState == this.lastFlutterState) {
            return;
        }
        String message = "AppLifecycleState." + newState.name().toLowerCase(Locale.ROOT);
        Log.v(TAG, "Sending " + message + " message.");
        this.channel.send(message);
        this.lastFlutterState = newState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.engine.systemchannels.LifecycleChannel$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState;

        static {
            int[] iArr = new int[AppLifecycleState.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState = iArr;
            try {
                iArr[AppLifecycleState.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState[AppLifecycleState.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState[AppLifecycleState.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState[AppLifecycleState.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState[AppLifecycleState.DETACHED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public void aWindowIsFocused() {
        sendState(this.lastAndroidState, true);
    }

    public void noWindowsAreFocused() {
        sendState(this.lastAndroidState, false);
    }

    public void appIsResumed() {
        sendState(AppLifecycleState.RESUMED, this.lastFocus);
    }

    public void appIsInactive() {
        sendState(AppLifecycleState.INACTIVE, this.lastFocus);
    }

    public void appIsPaused() {
        sendState(AppLifecycleState.PAUSED, this.lastFocus);
    }

    public void appIsDetached() {
        sendState(AppLifecycleState.DETACHED, this.lastFocus);
    }
}
