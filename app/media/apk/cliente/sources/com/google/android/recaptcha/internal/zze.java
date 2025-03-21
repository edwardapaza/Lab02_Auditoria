package com.google.android.recaptcha.internal;

import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.m;
import s3.n;
import s3.t;
import v3.d;
/* loaded from: classes.dex */
final class zze extends l implements p {
    int zza;
    final /* synthetic */ zza zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzoe zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zze(zza zzaVar, long j5, zzoe zzoeVar, d dVar) {
        super(2, dVar);
        this.zzb = zzaVar;
        this.zzc = j5;
        this.zzd = zzoeVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zze(this.zzb, this.zzc, this.zzd, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zze) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        Object zzb;
        c5 = w3.d.c();
        int i5 = this.zza;
        n.b(obj);
        if (i5 != 0) {
            zzb = ((m) obj).i();
        } else {
            zza zzaVar = this.zzb;
            long j5 = this.zzc;
            zzoe zzoeVar = this.zzd;
            this.zza = 1;
            zzb = zzaVar.zzb(j5, zzoeVar, this);
            if (zzb == c5) {
                return c5;
            }
        }
        return m.a(zzb);
    }
}
