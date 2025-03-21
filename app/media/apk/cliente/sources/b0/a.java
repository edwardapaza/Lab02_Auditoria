package b0;

import android.app.Activity;
import c0.f;
import c0.j;
import e4.k;
import java.util.concurrent.Executor;
import p4.c;
/* loaded from: classes.dex */
public final class a implements f {

    /* renamed from: b  reason: collision with root package name */
    private final f f734b;

    /* renamed from: c  reason: collision with root package name */
    private final a0.a f735c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        this(fVar, new a0.a());
        k.e(fVar, "tracker");
    }

    private a(f fVar, a0.a aVar) {
        this.f734b = fVar;
        this.f735c = aVar;
    }

    @Override // c0.f
    public c<j> a(Activity activity) {
        k.e(activity, "activity");
        return this.f734b.a(activity);
    }

    public final void b(Activity activity, Executor executor, k.a<j> aVar) {
        k.e(activity, "activity");
        k.e(executor, "executor");
        k.e(aVar, "consumer");
        this.f735c.a(executor, aVar, this.f734b.a(activity));
    }

    public final void c(k.a<j> aVar) {
        k.e(aVar, "consumer");
        this.f735c.b(aVar);
    }
}
