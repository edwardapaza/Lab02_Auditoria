package io.grpc.internal;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public interface u extends i3.i0<Object> {

    /* loaded from: classes.dex */
    public interface a {
        void a(Throwable th);

        void b(long j5);
    }

    s c(i3.z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar, i3.k[] kVarArr);

    void g(a aVar, Executor executor);
}
