package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
abstract class zzgh extends AbstractList implements zzjb {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(boolean z4) {
        this.zza = z4;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, Object obj) {
        zza();
        super.add(i5, obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        zza();
        return super.add(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection collection) {
        zza();
        return super.addAll(i5, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        zza();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        zza();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            if (obj instanceof RandomAccess) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    for (int i5 = 0; i5 < size; i5++) {
                        if (!get(i5).equals(list.get(i5))) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return super.equals(obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = (i5 * 31) + get(i6).hashCode();
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i5) {
        zza();
        return super.remove(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zza();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        zza();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        zza();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i5, Object obj) {
        zza();
        return super.set(i5, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.android.recaptcha.internal.zzjb
    public final void zzb() {
        if (this.zza) {
            this.zza = false;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzjb
    public final boolean zzc() {
        return this.zza;
    }
}
