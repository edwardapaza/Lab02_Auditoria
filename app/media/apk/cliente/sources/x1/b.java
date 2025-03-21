package x1;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class b extends z<b, C0127b> implements x0 {
    private static final b DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g1<b> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 2;
    private String name_ = "";
    private u1 readTime_;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8339a;

        static {
            int[] iArr = new int[z.f.values().length];
            f8339a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8339a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8339a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8339a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8339a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8339a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8339a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: x1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0127b extends z.a<b, C0127b> implements x0 {
        private C0127b() {
            super(b.DEFAULT_INSTANCE);
        }

        /* synthetic */ C0127b(a aVar) {
            this();
        }

        public C0127b E(String str) {
            w();
            ((b) this.f2203b).k0(str);
            return this;
        }

        public C0127b F(u1 u1Var) {
            w();
            ((b) this.f2203b).l0(u1Var);
            return this;
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        z.a0(b.class, bVar);
    }

    private b() {
    }

    public static b g0() {
        return DEFAULT_INSTANCE;
    }

    public static C0127b j0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(u1 u1Var) {
        u1Var.getClass();
        this.readTime_ = u1Var;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f8339a[fVar.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return new C0127b(null);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"name_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<b> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (b.class) {
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
        return this.name_;
    }

    public u1 i0() {
        u1 u1Var = this.readTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }
}
