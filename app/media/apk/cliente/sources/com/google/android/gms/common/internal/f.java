package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.j;
/* loaded from: classes.dex */
public class f extends m0.a {
    public static final Parcelable.Creator<f> CREATOR = new e1();

    /* renamed from: s  reason: collision with root package name */
    static final Scope[] f1112s = new Scope[0];

    /* renamed from: t  reason: collision with root package name */
    static final l0.c[] f1113t = new l0.c[0];

    /* renamed from: a  reason: collision with root package name */
    final int f1114a;

    /* renamed from: b  reason: collision with root package name */
    final int f1115b;

    /* renamed from: c  reason: collision with root package name */
    final int f1116c;

    /* renamed from: d  reason: collision with root package name */
    String f1117d;

    /* renamed from: e  reason: collision with root package name */
    IBinder f1118e;

    /* renamed from: f  reason: collision with root package name */
    Scope[] f1119f;

    /* renamed from: k  reason: collision with root package name */
    Bundle f1120k;

    /* renamed from: l  reason: collision with root package name */
    Account f1121l;

    /* renamed from: m  reason: collision with root package name */
    l0.c[] f1122m;

    /* renamed from: n  reason: collision with root package name */
    l0.c[] f1123n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f1124o;

    /* renamed from: p  reason: collision with root package name */
    final int f1125p;

    /* renamed from: q  reason: collision with root package name */
    boolean f1126q;

    /* renamed from: r  reason: collision with root package name */
    private final String f1127r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i5, int i6, int i7, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, l0.c[] cVarArr, l0.c[] cVarArr2, boolean z4, int i8, boolean z5, String str2) {
        scopeArr = scopeArr == null ? f1112s : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        cVarArr = cVarArr == null ? f1113t : cVarArr;
        cVarArr2 = cVarArr2 == null ? f1113t : cVarArr2;
        this.f1114a = i5;
        this.f1115b = i6;
        this.f1116c = i7;
        if ("com.google.android.gms".equals(str)) {
            this.f1117d = "com.google.android.gms";
        } else {
            this.f1117d = str;
        }
        if (i5 < 2) {
            this.f1121l = iBinder != null ? a.b(j.a.a(iBinder)) : null;
        } else {
            this.f1118e = iBinder;
            this.f1121l = account;
        }
        this.f1119f = scopeArr;
        this.f1120k = bundle;
        this.f1122m = cVarArr;
        this.f1123n = cVarArr2;
        this.f1124o = z4;
        this.f1125p = i8;
        this.f1126q = z5;
        this.f1127r = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        e1.a(this, parcel, i5);
    }

    public final String zza() {
        return this.f1127r;
    }
}
