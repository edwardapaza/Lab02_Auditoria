package io.grpc.internal;

import i3.n1;
import io.grpc.internal.k;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements d2 {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f5004f = Logger.getLogger(m.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f5005a;

    /* renamed from: b  reason: collision with root package name */
    private final i3.n1 f5006b;

    /* renamed from: c  reason: collision with root package name */
    private final k.a f5007c;

    /* renamed from: d  reason: collision with root package name */
    private k f5008d;

    /* renamed from: e  reason: collision with root package name */
    private n1.d f5009e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k.a aVar, ScheduledExecutorService scheduledExecutorService, i3.n1 n1Var) {
        this.f5007c = aVar;
        this.f5005a = scheduledExecutorService;
        this.f5006b = n1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        n1.d dVar = this.f5009e;
        if (dVar != null && dVar.b()) {
            this.f5009e.a();
        }
        this.f5008d = null;
    }

    @Override // io.grpc.internal.d2
    public void a(Runnable runnable) {
        this.f5006b.e();
        if (this.f5008d == null) {
            this.f5008d = this.f5007c.get();
        }
        n1.d dVar = this.f5009e;
        if (dVar == null || !dVar.b()) {
            long a5 = this.f5008d.a();
            this.f5009e = this.f5006b.c(runnable, a5, TimeUnit.NANOSECONDS, this.f5005a);
            f5004f.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(a5));
        }
    }

    @Override // io.grpc.internal.d2
    public void reset() {
        this.f5006b.e();
        this.f5006b.execute(new Runnable() { // from class: io.grpc.internal.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.c();
            }
        });
    }
}
