package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagz  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagz implements zzacr {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzagz(String str, String str2, String str3) {
        this.zza = q.e(str);
        this.zzb = q.e(str2);
        this.zzc = str3;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zza);
        jSONObject.put("mfaEnrollmentId", this.zzb);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        return jSONObject.toString();
    }
}
