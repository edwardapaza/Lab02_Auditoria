package com.google.android.recaptcha.internal;

import i2.a0;
import i2.d0;
import java.util.Map;
/* loaded from: classes.dex */
final class zzig extends zzif {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final int zza(Map.Entry entry) {
        return ((zziq) entry.getKey()).zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final zzij zzb(Object obj) {
        return ((zzip) obj).zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final zzij zzc(Object obj) {
        return ((zzip) obj).zzi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final Object zzd(zzie zzieVar, zzke zzkeVar, int i5) {
        return zzieVar.zza(zzkeVar, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final Object zze(Object obj, zzkq zzkqVar, Object obj2, zzie zzieVar, zzij zzijVar, Object obj3, zzll zzllVar) {
        Object zze;
        long zzl;
        int zzg;
        zzir zzirVar = (zzir) obj2;
        zzmb zzmbVar = zzirVar.zzb.zzb;
        zzke zzkeVar = null;
        if (zzmbVar == zzmb.zzn) {
            zzkqVar.zzg();
            throw null;
        }
        switch (zzmbVar.ordinal()) {
            case 0:
                zzkeVar = Double.valueOf(zzkqVar.zza());
                break;
            case 1:
                zzkeVar = Float.valueOf(zzkqVar.zzb());
                break;
            case 2:
                zzl = zzkqVar.zzl();
                zzkeVar = Long.valueOf(zzl);
                break;
            case 3:
                zzl = zzkqVar.zzo();
                zzkeVar = Long.valueOf(zzl);
                break;
            case 4:
                zzg = zzkqVar.zzg();
                zzkeVar = Integer.valueOf(zzg);
                break;
            case 5:
                zzl = zzkqVar.zzk();
                zzkeVar = Long.valueOf(zzl);
                break;
            case 6:
                zzg = zzkqVar.zzf();
                zzkeVar = Integer.valueOf(zzg);
                break;
            case 7:
                zzkeVar = Boolean.valueOf(zzkqVar.zzN());
                break;
            case 8:
                zzkeVar = zzkqVar.zzr();
                break;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                Object zze2 = zzijVar.zze(zzirVar.zzb);
                if (zze2 instanceof zzit) {
                    zzkr zzb = zzkn.zza().zzb(zze2.getClass());
                    if (!((zzit) zze2).zzG()) {
                        Object zze3 = zzb.zze();
                        zzb.zzg(zze3, zze2);
                        zzijVar.zzi(zzirVar.zzb, zze3);
                        zze2 = zze3;
                    }
                    zzkqVar.zzt(zze2, zzb, zzieVar);
                    return obj3;
                }
                throw null;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                Object zze4 = zzijVar.zze(zzirVar.zzb);
                if (zze4 instanceof zzit) {
                    zzkr zzb2 = zzkn.zza().zzb(zze4.getClass());
                    if (!((zzit) zze4).zzG()) {
                        Object zze5 = zzb2.zze();
                        zzb2.zzg(zze5, zze4);
                        zzijVar.zzi(zzirVar.zzb, zze5);
                        zze4 = zze5;
                    }
                    zzkqVar.zzu(zze4, zzb2, zzieVar);
                    return obj3;
                }
                throw null;
            case 11:
                zzkeVar = zzkqVar.zzp();
                break;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                zzg = zzkqVar.zzj();
                zzkeVar = Integer.valueOf(zzg);
                break;
            case 13:
                throw new IllegalStateException("Shouldn't reach here.");
            case 14:
                zzg = zzkqVar.zzh();
                zzkeVar = Integer.valueOf(zzg);
                break;
            case 15:
                zzl = zzkqVar.zzm();
                zzkeVar = Long.valueOf(zzl);
                break;
            case 16:
                zzg = zzkqVar.zzi();
                zzkeVar = Integer.valueOf(zzg);
                break;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                zzl = zzkqVar.zzn();
                zzkeVar = Long.valueOf(zzl);
                break;
        }
        int ordinal = zzirVar.zzb.zzb.ordinal();
        if ((ordinal == 9 || ordinal == 10) && (zze = zzijVar.zze(zzirVar.zzb)) != null) {
            byte[] bArr = zzjc.zzd;
            zzkeVar = ((zzke) zze).zzX().zzc((zzke) zzkeVar).zzk();
        }
        zzijVar.zzi(zzirVar.zzb, zzkeVar);
        return obj3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final void zzf(Object obj) {
        ((zzip) obj).zzb.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final void zzg(zzkq zzkqVar, Object obj, zzie zzieVar, zzij zzijVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final void zzh(zzgw zzgwVar, Object obj, zzie zzieVar, zzij zzijVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final void zzi(zzmd zzmdVar, Map.Entry entry) {
        zziq zziqVar = (zziq) entry.getKey();
        zzmb zzmbVar = zzmb.zza;
        switch (zziqVar.zzb.ordinal()) {
            case 0:
                zzmdVar.zzf(zziqVar.zza, ((Double) entry.getValue()).doubleValue());
                return;
            case 1:
                zzmdVar.zzo(zziqVar.zza, ((Float) entry.getValue()).floatValue());
                return;
            case 2:
                zzmdVar.zzt(zziqVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case 3:
                zzmdVar.zzK(zziqVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                zzmdVar.zzr(zziqVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 5:
                zzmdVar.zzm(zziqVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case 6:
                zzmdVar.zzk(zziqVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 7:
                zzmdVar.zzb(zziqVar.zza, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 8:
                zzmdVar.zzG(zziqVar.zza, (String) entry.getValue());
                return;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                zzmdVar.zzq(zziqVar.zza, entry.getValue(), zzkn.zza().zzb(entry.getValue().getClass()));
                return;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                zzmdVar.zzv(zziqVar.zza, entry.getValue(), zzkn.zza().zzb(entry.getValue().getClass()));
                return;
            case 11:
                zzmdVar.zzd(zziqVar.zza, (zzgw) entry.getValue());
                return;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                zzmdVar.zzI(zziqVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                zzmdVar.zzr(zziqVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 14:
                zzmdVar.zzx(zziqVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                zzmdVar.zzz(zziqVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case 16:
                zzmdVar.zzB(zziqVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                zzmdVar.zzD(zziqVar.zza, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzif
    public final boolean zzj(zzke zzkeVar) {
        return zzkeVar instanceof zzip;
    }
}
