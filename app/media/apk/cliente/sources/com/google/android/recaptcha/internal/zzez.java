package com.google.android.recaptcha.internal;

import android.content.Context;
import android.webkit.WebView;
import java.util.LinkedHashMap;
import java.util.Map;
import m4.i;
import m4.u;
import m4.v2;
import t3.x;
/* loaded from: classes.dex */
public final class zzez implements zza {
    public static final zzep zza = new zzep(null);
    public u zzb;
    public zzbu zzc;
    private final WebView zzd;
    private final String zze;
    private final Context zzf;
    private final zzab zzg;
    private final zzbd zzh;
    private final zzbg zzi;
    private final zzbq zzj;
    private final Map zzk = zzfa.zza();
    private final Map zzl;
    private final Map zzm;
    private final zzfh zzn;
    private final zzeq zzo;
    private final zzbd zzp;
    private final zzt zzq;

    public zzez(WebView webView, String str, Context context, zzab zzabVar, zzbd zzbdVar, zzt zztVar, zzbg zzbgVar, zzbq zzbqVar) {
        this.zzd = webView;
        this.zze = str;
        this.zzf = context;
        this.zzg = zzabVar;
        this.zzh = zzbdVar;
        this.zzq = zztVar;
        this.zzi = zzbgVar;
        this.zzj = zzbqVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzl = linkedHashMap;
        this.zzm = linkedHashMap;
        this.zzn = zzfh.zzc();
        zzeq zzeqVar = new zzeq(this);
        this.zzo = zzeqVar;
        zzbd zzb = zzbdVar.zzb();
        zzb.zzc(zzbdVar.zzd());
        this.zzp = zzb;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(zzeqVar, "RN");
        webView.setWebViewClient(new zzeu(this));
    }

    public static final /* synthetic */ void zzl(zzez zzezVar, zzoe zzoeVar) {
        zzezVar.zzd.clearCache(true);
        zzbb zza2 = zzezVar.zzp.zza(zzne.INIT_NETWORK);
        r1.zze.put(zza2, new zzbf(zza2, zzezVar.zzi.zza, new zzac()));
        i.d(zzezVar.zzq.zza(), null, null, new zzey(zzezVar, zzoeVar, zza2, null), 3, null);
    }

    public static final /* synthetic */ void zzm(zzez zzezVar, String str) {
        zzbb zza2 = zzezVar.zzp.zza(zzne.LOAD_WEBVIEW);
        try {
            r2.zze.put(zza2, new zzbf(zza2, zzezVar.zzi.zza, new zzac()));
            zzezVar.zzd.loadDataWithBaseURL(zzezVar.zzg.zza(), str, "text/html", "utf-8", null);
        } catch (Exception unused) {
            zzp zzpVar = new zzp(zzn.zzc, zzl.zzag, null);
            zzezVar.zzi.zzb(zza2, zzpVar, null);
            zzezVar.zzk().z(zzpVar);
        }
    }

    private final zzp zzp(Exception exc, zzp zzpVar) {
        return exc instanceof v2 ? new zzp(zzn.zzc, zzl.zzj, null) : exc instanceof zzp ? (zzp) exc : zzpVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    @Override // com.google.android.recaptcha.internal.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zza(java.lang.String r5, long r6, v3.d r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.internal.zzer
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.recaptcha.internal.zzer r0 = (com.google.android.recaptcha.internal.zzer) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzer r0 = new com.google.android.recaptcha.internal.zzer
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.zza
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.String r5 = r0.zze
            com.google.android.recaptcha.internal.zzez r6 = r0.zzd
            s3.n.b(r8)     // Catch: java.lang.Exception -> L2d
            goto L4e
        L2d:
            r7 = move-exception
            goto L58
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            s3.n.b(r8)
            com.google.android.recaptcha.internal.zzet r8 = new com.google.android.recaptcha.internal.zzet     // Catch: java.lang.Exception -> L55
            r2 = 0
            r8.<init>(r5, r4, r2)     // Catch: java.lang.Exception -> L55
            r0.zzd = r4     // Catch: java.lang.Exception -> L55
            r0.zze = r5     // Catch: java.lang.Exception -> L55
            r0.zzc = r3     // Catch: java.lang.Exception -> L55
            java.lang.Object r8 = m4.x2.c(r6, r8, r0)     // Catch: java.lang.Exception -> L55
            if (r8 != r1) goto L4d
            return r1
        L4d:
            r6 = r4
        L4e:
            com.google.android.recaptcha.internal.zzog r8 = (com.google.android.recaptcha.internal.zzog) r8     // Catch: java.lang.Exception -> L2d
            java.lang.Object r5 = s3.m.b(r8)     // Catch: java.lang.Exception -> L2d
            goto L88
        L55:
            r6 = move-exception
            r7 = r6
            r6 = r4
        L58:
            java.lang.Class r8 = r7.getClass()
            com.google.android.recaptcha.internal.zzp r0 = new com.google.android.recaptcha.internal.zzp
            com.google.android.recaptcha.internal.zzn r1 = com.google.android.recaptcha.internal.zzn.zzc
            com.google.android.recaptcha.internal.zzl r2 = com.google.android.recaptcha.internal.zzl.zzai
            java.lang.String r8 = r8.getSimpleName()
            r0.<init>(r1, r2, r8)
            com.google.android.recaptcha.internal.zzp r7 = r6.zzp(r7, r0)
            java.util.Map r6 = r6.zzl
            java.lang.Object r5 = r6.remove(r5)
            m4.u r5 = (m4.u) r5
            if (r5 == 0) goto L7e
            boolean r5 = r5.z(r7)
            kotlin.coroutines.jvm.internal.b.a(r5)
        L7e:
            s3.m$a r5 = s3.m.f7565b
            java.lang.Object r5 = s3.n.a(r7)
            java.lang.Object r5 = s3.m.b(r5)
        L88:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzez.zza(java.lang.String, long, v3.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4 A[LOOP:0: B:41:0x00de->B:43:0x00e4, LOOP_END] */
    @Override // com.google.android.recaptcha.internal.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzb(long r8, com.google.android.recaptcha.internal.zzoe r10, v3.d r11) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzez.zzb(long, com.google.android.recaptcha.internal.zzoe, v3.d):java.lang.Object");
    }

    public final WebView zzc() {
        return this.zzd;
    }

    public final zzbq zzf() {
        return this.zzj;
    }

    public final zzeq zzg() {
        return this.zzo;
    }

    public final u zzk() {
        u uVar = this.zzb;
        if (uVar != null) {
            return uVar;
        }
        return null;
    }

    public final zzca zzo(zzoe zzoeVar, zzag zzagVar) {
        long[] I;
        zzcd zzcdVar = new zzcd(this.zzd, this.zzq.zzb());
        zzef zzefVar = new zzef();
        I = x.I(zzoeVar.zzK());
        zzefVar.zzb(I);
        zzcl zzclVar = new zzcl(zzcdVar, zzagVar, new zzaa());
        zzeg zzegVar = new zzeg(zzefVar, new zzed());
        zzclVar.zzf(3, this.zzf);
        zzclVar.zzf(5, zzen.class.getMethod("cs", new Object[0].getClass()));
        zzclVar.zzf(6, new zzeh(this.zzf));
        zzclVar.zzf(7, new zzej());
        zzclVar.zzf(8, new zzeo(this.zzf));
        zzclVar.zzf(9, new zzek(this.zzf));
        zzclVar.zzf(10, new zzei(this.zzf));
        return new zzca(this.zzq.zzc(), zzclVar, zzegVar, zzbt.zza());
    }
}
