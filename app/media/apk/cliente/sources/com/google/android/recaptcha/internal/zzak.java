package com.google.android.recaptcha.internal;

import android.app.Application;
import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.n;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzak extends l implements p {
    int zza;
    final /* synthetic */ Application zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzak(Application application, String str, long j5, d dVar) {
        super(2, dVar);
        this.zzb = application;
        this.zzc = str;
        this.zzd = j5;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzak(this.zzb, this.zzc, this.zzd, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzak) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        c5 = w3.d.c();
        int i5 = this.zza;
        n.b(obj);
        if (i5 == 0) {
            zzam zzamVar = zzam.zza;
            Application application = this.zzb;
            String str = this.zzc;
            long j5 = this.zzd;
            this.zza = 1;
            obj = zzam.zzc(application, str, j5, null, this);
            if (obj == c5) {
                return c5;
            }
        }
        return obj;
    }
}
