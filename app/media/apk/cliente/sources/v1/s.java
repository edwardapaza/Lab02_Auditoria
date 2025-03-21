package v1;

import i2.d0;
/* loaded from: classes.dex */
public final class s implements i {

    /* renamed from: b  reason: collision with root package name */
    private final l f8136b;

    /* renamed from: c  reason: collision with root package name */
    private b f8137c;

    /* renamed from: d  reason: collision with root package name */
    private w f8138d;

    /* renamed from: e  reason: collision with root package name */
    private w f8139e;

    /* renamed from: f  reason: collision with root package name */
    private t f8140f;

    /* renamed from: g  reason: collision with root package name */
    private a f8141g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum a {
        HAS_LOCAL_MUTATIONS,
        HAS_COMMITTED_MUTATIONS,
        SYNCED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        INVALID,
        FOUND_DOCUMENT,
        NO_DOCUMENT,
        UNKNOWN_DOCUMENT
    }

    private s(l lVar) {
        this.f8136b = lVar;
        this.f8139e = w.f8154b;
    }

    private s(l lVar, b bVar, w wVar, w wVar2, t tVar, a aVar) {
        this.f8136b = lVar;
        this.f8138d = wVar;
        this.f8139e = wVar2;
        this.f8137c = bVar;
        this.f8141g = aVar;
        this.f8140f = tVar;
    }

    public static s p(l lVar, w wVar, t tVar) {
        return new s(lVar).l(wVar, tVar);
    }

    public static s q(l lVar) {
        b bVar = b.INVALID;
        w wVar = w.f8154b;
        return new s(lVar, bVar, wVar, wVar, new t(), a.SYNCED);
    }

    public static s r(l lVar, w wVar) {
        return new s(lVar).m(wVar);
    }

    public static s s(l lVar, w wVar) {
        return new s(lVar).n(wVar);
    }

    @Override // v1.i
    public s a() {
        return new s(this.f8136b, this.f8137c, this.f8138d, this.f8139e, this.f8140f.clone(), this.f8141g);
    }

    @Override // v1.i
    public boolean b() {
        return this.f8137c.equals(b.FOUND_DOCUMENT);
    }

    @Override // v1.i
    public boolean c() {
        return this.f8141g.equals(a.HAS_COMMITTED_MUTATIONS);
    }

    @Override // v1.i
    public boolean d() {
        return this.f8141g.equals(a.HAS_LOCAL_MUTATIONS);
    }

    @Override // v1.i
    public d0 e(r rVar) {
        return k().k(rVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.f8136b.equals(sVar.f8136b) && this.f8138d.equals(sVar.f8138d) && this.f8137c.equals(sVar.f8137c) && this.f8141g.equals(sVar.f8141g)) {
            return this.f8140f.equals(sVar.f8140f);
        }
        return false;
    }

    @Override // v1.i
    public boolean f() {
        return d() || c();
    }

    @Override // v1.i
    public w g() {
        return this.f8139e;
    }

    @Override // v1.i
    public l getKey() {
        return this.f8136b;
    }

    @Override // v1.i
    public boolean h() {
        return this.f8137c.equals(b.NO_DOCUMENT);
    }

    public int hashCode() {
        return this.f8136b.hashCode();
    }

    @Override // v1.i
    public boolean i() {
        return this.f8137c.equals(b.UNKNOWN_DOCUMENT);
    }

    @Override // v1.i
    public w j() {
        return this.f8138d;
    }

    @Override // v1.i
    public t k() {
        return this.f8140f;
    }

    public s l(w wVar, t tVar) {
        this.f8138d = wVar;
        this.f8137c = b.FOUND_DOCUMENT;
        this.f8140f = tVar;
        this.f8141g = a.SYNCED;
        return this;
    }

    public s m(w wVar) {
        this.f8138d = wVar;
        this.f8137c = b.NO_DOCUMENT;
        this.f8140f = new t();
        this.f8141g = a.SYNCED;
        return this;
    }

    public s n(w wVar) {
        this.f8138d = wVar;
        this.f8137c = b.UNKNOWN_DOCUMENT;
        this.f8140f = new t();
        this.f8141g = a.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public boolean o() {
        return !this.f8137c.equals(b.INVALID);
    }

    public s t() {
        this.f8141g = a.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public String toString() {
        return "Document{key=" + this.f8136b + ", version=" + this.f8138d + ", readTime=" + this.f8139e + ", type=" + this.f8137c + ", documentState=" + this.f8141g + ", value=" + this.f8140f + '}';
    }

    public s u() {
        this.f8141g = a.HAS_LOCAL_MUTATIONS;
        this.f8138d = w.f8154b;
        return this;
    }

    public s v(w wVar) {
        this.f8139e = wVar;
        return this;
    }
}
