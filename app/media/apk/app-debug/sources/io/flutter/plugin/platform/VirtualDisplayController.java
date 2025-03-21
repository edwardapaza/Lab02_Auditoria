package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.firebase.messaging.Constants;
import io.flutter.plugin.platform.SingleViewPresentation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class VirtualDisplayController {
    private static String TAG = "VirtualDisplayController";
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private final Context context;
    private final int densityDpi;
    private final View.OnFocusChangeListener focusChangeListener;
    SingleViewPresentation presentation;
    private final PlatformViewRenderTarget renderTarget;
    private final int viewId;
    private VirtualDisplay virtualDisplay;

    public static VirtualDisplayController create(Context context, AccessibilityEventsDelegate accessibilityEventsDelegate, PlatformView view, PlatformViewRenderTarget renderTarget, int width, int height, int viewId, Object createParams, View.OnFocusChangeListener focusChangeListener) {
        if (width != 0 && height != 0) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            renderTarget.resize(width, height);
            VirtualDisplay virtualDisplay = displayManager.createVirtualDisplay("flutter-vd#" + viewId, width, height, metrics.densityDpi, renderTarget.getSurface(), 0);
            if (virtualDisplay == null) {
                return null;
            }
            VirtualDisplayController controller = new VirtualDisplayController(context, accessibilityEventsDelegate, virtualDisplay, view, renderTarget, focusChangeListener, viewId, createParams);
            return controller;
        }
        return null;
    }

    private VirtualDisplayController(Context context, AccessibilityEventsDelegate accessibilityEventsDelegate, VirtualDisplay virtualDisplay, PlatformView view, PlatformViewRenderTarget renderTarget, View.OnFocusChangeListener focusChangeListener, int viewId, Object createParams) {
        this.context = context;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate;
        this.renderTarget = renderTarget;
        this.focusChangeListener = focusChangeListener;
        this.viewId = viewId;
        this.virtualDisplay = virtualDisplay;
        this.densityDpi = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.virtualDisplay.getDisplay(), view, accessibilityEventsDelegate, viewId, focusChangeListener);
        this.presentation = singleViewPresentation;
        singleViewPresentation.show();
    }

    public int getRenderTargetWidth() {
        PlatformViewRenderTarget platformViewRenderTarget = this.renderTarget;
        if (platformViewRenderTarget != null) {
            return platformViewRenderTarget.getWidth();
        }
        return 0;
    }

    public int getRenderTargetHeight() {
        PlatformViewRenderTarget platformViewRenderTarget = this.renderTarget;
        if (platformViewRenderTarget != null) {
            return platformViewRenderTarget.getHeight();
        }
        return 0;
    }

    public void resize(int width, int height, final Runnable onNewSizeFrameAvailable) {
        if (width == getRenderTargetWidth() && height == getRenderTargetHeight()) {
            getView().postDelayed(onNewSizeFrameAvailable, 0L);
        } else if (Build.VERSION.SDK_INT >= 31) {
            resize31(getView(), width, height, onNewSizeFrameAvailable);
        } else {
            boolean isFocused = getView().isFocused();
            SingleViewPresentation.PresentationState presentationState = this.presentation.detachState();
            this.virtualDisplay.setSurface(null);
            this.virtualDisplay.release();
            DisplayManager displayManager = (DisplayManager) this.context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
            this.renderTarget.resize(width, height);
            this.virtualDisplay = displayManager.createVirtualDisplay("flutter-vd#" + this.viewId, width, height, this.densityDpi, this.renderTarget.getSurface(), 0);
            final View embeddedView = getView();
            embeddedView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: io.flutter.plugin.platform.VirtualDisplayController.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    OneTimeOnDrawListener.schedule(embeddedView, new Runnable() { // from class: io.flutter.plugin.platform.VirtualDisplayController.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            embeddedView.postDelayed(onNewSizeFrameAvailable, 128L);
                        }
                    });
                    embeddedView.removeOnAttachStateChangeListener(this);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                }
            });
            SingleViewPresentation newPresentation = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, presentationState, this.focusChangeListener, isFocused);
            newPresentation.show();
            this.presentation.cancel();
            this.presentation = newPresentation;
        }
    }

    public void dispose() {
        this.presentation.cancel();
        this.presentation.detachState();
        this.virtualDisplay.release();
        this.renderTarget.release();
    }

    private void resize31(View embeddedView, int width, int height, Runnable onNewSizeFrameAvailable) {
        this.renderTarget.resize(width, height);
        this.virtualDisplay.resize(width, height, this.densityDpi);
        embeddedView.postDelayed(onNewSizeFrameAvailable, 0L);
    }

    void onFlutterViewAttached(View flutterView) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.presentation.getView().onFlutterViewAttached(flutterView);
    }

    void onFlutterViewDetached() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.presentation.getView().onFlutterViewDetached();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInputConnectionLocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.presentation.getView().onInputConnectionLocked();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInputConnectionUnlocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.presentation.getView().onInputConnectionUnlocked();
    }

    public View getView() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null) {
            return null;
        }
        PlatformView platformView = singleViewPresentation.getView();
        return platformView.getView();
    }

    public void dispatchTouchEvent(MotionEvent event) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(event);
    }

    /* loaded from: classes.dex */
    static class OneTimeOnDrawListener implements ViewTreeObserver.OnDrawListener {
        Runnable mOnDrawRunnable;
        final View mView;

        static void schedule(View view, Runnable runnable) {
            OneTimeOnDrawListener listener = new OneTimeOnDrawListener(view, runnable);
            view.getViewTreeObserver().addOnDrawListener(listener);
        }

        OneTimeOnDrawListener(View view, Runnable onDrawRunnable) {
            this.mView = view;
            this.mOnDrawRunnable = onDrawRunnable;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.mOnDrawRunnable;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.mOnDrawRunnable = null;
            this.mView.post(new Runnable() { // from class: io.flutter.plugin.platform.VirtualDisplayController.OneTimeOnDrawListener.1
                @Override // java.lang.Runnable
                public void run() {
                    OneTimeOnDrawListener.this.mView.getViewTreeObserver().removeOnDrawListener(OneTimeOnDrawListener.this);
                }
            });
        }
    }
}
