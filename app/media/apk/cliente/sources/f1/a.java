package f1;
/* loaded from: classes.dex */
final class a extends p {

    /* renamed from: a  reason: collision with root package name */
    private final long f2967a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2968b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2969c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j5, long j6, long j7) {
        this.f2967a = j5;
        this.f2968b = j6;
        this.f2969c = j7;
    }

    @Override // f1.p
    public long b() {
        return this.f2968b;
    }

    @Override // f1.p
    public long c() {
        return this.f2967a;
    }

    @Override // f1.p
    public long d() {
        return this.f2969c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return this.f2967a == pVar.c() && this.f2968b == pVar.b() && this.f2969c == pVar.d();
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f2967a;
        long j6 = this.f2968b;
        long j7 = this.f2969c;
        return ((int) ((j7 >>> 32) ^ j7)) ^ ((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f2967a + ", elapsedRealtime=" + this.f2968b + ", uptimeMillis=" + this.f2969c + "}";
    }
}
