package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.reflect.Type;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaco  reason: invalid package */
/* loaded from: classes.dex */
public class zzaco {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzaco";

    private zzaco() {
    }

    public static Object zza(String str, Type type) {
        if (type == String.class) {
            try {
                zzaek zzaekVar = (zzaek) new zzaek().zza(str);
                if (zzaekVar.zzb()) {
                    return zzaekVar.zza();
                }
                throw new zzaah("No error message: " + str);
            } catch (Exception e5) {
                String message = e5.getMessage();
                throw new zzaah("Json conversion failed! " + message, e5);
            }
        } else if (type == Void.class) {
            return null;
        } else {
            try {
                try {
                    return ((zzacq) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0])).zza(str);
                } catch (Exception e6) {
                    String message2 = e6.getMessage();
                    throw new zzaah("Json conversion failed! " + message2, e6);
                }
            } catch (Exception e7) {
                String valueOf = String.valueOf(type);
                throw new zzaah("Instantiation of JsonResponse failed! " + valueOf, e7);
            }
        }
    }
}
