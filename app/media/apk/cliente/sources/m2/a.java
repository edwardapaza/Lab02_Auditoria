package m2;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class a extends z<a, b> implements x0 {
    private static final a DEFAULT_INSTANCE;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    private static volatile g1<a> PARSER;
    private double latitude_;
    private double longitude_;

    /* renamed from: m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0093a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6084a;

        static {
            int[] iArr = new int[z.f.values().length];
            f6084a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6084a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6084a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6084a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6084a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6084a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6084a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<a, b> implements x0 {
        private b() {
            super(a.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(C0093a c0093a) {
            this();
        }

        public b E(double d5) {
            w();
            ((a) this.f2203b).k0(d5);
            return this;
        }

        public b F(double d5) {
            w();
            ((a) this.f2203b).l0(d5);
            return this;
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.a0(a.class, aVar);
    }

    private a() {
    }

    public static a g0() {
        return DEFAULT_INSTANCE;
    }

    public static b j0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(double d5) {
        this.latitude_ = d5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(double d5) {
        this.longitude_ = d5;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (C0093a.f6084a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(null);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0000\u0002\u0000", new Object[]{"latitude_", "longitude_"});
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

    public double h0() {
        return this.latitude_;
    }

    public double i0() {
        return this.longitude_;
    }
}
