package d3;

import d3.a1;
/* loaded from: classes.dex */
public class z0 implements a1.l {
    @Override // d3.a1.l
    public void a(String str, String str2, String str3, a1.f0<String> f0Var) {
        com.google.firebase.auth.a1 a1Var = y0.f2618a.get(str);
        f0Var.a((str2 == null || str3 == null) ? a1Var.f() : a1Var.d(str2, str3));
    }

    @Override // d3.a1.l
    public void b(String str, String str2, a1.g0 g0Var) {
        y0.f2618a.get(str).i(str2);
        g0Var.a();
    }
}
