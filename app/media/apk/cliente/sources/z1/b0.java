package z1;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b0 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f8895a;

    /* renamed from: b  reason: collision with root package name */
    private final Semaphore f8896b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(int i5, Executor executor) {
        this.f8896b = new Semaphore(i5);
        this.f8895a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        runnable.run();
        this.f8896b.release();
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (this.f8896b.tryAcquire()) {
            try {
                this.f8895a.execute(new Runnable() { // from class: z1.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.this.b(runnable);
                    }
                });
                return;
            } catch (RejectedExecutionException unused) {
            }
        }
        runnable.run();
    }
}
