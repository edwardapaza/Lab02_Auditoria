package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import i2.b;
import java.util.List;
/* loaded from: classes.dex */
public final class p extends com.google.protobuf.z<p, b> implements x0 {
    private static final p DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile g1<p> PARSER;
    private String document_ = "";
    private d0.i<c> fieldTransforms_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3217a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3217a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3217a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3217a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3217a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3217a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3217a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3217a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<p, b> implements x0 {
        private b() {
            super(p.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends com.google.protobuf.z<c, a> implements x0 {
        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile g1<c> PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private Object transformType_;
        private int transformTypeCase_ = 0;
        private String fieldPath_ = "";

        /* loaded from: classes.dex */
        public static final class a extends z.a<c, a> implements x0 {
            private a() {
                super(c.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(b.C0063b c0063b) {
                w();
                ((c) this.f2203b).q0(c0063b.build());
                return this;
            }

            public a F(String str) {
                w();
                ((c) this.f2203b).r0(str);
                return this;
            }

            public a G(d0 d0Var) {
                w();
                ((c) this.f2203b).s0(d0Var);
                return this;
            }

            public a H(b.C0063b c0063b) {
                w();
                ((c) this.f2203b).t0(c0063b.build());
                return this;
            }

            public a I(b bVar) {
                w();
                ((c) this.f2203b).u0(bVar);
                return this;
            }
        }

        /* loaded from: classes.dex */
        public enum b implements d0.c {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);
            

            /* renamed from: e  reason: collision with root package name */
            private static final d0.d<b> f3221e = new a();

            /* renamed from: a  reason: collision with root package name */
            private final int f3223a;

            /* loaded from: classes.dex */
            class a implements d0.d<b> {
                a() {
                }

                @Override // com.google.protobuf.d0.d
                /* renamed from: b */
                public b a(int i5) {
                    return b.a(i5);
                }
            }

            b(int i5) {
                this.f3223a = i5;
            }

            public static b a(int i5) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        return null;
                    }
                    return REQUEST_TIME;
                }
                return SERVER_VALUE_UNSPECIFIED;
            }

            @Override // com.google.protobuf.d0.c
            public final int b() {
                if (this != UNRECOGNIZED) {
                    return this.f3223a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* renamed from: i2.p$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0064c {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);
            

            /* renamed from: a  reason: collision with root package name */
            private final int f3232a;

            EnumC0064c(int i5) {
                this.f3232a = i5;
            }

            public static EnumC0064c a(int i5) {
                if (i5 != 0) {
                    switch (i5) {
                        case 2:
                            return SET_TO_SERVER_VALUE;
                        case 3:
                            return INCREMENT;
                        case 4:
                            return MAXIMUM;
                        case 5:
                            return MINIMUM;
                        case 6:
                            return APPEND_MISSING_ELEMENTS;
                        case 7:
                            return REMOVE_ALL_FROM_ARRAY;
                        default:
                            return null;
                    }
                }
                return TRANSFORMTYPE_NOT_SET;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            com.google.protobuf.z.a0(c.class, cVar);
        }

        private c() {
        }

        public static a p0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(i2.b bVar) {
            bVar.getClass();
            this.transformType_ = bVar;
            this.transformTypeCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(d0 d0Var) {
            d0Var.getClass();
            this.transformType_ = d0Var;
            this.transformTypeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(i2.b bVar) {
            bVar.getClass();
            this.transformType_ = bVar;
            this.transformTypeCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(b bVar) {
            this.transformType_ = Integer.valueOf(bVar.b());
            this.transformTypeCase_ = 2;
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3217a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"transformType_", "transformTypeCase_", "fieldPath_", d0.class, d0.class, d0.class, i2.b.class, i2.b.class});
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

        public i2.b j0() {
            return this.transformTypeCase_ == 6 ? (i2.b) this.transformType_ : i2.b.k0();
        }

        public String k0() {
            return this.fieldPath_;
        }

        public d0 l0() {
            return this.transformTypeCase_ == 3 ? (d0) this.transformType_ : d0.s0();
        }

        public i2.b m0() {
            return this.transformTypeCase_ == 7 ? (i2.b) this.transformType_ : i2.b.k0();
        }

        public b n0() {
            if (this.transformTypeCase_ == 2) {
                b a5 = b.a(((Integer) this.transformType_).intValue());
                return a5 == null ? b.UNRECOGNIZED : a5;
            }
            return b.SERVER_VALUE_UNSPECIFIED;
        }

        public EnumC0064c o0() {
            return EnumC0064c.a(this.transformTypeCase_);
        }
    }

    static {
        p pVar = new p();
        DEFAULT_INSTANCE = pVar;
        com.google.protobuf.z.a0(p.class, pVar);
    }

    private p() {
    }

    public static p e0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3217a[fVar.ordinal()]) {
            case 1:
                return new p();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"document_", "fieldTransforms_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<p> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (p.class) {
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

    public List<c> f0() {
        return this.fieldTransforms_;
    }
}
