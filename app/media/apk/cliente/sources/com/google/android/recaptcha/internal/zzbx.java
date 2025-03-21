package com.google.android.recaptcha.internal;

import d4.p;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import m4.k0;
import s3.n;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbx extends l implements p {
    int zza;
    final /* synthetic */ zzcj zzb;
    final /* synthetic */ List zzc;
    final /* synthetic */ zzca zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbx(zzcj zzcjVar, List list, zzca zzcaVar, d dVar) {
        super(2, dVar);
        this.zzb = zzcjVar;
        this.zzc = list;
        this.zzd = zzcaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        zzbx zzbxVar = new zzbx(this.zzb, this.zzc, this.zzd, dVar);
        zzbxVar.zze = obj;
        return zzbxVar;
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbx) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        Object zzh;
        c5 = w3.d.c();
        int i5 = this.zza;
        n.b(obj);
        if (i5 == 0) {
            j0 j0Var = (j0) this.zze;
            zzfh zzb = zzfh.zzb();
            while (true) {
                zzcj zzcjVar = this.zzb;
                if (zzcjVar.zza() < 0) {
                    break;
                }
                if (zzcjVar.zza() >= this.zzc.size() || !k0.d(j0Var)) {
                    break;
                }
                try {
                    this.zzd.zzi((zzpr) this.zzc.get(this.zzb.zza()), this.zzb);
                } catch (Exception e5) {
                    zzca zzcaVar = this.zzd;
                    zzcj zzcjVar2 = this.zzb;
                    this.zza = 1;
                    zzh = zzcaVar.zzh(e5, zzcjVar2, this);
                    if (zzh == c5) {
                        return c5;
                    }
                }
            }
            zzb.zzf();
            b.c(zzb.zza(TimeUnit.MICROSECONDS));
            return t.f7573a;
        }
        return t.f7573a;
    }
}
