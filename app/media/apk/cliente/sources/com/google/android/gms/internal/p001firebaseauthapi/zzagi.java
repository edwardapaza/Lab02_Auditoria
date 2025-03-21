package com.google.android.gms.internal.p001firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagi  reason: invalid package */
/* loaded from: classes.dex */
public class zzagi implements zzacq<zzagi> {
    private static final String zza = "zzagi";

    public String zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public zzagi zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("phoneSessionInfo") != null) {
                return (zzagm) ((zzagi) new zzagm().zza(str));
            }
            if (jSONObject.optJSONObject("totpSessionInfo") != null) {
                return (zzago) ((zzagi) new zzago().zza(str));
            }
            throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }
}
