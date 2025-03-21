package j1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
/* loaded from: classes.dex */
public final class c2 implements com.google.firebase.auth.g {
    public static final Parcelable.Creator<c2> CREATOR = new b2();

    /* renamed from: a  reason: collision with root package name */
    private final String f5360a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5361b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f5362c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5363d;

    public c2(String str, String str2, boolean z4) {
        com.google.android.gms.common.internal.q.e(str);
        com.google.android.gms.common.internal.q.e(str2);
        this.f5360a = str;
        this.f5361b = str2;
        this.f5362c = k0.d(str2);
        this.f5363d = z4;
    }

    public c2(boolean z4) {
        this.f5363d = z4;
        this.f5361b = null;
        this.f5360a = null;
        this.f5362c = null;
    }

    @Override // com.google.firebase.auth.g
    public final String c() {
        return this.f5360a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.g
    public final Map<String, Object> e() {
        return this.f5362c;
    }

    @Override // com.google.firebase.auth.g
    public final String o() {
        Map<String, Object> map;
        String str;
        if ("github.com".equals(this.f5360a)) {
            map = this.f5362c;
            str = "login";
        } else if (!"twitter.com".equals(this.f5360a)) {
            return null;
        } else {
            map = this.f5362c;
            str = "screen_name";
        }
        return (String) map.get(str);
    }

    @Override // com.google.firebase.auth.g
    public final boolean p() {
        return this.f5363d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, c(), false);
        m0.c.l(parcel, 2, this.f5361b, false);
        m0.c.c(parcel, 3, p());
        m0.c.b(parcel, a5);
    }
}
