package j1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class m0 extends m0.a {
    public static final Parcelable.Creator<m0> CREATOR = new p0();

    /* renamed from: a  reason: collision with root package name */
    private final List<com.google.firebase.auth.t0> f5442a;

    /* renamed from: b  reason: collision with root package name */
    private final List<com.google.firebase.auth.z0> f5443b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(List<com.google.firebase.auth.t0> list, List<com.google.firebase.auth.z0> list2) {
        this.f5442a = list == null ? new ArrayList<>() : list;
        this.f5443b = list2 == null ? new ArrayList<>() : list2;
    }

    public static m0 t(List<com.google.firebase.auth.j0> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.google.firebase.auth.j0 j0Var : list) {
            if (j0Var instanceof com.google.firebase.auth.t0) {
                arrayList.add((com.google.firebase.auth.t0) j0Var);
            } else if (j0Var instanceof com.google.firebase.auth.z0) {
                arrayList2.add((com.google.firebase.auth.z0) j0Var);
            }
        }
        return new m0(arrayList, arrayList2);
    }

    public final List<com.google.firebase.auth.j0> u() {
        ArrayList arrayList = new ArrayList();
        for (com.google.firebase.auth.t0 t0Var : this.f5442a) {
            arrayList.add(t0Var);
        }
        for (com.google.firebase.auth.z0 z0Var : this.f5443b) {
            arrayList.add(z0Var);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.o(parcel, 1, this.f5442a, false);
        m0.c.o(parcel, 2, this.f5443b, false);
        m0.c.b(parcel, a5);
    }
}
