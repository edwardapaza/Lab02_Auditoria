package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class h extends com.google.protobuf.z<h, b> implements x0 {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final h DEFAULT_INSTANCE;
    private static volatile g1<h> PARSER = null;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    public static final int WRITES_FIELD_NUMBER = 2;
    private String database_ = "";
    private d0.i<e0> writes_ = com.google.protobuf.z.G();
    private com.google.protobuf.i transaction_ = com.google.protobuf.i.f1961b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3207a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3207a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3207a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3207a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3207a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3207a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3207a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3207a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<h, b> implements x0 {
        private b() {
            super(h.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(e0 e0Var) {
            w();
            ((h) this.f2203b).g0(e0Var);
            return this;
        }

        public b F(String str) {
            w();
            ((h) this.f2203b).k0(str);
            return this;
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        com.google.protobuf.z.a0(h.class, hVar);
    }

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(e0 e0Var) {
        e0Var.getClass();
        h0();
        this.writes_.add(e0Var);
    }

    private void h0() {
        d0.i<e0> iVar = this.writes_;
        if (iVar.j()) {
            return;
        }
        this.writes_ = com.google.protobuf.z.Q(iVar);
    }

    public static h i0() {
        return DEFAULT_INSTANCE;
    }

    public static b j0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(String str) {
        str.getClass();
        this.database_ = str;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3207a[fVar.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\n", new Object[]{"database_", "writes_", e0.class, "transaction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<h> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (h.class) {
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
