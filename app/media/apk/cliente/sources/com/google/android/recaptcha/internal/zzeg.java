package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import s3.q;
import t3.x;
/* loaded from: classes.dex */
public final class zzeg implements zzee {
    private final zzef zza;
    private final zzed zzb;

    public zzeg(zzef zzefVar, zzed zzedVar) {
        this.zza = zzefVar;
        this.zzb = zzedVar;
    }

    private final zzpf zzb(String str, List list) {
        long[] I;
        zzea zzeaVar;
        if (str.length() != 0) {
            try {
                zzef zzefVar = this.zza;
                I = x.I(list);
                long zza = zzefVar.zza(I);
                zzeaVar = zzec.zzb;
                zzec zzecVar = new zzec(zza, 255L, zzeaVar);
                StringBuilder sb = new StringBuilder(str.length());
                for (int i5 = 0; i5 < str.length(); i5++) {
                    sb.append((char) q.a(q.a(str.charAt(i5)) ^ q.a((int) zzecVar.zza())));
                }
                return zzpf.zzg(zzfy.zzh().zzj(sb.toString()));
            } catch (Exception e5) {
                throw new zzae(3, 18, e5);
            }
        }
        throw new zzae(3, 17, null);
    }

    @Override // com.google.android.recaptcha.internal.zzee
    public final zzpf zza(zzpn zzpnVar) {
        zzfh zzb = zzfh.zzb();
        zzpf zzb2 = zzb(zzpnVar.zzi(), zzpnVar.zzj());
        zzb.zzf();
        long zza = zzb.zza(TimeUnit.MICROSECONDS);
        zzv zzvVar = zzv.zza;
        zzv.zza(zzx.zzm.zza(), zza);
        return zzb2;
    }
}
