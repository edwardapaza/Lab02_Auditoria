package com.google.android.recaptcha.internal;

import d4.p;
import e4.r;
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
public final class zzf extends l implements p {
    int zza;
    final /* synthetic */ zzg zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzoe zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(zzg zzgVar, long j5, zzoe zzoeVar, d dVar) {
        super(2, dVar);
        this.zzb = zzgVar;
        this.zzc = j5;
        this.zzd = zzoeVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        zzf zzfVar = new zzf(this.zzb, this.zzc, this.zzd, dVar);
        zzfVar.zze = obj;
        return zzfVar;
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzf) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c5;
        Object a5;
        r rVar;
        q0 b5;
        Object obj2;
        c5 = w3.d.c();
        if (this.zza != 0) {
            rVar = (r) this.zze;
            n.b(obj);
            a5 = obj;
        } else {
            n.b(obj);
            j0 j0Var = (j0) this.zze;
            ArrayList arrayList = new ArrayList();
            for (zza zzaVar : this.zzb.zzc()) {
                b5 = i.b(j0Var, null, null, new zze(zzaVar, this.zzc, this.zzd, null), 3, null);
                arrayList.add(b5);
            }
            r rVar2 = new r();
            q0[] q0VarArr = (q0[]) arrayList.toArray(new q0[0]);
            this.zze = rVar2;
            this.zza = 1;
            a5 = f.a((q0[]) Arrays.copyOf(q0VarArr, q0VarArr.length), this);
            if (a5 == c5) {
                return c5;
            }
            rVar = rVar2;
        }
        for (m mVar : (List) a5) {
            Throwable d5 = m.d(mVar.i());
            if (d5 != null) {
                T t5 = 0;
                if (rVar.f2939a != 0) {
                    t5 = new zzp(zzn.zzc, zzl.zzal, null);
                } else if (d5 instanceof zzp) {
                    t5 = (zzp) d5;
                }
                rVar.f2939a = t5;
            }
        }
        zzp zzpVar = (zzp) rVar.f2939a;
        if (zzpVar != null) {
            m.a aVar = m.f7565b;
            obj2 = n.a(zzpVar);
        } else {
            m.a aVar2 = m.f7565b;
            obj2 = t.f7573a;
        }
        return m.a(m.b(obj2));
    }
}
