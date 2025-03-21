package f1;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.t;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final String f2989a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2990b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2991c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2992d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2993e;

    /* renamed from: f  reason: collision with root package name */
    private final String f2994f;

    /* renamed from: g  reason: collision with root package name */
    private final String f2995g;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f2996a;

        /* renamed from: b  reason: collision with root package name */
        private String f2997b;

        /* renamed from: c  reason: collision with root package name */
        private String f2998c;

        /* renamed from: d  reason: collision with root package name */
        private String f2999d;

        /* renamed from: e  reason: collision with root package name */
        private String f3000e;

        /* renamed from: f  reason: collision with root package name */
        private String f3001f;

        /* renamed from: g  reason: collision with root package name */
        private String f3002g;

        public n a() {
            return new n(this.f2997b, this.f2996a, this.f2998c, this.f2999d, this.f3000e, this.f3001f, this.f3002g);
        }

        public b b(String str) {
            this.f2996a = com.google.android.gms.common.internal.q.f(str, "ApiKey must be set.");
            return this;
        }

        public b c(String str) {
            this.f2997b = com.google.android.gms.common.internal.q.f(str, "ApplicationId must be set.");
            return this;
        }

        public b d(String str) {
            this.f2998c = str;
            return this;
        }

        public b e(String str) {
            this.f2999d = str;
            return this;
        }

        public b f(String str) {
            this.f3000e = str;
            return this;
        }

        public b g(String str) {
            this.f3002g = str;
            return this;
        }

        public b h(String str) {
            this.f3001f = str;
            return this;
        }
    }

    private n(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.google.android.gms.common.internal.q.n(!q0.m.b(str), "ApplicationId must be set.");
        this.f2990b = str;
        this.f2989a = str2;
        this.f2991c = str3;
        this.f2992d = str4;
        this.f2993e = str5;
        this.f2994f = str6;
        this.f2995g = str7;
    }

    public static n a(Context context) {
        t tVar = new t(context);
        String a5 = tVar.a("google_app_id");
        if (TextUtils.isEmpty(a5)) {
            return null;
        }
        return new n(a5, tVar.a("google_api_key"), tVar.a("firebase_database_url"), tVar.a("ga_trackingId"), tVar.a("gcm_defaultSenderId"), tVar.a("google_storage_bucket"), tVar.a("project_id"));
    }

    public String b() {
        return this.f2989a;
    }

    public String c() {
        return this.f2990b;
    }

    public String d() {
        return this.f2991c;
    }

    public String e() {
        return this.f2992d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            return com.google.android.gms.common.internal.p.a(this.f2990b, nVar.f2990b) && com.google.android.gms.common.internal.p.a(this.f2989a, nVar.f2989a) && com.google.android.gms.common.internal.p.a(this.f2991c, nVar.f2991c) && com.google.android.gms.common.internal.p.a(this.f2992d, nVar.f2992d) && com.google.android.gms.common.internal.p.a(this.f2993e, nVar.f2993e) && com.google.android.gms.common.internal.p.a(this.f2994f, nVar.f2994f) && com.google.android.gms.common.internal.p.a(this.f2995g, nVar.f2995g);
        }
        return false;
    }

    public String f() {
        return this.f2993e;
    }

    public String g() {
        return this.f2995g;
    }

    public String h() {
        return this.f2994f;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(this.f2990b, this.f2989a, this.f2991c, this.f2992d, this.f2993e, this.f2994f, this.f2995g);
    }

    public String toString() {
        return com.google.android.gms.common.internal.p.c(this).a("applicationId", this.f2990b).a("apiKey", this.f2989a).a("databaseUrl", this.f2991c).a("gcmSenderId", this.f2993e).a("storageBucket", this.f2994f).a("projectId", this.f2995g).toString();
    }
}
