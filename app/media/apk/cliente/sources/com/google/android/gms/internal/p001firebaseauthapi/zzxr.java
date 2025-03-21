package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxr  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxr {
    private final byte[] zza;

    private zzxr(byte[] bArr, int i5, int i6) {
        byte[] bArr2 = new byte[i6];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i6);
    }

    public static zzxr zza(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if (length > bArr.length) {
                length = bArr.length;
            }
            return new zzxr(bArr, 0, length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzxr) {
            return Arrays.equals(((zzxr) obj).zza, this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String zza = zzxh.zza(this.zza);
        return "Bytes(" + zza + ")";
    }

    public final int zza() {
        return this.zza.length;
    }

    public final byte[] zzb() {
        byte[] bArr = this.zza;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
