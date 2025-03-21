package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.AbstractMap;
import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaz  reason: invalid package */
/* loaded from: classes.dex */
final class zzaz extends zzaq {
    private final /* synthetic */ zzba zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaz(zzba zzbaVar) {
        this.zza = zzbaVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i5) {
        int i6;
        Object[] objArr;
        Object[] objArr2;
        i6 = this.zza.zzd;
        zzz.zza(i5, i6);
        objArr = this.zza.zzb;
        int i7 = i5 * 2;
        Object obj = objArr[i7];
        Objects.requireNonNull(obj);
        objArr2 = this.zza.zzb;
        Object obj2 = objArr2[i7 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i5;
        i5 = this.zza.zzd;
        return i5;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final boolean zze() {
        return true;
    }
}
