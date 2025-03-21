package com.google.android.recaptcha.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjw implements zzks {
    private static final zzkc zza = new zzju();
    private final zzkc zzb;

    public zzjw() {
        zzkc zzkcVar;
        zzkc[] zzkcVarArr = new zzkc[2];
        zzkcVarArr[0] = zzim.zza();
        try {
            zzkcVar = (zzkc) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzkcVar = zza;
        }
        zzkcVarArr[1] = zzkcVar;
        zzjv zzjvVar = new zzjv(zzkcVarArr);
        byte[] bArr = zzjc.zzd;
        this.zzb = zzjvVar;
    }

    private static boolean zzb(zzkb zzkbVar) {
        return zzkbVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.recaptcha.internal.zzks
    public final zzkr zza(Class cls) {
        zzkk zza2;
        zzjs zzd;
        zzll zzm;
        zzif zza3;
        zzjz zza4;
        zzll zzm2;
        zzif zza5;
        zzkt.zzs(cls);
        zzkb zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzit.class.isAssignableFrom(cls)) {
                zzm2 = zzkt.zzn();
                zza5 = zzih.zzb();
            } else {
                zzm2 = zzkt.zzm();
                zza5 = zzih.zza();
            }
            return zzki.zzc(zzm2, zza5, zzb.zza());
        }
        if (zzit.class.isAssignableFrom(cls)) {
            boolean zzb2 = zzb(zzb);
            zza2 = zzkl.zzb();
            zzd = zzjs.zze();
            zzm = zzkt.zzn();
            zza3 = zzb2 ? zzih.zzb() : null;
            zza4 = zzka.zzb();
        } else {
            boolean zzb3 = zzb(zzb);
            zza2 = zzkl.zza();
            zzd = zzjs.zzd();
            zzm = zzkt.zzm();
            zza3 = zzb3 ? zzih.zza() : null;
            zza4 = zzka.zza();
        }
        return zzkh.zzm(cls, zzb, zza2, zzd, zzm, zza3, zza4);
    }
}
