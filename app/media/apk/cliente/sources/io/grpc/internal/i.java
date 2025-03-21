package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
final class i implements g1 {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f4788a = new AtomicLong();

    @Override // io.grpc.internal.g1
    public void add(long j5) {
        this.f4788a.getAndAdd(j5);
    }
}
