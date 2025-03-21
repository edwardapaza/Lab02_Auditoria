package com.google.android.recaptcha.internal;

import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.i;
import m4.j0;
import s3.n;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzey extends l implements p {
    final /* synthetic */ zzez zza;
    final /* synthetic */ zzoe zzb;
    final /* synthetic */ zzbb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzey(zzez zzezVar, zzoe zzoeVar, zzbb zzbbVar, d dVar) {
        super(2, dVar);
        this.zza = zzezVar;
        this.zzb = zzoeVar;
        this.zzc = zzbbVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzey(this.zza, this.zzb, this.zzc, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzey) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        zzbg zzbgVar;
        zzbd zzbdVar;
        zzt zztVar;
        w3.d.c();
        n.b(obj);
        try {
            zzez zzezVar = this.zza;
            zzbq zzf = zzezVar.zzf();
            zzoe zzoeVar = this.zzb;
            zzbdVar = zzezVar.zzp;
            String zzb = zzf.zzb(zzoeVar, zzbdVar);
            zztVar = this.zza.zzq;
            i.d(zztVar.zzb(), null, null, new zzex(this.zza, zzb, null), 3, null);
        } catch (zzp e5) {
            zzez zzezVar2 = this.zza;
            zzbb zzbbVar = this.zzc;
            zzbgVar = zzezVar2.zzi;
            zzbgVar.zzb(zzbbVar, e5, null);
            this.zza.zzk().z(e5);
        }
        return t.f7573a;
    }
}
