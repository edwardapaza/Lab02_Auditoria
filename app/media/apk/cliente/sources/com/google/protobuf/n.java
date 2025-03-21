package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.d0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends c<Double> implements d0.b, RandomAccess, h1 {

    /* renamed from: d  reason: collision with root package name */
    private static final n f2069d;

    /* renamed from: b  reason: collision with root package name */
    private double[] f2070b;

    /* renamed from: c  reason: collision with root package name */
    private int f2071c;

    static {
        n nVar = new n(new double[0], 0);
        f2069d = nVar;
        nVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n() {
        this(new double[10], 0);
    }

    private n(double[] dArr, int i5) {
        this.f2070b = dArr;
        this.f2071c = i5;
    }

    private void l(int i5, double d5) {
        int i6;
        g();
        if (i5 < 0 || i5 > (i6 = this.f2071c)) {
            throw new IndexOutOfBoundsException(p(i5));
        }
        double[] dArr = this.f2070b;
        if (i6 < dArr.length) {
            System.arraycopy(dArr, i5, dArr, i5 + 1, i6 - i5);
        } else {
            double[] dArr2 = new double[((i6 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            System.arraycopy(this.f2070b, i5, dArr2, i5 + 1, this.f2071c - i5);
            this.f2070b = dArr2;
        }
        this.f2070b[i5] = d5;
        this.f2071c++;
        ((AbstractList) this).modCount++;
    }

    private void m(int i5) {
        if (i5 < 0 || i5 >= this.f2071c) {
            throw new IndexOutOfBoundsException(p(i5));
        }
    }

    private String p(int i5) {
        return "Index:" + i5 + ", Size:" + this.f2071c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        g();
        d0.a(collection);
        if (collection instanceof n) {
            n nVar = (n) collection;
            int i5 = nVar.f2071c;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.f2071c;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                double[] dArr = this.f2070b;
                if (i7 > dArr.length) {
                    this.f2070b = Arrays.copyOf(dArr, i7);
                }
                System.arraycopy(nVar.f2070b, 0, this.f2070b, this.f2071c, nVar.f2071c);
                this.f2071c = i7;
                ((AbstractList) this).modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.f2071c != nVar.f2071c) {
                return false;
            }
            double[] dArr = nVar.f2070b;
            for (int i5 = 0; i5 < this.f2071c; i5++) {
                if (Double.doubleToLongBits(this.f2070b[i5]) != Double.doubleToLongBits(dArr[i5])) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public void add(int i5, Double d5) {
        l(i5, d5.doubleValue());
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f2071c; i6++) {
            i5 = (i5 * 31) + d0.f(Double.doubleToLongBits(this.f2070b[i6]));
        }
        return i5;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i */
    public boolean add(Double d5) {
        k(d5.doubleValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f2070b[i5] == doubleValue) {
                    return i5;
                }
            }
            return -1;
        }
        return -1;
    }

    public void k(double d5) {
        g();
        int i5 = this.f2071c;
        double[] dArr = this.f2070b;
        if (i5 == dArr.length) {
            double[] dArr2 = new double[((i5 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            this.f2070b = dArr2;
        }
        double[] dArr3 = this.f2070b;
        int i6 = this.f2071c;
        this.f2071c = i6 + 1;
        dArr3[i6] = d5;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n */
    public Double get(int i5) {
        return Double.valueOf(o(i5));
    }

    public double o(int i5) {
        m(i5);
        return this.f2070b[i5];
    }

    @Override // com.google.protobuf.d0.i
    /* renamed from: q */
    public d0.b b(int i5) {
        if (i5 >= this.f2071c) {
            return new n(Arrays.copyOf(this.f2070b, i5), this.f2071c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* renamed from: r */
    public Double remove(int i5) {
        int i6;
        g();
        m(i5);
        double[] dArr = this.f2070b;
        double d5 = dArr[i5];
        if (i5 < this.f2071c - 1) {
            System.arraycopy(dArr, i5 + 1, dArr, i5, (i6 - i5) - 1);
        }
        this.f2071c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d5);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        g();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f2070b;
        System.arraycopy(dArr, i6, dArr, i5, this.f2071c - i6);
        this.f2071c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s */
    public Double set(int i5, Double d5) {
        return Double.valueOf(t(i5, d5.doubleValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2071c;
    }

    public double t(int i5, double d5) {
        g();
        m(i5);
        double[] dArr = this.f2070b;
        double d6 = dArr[i5];
        dArr[i5] = d5;
        return d6;
    }
}
