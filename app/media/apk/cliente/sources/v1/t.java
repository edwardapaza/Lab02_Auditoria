package v1;

import i2.d0;
import i2.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class t implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private d0 f8151a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f8152b;

    public t() {
        this(d0.B0().N(i2.u.f0()).build());
    }

    public t(d0 d0Var) {
        this.f8152b = new HashMap();
        z1.b.d(d0Var.A0() == d0.c.MAP_VALUE, "ObjectValues should be backed by a MapValue", new Object[0]);
        z1.b.d(!v.c(d0Var), "ServerTimestamps should not be used as an ObjectValue", new Object[0]);
        this.f8151a = d0Var;
    }

    private i2.u a(r rVar, Map<String, Object> map) {
        d0 f5 = f(this.f8151a, rVar);
        u.b c5 = z.w(f5) ? f5.w0().c() : i2.u.n0();
        boolean z4 = false;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                i2.u a5 = a(rVar.a(key), (Map) value);
                if (a5 != null) {
                    c5.G(key, d0.B0().N(a5).build());
                    z4 = true;
                }
            } else {
                if (value instanceof d0) {
                    c5.G(key, (d0) value);
                } else if (c5.E(key)) {
                    z1.b.d(value == null, "Expected entry to be a Map, a Value or null", new Object[0]);
                    c5.H(key);
                }
                z4 = true;
            }
        }
        if (z4) {
            return c5.build();
        }
        return null;
    }

    private d0 b() {
        synchronized (this.f8152b) {
            i2.u a5 = a(r.f8135c, this.f8152b);
            if (a5 != null) {
                this.f8151a = d0.B0().N(a5).build();
                this.f8152b.clear();
            }
        }
        return this.f8151a;
    }

    private w1.d e(i2.u uVar) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, d0> entry : uVar.h0().entrySet()) {
            r v5 = r.v(entry.getKey());
            if (z.w(entry.getValue())) {
                Set<r> c5 = e(entry.getValue().w0()).c();
                if (!c5.isEmpty()) {
                    for (r rVar : c5) {
                        hashSet.add(v5.c(rVar));
                    }
                }
            }
            hashSet.add(v5);
        }
        return w1.d.b(hashSet);
    }

    private d0 f(d0 d0Var, r rVar) {
        if (rVar.n()) {
            return d0Var;
        }
        int i5 = 0;
        while (true) {
            int p5 = rVar.p() - 1;
            i2.u w02 = d0Var.w0();
            if (i5 >= p5) {
                return w02.i0(rVar.k(), null);
            }
            d0Var = w02.i0(rVar.m(i5), null);
            if (!z.w(d0Var)) {
                return null;
            }
            i5++;
        }
    }

    public static t j(Map<String, d0> map) {
        return new t(d0.B0().M(i2.u.n0().F(map)).build());
    }

    private void p(r rVar, d0 d0Var) {
        Object hashMap;
        HashMap hashMap2 = this.f8152b;
        for (int i5 = 0; i5 < rVar.p() - 1; i5++) {
            String m5 = rVar.m(i5);
            Object obj = hashMap2.get(m5);
            if (obj instanceof Map) {
                hashMap = (Map) obj;
            } else {
                if (obj instanceof d0) {
                    d0 d0Var2 = (d0) obj;
                    if (d0Var2.A0() == d0.c.MAP_VALUE) {
                        HashMap hashMap3 = new HashMap(d0Var2.w0().h0());
                        hashMap2.put(m5, hashMap3);
                        hashMap2 = hashMap3;
                    }
                }
                hashMap = new HashMap();
                hashMap2.put(m5, hashMap);
            }
            hashMap2 = hashMap;
        }
        hashMap2.put(rVar.k(), d0Var);
    }

    /* renamed from: c */
    public t clone() {
        return new t(b());
    }

    public void d(r rVar) {
        z1.b.d(!rVar.n(), "Cannot delete field for empty path on ObjectValue", new Object[0]);
        p(rVar, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t) {
            return z.q(b(), ((t) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public d0 k(r rVar) {
        return f(b(), rVar);
    }

    public w1.d l() {
        return e(b().w0());
    }

    public Map<String, d0> m() {
        return b().w0().h0();
    }

    public void n(r rVar, d0 d0Var) {
        z1.b.d(!rVar.n(), "Cannot set field for empty path on ObjectValue", new Object[0]);
        p(rVar, d0Var);
    }

    public void o(Map<r, d0> map) {
        for (Map.Entry<r, d0> entry : map.entrySet()) {
            r key = entry.getKey();
            if (entry.getValue() == null) {
                d(key);
            } else {
                n(key, entry.getValue());
            }
        }
    }

    public String toString() {
        return "ObjectValue{internalValue=" + z.b(b()) + '}';
    }
}
