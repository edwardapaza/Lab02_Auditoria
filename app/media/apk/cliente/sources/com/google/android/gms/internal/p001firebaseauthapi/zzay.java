package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzay  reason: invalid package */
/* loaded from: classes.dex */
public final class zzay<E> extends zzaq<E> {
    static final zzaq<Object> zza = new zzay(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(Object[] objArr, int i5) {
        this.zzb = objArr;
        this.zzc = i5;
    }

    @Override // java.util.List
    public final E get(int i5) {
        zzz.zza(i5, this.zzc);
        E e5 = (E) this.zzb[i5];
        Objects.requireNonNull(e5);
        return e5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaq, com.google.android.gms.internal.p001firebaseauthapi.zzal
    final int zza(Object[] objArr, int i5) {
        System.arraycopy(this.zzb, 0, objArr, i5, this.zzc);
        return i5 + this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final int zzb() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final boolean zze() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final Object[] zzf() {
        return this.zzb;
    }
}
