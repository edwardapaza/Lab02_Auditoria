package m4;
/* loaded from: classes.dex */
public final class y2 extends g0 {

    /* renamed from: c  reason: collision with root package name */
    public static final y2 f6296c = new y2();

    private y2() {
    }

    @Override // m4.g0
    public void f0(v3.g gVar, Runnable runnable) {
        c3 c3Var = (c3) gVar.d(c3.f6207c);
        if (c3Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        c3Var.f6208b = true;
    }

    @Override // m4.g0
    public boolean g0(v3.g gVar) {
        return false;
    }

    @Override // m4.g0
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
