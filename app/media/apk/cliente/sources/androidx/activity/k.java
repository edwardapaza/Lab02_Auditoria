package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.i;
import androidx.lifecycle.n0;
/* loaded from: classes.dex */
public class k extends Dialog implements androidx.lifecycle.m, s, u.f {

    /* renamed from: a  reason: collision with root package name */
    private androidx.lifecycle.n f137a;

    /* renamed from: b  reason: collision with root package name */
    private final u.e f138b;

    /* renamed from: c  reason: collision with root package name */
    private final q f139c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, int i5) {
        super(context, i5);
        e4.k.e(context, "context");
        this.f138b = u.e.f7712d.a(this);
        this.f139c = new q(new Runnable() { // from class: androidx.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                k.e(k.this);
            }
        });
    }

    private final androidx.lifecycle.n c() {
        androidx.lifecycle.n nVar = this.f137a;
        if (nVar == null) {
            androidx.lifecycle.n nVar2 = new androidx.lifecycle.n(this);
            this.f137a = nVar2;
            return nVar2;
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(k kVar) {
        e4.k.e(kVar, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.lifecycle.m
    public androidx.lifecycle.i a() {
        return c();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e4.k.e(view, "view");
        d();
        super.addContentView(view, layoutParams);
    }

    public void d() {
        Window window = getWindow();
        e4.k.b(window);
        View decorView = window.getDecorView();
        e4.k.d(decorView, "window!!.decorView");
        n0.a(decorView, this);
        Window window2 = getWindow();
        e4.k.b(window2);
        View decorView2 = window2.getDecorView();
        e4.k.d(decorView2, "window!!.decorView");
        v.a(decorView2, this);
        Window window3 = getWindow();
        e4.k.b(window3);
        View decorView3 = window3.getDecorView();
        e4.k.d(decorView3, "window!!.decorView");
        u.g.a(decorView3, this);
    }

    @Override // androidx.activity.s
    public final q j() {
        return this.f139c;
    }

    @Override // u.f
    public u.d k() {
        return this.f138b.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f139c.k();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            q qVar = this.f139c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            e4.k.d(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            qVar.n(onBackInvokedDispatcher);
        }
        this.f138b.d(bundle);
        c().h(i.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        e4.k.d(onSaveInstanceState, "super.onSaveInstanceState()");
        this.f138b.e(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        c().h(i.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        c().h(i.a.ON_DESTROY);
        this.f137a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i5) {
        d();
        super.setContentView(i5);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        e4.k.e(view, "view");
        d();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e4.k.e(view, "view");
        d();
        super.setContentView(view, layoutParams);
    }
}
