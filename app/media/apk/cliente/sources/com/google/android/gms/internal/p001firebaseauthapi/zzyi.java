package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.d2;
import com.google.firebase.auth.j0;
import j1.n0;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyi  reason: invalid package */
/* loaded from: classes.dex */
public final class zzyi {
    private String zza;
    private List<zzafq> zzb;
    private d2 zzc;

    public zzyi(String str, List<zzafq> list, d2 d2Var) {
        this.zza = str;
        this.zzb = list;
        this.zzc = d2Var;
    }

    public final d2 zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final List<j0> zzc() {
        return n0.b(this.zzb);
    }
}
