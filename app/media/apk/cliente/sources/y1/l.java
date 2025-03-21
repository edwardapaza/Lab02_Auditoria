package y1;

import y1.x0;
/* loaded from: classes.dex */
final class l extends x0.a {

    /* renamed from: a  reason: collision with root package name */
    private final n f8428a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8429b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8430c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8431d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8432e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(n nVar, boolean z4, int i5, int i6, int i7) {
        this.f8428a = nVar;
        this.f8429b = z4;
        this.f8430c = i5;
        this.f8431d = i6;
        this.f8432e = i7;
    }

    @Override // y1.x0.a
    boolean a() {
        return this.f8429b;
    }

    @Override // y1.x0.a
    int b() {
        return this.f8431d;
    }

    @Override // y1.x0.a
    n c() {
        return this.f8428a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x0.a) {
            x0.a aVar = (x0.a) obj;
            n nVar = this.f8428a;
            if (nVar != null ? nVar.equals(aVar.c()) : aVar.c() == null) {
                if (this.f8429b == aVar.a() && this.f8430c == aVar.f() && this.f8431d == aVar.b() && this.f8432e == aVar.g()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // y1.x0.a
    int f() {
        return this.f8430c;
    }

    @Override // y1.x0.a
    int g() {
        return this.f8432e;
    }

    public int hashCode() {
        n nVar = this.f8428a;
        return (((((((((nVar == null ? 0 : nVar.hashCode()) ^ 1000003) * 1000003) ^ (this.f8429b ? 1231 : 1237)) * 1000003) ^ this.f8430c) * 1000003) ^ this.f8431d) * 1000003) ^ this.f8432e;
    }

    public String toString() {
        return "ExistenceFilterBloomFilterInfo{bloomFilter=" + this.f8428a + ", applied=" + this.f8429b + ", hashCount=" + this.f8430c + ", bitmapLength=" + this.f8431d + ", padding=" + this.f8432e + "}";
    }
}
