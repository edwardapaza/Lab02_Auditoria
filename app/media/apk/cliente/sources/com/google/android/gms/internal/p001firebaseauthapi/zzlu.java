package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlu  reason: invalid package */
/* loaded from: classes.dex */
final class zzlu implements zzli {
    private final zzxr zza;
    private final zzxr zzb;

    private zzlu(byte[] bArr, byte[] bArr2) {
        this.zza = zzxr.zza(bArr);
        this.zzb = zzxr.zza(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzlu zza(byte[] bArr, byte[] bArr2, zzwq zzwqVar) {
        zzwn.zza(zzwn.zza(zzwqVar, zzwp.UNCOMPRESSED, bArr2), zzwn.zza(zzwqVar, bArr));
        return new zzlu(bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzli
    public final zzxr zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzli
    public final zzxr zzb() {
        return this.zzb;
    }
}
