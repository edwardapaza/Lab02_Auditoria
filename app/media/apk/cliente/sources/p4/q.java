package p4;

import s3.t;
/* loaded from: classes.dex */
public final class q<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d<T> f6917a;

    /* renamed from: b  reason: collision with root package name */
    private final d4.p<d<? super T>, v3.d<? super t>, Object> f6918b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
    /* loaded from: classes.dex */
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f6919a;

        /* renamed from: b  reason: collision with root package name */
        Object f6920b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f6921c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ q<T> f6922d;

        /* renamed from: e  reason: collision with root package name */
        int f6923e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(q<T> qVar, v3.d<? super a> dVar) {
            super(dVar);
            this.f6922d = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f6921c = obj;
            this.f6923e |= Integer.MIN_VALUE;
            return this.f6922d.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [q4.l] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(v3.d<? super s3.t> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof p4.q.a
            if (r0 == 0) goto L13
            r0 = r7
            p4.q$a r0 = (p4.q.a) r0
            int r1 = r0.f6923e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6923e = r1
            goto L18
        L13:
            p4.q$a r0 = new p4.q$a
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f6921c
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.f6923e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            s3.n.b(r7)
            goto L77
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            java.lang.Object r2 = r0.f6920b
            q4.l r2 = (q4.l) r2
            java.lang.Object r4 = r0.f6919a
            p4.q r4 = (p4.q) r4
            s3.n.b(r7)     // Catch: java.lang.Throwable -> L7d
            goto L5e
        L40:
            s3.n.b(r7)
            q4.l r2 = new q4.l
            p4.d<T> r7 = r6.f6917a
            v3.g r5 = r0.getContext()
            r2.<init>(r7, r5)
            d4.p<p4.d<? super T>, v3.d<? super s3.t>, java.lang.Object> r7 = r6.f6918b     // Catch: java.lang.Throwable -> L7d
            r0.f6919a = r6     // Catch: java.lang.Throwable -> L7d
            r0.f6920b = r2     // Catch: java.lang.Throwable -> L7d
            r0.f6923e = r4     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r7 = r7.invoke(r2, r0)     // Catch: java.lang.Throwable -> L7d
            if (r7 != r1) goto L5d
            return r1
        L5d:
            r4 = r6
        L5e:
            r2.releaseIntercepted()
            p4.d<T> r7 = r4.f6917a
            boolean r2 = r7 instanceof p4.q
            if (r2 == 0) goto L7a
            p4.q r7 = (p4.q) r7
            r2 = 0
            r0.f6919a = r2
            r0.f6920b = r2
            r0.f6923e = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L77
            return r1
        L77:
            s3.t r7 = s3.t.f7573a
            return r7
        L7a:
            s3.t r7 = s3.t.f7573a
            return r7
        L7d:
            r7 = move-exception
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.q.a(v3.d):java.lang.Object");
    }

    @Override // p4.d
    public Object c(T t5, v3.d<? super t> dVar) {
        return this.f6917a.c(t5, dVar);
    }
}
