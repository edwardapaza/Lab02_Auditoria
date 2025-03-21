package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafa  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafa implements zzacr {
    private String zza = zzaey.REFRESH_TOKEN.toString();
    private String zzb;

    public zzafa(String str) {
        this.zzb = q.e(str);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grantType", this.zza);
        jSONObject.put("refreshToken", this.zzb);
        return jSONObject.toString();
    }
}
