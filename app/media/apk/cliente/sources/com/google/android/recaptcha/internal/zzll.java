package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
abstract class zzll {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzb(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zzc(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zzd(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zze(Object obj, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract void zzh(Object obj, int i5, int i6);

    abstract void zzi(Object obj, int i5, long j5);

    abstract void zzj(Object obj, int i5, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzk(Object obj, int i5, zzgw zzgwVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzl(Object obj, int i5, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzm(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzn(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzo(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzp(Object obj, zzmd zzmdVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzq(Object obj, zzmd zzmdVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzr(Object obj, zzkq zzkqVar) {
        int zzd = zzkqVar.zzd();
        int i5 = zzd >>> 3;
        int i6 = zzd & 7;
        if (i6 == 0) {
            zzl(obj, i5, zzkqVar.zzl());
            return true;
        } else if (i6 == 1) {
            zzi(obj, i5, zzkqVar.zzk());
            return true;
        } else if (i6 == 2) {
            zzk(obj, i5, zzkqVar.zzp());
            return true;
        } else if (i6 != 3) {
            if (i6 != 4) {
                if (i6 == 5) {
                    zzh(obj, i5, zzkqVar.zzf());
                    return true;
                }
                throw zzje.zza();
            }
            return false;
        } else {
            Object zzf = zzf();
            int i7 = i5 << 3;
            while (zzkqVar.zzc() != Integer.MAX_VALUE && zzr(zzf, zzkqVar)) {
            }
            if ((4 | i7) == zzkqVar.zzd()) {
                zzg(zzf);
                zzj(obj, i5, zzf);
                return true;
            }
            throw zzje.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzs(zzkq zzkqVar);
}
