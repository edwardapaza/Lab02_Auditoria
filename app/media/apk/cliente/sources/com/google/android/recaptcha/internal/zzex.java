package com.google.android.recaptcha.internal;

import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.n;
import s3.t;
import v3.d;
/* loaded from: classes.dex */
final class zzex extends l implements p {
    final /* synthetic */ zzez zza;
    final /* synthetic */ String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzex(zzez zzezVar, String str, d dVar) {
        super(2, dVar);
        this.zza = zzezVar;
        this.zzb = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzex(this.zza, this.zzb, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzex) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        w3.d.c();
        n.b(obj);
        zzez.zzm(this.zza, this.zzb);
        return t.f7573a;
    }
}
