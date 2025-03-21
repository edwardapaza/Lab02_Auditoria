package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafj  reason: invalid package */
/* loaded from: classes.dex */
public class zzafj implements zzacq<zzafj> {
    private static final String zza = "zzafj";
    private String zzb;
    private zzaq<zzaft> zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzc */
    public final zzafj zza(String str) {
        zzaq<zzaft> zza2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = m.a(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    zzap zzg = zzaq.zzg();
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                        zzg.zza(jSONObject2 == null ? zzaft.zza(null, null) : zzaft.zza(m.a(jSONObject2.optString("provider")), m.a(jSONObject2.optString("enforcementState"))));
                    }
                    zza2 = zzg.zza();
                    this.zzc = zza2;
                }
                zza2 = zzaq.zza(new ArrayList());
                this.zzc = zza2;
            }
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb(String str) {
        q.e(str);
        zzaq<zzaft> zzaqVar = this.zzc;
        String str2 = null;
        if (zzaqVar != null && !zzaqVar.isEmpty()) {
            zzaq<zzaft> zzaqVar2 = this.zzc;
            int size = zzaqVar2.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    break;
                }
                zzaft zzaftVar = zzaqVar2.get(i5);
                i5++;
                zzaft zzaftVar2 = zzaftVar;
                String zza2 = zzaftVar2.zza();
                String zzb = zzaftVar2.zzb();
                if (zza2 != null && zzb != null && zzb.equals(str)) {
                    str2 = zzaftVar2.zza();
                    break;
                }
            }
        }
        if (str2 == null) {
            return false;
        }
        return str2.equals("ENFORCE") || str2.equals("AUDIT");
    }
}
