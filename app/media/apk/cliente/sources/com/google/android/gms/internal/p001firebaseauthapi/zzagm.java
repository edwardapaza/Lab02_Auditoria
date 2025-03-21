package com.google.android.gms.internal.p001firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagm  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagm extends zzagi {
    private static final String zza = "zzagm";
    private String zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzagi
    /* renamed from: zzc */
    public final zzagm zzb(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
                this.zzb = zzah.zza(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzagi, com.google.android.gms.internal.p001firebaseauthapi.zzacq
    public final /* synthetic */ zzagi zza(String str) {
        return (zzagm) zza(str);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzagi
    public final String zza() {
        return this.zzb;
    }
}
