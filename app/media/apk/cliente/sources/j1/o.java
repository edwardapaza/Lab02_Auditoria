package j1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzyi;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class o extends com.google.firebase.auth.k0 {
    public static final Parcelable.Creator<o> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private final List<com.google.firebase.auth.t0> f5446a;

    /* renamed from: b  reason: collision with root package name */
    private final p f5447b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5448c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.auth.d2 f5449d;

    /* renamed from: e  reason: collision with root package name */
    private final i f5450e;

    /* renamed from: f  reason: collision with root package name */
    private final List<com.google.firebase.auth.z0> f5451f;

    public o(List<com.google.firebase.auth.t0> list, p pVar, String str, com.google.firebase.auth.d2 d2Var, i iVar, List<com.google.firebase.auth.z0> list2) {
        this.f5446a = (List) com.google.android.gms.common.internal.q.k(list);
        this.f5447b = (p) com.google.android.gms.common.internal.q.k(pVar);
        this.f5448c = com.google.android.gms.common.internal.q.e(str);
        this.f5449d = d2Var;
        this.f5450e = iVar;
        this.f5451f = (List) com.google.android.gms.common.internal.q.k(list2);
    }

    public static o y(zzyi zzyiVar, FirebaseAuth firebaseAuth, com.google.firebase.auth.a0 a0Var) {
        List<com.google.firebase.auth.j0> zzc = zzyiVar.zzc();
        ArrayList arrayList = new ArrayList();
        for (com.google.firebase.auth.j0 j0Var : zzc) {
            if (j0Var instanceof com.google.firebase.auth.t0) {
                arrayList.add((com.google.firebase.auth.t0) j0Var);
            }
        }
        List<com.google.firebase.auth.j0> zzc2 = zzyiVar.zzc();
        ArrayList arrayList2 = new ArrayList();
        for (com.google.firebase.auth.j0 j0Var2 : zzc2) {
            if (j0Var2 instanceof com.google.firebase.auth.z0) {
                arrayList2.add((com.google.firebase.auth.z0) j0Var2);
            }
        }
        return new o(arrayList, p.v(zzyiVar.zzc(), zzyiVar.zzb()), firebaseAuth.l().q(), zzyiVar.zza(), (i) a0Var, arrayList2);
    }

    @Override // com.google.firebase.auth.k0
    public final FirebaseAuth t() {
        return FirebaseAuth.getInstance(f1.f.p(this.f5448c));
    }

    @Override // com.google.firebase.auth.k0
    public final List<com.google.firebase.auth.j0> u() {
        ArrayList arrayList = new ArrayList();
        for (com.google.firebase.auth.t0 t0Var : this.f5446a) {
            arrayList.add(t0Var);
        }
        for (com.google.firebase.auth.z0 z0Var : this.f5451f) {
            arrayList.add(z0Var);
        }
        return arrayList;
    }

    @Override // com.google.firebase.auth.k0
    public final com.google.firebase.auth.l0 v() {
        return this.f5447b;
    }

    @Override // com.google.firebase.auth.k0
    public final Task<com.google.firebase.auth.i> w(com.google.firebase.auth.i0 i0Var) {
        return t().W(i0Var, this.f5447b, this.f5450e).continueWithTask(new n(this));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.o(parcel, 1, this.f5446a, false);
        m0.c.k(parcel, 2, v(), i5, false);
        m0.c.l(parcel, 3, this.f5448c, false);
        m0.c.k(parcel, 4, this.f5449d, i5, false);
        m0.c.k(parcel, 5, this.f5450e, i5, false);
        m0.c.o(parcel, 6, this.f5451f, false);
        m0.c.b(parcel, a5);
    }
}
