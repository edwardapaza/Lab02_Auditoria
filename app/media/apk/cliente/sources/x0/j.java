package x0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.k0;
/* loaded from: classes.dex */
public final class j extends m0.a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    final int f8327a;

    /* renamed from: b  reason: collision with root package name */
    final k0 f8328b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i5, k0 k0Var) {
        this.f8327a = i5;
        this.f8328b = k0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, this.f8327a);
        m0.c.k(parcel, 2, this.f8328b, i5, false);
        m0.c.b(parcel, a5);
    }
}
