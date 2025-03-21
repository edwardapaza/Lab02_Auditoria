package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import com.google.firebase.auth.FirebaseAuth;
import f1.f;
import j1.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import o0.a;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacg  reason: invalid package */
/* loaded from: classes.dex */
public final class zzacg extends AsyncTask<Void, Void, zzacj> {
    private static final a zza = new a("FirebaseAuth", "GetAuthDomainTask");
    private final String zzb;
    private final String zzc;
    private final WeakReference<zzaci> zzd;
    private final Uri.Builder zze;
    private final String zzf;
    private final f zzg;

    public zzacg(String str, String str2, Intent intent, f fVar, zzaci zzaciVar) {
        this.zzb = q.e(str);
        this.zzg = (f) q.k(fVar);
        q.e(str2);
        q.k(intent);
        String e5 = q.e(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder buildUpon = Uri.parse(zzaciVar.zza(e5)).buildUpon();
        buildUpon.appendPath("getProjectConfig").appendQueryParameter("key", e5).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) q.k(str2));
        this.zzc = buildUpon.build().toString();
        this.zzd = new WeakReference<>(zzaciVar);
        this.zze = zzaciVar.zza(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zza */
    public final zzacj doInBackground(Void... voidArr) {
        try {
            URL url = new URL(this.zzc);
            zzaci zzaciVar = this.zzd.get();
            HttpURLConnection zza2 = zzaciVar.zza(url);
            zza2.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
            zza2.setConnectTimeout(60000);
            new zzacv(zzaciVar.zza(), this.zzg, zzact.zza().zzb()).zza(zza2);
            int responseCode = zza2.getResponseCode();
            if (responseCode != 200) {
                String zza3 = zza(zza2);
                zza.c(String.format("Error getting project config. Failed with %s %s", zza3, Integer.valueOf(responseCode)), new Object[0]);
                return zzacj.zzb(zza3);
            }
            zzafh zzafhVar = new zzafh();
            zzafhVar.zza(new String(zza(zza2.getInputStream(), 128)));
            if (!TextUtils.isEmpty(this.zzf)) {
                return !zzafhVar.zza().contains(this.zzf) ? zzacj.zzb("UNAUTHORIZED_DOMAIN") : zzacj.zza(this.zzf);
            }
            for (String str : zzafhVar.zza()) {
                if (zza(str)) {
                    return zzacj.zza(str);
                }
            }
            return null;
        } catch (zzaah e5) {
            a aVar = zza;
            String message = e5.getMessage();
            aVar.c("ConversionException encountered: " + message, new Object[0]);
            return null;
        } catch (IOException e6) {
            a aVar2 = zza;
            String message2 = e6.getMessage();
            aVar2.c("IOException occurred: " + message2, new Object[0]);
            return null;
        } catch (NullPointerException e7) {
            a aVar3 = zza;
            String message3 = e7.getMessage();
            aVar3.c("Null pointer encountered: " + message3, new Object[0]);
            return null;
        }
    }

    private static String zza(HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getResponseCode() >= 400) {
                InputStream errorStream = httpURLConnection.getErrorStream();
                if (errorStream == null) {
                    return "WEB_INTERNAL_ERROR:Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again.";
                }
                return (String) zzaco.zza(new String(zza(errorStream, 128)), String.class);
            }
            return null;
        } catch (IOException e5) {
            a aVar = zza;
            String valueOf = String.valueOf(e5);
            aVar.h("Error parsing error message from response body in getErrorMessageFromBody. " + valueOf, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zza */
    public final void onPostExecute(zzacj zzacjVar) {
        String str;
        Uri.Builder builder;
        zzaci zzaciVar = this.zzd.get();
        String str2 = null;
        if (zzacjVar != null) {
            str2 = zzacjVar.zza();
            str = zzacjVar.zzb();
        } else {
            str = null;
        }
        if (zzaciVar == null) {
            zza.c("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (TextUtils.isEmpty(str2) || (builder = this.zze) == null) {
            zzaciVar.zza(this.zzb, r.a(str));
        } else {
            builder.authority(str2);
            zzaciVar.zza(this.zze.build(), this.zzb, FirebaseAuth.getInstance(this.zzg).u0());
        }
    }

    private static boolean zza(String str) {
        try {
            String host = new URI("https://" + str).getHost();
            if (host != null) {
                if (host.endsWith("firebaseapp.com")) {
                    return true;
                }
                if (host.endsWith("web.app")) {
                    return true;
                }
            }
        } catch (URISyntaxException e5) {
            a aVar = zza;
            String message = e5.getMessage();
            aVar.c("Error parsing URL for auth domain check: " + str + ". " + message, new Object[0]);
        }
        return false;
    }

    private static byte[] zza(InputStream inputStream, int i5) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onCancelled(zzacj zzacjVar) {
        onPostExecute((zzacj) null);
    }
}
