package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaClient;
import com.google.android.recaptcha.RecaptchaTasksClient;
import h4.l;
import java.util.LinkedHashMap;
import java.util.List;
import k4.e;
import m4.i;
import m4.q0;
import s3.p;
import t3.g0;
import t3.q;
/* loaded from: classes.dex */
public final class zzaw implements RecaptchaClient, RecaptchaTasksClient {
    public static final zzan zza = new zzan(null);
    private static final e zzb = new e("^[a-zA-Z0-9/_]{0,100}$");
    private final Application zzc;
    private final zzg zzd;
    private final String zze;
    private final zzab zzf;
    private final zzoe zzg;
    private final zzbd zzh;
    private final zzbg zzi;
    private final zzq zzj;
    private final zzbs zzk;
    private final zzt zzl;

    public zzaw(Application application, zzg zzgVar, String str, zzt zztVar, zzab zzabVar, zzoe zzoeVar, zzbd zzbdVar, zzbg zzbgVar, zzq zzqVar, zzbs zzbsVar) {
        this.zzc = application;
        this.zzd = zzgVar;
        this.zze = str;
        this.zzl = zztVar;
        this.zzf = zzabVar;
        this.zzg = zzoeVar;
        this.zzh = zzbdVar;
        this.zzi = zzbgVar;
        this.zzj = zzqVar;
        this.zzk = zzbsVar;
    }

