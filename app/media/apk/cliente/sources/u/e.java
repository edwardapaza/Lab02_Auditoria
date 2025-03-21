package u;

import android.os.Bundle;
import androidx.lifecycle.i;
import e4.k;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final a f7712d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final f f7713a;

    /* renamed from: b  reason: collision with root package name */
    private final d f7714b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7715c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final e a(f fVar) {
            k.e(fVar, "owner");
            return new e(fVar, null);
        }
    }

    private e(f fVar) {
        this.f7713a = fVar;
        this.f7714b = new d();
    }

    public /* synthetic */ e(f fVar, e4.g gVar) {
        this(fVar);
    }

    public static final e a(f fVar) {
        return f7712d.a(fVar);
    }

    public final d b() {
        return this.f7714b;
    }

    public final void c() {
        i a5 = this.f7713a.a();
        if (!(a5.b() == i.b.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        a5.a(new b(this.f7713a));
        this.f7714b.e(a5);
        this.f7715c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f7715c) {
            c();
        }
        i a5 = this.f7713a.a();
        if (!a5.b().c(i.b.STARTED)) {
            this.f7714b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + a5.b()).toString());
    }

    public final void e(Bundle bundle) {
        k.e(bundle, "outBundle");
        this.f7714b.g(bundle);
    }
}
