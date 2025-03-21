package com.google.android.recaptcha.internal;

import android.os.Build;
import java.util.Map;
import s3.p;
import t3.h0;
/* loaded from: classes.dex */
public final class zzfa {
    public static final zzfa zza = new zzfa();

    private zzfa() {
    }

    public static final Map zza() {
        Map f5;
        f5 = h0.f(p.a(-4, zzl.zzz), p.a(-12, zzl.zzA), p.a(-6, zzl.zzv), p.a(-11, zzl.zzx), p.a(-13, zzl.zzB), p.a(-14, zzl.zzC), p.a(-2, zzl.zzw), p.a(-7, zzl.zzD), p.a(-5, zzl.zzE), p.a(-9, zzl.zzF), p.a(-8, zzl.zzP), p.a(-15, zzl.zzy), p.a(-1, zzl.zzG), p.a(-3, zzl.zzI), p.a(-10, zzl.zzJ));
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            f5.put(-16, zzl.zzH);
        }
        if (i5 >= 27) {
            f5.put(1, zzl.zzL);
            f5.put(2, zzl.zzM);
            f5.put(0, zzl.zzN);
            f5.put(3, zzl.zzO);
        }
        if (i5 >= 29) {
            f5.put(4, zzl.zzK);
        }
        return f5;
    }
}
