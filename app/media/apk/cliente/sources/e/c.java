package e;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class c extends f {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f2625c;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f2626d = new Executor() { // from class: e.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.g(runnable);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f2627e = new Executor() { // from class: e.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.h(runnable);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private f f2628a;

    /* renamed from: b  reason: collision with root package name */
    private final f f2629b;

    private c() {
        d dVar = new d();
        this.f2629b = dVar;
        this.f2628a = dVar;
    }

    public static c f() {
        if (f2625c != null) {
            return f2625c;
        }
        synchronized (c.class) {
            if (f2625c == null) {
                f2625c = new c();
            }
        }
        return f2625c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Runnable runnable) {
        f().c(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Runnable runnable) {
        f().a(runnable);
    }

    @Override // e.f
    public void a(Runnable runnable) {
        this.f2628a.a(runnable);
    }

    @Override // e.f
    public boolean b() {
        return this.f2628a.b();
    }

    @Override // e.f
    public void c(Runnable runnable) {
        this.f2628a.c(runnable);
    }
}
