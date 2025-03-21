package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.Locale;
import java.util.MissingResourceException;
/* loaded from: classes.dex */
public final class zzbf {
    public static final zzbe zza = new zzbe(null);
    private static zzmo zzb;
    private final String zzc;
    private final zzac zzd;
    private final zznc zze;
    private final long zzf;

    public zzbf(zzbb zzbbVar, String str, zzac zzacVar) {
        this.zzc = str;
        this.zzd = zzacVar;
        zznc zzi = zznf.zzi();
        this.zze = zzi;
        this.zzf = System.currentTimeMillis();
        zzi.zzp(zzbbVar.zza());
        zzi.zzd(zzbbVar.zzb());
        zzi.zzr(zzbbVar.zzc());
        if (zzbbVar.zzd() != null) {
            zzi.zzu(zzbbVar.zzd());
        }
        zzi.zzt(zzmg.zzc(zzmg.zzb(System.currentTimeMillis())));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:2|3|4)|(2:6|(8:8|9|10|11|(1:13)(2:18|(1:20)(3:21|15|16))|14|15|16))(1:25)|23|10|11|(0)(0)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
        if (r2 == (-1)) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046 A[Catch: NameNotFoundException -> 0x0089, TryCatch #0 {NameNotFoundException -> 0x0089, blocks: (B:13:0x0042, B:15:0x0046, B:16:0x005c, B:19:0x0066, B:20:0x0077), top: B:25:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final com.google.android.recaptcha.internal.zzmo zzb(android.content.Context r8) {
        /*
            java.lang.String r0 = "unknown"
            r1 = 33
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            java.lang.String r3 = "com.google.android.gms.version"
            r4 = -1
            if (r2 < r1) goto L2b
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            java.lang.String r5 = r8.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            r6 = 128(0x80, double:6.32E-322)
            android.content.pm.PackageManager$ApplicationInfoFlags r6 = android.content.pm.PackageManager.ApplicationInfoFlags.of(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r5, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            android.os.Bundle r2 = r2.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            int r2 = r2.getInt(r3, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            if (r2 != r4) goto L26
            goto L41
        L26:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            goto L42
        L2b:
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            java.lang.String r5 = r8.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r5, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            android.os.Bundle r2 = r2.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            int r2 = r2.getInt(r3, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41
            if (r2 != r4) goto L26
        L41:
            r2 = r0
        L42:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            if (r3 < r1) goto L61
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            java.lang.String r8 = r8.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            r3 = 0
            android.content.pm.PackageManager$PackageInfoFlags r3 = android.content.pm.PackageManager.PackageInfoFlags.of(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            long r3 = com.google.android.recaptcha.internal.a.a(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
        L5c:
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            goto L89
        L61:
            r1 = 28
            r4 = 0
            if (r3 < r1) goto L77
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            java.lang.String r8 = r8.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            long r3 = com.google.android.recaptcha.internal.a.a(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            goto L5c
        L77:
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            java.lang.String r8 = r8.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            int r8 = r8.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
            java.lang.String r0 = java.lang.String.valueOf(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L89
        L89:
            com.google.android.recaptcha.internal.zzmn r8 = com.google.android.recaptcha.internal.zzmo.zzf()
            int r1 = android.os.Build.VERSION.SDK_INT
            r8.zzd(r1)
            r8.zzq(r2)
            java.lang.String r1 = "18.4.0"
            r8.zzs(r1)
            java.lang.String r1 = android.os.Build.MODEL
            r8.zzp(r1)
            java.lang.String r1 = android.os.Build.MANUFACTURER
            r8.zzr(r1)
            r8.zze(r0)
            com.google.android.recaptcha.internal.zzit r8 = r8.zzj()
            com.google.android.recaptcha.internal.zzmo r8 = (com.google.android.recaptcha.internal.zzmo) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbf.zzb(android.content.Context):com.google.android.recaptcha.internal.zzmo");
    }

    public final zznf zza(int i5, zzmr zzmrVar, Context context) {
        String str;
        String str2 = "";
        long currentTimeMillis = System.currentTimeMillis() - this.zzf;
        zznc zzncVar = this.zze;
        zzncVar.zze(currentTimeMillis);
        zzncVar.zzv(i5);
        if (zzmrVar != null) {
            this.zze.zzq(zzmrVar);
        }
        if (zzb == null) {
            zzb = zzb(context);
        }
        try {
            str = Locale.getDefault().getISO3Language();
        } catch (MissingResourceException unused) {
            str = "";
        }
        try {
            str2 = Locale.getDefault().getISO3Country();
        } catch (MissingResourceException unused2) {
        }
        zznc zzncVar2 = this.zze;
        String str3 = this.zzc;
        zznq zzf = zznr.zzf();
        zzf.zzq(str3);
        zzmo zzmoVar = zzb;
        if (zzmoVar == null) {
            zzmoVar = zzb(context);
        }
        zzf.zzd(zzmoVar);
        zzf.zzp(str);
        zzf.zze(str2);
        zzncVar2.zzs((zznr) zzf.zzj());
        return (zznf) this.zze.zzj();
    }
}
