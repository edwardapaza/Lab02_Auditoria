package l1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public enum k implements Executor {
    INSTANCE;
    

    /* renamed from: b  reason: collision with root package name */
    private static final Handler f5906b = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f5906b.post(runnable);
    }
}
