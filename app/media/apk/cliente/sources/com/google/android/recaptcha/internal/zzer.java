package com.google.android.recaptcha.internal;

import kotlin.coroutines.jvm.internal.d;
import s3.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzer extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzez zzb;
    int zzc;
    zzez zzd;
    String zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzer(zzez zzezVar, v3.d dVar) {
        super(dVar);
        this.zzb = zzezVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zza = this.zzb.zza(null, 0L, this);
        c5 = w3.d.c();
        return zza == c5 ? zza : m.a(zza);
    }
}
