package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public class k0 extends c<String> implements l0, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    private static final k0 f2041c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final l0 f2042d;

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f2043b;

    static {
        k0 k0Var = new k0();
        f2041c = k0Var;
        k0Var.a();
        f2042d = k0Var;
    }

    public k0() {
        this(10);
    }

    public k0(int i5) {
        this(new ArrayList(i5));
    }

    private k0(ArrayList<Object> arrayList) {
        this.f2043b = arrayList;
    }

    private static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof i ? ((i) obj).K() : d0.j((byte[]) obj);
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection<? extends String> collection) {
        g();
        if (collection instanceof l0) {
            collection = ((l0) collection).f();
        }
        boolean addAll = this.f2043b.addAll(i5, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.l0
    public void c(i iVar) {
        g();
        this.f2043b.add(iVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        g();
        this.f2043b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.l0
    public l0 d() {
        return j() ? new z1(this) : this;
    }

    @Override // com.google.protobuf.l0
    public Object e(int i5) {
        return this.f2043b.get(i5);
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.protobuf.l0
    public List<?> f() {
        return Collections.unmodifiableList(this.f2043b);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public void add(int i5, String str) {
        g();
        this.f2043b.add(i5, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.c, com.google.protobuf.d0.i
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k */
    public String get(int i5) {
        Object obj = this.f2043b.get(i5);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            String K = iVar.K();
            if (iVar.x()) {
                this.f2043b.set(i5, K);
            }
            return K;
        }
        byte[] bArr = (byte[]) obj;
        String j5 = d0.j(bArr);
        if (d0.g(bArr)) {
            this.f2043b.set(i5, j5);
        }
        return j5;
    }

    @Override // com.google.protobuf.d0.i
    /* renamed from: l */
    public k0 b(int i5) {
        if (i5 >= size()) {
            ArrayList arrayList = new ArrayList(i5);
            arrayList.addAll(this.f2043b);
            return new k0(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* renamed from: m */
    public String remove(int i5) {
        g();
        Object remove = this.f2043b.remove(i5);
        ((AbstractList) this).modCount++;
        return i(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n */
    public String set(int i5, String str) {
        g();
        return i(this.f2043b.set(i5, str));
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2043b.size();
    }
}
