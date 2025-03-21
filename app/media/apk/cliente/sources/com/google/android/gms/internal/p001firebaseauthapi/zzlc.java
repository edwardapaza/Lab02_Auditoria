package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlc  reason: invalid package */
/* loaded from: classes.dex */
final class zzlc implements zzbp {
    private static final byte[] zza = new byte[0];
    private final zzli zzb;
    private final zzlg zzc;
    private final zzld zzd;
    private final zzla zze;
    private final int zzf;
    private final byte[] zzg;

    private zzlc(zzli zzliVar, zzlg zzlgVar, zzld zzldVar, zzla zzlaVar, int i5, zzxr zzxrVar) {
        this.zzb = zzliVar;
        this.zzc = zzlgVar;
        this.zzd = zzldVar;
        this.zze = zzlaVar;
        this.zzf = i5;
        this.zzg = zzxrVar.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzlc zza(zzut zzutVar) {
        int i5;
        zzli zza2;
        if (zzutVar.zzf()) {
            if (zzutVar.zzd().zzg()) {
                if (zzutVar.zze().zze()) {
                    throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
                }
                zzus zzb = zzutVar.zzd().zzb();
                zzlg zzc = zzlh.zzc(zzb);
                zzld zzb2 = zzlh.zzb(zzb);
                zzla zza3 = zzlh.zza(zzb);
                zzum zzc2 = zzb.zzc();
                int i6 = zzlb.zza[zzc2.ordinal()];
                if (i6 == 1) {
                    i5 = 32;
                } else if (i6 == 2) {
                    i5 = 65;
                } else if (i6 == 3) {
                    i5 = 97;
                } else if (i6 != 4) {
                    String name = zzc2.name();
                    throw new IllegalArgumentException("Unable to determine KEM-encoding length for " + name);
                } else {
                    i5 = 133;
                }
                int i7 = zzlf.zza[zzutVar.zzd().zzb().zzc().ordinal()];
                if (i7 == 1) {
                    zza2 = zzlw.zza(zzutVar.zze().zzg());
                } else if (i7 != 2 && i7 != 3 && i7 != 4) {
                    throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
                } else {
                    zza2 = zzlu.zza(zzutVar.zze().zzg(), zzutVar.zzd().zzf().zzg(), zzlq.zzc(zzutVar.zzd().zzb().zzc()));
                }
                return new zzlc(zza2, zzc, zzb2, zza3, i5, zzxr.zza(new byte[0]));
            }
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        }
        throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
    }

    private final byte[] zzb(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i5 = this.zzf;
        if (length >= i5) {
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] copyOf = Arrays.copyOf(bArr, i5);
            return zzkz.zza(copyOf, this.zzb, this.zzc, this.zzd, this.zze, bArr3).zza(Arrays.copyOfRange(bArr, this.zzf, bArr.length), zza);
        }
        throw new GeneralSecurityException("Ciphertext is too short.");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbp
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = this.zzg;
        if (bArr3.length == 0) {
            return zzb(bArr, bArr2);
        }
        if (zzpg.zza(bArr3, bArr)) {
            return zzb(Arrays.copyOfRange(bArr, this.zzg.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }
}
