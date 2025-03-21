package com.google.android.recaptcha.internal;

import android.app.Application;
import android.webkit.WebView;
import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaj extends l implements p {
    Object zza;
    int zzb;
    final /* synthetic */ Application zzc;
    final /* synthetic */ zzab zzd;
    final /* synthetic */ String zze;
    final /* synthetic */ zzbq zzf;
    final /* synthetic */ zzbd zzg;
    final /* synthetic */ zzbg zzh;
    final /* synthetic */ long zzi;
    final /* synthetic */ zzt zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaj(Application application, zzab zzabVar, String str, zzbq zzbqVar, zzbd zzbdVar, zzt zztVar, WebView webView, zzbg zzbgVar, long j5, d dVar) {
        super(2, dVar);
        this.zzc = application;
        this.zzd = zzabVar;
        this.zze = str;
        this.zzf = zzbqVar;
        this.zzg = zzbdVar;
        this.zzj = zztVar;
        this.zzh = zzbgVar;
        this.zzi = j5;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzaj(this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzj, null, this.zzh, this.zzi, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzaj) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0058, code lost:
        if (r2 != r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x008e, code lost:
        if (r3 != r1) goto L6;
     */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaj.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
