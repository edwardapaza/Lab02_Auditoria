package o4;

import java.util.concurrent.atomic.AtomicReferenceArray;
import r4.e0;
/* loaded from: classes.dex */
public final class j<E> extends e0<j<E>> {

    /* renamed from: e  reason: collision with root package name */
    private final b<E> f6839e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReferenceArray f6840f;

    public j(long j5, j<E> jVar, b<E> bVar, int i5) {
        super(j5, jVar, i5);
        this.f6839e = bVar;
        this.f6840f = new AtomicReferenceArray(c.f6812b * 2);
    }

    private final void z(int i5, Object obj) {
        this.f6840f.lazySet(i5 * 2, obj);
    }

    public final void A(int i5, Object obj) {
        this.f6840f.set((i5 * 2) + 1, obj);
    }

    public final void B(int i5, E e5) {
        z(i5, e5);
    }

    @Override // r4.e0
    public int n() {
        return c.f6812b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
        s(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
        if (r0 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
        r4 = u().f6800b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        if (r4 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
        r4.z.b(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    @Override // r4.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(int r4, java.lang.Throwable r5, v3.g r6) {
        /*
            r3 = this;
            int r5 = o4.c.f6812b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.v(r4)
        Le:
            java.lang.Object r1 = r3.w(r4)
            boolean r2 = r1 instanceof m4.b3
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof o4.v
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            r4.h0 r2 = o4.c.j()
            if (r1 == r2) goto L63
            r4.h0 r2 = o4.c.i()
            if (r1 != r2) goto L28
            goto L63
        L28:
            r4.h0 r2 = o4.c.p()
            if (r1 == r2) goto Le
            r4.h0 r2 = o4.c.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            r4.h0 r4 = o4.c.f()
            if (r1 == r4) goto L62
            r4.h0 r4 = o4.c.f6814d
            if (r1 != r4) goto L40
            goto L62
        L40:
            r4.h0 r4 = o4.c.z()
            if (r1 != r4) goto L47
            return
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            return
        L63:
            r3.s(r4)
            if (r0 == 0) goto L73
            o4.b r4 = r3.u()
            d4.l<E, s3.t> r4 = r4.f6800b
            if (r4 == 0) goto L73
            r4.z.b(r4, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            r4.h0 r2 = o4.c.j()
            goto L7f
        L7b:
            r4.h0 r2 = o4.c.i()
        L7f:
            boolean r1 = r3.r(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.s(r4)
            r1 = r0 ^ 1
            r3.x(r4, r1)
            if (r0 == 0) goto L9a
            o4.b r4 = r3.u()
            d4.l<E, s3.t> r4 = r4.f6800b
            if (r4 == 0) goto L9a
            r4.z.b(r4, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.j.o(int, java.lang.Throwable, v3.g):void");
    }

    public final boolean r(int i5, Object obj, Object obj2) {
        return i.a(this.f6840f, (i5 * 2) + 1, obj, obj2);
    }

    public final void s(int i5) {
        z(i5, null);
    }

    public final Object t(int i5, Object obj) {
        return this.f6840f.getAndSet((i5 * 2) + 1, obj);
    }

    public final b<E> u() {
        b<E> bVar = this.f6839e;
        e4.k.b(bVar);
        return bVar;
    }

    public final E v(int i5) {
        return (E) this.f6840f.get(i5 * 2);
    }

    public final Object w(int i5) {
        return this.f6840f.get((i5 * 2) + 1);
    }

    public final void x(int i5, boolean z4) {
        if (z4) {
            u().A0((this.f7187c * c.f6812b) + i5);
        }
        p();
    }

    public final E y(int i5) {
        E v5 = v(i5);
        s(i5);
        return v5;
    }
}
