package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.regex.Matcher;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzt  reason: invalid package */
/* loaded from: classes.dex */
final class zzt extends zzp {
    private final Matcher zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(Matcher matcher) {
        this.zza = (Matcher) zzz.zza(matcher);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzp
    public final int zza() {
        return this.zza.end();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzp
    public final boolean zza(int i5) {
        return this.zza.find(i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzp
    public final int zzb() {
        return this.zza.start();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzp
    public final boolean zzc() {
        return this.zza.matches();
    }
}
