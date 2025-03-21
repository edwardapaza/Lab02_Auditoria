package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.Provider;
import java.security.Signature;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxi  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxi implements zzwz<Signature> {
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzwz
    public final /* synthetic */ Signature zza(String str, Provider provider) {
        return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
    }
}
