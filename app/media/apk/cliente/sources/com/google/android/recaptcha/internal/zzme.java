package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzme {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;

    static {
        zzia zzi = zzib.zzi();
        zzi.zze(-315576000000L);
        zzi.zzd(-999999999);
        zza = (zzib) zzi.zzj();
        zzia zzi2 = zzib.zzi();
        zzi2.zze(315576000000L);
        zzi2.zzd(999999999);
        zzb = (zzib) zzi2.zzj();
        zzia zzi3 = zzib.zzi();
        zzi3.zze(0L);
        zzi3.zzd(0);
        zzc = (zzib) zzi3.zzj();
    }

    public static zzib zza(long j5) {
        int i5;
        int i6 = (int) (j5 % 1000000000);
        long j6 = j5 / 1000000000;
        if (i6 <= -1000000000 || i6 >= 1000000000) {
            j6 = zzgb.zza(j6, i6 / 1000000000);
            i6 %= 1000000000;
        }
        if (j6 > 0 && i6 < 0) {
            i6 += 1000000000;
            j6--;
        }
        if (j6 < 0 && i6 > 0) {
            i6 -= 1000000000;
            j6++;
        }
        zzia zzi = zzib.zzi();
        zzi.zze(j6);
        zzi.zzd(i6);
        zzib zzibVar = (zzib) zzi.zzj();
        long zzg = zzibVar.zzg();
        int zzf = zzibVar.zzf();
        if (zzg < -315576000000L || zzg > 315576000000L || zzf < -999999999 || zzf >= 1000000000 || ((zzg < 0 || zzf < 0) && (i5 > 0 || zzf > 0))) {
            throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(zzg), Integer.valueOf(zzf)));
        }
        return zzibVar;
    }
}
