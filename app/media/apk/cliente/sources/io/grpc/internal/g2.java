package io.grpc.internal;

import i3.a1;
import java.util.Map;
/* loaded from: classes.dex */
public final class g2 extends a1.h {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4772a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4773b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4774c;

    /* renamed from: d  reason: collision with root package name */
    private final j f4775d;

    public g2(boolean z4, int i5, int i6, j jVar) {
        this.f4772a = z4;
        this.f4773b = i5;
        this.f4774c = i6;
        this.f4775d = (j) z0.k.o(jVar, "autoLoadBalancerFactory");
    }

    @Override // i3.a1.h
    public a1.c a(Map<String, ?> map) {
        Object c5;
        try {
            a1.c f5 = this.f4775d.f(map);
            if (f5 == null) {
                c5 = null;
            } else if (f5.d() != null) {
                return a1.c.b(f5.d());
            } else {
                c5 = f5.c();
            }
            return a1.c.a(l1.b(map, this.f4772a, this.f4773b, this.f4774c, c5));
        } catch (RuntimeException e5) {
            return a1.c.b(i3.j1.f3434h.q("failed to parse service config").p(e5));
        }
    }
}
