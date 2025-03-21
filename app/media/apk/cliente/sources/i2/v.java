package i2;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class v extends com.google.protobuf.z<v, b> implements x0 {
    private static final v DEFAULT_INSTANCE;
    public static final int EXISTS_FIELD_NUMBER = 1;
    private static volatile g1<v> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 2;
    private int conditionTypeCase_ = 0;
    private Object conditionType_;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3252a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3252a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3252a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3252a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3252a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3252a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3252a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3252a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<v, b> implements x0 {
        private b() {
            super(v.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(boolean z4) {
            w();
            ((v) this.f2203b).l0(z4);
            return this;
        }

        public b F(u1 u1Var) {
            w();
            ((v) this.f2203b).m0(u1Var);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        EXISTS(1),
        UPDATE_TIME(2),
        CONDITIONTYPE_NOT_SET(0);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f3257a;

        c(int i5) {
            this.f3257a = i5;
        }

        public static c a(int i5) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        return null;
                    }
                    return UPDATE_TIME;
                }
                return EXISTS;
            }
            return CONDITIONTYPE_NOT_SET;
        }
    }

    static {
        v vVar = new v();
        DEFAULT_INSTANCE = vVar;
        com.google.protobuf.z.a0(v.class, vVar);
    }

    private v() {
    }

    public static v h0() {
        return DEFAULT_INSTANCE;
    }

    public static b k0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(boolean z4) {
        this.conditionTypeCase_ = 1;
        this.conditionType_ = Boolean.valueOf(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(u1 u1Var) {
        u1Var.getClass();
        this.conditionType_ = u1Var;
        this.conditionTypeCase_ = 2;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3252a[fVar.ordinal()]) {
            case 1:
                return new v();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001:\u0000\u0002<\u0000", new Object[]{"conditionType_", "conditionTypeCase_", u1.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<v> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (v.class) {
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

    public c g0() {
        return c.a(this.conditionTypeCase_);
    }

    public boolean i0() {
        if (this.conditionTypeCase_ == 1) {
            return ((Boolean) this.conditionType_).booleanValue();
        }
        return false;
    }

    public u1 j0() {
        return this.conditionTypeCase_ == 2 ? (u1) this.conditionType_ : u1.g0();
    }
}
