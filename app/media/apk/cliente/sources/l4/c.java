package l4;

import java.text.DecimalFormat;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f6038a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f6039b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i5 = 0; i5 < 4; i5++) {
            threadLocalArr[i5] = new ThreadLocal<>();
        }
        f6039b = threadLocalArr;
    }

    public static final boolean a() {
        return f6038a;
    }
}
