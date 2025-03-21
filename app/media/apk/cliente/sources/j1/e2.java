package j1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes.dex */
public final class e2 implements com.google.firebase.auth.i {
    public static final Parcelable.Creator<e2> CREATOR = new d2();

    /* renamed from: a  reason: collision with root package name */
    private i f5381a;

    /* renamed from: b  reason: collision with root package name */
    private c2 f5382b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.firebase.auth.d2 f5383c;

    public e2(i iVar) {
        i iVar2 = (i) com.google.android.gms.common.internal.q.k(iVar);
        this.f5381a = iVar2;
        List<e> c02 = iVar2.c0();
        this.f5382b = null;
        for (int i5 = 0; i5 < c02.size(); i5++) {
            if (!TextUtils.isEmpty(c02.get(i5).zza())) {
                this.f5382b = new c2(c02.get(i5).c(), c02.get(i5).zza(), iVar.d0());
            }
        }
        if (this.f5382b == null) {
            this.f5382b = new c2(iVar.d0());
        }
        this.f5383c = iVar.a0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e2(i iVar, c2 c2Var, com.google.firebase.auth.d2 d2Var) {
        this.f5381a = iVar;
        this.f5382b = c2Var;
        this.f5383c = d2Var;
    }

    @Override // com.google.firebase.auth.i
    public final com.google.firebase.auth.h d() {
        return this.f5383c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.i
    public final com.google.firebase.auth.a0 m() {
        return this.f5381a;
    }

    @Override // com.google.firebase.auth.i
    public final com.google.firebase.auth.g s() {
        return this.f5382b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.k(parcel, 1, m(), i5, false);
        m0.c.k(parcel, 2, s(), i5, false);
        m0.c.k(parcel, 3, this.f5383c, i5, false);
        m0.c.b(parcel, a5);
    }
}
