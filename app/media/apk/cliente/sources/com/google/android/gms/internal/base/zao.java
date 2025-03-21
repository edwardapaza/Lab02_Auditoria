package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
final class zao implements zam {
    private zao() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zao(zan zanVar) {
    }

    @Override // com.google.android.gms.internal.base.zam
    public final ExecutorService zaa(ThreadFactory threadFactory, int i5) {
        return zac(1, threadFactory, 1);
    }

    @Override // com.google.android.gms.internal.base.zam
    public final ExecutorService zab(int i5, int i6) {
        return zac(4, Executors.defaultThreadFactory(), 2);
    }

    @Override // com.google.android.gms.internal.base.zam
    public final ExecutorService zac(int i5, ThreadFactory threadFactory, int i6) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i5, i5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
