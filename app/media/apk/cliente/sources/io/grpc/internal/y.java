package io.grpc.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<a> f5316a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private volatile i3.p f5317b = i3.p.IDLE;

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f5318a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f5319b;

        a(Runnable runnable, Executor executor) {
            this.f5318a = runnable;
            this.f5319b = executor;
        }

        void a() {
            this.f5319b.execute(this.f5318a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i3.p a() {
        i3.p pVar = this.f5317b;
        if (pVar != null) {
            return pVar;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i3.p pVar) {
        z0.k.o(pVar, "newState");
        if (this.f5317b == pVar || this.f5317b == i3.p.SHUTDOWN) {
            return;
        }
        this.f5317b = pVar;
        if (this.f5316a.isEmpty()) {
            return;
        }
        ArrayList<a> arrayList = this.f5316a;
        this.f5316a = new ArrayList<>();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Runnable runnable, Executor executor, i3.p pVar) {
        z0.k.o(runnable, "callback");
        z0.k.o(executor, "executor");
        z0.k.o(pVar, "source");
        a aVar = new a(runnable, executor);
        if (this.f5317b != pVar) {
            aVar.a();
        } else {
            this.f5316a.add(aVar);
        }
    }
}
