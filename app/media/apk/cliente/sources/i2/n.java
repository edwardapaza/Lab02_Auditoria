package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class n extends com.google.protobuf.z<n, b> implements x0 {
    private static final n DEFAULT_INSTANCE;
    public static final int FIELD_PATHS_FIELD_NUMBER = 1;
    private static volatile g1<n> PARSER;
    private d0.i<String> fieldPaths_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3215a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3215a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3215a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3215a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3215a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3215a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3215a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3215a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<n, b> implements x0 {
        private b() {
            super(n.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(String str) {
            w();
            ((n) this.f2203b).f0(str);
            return this;
        }
    }

    static {
        n nVar = new n();
        DEFAULT_INSTANCE = nVar;
        com.google.protobuf.z.a0(n.class, nVar);
    }

    private n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(String str) {
        str.getClass();
        g0();
        this.fieldPaths_.add(str);
    }

    private void g0() {
        d0.i<String> iVar = this.fieldPaths_;
        if (iVar.j()) {
            return;
        }
        this.fieldPaths_ = com.google.protobuf.z.Q(iVar);
    }

    public static n h0() {
        return DEFAULT_INSTANCE;
    }

    public static b k0() {
        return DEFAULT_INSTANCE.A();
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3215a[fVar.ordinal()]) {
            case 1:
                return new n();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"fieldPaths_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<n> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (n.class) {
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

    public String i0(int i5) {
        return this.fieldPaths_.get(i5);
    }

    public int j0() {
        return this.fieldPaths_.size();
    }
}
