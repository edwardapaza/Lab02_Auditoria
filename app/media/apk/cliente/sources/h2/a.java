package h2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class a extends z<a, b> implements x0 {
    private static final a DEFAULT_INSTANCE;
    public static final int LIMIT_TYPE_FIELD_NUMBER = 3;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile g1<a> PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    private int limitType_;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private String parent_ = "";

    /* renamed from: h2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0059a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3108a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3108a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3108a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3108a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3108a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3108a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3108a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3108a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<a, b> implements x0 {
        private b() {
            super(a.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(C0059a c0059a) {
            this();
        }

        public b E(c cVar) {
            w();
            ((a) this.f2203b).m0(cVar);
            return this;
        }

        public b F(String str) {
            w();
            ((a) this.f2203b).n0(str);
            return this;
        }

        public b G(i2.z zVar) {
            w();
            ((a) this.f2203b).o0(zVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c implements d0.c {
        FIRST(0),
        LAST(1),
        UNRECOGNIZED(-1);
        

        /* renamed from: e  reason: collision with root package name */
        private static final d0.d<c> f3112e = new C0060a();

        /* renamed from: a  reason: collision with root package name */
        private final int f3114a;

        /* renamed from: h2.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0060a implements d0.d<c> {
            C0060a() {
            }

            @Override // com.google.protobuf.d0.d
            /* renamed from: b */
            public c a(int i5) {
                return c.a(i5);
            }
        }

        c(int i5) {
            this.f3114a = i5;
        }

        public static c a(int i5) {
            if (i5 != 0) {
                if (i5 != 1) {
                    return null;
                }
                return LAST;
            }
            return FIRST;
        }

        @Override // com.google.protobuf.d0.c
        public final int b() {
            if (this != UNRECOGNIZED) {
                return this.f3114a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.a0(a.class, aVar);
    }

    private a() {
    }

    public static b k0() {
        return DEFAULT_INSTANCE.A();
    }

    public static a l0(byte[] bArr) {
        return (a) z.W(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(c cVar) {
        this.limitType_ = cVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(String str) {
        str.getClass();
        this.parent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(i2.z zVar) {
        zVar.getClass();
        this.queryType_ = zVar;
        this.queryTypeCase_ = 2;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (C0059a.f3108a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(null);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003\f", new Object[]{"queryType_", "queryTypeCase_", "parent_", i2.z.class, "limitType_"});
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

    public c h0() {
        c a5 = c.a(this.limitType_);
        return a5 == null ? c.UNRECOGNIZED : a5;
    }

    public String i0() {
        return this.parent_;
    }

    public i2.z j0() {
        return this.queryTypeCase_ == 2 ? (i2.z) this.queryType_ : i2.z.o0();
    }
}
