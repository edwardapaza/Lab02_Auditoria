package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import java.io.UnsupportedEncodingException;
import java.util.List;
import q0.c;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafo  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafo {
    public static long zza(String str) {
        zzafn zzb = zzb(str);
        return zzb.zza().longValue() - zzb.zzb().longValue();
    }

    private static zzafn zzb(String str) {
        q.e(str);
        List<String> zza = zzac.zza('.').zza((CharSequence) str);
        if (zza.size() >= 2) {
            try {
                return zzafn.zza(new String(c.b(zza.get(1)), "UTF-8"));
            } catch (UnsupportedEncodingException e5) {
                throw new RuntimeException("Unable to decode token", e5);
            }
        }
        throw new RuntimeException("Invalid idToken " + str);
    }
}
