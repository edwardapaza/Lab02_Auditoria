package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
/* loaded from: classes.dex */
public class u0 extends h {
    public static final Parcelable.Creator<u0> CREATOR = new x1();

    /* renamed from: a  reason: collision with root package name */
    private final String f1559a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(String str) {
        this.f1559a = com.google.android.gms.common.internal.q.e(str);
    }

    public static zzags w(u0 u0Var, String str) {
        com.google.android.gms.common.internal.q.k(u0Var);
        return new zzags(null, null, u0Var.t(), null, null, u0Var.f1559a, str, null, null);
    }

    @Override // com.google.firebase.auth.h
    public String t() {
        return "playgames.google.com";
    }

    @Override // com.google.firebase.auth.h
    public String u() {
        return "playgames.google.com";
    }

    @Override // com.google.firebase.auth.h
    public final h v() {
        return new u0(this.f1559a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, this.f1559a, false);
        m0.c.b(parcel, a5);
    }
}
