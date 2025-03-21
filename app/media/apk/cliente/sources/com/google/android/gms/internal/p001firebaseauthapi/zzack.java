package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import l0.g;
import l0.k;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzack  reason: invalid package */
/* loaded from: classes.dex */
public final class zzack {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int g5 = g.e().g(context, k.f5890a);
            zza = Boolean.valueOf(g5 == 0 || g5 == 2);
        }
        return zza.booleanValue();
    }
}
