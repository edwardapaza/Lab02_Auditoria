package y1;

import y1.x0;
/* loaded from: classes.dex */
final class m extends x0.b {

    /* renamed from: a  reason: collision with root package name */
    private final int f8434a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8435b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8436c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8437d;

    /* renamed from: e  reason: collision with root package name */
    private final x0.a f8438e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i5, int i6, String str, String str2, x0.a aVar) {
        this.f8434a = i5;
        this.f8435b = i6;
        if (str == null) {
            throw new NullPointerException("Null projectId");
        }
        this.f8436c = str;
        if (str2 == null) {
            throw new NullPointerException("Null databaseId");
        }
        this.f8437d = str2;
        this.f8438e = aVar;
    }

    @Override // y1.x0.b
    x0.a a() {
        return this.f8438e;
    }

    @Override // y1.x0.b
    String c() {
        return this.f8437d;
    }

    @Override // y1.x0.b
    int d() {
        return this.f8435b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x0.b) {
            x0.b bVar = (x0.b) obj;
            if (this.f8434a == bVar.f() && this.f8435b == bVar.d() && this.f8436c.equals(bVar.g()) && this.f8437d.equals(bVar.c())) {
                x0.a aVar = this.f8438e;
                x0.a a5 = bVar.a();
                if (aVar == null) {
                    if (a5 == null) {
                        return true;
                    }
                } else if (aVar.equals(a5)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // y1.x0.b
    int f() {
        return this.f8434a;
    }

    @Override // y1.x0.b
    String g() {
        return this.f8436c;
    }

    public int hashCode() {
        int hashCode = (((((((this.f8434a ^ 1000003) * 1000003) ^ this.f8435b) * 1000003) ^ this.f8436c.hashCode()) * 1000003) ^ this.f8437d.hashCode()) * 1000003;
        x0.a aVar = this.f8438e;
        return hashCode ^ (aVar == null ? 0 : aVar.hashCode());
    }

    public String toString() {
        return "ExistenceFilterMismatchInfo{localCacheCount=" + this.f8434a + ", existenceFilterCount=" + this.f8435b + ", projectId=" + this.f8436c + ", databaseId=" + this.f8437d + ", bloomFilter=" + this.f8438e + "}";
    }
}
