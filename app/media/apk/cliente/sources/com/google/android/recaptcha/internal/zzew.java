package com.google.android.recaptcha.internal;

import d4.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import m4.u;
import s3.m;
import s3.n;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzew extends l implements p {
    int zza;
    final /* synthetic */ zzez zzb;
    final /* synthetic */ zzoe zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzew(zzez zzezVar, zzoe zzoeVar, d dVar) {
        super(2, dVar);
        this.zzb = zzezVar;
        this.zzc = zzoeVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzew(this.zzb, this.zzc, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzew) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        zzbg zzbgVar;
        zzbd zzbdVar;
        zzfh zzfhVar;
        zzfh zzfhVar2;
        c5 = w3.d.c();
        int i5 = this.zza;
        n.b(obj);
        if (i5 == 0) {
            zzez zzezVar = this.zzb;
            zzbgVar = zzezVar.zzi;
            zzbdVar = zzezVar.zzp;
            zzbgVar.zza(zzbdVar.zza(zzne.INIT_NATIVE));
            zzcb.zza(zznz.zzj(zzfy.zzh().zzj(this.zzc.zzJ())));
            zzfhVar = this.zzb.zzn;
            zzfhVar.zzd();
            zzfhVar2 = this.zzb.zzn;
            zzfhVar2.zze();
            zzez.zzl(this.zzb, this.zzc);
            b.b(this.zzb.zzk().hashCode());
            u zzk = this.zzb.zzk();
            this.zza = 1;
            if (zzk.n(this) == c5) {
                return c5;
            }
        }
        return m.a(m.b(t.f7573a));
    }
}
