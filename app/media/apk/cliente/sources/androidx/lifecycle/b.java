package androidx.lifecycle;

import androidx.lifecycle.i;
/* loaded from: classes.dex */
public final class b implements k {

    /* renamed from: a  reason: collision with root package name */
    private final g[] f519a;

    public b(g[] gVarArr) {
        e4.k.e(gVarArr, "generatedAdapters");
        this.f519a = gVarArr;
    }

    @Override // androidx.lifecycle.k
    public void d(m mVar, i.a aVar) {
        e4.k.e(mVar, "source");
        e4.k.e(aVar, "event");
        r rVar = new r();
        for (g gVar : this.f519a) {
            gVar.a(mVar, aVar, false, rVar);
        }
        for (g gVar2 : this.f519a) {
            gVar2.a(mVar, aVar, true, rVar);
        }
    }
}
