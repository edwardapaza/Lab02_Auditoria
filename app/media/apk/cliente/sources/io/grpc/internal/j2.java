package io.grpc.internal;

import i3.a1;
import i3.j1;
import io.grpc.internal.b2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class j2 {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f4962a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, ?> f4963b;

        public a(String str, Map<String, ?> map) {
            this.f4962a = (String) z0.k.o(str, "policyName");
            this.f4963b = (Map) z0.k.o(map, "rawConfigValue");
        }

        public String a() {
            return this.f4962a;
        }

        public Map<String, ?> b() {
            return this.f4963b;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f4962a.equals(aVar.f4962a) && this.f4963b.equals(aVar.f4963b);
            }
            return false;
        }

        public int hashCode() {
            return z0.g.b(this.f4962a, this.f4963b);
        }

        public String toString() {
            return z0.f.b(this).d("policyName", this.f4962a).d("rawConfigValue", this.f4963b).toString();
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final i3.s0 f4964a;

        /* renamed from: b  reason: collision with root package name */
        final Object f4965b;

        public b(i3.s0 s0Var, Object obj) {
            this.f4964a = (i3.s0) z0.k.o(s0Var, "provider");
            this.f4965b = obj;
        }

        public Object a() {
            return this.f4965b;
        }

        public i3.s0 b() {
            return this.f4964a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return z0.g.a(this.f4964a, bVar.f4964a) && z0.g.a(this.f4965b, bVar.f4965b);
        }

        public int hashCode() {
            return z0.g.b(this.f4964a, this.f4965b);
        }

        public String toString() {
            return z0.f.b(this).d("provider", this.f4964a).d("config", this.f4965b).toString();
        }
    }

    private j2() {
    }

    public static List<a> A(List<Map<String, ?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, ?> map : list) {
            arrayList.add(z(map));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Double a(Map<String, ?> map) {
        return d1.h(map, "backoffMultiplier");
    }

    public static Map<String, ?> b(Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        return d1.j(map, "healthCheckConfig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Long c(Map<String, ?> map) {
        return d1.l(map, "hedgingDelay");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, ?> d(Map<String, ?> map) {
        return d1.j(map, "hedgingPolicy");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Long e(Map<String, ?> map) {
        return d1.l(map, "initialBackoff");
    }

    private static Set<j1.b> f(Map<String, ?> map, String str) {
        List<?> e5 = d1.e(map, str);
        if (e5 == null) {
            return null;
        }
        return u(e5);
    }

    public static List<Map<String, ?>> g(Map<String, ?> map) {
        String k5;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(d1.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (k5 = d1.k(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(k5.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Integer h(Map<String, ?> map) {
        return d1.i(map, "maxAttempts");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Integer i(Map<String, ?> map) {
        return d1.i(map, "maxAttempts");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Long j(Map<String, ?> map) {
        return d1.l(map, "maxBackoff");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Integer k(Map<String, ?> map) {
        return d1.i(map, "maxRequestMessageBytes");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Integer l(Map<String, ?> map) {
        return d1.i(map, "maxResponseMessageBytes");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Map<String, ?>> m(Map<String, ?> map) {
        return d1.f(map, "methodConfig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n(Map<String, ?> map) {
        return d1.k(map, "method");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Map<String, ?>> o(Map<String, ?> map) {
        return d1.f(map, "name");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<j1.b> p(Map<String, ?> map) {
        Set<j1.b> f5 = f(map, "nonFatalStatusCodes");
        if (f5 == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(j1.b.class));
        }
        z0.r.a(!f5.contains(j1.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return f5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Long q(Map<String, ?> map) {
        return d1.l(map, "perAttemptRecvTimeout");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, ?> r(Map<String, ?> map) {
        return d1.j(map, "retryPolicy");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<j1.b> s(Map<String, ?> map) {
        Set<j1.b> f5 = f(map, "retryableStatusCodes");
        z0.r.a(f5 != null, "%s is required in retry policy", "retryableStatusCodes");
        z0.r.a(true ^ f5.contains(j1.b.OK), "%s must not contain OK", "retryableStatusCodes");
        return f5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String t(Map<String, ?> map) {
        return d1.k(map, "service");
    }

    private static Set<j1.b> u(List<?> list) {
        j1.b valueOf;
        EnumSet noneOf = EnumSet.noneOf(j1.b.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d5 = (Double) obj;
                int intValue = d5.intValue();
                z0.r.a(((double) intValue) == d5.doubleValue(), "Status code %s is not integral", obj);
                valueOf = i3.j1.h(intValue).m();
                z0.r.a(valueOf.d() == d5.intValue(), "Status code %s is not valid", obj);
            } else if (!(obj instanceof String)) {
                throw new z0.s("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
            } else {
                try {
                    valueOf = j1.b.valueOf((String) obj);
                } catch (IllegalArgumentException e5) {
                    throw new z0.s("Status code " + obj + " is not valid", e5);
                }
            }
            noneOf.add(valueOf);
        }
        return Collections.unmodifiableSet(noneOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b2.d0 v(Map<String, ?> map) {
        Map<String, ?> j5;
        if (map == null || (j5 = d1.j(map, "retryThrottling")) == null) {
            return null;
        }
        float floatValue = d1.h(j5, "maxTokens").floatValue();
        float floatValue2 = d1.h(j5, "tokenRatio").floatValue();
        z0.k.u(floatValue > 0.0f, "maxToken should be greater than zero");
        z0.k.u(floatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new b2.d0(floatValue, floatValue2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Long w(Map<String, ?> map) {
        return d1.l(map, "timeout");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean x(Map<String, ?> map) {
        return d1.d(map, "waitForReady");
    }

    public static a1.c y(List<a> list, i3.t0 t0Var) {
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            String a5 = aVar.a();
            i3.s0 d5 = t0Var.d(a5);
            if (d5 != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(j2.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                a1.c e5 = d5.e(aVar.b());
                return e5.d() != null ? e5 : a1.c.a(new b(d5, e5.c()));
            }
            arrayList.add(a5);
        }
        i3.j1 j1Var = i3.j1.f3434h;
        return a1.c.b(j1Var.q("None of " + arrayList + " specified by Service Config are available."));
    }

    public static a z(Map<String, ?> map) {
        if (map.size() == 1) {
            String key = map.entrySet().iterator().next().getKey();
            return new a(key, d1.j(map, key));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }
}
