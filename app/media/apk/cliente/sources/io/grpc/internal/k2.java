package io.grpc.internal;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class k2 {

    /* renamed from: d  reason: collision with root package name */
    private static final k2 f4977d = new k2(new a());

    /* renamed from: a  reason: collision with root package name */
    private final IdentityHashMap<d<?>, c> f4978a = new IdentityHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final e f4979b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledExecutorService f4980c;

    /* loaded from: classes.dex */
    class a implements e {
        a() {
        }

        @Override // io.grpc.internal.k2.e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(t0.i("grpc-shared-destroyer-%d", true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f4981a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f4982b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f4983c;

        b(c cVar, d dVar, Object obj) {
            this.f4981a = cVar;
            this.f4982b = dVar;
            this.f4983c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (k2.this) {
                if (this.f4981a.f4986b == 0) {
                    this.f4982b.b(this.f4983c);
                    k2.this.f4978a.remove(this.f4982b);
                    if (k2.this.f4978a.isEmpty()) {
                        k2.this.f4980c.shutdown();
                        k2.this.f4980c = null;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final Object f4985a;

        /* renamed from: b  reason: collision with root package name */
        int f4986b;

        /* renamed from: c  reason: collision with root package name */
        ScheduledFuture<?> f4987c;

        c(Object obj) {
            this.f4985a = obj;
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        T a();

        void b(T t5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        ScheduledExecutorService a();
    }

    k2(e eVar) {
        this.f4979b = eVar;
    }

    public static <T> T d(d<T> dVar) {
        return (T) f4977d.e(dVar);
    }

    public static <T> T f(d<T> dVar, T t5) {
        return (T) f4977d.g(dVar, t5);
    }

    synchronized <T> T e(d<T> dVar) {
        c cVar;
        cVar = this.f4978a.get(dVar);
        if (cVar == null) {
            cVar = new c(dVar.a());
            this.f4978a.put(dVar, cVar);
        }
        ScheduledFuture<?> scheduledFuture = cVar.f4987c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            cVar.f4987c = null;
        }
        cVar.f4986b++;
        return (T) cVar.f4985a;
    }

    synchronized <T> T g(d<T> dVar, T t5) {
        c cVar = this.f4978a.get(dVar);
        if (cVar == null) {
            throw new IllegalArgumentException("No cached instance found for " + dVar);
        }
        z0.k.e(t5 == cVar.f4985a, "Releasing the wrong instance");
        z0.k.u(cVar.f4986b > 0, "Refcount has already reached zero");
        int i5 = cVar.f4986b - 1;
        cVar.f4986b = i5;
        if (i5 == 0) {
            z0.k.u(cVar.f4987c == null, "Destroy task already scheduled");
            if (this.f4980c == null) {
                this.f4980c = this.f4979b.a();
            }
            cVar.f4987c = this.f4980c.schedule(new f1(new b(cVar, dVar, t5)), 1L, TimeUnit.SECONDS);
        }
        return null;
    }
}
