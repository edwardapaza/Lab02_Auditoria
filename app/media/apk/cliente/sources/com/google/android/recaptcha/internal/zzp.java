package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaErrorCode;
import com.google.android.recaptcha.RecaptchaException;
import e4.k;
import java.util.Map;
import s3.p;
import t3.h0;
/* loaded from: classes.dex */
public final class zzp extends Exception {
    public static final zzo zza = new zzo(null);
    private static final Map zzb;
    private final zzn zzc;
    private final zzl zzd;
    private final String zze;
    private final Map zzf;

    static {
        Map e5;
        zzpb zzpbVar = zzpb.JS_INTERNAL_ERROR;
        zzn zznVar = zzn.zzc;
        e5 = h0.e(p.a(zzpb.JS_NETWORK_ERROR, new zzp(zzn.zze, zzl.zzm, null)), p.a(zzpbVar, new zzp(zznVar, zzl.zzk, null)), p.a(zzpb.JS_INVALID_SITE_KEY, new zzp(zzn.zzf, zzl.zzn, null)), p.a(zzpb.JS_INVALID_SITE_KEY_TYPE, new zzp(zzn.zzg, zzl.zzo, null)), p.a(zzpb.JS_THIRD_PARTY_APP_PACKAGE_NAME_NOT_ALLOWED, new zzp(zzn.zzh, zzl.zzp, null)), p.a(zzpb.JS_INVALID_ACTION, new zzp(zzn.zzi, zzl.zzq, null)), p.a(zzpb.JS_PROGRAM_ERROR, new zzp(zznVar, zzl.zzu, null)));
        zzb = e5;
    }

    public zzp(zzn zznVar, zzl zzlVar, String str) {
        Map e5;
        this.zzc = zznVar;
        this.zzd = zzlVar;
        this.zze = str;
        zzn zznVar2 = zzn.zze;
        RecaptchaErrorCode recaptchaErrorCode = RecaptchaErrorCode.NETWORK_ERROR;
        e5 = h0.e(p.a(zznVar2, new RecaptchaException(recaptchaErrorCode, null, 2, null)), p.a(zzn.zzk, new RecaptchaException(recaptchaErrorCode, null, 2, null)), p.a(zzn.zzf, new RecaptchaException(RecaptchaErrorCode.INVALID_SITEKEY, null, 2, null)), p.a(zzn.zzg, new RecaptchaException(RecaptchaErrorCode.INVALID_KEYTYPE, null, 2, null)), p.a(zzn.zzh, new RecaptchaException(RecaptchaErrorCode.INVALID_PACKAGE_NAME, null, 2, null)), p.a(zzn.zzi, new RecaptchaException(RecaptchaErrorCode.INVALID_ACTION, null, 2, null)), p.a(zzn.zzc, new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, null, 2, null)));
        this.zzf = e5;
    }

    public final zzl zza() {
        return this.zzd;
    }

    public final zzn zzb() {
        return this.zzc;
    }

    public final RecaptchaException zzc() {
        if (k.a(this.zzd, zzl.zzT)) {
            return new RecaptchaException(RecaptchaErrorCode.INVALID_TIMEOUT, null, 2, null);
        }
        RecaptchaException recaptchaException = (RecaptchaException) this.zzf.get(this.zzc);
        return recaptchaException == null ? new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, null, 2, null) : recaptchaException;
    }

    public final String zzd() {
        return this.zze;
    }
}
