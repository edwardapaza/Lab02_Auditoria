package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadl  reason: invalid package */
/* loaded from: classes.dex */
public final class zzadl {
    public static void zza(String str, zzacr zzacrVar, zzadm<?> zzadmVar, Type type, zzacv zzacvVar) {
        String str2;
        try {
            q.k(zzacrVar);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzacrVar.zza().getBytes(Charset.defaultCharset());
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzacvVar.zza(httpURLConnection);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), bytes.length);
            try {
                bufferedOutputStream.write(bytes, 0, bytes.length);
                bufferedOutputStream.close();
                zza(httpURLConnection, zzadmVar, type);
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            str2 = e.getMessage();
            zzadmVar.zza(str2);
        } catch (NullPointerException e6) {
            e = e6;
            str2 = e.getMessage();
            zzadmVar.zza(str2);
        } catch (SocketTimeoutException unused) {
            str2 = "TIMEOUT";
            zzadmVar.zza(str2);
        } catch (UnknownHostException unused2) {
            str2 = "<<Network Error>>";
            zzadmVar.zza(str2);
        } catch (JSONException e7) {
            e = e7;
            str2 = e.getMessage();
            zzadmVar.zza(str2);
        }
    }

    public static void zza(String str, zzadm<?> zzadmVar, Type type, zzacv zzacvVar) {
        String message;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            zzacvVar.zza(httpURLConnection);
            zza(httpURLConnection, zzadmVar, type);
        } catch (SocketTimeoutException unused) {
            message = "TIMEOUT";
            zzadmVar.zza(message);
        } catch (UnknownHostException unused2) {
            message = "<<Network Error>>";
            zzadmVar.zza(message);
        } catch (IOException e5) {
            message = e5.getMessage();
            zzadmVar.zza(message);
        }
    }

    private static void zza(HttpURLConnection httpURLConnection, zzadm<?> zzadmVar, Type type) {
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InputStream inputStream = zza(responseCode) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                String sb2 = sb.toString();
                if (zza(responseCode)) {
                    zzadmVar.zza((zzadm<?>) ((zzacq) zzaco.zza(sb2, type)));
                } else {
                    zzadmVar.zza((String) zzaco.zza(sb2, String.class));
                }
                httpURLConnection.disconnect();
            } catch (zzaah e5) {
                e = e5;
                zzadmVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            } catch (SocketTimeoutException unused) {
                zzadmVar.zza("TIMEOUT");
                httpURLConnection.disconnect();
            } catch (IOException e6) {
                e = e6;
                zzadmVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }

    private static final boolean zza(int i5) {
        return i5 >= 200 && i5 < 300;
    }
}
