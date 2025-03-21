package o;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a0 extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final List<View> f6352a;

    /* renamed from: b  reason: collision with root package name */
    private final List<View> f6353b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f6354c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6355d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f6356a = new a();

        private a() {
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            e4.k.e(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            e4.k.e(view, "v");
            e4.k.e(windowInsets, "insets");
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            e4.k.d(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(Context context, AttributeSet attributeSet, l0 l0Var) {
        super(context, attributeSet);
        String str;
        e4.k.e(context, "context");
        e4.k.e(attributeSet, "attrs");
        e4.k.e(l0Var, "fm");
        this.f6352a = new ArrayList();
        this.f6353b = new ArrayList();
        this.f6355d = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = n.c.f6308e;
        e4.k.d(iArr, "FragmentContainerView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(n.c.f6309f) : classAttribute;
        String string = obtainStyledAttributes.getString(n.c.f6310g);
        obtainStyledAttributes.recycle();
        int id = getId();
        s h02 = l0Var.h0(id);
        if (classAttribute != null && h02 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            s a5 = l0Var.t0().a(context.getClassLoader(), classAttribute);
            e4.k.d(a5, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            a5.C = id;
            a5.D = id;
            a5.E = string;
            a5.f6624y = l0Var;
            a5.f6625z = l0Var.v0();
            a5.A0(context, attributeSet, null);
            l0Var.n().m(true).c(this, a5, string).i();
        }
        l0Var.Y0(this);
    }

    private final void a(View view) {
        if (this.f6353b.contains(view)) {
            this.f6352a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        e4.k.e(view, "child");
        if (l0.C0(view) != null) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        androidx.core.view.c0 h5;
        e4.k.e(windowInsets, "insets");
        androidx.core.view.c0 n5 = androidx.core.view.c0.n(windowInsets);
        e4.k.d(n5, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f6354c;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f6356a;
            e4.k.b(onApplyWindowInsetsListener);
            h5 = androidx.core.view.c0.n(aVar.a(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            h5 = androidx.core.view.l.h(this, n5);
        }
        e4.k.d(h5, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!h5.h()) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                androidx.core.view.l.a(getChildAt(i5), h5);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        e4.k.e(canvas, "canvas");
        if (this.f6355d) {
            for (View view : this.f6352a) {
                super.drawChild(canvas, view, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j5) {
        e4.k.e(canvas, "canvas");
        e4.k.e(view, "child");
        if (this.f6355d && (!this.f6352a.isEmpty()) && this.f6352a.contains(view)) {
            return false;
        }
        return super.drawChild(canvas, view, j5);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        e4.k.e(view, "view");
        this.f6353b.remove(view);
        if (this.f6352a.remove(view)) {
            this.f6355d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends s> F getFragment() {
        return (F) l0.k0(this).h0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        e4.k.e(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            }
            View childAt = getChildAt(childCount);
            e4.k.d(childAt, "view");
            a(childAt);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        e4.k.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i5) {
        View childAt = getChildAt(i5);
        e4.k.d(childAt, "view");
        a(childAt);
        super.removeViewAt(i5);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        e4.k.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i5, int i6) {
        int i7 = i5 + i6;
        for (int i8 = i5; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            e4.k.d(childAt, "view");
            a(childAt);
        }
        super.removeViews(i5, i6);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i5, int i6) {
        int i7 = i5 + i6;
        for (int i8 = i5; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            e4.k.d(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i5, i6);
    }

    public final void setDrawDisappearingViewsLast(boolean z4) {
        this.f6355d = z4;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        e4.k.e(onApplyWindowInsetsListener, "listener");
        this.f6354c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        e4.k.e(view, "view");
        if (view.getParent() == this) {
            this.f6353b.add(view);
        }
        super.startViewTransition(view);
    }
}
