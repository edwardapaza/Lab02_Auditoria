package com.google.android.recaptcha.internal;

import d4.p;
import java.util.Timer;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.n;
import s3.t;
import v3.d;
/* loaded from: classes.dex */
final class zzbk extends l implements p {
    final /* synthetic */ zzbm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbk(zzbm zzbmVar, d dVar) {
        super(2, dVar);
        this.zza = zzbmVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzbk(this.zza, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbk) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        zzaz zzazVar;
        Timer timer;
        w3.d.c();
        n.b(obj);
        zzbm zzbmVar = this.zza;
        synchronized (zzbh.class) {
            zzazVar = zzbmVar.zze;
            if (zzazVar != null && zzazVar.zzb() == 0) {
                timer = zzbm.zzb;
                if (timer != null) {
                    timer.cancel();
                }
                zzbm.zzb = null;
            }
            zzbmVar.zzg();
        }
        return t.f7573a;
    }
}
