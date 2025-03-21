package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes.dex */
final class zzhy extends zzgh implements RandomAccess, zzkm {
    private static final zzhy zza = new zzhy(new double[0], 0, false);
    private double[] zzb;
    private int zzc;

    zzhy() {
        this(new double[10], 0, true);
    }

    private zzhy(double[] dArr, int i5, boolean z4) {
        super(z4);
        this.zzb = dArr;
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
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i5));
        }
        int i7 = i5 + 1;
        double[] dArr = this.zzb;
        if (i6 < dArr.length) {
            System.arraycopy(dArr, i5, dArr, i7, i6 - i5);
        } else {
            double[] dArr2 = new double[((i6 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            System.arraycopy(this.zzb, i5, dArr2, i7, this.zzc - i5);
            this.zzb = dArr2;
        }
        this.zzb[i5] = doubleValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzjc.zzd;
        collection.getClass();
        if (collection instanceof zzhy) {
            zzhy zzhyVar = (zzhy) collection;
            int i5 = zzhyVar.zzc;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.zzc;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                double[] dArr = this.zzb;
                if (i7 > dArr.length) {
                    this.zzb = Arrays.copyOf(dArr, i7);
                }
                System.arraycopy(zzhyVar.zzb, 0, this.zzb, this.zzc, zzhyVar.zzc);
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
        if (obj instanceof zzhy) {
            zzhy zzhyVar = (zzhy) obj;
            if (this.zzc != zzhyVar.zzc) {
                return false;
            }
            double[] dArr = zzhyVar.zzb;
            for (int i5 = 0; i5 < this.zzc; i5++) {
                if (Double.doubleToLongBits(this.zzb[i5]) != Double.doubleToLongBits(dArr[i5])) {
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
        return Double.valueOf(this.zzb[i5]);
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            long doubleToLongBits = Double.doubleToLongBits(this.zzb[i6]);
            byte[] bArr = zzjc.zzd;
            i5 = (i5 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            int i5 = this.zzc;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.zzb[i6] == doubleValue) {
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
        double[] dArr = this.zzb;
        double d5 = dArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(dArr, i5 + 1, dArr, i5, (i6 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d5);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzb;
        System.arraycopy(dArr, i6, dArr, i5, this.zzc - i6);
        this.zzc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        zzg(i5);
        double[] dArr = this.zzb;
        double d5 = dArr[i5];
        dArr[i5] = doubleValue;
        return Double.valueOf(d5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzjb
    public final /* bridge */ /* synthetic */ zzjb zzd(int i5) {
        if (i5 >= this.zzc) {
            return new zzhy(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(double d5) {
        zza();
        int i5 = this.zzc;
        double[] dArr = this.zzb;
        if (i5 == dArr.length) {
            double[] dArr2 = new double[((i5 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        dArr3[i6] = d5;
    }
}
