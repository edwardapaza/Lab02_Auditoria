package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.Provider;
import javax.crypto.KeyAgreement;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxb implements zzwz<KeyAgreement> {
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzwz
    public final /* synthetic */ KeyAgreement zza(String str, Provider provider) {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
