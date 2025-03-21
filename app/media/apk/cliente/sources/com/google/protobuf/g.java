package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.d0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends c<Boolean> implements d0.a, RandomAccess, h1 {

    /* renamed from: d  reason: collision with root package name */
    private static final g f1944d;

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f1945b;

    /* renamed from: c  reason: collision with root package name */
    private int f1946c;

    static {
        g gVar = new g(new boolean[0], 0);
        f1944d = gVar;
        gVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        this(new boolean[10], 0);
    }

    private g(boolean[] zArr, int i5) {
        this.f1945b = zArr;
        this.f1946c = i5;
    }

    private void k(int i5, boolean z4) {
        int i6;
        g();
        if (i5 < 0 || i5 > (i6 = this.f1946c)) {
            throw new IndexOutOfBoundsException(p(i5));
        }
        boolean[] zArr = this.f1945b;
        if (i6 < zArr.length) {
            System.arraycopy(zArr, i5, zArr, i5 + 1, i6 - i5);
        } else {
            boolean[] zArr2 = new boolean[((i6 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            System.arraycopy(this.f1945b, i5, zArr2, i5 + 1, this.f1946c - i5);
            this.f1945b = zArr2;
        }
        this.f1945b[i5] = z4;
        this.f1946c++;
        ((AbstractList) this).modCount++;
    }

    private void m(int i5) {
        if (i5 < 0 || i5 >= this.f1946c) {
            throw new IndexOutOfBoundsException(p(i5));
        }
    }

    private String p(int i5) {
        return "Index:" + i5 + ", Size:" + this.f1946c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        g();
        d0.a(collection);
        if (collection instanceof g) {
            g gVar = (g) collection;
            int i5 = gVar.f1946c;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.f1946c;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                boolean[] zArr = this.f1945b;
                if (i7 > zArr.length) {
                    this.f1945b = Arrays.copyOf(zArr, i7);
                }
                System.arraycopy(gVar.f1945b, 0, this.f1945b, this.f1946c, gVar.f1946c);
                this.f1946c = i7;
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
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f1946c != gVar.f1946c) {
                return false;
            }
            boolean[] zArr = gVar.f1945b;
            for (int i5 = 0; i5 < this.f1946c; i5++) {
                if (this.f1945b[i5] != zArr[i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public void add(int i5, Boolean bool) {
        k(i5, bool.booleanValue());
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f1946c; i6++) {
            i5 = (i5 * 31) + d0.c(this.f1945b[i6]);
        }
        return i5;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i */
    public boolean add(Boolean bool) {
        l(bool.booleanValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f1945b[i5] == booleanValue) {
                    return i5;
                }
            }
            return -1;
        }
        return -1;
    }

    public void l(boolean z4) {
        g();
        int i5 = this.f1946c;
        boolean[] zArr = this.f1945b;
        if (i5 == zArr.length) {
            boolean[] zArr2 = new boolean[((i5 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            this.f1945b = zArr2;
        }
        boolean[] zArr3 = this.f1945b;
        int i6 = this.f1946c;
        this.f1946c = i6 + 1;
        zArr3[i6] = z4;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n */
    public Boolean get(int i5) {
        return Boolean.valueOf(o(i5));
    }

    public boolean o(int i5) {
        m(i5);
        return this.f1945b[i5];
    }

    @Override // com.google.protobuf.d0.i
    /* renamed from: q */
    public d0.a b(int i5) {
        if (i5 >= this.f1946c) {
            return new g(Arrays.copyOf(this.f1945b, i5), this.f1946c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* renamed from: r */
    public Boolean remove(int i5) {
        int i6;
        g();
        m(i5);
        boolean[] zArr = this.f1945b;
        boolean z4 = zArr[i5];
        if (i5 < this.f1946c - 1) {
            System.arraycopy(zArr, i5 + 1, zArr, i5, (i6 - i5) - 1);
        }
        this.f1946c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z4);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        g();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f1945b;
        System.arraycopy(zArr, i6, zArr, i5, this.f1946c - i6);
        this.f1946c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s */
    public Boolean set(int i5, Boolean bool) {
        return Boolean.valueOf(t(i5, bool.booleanValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1946c;
    }

    public boolean t(int i5, boolean z4) {
        g();
        m(i5);
        boolean[] zArr = this.f1945b;
        boolean z5 = zArr[i5];
        zArr[i5] = z4;
        return z5;
    }
}
