package com.google.android.recaptcha.internal;

import e4.k;
import java.util.List;
import java.util.Set;
import k4.p;
import t3.x;
/* loaded from: classes.dex */
public final class zzcb {
    public static final zzcb zza = new zzcb();
    private static Set zzb;
    private static Set zzc;
    private static Long zzd;
    private static int zze;

    private zzcb() {
    }

    public static final void zza(zznz zznzVar) {
        Set L;
        Set L2;
        L = x.L(zznzVar.zzf().zzi());
        zzb = L;
        L2 = x.L(zznzVar.zzg().zzi());
        zzc = L2;
    }

    public static final boolean zzb(String str) {
        Set set = zzb;
        if (set == null || zzc == null) {
            if (zzd == null) {
                zzd = Long.valueOf(System.currentTimeMillis());
            }
            zze++;
            return true;
        }
        k.c(set, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        if (set.isEmpty()) {
            return true;
        }
        Set set2 = zzc;
        k.c(set2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        if (zzc(str, set2)) {
            return false;
        }
        return zzc(str, set);
    }

    private static final boolean zzc(String str, Set set) {
        List<String> S;
        S = p.S(str, new char[]{'.'}, false, 0, 6, null);
        String str2 = "";
        for (String str3 : S) {
            String concat = str2.concat(String.valueOf(str3));
            if (set.contains(concat)) {
                return true;
            }
            str2 = concat.concat(".");
        }
        return false;
    }
}
