package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.d0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n0 extends c<Long> implements d0.h, RandomAccess, h1 {

    /* renamed from: d  reason: collision with root package name */
    private static final n0 f2072d;

    /* renamed from: b  reason: collision with root package name */
    private long[] f2073b;

    /* renamed from: c  reason: collision with root package name */
    private int f2074c;

    static {
        n0 n0Var = new n0(new long[0], 0);
        f2072d = n0Var;
        n0Var.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0() {
        this(new long[10], 0);
    }

    private n0(long[] jArr, int i5) {
        this.f2073b = jArr;
        this.f2074c = i5;
    }

    private void k(int i5, long j5) {
        int i6;
        g();
        if (i5 < 0 || i5 > (i6 = this.f2074c)) {
            throw new IndexOutOfBoundsException(p(i5));
        }
        long[] jArr = this.f2073b;
        if (i6 < jArr.length) {
            System.arraycopy(jArr, i5, jArr, i5 + 1, i6 - i5);
        } else {
            long[] jArr2 = new long[((i6 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            System.arraycopy(this.f2073b, i5, jArr2, i5 + 1, this.f2074c - i5);
            this.f2073b = jArr2;
        }
        this.f2073b[i5] = j5;
        this.f2074c++;
        ((AbstractList) this).modCount++;
    }

    private void m(int i5) {
        if (i5 < 0 || i5 >= this.f2074c) {
            throw new IndexOutOfBoundsException(p(i5));
        }
    }

    private String p(int i5) {
        return "Index:" + i5 + ", Size:" + this.f2074c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        g();
        d0.a(collection);
        if (collection instanceof n0) {
            n0 n0Var = (n0) collection;
            int i5 = n0Var.f2074c;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.f2074c;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                long[] jArr = this.f2073b;
                if (i7 > jArr.length) {
                    this.f2073b = Arrays.copyOf(jArr, i7);
                }
                System.arraycopy(n0Var.f2073b, 0, this.f2073b, this.f2074c, n0Var.f2074c);
                this.f2074c = i7;
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
        if (obj instanceof n0) {
            n0 n0Var = (n0) obj;
            if (this.f2074c != n0Var.f2074c) {
                return false;
            }
            long[] jArr = n0Var.f2073b;
            for (int i5 = 0; i5 < this.f2074c; i5++) {
                if (this.f2073b[i5] != jArr[i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public void add(int i5, Long l5) {
        k(i5, l5.longValue());
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f2074c; i6++) {
            i5 = (i5 * 31) + d0.f(this.f2073b[i6]);
        }
        return i5;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i */
    public boolean add(Long l5) {
        l(l5.longValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f2073b[i5] == longValue) {
                    return i5;
                }
            }
            return -1;
        }
        return -1;
    }

    public void l(long j5) {
        g();
        int i5 = this.f2074c;
        long[] jArr = this.f2073b;
        if (i5 == jArr.length) {
            long[] jArr2 = new long[((i5 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            this.f2073b = jArr2;
        }
        long[] jArr3 = this.f2073b;
        int i6 = this.f2074c;
        this.f2074c = i6 + 1;
        jArr3[i6] = j5;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n */
    public Long get(int i5) {
        return Long.valueOf(o(i5));
    }

    public long o(int i5) {
        m(i5);
        return this.f2073b[i5];
    }

    @Override // com.google.protobuf.d0.i
    /* renamed from: q */
    public d0.h b(int i5) {
        if (i5 >= this.f2074c) {
            return new n0(Arrays.copyOf(this.f2073b, i5), this.f2074c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* renamed from: r */
    public Long remove(int i5) {
        int i6;
        g();
        m(i5);
        long[] jArr = this.f2073b;
        long j5 = jArr[i5];
        if (i5 < this.f2074c - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (i6 - i5) - 1);
        }
        this.f2074c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        g();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f2073b;
        System.arraycopy(jArr, i6, jArr, i5, this.f2074c - i6);
        this.f2074c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s */
    public Long set(int i5, Long l5) {
        return Long.valueOf(t(i5, l5.longValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2074c;
    }

    public long t(int i5, long j5) {
        g();
        m(i5);
        long[] jArr = this.f2073b;
        long j6 = jArr[i5];
        jArr[i5] = j5;
        return j6;
    }
}
