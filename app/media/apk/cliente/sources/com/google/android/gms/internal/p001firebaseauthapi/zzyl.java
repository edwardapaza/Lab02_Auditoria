package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.firebase.auth.d2;
import com.google.firebase.auth.e;
import com.google.firebase.auth.e1;
import com.google.firebase.auth.j;
import j1.r;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyl  reason: invalid package */
/* loaded from: classes.dex */
public final class zzyl {
    private final zzadk zza;

    public zzyl(zzadk zzadkVar) {
        this.zza = (zzadk) q.k(zzadkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzaeo zzaeoVar, zzacf zzacfVar) {
        q.k(zzaeoVar);
        q.k(zzacfVar);
        this.zza.zza(zzaeoVar, new zzyo(this, zzacfVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzafm zzafmVar, String str, String str2, Boolean bool, d2 d2Var, zzacf zzacfVar, zzadj zzadjVar) {
        q.k(zzafmVar);
        q.k(zzadjVar);
        q.k(zzacfVar);
        this.zza.zza(new zzaez(zzafmVar.zzc()), new zzyt(this, zzadjVar, str2, str, bool, d2Var, zzacfVar, zzafmVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzyl zzylVar, zzacf zzacfVar, zzafm zzafmVar, zzafb zzafbVar, zzagb zzagbVar, zzadj zzadjVar) {
        q.k(zzacfVar);
        q.k(zzafmVar);
        q.k(zzafbVar);
        q.k(zzagbVar);
        q.k(zzadjVar);
        zzylVar.zza.zza(zzagbVar, new zzyq(zzylVar, zzagbVar, zzafbVar, zzacfVar, zzafmVar, zzadjVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzyl zzylVar, zzacf zzacfVar, zzafm zzafmVar, zzagb zzagbVar, zzadj zzadjVar) {
        q.k(zzacfVar);
        q.k(zzafmVar);
        q.k(zzagbVar);
        q.k(zzadjVar);
        zzylVar.zza.zza(new zzaez(zzafmVar.zzc()), new zzyr(zzylVar, zzadjVar, zzacfVar, zzafmVar, zzagbVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzyl zzylVar, zzacf zzacfVar, zzagd zzagdVar, zzadj zzadjVar) {
        q.k(zzacfVar);
        q.k(zzagdVar);
        q.k(zzadjVar);
        zzylVar.zza.zza(zzagdVar, new zzza(zzylVar, zzacfVar, zzadjVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzyl zzylVar, zzagu zzaguVar, zzacf zzacfVar, zzadj zzadjVar) {
        if (!zzaguVar.zzo()) {
            zzylVar.zza(new zzafm(zzaguVar.zzi(), zzaguVar.zze(), Long.valueOf(zzaguVar.zza()), "Bearer"), zzaguVar.zzh(), zzaguVar.zzg(), Boolean.valueOf(zzaguVar.zzn()), zzaguVar.zzb(), zzacfVar, zzadjVar);
            return;
        }
        zzacfVar.zza(new zzyj(zzaguVar.zzm() ? new Status(17012) : r.a(zzaguVar.zzd()), zzaguVar.zzb(), zzaguVar.zzc(), zzaguVar.zzj()));
    }

    private final void zza(String str, zzadm<zzafm> zzadmVar) {
        q.k(zzadmVar);
        q.e(str);
        zzafm zzb = zzafm.zzb(str);
        if (zzb.zzg()) {
            zzadmVar.zza((zzadm<zzafm>) zzb);
            return;
        }
        this.zza.zza(new zzafa(zzb.zzd()), new zzaae(this, zzadmVar));
    }

    private final void zzb(zzafd zzafdVar, zzacf zzacfVar) {
        q.k(zzafdVar);
        q.k(zzacfVar);
        this.zza.zza(zzafdVar, new zzzz(this, zzacfVar));
    }

    public final void zza(zzaeq zzaeqVar, String str, zzacf zzacfVar) {
        q.k(zzaeqVar);
        q.k(zzacfVar);
        zza(str, new zzzm(this, zzaeqVar, zzacfVar));
    }

    public final void zza(zzaes zzaesVar, zzacf zzacfVar) {
        q.k(zzaesVar);
        q.k(zzacfVar);
        this.zza.zza(zzaesVar, new zzzo(this, zzacfVar));
    }

    public final void zza(zzafd zzafdVar, zzacf zzacfVar) {
        zzb(zzafdVar, zzacfVar);
    }

    public final void zza(zzaff zzaffVar, zzacf zzacfVar) {
        q.k(zzaffVar);
        q.k(zzacfVar);
        this.zza.zza(zzaffVar, new zzzt(this, zzacfVar));
    }

    public final void zza(zzafk zzafkVar, zzacf zzacfVar) {
        q.k(zzafkVar);
        q.k(zzacfVar);
        this.zza.zza(zzafkVar, new zzzq(this, zzacfVar));
    }

    public final void zza(zzafy zzafyVar, zzacf zzacfVar) {
        this.zza.zza(zzafyVar, new zzaab(this, zzacfVar));
    }

    public final void zza(zzafz zzafzVar, zzacf zzacfVar) {
        q.e(zzafzVar.zzd());
        q.k(zzacfVar);
        this.zza.zza(zzafzVar, new zzyz(this, zzacfVar));
    }

    public final void zza(zzagf zzagfVar, zzacf zzacfVar) {
        q.k(zzagfVar);
        q.k(zzacfVar);
        this.zza.zza(zzagfVar, new zzzn(this, zzagfVar, zzacfVar));
    }

    public final void zza(zzagh zzaghVar, zzacf zzacfVar) {
        q.k(zzaghVar);
        q.k(zzacfVar);
        this.zza.zza(zzaghVar, new zzzr(this, zzacfVar));
    }

    public final void zza(zzags zzagsVar, zzacf zzacfVar) {
        q.k(zzagsVar);
        q.k(zzacfVar);
        zzagsVar.zzb(true);
        this.zza.zza(zzagsVar, new zzzk(this, zzacfVar));
    }

    public final void zza(zzagt zzagtVar, zzacf zzacfVar) {
        q.k(zzagtVar);
        q.k(zzacfVar);
        this.zza.zza(zzagtVar, new zzyx(this, zzacfVar));
    }

    public final void zza(zzagx zzagxVar, zzacf zzacfVar) {
        q.k(zzagxVar);
        q.k(zzacfVar);
        this.zza.zza(zzagxVar, new zzyy(this, zzacfVar));
    }

    public final void zza(j jVar, String str, zzacf zzacfVar) {
        q.k(jVar);
        q.k(zzacfVar);
        if (jVar.zzg()) {
            zza(jVar.y(), new zzyp(this, jVar, str, zzacfVar));
        } else {
            zza(new zzaeo(jVar, null, str), zzacfVar);
        }
    }

    public final void zza(String str, zzacf zzacfVar) {
        q.e(str);
        q.k(zzacfVar);
        zza(str, new zzzu(this, zzacfVar));
    }

    public final void zza(String str, zzags zzagsVar, zzacf zzacfVar) {
        q.e(str);
        q.k(zzagsVar);
        q.k(zzacfVar);
        zza(str, new zzzf(this, zzagsVar, zzacfVar));
    }

    public final void zza(String str, zzagx zzagxVar, zzacf zzacfVar) {
        q.e(str);
        q.k(zzagxVar);
        q.k(zzacfVar);
        zza(str, new zzzd(this, zzagxVar, zzacfVar));
    }

    public final void zza(String str, e1 e1Var, zzacf zzacfVar) {
        q.e(str);
        q.k(e1Var);
        q.k(zzacfVar);
        zza(str, new zzaaa(this, e1Var, zzacfVar));
    }

    public final void zza(String str, e eVar, zzacf zzacfVar) {
        q.e(str);
        q.k(zzacfVar);
        zzafd zzafdVar = new zzafd(4);
        zzafdVar.zzd(str);
        if (eVar != null) {
            zzafdVar.zza(eVar);
        }
        zzb(zzafdVar, zzacfVar);
    }

    public final void zza(String str, e eVar, String str2, String str3, zzacf zzacfVar) {
        q.e(str);
        q.k(zzacfVar);
        zzafd zzafdVar = new zzafd(eVar.A());
        zzafdVar.zzb(str);
        zzafdVar.zza(eVar);
        zzafdVar.zzc(str2);
        zzafdVar.zza(str3);
        this.zza.zza(zzafdVar, new zzyv(this, zzacfVar));
    }

    public final void zza(String str, String str2, zzacf zzacfVar) {
        q.e(str);
        q.k(zzacfVar);
        zzagb zzagbVar = new zzagb();
        zzagbVar.zze(str);
        zzagbVar.zzh(str2);
        this.zza.zza(zzagbVar, new zzaaf(this, zzacfVar));
    }

    public final void zza(String str, String str2, String str3, zzacf zzacfVar) {
        q.e(str);
        q.e(str2);
        q.k(zzacfVar);
        this.zza.zza(new zzafw(str, str2, str3), new zzyw(this, zzacfVar));
    }

    public final void zza(String str, String str2, String str3, String str4, zzacf zzacfVar) {
        q.e(str);
        q.e(str2);
        q.k(zzacfVar);
        this.zza.zza(new zzagd(str, str2, null, str3, str4, null), new zzyn(this, zzacfVar));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzacf zzacfVar) {
        q.e(str);
        q.e(str2);
        q.e(str3);
        q.k(zzacfVar);
        zza(str3, new zzzb(this, str, str2, str4, str5, zzacfVar));
    }

    public final void zzb(String str, zzacf zzacfVar) {
        q.e(str);
        q.k(zzacfVar);
        this.zza.zza(new zzafa(str), new zzyk(this, zzacfVar));
    }

    public final void zzb(String str, String str2, zzacf zzacfVar) {
        q.e(str);
        q.e(str2);
        q.k(zzacfVar);
        zza(str, new zzaad(this, str2, zzacfVar));
    }

    public final void zzb(String str, String str2, String str3, zzacf zzacfVar) {
        q.e(str);
        q.e(str2);
        q.k(zzacfVar);
        zza(str, new zzzi(this, str2, str3, zzacfVar));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzacf zzacfVar) {
        q.e(str);
        q.e(str2);
        q.k(zzacfVar);
        this.zza.zza(new zzagv(str, str2, str3, str4), new zzym(this, zzacfVar));
    }

    public final void zzc(String str, zzacf zzacfVar) {
        q.e(str);
        q.k(zzacfVar);
        zza(str, new zzzs(this, zzacfVar));
    }

    public final void zzc(String str, String str2, zzacf zzacfVar) {
        q.e(str);
        q.e(str2);
        q.k(zzacfVar);
        zza(str, new zzaac(this, str2, zzacfVar));
    }

    public final void zzd(String str, zzacf zzacfVar) {
        q.k(zzacfVar);
        this.zza.zza(str, new zzzw(this, zzacfVar));
    }

    public final void zzd(String str, String str2, zzacf zzacfVar) {
        q.e(str);
        q.k(zzacfVar);
        this.zza.zza(new zzafw(str, null, str2), new zzyu(this, zzacfVar));
    }

    public final void zze(String str, zzacf zzacfVar) {
        q.k(zzacfVar);
        this.zza.zza(new zzagd(str), new zzzy(this, zzacfVar));
    }

    public final void zze(String str, String str2, zzacf zzacfVar) {
        q.e(str);
        q.k(zzacfVar);
        this.zza.zza(new zzaej(str, str2), new zzys(this, zzacfVar));
    }

    public final void zzf(String str, zzacf zzacfVar) {
        q.e(str);
        q.k(zzacfVar);
        zza(str, new zzzh(this, zzacfVar));
    }

    public final void zzf(String str, String str2, zzacf zzacfVar) {
        q.e(str);
        q.e(str2);
        q.k(zzacfVar);
        zza(str2, new zzzg(this, str, zzacfVar));
    }
}
