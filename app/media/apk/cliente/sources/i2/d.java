package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class d extends com.google.protobuf.z<d, b> implements x0 {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final d DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 2;
    public static final int MASK_FIELD_NUMBER = 3;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
    private static volatile g1<d> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 7;
    public static final int TRANSACTION_FIELD_NUMBER = 4;
    private Object consistencySelector_;
    private n mask_;
    private int consistencySelectorCase_ = 0;
    private String database_ = "";
    private d0.i<String> documents_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3172a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3172a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3172a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3172a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3172a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3172a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3172a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3172a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<d, b> implements x0 {
        private b() {
            super(d.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(String str) {
            w();
            ((d) this.f2203b).g0(str);
            return this;
        }

        public b F(String str) {
            w();
            ((d) this.f2203b).k0(str);
            return this;
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        com.google.protobuf.z.a0(d.class, dVar);
    }

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(String str) {
        str.getClass();
        h0();
        this.documents_.add(str);
    }

    private void h0() {
        d0.i<String> iVar = this.documents_;
        if (iVar.j()) {
            return;
        }
        this.documents_ = com.google.protobuf.z.Q(iVar);
    }

    public static d i0() {
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
        switch (a.f3172a[fVar.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0007\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ț\u0003\t\u0004=\u0000\u0005<\u0000\u0007<\u0000", new Object[]{"consistencySelector_", "consistencySelectorCase_", "database_", "documents_", "mask_", c0.class, u1.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<d> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (d.class) {
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
