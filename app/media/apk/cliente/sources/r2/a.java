package r2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import h3.h;
import io.flutter.embedding.android.c;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private FlutterMutatorsStack f7160a;

    /* renamed from: b  reason: collision with root package name */
    private float f7161b;

    /* renamed from: c  reason: collision with root package name */
    private int f7162c;

    /* renamed from: d  reason: collision with root package name */
    private int f7163d;

    /* renamed from: e  reason: collision with root package name */
    private int f7164e;

    /* renamed from: f  reason: collision with root package name */
    private int f7165f;

    /* renamed from: k  reason: collision with root package name */
    private final c f7166k;

    /* renamed from: l  reason: collision with root package name */
    ViewTreeObserver.OnGlobalFocusChangeListener f7167l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalFocusChangeListenerC0111a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnFocusChangeListener f7168a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f7169b;

        ViewTreeObserver$OnGlobalFocusChangeListenerC0111a(View.OnFocusChangeListener onFocusChangeListener, View view) {
            this.f7168a = onFocusChangeListener;
            this.f7169b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f7168a;
            View view3 = this.f7169b;
            onFocusChangeListener.onFocusChange(view3, h.d(view3));
        }
    }

    public a(Context context, float f5, c cVar) {
        super(context, null);
        this.f7161b = f5;
        this.f7166k = cVar;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f7160a.getFinalMatrix());
        float f5 = this.f7161b;
        matrix.preScale(1.0f / f5, 1.0f / f5);
        matrix.postTranslate(-this.f7162c, -this.f7163d);
        return matrix;
    }

    public void a(FlutterMutatorsStack flutterMutatorsStack, int i5, int i6, int i7, int i8) {
        this.f7160a = flutterMutatorsStack;
        this.f7162c = i5;
        this.f7163d = i6;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
        layoutParams.leftMargin = i5;
        layoutParams.topMargin = i6;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void b() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f7167l) == null) {
            return;
        }
        this.f7167l = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        for (Path path : this.f7160a.getFinalClippingPaths()) {
            Path path2 = new Path(path);
            path2.offset(-this.f7162c, -this.f7163d);
            canvas.clipPath(path2);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i5;
        float f5;
        if (this.f7166k == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i6 = this.f7162c;
            this.f7164e = i6;
            i5 = this.f7163d;
            this.f7165f = i5;
            f5 = i6;
        } else if (action == 2) {
            matrix.postTranslate(this.f7164e, this.f7165f);
            this.f7164e = this.f7162c;
            this.f7165f = this.f7163d;
            return this.f7166k.l(motionEvent, matrix);
        } else {
            f5 = this.f7162c;
            i5 = this.f7163d;
        }
        matrix.postTranslate(f5, i5);
        return this.f7166k.l(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f7167l == null) {
            ViewTreeObserver$OnGlobalFocusChangeListenerC0111a viewTreeObserver$OnGlobalFocusChangeListenerC0111a = new ViewTreeObserver$OnGlobalFocusChangeListenerC0111a(onFocusChangeListener, this);
            this.f7167l = viewTreeObserver$OnGlobalFocusChangeListenerC0111a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserver$OnGlobalFocusChangeListenerC0111a);
        }
    }
}
