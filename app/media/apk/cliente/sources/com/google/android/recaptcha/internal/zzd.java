package com.google.android.recaptcha.internal;

import kotlin.coroutines.jvm.internal.d;
import s3.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzd extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzg zzb;
    int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzd(zzg zzgVar, v3.d dVar) {
        super(dVar);
        this.zzb = zzgVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzb = this.zzb.zzb(0L, null, this);
        c5 = w3.d.c();
        return zzb == c5 ? zzb : m.a(zzb);
    }
}
