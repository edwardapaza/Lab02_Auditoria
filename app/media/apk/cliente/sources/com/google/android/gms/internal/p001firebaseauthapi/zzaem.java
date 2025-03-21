package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaem  reason: invalid package */
/* loaded from: classes.dex */
public class zzaem implements zzacq<zzaem> {
    private static final String zza = "zzaem";
    private String zzb;
    private boolean zzc;
    private String zzd;
    private boolean zze;
    private zzagn zzf = zzagn.zza();
    private List<String> zzg;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzaem zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("authUri", null);
            this.zzc = jSONObject.optBoolean("registered", false);
            this.zzd = jSONObject.optString("providerId", null);
            this.zze = jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                this.zzf = new zzagn(1, zzahb.zza(jSONObject.optJSONArray("allProviders")));
            } else {
                this.zzf = zzagn.zza();
            }
            this.zzg = zzahb.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzg;
    }
}
