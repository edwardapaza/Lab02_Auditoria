package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.SecureRandom;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzou  reason: invalid package */
/* loaded from: classes.dex */
final class zzou extends ThreadLocal<SecureRandom> {
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SecureRandom initialValue() {
        return zzov.zza();
    }
}
