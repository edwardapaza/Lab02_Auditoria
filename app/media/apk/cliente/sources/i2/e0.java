package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import i2.p;
import java.util.List;
/* loaded from: classes.dex */
public final class e0 extends com.google.protobuf.z<e0, b> implements x0 {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final e0 DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile g1<e0> PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    public static final int UPDATE_TRANSFORMS_FIELD_NUMBER = 7;
    public static final int VERIFY_FIELD_NUMBER = 5;
    private v currentDocument_;
    private Object operation_;
    private n updateMask_;
    private int operationCase_ = 0;
    private d0.i<p.c> updateTransforms_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3194a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3194a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3194a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3194a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3194a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3194a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3194a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3194a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<e0, b> implements x0 {
        private b() {
            super(e0.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(p.c cVar) {
            w();
            ((e0) this.f2203b).k0(cVar);
            return this;
        }

        public b F(v vVar) {
            w();
            ((e0) this.f2203b).B0(vVar);
            return this;
        }

        public b G(String str) {
            w();
            ((e0) this.f2203b).C0(str);
            return this;
        }

        public b H(k kVar) {
            w();
            ((e0) this.f2203b).D0(kVar);
            return this;
        }

        public b I(n nVar) {
            w();
            ((e0) this.f2203b).E0(nVar);
            return this;
        }

        public b J(String str) {
            w();
            ((e0) this.f2203b).F0(str);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        UPDATE(1),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f3201a;

        c(int i5) {
            this.f3201a = i5;
        }

        public static c a(int i5) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 5) {
                            if (i5 != 6) {
                                return null;
                            }
                            return TRANSFORM;
                        }
                        return VERIFY;
                    }
                    return DELETE;
                }
                return UPDATE;
            }
            return OPERATION_NOT_SET;
        }
    }

    static {
        e0 e0Var = new e0();
        DEFAULT_INSTANCE = e0Var;
        com.google.protobuf.z.a0(e0.class, e0Var);
    }

    private e0() {
    }

    public static e0 A0(byte[] bArr) {
        return (e0) com.google.protobuf.z.W(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(v vVar) {
        vVar.getClass();
        this.currentDocument_ = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(String str) {
        str.getClass();
        this.operationCase_ = 2;
        this.operation_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(k kVar) {
        kVar.getClass();
        this.operation_ = kVar;
        this.operationCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(n nVar) {
        nVar.getClass();
        this.updateMask_ = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(String str) {
        str.getClass();
        this.operationCase_ = 5;
        this.operation_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(p.c cVar) {
        cVar.getClass();
        l0();
        this.updateTransforms_.add(cVar);
    }

    private void l0() {
        d0.i<p.c> iVar = this.updateTransforms_;
        if (iVar.j()) {
            return;
        }
        this.updateTransforms_ = com.google.protobuf.z.Q(iVar);
    }

    public static b y0() {
        return DEFAULT_INSTANCE.A();
    }

    public static b z0(e0 e0Var) {
        return DEFAULT_INSTANCE.B(e0Var);
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3194a[fVar.ordinal()]) {
            case 1:
                return new e0();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003\t\u0004\t\u0005Ȼ\u0000\u0006<\u0000\u0007\u001b", new Object[]{"operation_", "operationCase_", k.class, "updateMask_", "currentDocument_", p.class, "updateTransforms_", p.c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<e0> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (e0.class) {
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

    public v m0() {
        v vVar = this.currentDocument_;
        return vVar == null ? v.h0() : vVar;
    }

    public String n0() {
        return this.operationCase_ == 2 ? (String) this.operation_ : "";
    }

    public c o0() {
        return c.a(this.operationCase_);
    }

    public p p0() {
        return this.operationCase_ == 6 ? (p) this.operation_ : p.e0();
    }

    public k q0() {
        return this.operationCase_ == 1 ? (k) this.operation_ : k.h0();
    }

    public n r0() {
        n nVar = this.updateMask_;
        return nVar == null ? n.h0() : nVar;
    }

    public List<p.c> s0() {
        return this.updateTransforms_;
    }

    public String t0() {
        return this.operationCase_ == 5 ? (String) this.operation_ : "";
    }

    public boolean u0() {
        return this.currentDocument_ != null;
    }

    public boolean v0() {
        return this.operationCase_ == 6;
    }

    public boolean w0() {
        return this.operationCase_ == 1;
    }

    public boolean x0() {
        return this.updateMask_ != null;
    }
}
