package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.KeyPairGenerator;
import java.security.Provider;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxd  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxd implements zzwz<KeyPairGenerator> {
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzwz
    public final /* synthetic */ KeyPairGenerator zza(String str, Provider provider) {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }
}
