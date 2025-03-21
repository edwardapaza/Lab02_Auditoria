package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import d4.p;
import e4.k;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.n;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzav extends l implements p {
    final /* synthetic */ zzbd zza;
    final /* synthetic */ zzaw zzb;
    final /* synthetic */ RecaptchaAction zzc;
    final /* synthetic */ zzog zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzav(zzbd zzbdVar, zzaw zzawVar, RecaptchaAction recaptchaAction, zzog zzogVar, d dVar) {
        super(2, dVar);
        this.zza = zzbdVar;
        this.zzb = zzawVar;
        this.zzc = recaptchaAction;
        this.zzd = zzogVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzav(this.zza, this.zzb, this.zzc, this.zzd, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzav) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        zzbg zzbgVar;
        zzoe zzoeVar;
        zzoe zzoeVar2;
        zzbg zzbgVar2;
        zzab zzabVar;
        zzbg zzbgVar3;
        w3.d.c();
        n.b(obj);
        zzbb zza = this.zza.zza(zzne.FETCH_TOKEN);
        zzbgVar = this.zzb.zzi;
        zzbgVar.zze.put(zza, new zzbf(zza, zzbgVar.zza, new zzac()));
        zzob zzf = zzoc.zzf();
        zzaw zzawVar = this.zzb;
        zzf.zzr(zzawVar.zzg());
        zzf.zzd(this.zzc.getAction());
        zzoeVar = zzawVar.zzg;
        zzf.zzq(zzoeVar.zzI());
        zzoeVar2 = zzawVar.zzg;
        zzf.zzp(zzoeVar2.zzH());
        zzog zzogVar = this.zzd;
        zzf.zzt(zzogVar.zzH());
        zzf.zze(zzogVar.zzj());
        zzf.zzs(zzogVar.zzI());
        zzoc zzocVar = (zzoc) zzf.zzj();
        try {
            zzabVar = this.zzb.zzf;
            URLConnection openConnection = new URL(zzabVar.zzd()).openConnection();
            k.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuffer");
            try {
                httpURLConnection.connect();
                zzoi zzf2 = zzoj.zzf();
                zzf2.zzd(zzocVar.zzi());
                zzf2.zzq(zzocVar.zzk());
                zzf2.zzt(zzocVar.zzI());
                zzf2.zzp(zzocVar.zzH());
                zzf2.zzr(zzocVar.zzJ());
                zzf2.zzs(zzocVar.zzK());
                zzf2.zze(zzocVar.zzj());
                httpURLConnection.getOutputStream().write(((zzoj) zzf2.zzj()).zzd());
                if (httpURLConnection.getResponseCode() == 200) {
                    try {
                        zzol zzg = zzol.zzg(httpURLConnection.getInputStream());
                        zzbgVar3 = this.zzb.zzi;
                        zzbgVar3.zza(zza);
                        return zzg;
                    } catch (Exception unused) {
                        throw new zzp(zzn.zzc, zzl.zzR, null);
                    }
                }
                throw zzbr.zza(httpURLConnection.getResponseCode());
            } catch (Exception e5) {
                if (e5 instanceof zzp) {
                    throw ((zzp) e5);
                }
                throw new zzp(zzn.zze, zzl.zzQ, null);
            }
        } catch (Exception e6) {
            zzp zzpVar = e6 instanceof zzp ? (zzp) e6 : new zzp(zzn.zzc, zzl.zzam, null);
            zzbgVar2 = this.zzb.zzi;
            zzbgVar2.zzb(zza, zzpVar, null);
            throw zzpVar;
        }
    }
}
