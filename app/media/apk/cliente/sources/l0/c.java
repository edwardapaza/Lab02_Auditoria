package l0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
/* loaded from: classes.dex */
public class c extends m0.a {
    public static final Parcelable.Creator<c> CREATOR = new r();

    /* renamed from: a  reason: collision with root package name */
    private final String f5878a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final int f5879b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5880c;

    public c(String str, int i5, long j5) {
        this.f5878a = str;
        this.f5879b = i5;
        this.f5880c = j5;
    }

    public c(String str, long j5) {
        this.f5878a = str;
        this.f5880c = j5;
        this.f5879b = -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (((t() != null && t().equals(cVar.t())) || (t() == null && cVar.t() == null)) && u() == cVar.u()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(t(), Long.valueOf(u()));
    }

    public String t() {
        return this.f5878a;
    }

    public final String toString() {
        p.a c5 = com.google.android.gms.common.internal.p.c(this);
        c5.a("name", t());
        c5.a("version", Long.valueOf(u()));
        return c5.toString();
    }

    public long u() {
        long j5 = this.f5880c;
        return j5 == -1 ? this.f5879b : j5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, t(), false);
        m0.c.g(parcel, 2, this.f5879b);
        m0.c.i(parcel, 3, u());
        m0.c.b(parcel, a5);
    }
}
