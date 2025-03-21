package com.google.android.gms.internal.p001firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaep  reason: invalid package */
/* loaded from: classes.dex */
public class zzaep implements zzacq<zzaep> {
    private static final String zza = "zzaep";
    private String zzb;
    private String zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzaep zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("idToken", null);
            this.zzc = jSONObject.optString("refreshToken", null);
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }
}
