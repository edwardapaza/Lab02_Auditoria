package r1;

import v1.l;
import v1.s;
/* loaded from: classes.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private s f7129a;

    public b(s sVar) {
        this.f7129a = sVar;
    }

    public s a() {
        return this.f7129a;
    }

    public l b() {
        return this.f7129a.getKey();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f7129a.equals(((b) obj).f7129a);
    }

    public int hashCode() {
        return this.f7129a.hashCode();
    }
}
