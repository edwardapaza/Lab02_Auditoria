package q4;

import m4.y1;
import s3.t;
import v3.g;
/* loaded from: classes.dex */
public final class l<T> extends kotlin.coroutines.jvm.internal.d implements p4.d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final p4.d<T> f7108a;

    /* renamed from: b  reason: collision with root package name */
    public final v3.g f7109b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7110c;

    /* renamed from: d  reason: collision with root package name */
    private v3.g f7111d;

    /* renamed from: e  reason: collision with root package name */
    private v3.d<? super t> f7112e;

    /* loaded from: classes.dex */
    static final class a extends e4.l implements d4.p<Integer, g.b, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f7113a = new a();

        a() {
            super(2);
        }

        public final Integer a(int i5, g.b bVar) {
            return Integer.valueOf(i5 + 1);
        }

        @Override // d4.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(p4.d<? super T> dVar, v3.g gVar) {
        super(j.f7103a, v3.h.f8175a);
        this.f7108a = dVar;
        this.f7109b = gVar;
        this.f7110c = ((Number) gVar.e0(0, a.f7113a)).intValue();
    }

    private final void a(v3.g gVar, v3.g gVar2, T t5) {
        if (gVar2 instanceof h) {
            g((h) gVar2, t5);
        }
        n.a(this, gVar);
    }

    private final Object f(v3.d<? super t> dVar, T t5) {
        d4.q qVar;
        Object c5;
        v3.g context = dVar.getContext();
        y1.h(context);
        v3.g gVar = this.f7111d;
        if (gVar != context) {
            a(context, gVar, t5);
            this.f7111d = context;
        }
        this.f7112e = dVar;
        qVar = m.f7114a;
        p4.d<T> dVar2 = this.f7108a;
        e4.k.c(dVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        e4.k.c(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object d5 = qVar.d(dVar2, t5, this);
        c5 = w3.d.c();
        if (!e4.k.a(d5, c5)) {
            this.f7112e = null;
        }
        return d5;
    }

    private final void g(h hVar, Object obj) {
        String e5;
        e5 = k4.h.e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + hVar.f7101a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(e5.toString());
    }

    @Override // p4.d
    public Object c(T t5, v3.d<? super t> dVar) {
        Object c5;
        Object c6;
        try {
            Object f5 = f(dVar, t5);
            c5 = w3.d.c();
            if (f5 == c5) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            c6 = w3.d.c();
            return f5 == c6 ? f5 : t.f7573a;
        } catch (Throwable th) {
            this.f7111d = new h(th, dVar.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a, kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        v3.d<? super t> dVar = this.f7112e;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.d, v3.d
    public v3.g getContext() {
        v3.g gVar = this.f7111d;
        return gVar == null ? v3.h.f8175a : gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public Object invokeSuspend(Object obj) {
        Object c5;
        Throwable d5 = s3.m.d(obj);
        if (d5 != null) {
            this.f7111d = new h(d5, getContext());
        }
        v3.d<? super t> dVar = this.f7112e;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        c5 = w3.d.c();
        return c5;
    }

    @Override // kotlin.coroutines.jvm.internal.d, kotlin.coroutines.jvm.internal.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
