package p3;

import i3.d;
import java.util.concurrent.Executor;
import p3.b;
import z0.k;
/* loaded from: classes.dex */
public abstract class b<S extends b<S>> {

    /* renamed from: a  reason: collision with root package name */
    private final d f6882a;

    /* renamed from: b  reason: collision with root package name */
    private final i3.c f6883b;

    /* loaded from: classes.dex */
    public interface a<T extends b<T>> {
        T a(d dVar, i3.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(d dVar, i3.c cVar) {
        this.f6882a = (d) k.o(dVar, "channel");
        this.f6883b = (i3.c) k.o(cVar, "callOptions");
    }

    protected abstract S a(d dVar, i3.c cVar);

    public final i3.c b() {
        return this.f6883b;
    }

    public final S c(i3.b bVar) {
        return a(this.f6882a, this.f6883b.l(bVar));
    }

    public final S d(Executor executor) {
        return a(this.f6882a, this.f6883b.n(executor));
    }
}
