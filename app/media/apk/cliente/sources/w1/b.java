package w1;
/* loaded from: classes.dex */
final class b extends k {

    /* renamed from: a  reason: collision with root package name */
    private final int f8230a;

    /* renamed from: b  reason: collision with root package name */
    private final f f8231b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i5, f fVar) {
        this.f8230a = i5;
        if (fVar == null) {
            throw new NullPointerException("Null mutation");
        }
        this.f8231b = fVar;
    }

    @Override // w1.k
    public int c() {
        return this.f8230a;
    }

    @Override // w1.k
    public f d() {
        return this.f8231b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return this.f8230a == kVar.c() && this.f8231b.equals(kVar.d());
        }
        return false;
    }

    public int hashCode() {
        return ((this.f8230a ^ 1000003) * 1000003) ^ this.f8231b.hashCode();
    }

    public String toString() {
        return "Overlay{largestBatchId=" + this.f8230a + ", mutation=" + this.f8231b + "}";
    }
}
