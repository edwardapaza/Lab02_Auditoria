package com.google.protobuf;

import java.io.OutputStream;
/* loaded from: classes.dex */
public interface w0 extends x0 {

    /* loaded from: classes.dex */
    public interface a extends x0, Cloneable {
        w0 build();

        a g(w0 w0Var);

        a h(j jVar, q qVar);

        w0 i();
    }

    int a();

    a c();

    void d(OutputStream outputStream);

    void f(l lVar);

    byte[] j();

    a k();

    i l();

    g1<? extends w0> m();
}
