package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzage  reason: invalid package */
/* loaded from: classes.dex */
public class zzage implements zzacq<zzage> {
    private static final String zza = "zzage";
    private String zzb;
    private String zzc;
    private Boolean zzd;
    private String zze;
    private String zzf;
    private zzafu zzg;
    private String zzh;
    private String zzi;
    private long zzj;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzage zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = m.a(jSONObject.optString("email", null));
            this.zzc = m.a(jSONObject.optString("passwordHash", null));
            this.zzd = Boolean.valueOf(jSONObject.optBoolean("emailVerified", false));
            this.zze = m.a(jSONObject.optString("displayName", null));
            this.zzf = m.a(jSONObject.optString("photoUrl", null));
            this.zzg = zzafu.zza(jSONObject.optJSONArray("providerUserInfo"));
            this.zzh = m.a(jSONObject.optString("idToken", null));
            this.zzi = m.a(jSONObject.optString("refreshToken", null));
            this.zzj = jSONObject.optLong("expiresIn", 0L);
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final long zza() {
        return this.zzj;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zzi;
    }

    public final List<zzafr> zze() {
        zzafu zzafuVar = this.zzg;
        if (zzafuVar != null) {
            return zzafuVar.zza();
        }
        return null;
    }
}
