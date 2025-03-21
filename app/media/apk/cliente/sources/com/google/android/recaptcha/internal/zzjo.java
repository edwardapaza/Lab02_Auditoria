package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class zzjo extends zzjs {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzjo() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjo(zzjn zzjnVar) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zzf(Object obj, long j5, int i5) {
        zzjl zzjlVar;
        List list = (List) zzlv.zzf(obj, j5);
        if (list.isEmpty()) {
            List zzjlVar2 = list instanceof zzjm ? new zzjl(i5) : ((list instanceof zzkm) && (list instanceof zzjb)) ? ((zzjb) list).zzd(i5) : new ArrayList(i5);
            zzlv.zzs(obj, j5, zzjlVar2);
            return zzjlVar2;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i5);
            arrayList.addAll(list);
            zzjlVar = arrayList;
        } else if (!(list instanceof zzlq)) {
            if ((list instanceof zzkm) && (list instanceof zzjb)) {
                zzjb zzjbVar = (zzjb) list;
                if (zzjbVar.zzc()) {
                    return list;
                }
                zzjb zzd = zzjbVar.zzd(list.size() + i5);
                zzlv.zzs(obj, j5, zzd);
                return zzd;
            }
            return list;
        } else {
            zzjl zzjlVar3 = new zzjl(list.size() + i5);
            zzjlVar3.addAll(zzjlVar3.size(), (zzlq) list);
            zzjlVar = zzjlVar3;
        }
        zzlv.zzs(obj, j5, zzjlVar);
        return zzjlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzjs
    public final List zza(Object obj, long j5) {
        return zzf(obj, j5, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzjs
    public final void zzb(Object obj, long j5) {
        Object unmodifiableList;
        List list = (List) zzlv.zzf(obj, j5);
        if (list instanceof zzjm) {
            unmodifiableList = ((zzjm) list).zze();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzkm) && (list instanceof zzjb)) {
                zzjb zzjbVar = (zzjb) list;
                if (zzjbVar.zzc()) {
                    zzjbVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzlv.zzs(obj, j5, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzjs
    public final void zzc(Object obj, Object obj2, long j5) {
        List list = (List) zzlv.zzf(obj2, j5);
        List zzf = zzf(obj, j5, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzlv.zzs(obj, j5, list);
    }
}
