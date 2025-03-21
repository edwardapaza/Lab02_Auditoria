package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzba  reason: invalid package */
/* loaded from: classes.dex */
final class zzba<K, V> extends zzav<Map.Entry<K, V>> {
    private final transient zzau<K, V> zza;
    private final transient Object[] zzb;
    private final transient int zzc = 0;
    private final transient int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzau<K, V> zzauVar, Object[] objArr, int i5, int i6) {
        this.zza = zzauVar;
        this.zzb = objArr;
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzav, com.google.android.gms.internal.p001firebaseauthapi.zzal, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final int zza(Object[] objArr, int i5) {
        return zzc().zza(objArr, i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final zzbd<Map.Entry<K, V>> zzd() {
        return (zzbd) zzc().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzav
    final zzaq<Map.Entry<K, V>> zzg() {
        return new zzaz(this);
    }
}
