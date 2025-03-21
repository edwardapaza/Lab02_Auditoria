package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmc  reason: invalid package */
/* loaded from: classes.dex */
final class zzmc implements zzce {
    private final SharedPreferences.Editor zza;
    private final String zzb;

    public zzmc(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.zzb = str;
        Context applicationContext = context.getApplicationContext();
        this.zza = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).edit();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzce
    public final void zza(zzty zztyVar) {
        if (!this.zza.putString(this.zzb, zzxh.zza(zztyVar.zzj())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzce
    public final void zza(zzvh zzvhVar) {
        if (!this.zza.putString(this.zzb, zzxh.zza(zzvhVar.zzj())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
