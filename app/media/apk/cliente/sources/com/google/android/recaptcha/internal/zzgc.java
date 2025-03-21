package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzgc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(boolean z4, String str, long j5, long j6) {
        if (z4) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j5 + ", " + j6 + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(boolean z4) {
        if (!z4) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
