package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    private final d0<?> f6373a;

    private b0(d0<?> d0Var) {
        this.f6373a = d0Var;
    }

    public static b0 b(d0<?> d0Var) {
        return new b0((d0) k.d.b(d0Var, "callbacks == null"));
    }

    public void a(s sVar) {
        l0 v5 = this.f6373a.v();
        d0<?> d0Var = this.f6373a;
        v5.l(d0Var, d0Var, sVar);
    }

    public void c() {
        this.f6373a.v().x();
    }

    public boolean d(MenuItem menuItem) {
        return this.f6373a.v().A(menuItem);
    }

    public void e() {
        this.f6373a.v().B();
    }

    public void f() {
        this.f6373a.v().D();
    }

    public void g() {
        this.f6373a.v().M();
    }

    public void h() {
        this.f6373a.v().Q();
    }

    public void i() {
        this.f6373a.v().R();
    }

    public void j() {
        this.f6373a.v().T();
    }

    public boolean k() {
        return this.f6373a.v().a0(true);
    }

    public l0 l() {
        return this.f6373a.v();
    }

    public void m() {
        this.f6373a.v().X0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f6373a.v().w0().onCreateView(view, str, context, attributeSet);
    }
}
