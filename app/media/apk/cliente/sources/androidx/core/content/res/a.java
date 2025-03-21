package androidx.core.content.res;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final float f371a;

    /* renamed from: b  reason: collision with root package name */
    private final float f372b;

    /* renamed from: c  reason: collision with root package name */
    private final float f373c;

    /* renamed from: d  reason: collision with root package name */
    private final float f374d;

    /* renamed from: e  reason: collision with root package name */
    private final float f375e;

    /* renamed from: f  reason: collision with root package name */
    private final float f376f;

    /* renamed from: g  reason: collision with root package name */
    private final float f377g;

    /* renamed from: h  reason: collision with root package name */
    private final float f378h;

    /* renamed from: i  reason: collision with root package name */
    private final float f379i;

    a(float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f371a = f5;
        this.f372b = f6;
        this.f373c = f7;
        this.f374d = f8;
        this.f375e = f9;
        this.f376f = f10;
        this.f377g = f11;
        this.f378h = f12;
        this.f379i = f13;
    }

    private static a b(float f5, float f6, float f7) {
        float f8 = 1000.0f;
        a aVar = null;
        float f9 = 1000.0f;
        float f10 = 100.0f;
        float f11 = 0.0f;
        while (Math.abs(f11 - f10) > 0.01f) {
            float f12 = ((f10 - f11) / 2.0f) + f11;
            int p5 = e(f12, f6, f5).p();
            float b5 = b.b(p5);
            float abs = Math.abs(f7 - b5);
            if (abs < 0.2f) {
                a c5 = c(p5);
                float a5 = c5.a(e(c5.k(), c5.i(), f5));
                if (a5 <= 1.0f) {
                    aVar = c5;
                    f8 = abs;
                    f9 = a5;
                }
            }
            if (f8 == 0.0f && f9 == 0.0f) {
                break;
            } else if (b5 < f7) {
                f11 = f12;
            } else {
                f10 = f12;
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(int i5) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i5, h.f393k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void d(int i5, h hVar, float[] fArr, float[] fArr2) {
        float pow;
        b.f(i5, fArr2);
        float[][] fArr3 = b.f380a;
        float f5 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f6 = fArr2[1];
        float f7 = fArr2[2];
        float f8 = (fArr4[0] * f5) + (fArr4[1] * f6) + (fArr4[2] * f7);
        float[] fArr5 = fArr3[1];
        float f9 = (fArr5[0] * f5) + (fArr5[1] * f6) + (fArr5[2] * f7);
        float[] fArr6 = fArr3[2];
        float f10 = hVar.i()[0] * f8;
        float f11 = hVar.i()[1] * f9;
        float f12 = hVar.i()[2] * ((f5 * fArr6[0]) + (f6 * fArr6[1]) + (f7 * fArr6[2]));
        float pow2 = (float) Math.pow((hVar.c() * Math.abs(f10)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((hVar.c() * Math.abs(f11)) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((hVar.c() * Math.abs(f12)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f10) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f11) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f12) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d5 = signum3;
        float f13 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d5)) / 11.0f;
        float f14 = ((float) ((signum + signum2) - (d5 * 2.0d))) / 9.0f;
        float f15 = signum2 * 20.0f;
        float f16 = (((signum * 20.0f) + f15) + (21.0f * signum3)) / 20.0f;
        float f17 = (((signum * 40.0f) + f15) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f14, f13)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f18 = (3.1415927f * atan2) / 180.0f;
        float pow5 = ((float) Math.pow((f17 * hVar.f()) / hVar.a(), hVar.b() * hVar.j())) * 100.0f;
        float b5 = (4.0f / hVar.b()) * ((float) Math.sqrt(pow5 / 100.0f)) * (hVar.a() + 4.0f) * hVar.d();
        float f19 = atan2;
        float sqrt = ((float) Math.sqrt(pow5 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, hVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) atan2) < 20.14d ? 360.0f + atan2 : atan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * hVar.g()) * hVar.h()) * ((float) Math.sqrt((f13 * f13) + (f14 * f14)))) / (f16 + 0.305f), 0.9d));
        float d6 = hVar.d() * sqrt;
        float sqrt2 = ((float) Math.sqrt((pow * hVar.b()) / (hVar.a() + 4.0f))) * 50.0f;
        float f20 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((0.0228f * d6) + 1.0f)) * 43.85965f;
        double d7 = f18;
        float cos = ((float) Math.cos(d7)) * log;
        float sin = log * ((float) Math.sin(d7));
        fArr2[0] = f19;
        fArr2[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow5;
            fArr[1] = b5;
            fArr[2] = d6;
            fArr[3] = sqrt2;
            fArr[4] = f20;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    private static a e(float f5, float f6, float f7) {
        return f(f5, f6, f7, h.f393k);
    }

    private static a f(float f5, float f6, float f7, h hVar) {
        double d5;
        float b5 = (4.0f / hVar.b()) * ((float) Math.sqrt(f5 / 100.0d)) * (hVar.a() + 4.0f) * hVar.d();
        float d6 = f6 * hVar.d();
        float sqrt = ((float) Math.sqrt(((f6 / ((float) Math.sqrt(d5))) * hVar.b()) / (hVar.a() + 4.0f))) * 50.0f;
        float f8 = (1.7f * f5) / ((0.007f * f5) + 1.0f);
        float log = ((float) Math.log((d6 * 0.0228d) + 1.0d)) * 43.85965f;
        double d7 = (3.1415927f * f7) / 180.0f;
        return new a(f7, f6, f5, b5, d6, sqrt, f8, log * ((float) Math.cos(d7)), log * ((float) Math.sin(d7)));
    }

    public static int m(float f5, float f6, float f7) {
        return n(f5, f6, f7, h.f393k);
    }

    static int n(float f5, float f6, float f7, h hVar) {
        if (f6 < 1.0d || Math.round(f7) <= 0.0d || Math.round(f7) >= 100.0d) {
            return b.a(f7);
        }
        float min = f5 < 0.0f ? 0.0f : Math.min(360.0f, f5);
        float f8 = f6;
        a aVar = null;
        float f9 = 0.0f;
        boolean z4 = true;
        while (Math.abs(f9 - f6) >= 0.4f) {
            a b5 = b(min, f8, f7);
            if (z4) {
                if (b5 != null) {
                    return b5.o(hVar);
                }
                z4 = false;
            } else if (b5 == null) {
                f6 = f8;
            } else {
                f9 = f8;
                aVar = b5;
            }
            f8 = ((f6 - f9) / 2.0f) + f9;
        }
        return aVar == null ? b.a(f7) : aVar.o(hVar);
    }

    float a(a aVar) {
        float l5 = l() - aVar.l();
        float g5 = g() - aVar.g();
        float h5 = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((l5 * l5) + (g5 * g5) + (h5 * h5)), 0.63d) * 1.41d);
    }

    float g() {
        return this.f378h;
    }

    float h() {
        return this.f379i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f372b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f371a;
    }

    float k() {
        return this.f373c;
    }

    float l() {
        return this.f377g;
    }

    int o(h hVar) {
        float f5;
        float pow = (float) Math.pow(((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(k() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, hVar.e()), 0.73d), 1.1111111111111112d);
        double j5 = (j() * 3.1415927f) / 180.0f;
        float a5 = hVar.a() * ((float) Math.pow(k() / 100.0d, (1.0d / hVar.b()) / hVar.j()));
        float cos = ((float) (Math.cos(2.0d + j5) + 3.8d)) * 0.25f * 3846.1538f * hVar.g() * hVar.h();
        float f6 = a5 / hVar.f();
        float sin = (float) Math.sin(j5);
        float cos2 = (float) Math.cos(j5);
        float f7 = (((0.305f + f6) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f8 = cos2 * f7;
        float f9 = f7 * sin;
        float f10 = f6 * 460.0f;
        float f11 = (((451.0f * f8) + f10) + (288.0f * f9)) / 1403.0f;
        float f12 = ((f10 - (891.0f * f8)) - (261.0f * f9)) / 1403.0f;
        float signum = Math.signum(f11) * (100.0f / hVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f11) * 27.13d) / (400.0d - Math.abs(f11))), 2.380952380952381d));
        float signum2 = Math.signum(f12) * (100.0f / hVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f12) * 27.13d) / (400.0d - Math.abs(f12))), 2.380952380952381d));
        float signum3 = Math.signum(((f10 - (f8 * 220.0f)) - (f9 * 6300.0f)) / 1403.0f) * (100.0f / hVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f5) * 27.13d) / (400.0d - Math.abs(f5))), 2.380952380952381d));
        float f13 = signum / hVar.i()[0];
        float f14 = signum2 / hVar.i()[1];
        float f15 = signum3 / hVar.i()[2];
        float[][] fArr = b.f381b;
        float[] fArr2 = fArr[0];
        float f16 = (fArr2[0] * f13) + (fArr2[1] * f14) + (fArr2[2] * f15);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return androidx.core.graphics.a.a(f16, (fArr3[0] * f13) + (fArr3[1] * f14) + (fArr3[2] * f15), (f13 * fArr4[0]) + (f14 * fArr4[1]) + (f15 * fArr4[2]));
    }

    int p() {
        return o(h.f393k);
    }
}
