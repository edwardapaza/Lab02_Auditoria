package com.google.firebase.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.p001firebaseauthapi.zzact;
import com.google.android.gms.internal.p001firebaseauthapi.zzaec;
import com.google.firebase.auth.internal.GenericIdpActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class n0 extends n {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f1496a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final FirebaseAuth f1497a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f1498b;

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f1499c;

        private a(String str, FirebaseAuth firebaseAuth) {
            Bundle bundle = new Bundle();
            this.f1498b = bundle;
            Bundle bundle2 = new Bundle();
            this.f1499c = bundle2;
            this.f1497a = firebaseAuth;
            bundle.putString("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.l().r().b());
            bundle.putString("com.google.firebase.auth.KEY_PROVIDER_ID", str);
            bundle.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", bundle2);
            bundle.putString("com.google.firebase.auth.internal.CLIENT_VERSION", zzact.zza().zzb());
            bundle.putString("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.q());
            bundle.putString("com.google.firebase.auth.KEY_FIREBASE_APP_NAME", firebaseAuth.l().q());
            bundle.putString("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN", firebaseAuth.n());
        }

        public a a(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f1499c.putString(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public n0 b() {
            return new n0(this.f1498b);
        }

        public a c(List<String> list) {
            this.f1498b.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList<>(list));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f1500a;

        /* renamed from: b  reason: collision with root package name */
        private String f1501b;

        /* renamed from: c  reason: collision with root package name */
        private String f1502c;

        /* renamed from: d  reason: collision with root package name */
        private String f1503d;

        private b(String str) {
            this.f1500a = str;
        }

        public h a() {
            return d2.B(this.f1500a, this.f1501b, this.f1502c, this.f1503d);
        }

        public b b(String str) {
            this.f1502c = str;
            return this;
        }

        public b c(String str) {
            this.f1501b = str;
            return this;
        }

        public b d(String str, String str2) {
            this.f1501b = str;
            this.f1503d = str2;
            return this;
        }
    }

    private n0(Bundle bundle) {
        this.f1496a = bundle;
    }

    public static a d(String str) {
        return e(str, FirebaseAuth.getInstance());
    }

    public static a e(String str, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.q.e(str);
        com.google.android.gms.common.internal.q.k(firebaseAuth);
        if (!"facebook.com".equals(str) || zzaec.zza(firebaseAuth.l())) {
            return new a(str, firebaseAuth);
        }
        throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
    }

    public static b f(String str) {
        return new b(com.google.android.gms.common.internal.q.e(str));
    }

    @Override // com.google.firebase.auth.n
    public final void a(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_LINK");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f1496a);
        activity.startActivity(intent);
    }

    @Override // com.google.firebase.auth.n
    public final void b(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f1496a);
        activity.startActivity(intent);
    }

    @Override // com.google.firebase.auth.n
    public final void c(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f1496a);
        activity.startActivity(intent);
    }
}
