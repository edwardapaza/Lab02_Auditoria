package m4;

import java.util.List;
/* loaded from: classes.dex */
public final class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {66}, m = "joinAll")
    /* loaded from: classes.dex */
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f6222a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f6223b;

        /* renamed from: c  reason: collision with root package name */
        int f6224c;

        a(v3.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f6223b = obj;
            this.f6224c |= Integer.MIN_VALUE;
            return f.b(null, this);
        }
    }

    public static final <T> Object a(q0<? extends T>[] q0VarArr, v3.d<? super List<? extends T>> dVar) {
        List f5;
        if (q0VarArr.length == 0) {
            f5 = t3.p.f();
            return f5;
        }
        return new e(q0VarArr).c(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.util.Collection<? extends m4.u1> r4, v3.d<? super s3.t> r5) {
        /*
            boolean r0 = r5 instanceof m4.f.a
            if (r0 == 0) goto L13
            r0 = r5
            m4.f$a r0 = (m4.f.a) r0
            int r1 = r0.f6224c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6224c = r1
            goto L18
        L13:
            m4.f$a r0 = new m4.f$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f6223b
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.f6224c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f6222a
            java.util.Iterator r4 = (java.util.Iterator) r4
            s3.n.b(r5)
            goto L3c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            s3.n.b(r5)
            java.util.Iterator r4 = r4.iterator()
        L3c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L53
            java.lang.Object r5 = r4.next()
            m4.u1 r5 = (m4.u1) r5
            r0.f6222a = r4
            r0.f6224c = r3
            java.lang.Object r5 = r5.p(r0)
            if (r5 != r1) goto L3c
            return r1
        L53:
            s3.t r4 = s3.t.f7573a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.f.b(java.util.Collection, v3.d):java.lang.Object");
    }
}
