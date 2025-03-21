package i2;

import com.google.protobuf.c2;
import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class f0 extends com.google.protobuf.z<f0, b> implements x0 {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final f0 DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 5;
    private static volatile g1<f0> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 2;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 4;
    public static final int WRITES_FIELD_NUMBER = 3;
    private q0<String, String> labels_ = q0.d();
    private String database_ = "";
    private String streamId_ = "";
    private d0.i<e0> writes_ = com.google.protobuf.z.G();
    private com.google.protobuf.i streamToken_ = com.google.protobuf.i.f1961b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3203a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3203a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3203a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3203a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3203a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3203a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3203a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3203a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<f0, b> implements x0 {
        private b() {
            super(f0.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(e0 e0Var) {
            w();
            ((f0) this.f2203b).h0(e0Var);
            return this;
        }

        public b F(String str) {
            w();
            ((f0) this.f2203b).l0(str);
            return this;
        }

        public b G(com.google.protobuf.i iVar) {
            w();
            ((f0) this.f2203b).m0(iVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final p0<String, String> f3204a;

        static {
            c2.b bVar = c2.b.f1883o;
            f3204a = p0.d(bVar, "", bVar, "");
        }
    }

    static {
        f0 f0Var = new f0();
        DEFAULT_INSTANCE = f0Var;
        com.google.protobuf.z.a0(f0.class, f0Var);
    }

    private f0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(e0 e0Var) {
        e0Var.getClass();
        i0();
        this.writes_.add(e0Var);
    }

    private void i0() {
        d0.i<e0> iVar = this.writes_;
        if (iVar.j()) {
            return;
        }
        this.writes_ = com.google.protobuf.z.Q(iVar);
    }

    public static f0 j0() {
        return DEFAULT_INSTANCE;
    }

    public static b k0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(String str) {
        str.getClass();
        this.database_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(com.google.protobuf.i iVar) {
        iVar.getClass();
        this.streamToken_ = iVar;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3203a[fVar.ordinal()]) {
            case 1:
                return new f0();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004\n\u00052", new Object[]{"database_", "streamId_", "writes_", e0.class, "streamToken_", "labels_", c.f3204a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<f0> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (f0.class) {
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
