package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes.dex */
final class zzgl extends zzgh implements RandomAccess, zzkm {
    private static final zzgl zza = new zzgl(new boolean[0], 0, false);
    private boolean[] zzb;
    private int zzc;

    zzgl() {
        this(new boolean[10], 0, true);
    }

    private zzgl(boolean[] zArr, int i5, boolean z4) {
        super(z4);
        this.zzb = zArr;
        this.zzc = i5;
    }

    private final String zzf(int i5) {
        int i6 = this.zzc;
        return "Index:" + i5 + ", Size:" + i6;
    }

    private final void zzg(int i5) {
        if (i5 < 0 || i5 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i5));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i5));
        }
        int i7 = i5 + 1;
        boolean[] zArr = this.zzb;
        if (i6 < zArr.length) {
            System.arraycopy(zArr, i5, zArr, i7, i6 - i5);
        } else {
            boolean[] zArr2 = new boolean[((i6 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            System.arraycopy(this.zzb, i5, zArr2, i7, this.zzc - i5);
            this.zzb = zArr2;
        }
        this.zzb[i5] = booleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzjc.zzd;
        collection.getClass();
        if (collection instanceof zzgl) {
            zzgl zzglVar = (zzgl) collection;
            int i5 = zzglVar.zzc;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.zzc;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                boolean[] zArr = this.zzb;
                if (i7 > zArr.length) {
                    this.zzb = Arrays.copyOf(zArr, i7);
                }
                System.arraycopy(zzglVar.zzb, 0, this.zzb, this.zzc, zzglVar.zzc);
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
        if (obj instanceof zzgl) {
            zzgl zzglVar = (zzgl) obj;
            if (this.zzc != zzglVar.zzc) {
                return false;
            }
            boolean[] zArr = zzglVar.zzb;
            for (int i5 = 0; i5 < this.zzc; i5++) {
                if (this.zzb[i5] != zArr[i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        zzg(i5);
        return Boolean.valueOf(this.zzb[i5]);
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            i5 = (i5 * 31) + zzjc.zza(this.zzb[i6]);
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int i5 = this.zzc;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.zzb[i6] == booleanValue) {
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
        zzg(i5);
        boolean[] zArr = this.zzb;
        boolean z4 = zArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(zArr, i5 + 1, zArr, i5, (i6 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzb;
        System.arraycopy(zArr, i6, zArr, i5, this.zzc - i6);
        this.zzc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzg(i5);
        boolean[] zArr = this.zzb;
        boolean z4 = zArr[i5];
        zArr[i5] = booleanValue;
        return Boolean.valueOf(z4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzjb
    public final /* bridge */ /* synthetic */ zzjb zzd(int i5) {
        if (i5 >= this.zzc) {
            return new zzgl(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z4) {
        zza();
        int i5 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i5 == zArr.length) {
            boolean[] zArr2 = new boolean[((i5 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        zArr3[i6] = z4;
    }
}
