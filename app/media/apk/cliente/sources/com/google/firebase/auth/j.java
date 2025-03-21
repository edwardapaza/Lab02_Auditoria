package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class j extends h {
    public static final Parcelable.Creator<j> CREATOR = new g2();

    /* renamed from: a  reason: collision with root package name */
    private String f1474a;

    /* renamed from: b  reason: collision with root package name */
    private String f1475b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1476c;

    /* renamed from: d  reason: collision with root package name */
    private String f1477d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1478e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, String str2) {
        this(str, str2, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, String str2, String str3, String str4, boolean z4) {
        this.f1474a = com.google.android.gms.common.internal.q.e(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.f1475b = str2;
        this.f1476c = str3;
        this.f1477d = str4;
        this.f1478e = z4;
    }

    public static boolean x(String str) {
        f c5;
        return (TextUtils.isEmpty(str) || (c5 = f.c(str)) == null || c5.b() != 4) ? false : true;
    }

    @Override // com.google.firebase.auth.h
    public String t() {
        return "password";
    }

    @Override // com.google.firebase.auth.h
    public String u() {
        return !TextUtils.isEmpty(this.f1475b) ? "password" : "emailLink";
    }

    @Override // com.google.firebase.auth.h
    public final h v() {
        return new j(this.f1474a, this.f1475b, this.f1476c, this.f1477d, this.f1478e);
    }

    public final j w(a0 a0Var) {
        this.f1477d = a0Var.zze();
        this.f1478e = true;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, this.f1474a, false);
        m0.c.l(parcel, 2, this.f1475b, false);
        m0.c.l(parcel, 3, this.f1476c, false);
        m0.c.l(parcel, 4, this.f1477d, false);
        m0.c.c(parcel, 5, this.f1478e);
        m0.c.b(parcel, a5);
    }

    public final String y() {
        return this.f1477d;
    }

    public final boolean z() {
        return !TextUtils.isEmpty(this.f1476c);
    }

    public final String zzc() {
        return this.f1474a;
    }

    public final String zzd() {
        return this.f1475b;
    }

    public final String zze() {
        return this.f1476c;
    }

    public final boolean zzg() {
        return this.f1478e;
    }
}
