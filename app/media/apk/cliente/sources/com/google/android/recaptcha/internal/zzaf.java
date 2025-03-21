package com.google.android.recaptcha.internal;

import android.content.Context;
import android.os.Build;
import l0.g;
/* loaded from: classes.dex */
public final class zzaf {
    public static final zzaf zza = new zzaf();
    private static final String zzb = String.valueOf(Build.VERSION.SDK_INT);
    private static final g zzc = g.e();

    private zzaf() {
    }

    public static final String zza(Context context) {
        int f5 = zzc.f(context);
        return (f5 == 1 || f5 == 3 || f5 == 9) ? "ANDROID_OFFPLAY" : "ANDROID_ONPLAY";
    }
}
