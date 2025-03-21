package s3;

import java.io.Serializable;
/* loaded from: classes.dex */
final class o<T> implements g<T>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private d4.a<? extends T> f7568a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f7569b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f7570c;

    public o(d4.a<? extends T> aVar, Object obj) {
        e4.k.e(aVar, "initializer");
        this.f7568a = aVar;
        this.f7569b = r.f7572a;
        this.f7570c = obj == null ? this : obj;
    }

    public /* synthetic */ o(d4.a aVar, Object obj, int i5, e4.g gVar) {
        this(aVar, (i5 & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.f7569b != r.f7572a;
    }

    @Override // s3.g
    public T getValue() {
        T t5;
        T t6 = (T) this.f7569b;
        r rVar = r.f7572a;
        if (t6 != rVar) {
            return t6;
        }
        synchronized (this.f7570c) {
            t5 = (T) this.f7569b;
            if (t5 == rVar) {
                d4.a<? extends T> aVar = this.f7568a;
                e4.k.b(aVar);
                t5 = aVar.b();
                this.f7569b = t5;
                this.f7568a = null;
            }
        }
        return t5;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
