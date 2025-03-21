package com.google.protobuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o0 implements p1 {

    /* renamed from: b  reason: collision with root package name */
    private static final v0 f2087b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final v0 f2088a;

    /* loaded from: classes.dex */
    class a implements v0 {
        a() {
        }

        @Override // com.google.protobuf.v0
        public u0 a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.protobuf.v0
        public boolean b(Class<?> cls) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements v0 {

        /* renamed from: a  reason: collision with root package name */
        private v0[] f2089a;

        b(v0... v0VarArr) {
            this.f2089a = v0VarArr;
        }

        @Override // com.google.protobuf.v0
        public u0 a(Class<?> cls) {
            v0[] v0VarArr;
            for (v0 v0Var : this.f2089a) {
                if (v0Var.b(cls)) {
                    return v0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.protobuf.v0
        public boolean b(Class<?> cls) {
            for (v0 v0Var : this.f2089a) {
                if (v0Var.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public o0() {
        this(b());
    }

    private o0(v0 v0Var) {
        this.f2088a = (v0) d0.b(v0Var, "messageInfoFactory");
    }

    private static v0 b() {
        return new b(y.c(), c());
    }

    private static v0 c() {
        try {
            return (v0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f2087b;
        }
    }

    private static boolean d(u0 u0Var) {
        return u0Var.b() == i1.PROTO2;
    }

    private static <T> o1<T> e(Class<T> cls, u0 u0Var) {
        return z.class.isAssignableFrom(cls) ? d(u0Var) ? z0.V(cls, u0Var, d1.b(), m0.b(), q1.M(), t.b(), t0.b()) : z0.V(cls, u0Var, d1.b(), m0.b(), q1.M(), null, t0.b()) : d(u0Var) ? z0.V(cls, u0Var, d1.a(), m0.a(), q1.H(), t.a(), t0.a()) : z0.V(cls, u0Var, d1.a(), m0.a(), q1.I(), null, t0.a());
    }

    @Override // com.google.protobuf.p1
    public <T> o1<T> a(Class<T> cls) {
        w1<?, ?> H;
        r<?> a5;
        q1.J(cls);
        u0 a6 = this.f2088a.a(cls);
        if (a6.a()) {
            if (z.class.isAssignableFrom(cls)) {
                H = q1.M();
                a5 = t.b();
            } else {
                H = q1.H();
                a5 = t.a();
            }
            return a1.m(H, a5, a6.c());
        }
        return e(cls, a6);
    }
}
