package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhp  reason: invalid package */
/* loaded from: classes.dex */
public final class zzhp extends zzho {
    public zzhp(byte[] bArr, int i5) {
        super(bArr, i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzho
    public final int zza() {
        return 12;
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
    public final int[] zza(int[] iArr, int i5) {
        if (iArr.length == 3) {
            int[] iArr2 = new int[16];
            zzhk.zza(iArr2, this.zza);
            iArr2[12] = i5;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
    }
}
