package w3;

import d4.p;
import e4.k;
import e4.u;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;
import s3.n;
import s3.t;
import v3.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public static final class a extends j {

        /* renamed from: a  reason: collision with root package name */
        private int f8262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f8263b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f8264c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v3.d dVar, p pVar, Object obj) {
            super(dVar);
            this.f8263b = pVar;
            this.f8264c = obj;
            k.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i5 = this.f8262a;
            if (i5 == 0) {
                this.f8262a = 1;
                n.b(obj);
                k.c(this.f8263b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) u.a(this.f8263b, 2)).invoke(this.f8264c, this);
            } else if (i5 == 1) {
                this.f8262a = 2;
                n.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        private int f8265a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f8266b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f8267c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(v3.d dVar, g gVar, p pVar, Object obj) {
            super(dVar, gVar);
            this.f8266b = pVar;
            this.f8267c = obj;
            k.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i5 = this.f8265a;
            if (i5 == 0) {
                this.f8265a = 1;
                n.b(obj);
                k.c(this.f8266b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) u.a(this.f8266b, 2)).invoke(this.f8267c, this);
            } else if (i5 == 1) {
                this.f8265a = 2;
                n.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    public static <R, T> v3.d<t> a(p<? super R, ? super v3.d<? super T>, ? extends Object> pVar, R r5, v3.d<? super T> dVar) {
        k.e(pVar, "<this>");
        k.e(dVar, "completion");
        v3.d<?> a5 = h.a(dVar);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(r5, a5);
        }
        g context = a5.getContext();
        return context == v3.h.f8175a ? new a(a5, pVar, r5) : new b(a5, context, pVar, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> v3.d<T> b(v3.d<? super T> dVar) {
        v3.d<T> dVar2;
        k.e(dVar, "<this>");
        kotlin.coroutines.jvm.internal.d dVar3 = dVar instanceof kotlin.coroutines.jvm.internal.d ? (kotlin.coroutines.jvm.internal.d) dVar : null;
        return (dVar3 == null || (dVar2 = (v3.d<T>) dVar3.intercepted()) == null) ? dVar : dVar2;
    }
}
