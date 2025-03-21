package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: c  reason: collision with root package name */
    private static d0 f3658c;

    /* renamed from: a  reason: collision with root package name */
    private final LongSparseArray<MotionEvent> f3659a = new LongSparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Long> f3660b = new PriorityQueue<>();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        private static final AtomicLong f3661b = new AtomicLong(0);

        /* renamed from: a  reason: collision with root package name */
        private final long f3662a;

        private a(long j5) {
            this.f3662a = j5;
        }

        public static a b() {
            return c(f3661b.incrementAndGet());
        }

        public static a c(long j5) {
            return new a(j5);
        }

        public long d() {
            return this.f3662a;
        }
    }

    private d0() {
    }

    public static d0 a() {
        if (f3658c == null) {
            f3658c = new d0();
        }
        return f3658c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f3660b.isEmpty() && this.f3660b.peek().longValue() < aVar.f3662a) {
            this.f3659a.remove(this.f3660b.poll().longValue());
        }
        if (!this.f3660b.isEmpty() && this.f3660b.peek().longValue() == aVar.f3662a) {
            this.f3660b.poll();
        }
        MotionEvent motionEvent = this.f3659a.get(aVar.f3662a);
        this.f3659a.remove(aVar.f3662a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a b5 = a.b();
        this.f3659a.put(b5.f3662a, MotionEvent.obtain(motionEvent));
        this.f3660b.add(Long.valueOf(b5.f3662a));
        return b5;
    }
}
