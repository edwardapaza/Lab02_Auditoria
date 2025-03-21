package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzl  reason: invalid package */
/* loaded from: classes.dex */
final class zzl extends zzm {
    private final char zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(char c5) {
        this.zza = c5;
    }

    public final String toString() {
        char c5 = this.zza;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i5 = 0; i5 < 4; i5++) {
            cArr[5 - i5] = "0123456789ABCDEF".charAt(c5 & 15);
            c5 = (char) (c5 >> 4);
        }
        String copyValueOf = String.copyValueOf(cArr);
        return "CharMatcher.is('" + copyValueOf + "')";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzj
    public final boolean zza(char c5) {
        return c5 == this.zza;
    }
}
