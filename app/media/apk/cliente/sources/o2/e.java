package o2;

import android.os.Handler;
import android.os.Looper;
import o2.c;
/* loaded from: classes.dex */
public class e implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f6777a = h3.a.a(Looper.getMainLooper());

    @Override // o2.c.b
    public void a(Runnable runnable) {
        this.f6777a.post(runnable);
    }
}
