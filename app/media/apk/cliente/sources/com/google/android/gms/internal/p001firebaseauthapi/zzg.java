package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Handler;
import android.os.Looper;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzg  reason: invalid package */
/* loaded from: classes.dex */
public final class zzg extends Handler {
    private static zzf zza;
    private final Looper zzb;

    public zzg() {
        this.zzb = Looper.getMainLooper();
    }

    public zzg(Looper looper) {
        super(looper);
        this.zzb = Looper.getMainLooper();
    }
}
