package q4;

import e4.u;
import s3.t;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final d4.q<p4.d<Object>, Object, v3.d<? super t>, Object> f7114a;

    /* loaded from: classes.dex */
    /* synthetic */ class a extends e4.j implements d4.q<p4.d<? super Object>, Object, v3.d<? super t>, Object> {

        /* renamed from: n  reason: collision with root package name */
        public static final a f7115n = new a();

        a() {
            super(3, p4.d.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // d4.q
        /* renamed from: i */
        public final Object d(p4.d<Object> dVar, Object obj, v3.d<? super t> dVar2) {
            return dVar.c(obj, dVar2);
        }
    }

    static {
        a aVar = a.f7115n;
        e4.k.c(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f7114a = (d4.q) u.a(aVar, 3);
    }
}
