package com.google.android.recaptcha.internal;

import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.t;
import v3.d;
/* loaded from: classes.dex */
final class zzbz extends l implements p {
    int zza;
    final /* synthetic */ zzcj zzb;
    final /* synthetic */ zzca zzc;
    final /* synthetic */ String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbz(zzcj zzcjVar, zzca zzcaVar, String str, d dVar) {
        super(2, dVar);
        this.zzb = zzcjVar;
        this.zzc = zzcaVar;
        this.zzd = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzbz(this.zzb, this.zzc, this.zzd, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbz) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (r5 == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
        if (r5 != r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = w3.b.c()
            int r1 = r4.zza
            r2 = 1
            if (r1 == 0) goto L15
            if (r1 == r2) goto Lf
            s3.n.b(r5)
            goto L58
        Lf:
            s3.n.b(r5)     // Catch: java.lang.Exception -> L13
            goto L58
        L13:
            r5 = move-exception
            goto L4a
        L15:
            s3.n.b(r5)
            com.google.android.recaptcha.internal.zzcj r5 = r4.zzb
            com.google.android.recaptcha.internal.zzz r1 = new com.google.android.recaptcha.internal.zzz
            r1.<init>()
            r5.zza = r1
            java.lang.String r5 = r4.zzd     // Catch: java.lang.Exception -> L13
            com.google.android.recaptcha.internal.zzfy r1 = com.google.android.recaptcha.internal.zzfy.zzh()     // Catch: java.lang.Exception -> L13
            byte[] r5 = r1.zzj(r5)     // Catch: java.lang.Exception -> L13
            com.google.android.recaptcha.internal.zzpn r5 = com.google.android.recaptcha.internal.zzpn.zzg(r5)     // Catch: java.lang.Exception -> L13
            com.google.android.recaptcha.internal.zzca r1 = r4.zzc     // Catch: java.lang.Exception -> L13
            com.google.android.recaptcha.internal.zzee r1 = com.google.android.recaptcha.internal.zzca.zzb(r1)     // Catch: java.lang.Exception -> L13
            com.google.android.recaptcha.internal.zzpf r5 = r1.zza(r5)     // Catch: java.lang.Exception -> L13
            com.google.android.recaptcha.internal.zzca r1 = r4.zzc     // Catch: java.lang.Exception -> L13
            java.util.List r5 = r5.zzi()     // Catch: java.lang.Exception -> L13
            com.google.android.recaptcha.internal.zzcj r3 = r4.zzb     // Catch: java.lang.Exception -> L13
            r4.zza = r2     // Catch: java.lang.Exception -> L13
            java.lang.Object r5 = com.google.android.recaptcha.internal.zzca.zzc(r1, r5, r3, r4)     // Catch: java.lang.Exception -> L13
            if (r5 != r0) goto L58
            goto L57
        L4a:
            com.google.android.recaptcha.internal.zzca r1 = r4.zzc
            com.google.android.recaptcha.internal.zzcj r2 = r4.zzb
            r3 = 2
            r4.zza = r3
            java.lang.Object r5 = com.google.android.recaptcha.internal.zzca.zzd(r1, r5, r2, r4)
            if (r5 != r0) goto L58
        L57:
            return r0
        L58:
            s3.t r5 = s3.t.f7573a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbz.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
