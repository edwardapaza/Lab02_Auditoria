package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import b2.b;
import com.google.android.gms.common.api.Status;
import java.net.HttpURLConnection;
import java.net.URL;
import o0.a;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaci  reason: invalid package */
/* loaded from: classes.dex */
public interface zzaci {
    public static final a zza = new a("FirebaseAuth", "GetAuthDomainTaskResponseHandler");

    Context zza();

    Uri.Builder zza(Intent intent, String str, String str2);

    String zza(String str);

    HttpURLConnection zza(URL url);

    void zza(Uri uri, String str, b<i1.b> bVar);

    void zza(String str, Status status);
}
