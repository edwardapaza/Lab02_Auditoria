package j1;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzbj;
import com.google.android.gms.internal.p001firebaseauthapi.zzbp;
import com.google.android.gms.internal.p001firebaseauthapi.zzce;
import com.google.android.gms.internal.p001firebaseauthapi.zzkj;
import com.google.android.gms.internal.p001firebaseauthapi.zzkq;
import com.google.android.gms.internal.p001firebaseauthapi.zzlx;
import com.google.android.gms.internal.p001firebaseauthapi.zzw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
public final class v1 {

    /* renamed from: c  reason: collision with root package name */
    private static v1 f5489c;

    /* renamed from: a  reason: collision with root package name */
    private final String f5490a;

    /* renamed from: b  reason: collision with root package name */
    private final zzlx f5491b;

    private v1(Context context, String str, boolean z4) {
        zzlx zzlxVar;
        this.f5490a = str;
        try {
            zzkj.zza();
            zzlx.zza zza = new zzlx.zza().zza(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", str)).zza(zzkq.zza);
            zza.zza(String.format("android-keystore://firebear_master_key_id.%s", str));
            zzlxVar = zza.zza();
        } catch (IOException | GeneralSecurityException e5) {
            String message = e5.getMessage();
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n" + message);
            zzlxVar = null;
        }
        this.f5491b = zzlxVar;
    }

    public static v1 a(Context context, String str) {
        v1 v1Var = f5489c;
        if (v1Var == null || !zzw.zza(v1Var.f5490a, str)) {
            f5489c = new v1(context, str, true);
        }
        return f5489c;
    }

    public final String b() {
        if (this.f5491b == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzce zza = zzbj.zza(byteArrayOutputStream);
        try {
            synchronized (this.f5491b) {
                this.f5491b.zza().zza().zza(zza);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e5) {
            String message = e5.getMessage();
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n" + message);
            return null;
        }
    }

    public final String c(String str) {
        String str2;
        zzlx zzlxVar = this.f5491b;
        if (zzlxVar == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
            return null;
        }
        try {
            synchronized (zzlxVar) {
                str2 = new String(((zzbp) this.f5491b.zza().zza(zzbp.class)).zza(Base64.decode(str, 8), null), "UTF-8");
            }
            return str2;
        } catch (UnsupportedEncodingException | GeneralSecurityException e5) {
            String message = e5.getMessage();
            Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n" + message);
            return null;
        }
    }
}
