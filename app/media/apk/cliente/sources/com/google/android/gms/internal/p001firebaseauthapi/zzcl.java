package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcl  reason: invalid package */
/* loaded from: classes.dex */
final class zzcl implements Comparable<zzcl> {
    private final byte[] zza;

    private zzcl(byte[] bArr) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzcl zzclVar) {
        zzcl zzclVar2 = zzclVar;
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = zzclVar2.zza;
        if (length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        int i5 = 0;
        while (true) {
            byte[] bArr3 = this.zza;
            if (i5 >= bArr3.length) {
                return 0;
            }
            byte b5 = bArr3[i5];
            byte b6 = zzclVar2.zza[i5];
            if (b5 != b6) {
                return b5 - b6;
            }
            i5++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzcl) {
            return Arrays.equals(this.zza, ((zzcl) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzxh.zza(this.zza);
    }
}
