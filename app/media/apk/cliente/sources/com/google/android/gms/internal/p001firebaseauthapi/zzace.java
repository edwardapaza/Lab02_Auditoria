package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.internal.q;
import com.google.firebase.auth.a1;
import com.google.firebase.auth.e1;
import com.google.firebase.auth.i0;
import com.google.firebase.auth.o0;
import com.google.firebase.auth.r0;
import com.google.firebase.auth.x0;
import f1.f;
import java.util.concurrent.ScheduledExecutorService;
import o0.a;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzace  reason: invalid package */
/* loaded from: classes.dex */
public final class zzace {
    private static final a zza = new a("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzyl zzb;
    private final zzadt zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzace(f fVar, ScheduledExecutorService scheduledExecutorService) {
        q.k(fVar);
        Context m5 = fVar.m();
        q.k(m5);
        this.zzb = new zzyl(new zzacs(fVar, zzact.zza()));
        this.zzc = new zzadt(m5, scheduledExecutorService);
    }

    private static boolean zza(long j5, boolean z4) {
        if (j5 <= 0 || !z4) {
            zza.h("App hash will not be appended to the request.", new Object[0]);
            return false;
        }
        return true;
    }

    public final void zza(zzafy zzafyVar, zzacc zzaccVar) {
        q.k(zzafyVar);
        this.zzb.zza(zzafyVar, new zzacf(zzaccVar, zza));
    }

    public final void zza(zzagl zzaglVar, zzacc zzaccVar) {
        this.zzb.zza(zzaglVar, new zzacf((zzacc) q.k(zzaccVar), zza));
    }

    public final void zza(zzags zzagsVar, zzacc zzaccVar) {
        q.k(zzagsVar);
        q.k(zzaccVar);
        this.zzb.zza(zzagsVar, new zzacf(zzaccVar, zza));
    }

    public final void zza(zzagt zzagtVar, zzacc zzaccVar) {
        q.k(zzagtVar);
        q.k(zzaccVar);
        this.zzb.zza(zzagtVar, new zzacf(zzaccVar, zza));
    }

    public final void zza(zzxw zzxwVar, zzacc zzaccVar) {
        q.k(zzxwVar);
        this.zzb.zza(zzaff.zzb(), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzxx zzxxVar, zzacc zzaccVar) {
        q.k(zzxxVar);
        q.e(zzxxVar.zza());
        q.e(zzxxVar.zzb());
        q.k(zzaccVar);
        this.zzb.zza(zzxxVar.zza(), zzxxVar.zzb(), zzxxVar.zzc(), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzxy zzxyVar, zzacc zzaccVar) {
        q.k(zzaccVar);
        q.k(zzxyVar);
        this.zzb.zza(q.e(zzxyVar.zzb()), zzadn.zza((o0) q.k(zzxyVar.zza())), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzxz zzxzVar, zzacc zzaccVar) {
        q.k(zzxzVar);
        this.zzb.zza(zzafk.zza(zzxzVar.zzb(), zzxzVar.zza()), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzya zzyaVar, zzacc zzaccVar) {
        q.k(zzyaVar);
        q.e(zzyaVar.zzc());
        q.k(zzaccVar);
        this.zzb.zza(zzyaVar.zzc(), zzyaVar.zza(), zzyaVar.zzd(), zzyaVar.zzb(), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzyb zzybVar, zzacc zzaccVar) {
        q.k(zzybVar);
        q.e(zzybVar.zzb());
        q.k(zzaccVar);
        this.zzb.zza(zzybVar.zzb(), zzybVar.zza(), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzyc zzycVar, zzacc zzaccVar) {
        q.k(zzycVar);
        q.k(zzaccVar);
        this.zzb.zzd(zzycVar.zza(), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzyd zzydVar, zzacc zzaccVar) {
        q.k(zzaccVar);
        q.k(zzydVar);
        zzafz zzafzVar = (zzafz) q.k(zzydVar.zza());
        String zzd = zzafzVar.zzd();
        zzacf zzacfVar = new zzacf(zzaccVar, zza);
        if (this.zzc.zzd(zzd)) {
            if (!zzafzVar.zze()) {
                this.zzc.zzb(zzacfVar, zzd);
                return;
            }
            this.zzc.zzc(zzd);
        }
        long zzb = zzafzVar.zzb();
        boolean zzf = zzafzVar.zzf();
        if (zza(zzb, zzf)) {
            zzafzVar.zza(new zzaed(this.zzc.zzb()));
        }
        this.zzc.zza(zzd, zzacfVar, zzb, zzf);
        this.zzb.zza(zzafzVar, this.zzc.zza(zzacfVar, zzd));
    }

    public final void zza(zzye zzyeVar, zzacc zzaccVar) {
        q.k(zzaccVar);
        q.k(zzyeVar);
        this.zzb.zza(zzadn.zza((o0) q.k(zzyeVar.zza())), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzyf zzyfVar, zzacc zzaccVar) {
        q.k(zzyfVar);
        q.k(zzyfVar.zza());
        q.k(zzaccVar);
        this.zzb.zza(zzyfVar.zza(), zzyfVar.zzb(), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzyg zzygVar, zzacc zzaccVar) {
        q.k(zzygVar);
        this.zzb.zza(zzafd.zza(zzygVar.zza(), zzygVar.zzb(), zzygVar.zzc()), new zzacf(zzaccVar, zza));
    }

    public final void zza(zzyh zzyhVar, zzacc zzaccVar) {
        q.k(zzyhVar);
        q.k(zzaccVar);
        String j5 = zzyhVar.zzb().j();
        zzacf zzacfVar = new zzacf(zzaccVar, zza);
        if (this.zzc.zzd(j5)) {
            if (!zzyhVar.zzg()) {
                this.zzc.zzb(zzacfVar, j5);
                return;
            }
            this.zzc.zzc(j5);
        }
        long zza2 = zzyhVar.zza();
        boolean zzh = zzyhVar.zzh();
        zzagh zza3 = zzagh.zza(zzyhVar.zzd(), zzyhVar.zzb().a(), zzyhVar.zzb().j(), zzyhVar.zzc(), zzyhVar.zzf(), zzyhVar.zze());
        if (zza(zza2, zzh)) {
            zza3.zza(new zzaed(this.zzc.zzb()));
        }
        this.zzc.zza(j5, zzacfVar, zza2, zzh);
        this.zzb.zza(zza3, this.zzc.zza(zzacfVar, j5));
    }

    public final void zza(i0 i0Var, String str, String str2, String str3, zzacc zzaccVar) {
        zzaeq zza2;
        q.k(i0Var);
        q.f(str, "cachedTokenState should not be empty.");
        q.k(zzaccVar);
        if (i0Var instanceof r0) {
            o0 a5 = ((r0) i0Var).a();
            zza2 = zzaeu.zza(str, (String) q.k(a5.zzc()), (String) q.k(a5.w()), str2, str3);
        } else if (!(i0Var instanceof x0)) {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        } else {
            x0 x0Var = (x0) i0Var;
            zza2 = zzaew.zza(str, q.e(str2), q.e(((a1) q.k(x0Var.a())).c()), q.e(x0Var.c()), str3);
        }
        this.zzb.zza(zza2, str, new zzacf(zzaccVar, zza));
    }

    public final void zza(String str, zzacc zzaccVar) {
        q.e(str);
        q.k(zzaccVar);
        this.zzb.zza(str, new zzacf(zzaccVar, zza));
    }

    public final void zza(String str, zzags zzagsVar, zzacc zzaccVar) {
        q.e(str);
        q.k(zzagsVar);
        q.k(zzaccVar);
        this.zzb.zza(str, zzagsVar, new zzacf(zzaccVar, zza));
    }

    public final void zza(String str, e1 e1Var, zzacc zzaccVar) {
        q.e(str);
        q.k(e1Var);
        q.k(zzaccVar);
        this.zzb.zza(str, e1Var, new zzacf(zzaccVar, zza));
    }

    public final void zza(String str, i0 i0Var, String str2, zzacc zzaccVar) {
        zzyl zzylVar;
        zzaes zza2;
        zzacf zzacfVar;
        q.e(str);
        q.k(i0Var);
        q.k(zzaccVar);
        if (i0Var instanceof r0) {
            o0 a5 = ((r0) i0Var).a();
            zzylVar = this.zzb;
            zza2 = zzaet.zza(str, (String) q.k(a5.zzc()), (String) q.k(a5.w()), str2);
            zzacfVar = new zzacf(zzaccVar, zza);
        } else if (!(i0Var instanceof x0)) {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        } else {
            x0 x0Var = (x0) i0Var;
            zzylVar = this.zzb;
            zza2 = zzaev.zza(str, q.e(x0Var.c()), str2, q.e(x0Var.b()));
            zzacfVar = new zzacf(zzaccVar, zza);
        }
        zzylVar.zza(zza2, zzacfVar);
    }

    public final void zza(String str, String str2, zzacc zzaccVar) {
        q.e(str);
        q.k(zzaccVar);
        this.zzb.zza(str, str2, new zzacf(zzaccVar, zza));
    }

    public final void zza(String str, String str2, String str3, long j5, boolean z4, boolean z5, String str4, String str5, boolean z6, zzacc zzaccVar) {
        q.f(str, "idToken should not be empty.");
        q.k(zzaccVar);
        zzacf zzacfVar = new zzacf(zzaccVar, zza);
        if (this.zzc.zzd(str2)) {
            zzadt zzadtVar = this.zzc;
            if (!z4) {
                zzadtVar.zzb(zzacfVar, str2);
                return;
            }
            zzadtVar.zzc(str2);
        }
        zzagj zza2 = zzagj.zza(str, str2, str3, str4, str5, null);
        if (zza(j5, z6)) {
            zza2.zza(new zzaed(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzacfVar, j5, z6);
        this.zzb.zza(zza2, this.zzc.zza(zzacfVar, str2));
    }

    public final void zza(String str, String str2, String str3, zzacc zzaccVar) {
        q.f(str, "cachedTokenState should not be empty.");
        q.f(str2, "uid should not be empty.");
        q.k(zzaccVar);
        this.zzb.zzb(str, str2, str3, new zzacf(zzaccVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzacc zzaccVar) {
        q.e(str);
        q.e(str2);
        q.k(zzaccVar);
        this.zzb.zza(str, str2, str3, str4, new zzacf(zzaccVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzacc zzaccVar) {
        q.e(str);
        q.e(str2);
        q.e(str3);
        q.k(zzaccVar);
        this.zzb.zza(str, str2, str3, str4, str5, new zzacf(zzaccVar, zza));
    }

    public final void zzb(String str, zzacc zzaccVar) {
        q.e(str);
        q.k(zzaccVar);
        this.zzb.zzb(str, new zzacf(zzaccVar, zza));
    }

    public final void zzb(String str, String str2, zzacc zzaccVar) {
        q.e(str);
        q.e(str2);
        q.k(zzaccVar);
        this.zzb.zzb(str, str2, new zzacf(zzaccVar, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzacc zzaccVar) {
        q.e(str);
        q.e(str2);
        q.k(zzaccVar);
        q.k(zzaccVar);
        this.zzb.zzb(str, str2, str3, str4, new zzacf(zzaccVar, zza));
    }

    public final void zzc(String str, zzacc zzaccVar) {
        q.e(str);
        q.k(zzaccVar);
        this.zzb.zzc(str, new zzacf(zzaccVar, zza));
    }

    public final void zzc(String str, String str2, zzacc zzaccVar) {
        q.e(str);
        q.e(str2);
        q.k(zzaccVar);
        this.zzb.zzc(str, str2, new zzacf(zzaccVar, zza));
    }

    public final void zzd(String str, zzacc zzaccVar) {
        q.k(zzaccVar);
        this.zzb.zze(str, new zzacf(zzaccVar, zza));
    }

    public final void zzd(String str, String str2, zzacc zzaccVar) {
        q.e(str);
        q.k(zzaccVar);
        this.zzb.zzd(str, str2, new zzacf(zzaccVar, zza));
    }

    public final void zze(String str, zzacc zzaccVar) {
        q.e(str);
        q.k(zzaccVar);
        this.zzb.zzf(str, new zzacf(zzaccVar, zza));
    }

    public final void zze(String str, String str2, zzacc zzaccVar) {
        q.e(str);
        this.zzb.zze(str, str2, new zzacf(zzaccVar, zza));
    }

    public final void zzf(String str, String str2, zzacc zzaccVar) {
        q.e(str);
        q.e(str2);
        q.k(zzaccVar);
        this.zzb.zzf(str, str2, new zzacf(zzaccVar, zza));
    }
}
