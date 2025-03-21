package com.google.android.gms.internal.maps;

import java.util.Iterator;
import javax.annotation.CheckForNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public final class zzbe extends zzba {
    final transient Object zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbe(Object obj) {
        if (obj != null) {
            this.zza = obj;
            return;
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.maps.zzba, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.maps.zzba, com.google.android.gms.internal.maps.zzaw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzbb(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.zza.toString();
        return "[" + obj + "]";
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    final int zza(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.maps.zzba, com.google.android.gms.internal.maps.zzaw
    public final zzbf zzd() {
        return new zzbb(this.zza);
    }
}
