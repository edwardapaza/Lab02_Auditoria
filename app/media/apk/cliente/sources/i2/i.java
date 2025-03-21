package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class i extends com.google.protobuf.z<i, b> implements x0 {
    public static final int COMMIT_TIME_FIELD_NUMBER = 2;
    private static final i DEFAULT_INSTANCE;
    private static volatile g1<i> PARSER = null;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 1;
    private u1 commitTime_;
    private d0.i<h0> writeResults_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3209a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3209a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3209a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3209a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3209a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3209a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3209a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3209a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<i, b> implements x0 {
        private b() {
            super(i.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        com.google.protobuf.z.a0(i.class, iVar);
    }

    private i() {
    }

    public static i f0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3209a[fVar.ordinal()]) {
            case 1:
                return new i();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\t", new Object[]{"writeResults_", h0.class, "commitTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<i> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (i.class) {
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

    public h0 g0(int i5) {
        return this.writeResults_.get(i5);
    }

    public int h0() {
        return this.writeResults_.size();
    }
}
