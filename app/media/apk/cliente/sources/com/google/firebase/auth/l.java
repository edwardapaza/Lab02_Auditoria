package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
/* loaded from: classes.dex */
public class l extends h {
    public static final Parcelable.Creator<l> CREATOR = new h2();

    /* renamed from: a  reason: collision with root package name */
    private final String f1484a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str) {
        this.f1484a = com.google.android.gms.common.internal.q.e(str);
    }

    public static zzags w(l lVar, String str) {
        com.google.android.gms.common.internal.q.k(lVar);
        return new zzags(null, lVar.f1484a, lVar.t(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.h
    public String t() {
        return "facebook.com";
    }

    @Override // com.google.firebase.auth.h
    public String u() {
        return "facebook.com";
    }

    @Override // com.google.firebase.auth.h
    public final h v() {
        return new l(this.f1484a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, this.f1484a, false);
        m0.c.b(parcel, a5);
    }
}
