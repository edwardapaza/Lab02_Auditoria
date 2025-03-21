package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.d2;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyj  reason: invalid package */
/* loaded from: classes.dex */
public final class zzyj {
    private final Status zza;
    private final d2 zzb;
    private final String zzc;
    private final String zzd;

    public zzyj(Status status, d2 d2Var, String str, String str2) {
        this.zza = status;
        this.zzb = d2Var;
        this.zzc = str;
        this.zzd = str2;
    }

    public final Status zza() {
        return this.zza;
    }

    public final d2 zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
