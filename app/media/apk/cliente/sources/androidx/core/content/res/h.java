package androidx.core.content.res;
/* loaded from: classes.dex */
final class h {

    /* renamed from: k  reason: collision with root package name */
    static final h f393k = k(b.f382c, (float) ((b.h(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    private final float f394a;

    /* renamed from: b  reason: collision with root package name */
    private final float f395b;

    /* renamed from: c  reason: collision with root package name */
    private final float f396c;

    /* renamed from: d  reason: collision with root package name */
    private final float f397d;

    /* renamed from: e  reason: collision with root package name */
    private final float f398e;

    /* renamed from: f  reason: collision with root package name */
    private final float f399f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f400g;

    /* renamed from: h  reason: collision with root package name */
    private final float f401h;

    /* renamed from: i  reason: collision with root package name */
    private final float f402i;

    /* renamed from: j  reason: collision with root package name */
    private final float f403j;

    private h(float f5, float f6, float f7, float f8, float f9, float f10, float[] fArr, float f11, float f12, float f13) {
        this.f399f = f5;
        this.f394a = f6;
        this.f395b = f7;
        this.f396c = f8;
        this.f397d = f9;
        this.f398e = f10;
        this.f400g = fArr;
        this.f401h = f11;
        this.f402i = f12;
        this.f403j = f13;
    }

    static h k(float[] fArr, float f5, float f6, float f7, boolean z4) {
        float[][] fArr2 = b.f380a;
        float f8 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f9 = fArr[1];
        float f10 = fArr[2];
        float f11 = (fArr3[0] * f8) + (fArr3[1] * f9) + (fArr3[2] * f10);
        float[] fArr4 = fArr2[1];
        float f12 = (fArr4[0] * f8) + (fArr4[1] * f9) + (fArr4[2] * f10);
        float[] fArr5 = fArr2[2];
        float f13 = (f8 * fArr5[0]) + (f9 * fArr5[1]) + (f10 * fArr5[2]);
        float f14 = (f7 / 10.0f) + 0.8f;
        float d5 = ((double) f14) >= 0.9d ? b.d(0.59f, 0.69f, (f14 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f14 - 0.8f) * 10.0f);
        float exp = z4 ? 1.0f : (1.0f - (((float) Math.exp(((-f5) - 42.0f) / 92.0f)) * 0.2777778f)) * f14;
        double d6 = exp;
        if (d6 > 1.0d) {
            exp = 1.0f;
        } else if (d6 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f11) * exp) + 1.0f) - exp, (((100.0f / f12) * exp) + 1.0f) - exp, (((100.0f / f13) * exp) + 1.0f) - exp};
        float f15 = 1.0f / ((5.0f * f5) + 1.0f);
        float f16 = f15 * f15 * f15 * f15;
        float f17 = 1.0f - f16;
        float cbrt = (f16 * f5) + (0.1f * f17 * f17 * ((float) Math.cbrt(f5 * 5.0d)));
        float h5 = b.h(f6) / fArr[1];
        double d7 = h5;
        float sqrt = ((float) Math.sqrt(d7)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d7, 0.2d));
        float pow2 = (float) Math.pow(((fArr6[2] * cbrt) * f13) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f11) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f12) / 100.0d, 0.42d), pow2};
        float f18 = fArr7[0];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[1];
        return new h(h5, ((f19 * 2.0f) + ((f20 * 400.0f) / (f20 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, d5, f14, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.f394a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f397d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f401h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f402i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f399f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f395b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f398e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        return this.f396c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] i() {
        return this.f400g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f403j;
    }
}
