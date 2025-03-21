package q4;

import r4.l0;
import s3.t;
/* loaded from: classes.dex */
final class q<T> implements p4.d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final v3.g f7120a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f7121b;

    /* renamed from: c  reason: collision with root package name */
    private final d4.p<T, v3.d<? super t>, Object> f7122c;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {212}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class a extends kotlin.coroutines.jvm.internal.l implements d4.p<T, v3.d<? super t>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f7123a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f7124b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ p4.d<T> f7125c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(p4.d<? super T> dVar, v3.d<? super a> dVar2) {
            super(2, dVar2);
            this.f7125c = dVar;
        }

        @Override // d4.p
        /* renamed from: a */
        public final Object invoke(T t5, v3.d<? super t> dVar) {
            return ((a) create(t5, dVar)).invokeSuspend(t.f7573a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v3.d<t> create(Object obj, v3.d<?> dVar) {
            a aVar = new a(this.f7125c, dVar);
            aVar.f7124b = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object c5;
            c5 = w3.d.c();
            int i5 = this.f7123a;
            if (i5 == 0) {
                s3.n.b(obj);
                Object obj2 = this.f7124b;
                this.f7123a = 1;
                if (this.f7125c.c(obj2, this) == c5) {
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

    public q(p4.d<? super T> dVar, v3.g gVar) {
        this.f7120a = gVar;
        this.f7121b = l0.b(gVar);
        this.f7122c = new a(dVar, null);
    }

    @Override // p4.d
    public Object c(T t5, v3.d<? super t> dVar) {
        Object c5;
        Object b5 = e.b(this.f7120a, t5, this.f7121b, this.f7122c, dVar);
        c5 = w3.d.c();
        return b5 == c5 ? b5 : t.f7573a;
    }
}
