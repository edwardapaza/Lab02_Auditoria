package s1;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import s1.p;
import s1.z0;
import v1.q;
/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a  reason: collision with root package name */
    private String f7321a;

    /* renamed from: b  reason: collision with root package name */
    private final List<z0> f7322b;

    /* renamed from: c  reason: collision with root package name */
    private final List<q> f7323c;

    /* renamed from: d  reason: collision with root package name */
    private final v1.u f7324d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7325e;

    /* renamed from: f  reason: collision with root package name */
    private final long f7326f;

    /* renamed from: g  reason: collision with root package name */
    private final i f7327g;

    /* renamed from: h  reason: collision with root package name */
    private final i f7328h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7329a;

        static {
            int[] iArr = new int[p.b.values().length];
            f7329a = iArr;
            try {
                iArr[p.b.ARRAY_CONTAINS_ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7329a[p.b.ARRAY_CONTAINS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7329a[p.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7329a[p.b.IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7329a[p.b.NOT_IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7329a[p.b.NOT_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7329a[p.b.LESS_THAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7329a[p.b.LESS_THAN_OR_EQUAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7329a[p.b.GREATER_THAN_OR_EQUAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7329a[p.b.GREATER_THAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public f1(v1.u uVar, String str, List<q> list, List<z0> list2, long j5, i iVar, i iVar2) {
        this.f7324d = uVar;
        this.f7325e = str;
        this.f7322b = list2;
        this.f7323c = list;
        this.f7326f = j5;
        this.f7327g = iVar;
        this.f7328h = iVar2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Pair<i2.d0, Boolean> b(q.c cVar, i iVar) {
        i2.d0 d0Var = v1.z.f8162c;
        Iterator<p> it = g(cVar.d()).iterator();
        boolean z4 = true;
        while (true) {
            int i5 = 0;
            boolean z5 = false;
            if (!it.hasNext()) {
                if (iVar != null) {
                    while (true) {
                        if (i5 < this.f7322b.size()) {
                            if (this.f7322b.get(i5).c().equals(cVar.d())) {
                                i2.d0 d0Var2 = iVar.b().get(i5);
                                if (v1.z.C(d0Var, z4, d0Var2, iVar.c()) < 0) {
                                    z4 = iVar.c();
                                    d0Var = d0Var2;
                                }
                            } else {
                                i5++;
                            }
                        }
                    }
                }
                return new Pair<>(d0Var, Boolean.valueOf(z4));
            }
            p next = it.next();
            i2.d0 d0Var3 = v1.z.f8162c;
            switch (a.f7329a[next.g().ordinal()]) {
                case 3:
                case 4:
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    d0Var3 = next.h();
                    z5 = true;
                    break;
                case 5:
                case 6:
                default:
                    z5 = true;
                    break;
                case 7:
                case 8:
                    d0Var3 = v1.z.r(next.h().A0());
                    z5 = true;
                    break;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    d0Var3 = next.h();
                    break;
            }
            if (v1.z.C(d0Var, z4, d0Var3, z5) < 0) {
                z4 = z5;
                d0Var = d0Var3;
            }
        }
    }

    private Pair<i2.d0, Boolean> e(q.c cVar, i iVar) {
        i2.d0 d0Var = v1.z.f8164e;
        Iterator<p> it = g(cVar.d()).iterator();
        boolean z4 = true;
        while (true) {
            int i5 = 0;
            r5 = false;
            boolean z5 = false;
            if (!it.hasNext()) {
                if (iVar != null) {
                    while (true) {
                        if (i5 < this.f7322b.size()) {
                            if (this.f7322b.get(i5).c().equals(cVar.d())) {
                                i2.d0 d0Var2 = iVar.b().get(i5);
                                if (v1.z.H(d0Var, z4, d0Var2, iVar.c()) > 0) {
                                    z4 = iVar.c();
                                    d0Var = d0Var2;
                                }
                            } else {
                                i5++;
                            }
                        }
                    }
                }
                return new Pair<>(d0Var, Boolean.valueOf(z4));
            }
            p next = it.next();
            i2.d0 d0Var3 = v1.z.f8164e;
            switch (a.f7329a[next.g().ordinal()]) {
                case 3:
                case 4:
                case 8:
                    d0Var3 = next.h();
                case 5:
                case 6:
                default:
                    z5 = true;
                    break;
                case 7:
                    d0Var3 = next.h();
                    break;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    d0Var3 = v1.z.s(next.h().A0());
                    break;
            }
            if (v1.z.H(d0Var, z4, d0Var3, z5) > 0) {
                z4 = z5;
                d0Var = d0Var3;
            }
        }
    }

    private List<p> g(v1.r rVar) {
        ArrayList arrayList = new ArrayList();
        for (q qVar : this.f7323c) {
            if (qVar instanceof p) {
                p pVar = (p) qVar;
                if (pVar.f().equals(rVar)) {
                    arrayList.add(pVar);
                }
            }
        }
        return arrayList;
    }

    public List<i2.d0> a(v1.q qVar) {
        q.c c5 = qVar.c();
        if (c5 == null) {
            return null;
        }
        for (p pVar : g(c5.d())) {
            int i5 = a.f7329a[pVar.g().ordinal()];
            if (i5 == 1) {
                return pVar.h().p0().e();
            }
            if (i5 == 2) {
                return Collections.singletonList(pVar.h());
            }
        }
        return null;
    }

    public String c() {
        String str = this.f7321a;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n().d());
        if (this.f7325e != null) {
            sb.append("|cg:");
            sb.append(this.f7325e);
        }
        sb.append("|f:");
        for (q qVar : h()) {
            sb.append(qVar.a());
        }
        sb.append("|ob:");
        for (z0 z0Var : m()) {
            sb.append(z0Var.c().d());
            sb.append(z0Var.b().equals(z0.a.ASCENDING) ? "asc" : "desc");
        }
        if (r()) {
            sb.append("|l:");
            sb.append(j());
        }
        if (this.f7327g != null) {
            sb.append("|lb:");
            sb.append(this.f7327g.c() ? "b:" : "a:");
            sb.append(this.f7327g.d());
        }
        if (this.f7328h != null) {
            sb.append("|ub:");
            sb.append(this.f7328h.c() ? "a:" : "b:");
            sb.append(this.f7328h.d());
        }
        String sb2 = sb.toString();
        this.f7321a = sb2;
        return sb2;
    }

    public String d() {
        return this.f7325e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f1.class != obj.getClass()) {
            return false;
        }
        f1 f1Var = (f1) obj;
        String str = this.f7325e;
        if (str == null ? f1Var.f7325e == null : str.equals(f1Var.f7325e)) {
            if (this.f7326f == f1Var.f7326f && this.f7322b.equals(f1Var.f7322b) && this.f7323c.equals(f1Var.f7323c) && this.f7324d.equals(f1Var.f7324d)) {
                i iVar = this.f7327g;
                if (iVar == null ? f1Var.f7327g == null : iVar.equals(f1Var.f7327g)) {
                    i iVar2 = this.f7328h;
                    i iVar3 = f1Var.f7328h;
                    return iVar2 != null ? iVar2.equals(iVar3) : iVar3 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public i f() {
        return this.f7328h;
    }

    public List<q> h() {
        return this.f7323c;
    }

    public int hashCode() {
        int hashCode = this.f7322b.hashCode() * 31;
        String str = this.f7325e;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j5 = this.f7326f;
        int hashCode3 = (((((((hashCode + hashCode2) * 31) + this.f7323c.hashCode()) * 31) + this.f7324d.hashCode()) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        i iVar = this.f7327g;
        int hashCode4 = (hashCode3 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        i iVar2 = this.f7328h;
        return hashCode4 + (iVar2 != null ? iVar2.hashCode() : 0);
    }

    public z0.a i() {
        List<z0> list = this.f7322b;
        return list.get(list.size() - 1).b();
    }

    public long j() {
        return this.f7326f;
    }

    public i k(v1.q qVar) {
        ArrayList arrayList = new ArrayList();
        boolean z4 = true;
        for (q.c cVar : qVar.e()) {
            Pair<i2.d0, Boolean> b5 = cVar.e().equals(q.c.a.ASCENDING) ? b(cVar, this.f7327g) : e(cVar, this.f7327g);
            arrayList.add((i2.d0) b5.first);
            z4 &= ((Boolean) b5.second).booleanValue();
        }
        return new i(arrayList, z4);
    }

    public Collection<i2.d0> l(v1.q qVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (q.c cVar : qVar.e()) {
            for (p pVar : g(cVar.d())) {
                int i5 = a.f7329a[pVar.g().ordinal()];
                if (i5 == 3 || i5 == 4) {
                    linkedHashMap.put(cVar.d(), pVar.h());
                } else if (i5 == 5 || i5 == 6) {
                    linkedHashMap.put(cVar.d(), pVar.h());
                    return linkedHashMap.values();
                }
            }
        }
        return null;
    }

    public List<z0> m() {
        return this.f7322b;
    }

    public v1.u n() {
        return this.f7324d;
    }

    public int o() {
        HashSet hashSet = new HashSet();
        int i5 = 0;
        for (q qVar : this.f7323c) {
            for (p pVar : qVar.c()) {
                if (!pVar.f().w()) {
                    if (pVar.g().equals(p.b.ARRAY_CONTAINS) || pVar.g().equals(p.b.ARRAY_CONTAINS_ANY)) {
                        i5 = 1;
                    } else {
                        hashSet.add(pVar.f());
                    }
                }
            }
        }
        for (z0 z0Var : this.f7322b) {
            if (!z0Var.c().w()) {
                hashSet.add(z0Var.c());
            }
        }
        return hashSet.size() + i5;
    }

    public i p() {
        return this.f7327g;
    }

    public i q(v1.q qVar) {
        ArrayList arrayList = new ArrayList();
        boolean z4 = true;
        for (q.c cVar : qVar.e()) {
            Pair<i2.d0, Boolean> e5 = cVar.e().equals(q.c.a.ASCENDING) ? e(cVar, this.f7328h) : b(cVar, this.f7328h);
            arrayList.add((i2.d0) e5.first);
            z4 &= ((Boolean) e5.second).booleanValue();
        }
        return new i(arrayList, z4);
    }

    public boolean r() {
        return this.f7326f != -1;
    }

    public boolean s() {
        return v1.l.s(this.f7324d) && this.f7325e == null && this.f7323c.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Query(");
        sb.append(this.f7324d.d());
        if (this.f7325e != null) {
            sb.append(" collectionGroup=");
            sb.append(this.f7325e);
        }
        if (!this.f7323c.isEmpty()) {
            sb.append(" where ");
            for (int i5 = 0; i5 < this.f7323c.size(); i5++) {
                if (i5 > 0) {
                    sb.append(" and ");
                }
                sb.append(this.f7323c.get(i5));
            }
        }
        if (!this.f7322b.isEmpty()) {
            sb.append(" order by ");
            for (int i6 = 0; i6 < this.f7322b.size(); i6++) {
                if (i6 > 0) {
                    sb.append(", ");
                }
                sb.append(this.f7322b.get(i6));
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
