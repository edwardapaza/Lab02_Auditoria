package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzho  reason: invalid package */
/* loaded from: classes.dex */
abstract class zzho {
    int[] zza;
    private final int zzb;

    public zzho(byte[] bArr, int i5) {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzhk.zza(bArr);
        this.zzb = i5;
    }

    private final void zza(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (bArr.length != zza()) {
            int zza = zza();
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza);
        }
        int remaining = byteBuffer2.remaining();
        int i5 = (remaining / 64) + 1;
        for (int i6 = 0; i6 < i5; i6++) {
            ByteBuffer zza2 = zza(bArr, this.zzb + i6);
            if (i6 == i5 - 1) {
                zzwi.zza(byteBuffer, byteBuffer2, zza2, remaining % 64);
            } else {
                zzwi.zza(byteBuffer, byteBuffer2, zza2, 64);
            }
        }
    }

    abstract int zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteBuffer zza(byte[] bArr, int i5) {
        int[] zza = zza(zzhk.zza(bArr), i5);
        int[] iArr = (int[]) zza.clone();
        zzhk.zza(iArr);
        for (int i6 = 0; i6 < zza.length; i6++) {
            zza[i6] = zza[i6] + iArr[i6];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zza, 0, 16);
        return order;
    }

    public void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        zza(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
    }

    public byte[] zza(byte[] bArr, ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        zza(bArr, allocate, byteBuffer);
        return allocate.array();
    }

    abstract int[] zza(int[] iArr, int i5);
}
