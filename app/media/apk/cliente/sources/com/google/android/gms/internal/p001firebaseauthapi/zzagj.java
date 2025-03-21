package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagj  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagj implements zzagf {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private zzaed zzg;
    private final String zzh = null;

    private zzagj(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = q.e(str);
        this.zzb = q.e(str2);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
    }

    public static zzagj zza(String str, String str2, String str3, String str4, String str5, String str6) {
        q.e(str2);
        return new zzagj(str, "phone", str2, str3, str4, str5, null);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zza);
        jSONObject.put("mfaProvider", 1);
        if (this.zzc != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.zzc);
            if (!TextUtils.isEmpty(this.zze)) {
                jSONObject2.put("recaptchaToken", this.zze);
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("playIntegrityToken", this.zzf);
            }
            zzaed zzaedVar = this.zzg;
            if (zzaedVar != null) {
                jSONObject2.put("autoRetrievalInfo", zzaedVar.zza());
            }
            jSONObject.put("phoneEnrollmentInfo", jSONObject2);
        }
        if (!TextUtils.isEmpty(null)) {
            jSONObject.put("tenantId", (Object) null);
        }
        return jSONObject.toString();
    }

    public final void zza(zzaed zzaedVar) {
        this.zzg = zzaedVar;
    }

    public final String zzb() {
        return this.zzd;
    }
}
