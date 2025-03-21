package io.grpc.internal;

import i3.a1;
import i3.r0;
import io.grpc.internal.t1;
import java.util.Map;
/* loaded from: classes.dex */
public final class u1 extends i3.s0 {

    /* renamed from: b  reason: collision with root package name */
    static boolean f5272b = !z0.n.a(System.getenv("GRPC_EXPERIMENTAL_PICKFIRST_LB_CONFIG"));

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f5273c = 0;

    @Override // i3.r0.c
    public i3.r0 a(r0.d dVar) {
        return new t1(dVar);
    }

    @Override // i3.s0
    public String b() {
        return "pick_first";
    }

    @Override // i3.s0
    public int c() {
        return 5;
    }

    @Override // i3.s0
    public boolean d() {
        return true;
    }

    @Override // i3.s0
    public a1.c e(Map<String, ?> map) {
        if (f5272b) {
            try {
                return a1.c.a(new t1.c(d1.d(map, "shuffleAddressList")));
            } catch (RuntimeException e5) {
                i3.j1 p5 = i3.j1.f3447u.p(e5);
                return a1.c.b(p5.q("Failed parsing configuration for " + b()));
            }
        }
        return a1.c.a("no service config");
    }
}
