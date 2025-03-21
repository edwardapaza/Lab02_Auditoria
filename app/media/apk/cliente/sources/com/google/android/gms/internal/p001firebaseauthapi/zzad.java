package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzad  reason: invalid package */
/* loaded from: classes.dex */
public final class zzad implements zzai {
    private final /* synthetic */ zzs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzs zzsVar) {
        this.zza = zzsVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzai
    public final /* synthetic */ Iterator zza(zzac zzacVar, CharSequence charSequence) {
        return new zzag(this, zzacVar, charSequence, this.zza.zza(charSequence));
    }
}
