package com.google.android.recaptcha.internal;

import kotlin.coroutines.jvm.internal.d;
import s3.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzas extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaw zzb;
    int zzc;
    zzaw zzd;
    zzbd zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzas(zzaw zzawVar, v3.d dVar) {
        super(dVar);
        this.zzb = zzawVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object zzk;
        Object c5;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        zzk = this.zzb.zzk(null, 0L, this);
        c5 = w3.d.c();
        return zzk == c5 ? zzk : m.a(zzk);
    }
}
