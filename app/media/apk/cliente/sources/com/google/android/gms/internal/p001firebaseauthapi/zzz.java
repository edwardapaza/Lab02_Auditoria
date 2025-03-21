package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzz  reason: invalid package */
/* loaded from: classes.dex */
public final class zzz {
    public static int zza(int i5, int i6) {
        String zza;
        if (i5 < 0 || i5 >= i6) {
            if (i5 < 0) {
                zza = zzah.zza("%s (%s) must not be negative", "index", Integer.valueOf(i5));
            } else if (i6 < 0) {
                throw new IllegalArgumentException("negative size: " + i6);
            } else {
                zza = zzah.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i5), Integer.valueOf(i6));
            }
            throw new IndexOutOfBoundsException(zza);
        }
        return i5;
    }

    public static int zza(int i5, int i6, String str) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(zzb(i5, i6, str));
        }
        return i5;
    }

    public static <T> T zza(T t5) {
        t5.getClass();
        return t5;
    }

    public static void zza(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException((i5 < 0 || i5 > i7) ? zzb(i5, i7, "start index") : (i6 < 0 || i6 > i7) ? zzb(i6, i7, "end index") : zzah.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5)));
        }
    }

    public static int zzb(int i5, int i6) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(zzb(i5, i6, "index"));
        }
        return i5;
    }

    private static String zzb(int i5, int i6, String str) {
        if (i5 < 0) {
            return zzah.zza("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return zzah.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException("negative size: " + i6);
    }
}
