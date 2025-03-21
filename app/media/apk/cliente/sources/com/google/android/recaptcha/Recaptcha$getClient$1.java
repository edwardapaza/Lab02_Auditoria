package com.google.android.recaptcha;

import kotlin.coroutines.jvm.internal.d;
import s3.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Recaptcha$getClient$1 extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ Recaptcha zzb;
    int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$1(Recaptcha recaptcha, v3.d dVar) {
        super(dVar);
        this.zzb = recaptcha;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object m1getClientBWLJW6A = this.zzb.m1getClientBWLJW6A(null, null, 0L, this);
        c5 = w3.d.c();
        return m1getClientBWLJW6A == c5 ? m1getClientBWLJW6A : m.a(m1getClientBWLJW6A);
    }
}
