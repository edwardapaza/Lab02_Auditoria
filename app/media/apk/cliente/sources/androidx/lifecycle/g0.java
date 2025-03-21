package androidx.lifecycle;

import androidx.lifecycle.i;
/* loaded from: classes.dex */
public final class g0 implements k {

    /* renamed from: a  reason: collision with root package name */
    private final g f540a;

    public g0(g gVar) {
        e4.k.e(gVar, "generatedAdapter");
        this.f540a = gVar;
    }

    @Override // androidx.lifecycle.k
    public void d(m mVar, i.a aVar) {
        e4.k.e(mVar, "source");
        e4.k.e(aVar, "event");
        this.f540a.a(mVar, aVar, false, null);
        this.f540a.a(mVar, aVar, true, null);
    }
}
