package com.google.android.recaptcha;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.internal.zzam;
import v3.d;
/* loaded from: classes.dex */
public final class Recaptcha {
    public static final Recaptcha INSTANCE = new Recaptcha();

    private Recaptcha() {
    }

    /* renamed from: getClient-BWLJW6A$default  reason: not valid java name */
    public static /* synthetic */ Object m0getClientBWLJW6A$default(Recaptcha recaptcha, Application application, String str, long j5, d dVar, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            j5 = 10000;
        }
        return recaptcha.m1getClientBWLJW6A(application, str, j5, dVar);
    }

    public static final Task<RecaptchaTasksClient> getTasksClient(Application application, String str) {
        return zzam.zzd(application, str, 10000L);
    }

    public static final Task<RecaptchaTasksClient> getTasksClient(Application application, String str, long j5) {
        return zzam.zzd(application, str, j5);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* renamed from: getClient-BWLJW6A  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m1getClientBWLJW6A(android.app.Application r8, java.lang.String r9, long r10, v3.d<? super s3.m<? extends com.google.android.recaptcha.RecaptchaClient>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.google.android.recaptcha.Recaptcha$getClient$1
            if (r0 == 0) goto L13
            r0 = r12
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = (com.google.android.recaptcha.Recaptcha$getClient$1) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = new com.google.android.recaptcha.Recaptcha$getClient$1
            r0.<init>(r7, r12)
        L18:
            r6 = r0
            java.lang.Object r12 = r6.zza
            java.lang.Object r0 = w3.b.c()
            int r1 = r6.zzc
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            s3.n.b(r12)     // Catch: java.lang.Throwable -> L2a
            goto L48
        L2a:
            r8 = move-exception
            goto L4f
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            s3.n.b(r12)
            s3.m$a r12 = s3.m.f7565b     // Catch: java.lang.Throwable -> L2a
            com.google.android.recaptcha.internal.zzam r12 = com.google.android.recaptcha.internal.zzam.zza     // Catch: java.lang.Throwable -> L2a
            r6.zzc = r2     // Catch: java.lang.Throwable -> L2a
            r5 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            java.lang.Object r12 = com.google.android.recaptcha.internal.zzam.zzc(r1, r2, r3, r5, r6)     // Catch: java.lang.Throwable -> L2a
            if (r12 != r0) goto L48
            return r0
        L48:
            com.google.android.recaptcha.internal.zzaw r12 = (com.google.android.recaptcha.internal.zzaw) r12     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r8 = s3.m.b(r12)     // Catch: java.lang.Throwable -> L2a
            goto L59
        L4f:
            s3.m$a r9 = s3.m.f7565b
            java.lang.Object r8 = s3.n.a(r8)
            java.lang.Object r8 = s3.m.b(r8)
        L59:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.Recaptcha.m1getClientBWLJW6A(android.app.Application, java.lang.String, long, v3.d):java.lang.Object");
    }
}
