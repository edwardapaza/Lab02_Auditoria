package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class g0 extends com.google.protobuf.z<g0, b> implements x0 {
    public static final int COMMIT_TIME_FIELD_NUMBER = 4;
    private static final g0 DEFAULT_INSTANCE;
    private static volatile g1<g0> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 1;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 2;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 3;
    private u1 commitTime_;
    private String streamId_ = "";
    private com.google.protobuf.i streamToken_ = com.google.protobuf.i.f1961b;
    private d0.i<h0> writeResults_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3206a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3206a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3206a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3206a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3206a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3206a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3206a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3206a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<g0, b> implements x0 {
        private b() {
            super(g0.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        g0 g0Var = new g0();
        DEFAULT_INSTANCE = g0Var;
        com.google.protobuf.z.a0(g0.class, g0Var);
    }

    private g0() {
    }

    public static g0 f0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3206a[fVar.ordinal()]) {
            case 1:
                return new g0();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\n\u0003\u001b\u0004\t", new Object[]{"streamId_", "streamToken_", "writeResults_", h0.class, "commitTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<g0> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (g0.class) {
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

    public u1 e0() {
        u1 u1Var = this.commitTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public com.google.protobuf.i g0() {
        return this.streamToken_;
    }

    public h0 h0(int i5) {
        return this.writeResults_.get(i5);
    }

    public int i0() {
        return this.writeResults_.size();
    }
}
