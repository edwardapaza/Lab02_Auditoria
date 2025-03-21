package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public abstract class zzhc {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzhd zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhc(zzhb zzhbVar) {
    }

    public static int zzF(int i5) {
        return (i5 >>> 1) ^ (-(i5 & 1));
    }

    public static long zzG(long j5) {
        return (j5 >>> 1) ^ (-(1 & j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhc zzH(byte[] bArr, int i5, int i6, boolean z4) {
        zzgy zzgyVar = new zzgy(bArr, 0, 0, false, null);
        try {
            zzgyVar.zze(0);
            return zzgyVar;
        } catch (zzje e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public abstract void zzA(int i5);

    public abstract boolean zzC();

    public abstract boolean zzD();

    public abstract boolean zzE(int i5);

    public abstract double zzb();

    public abstract float zzc();

    public abstract int zzd();

    public abstract int zze(int i5);

    public abstract int zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract int zzk();

    public abstract int zzl();

    public abstract int zzm();

    public abstract int zzn();

    public abstract long zzo();

    public abstract long zzp();

    public abstract long zzt();

    public abstract long zzu();

    public abstract long zzv();

    public abstract zzgw zzw();

    public abstract String zzx();

    public abstract String zzy();

    public abstract void zzz(int i5);
}
