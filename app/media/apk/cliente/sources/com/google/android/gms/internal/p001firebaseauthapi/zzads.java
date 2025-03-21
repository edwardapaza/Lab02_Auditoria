package com.google.android.gms.internal.p001firebaseauthapi;

import android.app.Activity;
import androidx.collection.a;
import com.google.firebase.auth.q0;
import java.util.Map;
import java.util.concurrent.Executor;
import q0.f;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzads  reason: invalid package */
/* loaded from: classes.dex */
public final class zzads {
    private static final Map<String, zzadu> zza = new a();

    public static q0.b zza(String str, q0.b bVar, zzacw zzacwVar) {
        zza(str, zzacwVar);
        return new zzadr(bVar, str);
    }

    public static void zza() {
        zza.clear();
    }

    private static void zza(String str, zzacw zzacwVar) {
        zza.put(str, new zzadu(zzacwVar, f.b().a()));
    }

    public static boolean zza(String str, q0.b bVar, Activity activity, Executor executor) {
        Map<String, zzadu> map = zza;
        if (!map.containsKey(str)) {
            zza(str, null);
            return false;
        }
        zzadu zzaduVar = map.get(str);
        if (f.b().a() - zzaduVar.zzb >= 120000) {
            zza(str, null);
            return false;
        }
        zzacw zzacwVar = zzaduVar.zza;
        if (zzacwVar != null) {
            zzacwVar.zza(bVar, activity, executor, str);
            return true;
        }
        return true;
    }
}
