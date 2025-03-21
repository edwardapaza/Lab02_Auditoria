package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafh  reason: invalid package */
/* loaded from: classes.dex */
public class zzafh implements zzacq<zzafh> {
    private static final String zza = "zzafh";
    private List<String> zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzafh zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                    this.zzb.add(optJSONArray.getString(i5));
                }
            }
            return this;
        } catch (JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }
}
