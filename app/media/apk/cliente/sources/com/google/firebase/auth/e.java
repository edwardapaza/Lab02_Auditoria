package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class e extends m0.a {
    public static final Parcelable.Creator<e> CREATOR = new c2();

    /* renamed from: a  reason: collision with root package name */
    private final String f1422a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1423b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1424c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1425d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1426e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1427f;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f1428k;

    /* renamed from: l  reason: collision with root package name */
    private String f1429l;

    /* renamed from: m  reason: collision with root package name */
    private int f1430m;

    /* renamed from: n  reason: collision with root package name */
    private String f1431n;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f1432a;

        /* renamed from: b  reason: collision with root package name */
        private String f1433b;

        /* renamed from: c  reason: collision with root package name */
        private String f1434c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1435d;

        /* renamed from: e  reason: collision with root package name */
        private String f1436e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1437f;

        /* renamed from: g  reason: collision with root package name */
        private String f1438g;

        private a() {
            this.f1437f = false;
        }

        public e a() {
            if (this.f1432a != null) {
                return new e(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }

        public a b(String str, boolean z4, String str2) {
            this.f1434c = str;
            this.f1435d = z4;
            this.f1436e = str2;
            return this;
        }

        public a c(String str) {
            this.f1438g = str;
            return this;
        }

        public a d(boolean z4) {
            this.f1437f = z4;
            return this;
        }

        public a e(String str) {
            this.f1433b = str;
            return this;
        }

        public a f(String str) {
            this.f1432a = str;
            return this;
        }
    }

    private e(a aVar) {
        this.f1422a = aVar.f1432a;
        this.f1423b = aVar.f1433b;
        this.f1424c = null;
        this.f1425d = aVar.f1434c;
        this.f1426e = aVar.f1435d;
        this.f1427f = aVar.f1436e;
        this.f1428k = aVar.f1437f;
        this.f1431n = aVar.f1438g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2, String str3, String str4, boolean z4, String str5, boolean z5, String str6, int i5, String str7) {
        this.f1422a = str;
        this.f1423b = str2;
        this.f1424c = str3;
        this.f1425d = str4;
        this.f1426e = z4;
        this.f1427f = str5;
        this.f1428k = z5;
        this.f1429l = str6;
        this.f1430m = i5;
        this.f1431n = str7;
    }

    public static e D() {
        return new e(new a());
    }

    public static a z() {
        return new a();
    }

    public final int A() {
        return this.f1430m;
    }

    public final void B(int i5) {
        this.f1430m = i5;
    }

    public final void C(String str) {
        this.f1429l = str;
    }

    public boolean t() {
        return this.f1428k;
    }

    public boolean u() {
        return this.f1426e;
    }

    public String v() {
        return this.f1427f;
    }

    public String w() {
        return this.f1425d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 1, y(), false);
        m0.c.l(parcel, 2, x(), false);
        m0.c.l(parcel, 3, this.f1424c, false);
        m0.c.l(parcel, 4, w(), false);
        m0.c.c(parcel, 5, u());
        m0.c.l(parcel, 6, v(), false);
        m0.c.c(parcel, 7, t());
        m0.c.l(parcel, 8, this.f1429l, false);
        m0.c.g(parcel, 9, this.f1430m);
        m0.c.l(parcel, 10, this.f1431n, false);
        m0.c.b(parcel, a5);
    }

    public String x() {
        return this.f1423b;
    }

    public String y() {
        return this.f1422a;
    }

    public final String zzc() {
        return this.f1431n;
    }

    public final String zzd() {
        return this.f1424c;
    }

    public final String zze() {
        return this.f1429l;
    }
}
