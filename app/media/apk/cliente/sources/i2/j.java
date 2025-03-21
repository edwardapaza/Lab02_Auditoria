package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import java.util.List;
/* loaded from: classes.dex */
public final class j extends com.google.protobuf.z<j, b> implements x0 {
    public static final int BEFORE_FIELD_NUMBER = 2;
    private static final j DEFAULT_INSTANCE;
    private static volatile g1<j> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean before_;
    private d0.i<d0> values_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3210a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3210a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3210a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3210a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3210a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3210a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3210a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3210a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<j, b> implements x0 {
        private b() {
            super(j.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(Iterable<? extends d0> iterable) {
            w();
            ((j) this.f2203b).g0(iterable);
            return this;
        }

        public b F(boolean z4) {
            w();
            ((j) this.f2203b).l0(z4);
            return this;
        }
    }

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        com.google.protobuf.z.a0(j.class, jVar);
    }

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(Iterable<? extends d0> iterable) {
        h0();
        com.google.protobuf.a.o(iterable, this.values_);
    }

    private void h0() {
        d0.i<d0> iVar = this.values_;
        if (iVar.j()) {
            return;
        }
        this.values_ = com.google.protobuf.z.Q(iVar);
    }

    public static j j0() {
        return DEFAULT_INSTANCE;
    }

    public static b k0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(boolean z4) {
        this.before_ = z4;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3210a[fVar.ordinal()]) {
            case 1:
                return new j();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"values_", d0.class, "before_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<j> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (j.class) {
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

    public List<d0> e() {
        return this.values_;
    }

    public boolean i0() {
        return this.before_;
    }
}
