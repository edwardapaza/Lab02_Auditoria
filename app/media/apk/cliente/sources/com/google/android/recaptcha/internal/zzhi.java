package com.google.android.recaptcha.internal;

import java.util.List;
/* loaded from: classes.dex */
final class zzhi implements zzmd {
    private final zzhh zza;

    private zzhi(zzhh zzhhVar) {
        byte[] bArr = zzjc.zzd;
        this.zza = zzhhVar;
        zzhhVar.zza = this;
    }

    public static zzhi zza(zzhh zzhhVar) {
        zzhi zzhiVar = zzhhVar.zza;
        return zzhiVar != null ? zzhiVar : new zzhi(zzhhVar);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzA(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzh(i5, ((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Long) list.get(i8)).longValue();
            i7 += 8;
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzi(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzB(int i5, int i6) {
        this.zza.zzp(i5, (i6 >> 31) ^ (i6 + i6));
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzC(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                zzhh zzhhVar = this.zza;
                int intValue = ((Integer) list.get(i6)).intValue();
                zzhhVar.zzp(i5, (intValue >> 31) ^ (intValue + intValue));
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            int intValue2 = ((Integer) list.get(i8)).intValue();
            i7 += zzhh.zzy((intValue2 >> 31) ^ (intValue2 + intValue2));
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            zzhh zzhhVar2 = this.zza;
            int intValue3 = ((Integer) list.get(i6)).intValue();
            zzhhVar2.zzq((intValue3 >> 31) ^ (intValue3 + intValue3));
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzD(int i5, long j5) {
        this.zza.zzr(i5, (j5 >> 63) ^ (j5 + j5));
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzE(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                zzhh zzhhVar = this.zza;
                long longValue = ((Long) list.get(i6)).longValue();
                zzhhVar.zzr(i5, (longValue >> 63) ^ (longValue + longValue));
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            long longValue2 = ((Long) list.get(i8)).longValue();
            i7 += zzhh.zzz((longValue2 >> 63) ^ (longValue2 + longValue2));
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            zzhh zzhhVar2 = this.zza;
            long longValue3 = ((Long) list.get(i6)).longValue();
            zzhhVar2.zzs((longValue3 >> 63) ^ (longValue3 + longValue3));
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    @Deprecated
    public final void zzF(int i5) {
        this.zza.zzo(i5, 3);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzG(int i5, String str) {
        this.zza.zzm(i5, str);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzH(int i5, List list) {
        int i6 = 0;
        if (!(list instanceof zzjm)) {
            while (i6 < list.size()) {
                this.zza.zzm(i5, (String) list.get(i6));
                i6++;
            }
            return;
        }
        zzjm zzjmVar = (zzjm) list;
        while (i6 < list.size()) {
            Object zzf = zzjmVar.zzf(i6);
            if (zzf instanceof String) {
                this.zza.zzm(i5, (String) zzf);
            } else {
                this.zza.zze(i5, (zzgw) zzf);
            }
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzI(int i5, int i6) {
        this.zza.zzp(i5, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzJ(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzp(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzhh.zzy(((Integer) list.get(i8)).intValue());
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzq(((Integer) list.get(i6)).intValue());
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzK(int i5, long j5) {
        this.zza.zzr(i5, j5);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzL(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzr(i5, ((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzhh.zzz(((Long) list.get(i8)).longValue());
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzs(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzb(int i5, boolean z4) {
        this.zza.zzd(i5, z4);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzc(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzd(i5, ((Boolean) list.get(i6)).booleanValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Boolean) list.get(i8)).booleanValue();
            i7++;
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzb(((Boolean) list.get(i6)).booleanValue() ? (byte) 1 : (byte) 0);
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzd(int i5, zzgw zzgwVar) {
        this.zza.zze(i5, zzgwVar);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zze(int i5, List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.zza.zze(i5, (zzgw) list.get(i6));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzf(int i5, double d5) {
        this.zza.zzh(i5, Double.doubleToRawLongBits(d5));
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzg(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzh(i5, Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Double) list.get(i8)).doubleValue();
            i7 += 8;
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    @Deprecated
    public final void zzh(int i5) {
        this.zza.zzo(i5, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzi(int i5, int i6) {
        this.zza.zzj(i5, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzj(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzj(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzhh.zzu(((Integer) list.get(i8)).intValue());
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzk(((Integer) list.get(i6)).intValue());
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzk(int i5, int i6) {
        this.zza.zzf(i5, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzl(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzf(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Integer) list.get(i8)).intValue();
            i7 += 4;
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzg(((Integer) list.get(i6)).intValue());
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzm(int i5, long j5) {
        this.zza.zzh(i5, j5);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzn(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzh(i5, ((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Long) list.get(i8)).longValue();
            i7 += 8;
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzi(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzo(int i5, float f5) {
        this.zza.zzf(i5, Float.floatToRawIntBits(f5));
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzp(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzf(i5, Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Float) list.get(i8)).floatValue();
            i7 += 4;
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzq(int i5, Object obj, zzkr zzkrVar) {
        zzhh zzhhVar = this.zza;
        zzhhVar.zzo(i5, 3);
        zzkrVar.zzj((zzke) obj, zzhhVar.zza);
        zzhhVar.zzo(i5, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzr(int i5, int i6) {
        this.zza.zzj(i5, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzs(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzj(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzhh.zzu(((Integer) list.get(i8)).intValue());
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzk(((Integer) list.get(i6)).intValue());
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzt(int i5, long j5) {
        this.zza.zzr(i5, j5);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzu(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzr(i5, ((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += zzhh.zzz(((Long) list.get(i8)).longValue());
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzs(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzv(int i5, Object obj, zzkr zzkrVar) {
        zzke zzkeVar = (zzke) obj;
        zzhe zzheVar = (zzhe) this.zza;
        zzheVar.zzq((i5 << 3) | 2);
        zzheVar.zzq(((zzgf) zzkeVar).zza(zzkrVar));
        zzkrVar.zzj(zzkeVar, zzheVar.zza);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzw(int i5, Object obj) {
        if (obj instanceof zzgw) {
            zzhe zzheVar = (zzhe) this.zza;
            zzheVar.zzq(11);
            zzheVar.zzp(2, i5);
            zzheVar.zze(3, (zzgw) obj);
            zzheVar.zzq(12);
            return;
        }
        zzhh zzhhVar = this.zza;
        zzke zzkeVar = (zzke) obj;
        zzhe zzheVar2 = (zzhe) zzhhVar;
        zzheVar2.zzq(11);
        zzheVar2.zzp(2, i5);
        zzheVar2.zzq(26);
        zzheVar2.zzq(zzkeVar.zzn());
        zzkeVar.zze(zzhhVar);
        zzheVar2.zzq(12);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzx(int i5, int i6) {
        this.zza.zzf(i5, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzy(int i5, List list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.zza.zzf(i5, ((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        this.zza.zzo(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Integer) list.get(i8)).intValue();
            i7 += 4;
        }
        this.zza.zzq(i7);
        while (i6 < list.size()) {
            this.zza.zzg(((Integer) list.get(i6)).intValue());
            i6++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzmd
    public final void zzz(int i5, long j5) {
        this.zza.zzh(i5, j5);
    }
}
