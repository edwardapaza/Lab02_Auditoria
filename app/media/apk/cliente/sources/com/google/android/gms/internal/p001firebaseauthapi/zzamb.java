package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamb  reason: invalid package */
/* loaded from: classes.dex */
abstract class zzamb<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(T t5);

    abstract B zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zza(T t5, T t6);

    abstract void zza(B b5, int i5, int i6);

    abstract void zza(B b5, int i5, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b5, int i5, zzahm zzahmVar);

    abstract void zza(B b5, int i5, T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(T t5, zzanb zzanbVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zza(zzald zzaldVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(B b5, zzald zzaldVar) {
        int zzd = zzaldVar.zzd();
        int i5 = zzd >>> 3;
        int i6 = zzd & 7;
        if (i6 == 0) {
            zzb(b5, i5, zzaldVar.zzl());
            return true;
        } else if (i6 == 1) {
            zza((zzamb<T, B>) b5, i5, zzaldVar.zzk());
            return true;
        } else if (i6 == 2) {
            zza((zzamb<T, B>) b5, i5, zzaldVar.zzp());
            return true;
        } else if (i6 != 3) {
            if (i6 != 4) {
                if (i6 == 5) {
                    zza((zzamb<T, B>) b5, i5, zzaldVar.zzf());
                    return true;
                }
                throw zzajj.zza();
            }
            return false;
        } else {
            B zza = zza();
            int i7 = 4 | (i5 << 3);
            while (zzaldVar.zzc() != Integer.MAX_VALUE && zza((zzamb<T, B>) zza, zzaldVar)) {
            }
            if (i7 == zzaldVar.zzd()) {
                zza((zzamb<T, B>) b5, i5, (int) zze(zza));
                return true;
            }
            throw zzajj.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzb(T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(B b5, int i5, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(T t5, zzanb zzanbVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, B b5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzc(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(Object obj, T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzd(Object obj);

    abstract T zze(B b5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzf(Object obj);
}
