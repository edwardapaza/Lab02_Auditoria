package com.google.android.gms.internal.p001firebaseauthapi;

import java.math.BigInteger;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmg  reason: invalid package */
/* loaded from: classes.dex */
final class zzmg {
    static final zzmg zza;
    BigInteger zzb;
    BigInteger zzc;
    BigInteger zzd;

    static {
        BigInteger bigInteger = BigInteger.ONE;
        zza = new zzmg(bigInteger, bigInteger, BigInteger.ZERO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmg(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.zzb = bigInteger;
        this.zzc = bigInteger2;
        this.zzd = bigInteger3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zzd.equals(BigInteger.ZERO);
    }
}
