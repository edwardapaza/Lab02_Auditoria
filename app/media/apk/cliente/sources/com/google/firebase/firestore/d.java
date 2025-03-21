package com.google.firebase.firestore;

import com.google.firebase.firestore.a;
import com.google.firebase.firestore.n;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final c f1680a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, i2.d0> f1681b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Map<String, i2.d0> map) {
        z1.y.b(cVar);
        this.f1680a = cVar;
        this.f1681b = map;
    }

    private <T> T a(Object obj, a aVar, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new RuntimeException("AggregateField '" + aVar.c() + "' is not a " + cls.getName());
    }

    private Object g(a aVar) {
        if (this.f1681b.containsKey(aVar.c())) {
            return new j1(this.f1680a.c().f1787b, n.a.f1753d).f(this.f1681b.get(aVar.c()));
        }
        throw new IllegalArgumentException("'" + aVar.e() + "(" + aVar.d() + ")' was not requested in the aggregation query.");
    }

    private <T> T i(a aVar, Class<T> cls) {
        return (T) a(g(aVar), aVar, cls);
    }

    public long b(a.c cVar) {
        Long h5 = h(cVar);
        if (h5 != null) {
            return h5.longValue();
        }
        throw new IllegalArgumentException("RunAggregationQueryResponse alias " + cVar.c() + " is null");
    }

    public Double c(a.b bVar) {
        return f(bVar);
    }

    public Object d(a aVar) {
        return g(aVar);
    }

    public long e() {
        return b(a.b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f1680a.equals(dVar.f1680a) && this.f1681b.equals(dVar.f1681b);
        }
        return false;
    }

    public Double f(a aVar) {
        Number number = (Number) i(aVar, Number.class);
        if (number != null) {
            return Double.valueOf(number.doubleValue());
        }
        return null;
    }

    public Long h(a aVar) {
        Number number = (Number) i(aVar, Number.class);
        if (number != null) {
            return Long.valueOf(number.longValue());
        }
        return null;
    }

    public int hashCode() {
        return Objects.hash(this.f1680a, this.f1681b);
    }
}
