package p4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import r4.h0;
import s3.m;
import s3.t;
/* loaded from: classes.dex */
final class p extends q4.c<n<?>> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6916a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_state");
    private volatile Object _state;

    @Override // q4.c
    /* renamed from: d */
    public boolean a(n<?> nVar) {
        h0 h0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6916a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        h0Var = o.f6914a;
        atomicReferenceFieldUpdater.set(this, h0Var);
        return true;
    }

    public final Object e(v3.d<? super t> dVar) {
        v3.d b5;
        h0 h0Var;
        Object c5;
        Object c6;
        b5 = w3.c.b(dVar);
        m4.m mVar = new m4.m(b5, 1);
        mVar.B();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6916a;
        h0Var = o.f6914a;
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, h0Var, mVar)) {
            m.a aVar = s3.m.f7565b;
            mVar.resumeWith(s3.m.b(t.f7573a));
        }
        Object y4 = mVar.y();
        c5 = w3.d.c();
        if (y4 == c5) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        c6 = w3.d.c();
        return y4 == c6 ? y4 : t.f7573a;
    }

    @Override // q4.c
    /* renamed from: f */
    public v3.d<t>[] b(n<?> nVar) {
        f6916a.set(this, null);
        return q4.b.f7086a;
    }

    public final void g() {
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        h0 h0Var4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6916a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return;
            }
            h0Var = o.f6915b;
            if (obj == h0Var) {
                return;
            }
            h0Var2 = o.f6914a;
            if (obj == h0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6916a;
                h0Var3 = o.f6915b;
                if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater2, this, obj, h0Var3)) {
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f6916a;
                h0Var4 = o.f6914a;
                if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater3, this, obj, h0Var4)) {
                    m.a aVar = s3.m.f7565b;
                    ((m4.m) obj).resumeWith(s3.m.b(t.f7573a));
                    return;
                }
            }
        }
    }

    public final boolean h() {
        h0 h0Var;
        h0 h0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6916a;
        h0Var = o.f6914a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, h0Var);
        e4.k.b(andSet);
        h0Var2 = o.f6915b;
        return andSet == h0Var2;
    }
}
