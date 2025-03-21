package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzag  reason: invalid package */
/* loaded from: classes.dex */
final class zzag extends zzaf {
    private final /* synthetic */ zzp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzag(zzad zzadVar, zzac zzacVar, CharSequence charSequence, zzp zzpVar) {
        super(zzacVar, charSequence);
        this.zzb = zzpVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaf
    public final int zza(int i5) {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaf
    public final int zzb(int i5) {
        if (this.zzb.zza(i5)) {
            return this.zzb.zzb();
        }
        return -1;
    }
}
