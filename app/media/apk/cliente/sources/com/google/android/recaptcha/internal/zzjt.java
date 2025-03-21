package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes.dex */
final class zzjt extends zzgh implements RandomAccess, zzja, zzkm {
    private static final zzjt zza = new zzjt(new long[0], 0, false);
    private long[] zzb;
    private int zzc;

    zzjt() {
        this(new long[10], 0, true);
    }

    private zzjt(long[] jArr, int i5, boolean z4) {
        super(z4);
        this.zzb = jArr;
        this.zzc = i5;
    }

    public static zzjt zzf() {
        return zza;
    }

    private final String zzh(int i5) {
        int i6 = this.zzc;
        return "Index:" + i5 + ", Size:" + i6;
    }

    private final void zzi(int i5) {
        if (i5 < 0 || i5 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i5));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        long longValue = ((Long) obj).longValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i5));
        }
        int i7 = i5 + 1;
        long[] jArr = this.zzb;
        if (i6 < jArr.length) {
            System.arraycopy(jArr, i5, jArr, i7, i6 - i5);
        } else {
            long[] jArr2 = new long[((i6 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            System.arraycopy(this.zzb, i5, jArr2, i7, this.zzc - i5);
            this.zzb = jArr2;
        }
        this.zzb[i5] = longValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Long) obj).longValue());
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzjc.zzd;
        collection.getClass();
        if (collection instanceof zzjt) {
            zzjt zzjtVar = (zzjt) collection;
            int i5 = zzjtVar.zzc;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.zzc;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                long[] jArr = this.zzb;
                if (i7 > jArr.length) {
                    this.zzb = Arrays.copyOf(jArr, i7);
                }
                System.arraycopy(zzjtVar.zzb, 0, this.zzb, this.zzc, zzjtVar.zzc);
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

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjt) {
            zzjt zzjtVar = (zzjt) obj;
            if (this.zzc != zzjtVar.zzc) {
                return false;
            }
            long[] jArr = zzjtVar.zzb;
            for (int i5 = 0; i5 < this.zzc; i5++) {
                if (this.zzb[i5] != jArr[i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        zzi(i5);
        return Long.valueOf(this.zzb[i5]);
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            long j5 = this.zzb[i6];
            byte[] bArr = zzjc.zzd;
            i5 = (i5 * 31) + ((int) (j5 ^ (j5 >>> 32)));
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            int i5 = this.zzc;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.zzb[i6] == longValue) {
                    return i6;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        int i6;
        zza();
        zzi(i5);
        long[] jArr = this.zzb;
        long j5 = jArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (i6 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzb;
        System.arraycopy(jArr, i6, jArr, i5, this.zzc - i6);
        this.zzc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        long longValue = ((Long) obj).longValue();
        zza();
        zzi(i5);
        long[] jArr = this.zzb;
        long j5 = jArr[i5];
        jArr[i5] = longValue;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzjb
    public final /* bridge */ /* synthetic */ zzjb zzd(int i5) {
        if (i5 >= this.zzc) {
            return new zzjt(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i5) {
        zzi(i5);
        return this.zzb[i5];
    }

    public final void zzg(long j5) {
        zza();
        int i5 = this.zzc;
        long[] jArr = this.zzb;
        if (i5 == jArr.length) {
            long[] jArr2 = new long[((i5 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        jArr3[i6] = j5;
    }
}
