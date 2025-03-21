package x1;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import i2.k;
/* loaded from: classes.dex */
public final class a extends z<a, b> implements x0 {
    private static final a DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 2;
    public static final int HAS_COMMITTED_MUTATIONS_FIELD_NUMBER = 4;
    public static final int NO_DOCUMENT_FIELD_NUMBER = 1;
    private static volatile g1<a> PARSER = null;
    public static final int UNKNOWN_DOCUMENT_FIELD_NUMBER = 3;
    private int documentTypeCase_ = 0;
    private Object documentType_;
    private boolean hasCommittedMutations_;

    /* renamed from: x1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0126a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8332a;

        static {
            int[] iArr = new int[z.f.values().length];
            f8332a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8332a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8332a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8332a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8332a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8332a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8332a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<a, b> implements x0 {
        private b() {
            super(a.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(C0126a c0126a) {
            this();
        }

        public b E(k kVar) {
            w();
            ((a) this.f2203b).p0(kVar);
            return this;
        }

        public b F(boolean z4) {
            w();
            ((a) this.f2203b).q0(z4);
            return this;
        }

        public b G(x1.b bVar) {
            w();
            ((a) this.f2203b).r0(bVar);
            return this;
        }

        public b H(d dVar) {
            w();
            ((a) this.f2203b).s0(dVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        NO_DOCUMENT(1),
        DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        DOCUMENTTYPE_NOT_SET(0);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f8338a;

        c(int i5) {
            this.f8338a = i5;
        }

        public static c a(int i5) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            return null;
                        }
                        return UNKNOWN_DOCUMENT;
                    }
                    return DOCUMENT;
                }
                return NO_DOCUMENT;
            }
            return DOCUMENTTYPE_NOT_SET;
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.a0(a.class, aVar);
    }

    private a() {
    }

    public static b n0() {
        return DEFAULT_INSTANCE.A();
    }

    public static a o0(byte[] bArr) {
        return (a) z.W(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(k kVar) {
        kVar.getClass();
        this.documentType_ = kVar;
        this.documentTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(boolean z4) {
        this.hasCommittedMutations_ = z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(x1.b bVar) {
        bVar.getClass();
        this.documentType_ = bVar;
        this.documentTypeCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(d dVar) {
        dVar.getClass();
        this.documentType_ = dVar;
        this.documentTypeCase_ = 3;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (C0126a.f8332a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(null);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004\u0007", new Object[]{"documentType_", "documentTypeCase_", x1.b.class, k.class, d.class, "hasCommittedMutations_"});
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

    public k i0() {
        return this.documentTypeCase_ == 2 ? (k) this.documentType_ : k.h0();
    }

    public c j0() {
        return c.a(this.documentTypeCase_);
    }

    public boolean k0() {
        return this.hasCommittedMutations_;
    }

    public x1.b l0() {
        return this.documentTypeCase_ == 1 ? (x1.b) this.documentType_ : x1.b.g0();
    }

    public d m0() {
        return this.documentTypeCase_ == 3 ? (d) this.documentType_ : d.g0();
    }
}
