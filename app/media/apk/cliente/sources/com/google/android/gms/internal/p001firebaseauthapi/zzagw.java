package com.google.android.gms.internal.p001firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagw  reason: invalid package */
/* loaded from: classes.dex */
public class zzagw implements zzacq<zzagw> {
    private static final String zza = "zzagw";
    private String zzb;
    private String zzc;
    private long zzd;
    private boolean zze;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzagw zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = m.a(jSONObject.optString("idToken", null));
            this.zzc = m.a(jSONObject.optString("refreshToken", null));
            this.zzd = jSONObject.optLong("expiresIn", 0L);
            this.zze = jSONObject.optBoolean("isNewUser", false);
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zze;
    }
}
