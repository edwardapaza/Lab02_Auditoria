package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class o0 extends h implements Cloneable {
    public static final Parcelable.Creator<o0> CREATOR = new u1();

    /* renamed from: a  reason: collision with root package name */
    private String f1510a;

    /* renamed from: b  reason: collision with root package name */
    private String f1511b;

    /* renamed from: c  reason: collision with root package name */
    private String f1512c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1513d;

    /* renamed from: e  reason: collision with root package name */
    private String f1514e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(String str, String str2, String str3, boolean z4, String str4) {
        com.google.android.gms.common.internal.q.b(((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) ? false : true, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.f1510a = str;
        this.f1511b = str2;
        this.f1512c = str3;
        this.f1513d = z4;
        this.f1514e = str4;
    }

    public static o0 x(String str, String str2) {
        return new o0(str, str2, null, true, null);
    }

    public static o0 z(String str, String str2) {
        return new o0(null, null, str, true, str2);
    }

    public final String A() {
        return this.f1512c;
    }

    public final boolean B() {
        return this.f1513d;
    }

    public /* synthetic */ Object clone() {
        return new o0(this.f1510a, w(), this.f1512c, this.f1513d, this.f1514e);
    }

    @Override // com.google.firebase.auth.h
    public String t() {
        return "phone";
    }

    @Override // com.google.firebase.auth.h
    public String u() {
        return "phone";
    }

    @Override // com.google.firebase.auth.h
    public final h v() {
        return (o0) clone();
    }

    public String w() {
        return this.f1511b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, this.f1510a, false);
        m0.c.l(parcel, 2, w(), false);
        m0.c.l(parcel, 4, this.f1512c, false);
        m0.c.c(parcel, 5, this.f1513d);
        m0.c.l(parcel, 6, this.f1514e, false);
        m0.c.b(parcel, a5);
    }

    public final o0 y(boolean z4) {
        this.f1513d = false;
        return this;
    }

    public final String zzc() {
        return this.f1510a;
    }

    public final String zzd() {
        return this.f1514e;
    }
}
