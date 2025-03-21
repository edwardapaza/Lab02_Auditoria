package a1;
/* loaded from: classes.dex */
final class v<E> extends l<E> {

    /* renamed from: l  reason: collision with root package name */
    private static final Object[] f56l;

    /* renamed from: m  reason: collision with root package name */
    static final v<Object> f57m;

    /* renamed from: c  reason: collision with root package name */
    final transient Object[] f58c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f59d;

    /* renamed from: e  reason: collision with root package name */
    final transient Object[] f60e;

    /* renamed from: f  reason: collision with root package name */
    private final transient int f61f;

    /* renamed from: k  reason: collision with root package name */
    private final transient int f62k;

    static {
        Object[] objArr = new Object[0];
        f56l = objArr;
        f57m = new v<>(objArr, 0, objArr, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Object[] objArr, int i5, Object[] objArr2, int i6, int i7) {
        this.f58c = objArr;
        this.f59d = i5;
        this.f60e = objArr2;
        this.f61f = i6;
        this.f62k = i7;
    }

    @Override // a1.i, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f60e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int b5 = h.b(obj);
        while (true) {
            int i5 = b5 & this.f61f;
            Object obj2 = objArr[i5];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            b5 = i5 + 1;
        }
    }

    @Override // a1.i
    int g(Object[] objArr, int i5) {
        System.arraycopy(this.f58c, 0, objArr, i5, this.f62k);
        return i5 + this.f62k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a1.i
    public Object[] h() {
        return this.f58c;
    }

    @Override // a1.l, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f59d;
    }

    @Override // a1.i
    int i() {
        return this.f62k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a1.i
    public int k() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a1.i
    public boolean l() {
        return false;
    }

    @Override // a1.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: m */
    public z<E> iterator() {
        return n().iterator();
    }

    @Override // a1.l
    j<E> r() {
        return j.o(this.f58c, this.f62k);
    }

    @Override // a1.l
    boolean s() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f62k;
    }
}
