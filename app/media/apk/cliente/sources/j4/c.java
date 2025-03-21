package j4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import s3.m;
import s3.n;
import s3.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c<T> extends d<T> implements Iterator<T>, v3.d<t> {

    /* renamed from: a  reason: collision with root package name */
    private int f5534a;

    /* renamed from: b  reason: collision with root package name */
    private T f5535b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<? extends T> f5536c;

    /* renamed from: d  reason: collision with root package name */
    private v3.d<? super t> f5537d;

    private final Throwable c() {
        int i5 = this.f5534a;
        if (i5 != 4) {
            if (i5 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f5534a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final T d() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // j4.d
    public Object b(T t5, v3.d<? super t> dVar) {
        this.f5535b = t5;
        this.f5534a = 3;
        this.f5537d = dVar;
        Object c5 = w3.b.c();
        if (c5 == w3.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return c5 == w3.b.c() ? c5 : t.f7573a;
    }

    public final void f(v3.d<? super t> dVar) {
        this.f5537d = dVar;
    }

    @Override // v3.d
    public v3.g getContext() {
        return v3.h.f8175a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i5 = this.f5534a;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2 || i5 == 3) {
                        return true;
                    }
                    if (i5 == 4) {
                        return false;
                    }
                    throw c();
                }
                Iterator<? extends T> it = this.f5536c;
                e4.k.b(it);
                if (it.hasNext()) {
                    this.f5534a = 2;
                    return true;
                }
                this.f5536c = null;
            }
            this.f5534a = 5;
            v3.d<? super t> dVar = this.f5537d;
            e4.k.b(dVar);
            this.f5537d = null;
            m.a aVar = m.f7565b;
            dVar.resumeWith(m.b(t.f7573a));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i5 = this.f5534a;
        if (i5 == 0 || i5 == 1) {
            return d();
        }
        if (i5 == 2) {
            this.f5534a = 1;
            Iterator<? extends T> it = this.f5536c;
            e4.k.b(it);
            return it.next();
        } else if (i5 == 3) {
            this.f5534a = 0;
            T t5 = this.f5535b;
            this.f5535b = null;
            return t5;
        } else {
            throw c();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // v3.d
    public void resumeWith(Object obj) {
        n.b(obj);
        this.f5534a = 4;
    }
}
