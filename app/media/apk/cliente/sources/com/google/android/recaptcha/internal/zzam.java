package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import java.util.UUID;
import m4.h;
import m4.i;
import m4.q0;
import v3.d;
import v4.c;
/* loaded from: classes.dex */
public final class zzam {
    private static zzaw zzb;
    public static final zzam zza = new zzam();
    private static final String zzc = UUID.randomUUID().toString();
    private static final v4.a zzd = c.b(false, 1, null);
    private static final zzt zze = new zzt();
    private static zzg zzf = new zzg(null, 1, null);

    private zzam() {
    }

    public static final Object zzc(Application application, String str, long j5, zzbq zzbqVar, d dVar) {
        return h.e(zze.zzb().b(), new zzah(application, str, j5, null, null), dVar);
    }

    public static final Task zzd(Application application, String str, long j5) {
        q0 b5;
        b5 = i.b(zze.zzb(), null, null, new zzak(application, str, j5, null), 3, null);
        return zzj.zza(b5);
    }

    public static final zzg zze() {
        return zzf;
    }

    public static final void zzf(zzg zzgVar) {
        zzf = zzgVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5 A[Catch: all -> 0x019e, Exception -> 0x01a4, RecaptchaException -> 0x01b1, TryCatch #5 {RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e, blocks: (B:25:0x0090, B:27:0x00d5, B:29:0x00dd, B:31:0x00eb, B:33:0x00f5, B:34:0x00fd, B:35:0x0121, B:36:0x0122), top: B:74:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017e A[Catch: all -> 0x019a, RecaptchaException -> 0x019c, Exception -> 0x01a6, TryCatch #6 {RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a, blocks: (B:38:0x0140, B:46:0x0165, B:47:0x017d, B:48:0x017e, B:49:0x0199), top: B:73:0x00d3 }] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.recaptcha.internal.zzai, v3.d] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3, types: [v4.a] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zza(android.app.Application r22, java.lang.String r23, long r24, com.google.android.recaptcha.internal.zzab r26, android.webkit.WebView r27, com.google.android.recaptcha.internal.zzbq r28, com.google.android.recaptcha.internal.zzt r29, v3.d r30) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzam.zza(android.app.Application, java.lang.String, long, com.google.android.recaptcha.internal.zzab, android.webkit.WebView, com.google.android.recaptcha.internal.zzbq, com.google.android.recaptcha.internal.zzt, v3.d):java.lang.Object");
    }
}
