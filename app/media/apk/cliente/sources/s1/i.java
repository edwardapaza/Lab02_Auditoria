package s1;

import java.util.List;
import s1.z0;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f7339a;

    /* renamed from: b  reason: collision with root package name */
    private final List<i2.d0> f7340b;

    public i(List<i2.d0> list, boolean z4) {
        this.f7340b = list;
        this.f7339a = z4;
    }

    private int a(List<z0> list, v1.i iVar) {
        int i5;
        z1.b.d(this.f7340b.size() <= list.size(), "Bound has more components than query's orderBy", new Object[0]);
        int i6 = 0;
        for (int i7 = 0; i7 < this.f7340b.size(); i7++) {
            z0 z0Var = list.get(i7);
            i2.d0 d0Var = this.f7340b.get(i7);
            if (z0Var.f7544b.equals(v1.r.f8134b)) {
                z1.b.d(v1.z.B(d0Var), "Bound has a non-key value where the key path is being used %s", d0Var);
                i5 = v1.l.h(d0Var.x0()).compareTo(iVar.getKey());
            } else {
                i2.d0 e5 = iVar.e(z0Var.c());
                z1.b.d(e5 != null, "Field should exist since document matched the orderBy already.", new Object[0]);
                i5 = v1.z.i(d0Var, e5);
            }
            if (z0Var.b().equals(z0.a.DESCENDING)) {
                i5 *= -1;
            }
            i6 = i5;
            if (i6 != 0) {
                break;
            }
        }
        return i6;
    }

    public List<i2.d0> b() {
        return this.f7340b;
    }

    public boolean c() {
        return this.f7339a;
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        boolean z4 = true;
        for (i2.d0 d0Var : this.f7340b) {
            if (!z4) {
                sb.append(",");
            }
            z4 = false;
            sb.append(v1.z.b(d0Var));
        }
        return sb.toString();
    }

    public boolean e(List<z0> list, v1.i iVar) {
        int a5 = a(list, iVar);
        if (this.f7339a) {
            if (a5 >= 0) {
                return true;
            }
        } else if (a5 > 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f7339a == iVar.f7339a && this.f7340b.equals(iVar.f7340b);
    }

    public boolean f(List<z0> list, v1.i iVar) {
        int a5 = a(list, iVar);
        if (this.f7339a) {
            if (a5 <= 0) {
                return true;
            }
        } else if (a5 < 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f7339a ? 1 : 0) * 31) + this.f7340b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bound(inclusive=");
        sb.append(this.f7339a);
        sb.append(", position=");
        for (int i5 = 0; i5 < this.f7340b.size(); i5++) {
            if (i5 > 0) {
                sb.append(" and ");
            }
            sb.append(v1.z.b(this.f7340b.get(i5)));
        }
        sb.append(")");
        return sb.toString();
    }
}
