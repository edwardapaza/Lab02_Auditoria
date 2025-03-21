package v1;

import v1.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends q.c {

    /* renamed from: a  reason: collision with root package name */
    private final r f8112a;

    /* renamed from: b  reason: collision with root package name */
    private final q.c.a f8113b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(r rVar, q.c.a aVar) {
        if (rVar == null) {
            throw new NullPointerException("Null fieldPath");
        }
        this.f8112a = rVar;
        if (aVar == null) {
            throw new NullPointerException("Null kind");
        }
        this.f8113b = aVar;
    }

    @Override // v1.q.c
    public r d() {
        return this.f8112a;
    }

    @Override // v1.q.c
    public q.c.a e() {
        return this.f8113b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q.c) {
            q.c cVar = (q.c) obj;
            return this.f8112a.equals(cVar.d()) && this.f8113b.equals(cVar.e());
        }
        return false;
    }

    public int hashCode() {
        return ((this.f8112a.hashCode() ^ 1000003) * 1000003) ^ this.f8113b.hashCode();
    }

    public String toString() {
        return "Segment{fieldPath=" + this.f8112a + ", kind=" + this.f8113b + "}";
    }
}
