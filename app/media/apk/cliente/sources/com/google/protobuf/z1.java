package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
@Deprecated
/* loaded from: classes.dex */
public class z1 extends AbstractList<String> implements l0, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final l0 f2240a;

    /* loaded from: classes.dex */
    class a implements ListIterator<String> {

        /* renamed from: a  reason: collision with root package name */
        ListIterator<String> f2241a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2242b;

        a(int i5) {
            this.f2242b = i5;
            this.f2241a = z1.this.f2240a.listIterator(i5);
        }

        @Override // java.util.ListIterator
        /* renamed from: b */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c */
        public String next() {
            return this.f2241a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: d */
        public String previous() {
            return this.f2241a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: e */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f2241a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f2241a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2241a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2241a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    class b implements Iterator<String> {

        /* renamed from: a  reason: collision with root package name */
        Iterator<String> f2244a;

        b() {
            this.f2244a = z1.this.f2240a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public String next() {
            return this.f2244a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2244a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public z1(l0 l0Var) {
        this.f2240a = l0Var;
    }

    @Override // com.google.protobuf.l0
    public void c(i iVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.l0
    public l0 d() {
        return this;
    }

    @Override // com.google.protobuf.l0
    public Object e(int i5) {
        return this.f2240a.e(i5);
    }

    @Override // com.google.protobuf.l0
    public List<?> f() {
        return this.f2240a.f();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public String get(int i5) {
        return (String) this.f2240a.get(i5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i5) {
        return new a(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2240a.size();
    }
}
