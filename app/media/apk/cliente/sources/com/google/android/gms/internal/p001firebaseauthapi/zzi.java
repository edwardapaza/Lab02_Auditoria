package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzi  reason: invalid package */
/* loaded from: classes.dex */
abstract class zzi<T> implements Iterator<T> {
    private int zza = zzh.zzb;
    private T zzb;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i5 = this.zza;
        int i6 = zzh.zzd;
        if (i5 != i6) {
            int i7 = i5 - 1;
            if (i7 != 0) {
                if (i7 != 2) {
                    this.zza = i6;
                    this.zzb = zza();
                    if (this.zza != zzh.zzc) {
                        this.zza = zzh.zza;
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.zza = zzh.zzb;
            T t5 = this.zzb;
            this.zzb = null;
            return t5;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    protected abstract T zza();

    /* JADX INFO: Access modifiers changed from: protected */
    public final T zzb() {
        this.zza = zzh.zzc;
        return null;
    }
}
