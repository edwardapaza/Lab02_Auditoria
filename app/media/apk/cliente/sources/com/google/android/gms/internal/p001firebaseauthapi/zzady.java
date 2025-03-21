package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import java.util.HashMap;
import o0.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzady  reason: invalid package */
/* loaded from: classes.dex */
public final class zzady extends zzacf {
    private final String zza;
    private final /* synthetic */ zzadt zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzady(zzadt zzadtVar, zzacf zzacfVar, String str) {
        super(zzacfVar);
        this.zzb = zzadtVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacf
    public final void zza(Status status) {
        a aVar;
        HashMap hashMap;
        aVar = zzadt.zza;
        String a5 = d.a(status.u());
        String v5 = status.v();
        aVar.c("SMS verification code request failed: " + a5 + " " + v5, new Object[0]);
        hashMap = this.zzb.zzd;
        zzaea zzaeaVar = (zzaea) hashMap.get(this.zza);
        if (zzaeaVar == null) {
            return;
        }
        for (zzacf zzacfVar : zzaeaVar.zzb) {
            zzacfVar.zza(status);
        }
        this.zzb.zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacf
    public final void zzb(String str) {
        a aVar;
        HashMap hashMap;
        aVar = zzadt.zza;
        aVar.a("onCodeSent", new Object[0]);
        hashMap = this.zzb.zzd;
        zzaea zzaeaVar = (zzaea) hashMap.get(this.zza);
        if (zzaeaVar == null) {
            return;
        }
        for (zzacf zzacfVar : zzaeaVar.zzb) {
            zzacfVar.zzb(str);
        }
        zzaeaVar.zzg = true;
        zzaeaVar.zzd = str;
        if (zzaeaVar.zza <= 0) {
            this.zzb.zzb(this.zza);
        } else if (!zzaeaVar.zzc) {
            this.zzb.zze(this.zza);
        } else if (!zzah.zzc(zzaeaVar.zze)) {
            zzadt.zza(this.zzb, this.zza);
        }
    }
}
