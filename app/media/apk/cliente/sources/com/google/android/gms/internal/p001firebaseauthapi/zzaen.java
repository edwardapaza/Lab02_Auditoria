package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaen  reason: invalid package */
/* loaded from: classes.dex */
public class zzaen implements zzacq<zzaen> {
    private static final String zza = "zzaen";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;
    private long zzg;
    private List<zzafq> zzh;
    private String zzi;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzaen zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("localId", null);
            this.zzc = jSONObject.optString("email", null);
            this.zzd = jSONObject.optString("idToken", null);
            this.zze = jSONObject.optString("refreshToken", null);
            this.zzf = jSONObject.optBoolean("isNewUser", false);
            this.zzg = jSONObject.optLong("expiresIn", 0L);
            this.zzh = zzafq.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzi = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final long zza() {
        return this.zzg;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzi;
    }

    public final String zzd() {
        return this.zze;
    }

    public final List<zzafq> zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.zzi);
    }

    public final boolean zzg() {
        return this.zzf;
    }
}
