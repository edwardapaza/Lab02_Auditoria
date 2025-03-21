package com.google.firebase.firestore;

import com.google.firebase.firestore.r;
import com.google.protobuf.u1;
import i2.b;
import i2.d0;
import i2.u;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s1.p1;
import s1.q1;
import s1.r1;
import s1.s1;
import s1.t1;
import w1.a;
/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a  reason: collision with root package name */
    private final v1.f f1718a;

    public i1(v1.f fVar) {
        this.f1718a = fVar;
    }

    private v1.t a(Object obj, q1 q1Var) {
        if (obj.getClass().isArray()) {
            throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was an array");
        }
        i2.d0 d5 = d(z1.o.c(obj), q1Var);
        if (d5.A0() == d0.c.MAP_VALUE) {
            return new v1.t(d5);
        }
        throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was of type: " + z1.h0.B(obj));
    }

    private List<i2.d0> c(List<Object> list) {
        p1 p1Var = new p1(t1.Argument);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            arrayList.add(b(list.get(i5), p1Var.f().c(i5)));
        }
        return arrayList;
    }

    private i2.d0 d(Object obj, q1 q1Var) {
        if (obj instanceof Map) {
            return f((Map) obj, q1Var);
        }
        if (obj instanceof r) {
            k((r) obj, q1Var);
            return null;
        }
        if (q1Var.h() != null) {
            q1Var.a(q1Var.h());
        }
        if (obj instanceof List) {
            if (!q1Var.i() || q1Var.g() == t1.ArrayArgument) {
                return e((List) obj, q1Var);
            }
            throw q1Var.f("Nested arrays are not supported");
        }
        return j(obj, q1Var);
    }

    private <T> i2.d0 e(List<T> list, q1 q1Var) {
        b.C0063b n02 = i2.b.n0();
        int i5 = 0;
        for (T t5 : list) {
            i2.d0 d5 = d(t5, q1Var.c(i5));
            if (d5 == null) {
                d5 = i2.d0.B0().O(com.google.protobuf.f1.NULL_VALUE).build();
            }
            n02.F(d5);
            i5++;
        }
        return i2.d0.B0().F(n02).build();
    }

    private <K, V> i2.d0 f(Map<K, V> map, q1 q1Var) {
        d0.b M;
        if (map.isEmpty()) {
            if (q1Var.h() != null && !q1Var.h().n()) {
                q1Var.a(q1Var.h());
            }
            M = i2.d0.B0().N(i2.u.f0());
        } else {
            u.b n02 = i2.u.n0();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (!(entry.getKey() instanceof String)) {
                    throw q1Var.f(String.format("Non-String Map key (%s) is not allowed", entry.getValue()));
                }
                String str = (String) entry.getKey();
                i2.d0 d5 = d(entry.getValue(), q1Var.d(str));
                if (d5 != null) {
                    n02.G(str, d5);
                }
            }
            M = i2.d0.B0().M(n02);
        }
        return M.build();
    }

    private i2.d0 j(Object obj, q1 q1Var) {
        if (obj == null) {
            return i2.d0.B0().O(com.google.protobuf.f1.NULL_VALUE).build();
        }
        if (obj instanceof Integer) {
            return i2.d0.B0().L(((Integer) obj).intValue()).build();
        }
        if (obj instanceof Long) {
            return i2.d0.B0().L(((Long) obj).longValue()).build();
        }
        if (obj instanceof Float) {
            return i2.d0.B0().J(((Float) obj).doubleValue()).build();
        }
        if (obj instanceof Double) {
            return i2.d0.B0().J(((Double) obj).doubleValue()).build();
        }
        if (obj instanceof Boolean) {
            return i2.d0.B0().H(((Boolean) obj).booleanValue()).build();
        }
        if (obj instanceof String) {
            return i2.d0.B0().Q((String) obj).build();
        }
        if (obj instanceof Date) {
            return m(new f1.q((Date) obj));
        }
        if (obj instanceof f1.q) {
            return m((f1.q) obj);
        }
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            return i2.d0.B0().K(m2.a.j0().E(d0Var.c()).F(d0Var.d())).build();
        } else if (obj instanceof f) {
            return i2.d0.B0().I(((f) obj).e()).build();
        } else {
            if (obj instanceof m) {
                m mVar = (m) obj;
                if (mVar.j() != null) {
                    v1.f t5 = mVar.j().t();
                    if (!t5.equals(this.f1718a)) {
                        throw q1Var.f(String.format("Document reference is for database %s/%s but should be for database %s/%s", t5.h(), t5.e(), this.f1718a.h(), this.f1718a.e()));
                    }
                }
                return i2.d0.B0().P(String.format("projects/%s/databases/%s/documents/%s", this.f1718a.h(), this.f1718a.e(), mVar.l())).build();
            } else if (obj.getClass().isArray()) {
                throw q1Var.f("Arrays are not supported; use a List instead");
            } else {
                throw q1Var.f("Unsupported type: " + z1.h0.B(obj));
            }
        }
    }

    private void k(r rVar, q1 q1Var) {
        w1.p jVar;
        v1.r h5;
        if (!q1Var.j()) {
            throw q1Var.f(String.format("%s() can only be used with set() and update()", rVar.d()));
        }
        if (q1Var.h() == null) {
            throw q1Var.f(String.format("%s() is not currently supported inside arrays", rVar.d()));
        }
        if (rVar instanceof r.c) {
            if (q1Var.g() == t1.MergeSet) {
                q1Var.a(q1Var.h());
                return;
            } else if (q1Var.g() != t1.Update) {
                throw q1Var.f("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
            } else {
                z1.b.d(q1Var.h().p() > 0, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
                throw q1Var.f("FieldValue.delete() can only appear at the top level of your update data");
            }
        }
        if (rVar instanceof r.e) {
            h5 = q1Var.h();
            jVar = w1.n.d();
        } else {
            if (rVar instanceof r.b) {
                jVar = new a.b(c(((r.b) rVar).h()));
            } else if (rVar instanceof r.a) {
                jVar = new a.C0124a(c(((r.a) rVar).h()));
            } else if (!(rVar instanceof r.d)) {
                throw z1.b.a("Unknown FieldValue type: %s", z1.h0.B(rVar));
            } else {
                jVar = new w1.j(h(((r.d) rVar).h()));
            }
            h5 = q1Var.h();
        }
        q1Var.b(h5, jVar);
    }

    private i2.d0 m(f1.q qVar) {
        return i2.d0.B0().R(u1.j0().F(qVar.n()).E((qVar.h() / 1000) * 1000)).build();
    }

    public i2.d0 b(Object obj, q1 q1Var) {
        return d(z1.o.c(obj), q1Var);
    }

    public r1 g(Object obj, w1.d dVar) {
        p1 p1Var = new p1(t1.MergeSet);
        v1.t a5 = a(obj, p1Var.f());
        if (dVar != null) {
            for (v1.r rVar : dVar.c()) {
                if (!p1Var.d(rVar)) {
                    throw new IllegalArgumentException("Field '" + rVar.toString() + "' is specified in your field mask but not in your input data.");
                }
            }
            return p1Var.h(a5, dVar);
        }
        return p1Var.g(a5);
    }

    public i2.d0 h(Object obj) {
        return i(obj, false);
    }

    public i2.d0 i(Object obj, boolean z4) {
        p1 p1Var = new p1(z4 ? t1.ArrayArgument : t1.Argument);
        i2.d0 b5 = b(obj, p1Var.f());
        z1.b.d(b5 != null, "Parsed data should not be null.", new Object[0]);
        z1.b.d(p1Var.e().isEmpty(), "Field transforms should have been disallowed.", new Object[0]);
        return b5;
    }

    public r1 l(Object obj) {
        p1 p1Var = new p1(t1.Set);
        return p1Var.i(a(obj, p1Var.f()));
    }

    public s1 n(List<Object> list) {
        z1.b.d(list.size() % 2 == 0, "Expected fieldAndValues to contain an even number of elements", new Object[0]);
        p1 p1Var = new p1(t1.Update);
        q1 f5 = p1Var.f();
        v1.t tVar = new v1.t();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Object next2 = it.next();
            boolean z4 = next instanceof String;
            z1.b.d(z4 || (next instanceof q), "Expected argument to be String or FieldPath.", new Object[0]);
            v1.r c5 = (z4 ? q.b((String) next) : (q) next).c();
            if (next2 instanceof r.c) {
                f5.a(c5);
            } else {
                i2.d0 b5 = b(next2, f5.e(c5));
                if (b5 != null) {
                    f5.a(c5);
                    tVar.n(c5, b5);
                }
            }
        }
        return p1Var.j(tVar);
    }

    public s1 o(Map<String, Object> map) {
        z1.y.c(map, "Provided update data must not be null.");
        p1 p1Var = new p1(t1.Update);
        q1 f5 = p1Var.f();
        v1.t tVar = new v1.t();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            v1.r c5 = q.b(entry.getKey()).c();
            Object value = entry.getValue();
            if (value instanceof r.c) {
                f5.a(c5);
            } else {
                i2.d0 b5 = b(value, f5.e(c5));
                if (b5 != null) {
                    f5.a(c5);
                    tVar.n(c5, b5);
                }
            }
        }
        return p1Var.j(tVar);
    }
}
