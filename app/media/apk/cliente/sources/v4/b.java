package v4;

import d4.l;
import d4.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.h;
import m4.b3;
import m4.m;
import m4.n0;
import m4.o;
import r4.e0;
import r4.h0;
import s3.t;
import v3.g;
/* loaded from: classes.dex */
public class b extends d implements v4.a {

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f8176i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner");

    /* renamed from: h  reason: collision with root package name */
    private final q<u4.b<?>, Object, Object, l<Throwable, t>> f8177h;
    private volatile Object owner;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements m4.l<t>, b3 {

        /* renamed from: a  reason: collision with root package name */
        public final m<t> f8178a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f8179b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: v4.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0121a extends e4.l implements l<Throwable, t> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f8181a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f8182b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0121a(b bVar, a aVar) {
                super(1);
                this.f8181a = bVar;
                this.f8182b = aVar;
            }

            public final void a(Throwable th) {
                this.f8181a.a(this.f8182b.f8179b);
            }

            @Override // d4.l
            public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                a(th);
                return t.f7573a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: v4.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0122b extends e4.l implements l<Throwable, t> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f8183a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f8184b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0122b(b bVar, a aVar) {
                super(1);
                this.f8183a = bVar;
                this.f8184b = aVar;
            }

            public final void a(Throwable th) {
                b.f8176i.set(this.f8183a, this.f8184b.f8179b);
                this.f8183a.a(this.f8184b.f8179b);
            }

            @Override // d4.l
            public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                a(th);
                return t.f7573a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(m<? super t> mVar, Object obj) {
            this.f8178a = mVar;
            this.f8179b = obj;
        }

        @Override // m4.l
        /* renamed from: a */
        public void e(t tVar, l<? super Throwable, t> lVar) {
            b.f8176i.set(b.this, this.f8179b);
            this.f8178a.e(tVar, new C0121a(b.this, this));
        }

        @Override // m4.l
        /* renamed from: b */
        public Object h(t tVar, Object obj, l<? super Throwable, t> lVar) {
            Object h5 = this.f8178a.h(tVar, obj, new C0122b(b.this, this));
            if (h5 != null) {
                b.f8176i.set(b.this, this.f8179b);
            }
            return h5;
        }

        @Override // m4.b3
        public void f(e0<?> e0Var, int i5) {
            this.f8178a.f(e0Var, i5);
        }

        @Override // v3.d
        public g getContext() {
            return this.f8178a.getContext();
        }

        @Override // m4.l
        public boolean k() {
            return this.f8178a.k();
        }

        @Override // m4.l
        public Object q(Throwable th) {
            return this.f8178a.q(th);
        }

        @Override // v3.d
        public void resumeWith(Object obj) {
            this.f8178a.resumeWith(obj);
        }

        @Override // m4.l
        public void s(Object obj) {
            this.f8178a.s(obj);
        }

        @Override // m4.l
        public void t(l<? super Throwable, t> lVar) {
            this.f8178a.t(lVar);
        }
    }

    /* renamed from: v4.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0123b extends e4.l implements q<u4.b<?>, Object, Object, l<? super Throwable, ? extends t>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: v4.b$b$a */
        /* loaded from: classes.dex */
        public static final class a extends e4.l implements l<Throwable, t> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f8186a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f8187b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(b bVar, Object obj) {
                super(1);
                this.f8186a = bVar;
                this.f8187b = obj;
            }

            public final void a(Throwable th) {
                this.f8186a.a(this.f8187b);
            }

            @Override // d4.l
            public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                a(th);
                return t.f7573a;
            }
        }

        C0123b() {
            super(3);
        }

        @Override // d4.q
        /* renamed from: a */
        public final l<Throwable, t> d(u4.b<?> bVar, Object obj, Object obj2) {
            return new a(b.this, obj);
        }
    }

    public b(boolean z4) {
        super(1, z4 ? 1 : 0);
        this.owner = z4 ? null : c.f8188a;
        this.f8177h = new C0123b();
    }

    private final int m(Object obj) {
        h0 h0Var;
        while (n()) {
            Object obj2 = f8176i.get(this);
            h0Var = c.f8188a;
            if (obj2 != h0Var) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object o(b bVar, Object obj, v3.d<? super t> dVar) {
        Object c5;
        if (bVar.q(obj)) {
            return t.f7573a;
        }
        Object p5 = bVar.p(obj, dVar);
        c5 = w3.d.c();
        return p5 == c5 ? p5 : t.f7573a;
    }

    private final Object p(Object obj, v3.d<? super t> dVar) {
        v3.d b5;
        Object c5;
        Object c6;
        b5 = w3.c.b(dVar);
        m b6 = o.b(b5);
        try {
            c(new a(b6, obj));
            Object y4 = b6.y();
            c5 = w3.d.c();
            if (y4 == c5) {
                h.c(dVar);
            }
            c6 = w3.d.c();
            return y4 == c6 ? y4 : t.f7573a;
        } catch (Throwable th) {
            b6.J();
            throw th;
        }
    }

    private final int r(Object obj) {
        while (!i()) {
            if (obj == null) {
                return 1;
            }
            int m5 = m(obj);
            if (m5 == 1) {
                return 2;
            }
            if (m5 == 2) {
                return 1;
            }
        }
        f8176i.set(this, obj);
        return 0;
    }

    @Override // v4.a
    public void a(Object obj) {
        h0 h0Var;
        h0 h0Var2;
        while (n()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8176i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            h0Var = c.f8188a;
            if (obj2 != h0Var) {
                if (!(obj2 == obj || obj == null)) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                h0Var2 = c.f8188a;
                if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj2, h0Var2)) {
                    h();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    @Override // v4.a
    public Object b(Object obj, v3.d<? super t> dVar) {
        return o(this, obj, dVar);
    }

    public boolean n() {
        return g() == 0;
    }

    public boolean q(Object obj) {
        int r5 = r(obj);
        if (r5 != 0) {
            if (r5 != 1) {
                if (r5 != 2) {
                    throw new IllegalStateException("unexpected".toString());
                }
                throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
            }
            return false;
        }
        return true;
    }

    public String toString() {
        return "Mutex@" + n0.b(this) + "[isLocked=" + n() + ",owner=" + f8176i.get(this) + ']';
    }
}
