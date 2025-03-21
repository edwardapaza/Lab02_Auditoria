package i2;

import com.google.protobuf.f1;
import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import i2.b;
import i2.u;
import m2.a;
/* loaded from: classes.dex */
public final class d0 extends com.google.protobuf.z<d0, b> implements x0 {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final d0 DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile g1<d0> PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3173a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3173a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3173a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3173a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3173a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3173a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3173a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3173a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<d0, b> implements x0 {
        private b() {
            super(d0.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public u E() {
            return ((d0) this.f2203b).w0();
        }

        public b F(b.C0063b c0063b) {
            w();
            ((d0) this.f2203b).C0(c0063b.build());
            return this;
        }

        public b G(i2.b bVar) {
            w();
            ((d0) this.f2203b).C0(bVar);
            return this;
        }

        public b H(boolean z4) {
            w();
            ((d0) this.f2203b).D0(z4);
            return this;
        }

        public b I(com.google.protobuf.i iVar) {
            w();
            ((d0) this.f2203b).E0(iVar);
            return this;
        }

        public b J(double d5) {
            w();
            ((d0) this.f2203b).F0(d5);
            return this;
        }

        public b K(a.b bVar) {
            w();
            ((d0) this.f2203b).G0(bVar.build());
            return this;
        }

        public b L(long j5) {
            w();
            ((d0) this.f2203b).H0(j5);
            return this;
        }

        public b M(u.b bVar) {
            w();
            ((d0) this.f2203b).I0(bVar.build());
            return this;
        }

        public b N(u uVar) {
            w();
            ((d0) this.f2203b).I0(uVar);
            return this;
        }

        public b O(f1 f1Var) {
            w();
            ((d0) this.f2203b).J0(f1Var);
            return this;
        }

        public b P(String str) {
            w();
            ((d0) this.f2203b).K0(str);
            return this;
        }

        public b Q(String str) {
            w();
            ((d0) this.f2203b).L0(str);
            return this;
        }

        public b R(u1.b bVar) {
            w();
            ((d0) this.f2203b).M0(bVar.build());
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        NULL_VALUE(11),
        BOOLEAN_VALUE(1),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(18),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(8),
        ARRAY_VALUE(9),
        MAP_VALUE(6),
        VALUETYPE_NOT_SET(0);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f3187a;

        c(int i5) {
            this.f3187a = i5;
        }

        public static c a(int i5) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 5) {
                                if (i5 != 6) {
                                    if (i5 != 17) {
                                        if (i5 != 18) {
                                            switch (i5) {
                                                case 8:
                                                    return GEO_POINT_VALUE;
                                                case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                                                    return ARRAY_VALUE;
                                                case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                                                    return TIMESTAMP_VALUE;
                                                case 11:
                                                    return NULL_VALUE;
                                                default:
                                                    return null;
                                            }
                                        }
                                        return BYTES_VALUE;
                                    }
                                    return STRING_VALUE;
                                }
                                return MAP_VALUE;
                            }
                            return REFERENCE_VALUE;
                        }
                        return DOUBLE_VALUE;
                    }
                    return INTEGER_VALUE;
                }
                return BOOLEAN_VALUE;
            }
            return VALUETYPE_NOT_SET;
        }
    }

    static {
        d0 d0Var = new d0();
        DEFAULT_INSTANCE = d0Var;
        com.google.protobuf.z.a0(d0.class, d0Var);
    }

    private d0() {
    }

    public static b B0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(i2.b bVar) {
        bVar.getClass();
        this.valueType_ = bVar;
        this.valueTypeCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(boolean z4) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(com.google.protobuf.i iVar) {
        iVar.getClass();
        this.valueTypeCase_ = 18;
        this.valueType_ = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(double d5) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(m2.a aVar) {
        aVar.getClass();
        this.valueType_ = aVar;
        this.valueTypeCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(long j5) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(u uVar) {
        uVar.getClass();
        this.valueType_ = uVar;
        this.valueTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(f1 f1Var) {
        this.valueType_ = Integer.valueOf(f1Var.b());
        this.valueTypeCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(String str) {
        str.getClass();
        this.valueTypeCase_ = 5;
        this.valueType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(String str) {
        str.getClass();
        this.valueTypeCase_ = 17;
        this.valueType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(u1 u1Var) {
        u1Var.getClass();
        this.valueType_ = u1Var;
        this.valueTypeCase_ = 10;
    }

    public static d0 s0() {
        return DEFAULT_INSTANCE;
    }

    public c A0() {
        return c.a(this.valueTypeCase_);
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3173a[fVar.ordinal()]) {
            case 1:
                return new d0();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u0012\u000b\u0000\u0000\u0000\u0001:\u0000\u00025\u0000\u00033\u0000\u0005Ȼ\u0000\u0006<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b?\u0000\u0011Ȼ\u0000\u0012=\u0000", new Object[]{"valueType_", "valueTypeCase_", u.class, m2.a.class, i2.b.class, u1.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<d0> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (d0.class) {
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

    public i2.b p0() {
        return this.valueTypeCase_ == 9 ? (i2.b) this.valueType_ : i2.b.k0();
    }

    public boolean q0() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    public com.google.protobuf.i r0() {
        return this.valueTypeCase_ == 18 ? (com.google.protobuf.i) this.valueType_ : com.google.protobuf.i.f1961b;
    }

    public double t0() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }

    public m2.a u0() {
        return this.valueTypeCase_ == 8 ? (m2.a) this.valueType_ : m2.a.g0();
    }

    public long v0() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0L;
    }

    public u w0() {
        return this.valueTypeCase_ == 6 ? (u) this.valueType_ : u.f0();
    }

    public String x0() {
        return this.valueTypeCase_ == 5 ? (String) this.valueType_ : "";
    }

    public String y0() {
        return this.valueTypeCase_ == 17 ? (String) this.valueType_ : "";
    }

    public u1 z0() {
        return this.valueTypeCase_ == 10 ? (u1) this.valueType_ : u1.g0();
    }
}
