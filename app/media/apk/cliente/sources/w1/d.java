package w1;

import java.util.HashSet;
import java.util.Set;
import v1.r;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f8232b = b(new HashSet());

    /* renamed from: a  reason: collision with root package name */
    private final Set<r> f8233a;

    private d(Set<r> set) {
        this.f8233a = set;
    }

    public static d b(Set<r> set) {
        return new d(set);
    }

    public boolean a(r rVar) {
        for (r rVar2 : this.f8233a) {
            if (rVar2.o(rVar)) {
                return true;
            }
        }
        return false;
    }

    public Set<r> c() {
        return this.f8233a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.f8233a.equals(((d) obj).f8233a);
    }

    public int hashCode() {
        return this.f8233a.hashCode();
    }

    public String toString() {
        return "FieldMask{mask=" + this.f8233a.toString() + "}";
    }
}
