package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakd  reason: invalid package */
/* loaded from: classes.dex */
final class zzakd implements zzakl {
    private zzakl[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakd(zzakl... zzaklVarArr) {
        this.zza = zzaklVarArr;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakl
    public final zzaki zza(Class<?> cls) {
        zzakl[] zzaklVarArr;
        for (zzakl zzaklVar : this.zza) {
            if (zzaklVar.zzb(cls)) {
                return zzaklVar.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakl
    public final boolean zzb(Class<?> cls) {
        for (zzakl zzaklVar : this.zza) {
            if (zzaklVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
