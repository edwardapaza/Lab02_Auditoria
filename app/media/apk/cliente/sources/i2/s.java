package i2;

import com.google.protobuf.c2;
import com.google.protobuf.g1;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import java.util.Map;
/* loaded from: classes.dex */
public final class s extends com.google.protobuf.z<s, b> implements x0 {
    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final s DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile g1<s> PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private Object targetChange_;
    private int targetChangeCase_ = 0;
    private q0<String, String> labels_ = q0.d();
    private String database_ = "";

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3239a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3239a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3239a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3239a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3239a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3239a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3239a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3239a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<s, b> implements x0 {
        private b() {
            super(s.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(Map<String, String> map) {
            w();
            ((s) this.f2203b).j0().putAll(map);
            return this;
        }

        public b F(a0 a0Var) {
            w();
            ((s) this.f2203b).m0(a0Var);
            return this;
        }

        public b G(String str) {
            w();
            ((s) this.f2203b).n0(str);
            return this;
        }

        public b H(int i5) {
            w();
            ((s) this.f2203b).o0(i5);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final p0<String, String> f3240a;

        static {
            c2.b bVar = c2.b.f1883o;
            f3240a = p0.d(bVar, "", bVar, "");
        }
    }

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        com.google.protobuf.z.a0(s.class, sVar);
    }

    private s() {
    }

    public static s i0() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> j0() {
        return k0();
    }

    private q0<String, String> k0() {
        if (!this.labels_.k()) {
            this.labels_ = this.labels_.n();
        }
        return this.labels_;
    }

    public static b l0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(a0 a0Var) {
        a0Var.getClass();
        this.targetChange_ = a0Var;
        this.targetChangeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(String str) {
        str.getClass();
        this.database_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int i5) {
        this.targetChangeCase_ = 3;
        this.targetChange_ = Integer.valueOf(i5);
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3239a[fVar.ordinal()]) {
            case 1:
                return new s();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002<\u0000\u00037\u0000\u00042", new Object[]{"targetChange_", "targetChangeCase_", "database_", a0.class, "labels_", c.f3240a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<s> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (s.class) {
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
