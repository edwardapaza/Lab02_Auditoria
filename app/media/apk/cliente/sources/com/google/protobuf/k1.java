package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k1<E> extends c<E> implements RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    private static final k1<Object> f2044d;

    /* renamed from: b  reason: collision with root package name */
    private E[] f2045b;

    /* renamed from: c  reason: collision with root package name */
    private int f2046c;

    static {
        k1<Object> k1Var = new k1<>(new Object[0], 0);
        f2044d = k1Var;
        k1Var.a();
    }

    private k1(E[] eArr, int i5) {
        this.f2045b = eArr;
        this.f2046c = i5;
    }

    private static <E> E[] h(int i5) {
        return (E[]) new Object[i5];
    }

    public static <E> k1<E> i() {
        return (k1<E>) f2044d;
    }

    private void k(int i5) {
        if (i5 < 0 || i5 >= this.f2046c) {
            throw new IndexOutOfBoundsException(l(i5));
        }
    }

    private String l(int i5) {
        return "Index:" + i5 + ", Size:" + this.f2046c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, E e5) {
        int i6;
        g();
        if (i5 < 0 || i5 > (i6 = this.f2046c)) {
            throw new IndexOutOfBoundsException(l(i5));
        }
        E[] eArr = this.f2045b;
        if (i6 < eArr.length) {
            System.arraycopy(eArr, i5, eArr, i5 + 1, i6 - i5);
        } else {
            E[] eArr2 = (E[]) h(((i6 * 3) / 2) + 1);
            System.arraycopy(this.f2045b, 0, eArr2, 0, i5);
            System.arraycopy(this.f2045b, i5, eArr2, i5 + 1, this.f2046c - i5);
            this.f2045b = eArr2;
        }
        this.f2045b[i5] = e5;
        this.f2046c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e5) {
        g();
        int i5 = this.f2046c;
        E[] eArr = this.f2045b;
        if (i5 == eArr.length) {
            this.f2045b = (E[]) Arrays.copyOf(eArr, ((i5 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f2045b;
        int i6 = this.f2046c;
        this.f2046c = i6 + 1;
        eArr2[i6] = e5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i5) {
        k(i5);
        return this.f2045b[i5];
    }

    @Override // com.google.protobuf.d0.i
    /* renamed from: m */
    public k1<E> b(int i5) {
        if (i5 >= this.f2046c) {
            return new k1<>(Arrays.copyOf(this.f2045b, i5), this.f2046c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    public E remove(int i5) {
        int i6;
        g();
        k(i5);
        E[] eArr = this.f2045b;
        E e5 = eArr[i5];
        if (i5 < this.f2046c - 1) {
            System.arraycopy(eArr, i5 + 1, eArr, i5, (i6 - i5) - 1);
        }
        this.f2046c--;
        ((AbstractList) this).modCount++;
        return e5;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i5, E e5) {
        g();
        k(i5);
        E[] eArr = this.f2045b;
        E e6 = eArr[i5];
        eArr[i5] = e5;
        ((AbstractList) this).modCount++;
        return e6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2046c;
    }
}
