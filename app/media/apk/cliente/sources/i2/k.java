package i2;

import com.google.protobuf.c2;
import com.google.protobuf.g1;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes.dex */
public final class k extends com.google.protobuf.z<k, b> implements x0 {
    public static final int CREATE_TIME_FIELD_NUMBER = 3;
    private static final k DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g1<k> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 4;
    private u1 createTime_;
    private q0<String, d0> fields_ = q0.d();
    private String name_ = "";
    private u1 updateTime_;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3211a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3211a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3211a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3211a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3211a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3211a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3211a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3211a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<k, b> implements x0 {
        private b() {
            super(k.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(Map<String, d0> map) {
            w();
            ((k) this.f2203b).j0().putAll(map);
            return this;
        }

        public b F(String str) {
            w();
            ((k) this.f2203b).p0(str);
            return this;
        }

        public b G(u1 u1Var) {
            w();
            ((k) this.f2203b).q0(u1Var);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final p0<String, d0> f3212a = p0.d(c2.b.f1883o, "", c2.b.f1885q, d0.s0());
    }

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        com.google.protobuf.z.a0(k.class, kVar);
    }

    private k() {
    }

    public static k h0() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, d0> j0() {
        return n0();
    }

    private q0<String, d0> m0() {
        return this.fields_;
    }

    private q0<String, d0> n0() {
        if (!this.fields_.k()) {
            this.fields_ = this.fields_.n();
        }
        return this.fields_;
    }

    public static b o0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(u1 u1Var) {
        u1Var.getClass();
        this.updateTime_ = u1Var;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3211a[fVar.ordinal()]) {
            case 1:
                return new k();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u00022\u0003\t\u0004\t", new Object[]{"name_", "fields_", c.f3212a, "createTime_", "updateTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<k> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (k.class) {
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

    public Map<String, d0> i0() {
        return Collections.unmodifiableMap(m0());
    }

    public String k0() {
        return this.name_;
    }

    public u1 l0() {
        u1 u1Var = this.updateTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }
}
