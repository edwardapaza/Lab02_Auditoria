package com.google.android.gms.internal.location;

import javax.annotation.CheckForNull;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public final class zzer {
    public static void zza(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z, @CheckForNull Object obj) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException((String) obj);
    }

    public static int zzc(int i, int i2, String str) {
        String zza;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                zza = zzes.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else if (i2 < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 15);
                sb.append("negative size: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            } else {
                zza = zzes.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(zza);
        }
        return i;
    }

    public static int zzd(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzf(i, i2, "index"));
        }
        return i;
    }

    public static void zze(int i, int i2, int i3) {
        String zzf;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                zzf = zzf(i, i3, "start index");
            } else {
                zzf = (i2 < 0 || i2 > i3) ? zzf(i2, i3, "end index") : zzes.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(zzf);
        }
    }

    private static String zzf(int i, int i2, String str) {
        if (i < 0) {
            return zzes.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzes.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 15);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }
}
