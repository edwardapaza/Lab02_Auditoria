package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f4776c = Logger.getLogger(h.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final String f4777a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicLong f4778b;

    /* loaded from: classes.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        private final long f4779a;

        private b(long j5) {
            this.f4779a = j5;
        }

        public void a() {
            long j5 = this.f4779a;
            long max = Math.max(2 * j5, j5);
            if (h.this.f4778b.compareAndSet(this.f4779a, max)) {
                h.f4776c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{h.this.f4777a, Long.valueOf(max)});
            }
        }

        public long b() {
            return this.f4779a;
        }
    }

    public h(String str, long j5) {
        AtomicLong atomicLong = new AtomicLong();
        this.f4778b = atomicLong;
        z0.k.e(j5 > 0, "value must be positive");
        this.f4777a = str;
        atomicLong.set(j5);
    }

    public b d() {
        return new b(this.f4778b.get());
    }
}
