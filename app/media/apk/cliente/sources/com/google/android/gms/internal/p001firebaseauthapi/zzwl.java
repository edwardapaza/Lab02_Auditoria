package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwl  reason: invalid package */
/* loaded from: classes.dex */
public final class zzwl {
    private ECPrivateKey zza;

    public zzwl(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i5, zzwp zzwpVar) {
        int i6 = 1;
        byte[] zza = zzwi.zza(bArr, zzwn.zza(this.zza, zzwn.zza(this.zza.getParams(), zzwpVar, bArr)));
        Mac zza2 = zzwr.zzb.zza(str);
        if (i5 > zza2.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr2 == null || bArr2.length == 0) {
            zza2.init(new SecretKeySpec(new byte[zza2.getMacLength()], str));
        } else {
            zza2.init(new SecretKeySpec(bArr2, str));
        }
        byte[] doFinal = zza2.doFinal(zza);
        byte[] bArr4 = new byte[i5];
        zza2.init(new SecretKeySpec(doFinal, str));
        byte[] bArr5 = new byte[0];
        int i7 = 0;
        while (true) {
            zza2.update(bArr5);
            zza2.update(bArr3);
            zza2.update((byte) i6);
            bArr5 = zza2.doFinal();
            if (bArr5.length + i7 >= i5) {
                System.arraycopy(bArr5, 0, bArr4, i7, i5 - i7);
                return bArr4;
            }
            System.arraycopy(bArr5, 0, bArr4, i7, bArr5.length);
            i7 += bArr5.length;
            i6++;
        }
    }
}
