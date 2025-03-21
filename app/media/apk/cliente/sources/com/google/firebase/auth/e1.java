package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class e1 extends m0.a {
    public static final Parcelable.Creator<e1> CREATOR = new a2();

    /* renamed from: a  reason: collision with root package name */
    private String f1439a;

    /* renamed from: b  reason: collision with root package name */
    private String f1440b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1441c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1442d;

    /* renamed from: e  reason: collision with root package name */
    private Uri f1443e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f1444a;

        /* renamed from: b  reason: collision with root package name */
        private Uri f1445b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1446c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1447d;

        public e1 a() {
            String str = this.f1444a;
            Uri uri = this.f1445b;
            return new e1(str, uri == null ? null : uri.toString(), this.f1446c, this.f1447d);
        }

        public a b(String str) {
            if (str == null) {
                this.f1446c = true;
            } else {
                this.f1444a = str;
            }
            return this;
        }

        public a c(Uri uri) {
            if (uri == null) {
                this.f1447d = true;
            } else {
                this.f1445b = uri;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(String str, String str2, boolean z4, boolean z5) {
        this.f1439a = str;
        this.f1440b = str2;
        this.f1441c = z4;
        this.f1442d = z5;
        this.f1443e = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public String q() {
        return this.f1439a;
    }

    public Uri t() {
        return this.f1443e;
    }

    public final boolean u() {
        return this.f1441c;
    }

    public final boolean v() {
        return this.f1442d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.l(parcel, 2, q(), false);
        m0.c.l(parcel, 3, this.f1440b, false);
        m0.c.c(parcel, 4, this.f1441c);
        m0.c.c(parcel, 5, this.f1442d);
        m0.c.b(parcel, a5);
    }

    public final String zza() {
        return this.f1440b;
    }
}
