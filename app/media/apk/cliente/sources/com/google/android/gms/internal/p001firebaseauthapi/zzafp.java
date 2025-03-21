package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import m0.a;
import m0.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafp  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafp extends a {
    public static final Parcelable.Creator<zzafp> CREATOR = new zzafs();
    private final String zza;
    private final String zzb;
    private final String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafp(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public static zzaq<zzafp> zza(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return zzaq.zza(new ArrayList());
        }
        zzap zzg = zzaq.zzg();
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i5);
            zzg.zza(new zzafp(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName")));
        }
        return zzg.zza();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.l(parcel, 1, this.zza, false);
        c.l(parcel, 2, this.zzb, false);
        c.l(parcel, 3, this.zzc, false);
        c.b(parcel, a5);
    }
}
