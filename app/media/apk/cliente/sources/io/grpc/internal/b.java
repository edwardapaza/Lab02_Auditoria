package io.grpc.internal;

import i3.v0;
/* loaded from: classes.dex */
public abstract class b<T extends i3.v0<T>> extends i3.v0<T> {

    /* renamed from: a  reason: collision with root package name */
    protected int f4426a = 4194304;

    @Override // i3.v0
    public i3.u0 a() {
        return e().a();
    }

    protected abstract i3.v0<?> e();

    public String toString() {
        return z0.f.b(this).d("delegate", e()).toString();
    }
}
