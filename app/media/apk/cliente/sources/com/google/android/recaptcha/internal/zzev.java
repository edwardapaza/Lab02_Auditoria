package com.google.android.recaptcha.internal;

import kotlin.coroutines.jvm.internal.d;
import s3.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzev extends d {
    long zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzez zzc;
    int zzd;
    zzez zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzev(zzez zzezVar, v3.d dVar) {
        super(dVar);
        this.zzc = zzezVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        Object zzb = this.zzc.zzb(0L, null, this);
        c5 = w3.d.c();
        return zzb == c5 ? zzb : m.a(zzb);
    }
}
