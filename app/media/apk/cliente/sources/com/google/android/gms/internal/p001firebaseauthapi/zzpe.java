package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpe  reason: invalid package */
/* loaded from: classes.dex */
public final class zzpe extends RuntimeException {
    public zzpe(String str) {
        super(str);
    }

    public zzpe(String str, Throwable th) {
        super(str, th);
    }

    private zzpe(Throwable th) {
        super(th);
    }

    public static <T> T zza(zzph<T> zzphVar) {
        try {
            return zzphVar.zza();
        } catch (Exception e5) {
            throw new zzpe(e5);
        }
    }
}
