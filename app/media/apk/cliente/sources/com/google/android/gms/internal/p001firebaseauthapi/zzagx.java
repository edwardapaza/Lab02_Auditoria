package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagx  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagx implements zzacr {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzagx() {
    }

    public static zzagx zza(String str, String str2, boolean z4) {
        zzagx zzagxVar = new zzagx();
        zzagxVar.zzb = q.e(str);
        zzagxVar.zzc = q.e(str2);
        zzagxVar.zzf = z4;
        return zzagxVar;
    }

    public static zzagx zzb(String str, String str2, boolean z4) {
        zzagx zzagxVar = new zzagx();
        zzagxVar.zza = q.e(str);
        zzagxVar.zzd = q.e(str2);
        zzagxVar.zzf = z4;
        return zzagxVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("sessionInfo", this.zzb);
            str = this.zzc;
            str2 = "code";
        } else {
            jSONObject.put("phoneNumber", this.zza);
            str = this.zzd;
            str2 = "temporaryProof";
        }
        jSONObject.put(str2, str);
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject.put("idToken", str3);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
