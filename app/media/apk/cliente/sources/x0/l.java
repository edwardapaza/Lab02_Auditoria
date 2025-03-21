package x0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m0;
/* loaded from: classes.dex */
public final class l extends m0.a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    final int f8329a;

    /* renamed from: b  reason: collision with root package name */
    private final l0.a f8330b;

    /* renamed from: c  reason: collision with root package name */
    private final m0 f8331c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i5, l0.a aVar, m0 m0Var) {
        this.f8329a = i5;
        this.f8330b = aVar;
        this.f8331c = m0Var;
    }

    public final l0.a t() {
        return this.f8330b;
    }

    public final m0 u() {
        return this.f8331c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, this.f8329a);
        m0.c.k(parcel, 2, this.f8330b, i5, false);
        m0.c.k(parcel, 3, this.f8331c, i5, false);
        m0.c.b(parcel, a5);
    }
}
