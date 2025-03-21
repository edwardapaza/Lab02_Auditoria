package e0;

import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import c0.j;
import e4.k;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import s3.t;
/* loaded from: classes.dex */
public final class e implements d0.a {

    /* renamed from: a  reason: collision with root package name */
    private final WindowLayoutComponent f2643a;

    /* renamed from: b  reason: collision with root package name */
    private final ReentrantLock f2644b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Context, g> f2645c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<k.a<j>, Context> f2646d;

    public e(WindowLayoutComponent windowLayoutComponent) {
        k.e(windowLayoutComponent, "component");
        this.f2643a = windowLayoutComponent;
        this.f2644b = new ReentrantLock();
        this.f2645c = new LinkedHashMap();
        this.f2646d = new LinkedHashMap();
    }

    @Override // d0.a
    public void a(Context context, Executor executor, k.a<j> aVar) {
        t tVar;
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        ReentrantLock reentrantLock = this.f2644b;
        reentrantLock.lock();
        try {
            g gVar = this.f2645c.get(context);
            if (gVar != null) {
                gVar.b(aVar);
                this.f2646d.put(aVar, context);
                tVar = t.f7573a;
            } else {
                tVar = null;
            }
            if (tVar == null) {
                g gVar2 = new g(context);
                this.f2645c.put(context, gVar2);
                this.f2646d.put(aVar, context);
                gVar2.b(aVar);
                this.f2643a.addWindowLayoutInfoListener(context, gVar2);
            }
            t tVar2 = t.f7573a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // d0.a
    public void b(k.a<j> aVar) {
        k.e(aVar, "callback");
        ReentrantLock reentrantLock = this.f2644b;
        reentrantLock.lock();
        try {
            Context context = this.f2646d.get(aVar);
            if (context == null) {
                return;
            }
            g gVar = this.f2645c.get(context);
            if (gVar == null) {
                return;
            }
            gVar.d(aVar);
            this.f2646d.remove(aVar);
            if (gVar.c()) {
                this.f2645c.remove(context);
                this.f2643a.removeWindowLayoutInfoListener(gVar);
            }
            t tVar = t.f7573a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
