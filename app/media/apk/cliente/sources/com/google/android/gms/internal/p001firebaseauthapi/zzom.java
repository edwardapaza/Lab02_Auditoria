package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzom  reason: invalid package */
/* loaded from: classes.dex */
public final class zzom {
    private final Class<?> zza;
    private final Class<?> zzb;

    private zzom(Class<?> cls, Class<?> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzom) {
            zzom zzomVar = (zzom) obj;
            return zzomVar.zza.equals(this.zza) && zzomVar.zzb.equals(this.zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String simpleName2 = this.zzb.getSimpleName();
        return simpleName + " with primitive type: " + simpleName2;
    }
}
