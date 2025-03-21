package com.google.firebase.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
class p<V> extends androidx.concurrent.futures.a<V> implements ScheduledFuture<V> {

    /* renamed from: l  reason: collision with root package name */
    private final ScheduledFuture<?> f1628l;

    /* loaded from: classes.dex */
    class a implements b<V> {
        a() {
        }

        @Override // com.google.firebase.concurrent.p.b
        public void a(Throwable th) {
            p.this.v(th);
        }

        @Override // com.google.firebase.concurrent.p.b
        public void set(V v5) {
            p.this.u(v5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(Throwable th);

        void set(T t5);
    }

    /* loaded from: classes.dex */
    interface c<T> {
        ScheduledFuture<?> a(b<T> bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(c<V> cVar) {
        this.f1628l = cVar.a(new a());
    }

    @Override // java.lang.Comparable
    /* renamed from: A */
    public int compareTo(Delayed delayed) {
        return this.f1628l.compareTo(delayed);
    }

    @Override // androidx.concurrent.futures.a
    protected void c() {
        this.f1628l.cancel(x());
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f1628l.getDelay(timeUnit);
    }
}
