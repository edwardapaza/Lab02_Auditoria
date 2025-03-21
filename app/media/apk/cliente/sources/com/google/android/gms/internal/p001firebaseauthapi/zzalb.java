package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalb  reason: invalid package */
/* loaded from: classes.dex */
final class zzalb<E> extends zzahg<E> implements RandomAccess {
    private static final zzalb<Object> zza = new zzalb<>(new Object[0], 0, false);
    private E[] zzb;
    private int zzc;

    zzalb() {
        this(new Object[10], 0, true);
    }

    private zzalb(E[] eArr, int i5, boolean z4) {
        super(z4);
        this.zzb = eArr;
        this.zzc = i5;
    }

    private final String zzb(int i5) {
        int i6 = this.zzc;
        return "Index:" + i5 + ", Size:" + i6;
    }

    private final void zzc(int i5) {
        if (i5 < 0 || i5 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzb(i5));
        }
    }

    public static <E> zzalb<E> zzd() {
        return (zzalb<E>) zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final void add(int i5, E e5) {
        int i6;
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzb(i5));
        }
        E[] eArr = this.zzb;
        if (i6 < eArr.length) {
            System.arraycopy(eArr, i5, eArr, i5 + 1, i6 - i5);
        } else {
            E[] eArr2 = (E[]) new Object[((i6 * 3) / 2) + 1];
            System.arraycopy(eArr, 0, eArr2, 0, i5);
            System.arraycopy(this.zzb, i5, eArr2, i5 + 1, this.zzc - i5);
            this.zzb = eArr2;
        }
        this.zzb[i5] = e5;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e5) {
        zza();
        int i5 = this.zzc;
        E[] eArr = this.zzb;
        if (i5 == eArr.length) {
            this.zzb = (E[]) Arrays.copyOf(eArr, ((i5 * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        eArr2[i6] = e5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i5) {
        zzc(i5);
        return this.zzb[i5];
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final E remove(int i5) {
        int i6;
        zza();
        zzc(i5);
        E[] eArr = this.zzb;
        E e5 = eArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(eArr, i5 + 1, eArr, i5, (i6 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return e5;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final E set(int i5, E e5) {
        zza();
        zzc(i5);
        E[] eArr = this.zzb;
        E e6 = eArr[i5];
        eArr[i5] = e5;
        ((AbstractList) this).modCount++;
        return e6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajg
    public final /* synthetic */ zzajg zza(int i5) {
        if (i5 >= this.zzc) {
            return new zzalb(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }
}
