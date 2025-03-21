package com.google.firebase.firestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import s1.x1;
/* loaded from: classes.dex */
public class y0 implements Iterable<x0> {

    /* renamed from: a  reason: collision with root package name */
    private final w0 f1800a;

    /* renamed from: b  reason: collision with root package name */
    private final x1 f1801b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseFirestore f1802c;

    /* renamed from: d  reason: collision with root package name */
    private List<h> f1803d;

    /* renamed from: e  reason: collision with root package name */
    private p0 f1804e;

    /* renamed from: f  reason: collision with root package name */
    private final c1 f1805f;

    /* loaded from: classes.dex */
    private class a implements Iterator<x0> {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<v1.i> f1806a;

        a(Iterator<v1.i> it) {
            this.f1806a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public x0 next() {
            return y0.this.h(this.f1806a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1806a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("QuerySnapshot does not support remove().");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(w0 w0Var, x1 x1Var, FirebaseFirestore firebaseFirestore) {
        this.f1800a = (w0) z1.y.b(w0Var);
        this.f1801b = (x1) z1.y.b(x1Var);
        this.f1802c = (FirebaseFirestore) z1.y.b(firebaseFirestore);
        this.f1805f = new c1(x1Var.j(), x1Var.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public x0 h(v1.i iVar) {
        return x0.h(this.f1802c, iVar, this.f1801b.k(), this.f1801b.f().contains(iVar.getKey()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y0) {
            y0 y0Var = (y0) obj;
            return this.f1802c.equals(y0Var.f1802c) && this.f1800a.equals(y0Var.f1800a) && this.f1801b.equals(y0Var.f1801b) && this.f1805f.equals(y0Var.f1805f);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f1802c.hashCode() * 31) + this.f1800a.hashCode()) * 31) + this.f1801b.hashCode()) * 31) + this.f1805f.hashCode();
    }

    public List<h> i() {
        return k(p0.EXCLUDE);
    }

    @Override // java.lang.Iterable
    public Iterator<x0> iterator() {
        return new a(this.f1801b.e().iterator());
    }

    public List<h> k(p0 p0Var) {
        if (p0.INCLUDE.equals(p0Var) && this.f1801b.b()) {
            throw new IllegalArgumentException("To include metadata changes with your document changes, you must also pass MetadataChanges.INCLUDE to addSnapshotListener().");
        }
        if (this.f1803d == null || this.f1804e != p0Var) {
            this.f1803d = Collections.unmodifiableList(h.a(this.f1802c, p0Var, this.f1801b));
            this.f1804e = p0Var;
        }
        return this.f1803d;
    }

    public List<n> l() {
        ArrayList arrayList = new ArrayList(this.f1801b.e().size());
        Iterator<v1.i> it = this.f1801b.e().iterator();
        while (it.hasNext()) {
            arrayList.add(h(it.next()));
        }
        return arrayList;
    }

    public c1 m() {
        return this.f1805f;
    }
}
