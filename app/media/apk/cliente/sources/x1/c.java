package x1;

import com.google.protobuf.g1;
import com.google.protobuf.i;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import i2.a0;
/* loaded from: classes.dex */
public final class c extends z<c, b> implements x0 {
    private static final c DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile g1<c> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private u1 lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private u1 snapshotVersion_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private i resumeToken_ = i.f1961b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8340a;

        static {
            int[] iArr = new int[z.f.values().length];
            f8340a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8340a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8340a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8340a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8340a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8340a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8340a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<c, b> implements x0 {
        private b() {
            super(c.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E() {
            w();
            ((c) this.f2203b).m0();
            return this;
        }

        public b F(a0.c cVar) {
            w();
            ((c) this.f2203b).x0(cVar);
            return this;
        }

        public b G(u1 u1Var) {
            w();
            ((c) this.f2203b).y0(u1Var);
            return this;
        }

        public b H(long j5) {
            w();
            ((c) this.f2203b).z0(j5);
            return this;
        }

        public b I(a0.d dVar) {
            w();
            ((c) this.f2203b).A0(dVar);
            return this;
        }

        public b J(i iVar) {
            w();
            ((c) this.f2203b).B0(iVar);
            return this;
        }

        public b K(u1 u1Var) {
            w();
            ((c) this.f2203b).C0(u1Var);
            return this;
        }

        public b L(int i5) {
            w();
            ((c) this.f2203b).D0(i5);
            return this;
        }
    }

    /* renamed from: x1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0128c {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f8345a;

        EnumC0128c(int i5) {
            this.f8345a = i5;
        }

        public static EnumC0128c a(int i5) {
            if (i5 != 0) {
                if (i5 != 5) {
                    if (i5 != 6) {
                        return null;
                    }
                    return DOCUMENTS;
                }
                return QUERY;
            }
            return TARGETTYPE_NOT_SET;
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        z.a0(c.class, cVar);
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(a0.d dVar) {
        dVar.getClass();
        this.targetType_ = dVar;
        this.targetTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(i iVar) {
        iVar.getClass();
        this.resumeToken_ = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(u1 u1Var) {
        u1Var.getClass();
        this.snapshotVersion_ = u1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i5) {
        this.targetId_ = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        this.lastLimboFreeSnapshotVersion_ = null;
    }

    public static b v0() {
        return DEFAULT_INSTANCE.A();
    }

    public static c w0(byte[] bArr) {
        return (c) z.W(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(a0.c cVar) {
        cVar.getClass();
        this.targetType_ = cVar;
        this.targetTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(u1 u1Var) {
        u1Var.getClass();
        this.lastLimboFreeSnapshotVersion_ = u1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(long j5) {
        this.lastListenSequenceNumber_ = j5;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f8340a[fVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new b(null);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\t\u0003\n\u0004\u0002\u0005<\u0000\u0006<\u0000\u0007\t", new Object[]{"targetType_", "targetTypeCase_", "targetId_", "snapshotVersion_", "resumeToken_", "lastListenSequenceNumber_", a0.d.class, a0.c.class, "lastLimboFreeSnapshotVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<c> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (c.class) {
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

    public a0.c n0() {
        return this.targetTypeCase_ == 6 ? (a0.c) this.targetType_ : a0.c.h0();
    }

    public u1 o0() {
        u1 u1Var = this.lastLimboFreeSnapshotVersion_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public long p0() {
        return this.lastListenSequenceNumber_;
    }

    public a0.d q0() {
        return this.targetTypeCase_ == 5 ? (a0.d) this.targetType_ : a0.d.g0();
    }

    public i r0() {
        return this.resumeToken_;
    }

    public u1 s0() {
        u1 u1Var = this.snapshotVersion_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public int t0() {
        return this.targetId_;
    }

    public EnumC0128c u0() {
        return EnumC0128c.a(this.targetTypeCase_);
    }
}
