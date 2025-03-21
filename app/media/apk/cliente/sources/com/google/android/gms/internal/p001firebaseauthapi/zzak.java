package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.NoSuchElementException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzak  reason: invalid package */
/* loaded from: classes.dex */
abstract class zzak<E> extends zzbg<E> {
    private final int zza;
    private int zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzak(int i5, int i6) {
        zzz.zzb(i6, i5);
        this.zza = i5;
        this.zzb = i6;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i5 = this.zzb;
            this.zzb = i5 + 1;
            return zza(i5);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i5 = this.zzb - 1;
            this.zzb = i5;
            return zza(i5);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    protected abstract E zza(int i5);
}
