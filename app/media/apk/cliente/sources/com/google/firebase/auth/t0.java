package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzxv;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t0 extends j0 {
    public static final Parcelable.Creator<t0> CREATOR = new w1();

    /* renamed from: a  reason: collision with root package name */
    private final String f1552a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1553b;

    /* renamed from: c  reason: collision with root package name */
    private final long f1554c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1555d;

    public t0(String str, String str2, long j5, String str3) {
        this.f1552a = com.google.android.gms.common.internal.q.e(str);
        this.f1553b = str2;
        this.f1554c = j5;
        this.f1555d = com.google.android.gms.common.internal.q.e(str3);
    }

    public static t0 w(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            return new t0(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString("phoneNumber"));
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
    }

    @Override // com.google.firebase.auth.j0
    public String a() {
        return this.f1552a;
    }

    public String j() {
        return this.f1555d;
    }

    @Override // com.google.firebase.auth.j0
    public String q() {
        return this.f1553b;
    }

    @Override // com.google.firebase.auth.j0
    public long t() {
        return this.f1554c;
    }

    @Override // com.google.firebase.auth.j0
    public String u() {
        return "phone";
    }

    @Override // com.google.firebase.auth.j0
    public JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "phone");
            jSONObject.putOpt("uid", this.f1552a);
            jSONObject.putOpt("displayName", this.f1553b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f1554c));
            jSONObject.putOpt("phoneNumber", this.f1555d);
            return jSONObject;
        } catch (JSONException e5) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zzxv(e5);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, a(), false);
        m0.c.l(parcel, 2, q(), false);
        m0.c.i(parcel, 3, t());
        m0.c.l(parcel, 4, j(), false);
        m0.c.b(parcel, a5);
    }
}
