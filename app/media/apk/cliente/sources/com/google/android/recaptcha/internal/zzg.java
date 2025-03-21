package com.google.android.recaptcha.internal;

import e4.g;
import java.util.ArrayList;
import java.util.List;
import m4.k0;
import t3.p;
import v3.d;
/* loaded from: classes.dex */
public final class zzg {
    private final List zza;

    public zzg() {
        this(null, 1, null);
    }

    public /* synthetic */ zzg(List list, int i5, g gVar) {
        List f5;
        f5 = p.f();
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        arrayList.addAll(f5);
    }

    public final Object zza(String str, long j5, d dVar) {
        return k0.c(new zzc(this, str, j5, null), dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzb(long r11, com.google.android.recaptcha.internal.zzoe r13, v3.d r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzd
            if (r0 == 0) goto L13
            r0 = r14
            com.google.android.recaptcha.internal.zzd r0 = (com.google.android.recaptcha.internal.zzd) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzd r0 = new com.google.android.recaptcha.internal.zzd
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.zza
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            s3.n.b(r14)
            goto L47
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            s3.n.b(r14)
            com.google.android.recaptcha.internal.zzf r14 = new com.google.android.recaptcha.internal.zzf
            r9 = 0
            r4 = r14
            r5 = r10
            r6 = r11
            r8 = r13
            r4.<init>(r5, r6, r8, r9)
            r0.zzc = r3
            java.lang.Object r14 = m4.k0.c(r14, r0)
            if (r14 != r1) goto L47
            return r1
        L47:
            s3.m r14 = (s3.m) r14
            java.lang.Object r11 = r14.i()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzg.zzb(long, com.google.android.recaptcha.internal.zzoe, v3.d):java.lang.Object");
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zza zzaVar) {
        this.zza.add(zzaVar);
    }
}
