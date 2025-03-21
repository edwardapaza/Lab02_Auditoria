package com.google.android.gms.internal.p001firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagg  reason: invalid package */
/* loaded from: classes.dex */
public class zzagg implements zzacq<zzagg> {
    private static final String zza = "zzagg";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private long zzf;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzagg zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = m.a(jSONObject.optString("idToken", null));
            this.zzc = m.a(jSONObject.optString("displayName", null));
            this.zzd = m.a(jSONObject.optString("email", null));
            this.zze = m.a(jSONObject.optString("refreshToken", null));
            this.zzf = jSONObject.optLong("expiresIn", 0L);
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final long zza() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zze;
    }
}
