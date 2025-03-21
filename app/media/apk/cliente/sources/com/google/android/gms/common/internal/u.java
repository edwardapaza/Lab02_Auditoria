package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u extends m0.a {
    public static final Parcelable.Creator<u> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    private final int f1205a;

    /* renamed from: b  reason: collision with root package name */
    private List<o> f1206b;

    public u(int i5, List<o> list) {
        this.f1205a = i5;
        this.f1206b = list;
    }

    public final int t() {
        return this.f1205a;
    }

    public final List<o> u() {
        return this.f1206b;
    }

    public final void v(o oVar) {
        if (this.f1206b == null) {
            this.f1206b = new ArrayList();
        }
        this.f1206b.add(oVar);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, this.f1205a);
        m0.c.o(parcel, 2, this.f1206b, false);
        m0.c.b(parcel, a5);
    }
}
