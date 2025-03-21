package w1;

import v1.s;
import v1.w;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: c  reason: collision with root package name */
    public static final m f8253c = new m(null, null);

    /* renamed from: a  reason: collision with root package name */
    private final w f8254a;

    /* renamed from: b  reason: collision with root package name */
    private final Boolean f8255b;

    private m(w wVar, Boolean bool) {
        z1.b.d(wVar == null || bool == null, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
        this.f8254a = wVar;
        this.f8255b = bool;
    }

    public static m a(boolean z4) {
        return new m(null, Boolean.valueOf(z4));
    }

    public static m f(w wVar) {
        return new m(wVar, null);
    }

    public Boolean b() {
        return this.f8255b;
    }

    public w c() {
        return this.f8254a;
    }

    public boolean d() {
        return this.f8254a == null && this.f8255b == null;
    }

    public boolean e(s sVar) {
        if (this.f8254a != null) {
            return sVar.b() && sVar.j().equals(this.f8254a);
        }
        Boolean bool = this.f8255b;
        if (bool != null) {
            return bool.booleanValue() == sVar.b();
        }
        z1.b.d(d(), "Precondition should be empty", new Object[0]);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        w wVar = this.f8254a;
        if (wVar == null ? mVar.f8254a == null : wVar.equals(mVar.f8254a)) {
            Boolean bool = this.f8255b;
            Boolean bool2 = mVar.f8255b;
            return bool != null ? bool.equals(bool2) : bool2 == null;
        }
        return false;
    }

    public int hashCode() {
        w wVar = this.f8254a;
        int hashCode = (wVar != null ? wVar.hashCode() : 0) * 31;
        Boolean bool = this.f8255b;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        if (d()) {
            return "Precondition{<none>}";
        }
        if (this.f8254a != null) {
            sb = new StringBuilder();
            sb.append("Precondition{updateTime=");
            obj = this.f8254a;
        } else if (this.f8255b == null) {
            throw z1.b.a("Invalid Precondition", new Object[0]);
        } else {
            sb = new StringBuilder();
            sb.append("Precondition{exists=");
            obj = this.f8255b;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
