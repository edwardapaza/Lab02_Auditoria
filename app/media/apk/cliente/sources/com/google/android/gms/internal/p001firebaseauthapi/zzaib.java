package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaib  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzaib {
    private static volatile int zze = 100;
    int zza;
    int zzb;
    int zzc;
    zzaig zzd;
    private boolean zzf;

    private zzaib() {
        this.zzb = zze;
        this.zzc = a.e.API_PRIORITY_OTHER;
        this.zzf = false;
    }

    public static long zza(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzaib zza(byte[] bArr, int i5, int i6, boolean z4) {
        zzaia zzaiaVar = new zzaia(bArr, i5, i6, z4);
        try {
            zzaiaVar.zza(i6);
            return zzaiaVar;
        } catch (zzajj e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public static int zze(int i5) {
        return (-(i5 & 1)) ^ (i5 >>> 1);
    }

    public abstract double zza();

    public abstract int zza(int i5);

    public abstract float zzb();

    public abstract void zzb(int i5);

    public abstract int zzc();

    public abstract void zzc(int i5);

    public abstract int zzd();

    public abstract boolean zzd(int i5);

    public abstract int zze();

    public abstract int zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract int zzi();

    public abstract int zzj();

    public abstract long zzk();

    public abstract long zzl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long zzm();

    public abstract long zzn();

    public abstract long zzo();

    public abstract long zzp();

    public abstract zzahm zzq();

    public abstract String zzr();

    public abstract String zzs();

    public abstract boolean zzt();

    public abstract boolean zzu();
}
