package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.q;
import q0.a;
import q0.h;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzado  reason: invalid package */
/* loaded from: classes.dex */
public final class zzado {
    private final String zza;
    private final String zzb;

    public zzado(Context context) {
        this(context, context.getPackageName());
    }

    private zzado(Context context, String str) {
        q.k(context);
        String e5 = q.e(str);
        this.zza = e5;
        try {
            byte[] a5 = a.a(context, e5);
            if (a5 != null) {
                this.zzb = h.b(a5, false);
                return;
            }
            Log.e("FBA-PackageInfo", "single cert required: " + str);
            this.zzb = null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("FBA-PackageInfo", "no pkg: " + str);
            this.zzb = null;
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
