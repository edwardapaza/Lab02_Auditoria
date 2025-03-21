package androidx.lifecycle;

import androidx.lifecycle.i;
/* loaded from: classes.dex */
public final class c0 implements k {

    /* renamed from: a  reason: collision with root package name */
    private final e0 f527a;

    public c0(e0 e0Var) {
        e4.k.e(e0Var, "provider");
        this.f527a = e0Var;
    }

    @Override // androidx.lifecycle.k
    public void d(m mVar, i.a aVar) {
        e4.k.e(mVar, "source");
        e4.k.e(aVar, "event");
        if (aVar == i.a.ON_CREATE) {
            mVar.a().c(this);
            this.f527a.c();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
    }
}
