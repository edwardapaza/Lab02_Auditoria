package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
/* loaded from: classes.dex */
public class p extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f4055a;

    /* renamed from: b  reason: collision with root package name */
    private int f4056b;

    /* renamed from: c  reason: collision with root package name */
    private int f4057c;

    /* renamed from: d  reason: collision with root package name */
    private int f4058d;

    /* renamed from: e  reason: collision with root package name */
    private io.flutter.embedding.android.c f4059e;

    /* renamed from: f  reason: collision with root package name */
    private n f4060f;

    /* renamed from: k  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalFocusChangeListener f4061k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnFocusChangeListener f4062a;

        a(View.OnFocusChangeListener onFocusChangeListener) {
            this.f4062a = onFocusChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f4062a;
            p pVar = p.this;
            onFocusChangeListener.onFocusChange(pVar, h3.h.d(pVar));
        }
    }

    public p(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public p(Context context, n nVar) {
        this(context);
        Canvas lockHardwareCanvas;
        this.f4060f = nVar;
        Surface surface = nVar.getSurface();
        if (surface == null || FlutterRenderer.f3857j) {
            return;
        }
        lockHardwareCanvas = surface.lockHardwareCanvas();
        try {
            lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        } finally {
            surface.unlockCanvasAndPost(lockHardwareCanvas);
        }
    }

    public void a() {
        n nVar = this.f4060f;
        if (nVar != null) {
            nVar.release();
            this.f4060f = null;
        }
    }

    public void b(int i5, int i6) {
        n nVar = this.f4060f;
        if (nVar != null) {
            nVar.a(i5, i6);
        }
    }

    public void c() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f4061k) == null) {
            return;
        }
        this.f4061k = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Canvas lockHardwareCanvas;
        n nVar = this.f4060f;
        if (nVar == null) {
            super.draw(canvas);
            n2.b.b("PlatformViewWrapper", "Platform view cannot be composed without a RenderTarget.");
            return;
        }
        Surface surface = nVar.getSurface();
        lockHardwareCanvas = surface.lockHardwareCanvas();
        if (lockHardwareCanvas == null) {
            invalidate();
            return;
        }
        try {
            lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(lockHardwareCanvas);
        } finally {
            this.f4060f.scheduleFrame();
            surface.unlockCanvasAndPost(lockHardwareCanvas);
        }
    }

    public ViewTreeObserver.OnGlobalFocusChangeListener getActiveFocusListener() {
        return this.f4061k;
    }

    public int getRenderTargetHeight() {
        n nVar = this.f4060f;
        if (nVar != null) {
            return nVar.getHeight();
        }
        return 0;
    }

    public int getRenderTargetWidth() {
        n nVar = this.f4060f;
        if (nVar != null) {
            return nVar.getWidth();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i5;
        float f5;
        if (this.f4059e == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i6 = this.f4057c;
            this.f4055a = i6;
            i5 = this.f4058d;
            this.f4056b = i5;
            f5 = i6;
        } else if (action == 2) {
            matrix.postTranslate(this.f4055a, this.f4056b);
            this.f4055a = this.f4057c;
            this.f4056b = this.f4058d;
            return this.f4059e.l(motionEvent, matrix);
        } else {
            f5 = this.f4057c;
            i5 = this.f4058d;
        }
        matrix.postTranslate(f5, i5);
        return this.f4059e.l(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams((ViewGroup.LayoutParams) layoutParams);
        this.f4057c = layoutParams.leftMargin;
        this.f4058d = layoutParams.topMargin;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        c();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f4061k == null) {
            a aVar = new a(onFocusChangeListener);
            this.f4061k = aVar;
            viewTreeObserver.addOnGlobalFocusChangeListener(aVar);
        }
    }

    public void setTouchProcessor(io.flutter.embedding.android.c cVar) {
        this.f4059e = cVar;
    }
}
