package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajd  reason: invalid package */
/* loaded from: classes.dex */
final class zzajd extends zzahg<Integer> implements zzakw, RandomAccess {
    private static final zzajd zza = new zzajd(new int[0], 0, false);
    private int[] zzb;
    private int zzc;

    zzajd() {
        this(new int[10], 0, true);
    }

    private zzajd(int[] iArr, int i5, boolean z4) {
        super(z4);
        this.zzb = iArr;
        this.zzc = i5;
    }

    private final String zzd(int i5) {
        int i6 = this.zzc;
        return "Index:" + i5 + ", Size:" + i6;
    }

    private final void zze(int i5) {
        if (i5 < 0 || i5 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzd(i5));
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        int intValue = ((Integer) obj).intValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzd(i5));
        }
        int[] iArr = this.zzb;
        if (i6 < iArr.length) {
            System.arraycopy(iArr, i5, iArr, i5 + 1, i6 - i5);
        } else {
            int[] iArr2 = new int[((i6 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(this.zzb, i5, iArr2, i5 + 1, this.zzc - i5);
            this.zzb = iArr2;
        }
        this.zzb[i5] = intValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzc(((Integer) obj).intValue());
        return true;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zza();
        zzajc.zza(collection);
        if (collection instanceof zzajd) {
            zzajd zzajdVar = (zzajd) collection;
            int i5 = zzajdVar.zzc;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.zzc;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                int[] iArr = this.zzb;
                if (i7 > iArr.length) {
                    this.zzb = Arrays.copyOf(iArr, i7);
                }
                System.arraycopy(zzajdVar.zzb, 0, this.zzb, this.zzc, zzajdVar.zzc);
                this.zzc = i7;
                ((AbstractList) this).modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzajd) {
            zzajd zzajdVar = (zzajd) obj;
            if (this.zzc != zzajdVar.zzc) {
                return false;
            }
            int[] iArr = zzajdVar.zzb;
            for (int i5 = 0; i5 < this.zzc; i5++) {
                if (this.zzb[i5] != iArr[i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        return Integer.valueOf(zzb(i5));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            i5 = (i5 * 31) + this.zzb[i6];
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.zzb[i5] == intValue) {
                    return i5;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i5) {
        int i6;
        zza();
        zze(i5);
        int[] iArr = this.zzb;
        int i7 = iArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (i6 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i7);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzb;
        System.arraycopy(iArr, i6, iArr, i5, this.zzc - i6);
        this.zzc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i5, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zza();
        zze(i5);
        int[] iArr = this.zzb;
        int i6 = iArr[i5];
        iArr[i5] = intValue;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajg
    public final /* synthetic */ zzajg zza(int i5) {
        if (i5 >= this.zzc) {
            return new zzajd(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zzb(int i5) {
        zze(i5);
        return this.zzb[i5];
    }

    public final void zzc(int i5) {
        zza();
        int i6 = this.zzc;
        int[] iArr = this.zzb;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[((i6 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        iArr3[i7] = i5;
    }
}
