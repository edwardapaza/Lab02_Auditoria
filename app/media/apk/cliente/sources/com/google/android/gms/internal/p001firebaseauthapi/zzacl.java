package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacl  reason: invalid package */
/* loaded from: classes.dex */
public final /* synthetic */ class zzacl {
    public static String zza(zzaci zzaciVar, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance("SHA-256").digest(str.getBytes()));
            int length = str2.length();
            int i5 = 0;
            while (i5 < length) {
                if (zzk.zza(str2.charAt(i5))) {
                    char[] charArray = str2.toCharArray();
                    while (i5 < length) {
                        char c5 = charArray[i5];
                        if (zzk.zza(c5)) {
                            charArray[i5] = (char) (c5 ^ ' ');
                        }
                        i5++;
                    }
                    return String.valueOf(charArray);
                }
                i5++;
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            zzaci.zza.c("Failed to get SHA-256 MessageDigest", new Object[0]);
            return null;
        }
    }

    public static void zzb(zzaci zzaciVar, String str) {
        zzaciVar.zza(str, null);
    }
}
