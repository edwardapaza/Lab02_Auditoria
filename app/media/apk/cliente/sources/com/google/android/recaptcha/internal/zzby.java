package com.google.android.recaptcha.internal;

import d4.p;
import e4.s;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import m4.k0;
import s3.n;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzby extends l implements p {
    final /* synthetic */ Exception zza;
    final /* synthetic */ zzcj zzb;
    final /* synthetic */ zzca zzc;
    private /* synthetic */ Object zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzby(Exception exc, zzcj zzcjVar, zzca zzcaVar, d dVar) {
        super(2, dVar);
        this.zza = exc;
        this.zzb = zzcjVar;
        this.zzc = zzcaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        zzby zzbyVar = new zzby(this.zza, this.zzb, this.zzc, dVar);
        zzbyVar.zzd = obj;
        return zzbyVar;
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzby) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        zzpg zzpgVar;
        w3.d.c();
        n.b(obj);
        j0 j0Var = (j0) this.zzd;
        Exception exc = this.zza;
        if (exc instanceof zzae) {
            zzpgVar = ((zzae) exc).zza();
            zzpgVar.zzd(this.zzb.zza());
        } else {
            zzcj zzcjVar = this.zzb;
            zzpg zzf = zzph.zzf();
            zzf.zzd(zzcjVar.zza());
            zzf.zzp(2);
            zzf.zze(2);
            zzpgVar = zzf;
        }
        zzph zzphVar = (zzph) zzpgVar.zzj();
        zzphVar.zzk();
        zzphVar.zzj();
        s.b(this.zza.getClass()).c();
        this.zza.getMessage();
        zzcj zzcjVar2 = this.zzb;
        zzz zzb = zzcjVar2.zzb();
        zzz zzzVar = zzcjVar2.zza;
        if (zzzVar == null) {
            zzzVar = null;
        }
        zzno zza = zzbp.zza(zzb, zzzVar);
        String zzd = this.zzb.zzd();
        if (zzd.length() == 0) {
            zzd = "recaptcha.m.Main.rge";
        }
        if (k0.d(j0Var)) {
            zzca zzcaVar = this.zzc;
            zzfy zzh = zzfy.zzh();
            byte[] zzd2 = zzphVar.zzd();
            zzfy zzh2 = zzfy.zzh();
            byte[] zzd3 = zza.zzd();
            zzcaVar.zzc.zze().zzb(zzd, (String[]) Arrays.copyOf(new String[]{zzh.zzi(zzd2, 0, zzd2.length), zzh2.zzi(zzd3, 0, zzd3.length)}, 2));
        }
        return t.f7573a;
    }
}
