package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.d0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c0 extends c<Integer> implements d0.g, RandomAccess, h1 {

    /* renamed from: d  reason: collision with root package name */
    private static final c0 f1868d;

    /* renamed from: b  reason: collision with root package name */
    private int[] f1869b;

    /* renamed from: c  reason: collision with root package name */
    private int f1870c;

    static {
        c0 c0Var = new c0(new int[0], 0);
        f1868d = c0Var;
        c0Var.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0() {
        this(new int[10], 0);
    }

    private c0(int[] iArr, int i5) {
        this.f1869b = iArr;
        this.f1870c = i5;
    }

    private void l(int i5, int i6) {
        int i7;
        g();
        if (i5 < 0 || i5 > (i7 = this.f1870c)) {
            throw new IndexOutOfBoundsException(q(i5));
        }
        int[] iArr = this.f1869b;
        if (i7 < iArr.length) {
            System.arraycopy(iArr, i5, iArr, i5 + 1, i7 - i5);
        } else {
            int[] iArr2 = new int[((i7 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(this.f1869b, i5, iArr2, i5 + 1, this.f1870c - i5);
            this.f1869b = iArr2;
        }
        this.f1869b[i5] = i6;
        this.f1870c++;
        ((AbstractList) this).modCount++;
    }

    public static c0 m() {
        return f1868d;
    }

    private void n(int i5) {
        if (i5 < 0 || i5 >= this.f1870c) {
            throw new IndexOutOfBoundsException(q(i5));
        }
    }

    private String q(int i5) {
        return "Index:" + i5 + ", Size:" + this.f1870c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        g();
        d0.a(collection);
        if (collection instanceof c0) {
            c0 c0Var = (c0) collection;
            int i5 = c0Var.f1870c;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.f1870c;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                int[] iArr = this.f1869b;
                if (i7 > iArr.length) {
                    this.f1869b = Arrays.copyOf(iArr, i7);
                }
                System.arraycopy(c0Var.f1869b, 0, this.f1869b, this.f1870c, c0Var.f1870c);
                this.f1870c = i7;
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
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (this.f1870c != c0Var.f1870c) {
                return false;
            }
            int[] iArr = c0Var.f1869b;
            for (int i5 = 0; i5 < this.f1870c; i5++) {
                if (this.f1869b[i5] != iArr[i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public void add(int i5, Integer num) {
        l(i5, num.intValue());
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f1870c; i6++) {
            i5 = (i5 * 31) + this.f1869b[i6];
        }
        return i5;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i */
    public boolean add(Integer num) {
        k(num.intValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f1869b[i5] == intValue) {
                    return i5;
                }
            }
            return -1;
        }
        return -1;
    }

    public void k(int i5) {
        g();
        int i6 = this.f1870c;
        int[] iArr = this.f1869b;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[((i6 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.f1869b = iArr2;
        }
        int[] iArr3 = this.f1869b;
        int i7 = this.f1870c;
        this.f1870c = i7 + 1;
        iArr3[i7] = i5;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: o */
    public Integer get(int i5) {
        return Integer.valueOf(p(i5));
    }

    public int p(int i5) {
        n(i5);
        return this.f1869b[i5];
    }

    @Override // com.google.protobuf.d0.i
    /* renamed from: r */
    public d0.g b(int i5) {
        if (i5 >= this.f1870c) {
            return new c0(Arrays.copyOf(this.f1869b, i5), this.f1870c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        g();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f1869b;
        System.arraycopy(iArr, i6, iArr, i5, this.f1870c - i6);
        this.f1870c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* renamed from: s */
    public Integer remove(int i5) {
        int i6;
        g();
        n(i5);
        int[] iArr = this.f1869b;
        int i7 = iArr[i5];
        if (i5 < this.f1870c - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (i6 - i5) - 1);
        }
        this.f1870c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1870c;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: t */
    public Integer set(int i5, Integer num) {
        return Integer.valueOf(u(i5, num.intValue()));
    }

    public int u(int i5, int i6) {
        g();
        n(i5);
        int[] iArr = this.f1869b;
        int i7 = iArr[i5];
        iArr[i5] = i6;
        return i7;
    }
}
