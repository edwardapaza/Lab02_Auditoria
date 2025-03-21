package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
/* loaded from: classes.dex */
public class d0 extends h {
    public static final Parcelable.Creator<d0> CREATOR = new p1();

    /* renamed from: a  reason: collision with root package name */
    private String f1414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(String str) {
        this.f1414a = com.google.android.gms.common.internal.q.e(str);
    }

    public static zzags w(d0 d0Var, String str) {
        com.google.android.gms.common.internal.q.k(d0Var);
        return new zzags(null, d0Var.f1414a, d0Var.t(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.h
    public String t() {
        return "github.com";
    }

    @Override // com.google.firebase.auth.h
    public String u() {
        return "github.com";
    }

    @Override // com.google.firebase.auth.h
    public final h v() {
        return new d0(this.f1414a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, this.f1414a, false);
        m0.c.b(parcel, a5);
    }
}
