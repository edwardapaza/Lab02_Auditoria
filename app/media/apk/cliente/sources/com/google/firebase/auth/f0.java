package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
/* loaded from: classes.dex */
public class f0 extends h {
    public static final Parcelable.Creator<f0> CREATOR = new q1();

    /* renamed from: a  reason: collision with root package name */
    private final String f1455a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1456b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("idToken cannot be empty");
        }
        if (str2 != null && str2.length() == 0) {
            throw new IllegalArgumentException("accessToken cannot be empty");
        }
        this.f1455a = str;
        this.f1456b = str2;
    }

    public static zzags w(f0 f0Var, String str) {
        com.google.android.gms.common.internal.q.k(f0Var);
        return new zzags(f0Var.f1455a, f0Var.f1456b, f0Var.t(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.h
    public String t() {
        return "google.com";
    }

    @Override // com.google.firebase.auth.h
    public String u() {
        return "google.com";
    }

    @Override // com.google.firebase.auth.h
    public final h v() {
        return new f0(this.f1455a, this.f1456b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, this.f1455a, false);
        m0.c.l(parcel, 2, this.f1456b, false);
        m0.c.b(parcel, a5);
    }
}
