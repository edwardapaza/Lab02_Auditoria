package x0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class b extends m0.a implements com.google.android.gms.common.api.j {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final int f8322a;

    /* renamed from: b  reason: collision with root package name */
    private int f8323b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f8324c;

    public b() {
        this(2, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i5, int i6, Intent intent) {
        this.f8322a = i5;
        this.f8323b = i6;
        this.f8324c = intent;
    }

    @Override // com.google.android.gms.common.api.j
    public final Status l() {
        return this.f8323b == 0 ? Status.f876f : Status.f880n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, this.f8322a);
        m0.c.g(parcel, 2, this.f8323b);
        m0.c.k(parcel, 3, this.f8324c, i5, false);
        m0.c.b(parcel, a5);
    }
}
