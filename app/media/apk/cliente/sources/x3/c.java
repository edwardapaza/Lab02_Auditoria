package x3;

import e4.k;
import java.io.Serializable;
import java.lang.Enum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c<T extends Enum<T>> extends t3.c<T> implements a<T>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    private final d4.a<T[]> f8349b;

    /* renamed from: c  reason: collision with root package name */
    private volatile T[] f8350c;

    public c(d4.a<T[]> aVar) {
        k.e(aVar, "entriesProvider");
        this.f8349b = aVar;
    }

    private final T[] k() {
        T[] tArr = this.f8350c;
        if (tArr != null) {
            return tArr;
        }
        T[] b5 = this.f8349b.b();
        this.f8350c = b5;
        return b5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t3.a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return h((Enum) obj);
        }
        return false;
    }

    @Override // t3.a
    public int g() {
        return k().length;
    }

    public boolean h(T t5) {
        Object l5;
        k.e(t5, "element");
        l5 = t3.k.l(k(), t5.ordinal());
        return ((Enum) l5) == t5;
    }

    @Override // t3.c, java.util.List
    /* renamed from: i */
    public T get(int i5) {
        T[] k5 = k();
        t3.c.f7610a.a(i5, k5.length);
        return k5[i5];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t3.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return l((Enum) obj);
        }
        return -1;
    }

    public int l(T t5) {
        Object l5;
        k.e(t5, "element");
        int ordinal = t5.ordinal();
        l5 = t3.k.l(k(), ordinal);
        if (((Enum) l5) == t5) {
            return ordinal;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t3.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return m((Enum) obj);
        }
        return -1;
    }

    public int m(T t5) {
        k.e(t5, "element");
        return indexOf(t5);
    }
}
