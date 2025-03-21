package com.google.android.gms.internal.p001firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaha  reason: invalid package */
/* loaded from: classes.dex */
public class zzaha implements zzacq<zzaha> {
    private static final String zza = "zzaha";
    private String zzb;
    private String zzc;
    private long zzd;
    private String zze;
    private boolean zzf;
    private String zzg;
    private String zzh;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzaha zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = m.a(jSONObject.optString("idToken", null));
            this.zzc = m.a(jSONObject.optString("refreshToken", null));
            this.zzd = jSONObject.optLong("expiresIn", 0L);
            this.zze = m.a(jSONObject.optString("localId", null));
            this.zzf = jSONObject.optBoolean("isNewUser", false);
            this.zzg = m.a(jSONObject.optString("temporaryProof", null));
            this.zzh = m.a(jSONObject.optString("phoneNumber", null));
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
        return this.zzh;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzf;
    }
}
