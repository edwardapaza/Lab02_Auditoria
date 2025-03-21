package com.google.android.gms.internal.common;
/* loaded from: classes.dex */
final class zzl extends zzk {
    private final char zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(char c5) {
        this.zza = c5;
    }

    public final String toString() {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        int i5 = this.zza;
        for (int i6 = 0; i6 < 4; i6++) {
            cArr[5 - i6] = "0123456789ABCDEF".charAt(i5 & 15);
            i5 >>= 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        return "CharMatcher.is('" + copyValueOf + "')";
    }

    @Override // com.google.android.gms.internal.common.zzo
    public final boolean zza(char c5) {
        return c5 == this.zza;
    }
}
