package i2;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class c0 extends com.google.protobuf.z<c0, b> implements x0 {
    private static final c0 DEFAULT_INSTANCE;
    private static volatile g1<c0> PARSER = null;
    public static final int READ_ONLY_FIELD_NUMBER = 2;
    public static final int READ_WRITE_FIELD_NUMBER = 3;
    private int modeCase_ = 0;
    private Object mode_;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3171a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3171a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3171a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3171a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3171a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3171a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3171a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3171a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<c0, b> implements x0 {
        private b() {
            super(c0.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends com.google.protobuf.z<c, a> implements x0 {
        private static final c DEFAULT_INSTANCE;
        private static volatile g1<c> PARSER = null;
        public static final int READ_TIME_FIELD_NUMBER = 2;
        private int consistencySelectorCase_ = 0;
        private Object consistencySelector_;

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

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3171a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002<\u0000", new Object[]{"consistencySelector_", "consistencySelectorCase_", u1.class});
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
        private static volatile g1<d> PARSER = null;
        public static final int RETRY_TRANSACTION_FIELD_NUMBER = 1;
        private com.google.protobuf.i retryTransaction_ = com.google.protobuf.i.f1961b;

        /* loaded from: classes.dex */
        public static final class a extends z.a<d, a> implements x0 {
            private a() {
                super(d.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }
        }

        static {
            d dVar = new d();
            DEFAULT_INSTANCE = dVar;
            com.google.protobuf.z.a0(d.class, dVar);
        }

        private d() {
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3171a[fVar.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"retryTransaction_"});
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
        c0 c0Var = new c0();
        DEFAULT_INSTANCE = c0Var;
        com.google.protobuf.z.a0(c0.class, c0Var);
    }

    private c0() {
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3171a[fVar.ordinal()]) {
            case 1:
                return new c0();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"mode_", "modeCase_", c.class, d.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<c0> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (c0.class) {
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
