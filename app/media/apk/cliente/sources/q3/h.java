package q3;

import i3.a1;
import i3.j1;
import i3.r0;
import i3.s0;
import i3.t0;
import io.grpc.internal.d1;
import io.grpc.internal.j2;
import io.grpc.internal.q2;
import java.util.List;
import java.util.Map;
import q3.f;
/* loaded from: classes.dex */
public final class h extends s0 {
    private a1.c f(Map<String, ?> map) {
        Long l5 = d1.l(map, "interval");
        Long l6 = d1.l(map, "baseEjectionTime");
        Long l7 = d1.l(map, "maxEjectionTime");
        Integer i5 = d1.i(map, "maxEjectionPercentage");
        f.g.a aVar = new f.g.a();
        if (l5 != null) {
            aVar.e(l5);
        }
        if (l6 != null) {
            aVar.b(l6);
        }
        if (l7 != null) {
            aVar.g(l7);
        }
        if (i5 != null) {
            aVar.f(i5);
        }
        Map<String, ?> j5 = d1.j(map, "successRateEjection");
        if (j5 != null) {
            f.g.c.a aVar2 = new f.g.c.a();
            Integer i6 = d1.i(j5, "stdevFactor");
            Integer i7 = d1.i(j5, "enforcementPercentage");
            Integer i8 = d1.i(j5, "minimumHosts");
            Integer i9 = d1.i(j5, "requestVolume");
            if (i6 != null) {
                aVar2.e(i6);
            }
            if (i7 != null) {
                aVar2.b(i7);
            }
            if (i8 != null) {
                aVar2.c(i8);
            }
            if (i9 != null) {
                aVar2.d(i9);
            }
            aVar.h(aVar2.a());
        }
        Map<String, ?> j6 = d1.j(map, "failurePercentageEjection");
        if (j6 != null) {
            f.g.b.a aVar3 = new f.g.b.a();
            Integer i10 = d1.i(j6, "threshold");
            Integer i11 = d1.i(j6, "enforcementPercentage");
            Integer i12 = d1.i(j6, "minimumHosts");
            Integer i13 = d1.i(j6, "requestVolume");
            if (i10 != null) {
                aVar3.e(i10);
            }
            if (i11 != null) {
                aVar3.b(i11);
            }
            if (i12 != null) {
                aVar3.c(i12);
            }
            if (i13 != null) {
                aVar3.d(i13);
            }
            aVar.d(aVar3.a());
        }
        List<j2.a> A = j2.A(d1.f(map, "childPolicy"));
        if (A == null || A.isEmpty()) {
            j1 j1Var = j1.f3446t;
            return a1.c.b(j1Var.q("No child policy in outlier_detection_experimental LB policy: " + map));
        }
        a1.c y4 = j2.y(A, t0.b());
        if (y4.d() != null) {
            return y4;
        }
        aVar.c((j2.b) y4.c());
        return a1.c.a(aVar.a());
    }

    @Override // i3.r0.c
    public r0 a(r0.d dVar) {
        return new f(dVar, q2.f5109a);
    }

    @Override // i3.s0
    public String b() {
        return "outlier_detection_experimental";
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
        try {
            return f(map);
        } catch (RuntimeException e5) {
            j1 p5 = j1.f3447u.p(e5);
            return a1.c.b(p5.q("Failed parsing configuration for " + b()));
        }
    }
}
