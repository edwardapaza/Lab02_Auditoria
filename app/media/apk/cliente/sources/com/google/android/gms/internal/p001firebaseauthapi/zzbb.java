package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbb  reason: invalid package */
/* loaded from: classes.dex */
final class zzbb extends zzaq<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(Object[] objArr, int i5, int i6) {
        this.zza = objArr;
        this.zzb = i5;
        this.zzc = i6;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        zzz.zza(i5, this.zzc);
        Object obj = this.zza[(i5 * 2) + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final boolean zze() {
        return true;
    }
}
