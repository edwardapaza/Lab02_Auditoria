package i2;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class e extends com.google.protobuf.z<e, b> implements x0 {
    private static final e DEFAULT_INSTANCE;
    public static final int FOUND_FIELD_NUMBER = 1;
    public static final int MISSING_FIELD_NUMBER = 2;
    private static volatile g1<e> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private u1 readTime_;
    private Object result_;
    private int resultCase_ = 0;
    private com.google.protobuf.i transaction_ = com.google.protobuf.i.f1961b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3188a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3188a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3188a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3188a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3188a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3188a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3188a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3188a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<e, b> implements x0 {
        private b() {
            super(e.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        FOUND(1),
        MISSING(2),
        RESULT_NOT_SET(0);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f3193a;

        c(int i5) {
            this.f3193a = i5;
        }

        public static c a(int i5) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        return null;
                    }
                    return MISSING;
                }
                return FOUND;
            }
            return RESULT_NOT_SET;
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        com.google.protobuf.z.a0(e.class, eVar);
    }

    private e() {
    }

    public static e e0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3188a[fVar.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003\n\u0004\t", new Object[]{"result_", "resultCase_", k.class, "transaction_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<e> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (e.class) {
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

    public k f0() {
        return this.resultCase_ == 1 ? (k) this.result_ : k.h0();
    }

    public String g0() {
        return this.resultCase_ == 2 ? (String) this.result_ : "";
    }

    public u1 h0() {
        u1 u1Var = this.readTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public c i0() {
        return c.a(this.resultCase_);
    }
}
