package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import d4.p;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzat extends l implements p {
    int zza;
    final /* synthetic */ zzaw zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ RecaptchaAction zzd;
    final /* synthetic */ zzbd zze;
    final /* synthetic */ String zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzat(zzaw zzawVar, long j5, RecaptchaAction recaptchaAction, zzbd zzbdVar, String str, d dVar) {
        super(2, dVar);
        this.zzb = zzawVar;
        this.zzc = j5;
        this.zzd = recaptchaAction;
        this.zze = zzbdVar;
        this.zzf = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzat(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzat) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        r13 = (com.google.android.recaptcha.internal.zzol) r13;
        r12.zzb.zzl(r13, r12.zze);
        r0 = r12.zzb;
        r1 = r12.zze;
        r0 = r0.zzi;
        r0.zza(r1.zza(com.google.android.recaptcha.internal.zzne.EXECUTE_TOTAL));
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0063, code lost:
        return s3.m.a(s3.m.b(r13.zzi()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0064, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
        if (r1 != 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (r13 != r0) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
        if (r13 == r0) goto L6;
     */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = w3.b.c()
            int r1 = r12.zza
            r2 = 1
            s3.n.b(r13)
            if (r1 == 0) goto Lf
            if (r1 == r2) goto L2b
            goto L3d
        Lf:
            com.google.android.recaptcha.internal.zzaw r13 = r12.zzb
            long r3 = r12.zzc
            com.google.android.recaptcha.RecaptchaAction r1 = r12.zzd
            com.google.android.recaptcha.internal.zzbd r5 = r12.zze
            com.google.android.recaptcha.internal.zzaw.zzi(r13, r3, r1, r5)
            com.google.android.recaptcha.internal.zzaw r6 = r12.zzb
            long r7 = r12.zzc
            java.lang.String r9 = r12.zzf
            com.google.android.recaptcha.internal.zzbd r10 = r12.zze
            r12.zza = r2
            r11 = r12
            java.lang.Object r13 = com.google.android.recaptcha.internal.zzaw.zzd(r6, r7, r9, r10, r11)
            if (r13 == r0) goto L64
        L2b:
            com.google.android.recaptcha.internal.zzaw r1 = r12.zzb
            com.google.android.recaptcha.RecaptchaAction r2 = r12.zzd
            com.google.android.recaptcha.internal.zzbd r3 = r12.zze
            com.google.android.recaptcha.internal.zzog r13 = (com.google.android.recaptcha.internal.zzog) r13
            r4 = 2
            r12.zza = r4
            java.lang.Object r13 = com.google.android.recaptcha.internal.zzaw.zzf(r1, r2, r13, r3, r12)
            if (r13 != r0) goto L3d
            goto L64
        L3d:
            com.google.android.recaptcha.internal.zzaw r0 = r12.zzb
            com.google.android.recaptcha.internal.zzbd r1 = r12.zze
            com.google.android.recaptcha.internal.zzol r13 = (com.google.android.recaptcha.internal.zzol) r13
            com.google.android.recaptcha.internal.zzaw.zzh(r0, r13, r1)
            com.google.android.recaptcha.internal.zzaw r0 = r12.zzb
            com.google.android.recaptcha.internal.zzbd r1 = r12.zze
            com.google.android.recaptcha.internal.zzbg r0 = com.google.android.recaptcha.internal.zzaw.zzb(r0)
            com.google.android.recaptcha.internal.zzne r2 = com.google.android.recaptcha.internal.zzne.EXECUTE_TOTAL
            com.google.android.recaptcha.internal.zzbb r1 = r1.zza(r2)
            r0.zza(r1)
            java.lang.String r13 = r13.zzi()
            java.lang.Object r13 = s3.m.b(r13)
            s3.m r13 = s3.m.a(r13)
            return r13
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzat.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
