package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzar  reason: invalid package */
/* loaded from: classes.dex */
public final class zzar extends zzaq {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzaq zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzaq zzaqVar, int i5, int i6) {
        this.zzc = zzaqVar;
        this.zza = i5;
        this.zzb = i6;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        zzz.zza(i5, this.zzb);
        return this.zzc.get(i5 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaq, java.util.List
    public final /* synthetic */ List subList(int i5, int i6) {
        return subList(i5, i6);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    final int zza() {
        return this.zzc.zzb() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaq
    public final zzaq zza(int i5, int i6) {
        zzz.zza(i5, i6, this.zzb);
        zzaq zzaqVar = this.zzc;
        int i7 = this.zza;
        return (zzaq) zzaqVar.subList(i5 + i7, i6 + i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final int zzb() {
        return this.zzc.zzb() + this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final boolean zze() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final Object[] zzf() {
        return this.zzc.zzf();
    }
}
