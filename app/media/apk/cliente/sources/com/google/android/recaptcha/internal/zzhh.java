package com.google.android.recaptcha.internal;

import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class zzhh extends zzgm {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzhh.class.getName());
    private static final boolean zzd = zzlv.zzx();
    zzhi zza;

    private zzhh() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhh(zzhg zzhgVar) {
    }

    public static zzhh zzA(byte[] bArr, int i5, int i6) {
        return new zzhe(bArr, 0, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzt(int i5, zzke zzkeVar, zzkr zzkrVar) {
        int zza = ((zzgf) zzkeVar).zza(zzkrVar);
        int zzy = zzy(i5 << 3);
        return zzy + zzy + zza;
    }

    public static int zzu(int i5) {
        if (i5 >= 0) {
            return zzy(i5);
        }
        return 10;
    }

    public static int zzv(zzke zzkeVar) {
        int zzn = zzkeVar.zzn();
        return zzy(zzn) + zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(zzke zzkeVar, zzkr zzkrVar) {
        int zza = ((zzgf) zzkeVar).zza(zzkrVar);
        return zzy(zza) + zza;
    }

    public static int zzx(String str) {
        int length;
        try {
            length = zzma.zzc(str);
        } catch (zzlz unused) {
            length = str.getBytes(zzjc.zzb).length;
        }
        return zzy(length) + length;
    }

    public static int zzy(int i5) {
        if ((i5 & (-128)) == 0) {
            return 1;
        }
        if ((i5 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i5) == 0) {
            return 3;
        }
        return (i5 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzz(long j5) {
        int i5;
        if (((-128) & j5) == 0) {
            return 1;
        }
        if (j5 < 0) {
            return 10;
        }
        if (((-34359738368L) & j5) != 0) {
            i5 = 6;
            j5 >>>= 28;
        } else {
            i5 = 2;
        }
        if (((-2097152) & j5) != 0) {
            j5 >>>= 14;
            i5 += 2;
        }
        return (j5 & (-16384)) != 0 ? i5 + 1 : i5;
    }

    public final void zzB() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzC(String str, zzlz zzlzVar) {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzlzVar);
        byte[] bytes = str.getBytes(zzjc.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzhf(e5);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b5);

    public abstract void zzd(int i5, boolean z4);

    public abstract void zze(int i5, zzgw zzgwVar);

    public abstract void zzf(int i5, int i6);

    public abstract void zzg(int i5);

    public abstract void zzh(int i5, long j5);

    public abstract void zzi(long j5);

    public abstract void zzj(int i5, int i6);

    public abstract void zzk(int i5);

    public abstract void zzl(byte[] bArr, int i5, int i6);

    public abstract void zzm(int i5, String str);

    public abstract void zzo(int i5, int i6);

    public abstract void zzp(int i5, int i6);

    public abstract void zzq(int i5);

    public abstract void zzr(int i5, long j5);

    public abstract void zzs(long j5);
}
