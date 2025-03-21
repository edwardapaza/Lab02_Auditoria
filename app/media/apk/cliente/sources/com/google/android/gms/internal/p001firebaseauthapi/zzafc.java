package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafc  reason: invalid package */
/* loaded from: classes.dex */
public class zzafc implements zzacq<zzafc> {
    private static final String zza = "zzafc";
    private zzafe zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzafc zza(String str) {
        zzafe zzafeVar;
        int i5;
        zzafb zzafbVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("users")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    boolean z4 = false;
                    int i6 = 0;
                    while (i6 < optJSONArray.length()) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                        if (jSONObject2 == null) {
                            zzafbVar = new zzafb();
                            i5 = i6;
                        } else {
                            i5 = i6;
                            zzafbVar = new zzafb(m.a(jSONObject2.optString("localId", null)), m.a(jSONObject2.optString("email", null)), jSONObject2.optBoolean("emailVerified", z4), m.a(jSONObject2.optString("displayName", null)), m.a(jSONObject2.optString("photoUrl", null)), zzafu.zza(jSONObject2.optJSONArray("providerUserInfo")), m.a(jSONObject2.optString("rawPassword", null)), m.a(jSONObject2.optString("phoneNumber", null)), jSONObject2.optLong("createdAt", 0L), jSONObject2.optLong("lastLoginAt", 0L), false, null, zzafq.zza(jSONObject2.optJSONArray("mfaInfo")), zzafp.zza(jSONObject2.optJSONArray("passkeyInfo")));
                        }
                        arrayList.add(zzafbVar);
                        i6 = i5 + 1;
                        z4 = false;
                    }
                    zzafeVar = new zzafe(arrayList);
                }
                zzafeVar = new zzafe(new ArrayList());
            } else {
                zzafeVar = new zzafe();
            }
            this.zzb = zzafeVar;
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final List<zzafb> zza() {
        return this.zzb.zza();
    }
}
