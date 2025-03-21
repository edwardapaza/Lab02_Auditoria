package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagv  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagv implements zzacr {
    private String zza;
    private String zzb;
    private final String zzc;
    private final String zzd;
    private boolean zze = true;

    public zzagv(String str, String str2, String str3, String str4) {
        this.zza = q.e(str);
        this.zzb = q.e(str2);
        this.zzc = str3;
        this.zzd = str4;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zza);
        jSONObject.put("password", this.zzb);
        jSONObject.put("returnSecureToken", this.zze);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        String str2 = this.zzd;
        if (str2 != null) {
            zzahb.zza(jSONObject, "captchaResponse", str2);
        } else {
            zzahb.zza(jSONObject);
        }
        return jSONObject.toString();
    }
}
