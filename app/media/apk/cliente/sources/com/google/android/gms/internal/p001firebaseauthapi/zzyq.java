package com.google.android.gms.internal.p001firebaseauthapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyq  reason: invalid package */
/* loaded from: classes.dex */
public final class zzyq implements zzadm<zzage> {
    private final /* synthetic */ zzagb zza;
    private final /* synthetic */ zzafb zzb;
    private final /* synthetic */ zzacf zzc;
    private final /* synthetic */ zzafm zzd;
    private final /* synthetic */ zzadj zze;
    private final /* synthetic */ zzyl zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyq(zzyl zzylVar, zzagb zzagbVar, zzafb zzafbVar, zzacf zzacfVar, zzafm zzafmVar, zzadj zzadjVar) {
        this.zza = zzagbVar;
        this.zzb = zzafbVar;
        this.zzc = zzacfVar;
        this.zzd = zzafmVar;
        this.zze = zzadjVar;
        this.zzf = zzylVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void zza(com.google.android.gms.internal.p001firebaseauthapi.zzage r7) {
        /*
            r6 = this;
            com.google.android.gms.internal.firebase-auth-api.zzage r7 = (com.google.android.gms.internal.p001firebaseauthapi.zzage) r7
            com.google.android.gms.internal.firebase-auth-api.zzagb r0 = r6.zza
            java.lang.String r1 = "EMAIL"
            boolean r0 = r0.zzi(r1)
            r1 = 0
            if (r0 == 0) goto L13
            com.google.android.gms.internal.firebase-auth-api.zzafb r0 = r6.zzb
            r0.zzb(r1)
            goto L26
        L13:
            com.google.android.gms.internal.firebase-auth-api.zzagb r0 = r6.zza
            java.lang.String r0 = r0.zzc()
            if (r0 == 0) goto L26
            com.google.android.gms.internal.firebase-auth-api.zzafb r0 = r6.zzb
            com.google.android.gms.internal.firebase-auth-api.zzagb r2 = r6.zza
            java.lang.String r2 = r2.zzc()
            r0.zzb(r2)
        L26:
            com.google.android.gms.internal.firebase-auth-api.zzagb r0 = r6.zza
            java.lang.String r2 = "DISPLAY_NAME"
            boolean r0 = r0.zzi(r2)
            if (r0 == 0) goto L36
            com.google.android.gms.internal.firebase-auth-api.zzafb r0 = r6.zzb
            r0.zza(r1)
            goto L49
        L36:
            com.google.android.gms.internal.firebase-auth-api.zzagb r0 = r6.zza
            java.lang.String r0 = r0.zzb()
            if (r0 == 0) goto L49
            com.google.android.gms.internal.firebase-auth-api.zzafb r0 = r6.zzb
            com.google.android.gms.internal.firebase-auth-api.zzagb r2 = r6.zza
            java.lang.String r2 = r2.zzb()
            r0.zza(r2)
        L49:
            com.google.android.gms.internal.firebase-auth-api.zzagb r0 = r6.zza
            java.lang.String r2 = "PHOTO_URL"
            boolean r0 = r0.zzi(r2)
            if (r0 == 0) goto L59
            com.google.android.gms.internal.firebase-auth-api.zzafb r0 = r6.zzb
        L55:
            r0.zzd(r1)
            goto L6a
        L59:
            com.google.android.gms.internal.firebase-auth-api.zzagb r0 = r6.zza
            java.lang.String r0 = r0.zze()
            if (r0 == 0) goto L6a
            com.google.android.gms.internal.firebase-auth-api.zzafb r0 = r6.zzb
            com.google.android.gms.internal.firebase-auth-api.zzagb r1 = r6.zza
            java.lang.String r1 = r1.zze()
            goto L55
        L6a:
            com.google.android.gms.internal.firebase-auth-api.zzagb r0 = r6.zza
            java.lang.String r0 = r0.zzd()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L85
            com.google.android.gms.internal.firebase-auth-api.zzafb r0 = r6.zzb
            java.lang.String r1 = "redacted"
            byte[] r1 = r1.getBytes()
            java.lang.String r1 = q0.c.c(r1)
            r0.zzc(r1)
        L85:
            java.util.List r0 = r7.zze()
            if (r0 == 0) goto L8c
            goto L91
        L8c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L91:
            com.google.android.gms.internal.firebase-auth-api.zzafb r1 = r6.zzb
            r1.zza(r0)
            com.google.android.gms.internal.firebase-auth-api.zzacf r0 = r6.zzc
            com.google.android.gms.internal.firebase-auth-api.zzafm r1 = r6.zzd
            com.google.android.gms.common.internal.q.k(r1)
            com.google.android.gms.common.internal.q.k(r7)
            java.lang.String r2 = r7.zzc()
            java.lang.String r3 = r7.zzd()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto Lc6
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto Lc6
            long r4 = r7.zza()
            com.google.android.gms.internal.firebase-auth-api.zzafm r7 = new com.google.android.gms.internal.firebase-auth-api.zzafm
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r1 = r1.zze()
            r7.<init>(r3, r2, r4, r1)
            r1 = r7
        Lc6:
            com.google.android.gms.internal.firebase-auth-api.zzafb r7 = r6.zzb
            r0.zza(r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzyq.zza(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zze.zza(str);
    }
}
