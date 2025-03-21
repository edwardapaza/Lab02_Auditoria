package k3;

import i3.m0;
import i3.y0;
import io.grpc.internal.r2;
import io.grpc.internal.t0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    public static final m3.d f5673a;

    /* renamed from: b  reason: collision with root package name */
    public static final m3.d f5674b;

    /* renamed from: c  reason: collision with root package name */
    public static final m3.d f5675c;

    /* renamed from: d  reason: collision with root package name */
    public static final m3.d f5676d;

    /* renamed from: e  reason: collision with root package name */
    public static final m3.d f5677e;

    /* renamed from: f  reason: collision with root package name */
    public static final m3.d f5678f;

    static {
        w4.f fVar = m3.d.f6110g;
        f5673a = new m3.d(fVar, "https");
        f5674b = new m3.d(fVar, "http");
        w4.f fVar2 = m3.d.f6108e;
        f5675c = new m3.d(fVar2, "POST");
        f5676d = new m3.d(fVar2, "GET");
        f5677e = new m3.d(t0.f5184j.d(), "application/grpc");
        f5678f = new m3.d("te", "trailers");
    }

    private static List<m3.d> a(List<m3.d> list, y0 y0Var) {
        byte[][] d5 = r2.d(y0Var);
        for (int i5 = 0; i5 < d5.length; i5 += 2) {
            w4.f m5 = w4.f.m(d5[i5]);
            if (m5.p() != 0 && m5.h(0) != 58) {
                list.add(new m3.d(m5, w4.f.m(d5[i5 + 1])));
            }
        }
        return list;
    }

    public static List<m3.d> b(y0 y0Var, String str, String str2, String str3, boolean z4, boolean z5) {
        z0.k.o(y0Var, "headers");
        z0.k.o(str, "defaultPath");
        z0.k.o(str2, "authority");
        c(y0Var);
        ArrayList arrayList = new ArrayList(m0.a(y0Var) + 7);
        arrayList.add(z5 ? f5674b : f5673a);
        arrayList.add(z4 ? f5676d : f5675c);
        arrayList.add(new m3.d(m3.d.f6111h, str2));
        arrayList.add(new m3.d(m3.d.f6109f, str));
        arrayList.add(new m3.d(t0.f5186l.d(), str3));
        arrayList.add(f5677e);
        arrayList.add(f5678f);
        return a(arrayList, y0Var);
    }

    private static void c(y0 y0Var) {
        y0Var.e(t0.f5184j);
        y0Var.e(t0.f5185k);
        y0Var.e(t0.f5186l);
    }
}
