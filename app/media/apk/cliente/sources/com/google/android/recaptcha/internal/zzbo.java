package com.google.android.recaptcha.internal;

import android.net.TrafficStats;
import android.webkit.URLUtil;
import e4.k;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import t3.p;
/* loaded from: classes.dex */
public final class zzbo implements zzbn {
    private final String zza;

    public zzbo(String str) {
        this.zza = str;
    }

    private static final void zzb(byte[] bArr) {
        List h5;
        for (zznf zznfVar : zzni.zzk(bArr).zzH()) {
            h5 = p.h("INIT_TOTAL", "EXECUTE_TOTAL");
            if (h5.contains(zznfVar.zzj().name()) && zznfVar.zzT()) {
                zznfVar.zzJ();
                zznfVar.zzK();
                zznfVar.zzj().name();
                zznfVar.zzg().zzk();
                zznfVar.zzg().zzf();
            } else {
                zznfVar.zzJ();
                zznfVar.zzK();
                zznfVar.zzj().name();
            }
            zznfVar.zzU();
        }
    }

    @Override // com.google.android.recaptcha.internal.zzbn
    public final boolean zza(byte[] bArr) {
        HttpURLConnection httpURLConnection;
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            zzb(bArr);
            if (URLUtil.isHttpUrl(this.zza)) {
                URLConnection openConnection = new URL(this.zza).openConnection();
                k.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) openConnection;
            } else if (!URLUtil.isHttpsUrl(this.zza)) {
                throw new MalformedURLException("Recaptcha server url only allows using Http or Https.");
            } else {
                URLConnection openConnection2 = new URL(this.zza).openConnection();
                k.c(openConnection2, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                httpURLConnection = (HttpsURLConnection) openConnection2;
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuffer");
            httpURLConnection.connect();
            httpURLConnection.getOutputStream().write(bArr);
            return httpURLConnection.getResponseCode() == 200;
        } catch (Exception e5) {
            e5.getMessage();
            return false;
        }
    }
}
