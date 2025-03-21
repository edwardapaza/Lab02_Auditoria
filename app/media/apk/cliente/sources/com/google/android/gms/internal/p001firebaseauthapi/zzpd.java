package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpd  reason: invalid package */
/* loaded from: classes.dex */
public final class zzpd {
    private final Class<?> zza;
    private final Class<? extends zzow> zzb;

    private zzpd(Class<?> cls, Class<? extends zzow> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzpd) {
            zzpd zzpdVar = (zzpd) obj;
            return zzpdVar.zza.equals(this.zza) && zzpdVar.zzb.equals(this.zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String simpleName2 = this.zzb.getSimpleName();
        return simpleName + " with serialization type: " + simpleName2;
    }
}
