package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzle  reason: invalid package */
/* loaded from: classes.dex */
final class zzle implements zzbs {
    private static final byte[] zza = new byte[0];
    private final byte[] zzb;
    private final zzlg zzc;
    private final zzld zzd;
    private final zzla zze;
    private final byte[] zzf;

    private zzle(zzxr zzxrVar, zzlg zzlgVar, zzld zzldVar, zzla zzlaVar, zzxr zzxrVar2) {
        this.zzb = zzxrVar.zzb();
        this.zzc = zzlgVar;
        this.zzd = zzldVar;
        this.zze = zzlaVar;
        this.zzf = zzxrVar2.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzle zza(zzuw zzuwVar) {
        if (zzuwVar.zzf().zze()) {
            throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
        }
        zzus zzb = zzuwVar.zzb();
        return new zzle(zzxr.zza(zzuwVar.zzf().zzg()), zzlh.zzc(zzb), zzlh.zzb(zzb), zzlh.zza(zzb), zzxr.zza(new byte[0]));
    }
}
