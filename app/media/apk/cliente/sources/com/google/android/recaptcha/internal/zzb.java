package com.google.android.recaptcha.internal;

import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.m;
import s3.n;
import s3.t;
import v3.d;
/* loaded from: classes.dex */
final class zzb extends l implements p {
    int zza;
    final /* synthetic */ zza zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(zza zzaVar, String str, long j5, d dVar) {
        super(2, dVar);
        this.zzb = zzaVar;
        this.zzc = str;
        this.zzd = j5;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzb(this.zzb, this.zzc, this.zzd, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzb) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        Object zza;
        c5 = w3.d.c();
        int i5 = this.zza;
        n.b(obj);
        if (i5 != 0) {
            zza = ((m) obj).i();
        } else {
            zza zzaVar = this.zzb;
            String str = this.zzc;
            long j5 = this.zzd;
            this.zza = 1;
            zza = zzaVar.zza(str, j5, this);
            if (zza == c5) {
                return c5;
            }
        }
        return m.a(zza);
    }
}
