package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.MessageDigest;
import java.security.Provider;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxf  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxf implements zzwz<MessageDigest> {
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzwz
    public final /* synthetic */ MessageDigest zza(String str, Provider provider) {
        return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
    }
}
