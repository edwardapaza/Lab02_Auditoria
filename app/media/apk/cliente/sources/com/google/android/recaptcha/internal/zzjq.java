package com.google.android.recaptcha.internal;

import java.util.List;
/* loaded from: classes.dex */
final class zzjq extends zzjs {
    private zzjq() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjq(zzjp zzjpVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzjs
    public final List zza(Object obj, long j5) {
        zzjb zzjbVar = (zzjb) zzlv.zzf(obj, j5);
        if (zzjbVar.zzc()) {
            return zzjbVar;
        }
        int size = zzjbVar.size();
        zzjb zzd = zzjbVar.zzd(size == 0 ? 10 : size + size);
        zzlv.zzs(obj, j5, zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzjs
    public final void zzb(Object obj, long j5) {
        ((zzjb) zzlv.zzf(obj, j5)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzjs
    public final void zzc(Object obj, Object obj2, long j5) {
        zzjb zzjbVar = (zzjb) zzlv.zzf(obj, j5);
        zzjb zzjbVar2 = (zzjb) zzlv.zzf(obj2, j5);
        int size = zzjbVar.size();
        int size2 = zzjbVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzjbVar.zzc()) {
                zzjbVar = zzjbVar.zzd(size2 + size);
            }
            zzjbVar.addAll(zzjbVar2);
        }
        if (size > 0) {
            zzjbVar2 = zzjbVar;
        }
        zzlv.zzs(obj, j5, zzjbVar2);
    }
}
