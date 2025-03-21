package com.google.android.recaptcha.internal;

import d4.p;
import java.util.Map;
import kotlin.coroutines.jvm.internal.l;
import m4.i;
import m4.j0;
import m4.u;
import m4.w;
import s3.n;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzet extends l implements p {
    int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzez zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzet(String str, zzez zzezVar, d dVar) {
        super(2, dVar);
        this.zzb = str;
        this.zzc = zzezVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzet(this.zzb, this.zzc, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzet) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        Map map;
        zzt zztVar;
        c5 = w3.d.c();
        int i5 = this.zza;
        n.b(obj);
        if (i5 == 0) {
            zzez zzezVar = this.zzc;
            String str = this.zzb;
            u b5 = w.b(null, 1, null);
            map = zzezVar.zzl;
            map.put(str, b5);
            String str2 = this.zzb;
            zzou zzf = zzov.zzf();
            zzf.zzd(str2);
            byte[] zzd = ((zzov) zzf.zzj()).zzd();
            String zzi = zzfy.zzh().zzi(zzd, 0, zzd.length);
            zztVar = this.zzc.zzq;
            i.d(zztVar.zzb(), null, null, new zzes(this.zzc, zzi, null), 3, null);
            this.zza = 1;
            obj = b5.n(this);
            if (obj == c5) {
                return c5;
            }
        }
        return obj;
    }
}
