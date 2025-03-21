package o4;

import m4.f0;
import m4.j0;
import m4.l0;
import s3.m;
/* loaded from: classes.dex */
public final class p {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {153}, m = "awaitClose")
    /* loaded from: classes.dex */
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a */
        Object f6843a;

        /* renamed from: b */
        Object f6844b;

        /* renamed from: c */
        /* synthetic */ Object f6845c;

        /* renamed from: d */
        int f6846d;

        a(v3.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f6845c = obj;
            this.f6846d |= Integer.MIN_VALUE;
            return p.a(null, null, this);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e4.l implements d4.l<Throwable, s3.t> {

        /* renamed from: a */
        final /* synthetic */ m4.l<s3.t> f6847a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(m4.l<? super s3.t> lVar) {
            super(1);
            this.f6847a = lVar;
        }

        public final void a(Throwable th) {
            m4.l<s3.t> lVar = this.f6847a;
            m.a aVar = s3.m.f7565b;
            lVar.resumeWith(s3.m.b(s3.t.f7573a));
        }

        @Override // d4.l
        public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
            a(th);
            return s3.t.f7573a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(o4.r<?> r4, d4.a<s3.t> r5, v3.d<? super s3.t> r6) {
        /*
            boolean r0 = r6 instanceof o4.p.a
            if (r0 == 0) goto L13
            r0 = r6
            o4.p$a r0 = (o4.p.a) r0
            int r1 = r0.f6846d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6846d = r1
            goto L18
        L13:
            o4.p$a r0 = new o4.p$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f6845c
            java.lang.Object r1 = w3.b.c()
            int r2 = r0.f6846d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f6844b
            r5 = r4
            d4.a r5 = (d4.a) r5
            java.lang.Object r4 = r0.f6843a
            o4.r r4 = (o4.r) r4
            s3.n.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L7a
        L32:
            r4 = move-exception
            goto L80
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            s3.n.b(r6)
            v3.g r6 = r0.getContext()
            m4.u1$b r2 = m4.u1.f6282h
            v3.g$b r6 = r6.d(r2)
            if (r6 != r4) goto L4d
            r6 = 1
            goto L4e
        L4d:
            r6 = 0
        L4e:
            if (r6 == 0) goto L84
            r0.f6843a = r4     // Catch: java.lang.Throwable -> L32
            r0.f6844b = r5     // Catch: java.lang.Throwable -> L32
            r0.f6846d = r3     // Catch: java.lang.Throwable -> L32
            m4.m r6 = new m4.m     // Catch: java.lang.Throwable -> L32
            v3.d r2 = w3.b.b(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.B()     // Catch: java.lang.Throwable -> L32
            o4.p$b r2 = new o4.p$b     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.f(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.y()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = w3.b.c()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L77
            kotlin.coroutines.jvm.internal.h.c(r0)     // Catch: java.lang.Throwable -> L32
        L77:
            if (r4 != r1) goto L7a
            return r1
        L7a:
            r5.b()
            s3.t r4 = s3.t.f7573a
            return r4
        L80:
            r5.b()
            throw r4
        L84:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.p.a(o4.r, d4.a, v3.d):java.lang.Object");
    }

    public static final <E> t<E> b(j0 j0Var, v3.g gVar, int i5, o4.a aVar, l0 l0Var, d4.l<? super Throwable, s3.t> lVar, d4.p<? super r<? super E>, ? super v3.d<? super s3.t>, ? extends Object> pVar) {
        q qVar = new q(f0.d(j0Var, gVar), g.b(i5, aVar, null, 4, null));
        if (lVar != null) {
            qVar.O(lVar);
        }
        qVar.W0(l0Var, qVar, pVar);
        return qVar;
    }

    public static /* synthetic */ t c(j0 j0Var, v3.g gVar, int i5, o4.a aVar, l0 l0Var, d4.l lVar, d4.p pVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            gVar = v3.h.f8175a;
        }
        v3.g gVar2 = gVar;
        int i7 = (i6 & 2) != 0 ? 0 : i5;
        if ((i6 & 4) != 0) {
            aVar = o4.a.SUSPEND;
        }
        o4.a aVar2 = aVar;
        if ((i6 & 8) != 0) {
            l0Var = l0.DEFAULT;
        }
        l0 l0Var2 = l0Var;
        if ((i6 & 16) != 0) {
            lVar = null;
        }
        return b(j0Var, gVar2, i7, aVar2, l0Var2, lVar, pVar);
    }
}
