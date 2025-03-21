package r4;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: E
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* loaded from: classes.dex */
public final class z {

    /* loaded from: classes.dex */
    static final class a extends e4.l implements d4.l<Throwable, s3.t> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d4.l<E, s3.t> f7248a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ E f7249b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ v3.g f7250c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(d4.l<? super E, s3.t> lVar, E e5, v3.g gVar) {
            super(1);
            this.f7248a = lVar;
            this.f7249b = e5;
            this.f7250c = gVar;
        }

        public final void a(Throwable th) {
            z.b(this.f7248a, this.f7249b, this.f7250c);
        }

        @Override // d4.l
        public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
            a(th);
            return s3.t.f7573a;
        }
    }

    public static final <E> d4.l<Throwable, s3.t> a(d4.l<? super E, s3.t> lVar, E e5, v3.g gVar) {
        return new a(lVar, e5, gVar);
    }

    public static final <E> void b(d4.l<? super E, s3.t> lVar, E e5, v3.g gVar) {
        q0 c5 = c(lVar, e5, null);
        if (c5 != null) {
            m4.i0.a(gVar, c5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> q0 c(d4.l<? super E, s3.t> lVar, E e5, q0 q0Var) {
        try {
            lVar.invoke(e5);
        } catch (Throwable th) {
            if (q0Var == null || q0Var.getCause() == th) {
                return new q0("Exception in undelivered element handler for " + e5, th);
            }
            s3.b.a(q0Var, th);
        }
        return q0Var;
    }

    public static /* synthetic */ q0 d(d4.l lVar, Object obj, q0 q0Var, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            q0Var = null;
        }
        return c(lVar, obj, q0Var);
    }
}
