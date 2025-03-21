package com.google.android.recaptcha.internal;

import d4.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.coroutines.jvm.internal.l;
import m4.f;
import m4.i;
import m4.j0;
import m4.q0;
import s3.m;
import s3.n;
import s3.t;
import v3.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzc extends l implements p {
    int zza;
    final /* synthetic */ zzg zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzc(zzg zzgVar, String str, long j5, d dVar) {
        super(2, dVar);
        this.zzb = zzgVar;
        this.zzc = str;
        this.zzd = j5;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        zzc zzcVar = new zzc(this.zzb, this.zzc, this.zzd, dVar);
        zzcVar.zze = obj;
        return zzcVar;
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzc) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        Object a5;
        q0 b5;
        c5 = w3.d.c();
        int i5 = this.zza;
        n.b(obj);
        if (i5 != 0) {
            a5 = obj;
        } else {
            j0 j0Var = (j0) this.zze;
            ArrayList arrayList = new ArrayList();
            for (zza zzaVar : this.zzb.zzc()) {
                b5 = i.b(j0Var, null, null, new zzb(zzaVar, this.zzc, this.zzd, null), 3, null);
                arrayList.add(b5);
            }
            q0[] q0VarArr = (q0[]) arrayList.toArray(new q0[0]);
            this.zza = 1;
            a5 = f.a((q0[]) Arrays.copyOf(q0VarArr, q0VarArr.length), this);
            if (a5 == c5) {
                return c5;
            }
        }
        String str = this.zzc;
        zzof zzf = zzog.zzf();
        zzf.zzd(str);
        for (m mVar : (List) a5) {
            Object i6 = mVar.i();
            if (m.g(i6)) {
                zzf.zzg((zzog) i6);
            }
        }
        return (zzog) zzf.zzj();
    }
}
