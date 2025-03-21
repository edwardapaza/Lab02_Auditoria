package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaej  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaej implements zzacr {
    private String zza;
    private String zzb = "http://localhost";
    private final String zzc;

    public zzaej(String str, String str2) {
        this.zza = q.e(str);
        this.zzc = str2;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("identifier", this.zza);
        jSONObject.put("continueUri", this.zzb);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        return jSONObject.toString();
    }
}
