package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiy  reason: invalid package */
/* loaded from: classes.dex */
final class zzaiy extends zzahg<Float> implements zzakw, RandomAccess {
    private static final zzaiy zza = new zzaiy(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    zzaiy() {
        this(new float[10], 0, true);
    }

    private zzaiy(float[] fArr, int i5, boolean z4) {
        super(z4);
        this.zzb = fArr;
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

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        float floatValue = ((Float) obj).floatValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzb(i5));
        }
        float[] fArr = this.zzb;
        if (i6 < fArr.length) {
            System.arraycopy(fArr, i5, fArr, i5 + 1, i6 - i5);
        } else {
            float[] fArr2 = new float[((i6 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            System.arraycopy(this.zzb, i5, fArr2, i5 + 1, this.zzc - i5);
            this.zzb = fArr2;
        }
        this.zzb[i5] = floatValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Float) obj).floatValue());
        return true;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zza();
        zzajc.zza(collection);
        if (collection instanceof zzaiy) {
            zzaiy zzaiyVar = (zzaiy) collection;
            int i5 = zzaiyVar.zzc;
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
                System.arraycopy(zzaiyVar.zzb, 0, this.zzb, this.zzc, zzaiyVar.zzc);
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
        if (obj instanceof zzaiy) {
            zzaiy zzaiyVar = (zzaiy) obj;
            if (this.zzc != zzaiyVar.zzc) {
                return false;
            }
            float[] fArr = zzaiyVar.zzb;
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
        zzc(i5);
        return Float.valueOf(this.zzb[i5]);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.Collection, java.util.List
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
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.zzb[i5] == floatValue) {
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
        zzc(i5);
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

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i5, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zza();
        zzc(i5);
        float[] fArr = this.zzb;
        float f5 = fArr[i5];
        fArr[i5] = floatValue;
        return Float.valueOf(f5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajg
    public final /* synthetic */ zzajg zza(int i5) {
        if (i5 >= this.zzc) {
            return new zzaiy(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zza(float f5) {
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
