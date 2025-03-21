package m4;
/* loaded from: classes.dex */
final class y {

    /* renamed from: a  reason: collision with root package name */
    public final Object f6290a;

    /* renamed from: b  reason: collision with root package name */
    public final j f6291b;

    /* renamed from: c  reason: collision with root package name */
    public final d4.l<Throwable, s3.t> f6292c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f6293d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f6294e;

    /* JADX WARN: Multi-variable type inference failed */
    public y(Object obj, j jVar, d4.l<? super Throwable, s3.t> lVar, Object obj2, Throwable th) {
        this.f6290a = obj;
        this.f6291b = jVar;
        this.f6292c = lVar;
        this.f6293d = obj2;
        this.f6294e = th;
    }

    public /* synthetic */ y(Object obj, j jVar, d4.l lVar, Object obj2, Throwable th, int i5, e4.g gVar) {
        this(obj, (i5 & 2) != 0 ? null : jVar, (i5 & 4) != 0 ? null : lVar, (i5 & 8) != 0 ? null : obj2, (i5 & 16) != 0 ? null : th);
    }

    public static /* synthetic */ y b(y yVar, Object obj, j jVar, d4.l lVar, Object obj2, Throwable th, int i5, Object obj3) {
        if ((i5 & 1) != 0) {
            obj = yVar.f6290a;
        }
        if ((i5 & 2) != 0) {
            jVar = yVar.f6291b;
        }
        j jVar2 = jVar;
        d4.l<Throwable, s3.t> lVar2 = lVar;
        if ((i5 & 4) != 0) {
            lVar2 = yVar.f6292c;
        }
        d4.l lVar3 = lVar2;
        if ((i5 & 8) != 0) {
            obj2 = yVar.f6293d;
        }
        Object obj4 = obj2;
        if ((i5 & 16) != 0) {
            th = yVar.f6294e;
        }
        return yVar.a(obj, jVar2, lVar3, obj4, th);
    }

    public final y a(Object obj, j jVar, d4.l<? super Throwable, s3.t> lVar, Object obj2, Throwable th) {
        return new y(obj, jVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f6294e != null;
    }

    public final void d(m<?> mVar, Throwable th) {
        j jVar = this.f6291b;
        if (jVar != null) {
            mVar.l(jVar, th);
        }
        d4.l<Throwable, s3.t> lVar = this.f6292c;
        if (lVar != null) {
            mVar.m(lVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            return e4.k.a(this.f6290a, yVar.f6290a) && e4.k.a(this.f6291b, yVar.f6291b) && e4.k.a(this.f6292c, yVar.f6292c) && e4.k.a(this.f6293d, yVar.f6293d) && e4.k.a(this.f6294e, yVar.f6294e);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f6290a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        j jVar = this.f6291b;
        int hashCode2 = (hashCode + (jVar == null ? 0 : jVar.hashCode())) * 31;
        d4.l<Throwable, s3.t> lVar = this.f6292c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f6293d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f6294e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f6290a + ", cancelHandler=" + this.f6291b + ", onCancellation=" + this.f6292c + ", idempotentResume=" + this.f6293d + ", cancelCause=" + this.f6294e + ')';
    }
}
