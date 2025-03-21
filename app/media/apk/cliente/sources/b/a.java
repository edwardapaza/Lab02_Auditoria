package b;

import android.content.Context;
import e4.k;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f732a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f733b;

    public final void a(b bVar) {
        k.e(bVar, "listener");
        Context context = this.f733b;
        if (context != null) {
            bVar.a(context);
        }
        this.f732a.add(bVar);
    }

    public final void b() {
        this.f733b = null;
    }

    public final void c(Context context) {
        k.e(context, "context");
        this.f733b = context;
        for (b bVar : this.f732a) {
            bVar.a(context);
        }
    }
}
