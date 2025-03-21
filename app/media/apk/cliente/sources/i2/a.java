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
public final class a extends com.google.protobuf.z<a, c> implements x0 {
    public static final int AGGREGATE_FIELDS_FIELD_NUMBER = 2;
    private static final a DEFAULT_INSTANCE;
    private static volatile g1<a> PARSER;
    private q0<String, d0> aggregateFields_ = q0.d();

    /* renamed from: i2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0062a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3157a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3157a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3157a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3157a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3157a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3157a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3157a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3157a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final p0<String, d0> f3158a = p0.d(c2.b.f1883o, "", c2.b.f1885q, d0.s0());
    }

    /* loaded from: classes.dex */
    public static final class c extends z.a<a, c> implements x0 {
        private c() {
            super(a.DEFAULT_INSTANCE);
        }

        /* synthetic */ c(C0062a c0062a) {
            this();
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        com.google.protobuf.z.a0(a.class, aVar);
    }

    private a() {
    }

    public static a f0() {
        return DEFAULT_INSTANCE;
    }

    private q0<String, d0> g0() {
        return this.aggregateFields_;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (C0062a.f3157a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new c(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0001\u0000\u0000\u00022", new Object[]{"aggregateFields_", b.f3158a});
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

    public Map<String, d0> e0() {
        return Collections.unmodifiableMap(g0());
    }
}
