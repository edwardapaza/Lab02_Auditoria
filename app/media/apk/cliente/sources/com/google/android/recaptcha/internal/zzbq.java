package com.google.android.recaptcha.internal;

import e4.k;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
/* loaded from: classes.dex */
public final class zzbq {
    private final zzh zza;
    private final zzbg zzb;

    public zzbq(zzh zzhVar, zzbg zzbgVar) {
        this.zza = zzhVar;
        this.zzb = zzbgVar;
    }

    public final zzoe zza(String str, byte[] bArr, zzbd zzbdVar) {
        zzbb zza = zzbdVar.zza(zzne.VALIDATE_INPUT);
        zzbg.zzc(this.zzb, zza, null, 2, null);
        try {
            URLConnection openConnection = new URL(str).openConnection();
            k.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Accept", "application/x-protobuffer");
            try {
                httpURLConnection.connect();
                httpURLConnection.getOutputStream().write(bArr);
                if (httpURLConnection.getResponseCode() == 200) {
                    try {
                        zzoe zzi = zzoe.zzi(httpURLConnection.getInputStream());
                        this.zzb.zza(zza);
                        return zzi;
                    } catch (Exception unused) {
                        throw new zzp(zzn.zzc, zzl.zzR, null);
                    }
                } else if (httpURLConnection.getResponseCode() == 400) {
                    zzoz zzg = zzoz.zzg(httpURLConnection.getErrorStream());
                    zzo zzoVar = zzp.zza;
                    throw zzo.zza(zzg.zzi());
                } else {
                    throw zzbr.zza(httpURLConnection.getResponseCode());
                }
            } catch (Exception e5) {
                if (e5 instanceof zzp) {
                    throw ((zzp) e5);
                }
                throw new zzp(zzn.zze, zzl.zzQ, null);
            }
        } catch (zzp e6) {
            this.zzb.zzb(zza, e6, null);
            throw e6.zzc();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d A[Catch: Exception -> 0x0121, TRY_LEAVE, TryCatch #6 {Exception -> 0x0121, blocks: (B:3:0x0003, B:5:0x0015, B:14:0x004d, B:15:0x0058, B:18:0x0084, B:26:0x00b2, B:27:0x00b7, B:30:0x00cd, B:34:0x00e6, B:35:0x00f6, B:32:0x00dc, B:33:0x00e5, B:36:0x00f7, B:37:0x0100, B:38:0x0101, B:39:0x010a, B:41:0x010c, B:42:0x0111, B:43:0x0112, B:11:0x003c, B:10:0x002e, B:6:0x0020, B:8:0x0028, B:28:0x00bd), top: B:62:0x0003, inners: #0, #1, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zzb(com.google.android.recaptcha.internal.zzoe r12, com.google.android.recaptcha.internal.zzbd r13) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbq.zzb(com.google.android.recaptcha.internal.zzoe, com.google.android.recaptcha.internal.zzbd):java.lang.String");
    }
}
