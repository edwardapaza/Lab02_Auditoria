package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.m;
import s3.n;
import s3.t;
import v3.d;
/* loaded from: classes.dex */
final class zzau extends l implements p {
    int zza;
    final /* synthetic */ zzaw zzb;
    final /* synthetic */ RecaptchaAction zzc;
    final /* synthetic */ long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzau(zzaw zzawVar, RecaptchaAction recaptchaAction, long j5, d dVar) {
        super(2, dVar);
        this.zzb = zzawVar;
        this.zzc = recaptchaAction;
        this.zzd = j5;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzau(this.zzb, this.zzc, this.zzd, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzau) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        Object zzk;
        c5 = w3.d.c();
        int i5 = this.zza;
        n.b(obj);
        if (i5 != 0) {
            zzk = ((m) obj).i();
        } else {
            zzaw zzawVar = this.zzb;
            RecaptchaAction recaptchaAction = this.zzc;
            long j5 = this.zzd;
            this.zza = 1;
            zzk = zzawVar.zzk(recaptchaAction, j5, this);
            if (zzk == c5) {
                return c5;
            }
        }
        n.b(zzk);
        return zzk;
    }
}
