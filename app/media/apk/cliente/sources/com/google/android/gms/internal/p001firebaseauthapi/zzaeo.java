package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.firebase.auth.f;
import com.google.firebase.auth.j;
import o0.a;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeo  reason: invalid package */
/* loaded from: classes.dex */
public class zzaeo implements zzacr {
    private static final String zza = "zzaeo";
    private static final a zzb = new a(zzaeo.class.getSimpleName(), new String[0]);
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    public zzaeo(j jVar, String str, String str2) {
        this.zzc = q.e(jVar.zzc());
        this.zzd = q.e(jVar.zze());
        this.zze = str;
        this.zzf = str2;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacr
    public final String zza() {
        f c5 = f.c(this.zzd);
        String a5 = c5 != null ? c5.a() : null;
        String d5 = c5 != null ? c5.d() : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zzc);
        if (a5 != null) {
            jSONObject.put("oobCode", a5);
        }
        if (d5 != null) {
            jSONObject.put("tenantId", d5);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            zzahb.zza(jSONObject, "captchaResp", str2);
        } else {
            zzahb.zza(jSONObject);
        }
        return jSONObject.toString();
    }
}
