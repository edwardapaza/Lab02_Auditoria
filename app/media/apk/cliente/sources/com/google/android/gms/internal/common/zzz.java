package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;
import org.jspecify.nullness.NullMarked;
@NullMarked
/* loaded from: classes.dex */
abstract class zzz extends zzak {
    private final int zza;
    private int zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzz(int i5, int i6) {
        zzs.zzb(i6, i5, "index");
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
    public final Object next() {
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
    public final Object previous() {
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

    protected abstract Object zza(int i5);
}
