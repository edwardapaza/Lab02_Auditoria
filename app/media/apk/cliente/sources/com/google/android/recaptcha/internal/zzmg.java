package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public final class zzmg {
    public static final zzlj zza;
    public static final zzlj zzb;
    public static final zzlj zzc;
    private static final ThreadLocal zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;

    static {
        zzli zzi = zzlj.zzi();
        zzi.zze(-62135596800L);
        zzi.zzd(0);
        zza = (zzlj) zzi.zzj();
        zzli zzi2 = zzlj.zzi();
        zzi2.zze(253402300799L);
        zzi2.zzd(999999999);
        zzb = (zzlj) zzi2.zzj();
        zzli zzi3 = zzlj.zzi();
        zzi3.zze(0L);
        zzi3.zzd(0);
        zzc = (zzlj) zzi3.zzj();
        zzd = new zzmf();
        zze = zzd("now");
        zzf = zzd("getEpochSecond");
        zzg = zzd("getNano");
    }

    public static zzlj zza(zzlj zzljVar) {
        long zzg2 = zzljVar.zzg();
        int i5 = (zzg2 > (-62135596800L) ? 1 : (zzg2 == (-62135596800L) ? 0 : -1));
        int zzf2 = zzljVar.zzf();
        if (i5 < 0 || zzg2 > 253402300799L || zzf2 < 0 || zzf2 >= 1000000000) {
            throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(zzg2), Integer.valueOf(zzf2)));
        }
        return zzljVar;
    }

    public static zzlj zzb(long j5) {
        int i5 = (int) ((j5 % 1000) * 1000000);
        long j6 = j5 / 1000;
        if (i5 <= -1000000000 || i5 >= 1000000000) {
            j6 = zzgb.zza(j6, i5 / 1000000000);
            i5 %= 1000000000;
        }
        if (i5 < 0) {
            i5 += 1000000000;
            j6 = zzgb.zzb(j6, 1L);
        }
        zzli zzi = zzlj.zzi();
        zzi.zze(j6);
        zzi.zzd(i5);
        zzlj zzljVar = (zzlj) zzi.zzj();
        zza(zzljVar);
        return zzljVar;
    }

    public static String zzc(zzlj zzljVar) {
        zza(zzljVar);
        long zzg2 = zzljVar.zzg();
        int zzf2 = zzljVar.zzf();
        StringBuilder sb = new StringBuilder();
        sb.append(((SimpleDateFormat) zzd.get()).format(new Date(zzg2 * 1000)));
        if (zzf2 != 0) {
            sb.append(".");
            sb.append(zzf2 % 1000000 == 0 ? String.format(Locale.ENGLISH, "%1$03d", Integer.valueOf(zzf2 / 1000000)) : zzf2 % 1000 == 0 ? String.format(Locale.ENGLISH, "%1$06d", Integer.valueOf(zzf2 / 1000)) : String.format(Locale.ENGLISH, "%1$09d", Integer.valueOf(zzf2)));
        }
        sb.append("Z");
        return sb.toString();
    }

    private static Method zzd(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
