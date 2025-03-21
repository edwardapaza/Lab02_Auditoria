package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaio  reason: invalid package */
/* loaded from: classes.dex */
final class zzaio {
    private final Object zza;
    private final int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaio(Object obj, int i5) {
        this.zza = obj;
        this.zzb = i5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaio) {
            zzaio zzaioVar = (zzaio) obj;
            return this.zza == zzaioVar.zza && this.zzb == zzaioVar.zzb;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
