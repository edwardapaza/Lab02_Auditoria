package t1;

import java.util.Arrays;
import v1.l;
/* loaded from: classes.dex */
final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final int f7589a;

    /* renamed from: b  reason: collision with root package name */
    private final l f7590b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f7591c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f7592d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i5, l lVar, byte[] bArr, byte[] bArr2) {
        this.f7589a = i5;
        if (lVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f7590b = lVar;
        if (bArr == null) {
            throw new NullPointerException("Null arrayValue");
        }
        this.f7591c = bArr;
        if (bArr2 == null) {
            throw new NullPointerException("Null directionalValue");
        }
        this.f7592d = bArr2;
    }

    @Override // t1.e
    public byte[] d() {
        return this.f7591c;
    }

    @Override // t1.e
    public byte[] e() {
        return this.f7592d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f7589a == eVar.k() && this.f7590b.equals(eVar.h())) {
                boolean z4 = eVar instanceof a;
                if (Arrays.equals(this.f7591c, z4 ? ((a) eVar).f7591c : eVar.d())) {
                    if (Arrays.equals(this.f7592d, z4 ? ((a) eVar).f7592d : eVar.e())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override // t1.e
    public l h() {
        return this.f7590b;
    }

    public int hashCode() {
        return ((((((this.f7589a ^ 1000003) * 1000003) ^ this.f7590b.hashCode()) * 1000003) ^ Arrays.hashCode(this.f7591c)) * 1000003) ^ Arrays.hashCode(this.f7592d);
    }

    @Override // t1.e
    public int k() {
        return this.f7589a;
    }

    public String toString() {
        return "IndexEntry{indexId=" + this.f7589a + ", documentKey=" + this.f7590b + ", arrayValue=" + Arrays.toString(this.f7591c) + ", directionalValue=" + Arrays.toString(this.f7592d) + "}";
    }
}
