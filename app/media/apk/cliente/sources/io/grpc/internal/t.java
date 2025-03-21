package io.grpc.internal;
/* loaded from: classes.dex */
public interface t extends p2 {

    /* loaded from: classes.dex */
    public enum a {
        PROCESSED,
        REFUSED,
        DROPPED,
        MISCARRIED
    }

    void c(i3.y0 y0Var);

    void d(i3.j1 j1Var, a aVar, i3.y0 y0Var);
}
