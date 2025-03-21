package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.n;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzact  reason: invalid package */
/* loaded from: classes.dex */
public final class zzact {
    private final int zza;

    private zzact(String str) {
        this.zza = zza(str);
    }

    private static int zza(String str) {
        try {
            List<String> zza = zzac.zza("[.-]").zza((CharSequence) str);
            if (zza.size() == 1) {
                return Integer.parseInt(str);
            }
            if (zza.size() >= 3) {
                return (Integer.parseInt(zza.get(0)) * 1000000) + (Integer.parseInt(zza.get(1)) * 1000) + Integer.parseInt(zza.get(2));
            }
            return -1;
        } catch (IllegalArgumentException e5) {
            if (Log.isLoggable("LibraryVersionContainer", 3)) {
                Log.d("LibraryVersionContainer", String.format("Version code parsing failed for: %s with exception %s.", str, e5));
                return -1;
            }
            return -1;
        }
    }

    public static zzact zza() {
        String b5 = n.a().b("firebase-auth");
        return new zzact((TextUtils.isEmpty(b5) || b5.equals("UNKNOWN")) ? "-1" : "-1");
    }

    public final String zzb() {
        return String.format("X%s", Integer.toString(this.zza));
    }
}
