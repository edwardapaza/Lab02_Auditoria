package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.Provider;
import javax.crypto.Mac;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxg  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxg implements zzwz<Mac> {
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzwz
    public final /* synthetic */ Mac zza(String str, Provider provider) {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
