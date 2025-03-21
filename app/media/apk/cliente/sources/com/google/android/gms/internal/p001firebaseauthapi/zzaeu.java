package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeu  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaeu implements zzaeq {
    private final String zza;
    private String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    private zzaeu(String str, String str2, String str3, String str4, String str5, String str6) {
        this.zza = q.e(str);
        this.zzb = q.e(str2);
        this.zzd = str3;
        this.zze = str4;
        this.zzc = str5;
        this.zzf = str6;
    }

    public static zzaeu zza(String str, String str2, String str3, String str4, String str5) {
        q.e(str3);
        q.e(str2);
        return new zzaeu("phone", str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaeq
    public final /* synthetic */ zzaeq zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zzb);
        jSONObject.put("mfaProvider", 1);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("displayName", str);
        }
        JSONObject jSONObject2 = new JSONObject();
        String str2 = this.zzd;
        if (str2 != null) {
            jSONObject2.put("sessionInfo", str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject2.put("code", str3);
        }
        jSONObject.put("phoneVerificationInfo", jSONObject2);
        String str4 = this.zzf;
        if (str4 != null) {
            jSONObject.put("tenantId", str4);
        }
        return jSONObject.toString();
    }
}
