package androidx.activity;

import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    private boolean f154a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<c> f155b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private d4.a<s3.t> f156c;

    public p(boolean z4) {
        this.f154a = z4;
    }

    public final void a(c cVar) {
        e4.k.e(cVar, "cancellable");
        this.f155b.add(cVar);
    }

    public final d4.a<s3.t> b() {
        return this.f156c;
    }

    public void c() {
    }

    public abstract void d();

    public void e(b bVar) {
        e4.k.e(bVar, "backEvent");
    }

    public void f(b bVar) {
        e4.k.e(bVar, "backEvent");
    }

    public final boolean g() {
        return this.f154a;
    }

    public final void h() {
        for (c cVar : this.f155b) {
            cVar.cancel();
        }
    }

    public final void i(c cVar) {
        e4.k.e(cVar, "cancellable");
        this.f155b.remove(cVar);
    }

    public final void j(boolean z4) {
        this.f154a = z4;
        d4.a<s3.t> aVar = this.f156c;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void k(d4.a<s3.t> aVar) {
        this.f156c = aVar;
    }
}
