package i2;

import com.google.protobuf.c2;
import com.google.protobuf.g1;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes.dex */
public final class u extends com.google.protobuf.z<u, b> implements x0 {
    private static final u DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile g1<u> PARSER;
    private q0<String, d0> fields_ = q0.d();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3250a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3250a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3250a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3250a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3250a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3250a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3250a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3250a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<u, b> implements x0 {
        private b() {
            super(u.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public boolean E(String str) {
            str.getClass();
            return ((u) this.f2203b).h0().containsKey(str);
        }

        public b F(Map<String, d0> map) {
            w();
            ((u) this.f2203b).k0().putAll(map);
            return this;
        }

        public b G(String str, d0 d0Var) {
            str.getClass();
            d0Var.getClass();
            w();
            ((u) this.f2203b).k0().put(str, d0Var);
            return this;
        }

        public b H(String str) {
            str.getClass();
            w();
            ((u) this.f2203b).k0().remove(str);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final p0<String, d0> f3251a = p0.d(c2.b.f1883o, "", c2.b.f1885q, d0.s0());
    }

    static {
        u uVar = new u();
        DEFAULT_INSTANCE = uVar;
        com.google.protobuf.z.a0(u.class, uVar);
    }

    private u() {
    }

    public static u f0() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, d0> k0() {
        return m0();
    }

    private q0<String, d0> l0() {
        return this.fields_;
    }

    private q0<String, d0> m0() {
        if (!this.fields_.k()) {
            this.fields_ = this.fields_.n();
        }
        return this.fields_;
    }

    public static b n0() {
        return DEFAULT_INSTANCE.A();
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3250a[fVar.ordinal()]) {
            case 1:
                return new u();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", c.f3251a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<u> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (u.class) {
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

    public int g0() {
        return l0().size();
    }

    public Map<String, d0> h0() {
        return Collections.unmodifiableMap(l0());
    }

    public d0 i0(String str, d0 d0Var) {
        str.getClass();
        q0<String, d0> l02 = l0();
        return l02.containsKey(str) ? l02.get(str) : d0Var;
    }

    public d0 j0(String str) {
        str.getClass();
        q0<String, d0> l02 = l0();
        if (l02.containsKey(str)) {
            return l02.get(str);
        }
        throw new IllegalArgumentException();
    }
}
