package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.z;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class b extends com.google.protobuf.z<b, C0063b> implements c {
    private static final b DEFAULT_INSTANCE;
    private static volatile g1<b> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private d0.i<d0> values_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3160a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3160a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3160a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3160a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3160a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3160a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3160a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3160a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: i2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0063b extends z.a<b, C0063b> implements c {
        private C0063b() {
            super(b.DEFAULT_INSTANCE);
        }

        /* synthetic */ C0063b(a aVar) {
            this();
        }

        public C0063b E(Iterable<? extends d0> iterable) {
            w();
            ((b) this.f2203b).h0(iterable);
            return this;
        }

        public C0063b F(d0 d0Var) {
            w();
            ((b) this.f2203b).i0(d0Var);
            return this;
        }

        public d0 G(int i5) {
            return ((b) this.f2203b).l0(i5);
        }

        public int H() {
            return ((b) this.f2203b).m0();
        }

        public C0063b I(int i5) {
            w();
            ((b) this.f2203b).o0(i5);
            return this;
        }

        @Override // i2.c
        public List<d0> e() {
            return Collections.unmodifiableList(((b) this.f2203b).e());
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        com.google.protobuf.z.a0(b.class, bVar);
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(Iterable<? extends d0> iterable) {
        j0();
        com.google.protobuf.a.o(iterable, this.values_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(d0 d0Var) {
        d0Var.getClass();
        j0();
        this.values_.add(d0Var);
    }

    private void j0() {
        d0.i<d0> iVar = this.values_;
        if (iVar.j()) {
            return;
        }
        this.values_ = com.google.protobuf.z.Q(iVar);
    }

    public static b k0() {
        return DEFAULT_INSTANCE;
    }

    public static C0063b n0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int i5) {
        j0();
        this.values_.remove(i5);
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3160a[fVar.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return new C0063b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", d0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<b> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (b.class) {
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

    @Override // i2.c
    public List<d0> e() {
        return this.values_;
    }

    public d0 l0(int i5) {
        return this.values_.get(i5);
    }

    public int m0() {
        return this.values_.size();
    }
}
