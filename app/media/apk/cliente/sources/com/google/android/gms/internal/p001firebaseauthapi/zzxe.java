package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.KeyFactory;
import java.security.Provider;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxe  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxe implements zzwz<KeyFactory> {
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzwz
    public final /* synthetic */ KeyFactory zza(String str, Provider provider) {
        return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
    }
}
