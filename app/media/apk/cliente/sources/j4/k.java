package j4;

import d4.l;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class k<T, R> implements b<R> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f5541a;

    /* renamed from: b  reason: collision with root package name */
    private final l<T, R> f5542b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<R> {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f5543a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k<T, R> f5544b;

        a(k<T, R> kVar) {
            this.f5544b = kVar;
            this.f5543a = ((k) kVar).f5541a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5543a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((k) this.f5544b).f5542b.invoke(this.f5543a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(b<? extends T> bVar, l<? super T, ? extends R> lVar) {
        e4.k.e(bVar, "sequence");
        e4.k.e(lVar, "transformer");
        this.f5541a = bVar;
        this.f5542b = lVar;
    }

    @Override // j4.b
    public Iterator<R> iterator() {
        return new a(this);
    }
}
