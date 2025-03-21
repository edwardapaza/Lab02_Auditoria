package m4;
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f6176a;

    /* renamed from: b  reason: collision with root package name */
    public final d4.l<Throwable, s3.t> f6177b;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(Object obj, d4.l<? super Throwable, s3.t> lVar) {
        this.f6176a = obj;
        this.f6177b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            return e4.k.a(this.f6176a, a0Var.f6176a) && e4.k.a(this.f6177b, a0Var.f6177b);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f6176a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f6177b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f6176a + ", onCancellation=" + this.f6177b + ')';
    }
}
