package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxt  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxt {
    private final zzxr zza;

    private zzxt(zzxr zzxrVar) {
        this.zza = zzxrVar;
    }

    public static zzxt zza(int i5) {
        return new zzxt(zzxr.zza(zzov.zza(i5)));
    }

    public static zzxt zza(byte[] bArr, zzct zzctVar) {
        if (zzctVar != null) {
            return new zzxt(zzxr.zza(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final byte[] zza(zzct zzctVar) {
        if (zzctVar != null) {
            return this.zza.zzb();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
