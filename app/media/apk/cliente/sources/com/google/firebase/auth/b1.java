package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
/* loaded from: classes.dex */
public class b1 extends h {
    public static final Parcelable.Creator<b1> CREATOR = new z1();

    /* renamed from: a  reason: collision with root package name */
    private String f1410a;

    /* renamed from: b  reason: collision with root package name */
    private String f1411b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(String str, String str2) {
        this.f1410a = com.google.android.gms.common.internal.q.e(str);
        this.f1411b = com.google.android.gms.common.internal.q.e(str2);
    }

    public static zzags w(b1 b1Var, String str) {
        com.google.android.gms.common.internal.q.k(b1Var);
        return new zzags(null, b1Var.f1410a, b1Var.t(), null, b1Var.f1411b, null, str, null, null);
    }

    @Override // com.google.firebase.auth.h
    public String t() {
        return "twitter.com";
    }

    @Override // com.google.firebase.auth.h
    public String u() {
        return "twitter.com";
    }

    @Override // com.google.firebase.auth.h
    public final h v() {
        return new b1(this.f1410a, this.f1411b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, this.f1410a, false);
        m0.c.l(parcel, 2, this.f1411b, false);
        m0.c.b(parcel, a5);
    }
}
