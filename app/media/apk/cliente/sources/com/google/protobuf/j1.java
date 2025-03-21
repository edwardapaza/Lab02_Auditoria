package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j1 {

    /* renamed from: c  reason: collision with root package name */
    private static final j1 f2033c = new j1();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, o1<?>> f2035b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final p1 f2034a = new o0();

    private j1() {
    }

    public static j1 a() {
        return f2033c;
    }

    public o1<?> b(Class<?> cls, o1<?> o1Var) {
        d0.b(cls, "messageType");
        d0.b(o1Var, "schema");
        return this.f2035b.putIfAbsent(cls, o1Var);
    }

    public <T> o1<T> c(Class<T> cls) {
        d0.b(cls, "messageType");
        o1<T> o1Var = (o1<T>) this.f2035b.get(cls);
        if (o1Var == null) {
            o1<T> a5 = this.f2034a.a(cls);
            o1<T> o1Var2 = (o1<T>) b(cls, a5);
            return o1Var2 != null ? o1Var2 : a5;
        }
        return o1Var;
    }

    public <T> o1<T> d(T t5) {
        return c(t5.getClass());
    }
}
