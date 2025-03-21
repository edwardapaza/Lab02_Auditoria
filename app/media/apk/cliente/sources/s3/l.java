package s3;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class l<A, B> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final A f7563a;

    /* renamed from: b  reason: collision with root package name */
    private final B f7564b;

    public l(A a5, B b5) {
        this.f7563a = a5;
        this.f7564b = b5;
    }

    public final A a() {
        return this.f7563a;
    }

    public final B b() {
        return this.f7564b;
    }

    public final A c() {
        return this.f7563a;
    }

    public final B d() {
        return this.f7564b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return e4.k.a(this.f7563a, lVar.f7563a) && e4.k.a(this.f7564b, lVar.f7564b);
        }
        return false;
    }

    public int hashCode() {
        A a5 = this.f7563a;
        int hashCode = (a5 == null ? 0 : a5.hashCode()) * 31;
        B b5 = this.f7564b;
        return hashCode + (b5 != null ? b5.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f7563a + ", " + this.f7564b + ')';
    }
}
