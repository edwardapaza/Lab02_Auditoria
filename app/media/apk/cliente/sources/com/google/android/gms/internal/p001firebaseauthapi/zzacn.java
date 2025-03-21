package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacn  reason: invalid package */
/* loaded from: classes.dex */
public class zzacn {
    final zzacv zza;
    private final String zzb;

    public zzacn(String str, zzacv zzacvVar) {
        this.zzb = str;
        this.zza = zzacvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza(String str, String str2) {
        String str3 = this.zzb;
        return str3 + str + "?key=" + str2;
    }
}
