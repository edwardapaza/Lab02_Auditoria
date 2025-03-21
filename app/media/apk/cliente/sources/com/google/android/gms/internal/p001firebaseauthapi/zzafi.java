package com.google.android.gms.internal.p001firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafi  reason: invalid package */
/* loaded from: classes.dex */
public class zzafi implements zzacq<zzafi> {
    private static final String zza = "zzafi";
    private String zzb;

    public zzafi() {
    }

    public zzafi(String str) {
        this.zzb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzb */
    public final zzafi zza(String str) {
        try {
            this.zzb = m.a(new JSONObject(str).optString("producerProjectNumber"));
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }
}
