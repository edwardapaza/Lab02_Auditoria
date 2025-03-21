package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxs  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxs implements zzbh {
    private final zzhs zza;
    private final byte[] zzb;

    private zzxs(byte[] bArr, byte[] bArr2) {
        this.zza = new zzhs(bArr);
        this.zzb = bArr2;
    }

    public static zzbh zza(zzha zzhaVar) {
        return new zzxs(zzhaVar.zzd().zza(zzbr.zza()), zzhaVar.zzc().zzb());
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) {
        if (bArr.length >= 40) {
            byte[] copyOf = Arrays.copyOf(bArr, 24);
            return this.zza.zza(ByteBuffer.wrap(bArr, 24, bArr.length - 24), copyOf, bArr2);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzpg.zza(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 24 + 16);
        byte[] zza = zzov.zza(24);
        allocate.put(zza);
        this.zza.zza(allocate, zza, bArr, bArr2);
        byte[] array = allocate.array();
        byte[] bArr3 = this.zzb;
        return bArr3.length == 0 ? array : zzwi.zza(bArr3, array);
    }
}
