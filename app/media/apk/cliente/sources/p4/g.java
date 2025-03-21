package p4;

import o4.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class g {

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {36, 37}, m = "emitAllImpl$FlowKt__ChannelsKt")
    /* loaded from: classes.dex */
    public static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f6897a;

        /* renamed from: b  reason: collision with root package name */
        Object f6898b;

        /* renamed from: c  reason: collision with root package name */
        Object f6899c;

        /* renamed from: d  reason: collision with root package name */
        boolean f6900d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ Object f6901e;

        /* renamed from: f  reason: collision with root package name */
        int f6902f;

        a(v3.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f6901e = obj;
            this.f6902f |= Integer.MIN_VALUE;
            return g.c(null, null, false, this);
        }
    }

    public static final <T> Object b(d<? super T> dVar, t<? extends T> tVar, v3.d<? super s3.t> dVar2) {
        Object c5;
        Object c6 = c(dVar, tVar, true, dVar2);
        c5 = w3.d.c();
        return c6 == c5 ? c6 : s3.t.f7573a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e A[Catch: all -> 0x009b, TRY_LEAVE, TryCatch #0 {all -> 0x009b, blocks: (B:13:0x0036, B:22:0x0060, B:26:0x0075, B:28:0x007e, B:18:0x0052, B:21:0x005c), top: B:41:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0090 -> B:14:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(p4.d<? super T> r7, o4.t<? extends T> r8, boolean r9, v3.d<? super s3.t> r10) {
        /*
            boolean r0 = r10 instanceof p4.g.a
            if (r0 == 0) goto L13
            r0 = r10
            p4.g$a r0 = (p4.g.a) r0
            int r1 = r0.f6902f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6902f = r1
            goto L18
        L13:
            p4.g$a r0 = new p4.g$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f6901e
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.f6902f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L56
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            boolean r9 = r0.f6900d
            java.lang.Object r7 = r0.f6899c
            o4.f r7 = (o4.f) r7
            java.lang.Object r8 = r0.f6898b
            o4.t r8 = (o4.t) r8
            java.lang.Object r2 = r0.f6897a
            p4.d r2 = (p4.d) r2
            s3.n.b(r10)     // Catch: java.lang.Throwable -> L9b
        L39:
            r10 = r7
            r7 = r2
            goto L60
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            boolean r9 = r0.f6900d
            java.lang.Object r7 = r0.f6899c
            o4.f r7 = (o4.f) r7
            java.lang.Object r8 = r0.f6898b
            o4.t r8 = (o4.t) r8
            java.lang.Object r2 = r0.f6897a
            p4.d r2 = (p4.d) r2
            s3.n.b(r10)     // Catch: java.lang.Throwable -> L9b
            goto L75
        L56:
            s3.n.b(r10)
            p4.e.c(r7)
            o4.f r10 = r8.iterator()     // Catch: java.lang.Throwable -> L9b
        L60:
            r0.f6897a = r7     // Catch: java.lang.Throwable -> L9b
            r0.f6898b = r8     // Catch: java.lang.Throwable -> L9b
            r0.f6899c = r10     // Catch: java.lang.Throwable -> L9b
            r0.f6900d = r9     // Catch: java.lang.Throwable -> L9b
            r0.f6902f = r4     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r2 = r10.a(r0)     // Catch: java.lang.Throwable -> L9b
            if (r2 != r1) goto L71
            return r1
        L71:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L75:
            r5 = 0
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L9b
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L9b
            if (r10 == 0) goto L93
            java.lang.Object r10 = r7.next()     // Catch: java.lang.Throwable -> L9b
            r0.f6897a = r2     // Catch: java.lang.Throwable -> L9b
            r0.f6898b = r8     // Catch: java.lang.Throwable -> L9b
            r0.f6899c = r7     // Catch: java.lang.Throwable -> L9b
            r0.f6900d = r9     // Catch: java.lang.Throwable -> L9b
            r0.f6902f = r3     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r10 = r2.c(r10, r0)     // Catch: java.lang.Throwable -> L9b
            if (r10 != r1) goto L39
            return r1
        L93:
            if (r9 == 0) goto L98
            o4.k.a(r8, r5)
        L98:
            s3.t r7 = s3.t.f7573a
            return r7
        L9b:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L9d
        L9d:
            r10 = move-exception
            if (r9 == 0) goto La3
            o4.k.a(r8, r7)
        La3:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.g.c(p4.d, o4.t, boolean, v3.d):java.lang.Object");
    }
}
