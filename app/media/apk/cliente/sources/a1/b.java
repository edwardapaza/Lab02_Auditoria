package a1;

import java.io.Serializable;
/* loaded from: classes.dex */
final class b<F, T> extends r<F> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final z0.d<F, ? extends T> f9a;

    /* renamed from: b  reason: collision with root package name */
    final r<T> f10b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(z0.d<F, ? extends T> dVar, r<T> rVar) {
        this.f9a = (z0.d) z0.k.n(dVar);
        this.f10b = (r) z0.k.n(rVar);
    }

    @Override // a1.r, java.util.Comparator
    public int compare(F f5, F f6) {
        return this.f10b.compare(this.f9a.apply(f5), this.f9a.apply(f6));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f9a.equals(bVar.f9a) && this.f10b.equals(bVar.f10b);
        }
        return false;
    }

    public int hashCode() {
        return z0.g.b(this.f9a, this.f10b);
    }

    public String toString() {
        return this.f10b + ".onResultOf(" + this.f9a + ")";
    }
}
