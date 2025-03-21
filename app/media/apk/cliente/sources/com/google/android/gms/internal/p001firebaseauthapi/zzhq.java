package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhq  reason: invalid package */
/* loaded from: classes.dex */
abstract class zzhq {
    private static final zzic.zza zza = zzic.zza.zza;
    private final zzho zzb;
    private final zzho zzc;

    public zzhq(byte[] bArr) {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.zzb = zza(bArr, 1);
        this.zzc = zza(bArr, 0);
    }

    private final byte[] zza(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        this.zzc.zza(bArr, 0).get(bArr2);
        return bArr2;
    }

    private static byte[] zza(byte[] bArr, ByteBuffer byteBuffer) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int remaining = byteBuffer.remaining();
        int i5 = remaining % 16;
        int i6 = (i5 == 0 ? remaining : (remaining + 16) - i5) + length;
        ByteBuffer order = ByteBuffer.allocate(i6 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(length);
        order.put(byteBuffer);
        order.position(i6);
        order.putLong(bArr.length);
        order.putLong(remaining);
        return order.array();
    }

    abstract zzho zza(byte[] bArr, int i5);

    public void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (byteBuffer.remaining() < bArr2.length + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int position = byteBuffer.position();
        this.zzb.zza(byteBuffer, bArr, bArr2);
        byteBuffer.position(position);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        byte[] zza2 = zzhv.zza(zza(bArr), zza(bArr3, byteBuffer));
        byteBuffer.limit(byteBuffer.limit() + 16);
        byteBuffer.put(zza2);
    }

    public byte[] zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        if (byteBuffer.remaining() >= 16) {
            int position = byteBuffer.position();
            byte[] bArr3 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(bArr3);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            try {
                if (!MessageDigest.isEqual(zzhv.zza(zza(bArr), zza(bArr2, byteBuffer)), bArr3)) {
                    throw new GeneralSecurityException("invalid MAC");
                }
                byteBuffer.position(position);
                return this.zzb.zza(bArr, byteBuffer);
            } catch (GeneralSecurityException e5) {
                throw new AEADBadTagException(e5.toString());
            }
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return zza(ByteBuffer.wrap(bArr2), bArr, bArr3);
    }
}
