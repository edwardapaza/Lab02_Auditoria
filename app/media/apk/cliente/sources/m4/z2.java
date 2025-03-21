package m4;
/* loaded from: classes.dex */
public final class z2<T> extends r4.d0<T> {

    /* renamed from: e  reason: collision with root package name */
    private final ThreadLocal<s3.l<v3.g, Object>> f6303e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z2(v3.g r3, v3.d<? super T> r4) {
        /*
            r2 = this;
            m4.a3 r0 = m4.a3.f6180a
            v3.g$b r1 = r3.d(r0)
            if (r1 != 0) goto Ld
            v3.g r0 = r3.J(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f6303e = r0
            v3.g r4 = r4.getContext()
            v3.e$b r0 = v3.e.f8172j
            v3.g$b r4 = r4.d(r0)
            boolean r4 = r4 instanceof m4.g0
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = r4.l0.c(r3, r4)
            r4.l0.a(r3, r4)
            r2.Y0(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.z2.<init>(v3.g, v3.d):void");
    }

    @Override // r4.d0, m4.a
    protected void T0(Object obj) {
        if (this.threadLocalIsSet) {
            s3.l<v3.g, Object> lVar = this.f6303e.get();
            if (lVar != null) {
                r4.l0.a(lVar.a(), lVar.b());
            }
            this.f6303e.remove();
        }
        Object a5 = d0.a(obj, this.f7183d);
        v3.d<T> dVar = this.f7183d;
        v3.g context = dVar.getContext();
        Object c5 = r4.l0.c(context, null);
        z2<?> g5 = c5 != r4.l0.f7204a ? f0.g(dVar, context, c5) : null;
        try {
            this.f7183d.resumeWith(a5);
            s3.t tVar = s3.t.f7573a;
        } finally {
            if (g5 == null || g5.X0()) {
                r4.l0.a(context, c5);
            }
        }
    }

    public final boolean X0() {
        boolean z4 = this.threadLocalIsSet && this.f6303e.get() == null;
        this.f6303e.remove();
        return !z4;
    }

    public final void Y0(v3.g gVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f6303e.set(s3.p.a(gVar, obj));
    }
}
