package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzpb {
    private final Class<? extends zzow> zza;
    private final zzxr zzb;

    private zzpb(Class<? extends zzow> cls, zzxr zzxrVar) {
        this.zza = cls;
        this.zzb = zzxrVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzpb) {
            zzpb zzpbVar = (zzpb) obj;
            return zzpbVar.zza.equals(this.zza) && zzpbVar.zzb.equals(this.zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(this.zzb);
        return simpleName + ", object identifier: " + valueOf;
    }
}
