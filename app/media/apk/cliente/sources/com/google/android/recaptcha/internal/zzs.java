package com.google.android.recaptcha.internal;

import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.n;
import s3.t;
import v3.d;
/* loaded from: classes.dex */
final class zzs extends l implements p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(d dVar) {
        super(2, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzs(dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        j0 j0Var = (j0) obj;
        return new zzs((d) obj2).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        w3.d.c();
        n.b(obj);
        Thread.currentThread().setPriority(8);
        return t.f7573a;
    }
}
