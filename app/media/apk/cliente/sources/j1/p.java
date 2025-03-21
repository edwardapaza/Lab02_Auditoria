package j1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class p extends com.google.firebase.auth.l0 {
    public static final Parcelable.Creator<p> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private String f5458a;

    /* renamed from: b  reason: collision with root package name */
    private String f5459b;

    /* renamed from: c  reason: collision with root package name */
    private List<com.google.firebase.auth.t0> f5460c;

    /* renamed from: d  reason: collision with root package name */
    private List<com.google.firebase.auth.z0> f5461d;

    /* renamed from: e  reason: collision with root package name */
    private i f5462e;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, String str2, List<com.google.firebase.auth.t0> list, List<com.google.firebase.auth.z0> list2, i iVar) {
        this.f5458a = str;
        this.f5459b = str2;
        this.f5460c = list;
        this.f5461d = list2;
        this.f5462e = iVar;
    }

    public static p u(String str, i iVar) {
        com.google.android.gms.common.internal.q.e(str);
        p pVar = new p();
        pVar.f5458a = str;
        pVar.f5462e = iVar;
        return pVar;
    }

    public static p v(List<com.google.firebase.auth.j0> list, String str) {
        List list2;
        Parcelable parcelable;
        com.google.android.gms.common.internal.q.k(list);
        com.google.android.gms.common.internal.q.e(str);
        p pVar = new p();
        pVar.f5460c = new ArrayList();
        pVar.f5461d = new ArrayList();
        for (com.google.firebase.auth.j0 j0Var : list) {
            if (j0Var instanceof com.google.firebase.auth.t0) {
                list2 = pVar.f5460c;
                parcelable = (com.google.firebase.auth.t0) j0Var;
            } else if (!(j0Var instanceof com.google.firebase.auth.z0)) {
                String u5 = j0Var.u();
                throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: " + u5);
            } else {
                list2 = pVar.f5461d;
                parcelable = (com.google.firebase.auth.z0) j0Var;
            }
            list2.add(parcelable);
        }
        pVar.f5459b = str;
        return pVar;
    }

    public final i t() {
        return this.f5462e;
    }

    public final String w() {
        return this.f5458a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, this.f5458a, false);
        m0.c.l(parcel, 2, this.f5459b, false);
        m0.c.o(parcel, 3, this.f5460c, false);
        m0.c.o(parcel, 4, this.f5461d, false);
        m0.c.k(parcel, 5, this.f5462e, i5, false);
        m0.c.b(parcel, a5);
    }

    public final boolean x() {
        return this.f5458a != null;
    }

    public final String zzc() {
        return this.f5459b;
    }
}
