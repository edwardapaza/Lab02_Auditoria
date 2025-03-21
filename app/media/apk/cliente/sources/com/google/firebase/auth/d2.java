package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
import com.google.android.gms.internal.p001firebaseauthapi.zzah;
/* loaded from: classes.dex */
public class d2 extends m0 {
    public static final Parcelable.Creator<d2> CREATOR = new f2();

    /* renamed from: a  reason: collision with root package name */
    private final String f1415a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1416b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1417c;

    /* renamed from: d  reason: collision with root package name */
    private final zzags f1418d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1419e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1420f;

    /* renamed from: k  reason: collision with root package name */
    private final String f1421k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d2(String str, String str2, String str3, zzags zzagsVar, String str4, String str5, String str6) {
        this.f1415a = zzah.zzb(str);
        this.f1416b = str2;
        this.f1417c = str3;
        this.f1418d = zzagsVar;
        this.f1419e = str4;
        this.f1420f = str5;
        this.f1421k = str6;
    }

    public static d2 A(zzags zzagsVar) {
        com.google.android.gms.common.internal.q.l(zzagsVar, "Must specify a non-null webSignInCredential");
        return new d2(null, null, null, zzagsVar, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d2 B(String str, String str2, String str3, String str4) {
        com.google.android.gms.common.internal.q.f(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new d2(str, str2, str3, null, null, null, str4);
    }

    public static d2 C(String str, String str2, String str3, String str4, String str5) {
        com.google.android.gms.common.internal.q.f(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new d2(str, str2, str3, null, str4, str5, null);
    }

    public static zzags z(d2 d2Var, String str) {
        com.google.android.gms.common.internal.q.k(d2Var);
        zzags zzagsVar = d2Var.f1418d;
        return zzagsVar != null ? zzagsVar : new zzags(d2Var.x(), d2Var.w(), d2Var.t(), null, d2Var.y(), null, str, d2Var.f1419e, d2Var.f1421k);
    }

    @Override // com.google.firebase.auth.h
    public String t() {
        return this.f1415a;
    }

    @Override // com.google.firebase.auth.h
    public String u() {
        return this.f1415a;
    }

    @Override // com.google.firebase.auth.h
    public final h v() {
        return new d2(this.f1415a, this.f1416b, this.f1417c, this.f1418d, this.f1419e, this.f1420f, this.f1421k);
    }

    @Override // com.google.firebase.auth.m0
    public String w() {
        return this.f1417c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, t(), false);
        m0.c.l(parcel, 2, x(), false);
        m0.c.l(parcel, 3, w(), false);
        m0.c.k(parcel, 4, this.f1418d, i5, false);
        m0.c.l(parcel, 5, this.f1419e, false);
        m0.c.l(parcel, 6, y(), false);
        m0.c.l(parcel, 7, this.f1421k, false);
        m0.c.b(parcel, a5);
    }

    @Override // com.google.firebase.auth.m0
    public String x() {
        return this.f1416b;
    }

    @Override // com.google.firebase.auth.m0
    public String y() {
        return this.f1420f;
    }
}
