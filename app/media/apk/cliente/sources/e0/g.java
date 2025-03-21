package e0;

import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import c0.j;
import e4.k;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import s3.t;
/* loaded from: classes.dex */
public final class g implements k.a<WindowLayoutInfo>, Consumer<WindowLayoutInfo> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2648a;

    /* renamed from: b  reason: collision with root package name */
    private final ReentrantLock f2649b;

    /* renamed from: c  reason: collision with root package name */
    private j f2650c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<k.a<j>> f2651d;

    public g(Context context) {
        k.e(context, "context");
        this.f2648a = context;
        this.f2649b = new ReentrantLock();
        this.f2651d = new LinkedHashSet();
    }

    @Override // k.a
    /* renamed from: a */
    public void accept(WindowLayoutInfo windowLayoutInfo) {
        k.e(windowLayoutInfo, "value");
        ReentrantLock reentrantLock = this.f2649b;
        reentrantLock.lock();
        try {
            this.f2650c = f.f2647a.b(this.f2648a, windowLayoutInfo);
            Iterator<T> it = this.f2651d.iterator();
            while (it.hasNext()) {
                ((k.a) it.next()).accept(this.f2650c);
            }
            t tVar = t.f7573a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(k.a<j> aVar) {
        k.e(aVar, "listener");
        ReentrantLock reentrantLock = this.f2649b;
        reentrantLock.lock();
        try {
            j jVar = this.f2650c;
            if (jVar != null) {
                aVar.accept(jVar);
            }
            this.f2651d.add(aVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean c() {
        return this.f2651d.isEmpty();
    }

    public final void d(k.a<j> aVar) {
        k.e(aVar, "listener");
        ReentrantLock reentrantLock = this.f2649b;
        reentrantLock.lock();
        try {
            this.f2651d.remove(aVar);
        } finally {
            reentrantLock.unlock();
        }
    }
}
