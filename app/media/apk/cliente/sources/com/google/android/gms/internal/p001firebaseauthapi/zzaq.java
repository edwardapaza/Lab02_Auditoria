package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzaq<E> extends zzal<E> implements List<E>, RandomAccess {
    private static final zzbg<Object> zza = new zzas(zzay.zza, 0);

    public static <E> zzaq<E> zza(E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12) {
        return zzb(e5, e6, e7, e8, e9, e10, e11, e12);
    }

    public static <E> zzaq<E> zza(Collection<? extends E> collection) {
        if (collection instanceof zzal) {
            zzaq<E> zzc = ((zzal) collection).zzc();
            if (zzc.zze()) {
                Object[] array = zzc.toArray();
                return zzb(array, array.length);
            }
            return zzc;
        }
        return zzb(collection.toArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> zzaq<E> zza(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    private static <E> zzaq<E> zzb(Object... objArr) {
        int length = objArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (objArr[i5] == null) {
                throw new NullPointerException("at index " + i5);
            }
        }
        return zzb(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> zzaq<E> zzb(Object[] objArr, int i5) {
        return i5 == 0 ? (zzaq<E>) zzay.zza : new zzay(objArr, i5);
    }

    public static <E> zzap<E> zzg() {
        return new zzap<>();
    }

    public static <E> zzaq<E> zzh() {
        return (zzaq<E>) zzay.zza;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i5, E e5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i5, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == zzz.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i5 = 0; i5 < size; i5++) {
                        if (zzw.zza(get(i5), list.get(i5))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i6 = 0;
                while (true) {
                    if (i6 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e5 = get(i6);
                        i6++;
                        if (!zzw.zza(e5, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = ~(~((i5 * 31) + get(i6).hashCode()));
        }
        return i5;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (obj.equals(get(i5))) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzbg) listIterator(0);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i5) {
        zzz.zzb(i5, size());
        return isEmpty() ? zza : new zzas(this, i5);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i5, E e5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    int zza(Object[] objArr, int i5) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i5 + i6] = get(i6);
        }
        return i5 + size;
    }

    @Override // java.util.List
    /* renamed from: zza */
    public zzaq<E> subList(int i5, int i6) {
        zzz.zza(i5, i6, size());
        int i7 = i6 - i5;
        return i7 == size() ? this : i7 == 0 ? (zzaq<E>) zzay.zza : new zzar(this, i5, i7);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    @Deprecated
    public final zzaq<E> zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzal
    public final zzbd<E> zzd() {
        return (zzbg) listIterator();
    }
}
