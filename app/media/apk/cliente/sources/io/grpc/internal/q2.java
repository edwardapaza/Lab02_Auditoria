package io.grpc.internal;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public interface q2 {

    /* renamed from: a  reason: collision with root package name */
    public static final q2 f5109a = new a();

    /* loaded from: classes.dex */
    class a implements q2 {
        a() {
        }

        @Override // io.grpc.internal.q2
        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }

    long a();
}
