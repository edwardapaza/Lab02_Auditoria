package p1;

import k1.e0;
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f6880a;

    /* renamed from: b  reason: collision with root package name */
    private final T f6881b;

    public a(Class<T> cls, T t5) {
        this.f6880a = (Class) e0.b(cls);
        this.f6881b = (T) e0.b(t5);
    }

    public Class<T> a() {
        return this.f6880a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f6880a, this.f6881b);
    }
}
