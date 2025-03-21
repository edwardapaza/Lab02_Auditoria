package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajz  reason: invalid package */
/* loaded from: classes.dex */
final class zzajz extends zzahg<Long> implements zzakw, RandomAccess {
    private static final zzajz zza = new zzajz(new long[0], 0, false);
    private long[] zzb;
    private int zzc;

    zzajz() {
        this(new long[10], 0, true);
    }

    private zzajz(long[] jArr, int i5, boolean z4) {
        super(z4);
        this.zzb = jArr;
        this.zzc = i5;
    }

    private final String zzc(int i5) {
        int i6 = this.zzc;
        return "Index:" + i5 + ", Size:" + i6;
    }

    private final void zzd(int i5) {
        if (i5 < 0 || i5 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzc(i5));
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        long longValue = ((Long) obj).longValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzc(i5));
        }
        long[] jArr = this.zzb;
        if (i6 < jArr.length) {
            System.arraycopy(jArr, i5, jArr, i5 + 1, i6 - i5);
        } else {
            long[] jArr2 = new long[((i6 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            System.arraycopy(this.zzb, i5, jArr2, i5 + 1, this.zzc - i5);
            this.zzb = jArr2;
        }
        this.zzb[i5] = longValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Long) obj).longValue());
        return true;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zza();
        zzajc.zza(collection);
        if (collection instanceof zzajz) {
            zzajz zzajzVar = (zzajz) collection;
            int i5 = zzajzVar.zzc;
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
                System.arraycopy(zzajzVar.zzb, 0, this.zzb, this.zzc, zzajzVar.zzc);
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
        if (obj instanceof zzajz) {
            zzajz zzajzVar = (zzajz) obj;
            if (this.zzc != zzajzVar.zzc) {
                return false;
            }
            long[] jArr = zzajzVar.zzb;
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
        return Long.valueOf(zzb(i5));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            i5 = (i5 * 31) + zzajc.zza(this.zzb[i6]);
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.zzb[i5] == longValue) {
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
        zzd(i5);
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

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i5, Object obj) {
        long longValue = ((Long) obj).longValue();
        zza();
        zzd(i5);
        long[] jArr = this.zzb;
        long j5 = jArr[i5];
        jArr[i5] = longValue;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajg
    public final /* synthetic */ zzajg zza(int i5) {
        if (i5 >= this.zzc) {
            return new zzajz(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zza(long j5) {
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

    public final long zzb(int i5) {
        zzd(i5);
        return this.zzb[i5];
    }
}
