package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import android.view.Display;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;
/* loaded from: classes.dex */
public class VsyncWaiter {
    private static VsyncWaiter instance;
    private static DisplayListener listener;
    private FlutterJNI flutterJNI;
    private long refreshPeriodNanos = -1;
    private FrameCallback frameCallback = new FrameCallback(0);
    private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() { // from class: io.flutter.view.VsyncWaiter.1
        private Choreographer.FrameCallback obtainFrameCallback(long cookie) {
            if (VsyncWaiter.this.frameCallback != null) {
                VsyncWaiter.this.frameCallback.cookie = cookie;
                FrameCallback ret = VsyncWaiter.this.frameCallback;
                VsyncWaiter.this.frameCallback = null;
                return ret;
            }
            return new FrameCallback(cookie);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate
        public void asyncWaitForVsync(long cookie) {
            Choreographer.getInstance().postFrameCallback(obtainFrameCallback(cookie));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DisplayListener implements DisplayManager.DisplayListener {
        private DisplayManager displayManager;

        DisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            if (displayId == 0) {
                Display primaryDisplay = this.displayManager.getDisplay(0);
                float fps = primaryDisplay.getRefreshRate();
                VsyncWaiter.this.refreshPeriodNanos = (long) (1.0E9d / fps);
                VsyncWaiter.this.flutterJNI.setRefreshRateFPS(fps);
            }
        }
    }

    public static VsyncWaiter getInstance(float fps, FlutterJNI flutterJNI) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI);
        }
        flutterJNI.setRefreshRateFPS(fps);
        VsyncWaiter vsyncWaiter = instance;
        vsyncWaiter.refreshPeriodNanos = (long) (1.0E9d / fps);
        return vsyncWaiter;
    }

    public static VsyncWaiter getInstance(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI);
        }
        if (listener == null) {
            VsyncWaiter vsyncWaiter = instance;
            Objects.requireNonNull(vsyncWaiter);
            DisplayListener displayListener = new DisplayListener(displayManager);
            listener = displayListener;
            displayListener.register();
        }
        if (instance.refreshPeriodNanos == -1) {
            Display primaryDisplay = displayManager.getDisplay(0);
            float fps = primaryDisplay.getRefreshRate();
            instance.refreshPeriodNanos = (long) (1.0E9d / fps);
            flutterJNI.setRefreshRateFPS(fps);
        }
        return instance;
    }

    public static void reset() {
        instance = null;
        listener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FrameCallback implements Choreographer.FrameCallback {
        private long cookie;

        FrameCallback(long cookie) {
            this.cookie = cookie;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            long delay = System.nanoTime() - frameTimeNanos;
            if (delay < 0) {
                delay = 0;
            }
            VsyncWaiter.this.flutterJNI.onVsync(delay, VsyncWaiter.this.refreshPeriodNanos, this.cookie);
            VsyncWaiter.this.frameCallback = this;
        }
    }

    private VsyncWaiter(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    public void init() {
        this.flutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
    }
}
