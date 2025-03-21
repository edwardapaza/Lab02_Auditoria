package com.google.protobuf;

import com.google.protobuf.d0;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
abstract class c<E> extends AbstractList<E> implements d0.i<E> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1867a = true;

    @Override // com.google.protobuf.d0.i
    public final void a() {
        this.f1867a = false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e5) {
        g();
        return super.add(e5);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection<? extends E> collection) {
        g();
        return super.addAll(i5, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        g();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        g();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            if (obj instanceof RandomAccess) {
                List list = (List) obj;
                int size = size();
                if (size != list.size()) {
                    return false;
                }
                for (int i5 = 0; i5 < size; i5++) {
                    if (!get(i5).equals(list.get(i5))) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        if (!this.f1867a) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = (i5 * 31) + get(i6).hashCode();
        }
        return i5;
    }

    @Override // com.google.protobuf.d0.i
    public boolean j() {
        return this.f1867a;
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract E remove(int i5);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        g();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        g();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        g();
        return super.retainAll(collection);
    }
}
