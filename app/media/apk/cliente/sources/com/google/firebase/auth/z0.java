package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzagq;
import com.google.android.gms.internal.p001firebaseauthapi.zzxv;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z0 extends j0 {
    public static final Parcelable.Creator<z0> CREATOR = new y1();

    /* renamed from: a  reason: collision with root package name */
    private final String f1573a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1574b;

    /* renamed from: c  reason: collision with root package name */
    private final long f1575c;

    /* renamed from: d  reason: collision with root package name */
    private final zzagq f1576d;

    public z0(String str, String str2, long j5, zzagq zzagqVar) {
        this.f1573a = com.google.android.gms.common.internal.q.e(str);
        this.f1574b = str2;
        this.f1575c = j5;
        this.f1576d = (zzagq) com.google.android.gms.common.internal.q.l(zzagqVar, "totpInfo cannot be null.");
    }

    public static z0 w(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            long optLong = jSONObject.optLong("enrollmentTimestamp");
            if (jSONObject.opt("totpInfo") != null) {
                return new z0(jSONObject.optString("uid"), jSONObject.optString("displayName"), optLong, new zzagq());
            }
            throw new IllegalArgumentException("A totpInfo is required to build a TotpMultiFactorInfo instance.");
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a TotpMultiFactorInfo instance.");
    }

    @Override // com.google.firebase.auth.j0
    public String a() {
        return this.f1573a;
    }

    @Override // com.google.firebase.auth.j0
    public String q() {
        return this.f1574b;
    }

    @Override // com.google.firebase.auth.j0
    public long t() {
        return this.f1575c;
    }

    @Override // com.google.firebase.auth.j0
    public String u() {
        return "totp";
    }

    @Override // com.google.firebase.auth.j0
    public JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "totp");
            jSONObject.putOpt("uid", this.f1573a);
            jSONObject.putOpt("displayName", this.f1574b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f1575c));
            jSONObject.putOpt("totpInfo", this.f1576d);
            return jSONObject;
        } catch (JSONException e5) {
            Log.d("TotpMultiFactorInfo", "Failed to jsonify this object");
            throw new zzxv(e5);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, a(), false);
        m0.c.l(parcel, 2, q(), false);
        m0.c.i(parcel, 3, t());
        m0.c.k(parcel, 4, this.f1576d, i5, false);
        m0.c.b(parcel, a5);
    }
}
