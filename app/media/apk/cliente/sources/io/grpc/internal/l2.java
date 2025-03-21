package io.grpc.internal;

import io.grpc.internal.k2;
/* loaded from: classes.dex */
public final class l2<T> implements r1<T> {

    /* renamed from: a  reason: collision with root package name */
    private final k2.d<T> f5003a;

    private l2(k2.d<T> dVar) {
        this.f5003a = dVar;
    }

    public static <T> l2<T> c(k2.d<T> dVar) {
        return new l2<>(dVar);
    }

    @Override // io.grpc.internal.r1
    public T a() {
        return (T) k2.d(this.f5003a);
    }

    @Override // io.grpc.internal.r1
    public T b(Object obj) {
        k2.f(this.f5003a, obj);
        return null;
    }
}
