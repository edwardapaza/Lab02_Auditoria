package j1;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class k implements com.google.firebase.auth.b0 {
    public static final Parcelable.Creator<k> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    private long f5434a;

    /* renamed from: b  reason: collision with root package name */
    private long f5435b;

    public k(long j5, long j6) {
        this.f5434a = j5;
        this.f5435b = j6;
    }

    public static k a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new k(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.f5434a);
            jSONObject.put("creationTimestamp", this.f5435b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.b0
    public final long k() {
        return this.f5435b;
    }

    @Override // com.google.firebase.auth.b0
    public final long r() {
        return this.f5434a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.i(parcel, 1, r());
        m0.c.i(parcel, 2, k());
        m0.c.b(parcel, a5);
    }
}
