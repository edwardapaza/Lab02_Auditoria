package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaju  reason: invalid package */
/* loaded from: classes.dex */
final class zzaju extends zzajt {
    private zzaju() {
        super();
    }

    private static <E> zzajg<E> zzc(Object obj, long j5) {
        return (zzajg) zzamh.zze(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajt
    public final <L> List<L> zza(Object obj, long j5) {
        zzajg zzc = zzc(obj, j5);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzajg zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzamh.zza(obj, j5, zza);
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajt
    public final <E> void zza(Object obj, Object obj2, long j5) {
        zzajg<E> zzc = zzc(obj, j5);
        zzajg<E> zzc2 = zzc(obj2, j5);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzajg<E> zzajgVar = zzc;
        zzajgVar = zzc;
        if (size > 0 && size2 > 0) {
            boolean zzc3 = zzc.zzc();
            zzajg<E> zzajgVar2 = zzc;
            if (!zzc3) {
                zzajgVar2 = zzc.zza(size2 + size);
            }
            zzajgVar2.addAll(zzc2);
            zzajgVar = zzajgVar2;
        }
        if (size > 0) {
            zzc2 = zzajgVar;
        }
        zzamh.zza(obj, j5, zzc2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajt
    public final void zzb(Object obj, long j5) {
        zzc(obj, j5).b_();
    }
}
