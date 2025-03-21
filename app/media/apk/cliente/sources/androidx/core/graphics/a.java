package androidx.core.graphics;

import android.graphics.Color;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<double[]> f404a = new ThreadLocal<>();

    public static int a(double d5, double d6, double d7) {
        double d8 = (((3.2406d * d5) + ((-1.5372d) * d6)) + ((-0.4986d) * d7)) / 100.0d;
        double d9 = ((((-0.9689d) * d5) + (1.8758d * d6)) + (0.0415d * d7)) / 100.0d;
        double d10 = (((0.0557d * d5) + ((-0.204d) * d6)) + (1.057d * d7)) / 100.0d;
        return Color.rgb(b((int) Math.round((d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : d8 * 12.92d) * 255.0d), 0, 255), b((int) Math.round((d9 > 0.0031308d ? (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d : d9 * 12.92d) * 255.0d), 0, 255), b((int) Math.round((d10 > 0.0031308d ? (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d : d10 * 12.92d) * 255.0d), 0, 255));
    }

    private static int b(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : Math.min(i5, i7);
    }
}
