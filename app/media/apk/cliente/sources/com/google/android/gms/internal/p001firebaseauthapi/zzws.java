package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzws  reason: invalid package */
/* loaded from: classes.dex */
public final class zzws implements zzbh {
    private final zzxk zza;
    private final zzcf zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzws(zzxk zzxkVar, zzcf zzcfVar, int i5, byte[] bArr) {
        this.zza = zzxkVar;
        this.zzb = zzcfVar;
        this.zzc = i5;
        this.zzd = bArr;
    }

    public static zzbh zza(zzdf zzdfVar) {
        zzwa zzwaVar = new zzwa(zzdfVar.zze().zza(zzbr.zza()), zzdfVar.zzc().zzd());
        String valueOf = String.valueOf(zzdfVar.zzc().zzg());
        return new zzws(zzwaVar, new zzxo(new zzxm("HMAC" + valueOf, new SecretKeySpec(zzdfVar.zzf().zza(zzbr.zza()), "HMAC")), zzdfVar.zzc().zze()), zzdfVar.zzc().zze(), zzdfVar.zzd().zzb());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i5 = this.zzc;
        byte[] bArr3 = this.zzd;
        if (length >= i5 + bArr3.length) {
            if (zzpg.zza(bArr3, bArr)) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, bArr.length - this.zzc);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.zzc, bArr.length);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                this.zzb.zza(copyOfRange2, zzwi.zza(bArr2, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
                return this.zza.zza(copyOfRange);
            }
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        byte[] zzb = this.zza.zzb(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzwi.zza(this.zzd, zzb, this.zzb.zza(zzwi.zza(bArr2, zzb, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }
}
