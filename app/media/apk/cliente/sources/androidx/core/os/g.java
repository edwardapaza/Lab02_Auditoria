package androidx.core.os;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes.dex */
public final class g {

    /* loaded from: classes.dex */
    private static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f426a;

        a(Handler handler) {
            this.f426a = (Handler) k.d.a(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f426a.post((Runnable) k.d.a(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f426a + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
