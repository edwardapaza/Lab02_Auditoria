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
import com.google.android.gms.internal.p001firebaseauthapi.zzaec;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
import com.google.android.gms.internal.p001firebaseauthapi.zzb;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.GenericIdpActivity;
import f1.f;
import h.b;
import j1.g1;
import j1.h1;
import j1.o0;
import j1.r;
import j1.t1;
import j1.v1;
import j1.w1;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import m0.e;
import o.x;
import org.json.JSONException;
import org.json.JSONObject;
import q0.h;
/* loaded from: classes.dex */
public class GenericIdpActivity extends x implements zzaci {
    private static long E;
    private static final g1 F = g1.f();
    private boolean D = false;

    private final Uri.Builder Y(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String join = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        String a02 = a0(intent.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS"));
        String uuid = UUID.randomUUID().toString();
        String zza = zzacl.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String str3 = join;
        t1.b().e(getApplicationContext(), str, uuid, zza, action, stringExtra2, stringExtra3, stringExtra4);
        String b5 = v1.a(getApplicationContext(), f.p(stringExtra4).s()).b();
        if (TextUtils.isEmpty(b5)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            b0(r.a("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        } else if (zza == null) {
            return null;
        } else {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("eid", "p");
            appendQueryParameter.appendQueryParameter("v", "X" + stringExtra5).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", zza).appendQueryParameter("eventId", uuid).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", b5);
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter("scopes", str3);
            }
            if (!TextUtils.isEmpty(a02)) {
                builder.appendQueryParameter("customParameters", a02);
            }
            if (!TextUtils.isEmpty(stringExtra3)) {
                builder.appendQueryParameter("tid", stringExtra3);
            }
            return builder;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Uri Z(Uri uri, Task task) {
        Uri.Builder buildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            h1.a aVar = (h1.a) task.getResult();
            if (aVar.a() != null) {
                String valueOf = String.valueOf(aVar.a());
                Log.w("GenericIdpActivity", "Error getting App Check token; using placeholder token instead. Error: " + valueOf);
            }
            String b5 = aVar.b();
            buildUpon.fragment("fac=" + b5);
        } else {
            String message = task.getException().getMessage();
            Log.e("GenericIdpActivity", "Unexpected error getting App Check token: " + message);
        }
        return buildUpon.build();
    }

    private static String a0(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(str, string);
                }
            }
        } catch (JSONException unused) {
            Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
        }
        return jSONObject.toString();
    }

    private final void b0(Status status) {
        E = 0L;
        this.D = false;
        Intent intent = new Intent();
        h1.c(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (c0(intent)) {
            F.a(this);
        } else {
            o0.b(getApplicationContext(), status);
        }
        finish();
    }

    private final boolean c0(Intent intent) {
        return t.a.b(this).d(intent);
    }

    private final void d0() {
        E = 0L;
        this.D = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (c0(intent)) {
            F.a(this);
        } else {
            o0.b(this, r.a("WEB_CONTEXT_CANCELED"));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // o.x, androidx.activity.h, androidx.core.app.m, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e("GenericIdpActivity", "Could not do operation - unknown action: " + action);
            d0();
            return;
        }
        long a5 = q0.f.b().a();
        if (a5 - E < 30000) {
            Log.e("GenericIdpActivity", "Could not start operation - already in progress");
            return;
        }
        E = a5;
        if (bundle != null) {
            this.D = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
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
            String packageName = getPackageName();
            try {
                String lowerCase = h.a(q0.a.a(this, packageName)).toLowerCase(Locale.US);
                f p5 = f.p(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(p5);
                if (zzaec.zza(p5)) {
                    zza(Y(Uri.parse(zzaec.zza(p5.r().b())).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.u0());
                } else {
                    new zzacg(packageName, lowerCase, getIntent(), p5, this).executeOnExecutor(firebaseAuth.C0(), new Void[0]);
                }
            } catch (PackageManager.NameNotFoundException e5) {
                String valueOf = String.valueOf(e5);
                Log.e("GenericIdpActivity", "Could not get package signature: " + packageName + " " + valueOf);
                zzacl.zzb(this, packageName);
            }
            this.D = true;
            return;
        }
        Intent intent = getIntent();
        if (intent.hasExtra("firebaseError")) {
            b0(h1.b(intent.getStringExtra("firebaseError")));
        } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
            d0();
        } else {
            String stringExtra = intent.getStringExtra("link");
            String stringExtra2 = intent.getStringExtra("eventId");
            String packageName2 = getPackageName();
            boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
            w1 c5 = t1.b().c(this, packageName2, stringExtra2);
            if (c5 == null) {
                d0();
            }
            if (booleanExtra) {
                stringExtra = v1.a(getApplicationContext(), f.p(c5.a()).s()).c(stringExtra);
            }
            zzags zzagsVar = new zzags(c5, stringExtra);
            String e6 = c5.e();
            String b5 = c5.b();
            zzagsVar.zzb(e6);
            if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(b5) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(b5) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(b5)) {
                Log.e("GenericIdpActivity", "unsupported operation: " + b5);
                d0();
                return;
            }
            E = 0L;
            this.D = false;
            Intent intent2 = new Intent();
            e.e(zzagsVar, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
            intent2.putExtra("com.google.firebase.auth.internal.OPERATION", b5);
            intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
            if (c0(intent2)) {
                F.a(this);
            } else {
                o0.c(getApplicationContext(), zzagsVar, b5, e6);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.h, androidx.core.app.m, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.D);
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
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaci
    public final void zza(final Uri uri, final String str, b2.b<i1.b> bVar) {
        i1.b bVar2 = bVar.get();
        (bVar2 != null ? bVar2.c(false).continueWith(new Continuation() { // from class: com.google.firebase.auth.internal.a
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return GenericIdpActivity.Z(uri, task);
            }
        }) : Tasks.forResult(uri)).addOnCompleteListener(new OnCompleteListener() { // from class: j1.j0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                GenericIdpActivity genericIdpActivity = GenericIdpActivity.this;
                String str2 = str;
                boolean z4 = false;
                if (!(genericIdpActivity.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) != null)) {
                    Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
                    zzacl.zzb(genericIdpActivity, str2);
                    return;
                }
                List<ResolveInfo> queryIntentServices = genericIdpActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
                if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                    z4 = true;
                }
                if (z4) {
                    h.b a5 = new b.a().a();
                    Log.i("GenericIdpActivity", "Opening IDP Sign In link in a custom chrome tab.");
                    a5.a(genericIdpActivity, (Uri) task.getResult());
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
                intent.putExtra("com.android.browser.application_id", str2);
                Log.i("GenericIdpActivity", "Opening IDP Sign In link in a browser window.");
                intent.addFlags(1073741824);
                intent.addFlags(268435456);
                genericIdpActivity.startActivity(intent);
            }
        });
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaci
    public final void zza(String str, Status status) {
        if (status == null) {
            d0();
        } else {
            b0(status);
        }
    }
}
