package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamn  reason: invalid package */
/* loaded from: classes.dex */
abstract class zzamn {
    abstract int zza(int i5, byte[] bArr, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(String str, byte[] bArr, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String zza(byte[] bArr, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(byte[] bArr, int i5, int i6) {
        return zza(0, bArr, i5, i6) == 0;
    }
}
