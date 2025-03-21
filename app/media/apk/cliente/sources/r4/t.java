package r4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* loaded from: classes.dex */
public class t<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7232a = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "_cur");
    private volatile Object _cur;

    public t(boolean z4) {
        this._cur = new u(8, z4);
    }

    public final boolean a(E e5) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7232a;
        while (true) {
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            int a5 = uVar.a(e5);
            if (a5 == 0) {
                return true;
            }
            if (a5 == 1) {
                androidx.concurrent.futures.b.a(f7232a, this, uVar, uVar.i());
            } else if (a5 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7232a;
        while (true) {
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            if (uVar.d()) {
                return;
            }
            androidx.concurrent.futures.b.a(f7232a, this, uVar, uVar.i());
        }
    }

    public final int c() {
        return ((u) f7232a.get(this)).f();
    }

    public final E d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7232a;
        while (true) {
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            E e5 = (E) uVar.j();
            if (e5 != u.f7236h) {
                return e5;
            }
            androidx.concurrent.futures.b.a(f7232a, this, uVar, uVar.i());
        }
    }
}
