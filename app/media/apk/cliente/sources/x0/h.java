package x0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;
/* loaded from: classes.dex */
public final class h extends m0.a implements com.google.android.gms.common.api.j {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f8325a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8326b;

    public h(List<String> list, String str) {
        this.f8325a = list;
        this.f8326b = str;
    }

    @Override // com.google.android.gms.common.api.j
    public final Status l() {
        return this.f8326b != null ? Status.f876f : Status.f880n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.m(parcel, 1, this.f8325a, false);
        m0.c.l(parcel, 2, this.f8326b, false);
        m0.c.b(parcel, a5);
    }
}
