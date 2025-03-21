package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.regex.Pattern;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzx  reason: invalid package */
/* loaded from: classes.dex */
final class zzx implements zzv {
    private zzx() {
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzv
    public final zzs zza(String str) {
        return new zzu(Pattern.compile(str));
    }
}
