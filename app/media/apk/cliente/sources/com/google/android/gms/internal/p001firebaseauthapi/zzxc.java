package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.Provider;
import javax.crypto.Cipher;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxc  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxc implements zzwz<Cipher> {
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzwz
    public final /* synthetic */ Cipher zza(String str, Provider provider) {
        return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
    }
}
