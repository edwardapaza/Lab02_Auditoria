package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import d4.p;
import java.util.List;
import kotlin.coroutines.jvm.internal.l;
import m4.j0;
import s3.n;
import s3.t;
import t3.x;
import v3.d;
/* loaded from: classes.dex */
final class zzbl extends l implements p {
    final /* synthetic */ zzbm zza;
    final /* synthetic */ zzpd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbl(zzbm zzbmVar, zzpd zzpdVar, d dVar) {
        super(2, dVar);
        this.zza = zzbmVar;
        this.zzb = zzpdVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d create(Object obj, d dVar) {
        return new zzbl(this.zza, this.zzb, dVar);
    }

    @Override // d4.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbl) create((j0) obj, (d) obj2)).invokeSuspend(t.f7573a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        zzaz zzazVar;
        zzaz zzazVar2;
        zzaz zzazVar3;
        zzaz zzazVar4;
        zzaz zzazVar5;
        List D;
        zzaz zzazVar6;
        w3.d.c();
        n.b(obj);
        zzbm zzbmVar = this.zza;
        zzpd zzpdVar = this.zzb;
        synchronized (zzbh.class) {
            zzazVar = zzbmVar.zze;
            if (zzazVar != null) {
                byte[] zzd = zzpdVar.zzd();
                zzba zzbaVar = new zzba(zzfy.zzg().zzi(zzd, 0, zzd.length), System.currentTimeMillis(), 0);
                zzazVar2 = zzbmVar.zze;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ss", zzbaVar.zzc());
                contentValues.put("ts", Long.valueOf(zzbaVar.zzb()));
                zzazVar2.getWritableDatabase().insert("ce", null, contentValues);
                zzazVar3 = zzbmVar.zze;
                int zzb = zzazVar3.zzb() - 500;
                if (zzb > 0) {
                    zzazVar5 = zzbmVar.zze;
                    D = x.D(zzazVar5.zzd(), zzb);
                    zzazVar6 = zzbmVar.zze;
                    zzazVar6.zza(D);
                }
                zzazVar4 = zzbmVar.zze;
                if (zzazVar4.zzb() >= 20) {
                    zzbmVar.zzg();
                }
            }
        }
        return t.f7573a;
    }
}
