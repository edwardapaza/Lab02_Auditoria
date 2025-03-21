package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.firebase.auth.h;
import com.google.firebase.auth.o0;
import j1.r;
import j1.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacy  reason: invalid package */
/* loaded from: classes.dex */
public final class zzacy implements zzacc {
    final /* synthetic */ zzacw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacy(zzacw zzacwVar) {
        this.zza = zzacwVar;
    }

    private final void zza(Status status, h hVar, String str, String str2) {
        zzacw.zza(this.zza, status);
        zzacw zzacwVar = this.zza;
        zzacwVar.zzp = hVar;
        zzacwVar.zzq = str;
        zzacwVar.zzr = str2;
        x xVar = zzacwVar.zzf;
        if (xVar != null) {
            xVar.zza(status);
        }
        this.zza.zza(status);
    }

    private final void zza(zzadd zzaddVar) {
        this.zza.zzi.execute(new zzade(this, zzaddVar));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza() {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 5;
        q.n(z4, "Unexpected response type " + i5);
        zzacw.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(Status status) {
        String v5 = status.v();
        if (v5 != null) {
            if (v5.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (v5.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (v5.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (v5.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (v5.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (v5.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (v5.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (v5.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (v5.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (v5.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzacw zzacwVar = this.zza;
        if (zzacwVar.zza != 8) {
            zzacw.zza(zzacwVar, status);
            this.zza.zza(status);
            return;
        }
        zzacwVar.zzz = true;
        this.zza.zzx = false;
        zza(new zzadb(this, status));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(Status status, o0 o0Var) {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 2;
        q.n(z4, "Unexpected response type " + i5);
        zza(status, o0Var, null, null);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzaem zzaemVar) {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 3;
        q.n(z4, "Unexpected response type " + i5);
        zzacw zzacwVar = this.zza;
        zzacwVar.zzl = zzaemVar;
        zzacw.zza(zzacwVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzafi zzafiVar) {
        zzacw zzacwVar = this.zza;
        zzacwVar.zzu = zzafiVar;
        zzacw.zza(zzacwVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzafj zzafjVar) {
        zzacw zzacwVar = this.zza;
        zzacwVar.zzt = zzafjVar;
        zzacw.zza(zzacwVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzafm zzafmVar) {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 1;
        q.n(z4, "Unexpected response type: " + i5);
        zzacw zzacwVar = this.zza;
        zzacwVar.zzj = zzafmVar;
        zzacw.zza(zzacwVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzafm zzafmVar, zzafb zzafbVar) {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 2;
        q.n(z4, "Unexpected response type: " + i5);
        zzacw zzacwVar = this.zza;
        zzacwVar.zzj = zzafmVar;
        zzacwVar.zzk = zzafbVar;
        zzacw.zza(zzacwVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzafv zzafvVar) {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 4;
        q.n(z4, "Unexpected response type " + i5);
        zzacw zzacwVar = this.zza;
        zzacwVar.zzm = zzafvVar;
        zzacw.zza(zzacwVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzaga zzagaVar) {
        zzacw zzacwVar = this.zza;
        zzacwVar.zzw = zzagaVar;
        zzacw.zza(zzacwVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzagi zzagiVar) {
        zzacw zzacwVar = this.zza;
        zzacwVar.zzv = zzagiVar;
        zzacw.zza(zzacwVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzyi zzyiVar) {
        zzacw zzacwVar = this.zza;
        zzacwVar.zzs = zzyiVar;
        zzacwVar.zza(r.a("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(zzyj zzyjVar) {
        zza(zzyjVar.zza(), zzyjVar.zzb(), zzyjVar.zzc(), zzyjVar.zzd());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(o0 o0Var) {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 8;
        q.n(z4, "Unexpected response type " + i5);
        this.zza.zzz = true;
        this.zza.zzx = true;
        zza(new zzacz(this, o0Var));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zza(String str) {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 8;
        q.n(z4, "Unexpected response type " + i5);
        zzacw zzacwVar = this.zza;
        zzacwVar.zzo = str;
        zzacwVar.zzz = true;
        this.zza.zzx = true;
        zza(new zzadc(this, str));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zzb() {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 6;
        q.n(z4, "Unexpected response type " + i5);
        zzacw.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zzb(String str) {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 8;
        q.n(z4, "Unexpected response type " + i5);
        this.zza.zzo = str;
        zza(new zzada(this, str));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zzc() {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 9;
        q.n(z4, "Unexpected response type " + i5);
        zzacw.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacc
    public final void zzc(String str) {
        int i5 = this.zza.zza;
        boolean z4 = i5 == 7;
        q.n(z4, "Unexpected response type " + i5);
        zzacw zzacwVar = this.zza;
        zzacwVar.zzn = str;
        zzacw.zza(zzacwVar);
    }
}
