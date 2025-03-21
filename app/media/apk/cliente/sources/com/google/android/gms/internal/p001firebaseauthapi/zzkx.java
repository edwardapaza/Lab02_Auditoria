package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkx  reason: invalid package */
/* loaded from: classes.dex */
final class zzkx implements zzld {
    private final String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkx(String str) {
        this.zza = str;
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2) {
        Mac zza = zzwr.zzb.zza(this.zza);
        if (bArr2 == null || bArr2.length == 0) {
            zza.init(new SecretKeySpec(new byte[zza.getMacLength()], this.zza));
        } else {
            zza.init(new SecretKeySpec(bArr2, this.zza));
        }
        return zza.doFinal(bArr);
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2, int i5) {
        Mac zza = zzwr.zzb.zza(this.zza);
        if (i5 > zza.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i5];
        zza.init(new SecretKeySpec(bArr, this.zza));
        byte[] bArr4 = new byte[0];
        int i6 = 1;
        int i7 = 0;
        while (true) {
            zza.update(bArr4);
            zza.update(bArr2);
            zza.update((byte) i6);
            bArr4 = zza.doFinal();
            if (bArr4.length + i7 >= i5) {
                System.arraycopy(bArr4, 0, bArr3, i7, i5 - i7);
                return bArr3;
            }
            System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
            i7 += bArr4.length;
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() {
        return Mac.getInstance(this.zza).getMacLength();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzld
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return zza(zzlq.zza(str, bArr2, bArr3), bArr);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzld
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i5) {
        return zza(bArr, zzlq.zza(str, bArr2, bArr3, i5), i5);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i5) {
        return zza(zza(zzlq.zza(str, bArr2, bArr4), null), zzlq.zza(str2, bArr3, bArr4, i5), i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzld
    public final byte[] zzb() {
        String str = this.zza;
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case 984523022:
                if (str.equals("HmacSha256")) {
                    c5 = 0;
                    break;
                }
                break;
            case 984524074:
                if (str.equals("HmacSha384")) {
                    c5 = 1;
                    break;
                }
                break;
            case 984525777:
                if (str.equals("HmacSha512")) {
                    c5 = 2;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return zzlq.zzf;
            case 1:
                return zzlq.zzg;
            case 2:
                return zzlq.zzh;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }
}
