package a0;

import d4.p;
import e4.k;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import m4.h;
import m4.j0;
import m4.k0;
import m4.n1;
import m4.u1;
import p4.c;
import s3.n;
import s3.t;
import v3.d;
import w3.b;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final ReentrantLock f1a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final Map<k.a<?>, u1> f2b = new LinkedHashMap();

    @f(c = "androidx.window.java.core.CallbackToFlowAdapter$connect$1$1", f = "CallbackToFlowAdapter.kt", l = {46}, m = "invokeSuspend")
    /* renamed from: a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0000a extends l implements p<j0, d<? super t>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f3a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c<T> f4b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k.a<T> f5c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a0.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0001a<T> implements p4.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ k.a<T> f6a;

            C0001a(k.a<T> aVar) {
                this.f6a = aVar;
            }

            @Override // p4.d
            public final Object c(T t5, d<? super t> dVar) {
                this.f6a.accept(t5);
                return t.f7573a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0000a(c<? extends T> cVar, k.a<T> aVar, d<? super C0000a> dVar) {
            super(2, dVar);
            this.f4b = cVar;
            this.f5c = aVar;
        }

        @Override // d4.p
        /* renamed from: a */
        public final Object invoke(j0 j0Var, d<? super t> dVar) {
            return ((C0000a) create(j0Var, dVar)).invokeSuspend(t.f7573a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final d<t> create(Object obj, d<?> dVar) {
            return new C0000a(this.f4b, this.f5c, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i5 = this.f3a;
            if (i5 == 0) {
                n.b(obj);
                c<T> cVar = this.f4b;
                C0001a c0001a = new C0001a(this.f5c);
                this.f3a = 1;
                if (cVar.b(c0001a, this) == c5) {
                    return c5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            return t.f7573a;
        }
    }

    public final <T> void a(Executor executor, k.a<T> aVar, c<? extends T> cVar) {
        k.e(executor, "executor");
        k.e(aVar, "consumer");
        k.e(cVar, "flow");
        ReentrantLock reentrantLock = this.f1a;
        reentrantLock.lock();
        try {
            if (this.f2b.get(aVar) == null) {
                this.f2b.put(aVar, h.d(k0.a(n1.a(executor)), null, null, new C0000a(cVar, aVar, null), 3, null));
            }
            t tVar = t.f7573a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(k.a<?> aVar) {
        k.e(aVar, "consumer");
        ReentrantLock reentrantLock = this.f1a;
        reentrantLock.lock();
        try {
            u1 u1Var = this.f2b.get(aVar);
            if (u1Var != null) {
                u1.a.a(u1Var, null, 1, null);
            }
            this.f2b.remove(aVar);
        } finally {
            reentrantLock.unlock();
        }
    }
}
