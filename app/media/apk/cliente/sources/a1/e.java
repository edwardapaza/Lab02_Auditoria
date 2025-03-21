package a1;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes.dex */
final class e<T> extends r<T> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final Comparator<T> f11a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Comparator<T> comparator) {
        this.f11a = (Comparator) z0.k.n(comparator);
    }

    @Override // a1.r, java.util.Comparator
    public int compare(T t5, T t6) {
        return this.f11a.compare(t5, t6);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return this.f11a.equals(((e) obj).f11a);
        }
        return false;
    }

    public int hashCode() {
        return this.f11a.hashCode();
    }

    public String toString() {
        return this.f11a.toString();
    }
}
