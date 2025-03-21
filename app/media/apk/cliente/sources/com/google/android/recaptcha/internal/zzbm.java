package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import m4.i;
import m4.j0;
import t3.x;
/* loaded from: classes.dex */
public final class zzbm implements zzbh {
    public static final zzbi zza = new zzbi(null);
    private static Timer zzb;
    private final zzbn zzc;
    private final j0 zzd;
    private final zzaz zze;

    public zzbm(Context context, zzbn zzbnVar, j0 j0Var) {
        zzaz zzazVar;
        this.zzc = zzbnVar;
        this.zzd = j0Var;
        zzaz zzazVar2 = null;
        try {
            zzazVar = zzaz.zzc;
            zzazVar = zzazVar == null ? new zzaz(context, null) : zzazVar;
            zzaz.zzc = zzazVar;
            zzazVar2 = zzazVar;
        } catch (Exception unused) {
        }
        this.zze = zzazVar2;
        zzh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        List<List> M;
        zzaz zzazVar;
        zzpd zzk;
        int zzJ;
        int i5;
        zzaz zzazVar2 = this.zze;
        if (zzazVar2 != null) {
            M = x.M(zzazVar2.zzd(), 20, 20, true);
            for (List<zzba> list : M) {
                zznh zzi = zzni.zzi();
                ArrayList arrayList = new ArrayList();
                for (zzba zzbaVar : list) {
                    try {
                        zzk = zzpd.zzk(zzfy.zzg().zzj(zzbaVar.zzc()));
                        zzJ = zzk.zzJ();
                        i5 = zzJ - 1;
                    } catch (Exception unused) {
                        zzaz zzazVar3 = this.zze;
                        if (zzazVar3 != null) {
                            zzazVar3.zzf(zzbaVar);
                        }
                    }
                    if (zzJ == 0) {
                        throw null;
                    }
                    if (i5 == 0) {
                        zzi.zzp(zzk.zzf());
                    } else if (i5 == 1) {
                        zzi.zzq(zzk.zzg());
                    }
                    arrayList.add(zzbaVar);
                }
                if (zzi.zzd() + zzi.zze() != 0) {
                    if (this.zzc.zza(((zzni) zzi.zzj()).zzd()) && (zzazVar = this.zze) != null) {
                        zzazVar.zza(arrayList);
                    }
                }
            }
        }
    }

    private final void zzh() {
        if (zzb == null) {
            Timer timer = new Timer();
            zzb = timer;
            timer.schedule(new zzbj(this), 120000L, 120000L);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzbh
    public final void zza(zzpd zzpdVar) {
        i.d(this.zzd, null, null, new zzbl(this, zzpdVar, null), 3, null);
        zzh();
    }
}
