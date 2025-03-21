package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public final class i implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f482a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f483b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f484c;

    private i(View view, Runnable runnable) {
        this.f482a = view;
        this.f483b = view.getViewTreeObserver();
        this.f484c = runnable;
    }

    public static i a(View view, Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                i iVar = new i(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(iVar);
                view.addOnAttachStateChangeListener(iVar);
                return iVar;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    public void b() {
        (this.f483b.isAlive() ? this.f483b : this.f482a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f482a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f484c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f483b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
