package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzff {
    public static void zza(boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzc(boolean z4, String str, char c5) {
        if (!z4) {
            throw new IllegalArgumentException(zzfi.zza(str, Character.valueOf(c5)));
        }
    }

    public static void zzd(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException((i5 < 0 || i5 > i7) ? zzf(i5, i7, "start index") : (i6 < 0 || i6 > i7) ? zzf(i6, i7, "end index") : zzfi.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5)));
        }
    }

    public static void zze(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzf(int i5, int i6, String str) {
        return i5 < 0 ? zzfi.zza("%s (%s) must not be negative", str, Integer.valueOf(i5)) : zzfi.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
    }
}
