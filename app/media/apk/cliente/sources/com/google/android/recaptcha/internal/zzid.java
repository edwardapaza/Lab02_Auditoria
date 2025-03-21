package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzid {
    private final Object zza;
    private final int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzid(Object obj, int i5) {
        this.zza = obj;
        this.zzb = i5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzid) {
            zzid zzidVar = (zzid) obj;
            return this.zza == zzidVar.zza && this.zzb == zzidVar.zzb;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
