package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwy  reason: invalid package */
/* loaded from: classes.dex */
final class zzwy<JcePrimitiveT> implements zzxa<JcePrimitiveT> {
    private final zzwz<JcePrimitiveT> zza;

    private zzwy(zzwz<JcePrimitiveT> zzwzVar) {
        this.zza = zzwzVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzxa
    public final JcePrimitiveT zza(String str) {
        Exception exc = null;
        for (Provider provider : zzwr.zza("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt")) {
            try {
                return this.zza.zza(str, provider);
            } catch (Exception e5) {
                if (exc == null) {
                    exc = e5;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
