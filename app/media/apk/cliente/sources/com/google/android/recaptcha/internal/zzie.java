package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class zzie {
    static final zzie zza = new zzie(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzie() {
        this.zzd = new HashMap();
    }

    zzie(boolean z4) {
        this.zzd = Collections.emptyMap();
    }

    public final zzir zza(zzke zzkeVar, int i5) {
        return (zzir) this.zzd.get(new zzid(zzkeVar, i5));
    }
}
