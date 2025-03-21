package com.google.android.gms.internal.p001firebaseauthapi;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafn  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafn {
    private String zza;
    private String zzb;
    private String zzc;
    private Long zzd;
    private Long zze;
    private boolean zzf;

    public static zzafn zza(String str) {
        try {
            zzafn zzafnVar = new zzafn();
            JSONObject jSONObject = new JSONObject(str);
            zzafnVar.zza = jSONObject.optString("iss");
            zzafnVar.zzb = jSONObject.optString("aud");
            zzafnVar.zzc = jSONObject.optString("sub");
            zzafnVar.zzd = Long.valueOf(jSONObject.optLong("iat"));
            zzafnVar.zze = Long.valueOf(jSONObject.optLong("exp"));
            zzafnVar.zzf = jSONObject.optBoolean("is_anonymous");
            return zzafnVar;
        } catch (JSONException e5) {
            if (Log.isLoggable("JwtToken", 3)) {
                String valueOf = String.valueOf(e5);
                Log.d("JwtToken", "Failed to read JwtToken from JSONObject. " + valueOf);
            }
            String valueOf2 = String.valueOf(e5);
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. " + valueOf2);
        }
    }

    public final Long zza() {
        return this.zze;
    }

    public final Long zzb() {
        return this.zzd;
    }
}
