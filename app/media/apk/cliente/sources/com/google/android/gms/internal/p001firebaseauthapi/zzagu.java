package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.d2;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagu  reason: invalid package */
/* loaded from: classes.dex */
public class zzagu implements zzacq<zzagu> {
    private static final String zza = "zzagu";
    private boolean zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private boolean zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private String zzs;
    private List<zzafq> zzt;
    private String zzu;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzagu zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optBoolean("needConfirmation", false);
            this.zzc = jSONObject.optBoolean("needEmail", false);
            this.zzd = m.a(jSONObject.optString("idToken", null));
            this.zze = m.a(jSONObject.optString("refreshToken", null));
            this.zzf = jSONObject.optLong("expiresIn", 0L);
            this.zzg = m.a(jSONObject.optString("localId", null));
            this.zzh = m.a(jSONObject.optString("email", null));
            this.zzi = m.a(jSONObject.optString("displayName", null));
            this.zzj = m.a(jSONObject.optString("photoUrl", null));
            this.zzk = m.a(jSONObject.optString("providerId", null));
            this.zzl = m.a(jSONObject.optString("rawUserInfo", null));
            this.zzm = jSONObject.optBoolean("isNewUser", false);
            this.zzn = jSONObject.optString("oauthAccessToken", null);
            this.zzo = jSONObject.optString("oauthIdToken", null);
            this.zzq = m.a(jSONObject.optString("errorMessage", null));
            this.zzr = m.a(jSONObject.optString("pendingToken", null));
            this.zzs = m.a(jSONObject.optString("tenantId", null));
            this.zzt = zzafq.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzu = m.a(jSONObject.optString("mfaPendingCredential", null));
            this.zzp = m.a(jSONObject.optString("oauthTokenSecret", null));
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final long zza() {
        return this.zzf;
    }

    public final d2 zzb() {
        if (TextUtils.isEmpty(this.zzn) && TextUtils.isEmpty(this.zzo)) {
            return null;
        }
        return d2.C(this.zzk, this.zzo, this.zzn, this.zzr, this.zzp);
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zzq;
    }

    public final String zze() {
        return this.zzd;
    }

    public final String zzf() {
        return this.zzu;
    }

    public final String zzg() {
        return this.zzk;
    }

    public final String zzh() {
        return this.zzl;
    }

    public final String zzi() {
        return this.zze;
    }

    public final String zzj() {
        return this.zzs;
    }

    public final List<zzafq> zzk() {
        return this.zzt;
    }

    public final boolean zzl() {
        return !TextUtils.isEmpty(this.zzu);
    }

    public final boolean zzm() {
        return this.zzb;
    }

    public final boolean zzn() {
        return this.zzm;
    }

    public final boolean zzo() {
        return this.zzb || !TextUtils.isEmpty(this.zzq);
    }
}
