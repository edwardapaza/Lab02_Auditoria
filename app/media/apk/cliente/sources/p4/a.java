package p4;

import s3.t;
/* loaded from: classes.dex */
final class a<T> extends b<T> {

    /* renamed from: e  reason: collision with root package name */
    private final d4.p<o4.r<? super T>, v3.d<? super t>, Object> f6891e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {334}, m = "collectTo")
    /* renamed from: p4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0106a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f6892a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f6893b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a<T> f6894c;

        /* renamed from: d  reason: collision with root package name */
        int f6895d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0106a(a<T> aVar, v3.d<? super C0106a> dVar) {
            super(dVar);
            this.f6894c = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f6893b = obj;
            this.f6895d |= Integer.MIN_VALUE;
            return this.f6894c.e(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(d4.p<? super o4.r<? super T>, ? super v3.d<? super t>, ? extends Object> pVar, v3.g gVar, int i5, o4.a aVar) {
        super(pVar, gVar, i5, aVar);
        this.f6891e = pVar;
    }

    public /* synthetic */ a(d4.p pVar, v3.g gVar, int i5, o4.a aVar, int i6, e4.g gVar2) {
        this(pVar, (i6 & 2) != 0 ? v3.h.f8175a : gVar, (i6 & 4) != 0 ? -2 : i5, (i6 & 8) != 0 ? o4.a.SUSPEND : aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    @Override // p4.b, q4.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(o4.r<? super T> r5, v3.d<? super s3.t> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p4.a.C0106a
            if (r0 == 0) goto L13
            r0 = r6
            p4.a$a r0 = (p4.a.C0106a) r0
            int r1 = r0.f6895d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6895d = r1
            goto L18
        L13:
            p4.a$a r0 = new p4.a$a
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f6893b
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.f6895d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f6892a
            o4.r r5 = (o4.r) r5
            s3.n.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            s3.n.b(r6)
            r0.f6892a = r5
            r0.f6895d = r3
            java.lang.Object r6 = super.e(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.m()
            if (r5 == 0) goto L4c
            s3.t r5 = s3.t.f7573a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.a.e(o4.r, v3.d):java.lang.Object");
    }

    @Override // q4.d
    protected q4.d<T> f(v3.g gVar, int i5, o4.a aVar) {
        return new a(this.f6891e, gVar, i5, aVar);
    }
}
