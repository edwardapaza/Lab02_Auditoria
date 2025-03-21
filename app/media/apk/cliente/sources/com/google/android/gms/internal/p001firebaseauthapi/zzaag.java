package com.google.android.gms.internal.p001firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.a0;
import com.google.firebase.auth.c0;
import com.google.firebase.auth.d;
import com.google.firebase.auth.e1;
import com.google.firebase.auth.h;
import com.google.firebase.auth.j;
import com.google.firebase.auth.o0;
import com.google.firebase.auth.q0;
import com.google.firebase.auth.r0;
import com.google.firebase.auth.t0;
import com.google.firebase.auth.w0;
import com.google.firebase.auth.x0;
import f1.f;
import j1.e;
import j1.i;
import j1.k;
import j1.n0;
import j1.p;
import j1.q1;
import j1.x;
import j1.y;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaag  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaag extends zzadf {
    public zzaag(f fVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzace(fVar, scheduledExecutorService);
        this.zzb = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i zza(f fVar, zzafb zzafbVar) {
        q.k(fVar);
        q.k(zzafbVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e(zzafbVar, "firebase"));
        List<zzafr> zzl = zzafbVar.zzl();
        if (zzl != null && !zzl.isEmpty()) {
            for (int i5 = 0; i5 < zzl.size(); i5++) {
                arrayList.add(new e(zzl.get(i5)));
            }
        }
        i iVar = new i(fVar, arrayList);
        iVar.X(new k(zzafbVar.zzb(), zzafbVar.zza()));
        iVar.Y(zzafbVar.zzn());
        iVar.W(zzafbVar.zze());
        iVar.S(n0.b(zzafbVar.zzk()));
        iVar.Z(zzafbVar.zzd());
        return iVar;
    }

    public final Task<zzafi> zza() {
        return zza(new zzaaq());
    }

    public final Task<Void> zza(a0 a0Var, y yVar) {
        return zza((zzaan) new zzaan().zza(a0Var).zza((zzacw<Void, y>) yVar).zza((x) yVar));
    }

    public final Task<Void> zza(f fVar, a0 a0Var, e1 e1Var, j1.e1 e1Var2) {
        return zza((zzaby) new zzaby(e1Var).zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var2).zza((x) e1Var2));
    }

    public final Task<com.google.firebase.auth.i> zza(f fVar, a0 a0Var, h hVar, String str, j1.e1 e1Var) {
        q.k(fVar);
        q.k(hVar);
        q.k(a0Var);
        q.k(e1Var);
        List<String> U = a0Var.U();
        if (U == null || !U.contains(hVar.t())) {
            if (hVar instanceof j) {
                j jVar = (j) hVar;
                return !jVar.z() ? zza((zzaas) new zzaas(jVar, str).zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var)) : zza((zzaax) new zzaax(jVar).zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var));
            } else if (hVar instanceof o0) {
                zzads.zza();
                return zza((zzaau) new zzaau((o0) hVar).zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var));
            } else {
                q.k(fVar);
                q.k(hVar);
                q.k(a0Var);
                q.k(e1Var);
                return zza((zzaav) new zzaav(hVar).zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var));
            }
        }
        return Tasks.forException(zzach.zza(new Status(17015)));
    }

    public final Task<Void> zza(f fVar, a0 a0Var, j jVar, String str, j1.e1 e1Var) {
        return zza((zzaay) new zzaay(jVar, str).zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<Void> zza(f fVar, a0 a0Var, o0 o0Var, j1.e1 e1Var) {
        zzads.zza();
        return zza((zzabz) new zzabz(o0Var).zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<Void> zza(f fVar, a0 a0Var, o0 o0Var, String str, j1.e1 e1Var) {
        zzads.zza();
        return zza((zzabc) new zzabc(o0Var, str).zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<com.google.firebase.auth.i> zza(f fVar, a0 a0Var, r0 r0Var, String str, q1 q1Var) {
        zzads.zza();
        zzaao zzaaoVar = new zzaao(r0Var, str, null);
        zzaaoVar.zza(fVar).zza((zzacw<com.google.firebase.auth.i, q1>) q1Var);
        if (a0Var != null) {
            zzaaoVar.zza(a0Var);
        }
        return zza(zzaaoVar);
    }

    public final Task<com.google.firebase.auth.i> zza(f fVar, a0 a0Var, x0 x0Var, String str, String str2, q1 q1Var) {
        zzaao zzaaoVar = new zzaao(x0Var, str, str2);
        zzaaoVar.zza(fVar).zza((zzacw<com.google.firebase.auth.i, q1>) q1Var);
        if (a0Var != null) {
            zzaaoVar.zza(a0Var);
        }
        return zza(zzaaoVar);
    }

    public final Task<Void> zza(f fVar, a0 a0Var, j1.e1 e1Var) {
        return zza((zzabe) new zzabe().zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<c0> zza(f fVar, a0 a0Var, String str, j1.e1 e1Var) {
        return zza((zzaar) new zzaar(str).zza(fVar).zza(a0Var).zza((zzacw<c0, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<Void> zza(f fVar, a0 a0Var, String str, String str2, j1.e1 e1Var) {
        return zza((zzabs) new zzabs(a0Var.zze(), str, str2).zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<Void> zza(f fVar, a0 a0Var, String str, String str2, String str3, String str4, j1.e1 e1Var) {
        return zza((zzaba) new zzaba(str, str2, str3, str4).zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<Void> zza(f fVar, com.google.firebase.auth.e eVar, String str) {
        return zza((zzabg) new zzabg(str, eVar).zza(fVar));
    }

    public final Task<com.google.firebase.auth.i> zza(f fVar, h hVar, String str, q1 q1Var) {
        return zza((zzabk) new zzabk(hVar, str).zza(fVar).zza((zzacw<com.google.firebase.auth.i, q1>) q1Var));
    }

    public final Task<com.google.firebase.auth.i> zza(f fVar, j jVar, String str, q1 q1Var) {
        return zza((zzabp) new zzabp(jVar, str).zza(fVar).zza((zzacw<com.google.firebase.auth.i, q1>) q1Var));
    }

    public final Task<com.google.firebase.auth.i> zza(f fVar, o0 o0Var, String str, q1 q1Var) {
        zzads.zza();
        return zza((zzabo) new zzabo(o0Var, str).zza(fVar).zza((zzacw<com.google.firebase.auth.i, q1>) q1Var));
    }

    public final Task<Void> zza(f fVar, r0 r0Var, a0 a0Var, String str, q1 q1Var) {
        zzads.zza();
        zzaap zzaapVar = new zzaap(r0Var, a0Var.zze(), str, null);
        zzaapVar.zza(fVar).zza((zzacw<Void, q1>) q1Var);
        return zza(zzaapVar);
    }

    public final Task<Void> zza(f fVar, x0 x0Var, a0 a0Var, String str, String str2, q1 q1Var) {
        zzaap zzaapVar = new zzaap(x0Var, a0Var.zze(), str, str2);
        zzaapVar.zza(fVar).zza((zzacw<Void, q1>) q1Var);
        return zza(zzaapVar);
    }

    public final Task<com.google.firebase.auth.i> zza(f fVar, q1 q1Var, String str) {
        return zza((zzabl) new zzabl(str).zza(fVar).zza((zzacw<com.google.firebase.auth.i, q1>) q1Var));
    }

    public final Task<Void> zza(f fVar, String str, com.google.firebase.auth.e eVar, String str2, String str3) {
        eVar.B(1);
        return zza((zzabj) new zzabj(str, eVar, str2, str3, "sendPasswordResetEmail").zza(fVar));
    }

    public final Task<Void> zza(f fVar, String str, String str2) {
        return zza((zzaaj) new zzaaj(str, str2).zza(fVar));
    }

    public final Task<com.google.firebase.auth.i> zza(f fVar, String str, String str2, q1 q1Var) {
        return zza((zzabn) new zzabn(str, str2).zza(fVar).zza((zzacw<com.google.firebase.auth.i, q1>) q1Var));
    }

    public final Task<Void> zza(f fVar, String str, String str2, String str3) {
        return zza((zzaal) new zzaal(str, str2, str3).zza(fVar));
    }

    public final Task<com.google.firebase.auth.i> zza(f fVar, String str, String str2, String str3, String str4, q1 q1Var) {
        return zza((zzaak) new zzaak(str, str2, str3, str4).zza(fVar).zza((zzacw<com.google.firebase.auth.i, q1>) q1Var));
    }

    public final Task<Void> zza(p pVar, t0 t0Var, String str, long j5, boolean z4, boolean z5, String str2, String str3, boolean z6, q0.b bVar, Executor executor, Activity activity) {
        zzabt zzabtVar = new zzabt(t0Var, q.e(pVar.zzc()), str, j5, z4, z5, str2, str3, z6);
        zzabtVar.zza(bVar, activity, executor, t0Var.a());
        return zza(zzabtVar);
    }

    public final Task<zzagi> zza(p pVar, String str) {
        return zza(new zzabq(pVar, str));
    }

    public final Task<Void> zza(p pVar, String str, String str2, long j5, boolean z4, boolean z5, String str3, String str4, boolean z6, q0.b bVar, Executor executor, Activity activity) {
        zzabr zzabrVar = new zzabr(pVar, str, str2, j5, z4, z5, str3, str4, z6);
        zzabrVar.zza(bVar, activity, executor, str);
        return zza(zzabrVar);
    }

    public final Task<Void> zza(String str) {
        return zza(new zzabi(str));
    }

    public final Task<zzafj> zza(String str, String str2) {
        return zza(new zzaat(str, str2));
    }

    public final Task<Void> zza(String str, String str2, com.google.firebase.auth.e eVar) {
        eVar.B(7);
        return zza(new zzacb(str, str2, eVar));
    }

    public final Task<Void> zza(String str, String str2, String str3, String str4) {
        return zza(new zzabh(str, str2, str3, str4));
    }

    public final void zza(f fVar, zzafz zzafzVar, q0.b bVar, Activity activity, Executor executor) {
        zza((zzacd) new zzacd(zzafzVar).zza(fVar).zza(bVar, activity, executor, zzafzVar.zzd()));
    }

    public final Task<Void> zzb(f fVar, a0 a0Var, h hVar, String str, j1.e1 e1Var) {
        return zza((zzaaw) new zzaaw(hVar, str).zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<com.google.firebase.auth.i> zzb(f fVar, a0 a0Var, j jVar, String str, j1.e1 e1Var) {
        return zza((zzabb) new zzabb(jVar, str).zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<com.google.firebase.auth.i> zzb(f fVar, a0 a0Var, o0 o0Var, String str, j1.e1 e1Var) {
        zzads.zza();
        return zza((zzabf) new zzabf(o0Var, str).zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<com.google.firebase.auth.i> zzb(f fVar, a0 a0Var, String str, j1.e1 e1Var) {
        q.k(fVar);
        q.e(str);
        q.k(a0Var);
        q.k(e1Var);
        List<String> U = a0Var.U();
        if ((U == null || U.contains(str)) && !a0Var.z()) {
            str.hashCode();
            return !str.equals("password") ? zza((zzabu) new zzabu(str).zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var)) : zza((zzabv) new zzabv().zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var));
        }
        return Tasks.forException(zzach.zza(new Status(17016, str)));
    }

    public final Task<com.google.firebase.auth.i> zzb(f fVar, a0 a0Var, String str, String str2, String str3, String str4, j1.e1 e1Var) {
        return zza((zzabd) new zzabd(str, str2, str3, str4).zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<Void> zzb(f fVar, String str, com.google.firebase.auth.e eVar, String str2, String str3) {
        eVar.B(6);
        return zza((zzabj) new zzabj(str, eVar, str2, str3, "sendSignInLinkToEmail").zza(fVar));
    }

    public final Task<d> zzb(f fVar, String str, String str2) {
        return zza((zzaai) new zzaai(str, str2).zza(fVar));
    }

    public final Task<com.google.firebase.auth.i> zzb(f fVar, String str, String str2, String str3, String str4, q1 q1Var) {
        return zza((zzabm) new zzabm(str, str2, str3, str4).zza(fVar).zza((zzacw<com.google.firebase.auth.i, q1>) q1Var));
    }

    public final Task<com.google.firebase.auth.i> zzc(f fVar, a0 a0Var, h hVar, String str, j1.e1 e1Var) {
        return zza((zzaaz) new zzaaz(hVar, str).zza(fVar).zza(a0Var).zza((zzacw<com.google.firebase.auth.i, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<Void> zzc(f fVar, a0 a0Var, String str, j1.e1 e1Var) {
        return zza((zzabx) new zzabx(str).zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<w0> zzc(f fVar, String str, String str2) {
        return zza((zzaam) new zzaam(str, str2).zza(fVar));
    }

    public final Task<Void> zzd(f fVar, a0 a0Var, String str, j1.e1 e1Var) {
        return zza((zzabw) new zzabw(str).zza(fVar).zza(a0Var).zza((zzacw<Void, q1>) e1Var).zza((x) e1Var));
    }

    public final Task<String> zzd(f fVar, String str, String str2) {
        return zza((zzaca) new zzaca(str, str2).zza(fVar));
    }
}
