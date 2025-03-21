package m4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f6212b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");

    /* renamed from: a  reason: collision with root package name */
    private final q0<T>[] f6213a;
    private volatile int notCompletedCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a extends a2 {

        /* renamed from: l  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f6214l = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");
        private volatile Object _disposer;

        /* renamed from: e  reason: collision with root package name */
        private final l<List<? extends T>> f6215e;

        /* renamed from: f  reason: collision with root package name */
        public b1 f6216f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l<? super List<? extends T>> lVar) {
            this.f6215e = lVar;
        }

        public final void A(b1 b1Var) {
            this.f6216f = b1Var;
        }

        @Override // d4.l
        public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
            u(th);
            return s3.t.f7573a;
        }

        @Override // m4.b0
        public void u(Throwable th) {
            if (th != null) {
                Object q5 = this.f6215e.q(th);
                if (q5 != null) {
                    this.f6215e.s(q5);
                    e<T>.b x4 = x();
                    if (x4 != null) {
                        x4.g();
                    }
                }
            } else if (e.f6212b.decrementAndGet(e.this) == 0) {
                l<List<? extends T>> lVar = this.f6215e;
                q0[] q0VarArr = ((e) e.this).f6213a;
                ArrayList arrayList = new ArrayList(q0VarArr.length);
                for (q0 q0Var : q0VarArr) {
                    arrayList.add(q0Var.i());
                }
                lVar.resumeWith(s3.m.b(arrayList));
            }
        }

        public final e<T>.b x() {
            return (b) f6214l.get(this);
        }

        public final b1 y() {
            b1 b1Var = this.f6216f;
            if (b1Var != null) {
                return b1Var;
            }
            e4.k.o("handle");
            return null;
        }

        public final void z(e<T>.b bVar) {
            f6214l.set(this, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b extends j {

        /* renamed from: a  reason: collision with root package name */
        private final e<T>.a[] f6218a;

        public b(e<T>.a[] aVarArr) {
            this.f6218a = aVarArr;
        }

        @Override // m4.k
        public void e(Throwable th) {
            g();
        }

        public final void g() {
            for (e<T>.a aVar : this.f6218a) {
                aVar.y().a();
            }
        }

        @Override // d4.l
        public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
            e(th);
            return s3.t.f7573a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f6218a + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(q0<? extends T>[] q0VarArr) {
        this.f6213a = q0VarArr;
        this.notCompletedCount = q0VarArr.length;
    }

    public final Object c(v3.d<? super List<? extends T>> dVar) {
        v3.d b5;
        Object c5;
        b5 = w3.c.b(dVar);
        m mVar = new m(b5, 1);
        mVar.B();
        int length = this.f6213a.length;
        a[] aVarArr = new a[length];
        for (int i5 = 0; i5 < length; i5++) {
            q0 q0Var = this.f6213a[i5];
            q0Var.start();
            a aVar = new a(mVar);
            aVar.A(q0Var.O(aVar));
            s3.t tVar = s3.t.f7573a;
            aVarArr[i5] = aVar;
        }
        e<T>.b bVar = new b(aVarArr);
        for (int i6 = 0; i6 < length; i6++) {
            aVarArr[i6].z(bVar);
        }
        if (mVar.k()) {
            bVar.g();
        } else {
            mVar.t(bVar);
        }
        Object y4 = mVar.y();
        c5 = w3.d.c();
        if (y4 == c5) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return y4;
    }
}
