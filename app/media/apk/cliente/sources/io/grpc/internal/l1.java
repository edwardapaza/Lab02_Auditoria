package io.grpc.internal;

import i3.c;
import i3.f0;
import i3.j1;
import i3.r0;
import io.grpc.internal.b2;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: a  reason: collision with root package name */
    private final b f4989a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, b> f4990b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, b> f4991c;

    /* renamed from: d  reason: collision with root package name */
    private final b2.d0 f4992d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f4993e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, ?> f4994f;

    /* loaded from: classes.dex */
    static final class b {

        /* renamed from: g  reason: collision with root package name */
        static final c.C0069c<b> f4995g = c.C0069c.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

        /* renamed from: a  reason: collision with root package name */
        final Long f4996a;

        /* renamed from: b  reason: collision with root package name */
        final Boolean f4997b;

        /* renamed from: c  reason: collision with root package name */
        final Integer f4998c;

        /* renamed from: d  reason: collision with root package name */
        final Integer f4999d;

        /* renamed from: e  reason: collision with root package name */
        final c2 f5000e;

        /* renamed from: f  reason: collision with root package name */
        final v0 f5001f;

        b(Map<String, ?> map, boolean z4, int i5, int i6) {
            this.f4996a = j2.w(map);
            this.f4997b = j2.x(map);
            Integer l5 = j2.l(map);
            this.f4998c = l5;
            if (l5 != null) {
                z0.k.j(l5.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", l5);
            }
            Integer k5 = j2.k(map);
            this.f4999d = k5;
            if (k5 != null) {
                z0.k.j(k5.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", k5);
            }
            Map<String, ?> r5 = z4 ? j2.r(map) : null;
            this.f5000e = r5 == null ? null : b(r5, i5);
            Map<String, ?> d5 = z4 ? j2.d(map) : null;
            this.f5001f = d5 != null ? a(d5, i6) : null;
        }

        private static v0 a(Map<String, ?> map, int i5) {
            int intValue = ((Integer) z0.k.o(j2.h(map), "maxAttempts cannot be empty")).intValue();
            z0.k.h(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i5);
            long longValue = ((Long) z0.k.o(j2.c(map), "hedgingDelay cannot be empty")).longValue();
            z0.k.i(longValue >= 0, "hedgingDelay must not be negative: %s", longValue);
            return new v0(min, longValue, j2.p(map));
        }

        private static c2 b(Map<String, ?> map, int i5) {
            int intValue = ((Integer) z0.k.o(j2.i(map), "maxAttempts cannot be empty")).intValue();
            boolean z4 = true;
            z0.k.h(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i5);
            long longValue = ((Long) z0.k.o(j2.e(map), "initialBackoff cannot be empty")).longValue();
            z0.k.i(longValue > 0, "initialBackoffNanos must be greater than 0: %s", longValue);
            long longValue2 = ((Long) z0.k.o(j2.j(map), "maxBackoff cannot be empty")).longValue();
            z0.k.i(longValue2 > 0, "maxBackoff must be greater than 0: %s", longValue2);
            double doubleValue = ((Double) z0.k.o(j2.a(map), "backoffMultiplier cannot be empty")).doubleValue();
            z0.k.j(doubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", Double.valueOf(doubleValue));
            Long q5 = j2.q(map);
            z0.k.j(q5 == null || q5.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", q5);
            Set<j1.b> s5 = j2.s(map);
            if (q5 == null && s5.isEmpty()) {
                z4 = false;
            }
            z0.k.e(z4, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new c2(min, longValue, longValue2, doubleValue, q5, s5);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return z0.g.a(this.f4996a, bVar.f4996a) && z0.g.a(this.f4997b, bVar.f4997b) && z0.g.a(this.f4998c, bVar.f4998c) && z0.g.a(this.f4999d, bVar.f4999d) && z0.g.a(this.f5000e, bVar.f5000e) && z0.g.a(this.f5001f, bVar.f5001f);
            }
            return false;
        }

        public int hashCode() {
            return z0.g.b(this.f4996a, this.f4997b, this.f4998c, this.f4999d, this.f5000e, this.f5001f);
        }

        public String toString() {
            return z0.f.b(this).d("timeoutNanos", this.f4996a).d("waitForReady", this.f4997b).d("maxInboundMessageSize", this.f4998c).d("maxOutboundMessageSize", this.f4999d).d("retryPolicy", this.f5000e).d("hedgingPolicy", this.f5001f).toString();
        }
    }

    /* loaded from: classes.dex */
    static final class c extends i3.f0 {

        /* renamed from: b  reason: collision with root package name */
        final l1 f5002b;

        private c(l1 l1Var) {
            this.f5002b = l1Var;
        }

        @Override // i3.f0
        public f0.b a(r0.f fVar) {
            return f0.b.d().b(this.f5002b).a();
        }
    }

    l1(b bVar, Map<String, b> map, Map<String, b> map2, b2.d0 d0Var, Object obj, Map<String, ?> map3) {
        this.f4989a = bVar;
        this.f4990b = Collections.unmodifiableMap(new HashMap(map));
        this.f4991c = Collections.unmodifiableMap(new HashMap(map2));
        this.f4992d = d0Var;
        this.f4993e = obj;
        this.f4994f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l1 a() {
        return new l1(null, new HashMap(), new HashMap(), null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l1 b(Map<String, ?> map, boolean z4, int i5, int i6, Object obj) {
        b2.d0 v5 = z4 ? j2.v(map) : null;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Map<String, ?> b5 = j2.b(map);
        List<Map<String, ?>> m5 = j2.m(map);
        if (m5 == null) {
            return new l1(null, hashMap, hashMap2, v5, obj, b5);
        }
        b bVar = null;
        for (Map<String, ?> map2 : m5) {
            b bVar2 = new b(map2, z4, i5, i6);
            List<Map<String, ?>> o5 = j2.o(map2);
            if (o5 != null && !o5.isEmpty()) {
                for (Map<String, ?> map3 : o5) {
                    String t5 = j2.t(map3);
                    String n5 = j2.n(map3);
                    if (z0.n.a(t5)) {
                        z0.k.j(z0.n.a(n5), "missing service name for method %s", n5);
                        z0.k.j(bVar == null, "Duplicate default method config in service config %s", map);
                        bVar = bVar2;
                    } else if (z0.n.a(n5)) {
                        z0.k.j(!hashMap2.containsKey(t5), "Duplicate service %s", t5);
                        hashMap2.put(t5, bVar2);
                    } else {
                        String b6 = i3.z0.b(t5, n5);
                        z0.k.j(!hashMap.containsKey(b6), "Duplicate method name %s", b6);
                        hashMap.put(b6, bVar2);
                    }
                }
            }
        }
        return new l1(bVar, hashMap, hashMap2, v5, obj, b5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i3.f0 c() {
        if (this.f4991c.isEmpty() && this.f4990b.isEmpty() && this.f4989a == null) {
            return null;
        }
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, ?> d() {
        return this.f4994f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object e() {
        return this.f4993e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l1.class != obj.getClass()) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return z0.g.a(this.f4989a, l1Var.f4989a) && z0.g.a(this.f4990b, l1Var.f4990b) && z0.g.a(this.f4991c, l1Var.f4991c) && z0.g.a(this.f4992d, l1Var.f4992d) && z0.g.a(this.f4993e, l1Var.f4993e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b f(i3.z0<?, ?> z0Var) {
        b bVar = this.f4990b.get(z0Var.c());
        if (bVar == null) {
            bVar = this.f4991c.get(z0Var.d());
        }
        return bVar == null ? this.f4989a : bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b2.d0 g() {
        return this.f4992d;
    }

    public int hashCode() {
        return z0.g.b(this.f4989a, this.f4990b, this.f4991c, this.f4992d, this.f4993e);
    }

    public String toString() {
        return z0.f.b(this).d("defaultMethodConfig", this.f4989a).d("serviceMethodMap", this.f4990b).d("serviceMap", this.f4991c).d("retryThrottling", this.f4992d).d("loadBalancingConfig", this.f4993e).toString();
    }
}
