package e0;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import c0.j;
import d4.l;
import e4.k;
import e4.s;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import s3.t;
import t3.p;
import z.d;
/* loaded from: classes.dex */
public final class d implements d0.a {

    /* renamed from: a  reason: collision with root package name */
    private final WindowLayoutComponent f2637a;

    /* renamed from: b  reason: collision with root package name */
    private final z.d f2638b;

    /* renamed from: c  reason: collision with root package name */
    private final ReentrantLock f2639c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Context, g> f2640d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<k.a<j>, Context> f2641e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<g, d.b> f2642f;

    /* loaded from: classes.dex */
    /* synthetic */ class a extends e4.j implements l<WindowLayoutInfo, t> {
        a(Object obj) {
            super(1, obj, g.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0);
        }

        public final void i(WindowLayoutInfo windowLayoutInfo) {
            k.e(windowLayoutInfo, "p0");
            ((g) this.f2919b).accept(windowLayoutInfo);
        }

        @Override // d4.l
        public /* bridge */ /* synthetic */ t invoke(WindowLayoutInfo windowLayoutInfo) {
            i(windowLayoutInfo);
            return t.f7573a;
        }
    }

    public d(WindowLayoutComponent windowLayoutComponent, z.d dVar) {
        k.e(windowLayoutComponent, "component");
        k.e(dVar, "consumerAdapter");
        this.f2637a = windowLayoutComponent;
        this.f2638b = dVar;
        this.f2639c = new ReentrantLock();
        this.f2640d = new LinkedHashMap();
        this.f2641e = new LinkedHashMap();
        this.f2642f = new LinkedHashMap();
    }

    @Override // d0.a
    public void a(Context context, Executor executor, k.a<j> aVar) {
        t tVar;
        List f5;
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        ReentrantLock reentrantLock = this.f2639c;
        reentrantLock.lock();
        try {
            g gVar = this.f2640d.get(context);
            if (gVar != null) {
                gVar.b(aVar);
                this.f2641e.put(aVar, context);
                tVar = t.f7573a;
            } else {
                tVar = null;
            }
            if (tVar == null) {
                g gVar2 = new g(context);
                this.f2640d.put(context, gVar2);
                this.f2641e.put(aVar, context);
                gVar2.b(aVar);
                if (!(context instanceof Activity)) {
                    f5 = p.f();
                    gVar2.accept(new WindowLayoutInfo(f5));
                    return;
                }
                this.f2642f.put(gVar2, this.f2638b.c(this.f2637a, s.b(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", (Activity) context, new a(gVar2)));
            }
            t tVar2 = t.f7573a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // d0.a
    public void b(k.a<j> aVar) {
        k.e(aVar, "callback");
        ReentrantLock reentrantLock = this.f2639c;
        reentrantLock.lock();
        try {
            Context context = this.f2641e.get(aVar);
            if (context == null) {
                return;
            }
            g gVar = this.f2640d.get(context);
            if (gVar == null) {
                return;
            }
            gVar.d(aVar);
            this.f2641e.remove(aVar);
            if (gVar.c()) {
                this.f2640d.remove(context);
                d.b remove = this.f2642f.remove(gVar);
                if (remove != null) {
                    remove.a();
                }
            }
            t tVar = t.f7573a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
