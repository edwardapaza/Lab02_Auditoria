package s1;

import java.util.ArrayList;
import java.util.List;
import s1.p;
/* loaded from: classes.dex */
public class r0 extends p {

    /* renamed from: d  reason: collision with root package name */
    private final List<v1.l> f7471d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r0(v1.r r2, i2.d0 r3) {
        /*
            r1 = this;
            s1.p$b r0 = s1.p.b.IN
            r1.<init>(r2, r0, r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f7471d = r2
            java.util.List r3 = k(r0, r3)
            r2.addAll(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.r0.<init>(v1.r, i2.d0):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<v1.l> k(p.b bVar, i2.d0 d0Var) {
        z1.b.d(bVar == p.b.IN || bVar == p.b.NOT_IN, "extractDocumentKeysFromArrayValue requires IN or NOT_IN operators", new Object[0]);
        z1.b.d(v1.z.t(d0Var), "KeyFieldInFilter/KeyFieldNotInFilter expects an ArrayValue", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (i2.d0 d0Var2 : d0Var.p0().e()) {
            boolean B = v1.z.B(d0Var2);
            z1.b.d(B, "Comparing on key with " + bVar.toString() + ", but an array value was not a ReferenceValue", new Object[0]);
            arrayList.add(v1.l.h(d0Var2.x0()));
        }
        return arrayList;
    }

    @Override // s1.p, s1.q
    public boolean d(v1.i iVar) {
        return this.f7471d.contains(iVar.getKey());
    }
}
