package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcg  reason: invalid package */
/* loaded from: classes.dex */
public final class zzcg {
    private static final CopyOnWriteArrayList<zzcd> zza = new CopyOnWriteArrayList<>();

    @Deprecated
    public static zzcd zza(String str) {
        Iterator<zzcd> it = zza.iterator();
        while (it.hasNext()) {
            zzcd next = it.next();
            if (next.zzb(str)) {
                return next;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
