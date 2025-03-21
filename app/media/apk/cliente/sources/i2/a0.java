package i2;

import com.google.protobuf.a0;
import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import i2.z;
/* loaded from: classes.dex */
public final class a0 extends com.google.protobuf.z<a0, b> implements x0 {
    private static final a0 DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 3;
    public static final int EXPECTED_COUNT_FIELD_NUMBER = 12;
    public static final int ONCE_FIELD_NUMBER = 6;
    private static volatile g1<a0> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int READ_TIME_FIELD_NUMBER = 11;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_ID_FIELD_NUMBER = 5;
    private com.google.protobuf.a0 expectedCount_;
    private boolean once_;
    private Object resumeType_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private int resumeTypeCase_ = 0;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3159a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3159a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3159a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3159a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3159a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3159a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3159a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3159a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<a0, b> implements x0 {
        private b() {
            super(a0.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(c cVar) {
            w();
            ((a0) this.f2203b).l0(cVar);
            return this;
        }

        public b F(a0.b bVar) {
            w();
            ((a0) this.f2203b).m0(bVar.build());
            return this;
        }

        public b G(d dVar) {
            w();
            ((a0) this.f2203b).n0(dVar);
            return this;
        }

        public b H(u1 u1Var) {
            w();
            ((a0) this.f2203b).o0(u1Var);
            return this;
        }

        public b I(com.google.protobuf.i iVar) {
            w();
            ((a0) this.f2203b).p0(iVar);
            return this;
        }

        public b J(int i5) {
            w();
            ((a0) this.f2203b).q0(i5);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends com.google.protobuf.z<c, a> implements x0 {
        private static final c DEFAULT_INSTANCE;
        public static final int DOCUMENTS_FIELD_NUMBER = 2;
        private static volatile g1<c> PARSER;
        private d0.i<String> documents_ = com.google.protobuf.z.G();

        /* loaded from: classes.dex */
        public static final class a extends z.a<c, a> implements x0 {
            private a() {
                super(c.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(String str) {
                w();
                ((c) this.f2203b).f0(str);
                return this;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            com.google.protobuf.z.a0(c.class, cVar);
        }

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f0(String str) {
            str.getClass();
            g0();
            this.documents_.add(str);
        }

        private void g0() {
            d0.i<String> iVar = this.documents_;
            if (iVar.j()) {
                return;
            }
            this.documents_ = com.google.protobuf.z.Q(iVar);
        }

        public static c h0() {
            return DEFAULT_INSTANCE;
        }

        public static a k0() {
            return DEFAULT_INSTANCE.A();
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3159a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002Ț", new Object[]{"documents_"});
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

        public String i0(int i5) {
            return this.documents_.get(i5);
        }

        public int j0() {
            return this.documents_.size();
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends com.google.protobuf.z<d, a> implements x0 {
        private static final d DEFAULT_INSTANCE;
        public static final int PARENT_FIELD_NUMBER = 1;
        private static volatile g1<d> PARSER = null;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
        private Object queryType_;
        private int queryTypeCase_ = 0;
        private String parent_ = "";

        /* loaded from: classes.dex */
        public static final class a extends z.a<d, a> implements x0 {
            private a() {
                super(d.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(String str) {
                w();
                ((d) this.f2203b).k0(str);
                return this;
            }

            public a F(z.b bVar) {
                w();
                ((d) this.f2203b).l0(bVar.build());
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

        public static d g0() {
            return DEFAULT_INSTANCE;
        }

        public static a j0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0(String str) {
            str.getClass();
            this.parent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(z zVar) {
            zVar.getClass();
            this.queryType_ = zVar;
            this.queryTypeCase_ = 2;
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3159a[fVar.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000", new Object[]{"queryType_", "queryTypeCase_", "parent_", z.class});
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

        public String h0() {
            return this.parent_;
        }

        public z i0() {
            return this.queryTypeCase_ == 2 ? (z) this.queryType_ : z.o0();
        }
    }

    static {
        a0 a0Var = new a0();
        DEFAULT_INSTANCE = a0Var;
        com.google.protobuf.z.a0(a0.class, a0Var);
    }

    private a0() {
    }

    public static b k0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(c cVar) {
        cVar.getClass();
        this.targetType_ = cVar;
        this.targetTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(com.google.protobuf.a0 a0Var) {
        a0Var.getClass();
        this.expectedCount_ = a0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(d dVar) {
        dVar.getClass();
        this.targetType_ = dVar;
        this.targetTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(u1 u1Var) {
        u1Var.getClass();
        this.resumeType_ = u1Var;
        this.resumeTypeCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(com.google.protobuf.i iVar) {
        iVar.getClass();
        this.resumeTypeCase_ = 4;
        this.resumeType_ = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i5) {
        this.targetId_ = i5;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3159a[fVar.ordinal()]) {
            case 1:
                return new a0();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0007\u0002\u0000\u0002\f\u0007\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004=\u0001\u0005\u0004\u0006\u0007\u000b<\u0001\f\t", new Object[]{"targetType_", "targetTypeCase_", "resumeType_", "resumeTypeCase_", d.class, c.class, "targetId_", "once_", u1.class, "expectedCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<a0> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (a0.class) {
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
