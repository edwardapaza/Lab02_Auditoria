package i2;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class g extends com.google.protobuf.z<g, b> implements x0 {
    public static final int BITS_FIELD_NUMBER = 1;
    private static final g DEFAULT_INSTANCE;
    public static final int HASH_COUNT_FIELD_NUMBER = 2;
    private static volatile g1<g> PARSER;
    private f bits_;
    private int hashCount_;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3205a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3205a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3205a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3205a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3205a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3205a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3205a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3205a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<g, b> implements x0 {
        private b() {
            super(g.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        com.google.protobuf.z.a0(g.class, gVar);
    }

    private g() {
    }

    public static g f0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3205a[fVar.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u0004", new Object[]{"bits_", "hashCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<g> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (g.class) {
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

    public f e0() {
        f fVar = this.bits_;
        return fVar == null ? f.f0() : fVar;
    }

    public int g0() {
        return this.hashCount_;
    }

    public boolean h0() {
        return this.bits_ != null;
    }
}
