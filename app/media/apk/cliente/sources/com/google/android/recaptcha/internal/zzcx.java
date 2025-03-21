package com.google.android.recaptcha.internal;

import d4.p;
import e4.l;
import s3.t;
/* loaded from: classes.dex */
final class zzcx extends l implements p {
    final /* synthetic */ zzcj zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcx(zzcj zzcjVar, String str, int i5) {
        super(2);
        this.zza = zzcjVar;
        this.zzb = str;
        this.zzc = i5;
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        this.zza.zzi().zzb(this.zzb, (String) obj2);
        int i5 = this.zzc;
        if (i5 != -1) {
            this.zza.zzc().zzf(i5, objArr);
        }
        return t.f7573a;
    }
}
