package com.google.android.recaptcha.internal;

import kotlin.coroutines.jvm.internal.d;
import s3.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzar extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaw zzb;
    int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzar(zzaw zzawVar, v3.d dVar) {
        super(dVar);
        this.zzb = zzawVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object mo3executegIAlus = this.zzb.mo3executegIAlus(null, this);
        c5 = w3.d.c();
        return mo3executegIAlus == c5 ? mo3executegIAlus : m.a(mo3executegIAlus);
    }
}
