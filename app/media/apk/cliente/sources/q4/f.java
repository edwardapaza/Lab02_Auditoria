package q4;

import m4.f0;
import o4.r;
import s3.t;
import v3.e;
/* loaded from: classes.dex */
public abstract class f<S, T> extends d<T> {

    /* renamed from: d  reason: collision with root package name */
    protected final p4.c<S> f7097d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {152}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends kotlin.coroutines.jvm.internal.l implements d4.p<p4.d<? super T>, v3.d<? super t>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f7098a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f7099b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f<S, T> f7100c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(f<S, T> fVar, v3.d<? super a> dVar) {
            super(2, dVar);
            this.f7100c = fVar;
        }

        @Override // d4.p
        /* renamed from: a */
        public final Object invoke(p4.d<? super T> dVar, v3.d<? super t> dVar2) {
            return ((a) create(dVar, dVar2)).invokeSuspend(t.f7573a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v3.d<t> create(Object obj, v3.d<?> dVar) {
            a aVar = new a(this.f7100c, dVar);
            aVar.f7099b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object c5;
            c5 = w3.d.c();
            int i5 = this.f7098a;
            if (i5 == 0) {
                s3.n.b(obj);
                f<S, T> fVar = this.f7100c;
                this.f7098a = 1;
                if (fVar.m((p4.d) this.f7099b, this) == c5) {
                    return c5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                s3.n.b(obj);
            }
            return t.f7573a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(p4.c<? extends S> cVar, v3.g gVar, int i5, o4.a aVar) {
        super(gVar, i5, aVar);
        this.f7097d = cVar;
    }

    static /* synthetic */ <S, T> Object j(f<S, T> fVar, p4.d<? super T> dVar, v3.d<? super t> dVar2) {
        Object c5;
        Object c6;
        Object c7;
        if (fVar.f7088b == -3) {
            v3.g context = dVar2.getContext();
            v3.g e5 = f0.e(context, fVar.f7087a);
            if (e4.k.a(e5, context)) {
                Object m5 = fVar.m(dVar, dVar2);
                c7 = w3.d.c();
                return m5 == c7 ? m5 : t.f7573a;
            }
            e.b bVar = v3.e.f8172j;
            if (e4.k.a(e5.d(bVar), context.d(bVar))) {
                Object l5 = fVar.l(dVar, e5, dVar2);
                c6 = w3.d.c();
                return l5 == c6 ? l5 : t.f7573a;
            }
        }
        Object b5 = super.b(dVar, dVar2);
        c5 = w3.d.c();
        return b5 == c5 ? b5 : t.f7573a;
    }

    static /* synthetic */ <S, T> Object k(f<S, T> fVar, r<? super T> rVar, v3.d<? super t> dVar) {
        Object c5;
        Object m5 = fVar.m(new o(rVar), dVar);
        c5 = w3.d.c();
        return m5 == c5 ? m5 : t.f7573a;
    }

    private final Object l(p4.d<? super T> dVar, v3.g gVar, v3.d<? super t> dVar2) {
        Object c5;
        Object c6 = e.c(gVar, e.a(dVar, dVar2.getContext()), null, new a(this, null), dVar2, 4, null);
        c5 = w3.d.c();
        return c6 == c5 ? c6 : t.f7573a;
    }

    @Override // q4.d, p4.c
    public Object b(p4.d<? super T> dVar, v3.d<? super t> dVar2) {
        return j(this, dVar, dVar2);
    }

    @Override // q4.d
    protected Object e(r<? super T> rVar, v3.d<? super t> dVar) {
        return k(this, rVar, dVar);
    }

    protected abstract Object m(p4.d<? super T> dVar, v3.d<? super t> dVar2);

    @Override // q4.d
    public String toString() {
        return this.f7097d + " -> " + super.toString();
    }
}
