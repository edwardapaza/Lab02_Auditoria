package com.google.android.gms.internal.p001firebaseauthapi;

import a2.i;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import f1.f;
import h1.a;
import i1.b;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacv  reason: invalid package */
/* loaded from: classes.dex */
public final class zzacv {
    private Context zza;
    private zzado zzb;
    private String zzc;
    private final f zzd;
    private boolean zze;
    private String zzf;

    public zzacv(Context context, f fVar, String str) {
        this.zze = false;
        this.zza = (Context) q.k(context);
        this.zzd = (f) q.k(fVar);
        this.zzc = String.format("Android/%s/%s", "Fallback", str);
    }

    public zzacv(f fVar, String str) {
        this(fVar.m(), fVar, str);
    }

    private static String zza(f fVar) {
        b bVar = FirebaseAuth.getInstance(fVar).u0().get();
        if (bVar == null) {
            return null;
        }
        try {
            a aVar = (a) Tasks.await(bVar.c(false));
            if (aVar.a() != null) {
                String valueOf = String.valueOf(aVar.a());
                Log.w("LocalRequestInterceptor", "Error getting App Check token; using placeholder token instead. Error: " + valueOf);
            }
            return aVar.b();
        } catch (InterruptedException | ExecutionException e5) {
            String message = e5.getMessage();
            Log.e("LocalRequestInterceptor", "Unexpected error getting App Check token: " + message);
            return null;
        }
    }

    private static String zzb(f fVar) {
        i iVar = FirebaseAuth.getInstance(fVar).y0().get();
        if (iVar != null) {
            try {
                return (String) Tasks.await(iVar.a());
            } catch (InterruptedException | ExecutionException e5) {
                String message = e5.getMessage();
                Log.w("LocalRequestInterceptor", "Unable to get heartbeats: " + message);
            }
        }
        return null;
    }

    public final void zza(String str) {
        this.zze = !TextUtils.isEmpty(str);
    }

    public final void zza(URLConnection uRLConnection) {
        StringBuilder sb;
        String str;
        if (this.zze) {
            String str2 = this.zzc;
            sb = new StringBuilder();
            sb.append(str2);
            str = "/FirebaseUI-Android";
        } else {
            String str3 = this.zzc;
            sb = new StringBuilder();
            sb.append(str3);
            str = "/FirebaseCore-Android";
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (this.zzb == null) {
            this.zzb = new zzado(this.zza);
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.zzb.zzb());
        uRLConnection.setRequestProperty("X-Android-Cert", this.zzb.zza());
        uRLConnection.setRequestProperty("Accept-Language", zzacu.zza());
        uRLConnection.setRequestProperty("X-Client-Version", sb2);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.zzf);
        uRLConnection.setRequestProperty("X-Firebase-GMPID", this.zzd.r().c());
        uRLConnection.setRequestProperty("X-Firebase-Client", zzb(this.zzd));
        String zza = zza(this.zzd);
        if (!TextUtils.isEmpty(zza)) {
            uRLConnection.setRequestProperty("X-Firebase-AppCheck", zza);
        }
        this.zzf = null;
    }

    public final void zzb(String str) {
        this.zzf = str;
    }
}
