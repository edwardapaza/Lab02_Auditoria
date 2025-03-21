package com.google.android.gms.internal.p001firebaseauthapi;

import androidx.collection.a;
import f1.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaec  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaec {
    private static final Map<String, zzaeb> zza = new a();
    private static final Map<String, List<WeakReference<zzaee>>> zzb = new a();

    public static String zza(String str) {
        zzaeb zzaebVar;
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            zzaebVar = map.get(str);
        }
        if (zzaebVar != null) {
            String zza2 = zza(zzaebVar.zzb(), zzaebVar.zza(), zzaebVar.zzb().contains(":"));
            return zza2 + "emulator/auth/handler";
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    private static String zza(String str, int i5, boolean z4) {
        StringBuilder sb;
        String str2;
        if (z4) {
            sb = new StringBuilder("http://[");
            sb.append(str);
            str2 = "]:";
        } else {
            sb = new StringBuilder("http://");
            sb.append(str);
            str2 = ":";
        }
        sb.append(str2);
        sb.append(i5);
        sb.append("/");
        return sb.toString();
    }

    public static void zza(f fVar, String str, int i5) {
        String b5 = fVar.r().b();
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            map.put(b5, new zzaeb(str, i5));
        }
        Map<String, List<WeakReference<zzaee>>> map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(b5)) {
                boolean z4 = false;
                for (WeakReference<zzaee> weakReference : map2.get(b5)) {
                    zzaee zzaeeVar = weakReference.get();
                    if (zzaeeVar != null) {
                        z4 = true;
                        zzaeeVar.zza();
                    }
                }
                if (!z4) {
                    zza.remove(b5);
                }
            }
        }
    }

    public static void zza(String str, zzaee zzaeeVar) {
        Map<String, List<WeakReference<zzaee>>> map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                map.get(str).add(new WeakReference<>(zzaeeVar));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference<>(zzaeeVar));
                map.put(str, arrayList);
            }
        }
    }

    public static boolean zza(f fVar) {
        return zza.containsKey(fVar.r().b());
    }

    public static String zzb(String str) {
        zzaeb zzaebVar;
        String str2;
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            zzaebVar = map.get(str);
        }
        if (zzaebVar != null) {
            str2 = "" + zza(zzaebVar.zzb(), zzaebVar.zza(), zzaebVar.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "www.googleapis.com/identitytoolkit/v3/relyingparty";
    }

    public static String zzc(String str) {
        zzaeb zzaebVar;
        String str2;
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            zzaebVar = map.get(str);
        }
        if (zzaebVar != null) {
            str2 = "" + zza(zzaebVar.zzb(), zzaebVar.zza(), zzaebVar.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "identitytoolkit.googleapis.com/v2";
    }

    public static String zzd(String str) {
        zzaeb zzaebVar;
        String str2;
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            zzaebVar = map.get(str);
        }
        if (zzaebVar != null) {
            str2 = "" + zza(zzaebVar.zzb(), zzaebVar.zza(), zzaebVar.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "securetoken.googleapis.com/v1";
    }
}
