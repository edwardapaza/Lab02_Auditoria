package v1;

import v1.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends q.a {

    /* renamed from: c  reason: collision with root package name */
    private final w f8107c;

    /* renamed from: d  reason: collision with root package name */
    private final l f8108d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8109e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(w wVar, l lVar, int i5) {
        if (wVar == null) {
            throw new NullPointerException("Null readTime");
        }
        this.f8107c = wVar;
        if (lVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f8108d = lVar;
        this.f8109e = i5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q.a) {
            q.a aVar = (q.a) obj;
            return this.f8107c.equals(aVar.n()) && this.f8108d.equals(aVar.k()) && this.f8109e == aVar.m();
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f8107c.hashCode() ^ 1000003) * 1000003) ^ this.f8108d.hashCode()) * 1000003) ^ this.f8109e;
    }

    @Override // v1.q.a
    public l k() {
        return this.f8108d;
    }

    @Override // v1.q.a
    public int m() {
        return this.f8109e;
    }

    @Override // v1.q.a
    public w n() {
        return this.f8107c;
    }

    public String toString() {
        return "IndexOffset{readTime=" + this.f8107c + ", documentKey=" + this.f8108d + ", largestBatchId=" + this.f8109e + "}";
    }
}
