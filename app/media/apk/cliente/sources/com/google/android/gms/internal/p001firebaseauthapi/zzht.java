package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzht  reason: invalid package */
/* loaded from: classes.dex */
public final class zzht extends zzho {
    public zzht(byte[] bArr, int i5) {
        super(bArr, i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzho
    final int zza() {
        return 24;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzho
    public final /* bridge */ /* synthetic */ void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        super.zza(byteBuffer, bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzho
    public final /* bridge */ /* synthetic */ byte[] zza(byte[] bArr, ByteBuffer byteBuffer) {
        return super.zza(bArr, byteBuffer);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzho
    final int[] zza(int[] iArr, int i5) {
        if (iArr.length == 6) {
            int[] iArr2 = new int[16];
            zzhk.zza(r0, this.zza);
            int[] iArr3 = {0, 0, 0, 0, iArr3[12], iArr3[13], iArr3[14], iArr3[15], 0, 0, 0, 0, iArr[0], iArr[1], iArr[2], iArr[3]};
            zzhk.zza(iArr3);
            zzhk.zza(iArr2, Arrays.copyOf(iArr3, 8));
            iArr2[12] = i5;
            iArr2[13] = 0;
            iArr2[14] = iArr[4];
            iArr2[15] = iArr[5];
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
    }
}
