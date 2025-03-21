package x1;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.i;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import i2.e0;
/* loaded from: classes.dex */
public final class e extends z<e, b> implements x0 {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    private static final e DEFAULT_INSTANCE;
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile g1<e> PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private int batchId_;
    private u1 localWriteTime_;
    private d0.i<e0> writes_ = z.G();
    private d0.i<e0> baseWrites_ = z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8347a;

        static {
            int[] iArr = new int[z.f.values().length];
            f8347a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8347a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8347a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8347a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8347a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8347a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8347a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<e, b> implements x0 {
        private b() {
            super(e.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(e0 e0Var) {
            w();
            ((e) this.f2203b).i0(e0Var);
            return this;
        }

        public b F(e0 e0Var) {
            w();
            ((e) this.f2203b).j0(e0Var);
            return this;
        }

        public b G(int i5) {
            w();
            ((e) this.f2203b).v0(i5);
            return this;
        }

        public b H(u1 u1Var) {
            w();
            ((e) this.f2203b).w0(u1Var);
            return this;
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        z.a0(e.class, eVar);
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(e0 e0Var) {
        e0Var.getClass();
        k0();
        this.baseWrites_.add(e0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(e0 e0Var) {
        e0Var.getClass();
        l0();
        this.writes_.add(e0Var);
    }

    private void k0() {
        d0.i<e0> iVar = this.baseWrites_;
        if (iVar.j()) {
            return;
        }
        this.baseWrites_ = z.Q(iVar);
    }

    private void l0() {
        d0.i<e0> iVar = this.writes_;
        if (iVar.j()) {
            return;
        }
        this.writes_ = z.Q(iVar);
    }

    public static b s0() {
        return DEFAULT_INSTANCE.A();
    }

    public static e t0(i iVar) {
        return (e) z.U(DEFAULT_INSTANCE, iVar);
    }

    public static e u0(byte[] bArr) {
        return (e) z.W(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int i5) {
        this.batchId_ = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(u1 u1Var) {
        u1Var.getClass();
        this.localWriteTime_ = u1Var;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f8347a[fVar.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new b(null);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003\t\u0004\u001b", new Object[]{"batchId_", "writes_", e0.class, "localWriteTime_", "baseWrites_", e0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<e> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (e.class) {
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

    public e0 m0(int i5) {
        return this.baseWrites_.get(i5);
    }

    public int n0() {
        return this.baseWrites_.size();
    }

    public int o0() {
        return this.batchId_;
    }

    public u1 p0() {
        u1 u1Var = this.localWriteTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public e0 q0(int i5) {
        return this.writes_.get(i5);
    }

    public int r0() {
        return this.writes_.size();
    }
}
