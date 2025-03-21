package z1;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
/* loaded from: classes.dex */
public class m implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private Semaphore f8943a = new Semaphore(0);

    /* renamed from: b  reason: collision with root package name */
    private int f8944b = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Runnable runnable) {
        runnable.run();
        this.f8943a.release();
    }

    public void b() {
        try {
            this.f8943a.acquire(this.f8944b);
            this.f8944b = 0;
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            b.a("Interrupted while waiting for background task", e5);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        this.f8944b++;
        p.f8962c.execute(new Runnable() { // from class: z1.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.c(runnable);
            }
        });
    }
}
