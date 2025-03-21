package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzro  reason: invalid package */
/* loaded from: classes.dex */
public final class zzro {
    private HashMap<String, String> zza = new HashMap<>();

    public final zzrl zza() {
        if (this.zza != null) {
            zzrl zzrlVar = new zzrl(Collections.unmodifiableMap(this.zza));
            this.zza = null;
            return zzrlVar;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
