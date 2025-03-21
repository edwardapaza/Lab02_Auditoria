package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahk  reason: invalid package */
/* loaded from: classes.dex */
final class zzahk extends zzahg<Boolean> implements zzakw, RandomAccess {
    private static final zzahk zza = new zzahk(new boolean[0], 0, false);
    private boolean[] zzb;
    private int zzc;

    zzahk() {
        this(new boolean[10], 0, true);
    }

    private zzahk(boolean[] zArr, int i5, boolean z4) {
        super(z4);
        this.zzb = zArr;
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzb(i5));
        }
        boolean[] zArr = this.zzb;
        if (i6 < zArr.length) {
            System.arraycopy(zArr, i5, zArr, i5 + 1, i6 - i5);
        } else {
            boolean[] zArr2 = new boolean[((i6 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            System.arraycopy(this.zzb, i5, zArr2, i5 + 1, this.zzc - i5);
            this.zzb = zArr2;
        }
        this.zzb[i5] = booleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zza();
        zzajc.zza(collection);
        if (collection instanceof zzahk) {
            zzahk zzahkVar = (zzahk) collection;
            int i5 = zzahkVar.zzc;
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
                System.arraycopy(zzahkVar.zzb, 0, this.zzb, this.zzc, zzahkVar.zzc);
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
        if (obj instanceof zzahk) {
            zzahk zzahkVar = (zzahk) obj;
            if (this.zzc != zzahkVar.zzc) {
                return false;
            }
            boolean[] zArr = zzahkVar.zzb;
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
        zzc(i5);
        return Boolean.valueOf(this.zzb[i5]);
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
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.zzb[i5] == booleanValue) {
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

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i5, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzc(i5);
        boolean[] zArr = this.zzb;
        boolean z4 = zArr[i5];
        zArr[i5] = booleanValue;
        return Boolean.valueOf(z4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajg
    public final /* synthetic */ zzajg zza(int i5) {
        if (i5 >= this.zzc) {
            return new zzahk(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zza(boolean z4) {
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
