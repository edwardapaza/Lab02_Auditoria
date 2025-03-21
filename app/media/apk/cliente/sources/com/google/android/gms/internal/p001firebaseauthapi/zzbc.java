package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbc  reason: invalid package */
/* loaded from: classes.dex */
final class zzbc<K> extends zzav<K> {
    private final transient zzau<K, ?> zza;
    private final transient zzaq<K> zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbc(zzau<K, ?> zzauVar, zzaq<K> zzaqVar) {
        this.zza = zzauVar;
        this.zzb = zzaqVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzav, com.google.android.gms.internal.p001firebaseauthapi.zzal, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final int zza(Object[] objArr, int i5) {
        return zzc().zza(objArr, i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzav, com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final zzaq<K> zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final zzbd<K> zzd() {
        return (zzbd) zzc().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final boolean zze() {
        return true;
    }
}
