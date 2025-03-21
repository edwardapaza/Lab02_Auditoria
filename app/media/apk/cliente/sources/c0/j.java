package c0;

import java.util.List;
import t3.x;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f824a;

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends a> list) {
        e4.k.e(list, "displayFeatures");
        this.f824a = list;
    }

    public final List<a> a() {
        return this.f824a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !e4.k.a(j.class, obj.getClass())) {
            return false;
        }
        return e4.k.a(this.f824a, ((j) obj).f824a);
    }

    public int hashCode() {
        return this.f824a.hashCode();
    }

    public String toString() {
        String w5;
        w5 = x.w(this.f824a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
        return w5;
    }
}
