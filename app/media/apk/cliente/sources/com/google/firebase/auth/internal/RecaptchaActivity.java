package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzacg;
import com.google.android.gms.internal.p001firebaseauthapi.zzaci;
import com.google.android.gms.internal.p001firebaseauthapi.zzacl;
import com.google.android.gms.internal.p001firebaseauthapi.zzacu;
import com.google.android.gms.internal.p001firebaseauthapi.zzaec;
import com.google.android.gms.internal.p001firebaseauthapi.zzb;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import f1.f;
import h.b;
import j1.g1;
import j1.h1;
import j1.o0;
import j1.r;
import j1.t1;
import j1.v1;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import o.x;
import q0.h;
/* loaded from: classes.dex */
public class RecaptchaActivity extends x implements zzaci {
    private static final String E = "RecaptchaActivity";
    private static long F;
    private static final g1 G = g1.f();
    private boolean D = false;

    private final Uri.Builder Y(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        f p5 = f.p(stringExtra3);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(p5);
        t1.b().d(getApplicationContext(), str, uuid, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String b5 = v1.a(getApplicationContext(), p5.s()).b();
        if (TextUtils.isEmpty(b5)) {
            Log.e(E, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            a0(r.a("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        Uri.Builder appendQueryParameter = builder.appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", !TextUtils.isEmpty(firebaseAuth.p()) ? firebaseAuth.p() : zzacu.zza()).appendQueryParameter("eventId", uuid);
        appendQueryParameter.appendQueryParameter("v", "X" + stringExtra2).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", b5);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Uri Z(Uri uri, Task task) {
        Uri.Builder buildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            h1.a aVar = (h1.a) task.getResult();
            if (aVar.a() != null) {
                String str = E;
                String valueOf = String.valueOf(aVar.a());
                Log.w(str, "Error getting App Check token; using placeholder token instead. Error: " + valueOf);
            }
            String b5 = aVar.b();
            buildUpon.fragment("fac=" + b5);
        } else {
            String str2 = E;
            String message = task.getException().getMessage();
            Log.e(str2, "Unexpected error getting App Check token: " + message);
        }
        return buildUpon.build();
    }

    private final void a0(Status status) {
        F = 0L;
        this.D = false;
        Intent intent = new Intent();
        h1.c(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        c0(intent);
        G.a(this);
        finish();
    }

    private final boolean c0(Intent intent) {
        return t.a.b(this).d(intent);
    }

    private final void d0() {
        F = 0L;
        this.D = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        c0(intent);
        G.a(this);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b0(String str, Task task) {
        boolean z4 = false;
        if (!(getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) != null)) {
            Log.e(E, "Device cannot resolve intent for: android.intent.action.VIEW");
            zzacl.zzb(this, str);
            return;
        }
        List<ResolveInfo> queryIntentServices = getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            z4 = true;
        }
        if (z4) {
            h.b a5 = new b.a().a();
            a5.f3096a.addFlags(1073741824);
            a5.f3096a.addFlags(268435456);
            a5.a(this, (Uri) task.getResult());
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
        intent.putExtra("com.android.browser.application_id", str);
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // o.x, androidx.activity.h, androidx.core.app.m, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            String str = E;
            Log.e(str, "Could not do operation - unknown action: " + action);
            d0();
            return;
        }
        long a5 = q0.f.b().a();
        if (a5 - F < 30000) {
            Log.e(E, "Could not start operation - already in progress");
            return;
        }
        F = a5;
        if (bundle != null) {
            this.D = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // o.x, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
            if (this.D) {
                d0();
                return;
            }
            Intent intent = getIntent();
            String packageName = getPackageName();
            try {
                String lowerCase = h.a(q0.a.a(this, packageName)).toLowerCase(Locale.US);
                f p5 = f.p(intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(p5);
                if (zzaec.zza(p5)) {
                    zza(Y(Uri.parse(zzaec.zza(p5.r().b())).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.u0());
                } else {
                    new zzacg(packageName, lowerCase, intent, p5, this).executeOnExecutor(firebaseAuth.C0(), new Void[0]);
                }
            } catch (PackageManager.NameNotFoundException e5) {
                String str = E;
                String valueOf = String.valueOf(e5);
                Log.e(str, "Could not get package signature: " + packageName + " " + valueOf);
                zzacl.zzb(this, packageName);
            }
            this.D = true;
            return;
        }
        Intent intent2 = getIntent();
        if (intent2.hasExtra("firebaseError")) {
            a0(h1.b(intent2.getStringExtra("firebaseError")));
        } else if (!intent2.hasExtra("link") || !intent2.hasExtra("eventId")) {
            d0();
        } else {
            String stringExtra = intent2.getStringExtra("link");
            String g5 = t1.b().g(getApplicationContext(), getPackageName(), intent2.getStringExtra("eventId"));
            if (TextUtils.isEmpty(g5)) {
                Log.e(E, "Failed to find registration for this event - failing to prevent session injection.");
                a0(r.a("Failed to find registration for this reCAPTCHA event"));
            }
            if (intent2.getBooleanExtra("encryptionEnabled", true)) {
                stringExtra = v1.a(getApplicationContext(), f.p(g5).s()).c(stringExtra);
            }
            String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
            F = 0L;
            this.D = false;
            Intent intent3 = new Intent();
            intent3.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
            intent3.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent3.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
            if (c0(intent3)) {
                G.a(this);
            } else {
                o0.f(getApplicationContext(), queryParameter, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.h, androidx.core.app.m, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.D);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaci
    public final Context zza() {
        return getApplicationContext();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaci
    public final Uri.Builder zza(Intent intent, String str, String str2) {
        return Y(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaci
    public final String zza(String str) {
        return zzaec.zzb(str);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaci
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) zzb.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            zzaci.zza.c("Error generating connection", new Object[0]);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaci
    public final void zza(final Uri uri, final String str, b2.b<i1.b> bVar) {
        i1.b bVar2 = bVar.get();
        (bVar2 != null ? bVar2.c(false).continueWith(new Continuation() { // from class: com.google.firebase.auth.internal.c
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return RecaptchaActivity.Z(uri, task);
            }
        }) : Tasks.forResult(uri)).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.b
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                RecaptchaActivity.this.b0(str, task);
            }
        });
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaci
    public final void zza(String str, Status status) {
        if (status == null) {
            d0();
        } else {
            a0(status);
        }
    }
}
