package t1;

import v1.l;
import z1.h0;
/* loaded from: classes.dex */
public abstract class e implements Comparable<e> {
    public static e c(int i5, l lVar, byte[] bArr, byte[] bArr2) {
        return new a(i5, lVar, bArr, bArr2);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e eVar) {
        int compare = Integer.compare(k(), eVar.k());
        if (compare != 0) {
            return compare;
        }
        int compareTo = h().compareTo(eVar.h());
        if (compareTo != 0) {
            return compareTo;
        }
        int i5 = h0.i(d(), eVar.d());
        return i5 != 0 ? i5 : h0.i(e(), eVar.e());
    }

    public abstract byte[] d();

    public abstract byte[] e();

    public abstract l h();

    public abstract int k();
}
