package s1;

import java.util.List;
/* loaded from: classes.dex */
public class s0 extends p {

    /* renamed from: d  reason: collision with root package name */
    private final List<v1.l> f7476d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s0(v1.r r2, i2.d0 r3) {
        /*
            r1 = this;
            s1.p$b r0 = s1.p.b.NOT_IN
            r1.<init>(r2, r0, r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f7476d = r2
            java.util.List r3 = s1.r0.k(r0, r3)
            r2.addAll(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.s0.<init>(v1.r, i2.d0):void");
    }

    @Override // s1.p, s1.q
    public boolean d(v1.i iVar) {
        return !this.f7476d.contains(iVar.getKey());
    }
}
