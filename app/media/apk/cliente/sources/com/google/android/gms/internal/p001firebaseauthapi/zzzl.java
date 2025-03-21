package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import j1.r;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzl  reason: invalid package */
/* loaded from: classes.dex */
final class zzzl implements zzadm<zzahc> {
    private final /* synthetic */ zzzi zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzl(zzzi zzziVar) {
        this.zza = zzziVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzahc zzahcVar) {
        zzahc zzahcVar2 = zzahcVar;
        if (TextUtils.isEmpty(zzahcVar2.zza()) || TextUtils.isEmpty(zzahcVar2.zzb())) {
            this.zza.zza.zza(r.a("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        zzafm zzafmVar = new zzafm(zzahcVar2.zzb(), zzahcVar2.zza(), Long.valueOf(zzafo.zza(zzahcVar2.zza())), "Bearer");
        zzzi zzziVar = this.zza;
        zzziVar.zzb.zza(zzafmVar, null, null, Boolean.FALSE, null, zzziVar.zza, this);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza.zza(r.a(str));
    }
}
