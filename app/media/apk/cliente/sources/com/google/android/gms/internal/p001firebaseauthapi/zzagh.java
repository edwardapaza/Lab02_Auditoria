package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagh  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagh implements zzacr {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private zzaed zzh;

    private zzagh(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = q.e(str);
        this.zzb = q.e(str2);
        this.zzc = q.e(str3);
        this.zze = str4;
        this.zzd = str5;
        this.zzf = str6;
        this.zzg = str7;
    }

    public static zzagh zza(String str, String str2, String str3, String str4, String str5, String str6) {
        q.e(str3);
        return new zzagh("phone", str, str2, str3, str4, str5, str6);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mfaPendingCredential", this.zzb);
        jSONObject.put("mfaEnrollmentId", this.zzc);
        this.zza.hashCode();
        jSONObject.put("mfaProvider", 1);
        if (this.zze != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.zze);
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("recaptchaToken", this.zzf);
            }
            if (!TextUtils.isEmpty(this.zzg)) {
                jSONObject2.put("playIntegrityToken", this.zzg);
            }
            zzaed zzaedVar = this.zzh;
            if (zzaedVar != null) {
                jSONObject2.put("autoRetrievalInfo", zzaedVar.zza());
            }
            jSONObject.put("phoneSignInInfo", jSONObject2);
        }
        return jSONObject.toString();
    }

    public final void zza(zzaed zzaedVar) {
        this.zzh = zzaedVar;
    }

    public final String zzb() {
        return this.zzd;
    }
}
