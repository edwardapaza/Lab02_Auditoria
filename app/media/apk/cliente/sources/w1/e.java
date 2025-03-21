package w1;

import v1.r;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final r f8234a;

    /* renamed from: b  reason: collision with root package name */
    private final p f8235b;

    public e(r rVar, p pVar) {
        this.f8234a = rVar;
        this.f8235b = pVar;
    }

    public r a() {
        return this.f8234a;
    }

    public p b() {
        return this.f8235b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f8234a.equals(eVar.f8234a)) {
            return this.f8235b.equals(eVar.f8235b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f8234a.hashCode() * 31) + this.f8235b.hashCode();
    }
}
