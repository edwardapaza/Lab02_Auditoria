package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzj  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzj {
    public int zza(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        zzz.zza(i5, length, "index");
        while (i5 < length) {
            if (zza(charSequence.charAt(i5))) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public abstract boolean zza(char c5);
}
