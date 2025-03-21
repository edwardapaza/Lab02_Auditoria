package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes.dex */
final class zzil extends zzgh implements RandomAccess, zzkm {
    private static final zzil zza = new zzil(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    zzil() {
        this(new float[10], 0, true);
    }

    private zzil(float[] fArr, int i5, boolean z4) {
        super(z4);
        this.zzb = fArr;
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
        float floatValue = ((Float) obj).floatValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i5));
        }
        int i7 = i5 + 1;
        float[] fArr = this.zzb;
        if (i6 < fArr.length) {
            System.arraycopy(fArr, i5, fArr, i7, i6 - i5);
        } else {
            float[] fArr2 = new float[((i6 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            System.arraycopy(this.zzb, i5, fArr2, i7, this.zzc - i5);
            this.zzb = fArr2;
        }
        this.zzb[i5] = floatValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Float) obj).floatValue());
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzjc.zzd;
        collection.getClass();
        if (collection instanceof zzil) {
            zzil zzilVar = (zzil) collection;
            int i5 = zzilVar.zzc;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.zzc;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                float[] fArr = this.zzb;
                if (i7 > fArr.length) {
                    this.zzb = Arrays.copyOf(fArr, i7);
                }
                System.arraycopy(zzilVar.zzb, 0, this.zzb, this.zzc, zzilVar.zzc);
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
        if (obj instanceof zzil) {
            zzil zzilVar = (zzil) obj;
            if (this.zzc != zzilVar.zzc) {
                return false;
            }
            float[] fArr = zzilVar.zzb;
            for (int i5 = 0; i5 < this.zzc; i5++) {
                if (Float.floatToIntBits(this.zzb[i5]) != Float.floatToIntBits(fArr[i5])) {
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
        return Float.valueOf(this.zzb[i5]);
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            i5 = (i5 * 31) + Float.floatToIntBits(this.zzb[i6]);
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            int i5 = this.zzc;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.zzb[i6] == floatValue) {
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
        float[] fArr = this.zzb;
        float f5 = fArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(fArr, i5 + 1, fArr, i5, (i6 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f5);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzb;
        System.arraycopy(fArr, i6, fArr, i5, this.zzc - i6);
        this.zzc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zza();
        zzg(i5);
        float[] fArr = this.zzb;
        float f5 = fArr[i5];
        fArr[i5] = floatValue;
        return Float.valueOf(f5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzjb
    public final /* bridge */ /* synthetic */ zzjb zzd(int i5) {
        if (i5 >= this.zzc) {
            return new zzil(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(float f5) {
        zza();
        int i5 = this.zzc;
        float[] fArr = this.zzb;
        if (i5 == fArr.length) {
            float[] fArr2 = new float[((i5 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        fArr3[i6] = f5;
    }
}
