package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
/* loaded from: classes.dex */
public final class Status extends m0.a implements j, ReflectedParcelable {

    /* renamed from: a  reason: collision with root package name */
    private final int f883a;

    /* renamed from: b  reason: collision with root package name */
    private final String f884b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f885c;

    /* renamed from: d  reason: collision with root package name */
    private final l0.a f886d;

    /* renamed from: e  reason: collision with root package name */
    public static final Status f875e = new Status(-1);

    /* renamed from: f  reason: collision with root package name */
    public static final Status f876f = new Status(0);

    /* renamed from: k  reason: collision with root package name */
    public static final Status f877k = new Status(14);

    /* renamed from: l  reason: collision with root package name */
    public static final Status f878l = new Status(8);

    /* renamed from: m  reason: collision with root package name */
    public static final Status f879m = new Status(15);

    /* renamed from: n  reason: collision with root package name */
    public static final Status f880n = new Status(16);

    /* renamed from: p  reason: collision with root package name */
    public static final Status f882p = new Status(17);

    /* renamed from: o  reason: collision with root package name */
    public static final Status f881o = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new o();

    public Status(int i5) {
        this(i5, (String) null);
    }

    public Status(int i5, String str) {
        this(i5, str, (PendingIntent) null);
    }

    public Status(int i5, String str, PendingIntent pendingIntent) {
        this(i5, str, pendingIntent, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status(int i5, String str, PendingIntent pendingIntent, l0.a aVar) {
        this.f883a = i5;
        this.f884b = str;
        this.f885c = pendingIntent;
        this.f886d = aVar;
    }

    public Status(l0.a aVar, String str) {
        this(aVar, str, 17);
    }

    @Deprecated
    public Status(l0.a aVar, String str, int i5) {
        this(i5, str, aVar.v(), aVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.f883a == status.f883a && p.a(this.f884b, status.f884b) && p.a(this.f885c, status.f885c) && p.a(this.f886d, status.f886d);
        }
        return false;
    }

    public int hashCode() {
        return p.b(Integer.valueOf(this.f883a), this.f884b, this.f885c, this.f886d);
    }

    @Override // com.google.android.gms.common.api.j
    public Status l() {
        return this;
    }

    public l0.a t() {
        return this.f886d;
    }

    public String toString() {
        p.a c5 = p.c(this);
        c5.a("statusCode", zza());
        c5.a("resolution", this.f885c);
        return c5.toString();
    }

    @ResultIgnorabilityUnspecified
    public int u() {
        return this.f883a;
    }

    public String v() {
        return this.f884b;
    }

    public boolean w() {
        return this.f885c != null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, u());
        m0.c.l(parcel, 2, v(), false);
        m0.c.k(parcel, 3, this.f885c, i5, false);
        m0.c.k(parcel, 4, t(), i5, false);
        m0.c.b(parcel, a5);
    }

    public boolean x() {
        return this.f883a <= 0;
    }

    public final String zza() {
        String str = this.f884b;
        return str != null ? str : d.a(this.f883a);
    }
}
