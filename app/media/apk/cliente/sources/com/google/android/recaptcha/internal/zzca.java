package com.google.android.recaptcha.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import m4.i;
import m4.j0;
import m4.k0;
import s3.t;
import t3.x;
import v3.d;
/* loaded from: classes.dex */
public final class zzca implements zzbu {
    public static final zzbv zza = new zzbv(null);
    private final j0 zzb;
    private final zzcl zzc;
    private final zzee zzd;
    private final Map zze;
    private final Map zzf;

    public zzca(j0 j0Var, zzcl zzclVar, zzee zzeeVar, Map map) {
        this.zzb = j0Var;
        this.zzc = zzclVar;
        this.zzd = zzeeVar;
        this.zze = map;
        this.zzf = zzclVar.zzb().zzc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzg(List list, zzcj zzcjVar, d dVar) {
        Object c5;
        Object c6 = k0.c(new zzbx(zzcjVar, list, this, null), dVar);
        c5 = w3.d.c();
        return c6 == c5 ? c6 : t.f7573a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzh(Exception exc, zzcj zzcjVar, d dVar) {
        Object c5;
        Object c6 = k0.c(new zzby(exc, zzcjVar, this, null), dVar);
        c5 = w3.d.c();
        return c6 == c5 ? c6 : t.f7573a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzi(zzpr zzprVar, zzcj zzcjVar) {
        zzfh zzb = zzfh.zzb();
        int zza2 = zzcjVar.zza();
        zzdd zzddVar = (zzdd) this.zze.get(Integer.valueOf(zzprVar.zzf()));
        if (zzddVar == null) {
            throw new zzae(5, 2, null);
        }
        int zzg = zzprVar.zzg();
        zzpq[] zzpqVarArr = (zzpq[]) zzprVar.zzj().toArray(new zzpq[0]);
        zzddVar.zza(zzg, zzcjVar, (zzpq[]) Arrays.copyOf(zzpqVarArr, zzpqVarArr.length));
        if (zza2 == zzcjVar.zza()) {
            zzcjVar.zzg(zzcjVar.zza() + 1);
        }
        zzb.zzf();
        long zza3 = zzb.zza(TimeUnit.MICROSECONDS);
        zzv zzvVar = zzv.zza;
        int zzk = zzprVar.zzk();
        if (zzk == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzv.zza(zzk - 2, zza3);
        zzprVar.zzk();
        zzprVar.zzg();
        x.w(zzprVar.zzj(), null, null, null, 0, null, new zzbw(this), 31, null);
    }

    @Override // com.google.android.recaptcha.internal.zzbu
    public final void zza(String str) {
        i.d(this.zzb, null, null, new zzbz(new zzcj(this.zzc), this, str, null), 3, null);
    }
}
