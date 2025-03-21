package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahg  reason: invalid package */
/* loaded from: classes.dex */
abstract class zzahg<E> extends AbstractList<E> implements zzajg<E> {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahg() {
        this(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahg(boolean z4) {
        this.zza = z4;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, E e5) {
        zza();
        super.add(i5, e5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e5) {
        zza();
        return super.add(e5);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection<? extends E> collection) {
        zza();
        return super.addAll(i5, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        zza();
        return super.addAll(collection);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajg
    public final void b_() {
        if (this.zza) {
            this.zza = false;
        }
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
                if (size != list.size()) {
                    return false;
                }
                for (int i5 = 0; i5 < size; i5++) {
                    if (!get(i5).equals(list.get(i5))) {
                        return false;
                    }
                }
                return true;
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
    public E remove(int i5) {
        zza();
        return (E) super.remove(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        zza();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        zza();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        zza();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i5, E e5) {
        zza();
        return (E) super.set(i5, e5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajg
    public boolean zzc() {
        return this.zza;
    }
}