    public static final /* synthetic */ void zzi(zzaw zzawVar, long j5, RecaptchaAction recaptchaAction, zzbd zzbdVar) {
        zzbb zza2 = zzbdVar.zza(zzne.EXECUTE_NATIVE);
        zzbg.zzc(zzawVar.zzi, zza2, null, 2, null);
        zzp zzpVar = !zzb.a(recaptchaAction.getAction()) ? new zzp(zzn.zzi, zzl.zzq, null) : null;
        if (j5 < 5000) {
            zzpVar = new zzp(zzn.zzc, zzl.zzT, null);
        }
        zzbg zzbgVar = zzawVar.zzi;
        if (zzpVar == null) {
            zzbgVar.zza(zza2);
        } else {
            zzbgVar.zzb(zza2, zzpVar, null);
            throw zzpVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzj(long r6, java.lang.String r8, com.google.android.recaptcha.internal.zzbd r9, v3.d r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof com.google.android.recaptcha.internal.zzao
            if (r0 == 0) goto L13
            r0 = r10
            com.google.android.recaptcha.internal.zzao r0 = (com.google.android.recaptcha.internal.zzao) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzao r0 = new com.google.android.recaptcha.internal.zzao
            r0.<init>(r5, r10)
        L18:
            java.lang.Object r10 = r0.zza
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.zzc
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            com.google.android.recaptcha.internal.zzbb r6 = r0.zze
            com.google.android.recaptcha.internal.zzaw r7 = r0.zzd
            s3.n.b(r10)     // Catch: java.lang.Exception -> L2e
            goto L57
        L2e:
            r8 = move-exception
            goto L64
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            s3.n.b(r10)
            com.google.android.recaptcha.internal.zzne r10 = com.google.android.recaptcha.internal.zzne.COLLECT_SIGNALS
            com.google.android.recaptcha.internal.zzbb r9 = r9.zza(r10)
            com.google.android.recaptcha.internal.zzbg r10 = r5.zzi
            r2 = 2
            com.google.android.recaptcha.internal.zzbg.zzc(r10, r9, r4, r2, r4)
            com.google.android.recaptcha.internal.zzg r10 = r5.zzd     // Catch: java.lang.Exception -> L60
            r0.zzd = r5     // Catch: java.lang.Exception -> L60
            r0.zze = r9     // Catch: java.lang.Exception -> L60
            r0.zzc = r3     // Catch: java.lang.Exception -> L60
            java.lang.Object r10 = r10.zza(r8, r6, r0)     // Catch: java.lang.Exception -> L60
            if (r10 == r1) goto L5f
            r7 = r5
            r6 = r9
        L57:
            com.google.android.recaptcha.internal.zzog r10 = (com.google.android.recaptcha.internal.zzog) r10     // Catch: java.lang.Exception -> L2e
            com.google.android.recaptcha.internal.zzbg r8 = r7.zzi     // Catch: java.lang.Exception -> L2e
            r8.zza(r6)     // Catch: java.lang.Exception -> L2e
            return r10
        L5f:
            return r1
        L60:
            r6 = move-exception
            r8 = r6
            r7 = r5
            r6 = r9
        L64:
            boolean r9 = r8 instanceof com.google.android.recaptcha.internal.zzp
            if (r9 == 0) goto L6b
            com.google.android.recaptcha.internal.zzp r8 = (com.google.android.recaptcha.internal.zzp) r8
            goto L74
        L6b:
            com.google.android.recaptcha.internal.zzp r8 = new com.google.android.recaptcha.internal.zzp
            com.google.android.recaptcha.internal.zzn r9 = com.google.android.recaptcha.internal.zzn.zzc
            com.google.android.recaptcha.internal.zzl r10 = com.google.android.recaptcha.internal.zzl.zzan
            r8.<init>(r9, r10, r4)
        L74:
            com.google.android.recaptcha.internal.zzbg r7 = r7.zzi
            r7.zzb(r6, r8, r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaw.zzj(long, java.lang.String, com.google.android.recaptcha.internal.zzbd, v3.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzk(com.google.android.recaptcha.RecaptchaAction r16, long r17, v3.d r19) {
        /*
            r15 = this;
            r9 = r15
            r0 = r19
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzas
            if (r1 == 0) goto L16
            r1 = r0
            com.google.android.recaptcha.internal.zzas r1 = (com.google.android.recaptcha.internal.zzas) r1
            int r2 = r1.zzc
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.zzc = r2
            goto L1b
        L16:
            com.google.android.recaptcha.internal.zzas r1 = new com.google.android.recaptcha.internal.zzas
            r1.<init>(r15, r0)
        L1b:
            r0 = r1
            java.lang.Object r1 = r0.zza
            java.lang.Object r10 = w3.b.c()
            int r2 = r0.zzc
            r11 = 1
            r12 = 0
            if (r2 == 0) goto L3c
            if (r2 != r11) goto L34
            com.google.android.recaptcha.internal.zzbd r2 = r0.zze
            com.google.android.recaptcha.internal.zzaw r3 = r0.zzd
            s3.n.b(r1)     // Catch: java.lang.Exception -> L32
            goto L79
        L32:
            r0 = move-exception
            goto L84
        L34:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3c:
            s3.n.b(r1)
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r7 = r1.toString()
            com.google.android.recaptcha.internal.zzbd r1 = r9.zzh
            com.google.android.recaptcha.internal.zzbd r13 = r1.zzb()
            r13.zzc(r7)
            com.google.android.recaptcha.internal.zzbg r1 = r9.zzi
            com.google.android.recaptcha.internal.zzne r2 = com.google.android.recaptcha.internal.zzne.EXECUTE_TOTAL
            com.google.android.recaptcha.internal.zzbb r2 = r13.zza(r2)
            r3 = 2
            com.google.android.recaptcha.internal.zzbg.zzc(r1, r2, r12, r3, r12)
            com.google.android.recaptcha.internal.zzat r14 = new com.google.android.recaptcha.internal.zzat     // Catch: java.lang.Exception -> L81
            r8 = 0
            r1 = r14
            r2 = r15
            r3 = r17
            r5 = r16
            r6 = r13
            r1.<init>(r2, r3, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L81
            r0.zzd = r9     // Catch: java.lang.Exception -> L81
            r0.zze = r13     // Catch: java.lang.Exception -> L81
            r0.zzc = r11     // Catch: java.lang.Exception -> L81
            r1 = r17
            java.lang.Object r1 = m4.x2.c(r1, r14, r0)     // Catch: java.lang.Exception -> L81
            if (r1 == r10) goto L80
            r3 = r9
            r2 = r13
        L79:
            s3.m r1 = (s3.m) r1     // Catch: java.lang.Exception -> L32
            java.lang.Object r0 = r1.i()     // Catch: java.lang.Exception -> L32
            goto Lb6
        L80:
            return r10
        L81:
            r0 = move-exception
            r3 = r9
            r2 = r13
        L84:
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzp
            if (r1 == 0) goto L8b
            com.google.android.recaptcha.internal.zzp r0 = (com.google.android.recaptcha.internal.zzp) r0
            goto L9d
        L8b:
            java.lang.Class r0 = r0.getClass()
            com.google.android.recaptcha.internal.zzp r1 = new com.google.android.recaptcha.internal.zzp
            com.google.android.recaptcha.internal.zzn r4 = com.google.android.recaptcha.internal.zzn.zzc
            com.google.android.recaptcha.internal.zzl r5 = com.google.android.recaptcha.internal.zzl.zzaj
            java.lang.String r0 = r0.getSimpleName()
            r1.<init>(r4, r5, r0)
            r0 = r1
        L9d:
            com.google.android.recaptcha.internal.zzbg r1 = r3.zzi
            com.google.android.recaptcha.internal.zzne r3 = com.google.android.recaptcha.internal.zzne.EXECUTE_TOTAL
            com.google.android.recaptcha.internal.zzbb r2 = r2.zza(r3)
            r1.zzb(r2, r0, r12)
            com.google.android.recaptcha.RecaptchaException r0 = r0.zzc()
            s3.m$a r1 = s3.m.f7565b
            java.lang.Object r0 = s3.n.a(r0)
            java.lang.Object r0 = s3.m.b(r0)
        Lb6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaw.zzk(com.google.android.recaptcha.RecaptchaAction, long, v3.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(zzol zzolVar, zzbd zzbdVar) {
        int k5;
        int a5;
        int a6;
        zzbb zza2 = zzbdVar.zza(zzne.POST_EXECUTE);
        zzbg.zzc(this.zzi, zza2, null, 2, null);
        try {
            List<zzon> zzj = zzolVar.zzj();
            k5 = q.k(zzj, 10);
            a5 = g0.a(k5);
            a6 = l.a(a5, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(a6);
            for (zzon zzonVar : zzj) {
                s3.l a7 = p.a(zzonVar.zzg(), zzonVar.zzi());
                linkedHashMap.put(a7.c(), a7.d());
            }
            this.zzj.zzb(linkedHashMap);
            this.zzi.zza(zza2);
        } catch (Exception e5) {
            zzp zzpVar = e5 instanceof zzp ? (zzp) e5 : new zzp(zzn.zzc, zzl.zzan, null);
            this.zzi.zzb(zza2, zzpVar, null);
            throw zzpVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // com.google.android.recaptcha.RecaptchaClient
    /* renamed from: execute-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mo2execute0E7RQCE(com.google.android.recaptcha.RecaptchaAction r11, long r12, v3.d<? super s3.m<java.lang.String>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzap
            if (r0 == 0) goto L13
            r0 = r14
            com.google.android.recaptcha.internal.zzap r0 = (com.google.android.recaptcha.internal.zzap) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzap r0 = new com.google.android.recaptcha.internal.zzap
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.zza
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            s3.n.b(r14)
            goto L51
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            s3.n.b(r14)
            com.google.android.recaptcha.internal.zzt r14 = r10.zzl
            m4.j0 r14 = r14.zzb()
            v3.g r14 = r14.b()
            com.google.android.recaptcha.internal.zzaq r2 = new com.google.android.recaptcha.internal.zzaq
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r9)
            r0.zzc = r3
            java.lang.Object r14 = m4.h.e(r14, r2, r0)
            if (r14 != r1) goto L51
            return r1
        L51:
            s3.m r14 = (s3.m) r14
            java.lang.Object r11 = r14.i()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaw.mo2execute0E7RQCE(com.google.android.recaptcha.RecaptchaAction, long, v3.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    @Override // com.google.android.recaptcha.RecaptchaClient
    /* renamed from: execute-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mo3executegIAlus(com.google.android.recaptcha.RecaptchaAction r5, v3.d<? super s3.m<java.lang.String>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzar
            if (r0 == 0) goto L13
            r0 = r6
            com.google.android.recaptcha.internal.zzar r0 = (com.google.android.recaptcha.internal.zzar) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzar r0 = new com.google.android.recaptcha.internal.zzar
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            s3.n.b(r6)
            s3.m r6 = (s3.m) r6
            java.lang.Object r5 = r6.i()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            s3.n.b(r6)
            r0.zzc = r3
            r2 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r5 = r4.mo2execute0E7RQCE(r5, r2, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaw.mo3executegIAlus(com.google.android.recaptcha.RecaptchaAction, v3.d):java.lang.Object");
    }

    @Override // com.google.android.recaptcha.RecaptchaTasksClient
    public final Task<String> executeTask(RecaptchaAction recaptchaAction) {
        q0 b5;
        b5 = i.b(this.zzl.zzb(), null, null, new zzau(this, recaptchaAction, 10000L, null), 3, null);
        return zzj.zza(b5);
    }

    @Override // com.google.android.recaptcha.RecaptchaTasksClient
    public final Task<String> executeTask(RecaptchaAction recaptchaAction, long j5) {
        q0 b5;
        b5 = i.b(this.zzl.zzb(), null, null, new zzau(this, recaptchaAction, j5, null), 3, null);
        return zzj.zza(b5);
    }

    public final String zzg() {
        return this.zze;
    }
}
