package v1;

import v1.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends q.b {

    /* renamed from: a  reason: collision with root package name */
    private final long f8110a;

    /* renamed from: b  reason: collision with root package name */
    private final q.a f8111b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(long j5, q.a aVar) {
        this.f8110a = j5;
        if (aVar == null) {
            throw new NullPointerException("Null offset");
        }
        this.f8111b = aVar;
    }

    @Override // v1.q.b
    public q.a c() {
        return this.f8111b;
    }

    @Override // v1.q.b
    public long d() {
        return this.f8110a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q.b) {
            q.b bVar = (q.b) obj;
            return this.f8110a == bVar.d() && this.f8111b.equals(bVar.c());
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f8110a;
        return this.f8111b.hashCode() ^ ((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003);
    }

    public String toString() {
        return "IndexState{sequenceNumber=" + this.f8110a + ", offset=" + this.f8111b + "}";
    }
}
