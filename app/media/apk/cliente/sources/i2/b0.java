package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import java.util.List;
/* loaded from: classes.dex */
public final class b0 extends com.google.protobuf.z<b0, b> implements x0 {
    public static final int CAUSE_FIELD_NUMBER = 3;
    private static final b0 DEFAULT_INSTANCE;
    private static volatile g1<b0> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private l2.a cause_;
    private u1 readTime_;
    private int targetChangeType_;
    private int targetIdsMemoizedSerializedSize = -1;
    private d0.g targetIds_ = com.google.protobuf.z.F();
    private com.google.protobuf.i resumeToken_ = com.google.protobuf.i.f1961b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3161a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3161a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3161a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3161a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3161a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3161a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3161a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3161a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<b0, b> implements x0 {
        private b() {
            super(b0.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public enum c implements d0.c {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);
        

        /* renamed from: l  reason: collision with root package name */
        private static final d0.d<c> f3168l = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f3170a;

        /* loaded from: classes.dex */
        class a implements d0.d<c> {
            a() {
            }

            @Override // com.google.protobuf.d0.d
            /* renamed from: b */
            public c a(int i5) {
                return c.a(i5);
            }
        }

        c(int i5) {
            this.f3170a = i5;
        }

        public static c a(int i5) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                return null;
                            }
                            return RESET;
                        }
                        return CURRENT;
                    }
                    return REMOVE;
                }
                return ADD;
            }
            return NO_CHANGE;
        }

        @Override // com.google.protobuf.d0.c
        public final int b() {
            if (this != UNRECOGNIZED) {
                return this.f3170a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        b0 b0Var = new b0();
        DEFAULT_INSTANCE = b0Var;
        com.google.protobuf.z.a0(b0.class, b0Var);
    }

    private b0() {
    }

    public static b0 f0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3161a[fVar.ordinal()]) {
            case 1:
                return new b0();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0006\u0005\u0000\u0001\u0000\u0001\f\u0002'\u0003\t\u0004\n\u0006\t", new Object[]{"targetChangeType_", "targetIds_", "cause_", "resumeToken_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<b0> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (b0.class) {
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

    public l2.a e0() {
        l2.a aVar = this.cause_;
        return aVar == null ? l2.a.f0() : aVar;
    }

    public u1 g0() {
        u1 u1Var = this.readTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public com.google.protobuf.i h0() {
        return this.resumeToken_;
    }

    public c i0() {
        c a5 = c.a(this.targetChangeType_);
        return a5 == null ? c.UNRECOGNIZED : a5;
    }

    public int j0() {
        return this.targetIds_.size();
    }

    public List<Integer> k0() {
        return this.targetIds_;
    }
}
