package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.q;
import m0.a;
import m0.c;
import org.json.JSONException;
import org.json.JSONObject;
import q0.f;
import q0.m;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafm  reason: invalid package */
/* loaded from: classes.dex */
public class zzafm extends a implements zzacq<zzafm> {
    private String zzb;
    private String zzc;
    private Long zzd;
    private String zze;
    private Long zzf;
    private static final String zza = zzafm.class.getSimpleName();
    public static final Parcelable.Creator<zzafm> CREATOR = new zzafl();

    public zzafm() {
        this.zzf = Long.valueOf(System.currentTimeMillis());
    }

    public zzafm(String str, String str2, Long l5, String str3) {
        this(str, str2, l5, str3, Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafm(String str, String str2, Long l5, String str3, Long l6) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = l5;
        this.zze = str3;
        this.zzf = l6;
    }

    public static zzafm zzb(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzafm zzafmVar = new zzafm();
            zzafmVar.zzb = jSONObject.optString("refresh_token", null);
            zzafmVar.zzc = jSONObject.optString("access_token", null);
            zzafmVar.zzd = Long.valueOf(jSONObject.optLong("expires_in"));
            zzafmVar.zze = jSONObject.optString("token_type", null);
            zzafmVar.zzf = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzafmVar;
        } catch (JSONException e5) {
            Log.d(zza, "Failed to read GetTokenResponse from JSONObject");
            throw new zzxv(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacq
    /* renamed from: zzd */
    public final zzafm zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = m.a(jSONObject.optString("refresh_token"));
            this.zzc = m.a(jSONObject.optString("access_token"));
            this.zzd = Long.valueOf(jSONObject.optLong("expires_in", 0L));
            this.zze = m.a(jSONObject.optString("token_type"));
            this.zzf = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (NullPointerException | JSONException e5) {
            throw zzahb.zza(e5, zza, str);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = c.a(parcel);
        c.l(parcel, 2, this.zzb, false);
        c.l(parcel, 3, this.zzc, false);
        c.j(parcel, 4, Long.valueOf(zza()), false);
        c.l(parcel, 5, this.zze, false);
        c.j(parcel, 6, Long.valueOf(this.zzf.longValue()), false);
        c.b(parcel, a5);
    }

    public final long zza() {
        Long l5 = this.zzd;
        if (l5 == null) {
            return 0L;
        }
        return l5.longValue();
    }

    public final long zzb() {
        return this.zzf.longValue();
    }

    public final String zzc() {
        return this.zzc;
    }

    public final void zzc(String str) {
        this.zzb = q.e(str);
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.zzb);
            jSONObject.put("access_token", this.zzc);
            jSONObject.put("expires_in", this.zzd);
            jSONObject.put("token_type", this.zze);
            jSONObject.put("issued_at", this.zzf);
            return jSONObject.toString();
        } catch (JSONException e5) {
            Log.d(zza, "Failed to convert GetTokenResponse to JSON");
            throw new zzxv(e5);
        }
    }

    public final boolean zzg() {
        return f.b().a() + 300000 < this.zzf.longValue() + (this.zzd.longValue() * 1000);
    }
}
