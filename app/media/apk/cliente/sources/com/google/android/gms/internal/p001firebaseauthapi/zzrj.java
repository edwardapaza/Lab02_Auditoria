package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrj  reason: invalid package */
/* loaded from: classes.dex */
public final class zzrj implements zzcf {
    private static final byte[] zza = {0};
    private final zzcf zzb;
    private final zzvt zzc;
    private final byte[] zzd;

    private zzrj(zzcf zzcfVar, zzvt zzvtVar, byte[] bArr) {
        this.zzb = zzcfVar;
        this.zzc = zzvtVar;
        this.zzd = bArr;
    }

    public static zzcf zza(zznc zzncVar) {
        byte[] bArr;
        ByteBuffer put;
        zzot zza2 = zzncVar.zza(zzbr.zza());
        zzcf zzcfVar = (zzcf) zzox.zza().zza((zzux) ((zzaja) zzux.zza().zza(zza2.zzf()).zza(zza2.zzd()).zza(zza2.zza()).zzf()), zzcf.class);
        zzvt zzc = zza2.zzc();
        int i5 = zzrm.zza[zzc.ordinal()];
        if (i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                put = ByteBuffer.allocate(5).put((byte) 0);
            } else if (i5 != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            } else {
                put = ByteBuffer.allocate(5).put((byte) 1);
            }
            bArr = put.putInt(zzncVar.zza().intValue()).array();
        } else {
            bArr = new byte[0];
        }
        return new zzrj(zzcfVar, zzc, bArr);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcf
    public final void zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length < 10) {
            throw new GeneralSecurityException("tag too short");
        }
        if (this.zzc.equals(zzvt.LEGACY)) {
            bArr2 = zzwi.zza(bArr2, zza);
        }
        byte[] bArr3 = new byte[0];
        if (!this.zzc.equals(zzvt.RAW)) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            bArr = Arrays.copyOfRange(bArr, 5, bArr.length);
            bArr3 = copyOf;
        }
        if (!Arrays.equals(this.zzd, bArr3)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        this.zzb.zza(bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcf
    public final byte[] zza(byte[] bArr) {
        if (this.zzc.equals(zzvt.LEGACY)) {
            bArr = zzwi.zza(bArr, zza);
        }
        return zzwi.zza(this.zzd, this.zzb.zza(bArr));
    }
}
