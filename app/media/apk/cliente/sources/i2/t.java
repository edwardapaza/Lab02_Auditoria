package i2;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class t extends com.google.protobuf.z<t, b> implements x0 {
    private static final t DEFAULT_INSTANCE;
    public static final int DOCUMENT_CHANGE_FIELD_NUMBER = 3;
    public static final int DOCUMENT_DELETE_FIELD_NUMBER = 4;
    public static final int DOCUMENT_REMOVE_FIELD_NUMBER = 6;
    public static final int FILTER_FIELD_NUMBER = 5;
    private static volatile g1<t> PARSER = null;
    public static final int TARGET_CHANGE_FIELD_NUMBER = 2;
    private int responseTypeCase_ = 0;
    private Object responseType_;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3241a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3241a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3241a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3241a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3241a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3241a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3241a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3241a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<t, b> implements x0 {
        private b() {
            super(t.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        TARGET_CHANGE(2),
        DOCUMENT_CHANGE(3),
        DOCUMENT_DELETE(4),
        DOCUMENT_REMOVE(6),
        FILTER(5),
        RESPONSETYPE_NOT_SET(0);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f3249a;

        c(int i5) {
            this.f3249a = i5;
        }

        public static c a(int i5) {
            if (i5 != 0) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 != 5) {
                                if (i5 != 6) {
                                    return null;
                                }
                                return DOCUMENT_REMOVE;
                            }
                            return FILTER;
                        }
                        return DOCUMENT_DELETE;
                    }
                    return DOCUMENT_CHANGE;
                }
                return TARGET_CHANGE;
            }
            return RESPONSETYPE_NOT_SET;
        }
    }

    static {
        t tVar = new t();
        DEFAULT_INSTANCE = tVar;
        com.google.protobuf.z.a0(t.class, tVar);
    }

    private t() {
    }

    public static t e0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3241a[fVar.ordinal()]) {
            case 1:
                return new t();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0002\u0006\u0005\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"responseType_", "responseTypeCase_", b0.class, l.class, m.class, q.class, o.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<t> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (t.class) {
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

    public l f0() {
        return this.responseTypeCase_ == 3 ? (l) this.responseType_ : l.e0();
    }

    public m g0() {
        return this.responseTypeCase_ == 4 ? (m) this.responseType_ : m.e0();
    }

    public o h0() {
        return this.responseTypeCase_ == 6 ? (o) this.responseType_ : o.e0();
    }

    public q i0() {
        return this.responseTypeCase_ == 5 ? (q) this.responseType_ : q.f0();
    }

    public c j0() {
        return c.a(this.responseTypeCase_);
    }

    public b0 k0() {
        return this.responseTypeCase_ == 2 ? (b0) this.responseType_ : b0.f0();
    }
}
