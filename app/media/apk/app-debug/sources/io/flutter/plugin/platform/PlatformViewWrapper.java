package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.util.ViewUtils;
/* loaded from: classes.dex */
public class PlatformViewWrapper extends FrameLayout {
    private static final String TAG = "PlatformViewWrapper";
    private ViewTreeObserver.OnGlobalFocusChangeListener activeFocusListener;
    private int left;
    private int prevLeft;
    private int prevTop;
    private PlatformViewRenderTarget renderTarget;
    private int top;
    private AndroidTouchProcessor touchProcessor;

    public PlatformViewWrapper(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public PlatformViewWrapper(Context context, PlatformViewRenderTarget renderTarget) {
        this(context);
        this.renderTarget = renderTarget;
    }

    public void setTouchProcessor(AndroidTouchProcessor newTouchProcessor) {
        this.touchProcessor = newTouchProcessor;
    }

    public void setLayoutParams(FrameLayout.LayoutParams params) {
        super.setLayoutParams((ViewGroup.LayoutParams) params);
        this.left = params.leftMargin;
        this.top = params.topMargin;
    }

    public void resizeRenderTarget(int width, int height) {
        PlatformViewRenderTarget platformViewRenderTarget = this.renderTarget;
        if (platformViewRenderTarget != null) {
            platformViewRenderTarget.resize(width, height);
        }
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

    public void release() {
        PlatformViewRenderTarget platformViewRenderTarget = this.renderTarget;
        if (platformViewRenderTarget != null) {
            platformViewRenderTarget.release();
            this.renderTarget = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        View embeddedView = getChildAt(0);
        if (embeddedView != null && embeddedView.getImportantForAccessibility() == 4) {
            return false;
        }
        return super.requestSendAccessibilityEvent(child, event);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View child, View target) {
        super.onDescendantInvalidated(child, target);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        invalidate();
        return super.invalidateChildInParent(location, dirty);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PlatformViewRenderTarget platformViewRenderTarget = this.renderTarget;
        if (platformViewRenderTarget == null) {
            super.draw(canvas);
            Log.e(TAG, "Platform view cannot be composed without a RenderTarget.");
            return;
        }
        Canvas targetCanvas = platformViewRenderTarget.lockHardwareCanvas();
        if (targetCanvas == null) {
            invalidate();
            return;
        }
        try {
            targetCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(targetCanvas);
        } finally {
            this.renderTarget.unlockCanvasAndPost(targetCanvas);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.touchProcessor == null) {
            return super.onTouchEvent(event);
        }
        Matrix screenMatrix = new Matrix();
        switch (event.getAction()) {
            case 0:
                int i = this.left;
                this.prevLeft = i;
                int i2 = this.top;
                this.prevTop = i2;
                screenMatrix.postTranslate(i, i2);
                break;
            case 1:
            default:
                screenMatrix.postTranslate(this.left, this.top);
                break;
            case 2:
                screenMatrix.postTranslate(this.prevLeft, this.prevTop);
                this.prevLeft = this.left;
                this.prevTop = this.top;
                break;
        }
        return this.touchProcessor.onTouchEvent(event, screenMatrix);
    }

    public ViewTreeObserver.OnGlobalFocusChangeListener getActiveFocusListener() {
        return this.activeFocusListener;
    }

    public void setOnDescendantFocusChangeListener(final View.OnFocusChangeListener userFocusListener) {
        unsetOnDescendantFocusChangeListener();
        ViewTreeObserver observer = getViewTreeObserver();
        if (observer.isAlive() && this.activeFocusListener == null) {
            ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: io.flutter.plugin.platform.PlatformViewWrapper.1
                @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    View.OnFocusChangeListener onFocusChangeListener = userFocusListener;
                    PlatformViewWrapper platformViewWrapper = PlatformViewWrapper.this;
                    onFocusChangeListener.onFocusChange(platformViewWrapper, ViewUtils.childHasFocus(platformViewWrapper));
                }
            };
            this.activeFocusListener = onGlobalFocusChangeListener;
            observer.addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        }
    }

    public void unsetOnDescendantFocusChangeListener() {
        ViewTreeObserver observer = getViewTreeObserver();
        if (observer.isAlive() && this.activeFocusListener != null) {
            ViewTreeObserver.OnGlobalFocusChangeListener currFocusListener = this.activeFocusListener;
            this.activeFocusListener = null;
            observer.removeOnGlobalFocusChangeListener(currFocusListener);
        }
    }
}
