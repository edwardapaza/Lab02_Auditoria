package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.logging.Level;
import java.util.logging.Logger;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzah  reason: invalid package */
/* loaded from: classes.dex */
public final class zzah {
    private static String zza(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e5) {
            String str = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for " + str, (Throwable) e5);
            return "<" + str + " threw " + e5.getClass().getName() + ">";
        }
    }

    public static String zza(String str) {
        return zzy.zzb(str);
    }

    public static String zza(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i5 = 0;
        for (int i6 = 0; i6 < objArr.length; i6++) {
            objArr[i6] = zza(objArr[i6]);
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i7 = 0;
        while (i5 < objArr.length && (indexOf = valueOf.indexOf("%s", i7)) != -1) {
            sb.append((CharSequence) valueOf, i7, indexOf);
            sb.append(objArr[i5]);
            i7 = indexOf + 2;
            i5++;
        }
        sb.append((CharSequence) valueOf, i7, valueOf.length());
        if (i5 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i5]);
            for (int i8 = i5 + 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String zzb(String str) {
        return zzy.zzc(str);
    }

    public static boolean zzc(String str) {
        return zzy.zzd(str);
    }
}
