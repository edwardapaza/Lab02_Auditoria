package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajs  reason: invalid package */
/* loaded from: classes.dex */
final class zzajs extends zzajt {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzajs() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j5, int i5) {
        List<L> zza2;
        zzajr zzajrVar;
        List<L> zzc = zzc(obj, j5);
        if (!zzc.isEmpty()) {
            if (zza.isAssignableFrom(zzc.getClass())) {
                ArrayList arrayList = new ArrayList(zzc.size() + i5);
                arrayList.addAll(zzc);
                zzajrVar = arrayList;
            } else if (zzc instanceof zzamg) {
                zzajr zzajrVar2 = new zzajr(zzc.size() + i5);
                zzajrVar2.addAll((zzamg) zzc);
                zzajrVar = zzajrVar2;
            } else if (!(zzc instanceof zzakw) || !(zzc instanceof zzajg)) {
                return zzc;
            } else {
                zzajg zzajgVar = (zzajg) zzc;
                if (zzajgVar.zzc()) {
                    return zzc;
                }
                zza2 = zzajgVar.zza(zzc.size() + i5);
            }
            zzamh.zza(obj, j5, zzajrVar);
            return zzajrVar;
        }
        zza2 = zzc instanceof zzajq ? new zzajr(i5) : ((zzc instanceof zzakw) && (zzc instanceof zzajg)) ? ((zzajg) zzc).zza(i5) : new ArrayList<>(i5);
        zzamh.zza(obj, j5, zza2);
        return zza2;
    }

    private static <E> List<E> zzc(Object obj, long j5) {
        return (List) zzamh.zze(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajt
    public final <L> List<L> zza(Object obj, long j5) {
        return zza(obj, j5, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajt
    public final <E> void zza(Object obj, Object obj2, long j5) {
        List zzc = zzc(obj2, j5);
        List zza2 = zza(obj, j5, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzamh.zza(obj, j5, zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajt
    public final void zzb(Object obj, long j5) {
        Object unmodifiableList;
        List list = (List) zzamh.zze(obj, j5);
        if (list instanceof zzajq) {
            unmodifiableList = ((zzajq) list).a_();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzakw) && (list instanceof zzajg)) {
                zzajg zzajgVar = (zzajg) list;
                if (zzajgVar.zzc()) {
                    zzajgVar.b_();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzamh.zza(obj, j5, unmodifiableList);
    }
}
