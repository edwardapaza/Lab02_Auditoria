package com.google.android.gms.internal.common;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaf extends zzag {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzag zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzag zzagVar, int i5, int i6) {
        this.zzc = zzagVar;
        this.zza = i5;
        this.zzb = i6;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        zzs.zza(i5, this.zzb, "index");
        return this.zzc.get(i5 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.common.zzag, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i5, int i6) {
        return subList(i5, i6);
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.common.zzac
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.common.zzac
    public final boolean zzf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.common.zzac
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.common.zzag
    public final zzag zzh(int i5, int i6) {
        zzs.zzc(i5, i6, this.zzb);
        int i7 = this.zza;
        return this.zzc.subList(i5 + i7, i6 + i7);
    }
}
