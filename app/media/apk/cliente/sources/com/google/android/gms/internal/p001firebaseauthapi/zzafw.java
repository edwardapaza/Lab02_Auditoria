package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafw  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafw implements zzacr {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzafw(String str, String str2, String str3) {
        this.zza = q.e(str);
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("oobCode", this.zza);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("newPassword", str);
        }
        String str2 = this.zzc;
        if (str2 != null) {
            jSONObject.put("tenantId", str2);
        }
        return jSONObject.toString();
    }
}
