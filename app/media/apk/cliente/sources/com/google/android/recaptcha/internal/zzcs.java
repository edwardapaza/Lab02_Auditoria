package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzcs implements zzdd {
    public static final zzcs zza = new zzcs();

    private zzcs() {
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
        boolean z4 = true;
        if (zzpqVarArr.length != 1) {
            throw new zzae(4, 3, null);
        }
        Object zza2 = zzcjVar.zzc().zza(zzpqVarArr[0]);
        if (true != (zza2 instanceof Object)) {
            zza2 = null;
        }
        if (zza2 == null) {
            throw new zzae(4, 5, null);
        }
        try {
            try {
                if (zza2 instanceof String) {
                    zza2 = zzcjVar.zzh().zza((String) zza2);
                }
                zzck zzc = zzcjVar.zzc();
                try {
                    zzci.zza(zza2);
                } catch (zzae e5) {
                    if (e5.zzb() != 8 && e5.zzb() != 6) {
                        if (e5.zzb() != 47) {
                            throw e5;
                        }
                    }
                    z4 = false;
                }
                zzc.zzf(i5, Boolean.valueOf(z4));
            } catch (zzae e6) {
                throw e6;
            }
        } catch (Exception e7) {
            throw new zzae(6, 8, e7);
        }
    }
}
