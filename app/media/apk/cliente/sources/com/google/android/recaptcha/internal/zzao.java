package com.google.android.recaptcha.internal;

import kotlin.coroutines.jvm.internal.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzao extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaw zzb;
    int zzc;
    zzaw zzd;
    zzbb zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzao(zzaw zzawVar, v3.d dVar) {
        super(dVar);
        this.zzb = zzawVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object zzj;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        zzj = this.zzb.zzj(0L, null, null, this);
        return zzj;
    }
}
