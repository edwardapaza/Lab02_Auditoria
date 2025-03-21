package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafk  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafk implements zzacr {
    private final String zza;
    private final String zzb = "CLIENT_TYPE_ANDROID";
    private final String zzc;

    private zzafk(String str, String str2) {
        this.zza = str;
        this.zzc = str2;
    }

    public static zzafk zza(String str, String str2) {
        return new zzafk(str, str2);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zza)) {
            jSONObject.put("tenantId", this.zza);
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            jSONObject.put("clientType", this.zzb);
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            jSONObject.put("recaptchaVersion", this.zzc);
        }
        return jSONObject.toString();
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }
}
