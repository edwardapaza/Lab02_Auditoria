package w4;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends f {

    /* renamed from: f  reason: collision with root package name */
    final transient byte[][] f8310f;

    /* renamed from: k  reason: collision with root package name */
    final transient int[] f8311k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar, int i5) {
        super(null);
        p.b(cVar.f8282b, 0L, i5);
        j jVar = cVar.f8281a;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = jVar.f8303c;
            int i10 = jVar.f8302b;
            if (i9 == i10) {
                throw new AssertionError("s.limit == s.pos");
            }
            i7 += i9 - i10;
            i8++;
            jVar = jVar.f8306f;
        }
        this.f8310f = new byte[i8];
        this.f8311k = new int[i8 * 2];
        j jVar2 = cVar.f8281a;
        int i11 = 0;
        while (i6 < i5) {
            byte[][] bArr = this.f8310f;
            bArr[i11] = jVar2.f8301a;
            int i12 = jVar2.f8303c;
            int i13 = jVar2.f8302b;
            i6 += i12 - i13;
            if (i6 > i5) {
                i6 = i5;
            }
            int[] iArr = this.f8311k;
            iArr[i11] = i6;
            iArr[bArr.length + i11] = i13;
            jVar2.f8304d = true;
            i11++;
            jVar2 = jVar2.f8306f;
        }
    }

    private int w(int i5) {
        int binarySearch = Arrays.binarySearch(this.f8311k, 0, this.f8310f.length, i5 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private f x() {
        return new f(t());
    }

    @Override // w4.f
    public String a() {
        return x().a();
    }

    @Override // w4.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.p() == p() && n(0, fVar, 0, p())) {
                return true;
            }
        }
        return false;
    }

    @Override // w4.f
    public byte h(int i5) {
        p.b(this.f8311k[this.f8310f.length - 1], i5, 1L);
        int w5 = w(i5);
        int i6 = w5 == 0 ? 0 : this.f8311k[w5 - 1];
        int[] iArr = this.f8311k;
        byte[][] bArr = this.f8310f;
        return bArr[w5][(i5 - i6) + iArr[bArr.length + w5]];
    }

    @Override // w4.f
    public int hashCode() {
        int i5 = this.f8287b;
        if (i5 != 0) {
            return i5;
        }
        int length = this.f8310f.length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        while (i6 < length) {
            byte[] bArr = this.f8310f[i6];
            int[] iArr = this.f8311k;
            int i9 = iArr[length + i6];
            int i10 = iArr[i6];
            int i11 = (i10 - i7) + i9;
            while (i9 < i11) {
                i8 = (i8 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i7 = i10;
        }
        this.f8287b = i8;
        return i8;
    }

    @Override // w4.f
    public String k() {
        return x().k();
    }

    @Override // w4.f
    public boolean n(int i5, f fVar, int i6, int i7) {
        if (i5 < 0 || i5 > p() - i7) {
            return false;
        }
        int w5 = w(i5);
        while (i7 > 0) {
            int i8 = w5 == 0 ? 0 : this.f8311k[w5 - 1];
            int min = Math.min(i7, ((this.f8311k[w5] - i8) + i8) - i5);
            int[] iArr = this.f8311k;
            byte[][] bArr = this.f8310f;
            if (!fVar.o(i6, bArr[w5], (i5 - i8) + iArr[bArr.length + w5], min)) {
                return false;
            }
            i5 += min;
            i6 += min;
            i7 -= min;
            w5++;
        }
        return true;
    }

    @Override // w4.f
    public boolean o(int i5, byte[] bArr, int i6, int i7) {
        if (i5 < 0 || i5 > p() - i7 || i6 < 0 || i6 > bArr.length - i7) {
            return false;
        }
        int w5 = w(i5);
        while (i7 > 0) {
            int i8 = w5 == 0 ? 0 : this.f8311k[w5 - 1];
            int min = Math.min(i7, ((this.f8311k[w5] - i8) + i8) - i5);
            int[] iArr = this.f8311k;
            byte[][] bArr2 = this.f8310f;
            if (!p.a(bArr2[w5], (i5 - i8) + iArr[bArr2.length + w5], bArr, i6, min)) {
                return false;
            }
            i5 += min;
            i6 += min;
            i7 -= min;
            w5++;
        }
        return true;
    }

    @Override // w4.f
    public int p() {
        return this.f8311k[this.f8310f.length - 1];
    }

    @Override // w4.f
    public f r(int i5, int i6) {
        return x().r(i5, i6);
    }

    @Override // w4.f
    public f s() {
        return x().s();
    }

    @Override // w4.f
    public byte[] t() {
        int[] iArr = this.f8311k;
        byte[][] bArr = this.f8310f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr2 = this.f8311k;
            int i7 = iArr2[length + i5];
            int i8 = iArr2[i5];
            System.arraycopy(this.f8310f[i5], i7, bArr2, i6, i8 - i6);
            i5++;
            i6 = i8;
        }
        return bArr2;
    }

    @Override // w4.f
    public String toString() {
        return x().toString();
    }

    @Override // w4.f
    public String u() {
        return x().u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w4.f
    public void v(c cVar) {
        int length = this.f8310f.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr = this.f8311k;
            int i7 = iArr[length + i5];
            int i8 = iArr[i5];
            j jVar = new j(this.f8310f[i5], i7, (i7 + i8) - i6, true, false);
            j jVar2 = cVar.f8281a;
            if (jVar2 == null) {
                jVar.f8307g = jVar;
                jVar.f8306f = jVar;
                cVar.f8281a = jVar;
            } else {
                jVar2.f8307g.c(jVar);
            }
            i5++;
            i6 = i8;
        }
        cVar.f8282b += i6;
    }
}
