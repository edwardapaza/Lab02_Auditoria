package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.d2;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyt  reason: invalid package */
/* loaded from: classes.dex */
public final class zzyt implements zzadm<zzafc> {
    private final /* synthetic */ zzadj zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ d2 zze;
    private final /* synthetic */ zzacf zzf;
    private final /* synthetic */ zzafm zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyt(zzyl zzylVar, zzadj zzadjVar, String str, String str2, Boolean bool, d2 d2Var, zzacf zzacfVar, zzafm zzafmVar) {
        this.zza = zzadjVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = d2Var;
        this.zzf = zzacfVar;
        this.zzg = zzafmVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafc zzafcVar) {
        zzafr zzafrVar;
        List<zzafb> zza = zzafcVar.zza();
        if (zza == null || zza.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        boolean z4 = false;
        zzafb zzafbVar = zza.get(0);
        zzafu zzf = zzafbVar.zzf();
        List<zzafr> zza2 = zzf != null ? zzf.zza() : null;
        if (zza2 != null && !zza2.isEmpty()) {
            if (TextUtils.isEmpty(this.zzb)) {
                zzafrVar = zza2.get(0);
            } else {
                for (int i5 = 0; i5 < zza2.size(); i5++) {
                    if (zza2.get(i5).zzf().equals(this.zzb)) {
                        zzafrVar = zza2.get(i5);
                    }
                }
            }
            zzafrVar.zza(this.zzc);
            break;
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            z4 = bool.booleanValue();
        } else if (zzafbVar.zzb() - zzafbVar.zza() < 1000) {
            z4 = true;
        }
        zzafbVar.zza(z4);
        zzafbVar.zza(this.zze);
        this.zzf.zza(this.zzg, zzafbVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza(str);
    }
}
