package t1;

import com.google.android.gms.common.api.a;
import com.google.protobuf.u1;
import i2.d0;
import java.util.Map;
import v1.u;
import v1.z;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f7593a = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7594a;

        static {
            int[] iArr = new int[d0.c.values().length];
            f7594a = iArr;
            try {
                iArr[d0.c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7594a[d0.c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7594a[d0.c.DOUBLE_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7594a[d0.c.INTEGER_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7594a[d0.c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7594a[d0.c.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7594a[d0.c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7594a[d0.c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7594a[d0.c.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7594a[d0.c.MAP_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7594a[d0.c.ARRAY_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private c() {
    }

    private void a(i2.b bVar, b bVar2) {
        i(bVar2, 50);
        for (d0 d0Var : bVar.e()) {
            f(d0Var, bVar2);
        }
    }

    private void b(String str, b bVar) {
        i(bVar, 37);
        u u5 = u.u(str);
        int p5 = u5.p();
        for (int i5 = 5; i5 < p5; i5++) {
            String m5 = u5.m(i5);
            i(bVar, 60);
            h(m5, bVar);
        }
    }

    private void c(i2.u uVar, b bVar) {
        i(bVar, 55);
        for (Map.Entry<String, d0> entry : uVar.h0().entrySet()) {
            d(entry.getKey(), bVar);
            f(entry.getValue(), bVar);
        }
    }

    private void d(String str, b bVar) {
        i(bVar, 25);
        h(str, bVar);
    }

    private void f(d0 d0Var, b bVar) {
        int i5;
        long j5;
        double d5;
        switch (a.f7594a[d0Var.A0().ordinal()]) {
            case 1:
                i5 = 5;
                i(bVar, i5);
                return;
            case 2:
                i(bVar, 10);
                j5 = d0Var.q0() ? 1L : 0L;
                bVar.d(j5);
                return;
            case 3:
                double t02 = d0Var.t0();
                if (Double.isNaN(t02)) {
                    i5 = 13;
                    i(bVar, i5);
                    return;
                }
                i(bVar, 15);
                if (t02 != -0.0d) {
                    bVar.b(t02);
                    return;
                }
                d5 = 0.0d;
                bVar.b(d5);
                return;
            case 4:
                i(bVar, 15);
                d5 = d0Var.v0();
                bVar.b(d5);
                return;
            case 5:
                u1 z02 = d0Var.z0();
                i(bVar, 20);
                bVar.d(z02.i0());
                j5 = z02.h0();
                bVar.d(j5);
                return;
            case 6:
                d(d0Var.y0(), bVar);
                g(bVar);
                return;
            case 7:
                i(bVar, 30);
                bVar.a(d0Var.r0());
                g(bVar);
                return;
            case 8:
                b(d0Var.x0(), bVar);
                return;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                m2.a u02 = d0Var.u0();
                i(bVar, 45);
                bVar.b(u02.h0());
                d5 = u02.i0();
                bVar.b(d5);
                return;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                if (z.x(d0Var)) {
                    i5 = a.e.API_PRIORITY_OTHER;
                    i(bVar, i5);
                    return;
                }
                c(d0Var.w0(), bVar);
                g(bVar);
                return;
            case 11:
                a(d0Var.p0(), bVar);
                g(bVar);
                return;
            default:
                throw new IllegalArgumentException("unknown index value type " + d0Var.A0());
        }
    }

    private void g(b bVar) {
        bVar.d(2L);
    }

    private void h(String str, b bVar) {
        bVar.e(str);
    }

    private void i(b bVar, int i5) {
        bVar.d(i5);
    }

    public void e(d0 d0Var, b bVar) {
        f(d0Var, bVar);
        bVar.c();
    }
}
