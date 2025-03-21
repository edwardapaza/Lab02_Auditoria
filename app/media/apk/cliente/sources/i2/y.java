package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import i2.z;
/* loaded from: classes.dex */
public final class y extends com.google.protobuf.z<y, c> implements x0 {
    public static final int AGGREGATIONS_FIELD_NUMBER = 3;
    private static final y DEFAULT_INSTANCE;
    private static volatile g1<y> PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 1;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private d0.i<b> aggregations_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3260a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3260a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3260a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3260a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3260a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3260a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3260a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3260a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends com.google.protobuf.z<b, C0066b> implements x0 {
        public static final int ALIAS_FIELD_NUMBER = 7;
        public static final int AVG_FIELD_NUMBER = 3;
        public static final int COUNT_FIELD_NUMBER = 1;
        private static final b DEFAULT_INSTANCE;
        private static volatile g1<b> PARSER = null;
        public static final int SUM_FIELD_NUMBER = 2;
        private Object operator_;
        private int operatorCase_ = 0;
        private String alias_ = "";

        /* loaded from: classes.dex */
        public static final class a extends com.google.protobuf.z<a, C0065a> implements x0 {
            private static final a DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile g1<a> PARSER;
            private z.g field_;

            /* renamed from: i2.y$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0065a extends z.a<a, C0065a> implements x0 {
                private C0065a() {
                    super(a.DEFAULT_INSTANCE);
                }

                /* synthetic */ C0065a(a aVar) {
                    this();
                }

                public C0065a E(z.g gVar) {
                    w();
                    ((a) this.f2203b).g0(gVar);
                    return this;
                }
            }

            static {
                a aVar = new a();
                DEFAULT_INSTANCE = aVar;
                com.google.protobuf.z.a0(a.class, aVar);
            }

            private a() {
            }

            public static C0065a f0() {
                return DEFAULT_INSTANCE.A();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void g0(z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
            }

            @Override // com.google.protobuf.z
            protected final Object E(z.f fVar, Object obj, Object obj2) {
                switch (a.f3260a[fVar.ordinal()]) {
                    case 1:
                        return new a();
                    case 2:
                        return new C0065a(null);
                    case 3:
                        return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        g1<a> g1Var = PARSER;
                        if (g1Var == null) {
                            synchronized (a.class) {
                                g1Var = PARSER;
                                if (g1Var == null) {
                                    g1Var = new z.b<>(DEFAULT_INSTANCE);
                                    PARSER = g1Var;
                                }
                            }
                        }
                        return g1Var;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* renamed from: i2.y$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0066b extends z.a<b, C0066b> implements x0 {
            private C0066b() {
                super(b.DEFAULT_INSTANCE);
            }

            /* synthetic */ C0066b(a aVar) {
                this();
            }

            public C0066b E(String str) {
                w();
                ((b) this.f2203b).j0(str);
                return this;
            }

            public C0066b F(a aVar) {
                w();
                ((b) this.f2203b).k0(aVar);
                return this;
            }

            public C0066b G(c cVar) {
                w();
                ((b) this.f2203b).l0(cVar);
                return this;
            }

            public C0066b H(d dVar) {
                w();
                ((b) this.f2203b).m0(dVar);
                return this;
            }
        }

        /* loaded from: classes.dex */
        public static final class c extends com.google.protobuf.z<c, a> implements x0 {
            private static final c DEFAULT_INSTANCE;
            private static volatile g1<c> PARSER = null;
            public static final int UP_TO_FIELD_NUMBER = 1;
            private com.google.protobuf.b0 upTo_;

            /* loaded from: classes.dex */
            public static final class a extends z.a<c, a> implements x0 {
                private a() {
                    super(c.DEFAULT_INSTANCE);
                }

                /* synthetic */ a(a aVar) {
                    this();
                }
            }

            static {
                c cVar = new c();
                DEFAULT_INSTANCE = cVar;
                com.google.protobuf.z.a0(c.class, cVar);
            }

            private c() {
            }

            public static c e0() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.z
            protected final Object E(z.f fVar, Object obj, Object obj2) {
                switch (a.f3260a[fVar.ordinal()]) {
                    case 1:
                        return new c();
                    case 2:
                        return new a(null);
                    case 3:
                        return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"upTo_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        g1<c> g1Var = PARSER;
                        if (g1Var == null) {
                            synchronized (c.class) {
                                g1Var = PARSER;
                                if (g1Var == null) {
                                    g1Var = new z.b<>(DEFAULT_INSTANCE);
                                    PARSER = g1Var;
                                }
                            }
                        }
                        return g1Var;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class d extends com.google.protobuf.z<d, a> implements x0 {
            private static final d DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile g1<d> PARSER;
            private z.g field_;

            /* loaded from: classes.dex */
            public static final class a extends z.a<d, a> implements x0 {
                private a() {
                    super(d.DEFAULT_INSTANCE);
                }

                /* synthetic */ a(a aVar) {
                    this();
                }

                public a E(z.g gVar) {
                    w();
                    ((d) this.f2203b).g0(gVar);
                    return this;
                }
            }

            static {
                d dVar = new d();
                DEFAULT_INSTANCE = dVar;
                com.google.protobuf.z.a0(d.class, dVar);
            }

            private d() {
            }

            public static a f0() {
                return DEFAULT_INSTANCE.A();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void g0(z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
            }

            @Override // com.google.protobuf.z
            protected final Object E(z.f fVar, Object obj, Object obj2) {
                switch (a.f3260a[fVar.ordinal()]) {
                    case 1:
                        return new d();
                    case 2:
                        return new a(null);
                    case 3:
                        return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        g1<d> g1Var = PARSER;
                        if (g1Var == null) {
                            synchronized (d.class) {
                                g1Var = PARSER;
                                if (g1Var == null) {
                                    g1Var = new z.b<>(DEFAULT_INSTANCE);
                                    PARSER = g1Var;
                                }
                            }
                        }
                        return g1Var;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        static {
            b bVar = new b();
            DEFAULT_INSTANCE = bVar;
            com.google.protobuf.z.a0(b.class, bVar);
        }

        private b() {
        }

        public static C0066b i0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j0(String str) {
            str.getClass();
            this.alias_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0(a aVar) {
            aVar.getClass();
            this.operator_ = aVar;
            this.operatorCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(c cVar) {
            cVar.getClass();
            this.operator_ = cVar;
            this.operatorCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(d dVar) {
            dVar.getClass();
            this.operator_ = dVar;
            this.operatorCase_ = 2;
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3260a[fVar.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return new C0066b(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0007\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0007Ȉ", new Object[]{"operator_", "operatorCase_", c.class, d.class, a.class, "alias_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<b> g1Var = PARSER;
                    if (g1Var == null) {
                        synchronized (b.class) {
                            g1Var = PARSER;
                            if (g1Var == null) {
                                g1Var = new z.b<>(DEFAULT_INSTANCE);
                                PARSER = g1Var;
                            }
                        }
                    }
                    return g1Var;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends z.a<y, c> implements x0 {
        private c() {
            super(y.DEFAULT_INSTANCE);
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        public c E(Iterable<? extends b> iterable) {
            w();
            ((y) this.f2203b).g0(iterable);
            return this;
        }

        public c F(z zVar) {
            w();
            ((y) this.f2203b).j0(zVar);
            return this;
        }
    }

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        com.google.protobuf.z.a0(y.class, yVar);
    }

    private y() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(Iterable<? extends b> iterable) {
        h0();
        com.google.protobuf.a.o(iterable, this.aggregations_);
    }

    private void h0() {
        d0.i<b> iVar = this.aggregations_;
        if (iVar.j()) {
            return;
        }
        this.aggregations_ = com.google.protobuf.z.Q(iVar);
    }

    public static c i0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(z zVar) {
        zVar.getClass();
        this.queryType_ = zVar;
        this.queryTypeCase_ = 1;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3260a[fVar.ordinal()]) {
            case 1:
                return new y();
            case 2:
                return new c(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001<\u0000\u0003\u001b", new Object[]{"queryType_", "queryTypeCase_", z.class, "aggregations_", b.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<y> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (y.class) {
                        g1Var = PARSER;
                        if (g1Var == null) {
                            g1Var = new z.b<>(DEFAULT_INSTANCE);
                            PARSER = g1Var;
                        }
                    }
                }
                return g1Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
