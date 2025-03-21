package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.Provider;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu  reason: invalid package */
/* loaded from: classes.dex */
final class zzwu<JcePrimitiveT> implements zzxa<JcePrimitiveT> {
    private final zzwz<JcePrimitiveT> zza;

    private zzwu(zzwz<JcePrimitiveT> zzwzVar) {
        this.zza = zzwzVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzxa
    public final JcePrimitiveT zza(String str) {
        Exception exc = null;
        for (Provider provider : zzwr.zza("GmsCore_OpenSSL", "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, provider);
            } catch (Exception e5) {
                if (exc == null) {
                    exc = e5;
                }
            }
        }
        return this.zza.zza(str, null);
    }
}
