package k1;
/* loaded from: classes.dex */
public class x<T> implements b2.b<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f5617c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f5618a = f5617c;

    /* renamed from: b  reason: collision with root package name */
    private volatile b2.b<T> f5619b;

    public x(b2.b<T> bVar) {
        this.f5619b = bVar;
    }

    @Override // b2.b
    public T get() {
        T t5 = (T) this.f5618a;
        Object obj = f5617c;
        if (t5 == obj) {
            synchronized (this) {
                t5 = this.f5618a;
                if (t5 == obj) {
                    t5 = this.f5619b.get();
                    this.f5618a = t5;
                    this.f5619b = null;
                }
            }
        }
        return t5;
    }
}
