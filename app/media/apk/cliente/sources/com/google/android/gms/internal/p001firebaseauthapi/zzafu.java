package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafu  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafu {
    private List<zzafr> zza;

    public zzafu() {
        this.zza = new ArrayList();
    }

    private zzafu(List<zzafr> list) {
        this.zza = !list.isEmpty() ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public static zzafu zza(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzafu(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i5);
            arrayList.add(jSONObject == null ? new zzafr() : new zzafr(m.a(jSONObject.optString("federatedId", null)), m.a(jSONObject.optString("displayName", null)), m.a(jSONObject.optString("photoUrl", null)), m.a(jSONObject.optString("providerId", null)), null, m.a(jSONObject.optString("phoneNumber", null)), m.a(jSONObject.optString("email", null))));
        }
        return new zzafu(arrayList);
    }

    public final List<zzafr> zza() {
        return this.zza;
    }
}
