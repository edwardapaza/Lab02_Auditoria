package g2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import java.util.List;
/* loaded from: classes.dex */
public final class a extends z<a, b> implements x0 {
    private static final a DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g1<a> PARSER = null;
    public static final int QUERY_SCOPE_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 4;
    private int queryScope_;
    private int state_;
    private String name_ = "";
    private d0.i<c> fields_ = z.G();

    /* renamed from: g2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0052a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3057a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3057a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3057a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3057a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3057a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3057a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3057a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3057a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<a, b> implements x0 {
        private b() {
            super(a.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(C0052a c0052a) {
            this();
        }

        public b E(c.b bVar) {
            w();
            ((a) this.f2203b).g0(bVar.build());
            return this;
        }

        public b F(d dVar) {
            w();
            ((a) this.f2203b).l0(dVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends z<c, b> implements x0 {
        public static final int ARRAY_CONFIG_FIELD_NUMBER = 3;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int ORDER_FIELD_NUMBER = 2;
        private static volatile g1<c> PARSER;
        private Object valueMode_;
        private int valueModeCase_ = 0;
        private String fieldPath_ = "";

        /* renamed from: g2.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0053a implements d0.c {
            ARRAY_CONFIG_UNSPECIFIED(0),
            CONTAINS(1),
            UNRECOGNIZED(-1);
            

            /* renamed from: e  reason: collision with root package name */
            private static final d0.d<EnumC0053a> f3061e = new C0054a();

            /* renamed from: a  reason: collision with root package name */
            private final int f3063a;

            /* renamed from: g2.a$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0054a implements d0.d<EnumC0053a> {
                C0054a() {
                }

                @Override // com.google.protobuf.d0.d
                /* renamed from: b */
                public EnumC0053a a(int i5) {
                    return EnumC0053a.a(i5);
                }
            }

            EnumC0053a(int i5) {
                this.f3063a = i5;
            }

            public static EnumC0053a a(int i5) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        return null;
                    }
                    return CONTAINS;
                }
                return ARRAY_CONFIG_UNSPECIFIED;
            }

            @Override // com.google.protobuf.d0.c
            public final int b() {
                if (this != UNRECOGNIZED) {
                    return this.f3063a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends z.a<c, b> implements x0 {
            private b() {
                super(c.DEFAULT_INSTANCE);
            }

            /* synthetic */ b(C0052a c0052a) {
                this();
            }

            public b E(EnumC0053a enumC0053a) {
                w();
                ((c) this.f2203b).l0(enumC0053a);
                return this;
            }

            public b F(String str) {
                w();
                ((c) this.f2203b).m0(str);
                return this;
            }

            public b G(EnumC0055c enumC0055c) {
                w();
                ((c) this.f2203b).n0(enumC0055c);
                return this;
            }
        }

        /* renamed from: g2.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0055c implements d0.c {
            ORDER_UNSPECIFIED(0),
            ASCENDING(1),
            DESCENDING(2),
            UNRECOGNIZED(-1);
            

            /* renamed from: f  reason: collision with root package name */
            private static final d0.d<EnumC0055c> f3068f = new C0056a();

            /* renamed from: a  reason: collision with root package name */
            private final int f3070a;

            /* renamed from: g2.a$c$c$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0056a implements d0.d<EnumC0055c> {
                C0056a() {
                }

                @Override // com.google.protobuf.d0.d
                /* renamed from: b */
                public EnumC0055c a(int i5) {
                    return EnumC0055c.a(i5);
                }
            }

            EnumC0055c(int i5) {
                this.f3070a = i5;
            }

            public static EnumC0055c a(int i5) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            return null;
                        }
                        return DESCENDING;
                    }
                    return ASCENDING;
                }
                return ORDER_UNSPECIFIED;
            }

            @Override // com.google.protobuf.d0.c
            public final int b() {
                if (this != UNRECOGNIZED) {
                    return this.f3070a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* loaded from: classes.dex */
        public enum d {
            ORDER(2),
            ARRAY_CONFIG(3),
            VALUEMODE_NOT_SET(0);
            

            /* renamed from: a  reason: collision with root package name */
            private final int f3075a;

            d(int i5) {
                this.f3075a = i5;
            }

            public static d a(int i5) {
                if (i5 != 0) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            return null;
                        }
                        return ARRAY_CONFIG;
                    }
                    return ORDER;
                }
                return VALUEMODE_NOT_SET;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            z.a0(c.class, cVar);
        }

        private c() {
        }

        public static b k0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(EnumC0053a enumC0053a) {
            this.valueMode_ = Integer.valueOf(enumC0053a.b());
            this.valueModeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(EnumC0055c enumC0055c) {
            this.valueMode_ = Integer.valueOf(enumC0055c.b());
            this.valueModeCase_ = 2;
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (C0052a.f3057a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new b(null);
                case 3:
                    return z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003?\u0000", new Object[]{"valueMode_", "valueModeCase_", "fieldPath_"});
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

        public String h0() {
            return this.fieldPath_;
        }

        public EnumC0055c i0() {
            if (this.valueModeCase_ == 2) {
                EnumC0055c a5 = EnumC0055c.a(((Integer) this.valueMode_).intValue());
                return a5 == null ? EnumC0055c.UNRECOGNIZED : a5;
            }
            return EnumC0055c.ORDER_UNSPECIFIED;
        }

        public d j0() {
            return d.a(this.valueModeCase_);
        }
    }

    /* loaded from: classes.dex */
    public enum d implements d0.c {
        QUERY_SCOPE_UNSPECIFIED(0),
        COLLECTION(1),
        COLLECTION_GROUP(2),
        UNRECOGNIZED(-1);
        

        /* renamed from: f  reason: collision with root package name */
        private static final d0.d<d> f3080f = new C0057a();

        /* renamed from: a  reason: collision with root package name */
        private final int f3082a;

        /* renamed from: g2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0057a implements d0.d<d> {
            C0057a() {
            }

            @Override // com.google.protobuf.d0.d
            /* renamed from: b */
            public d a(int i5) {
                return d.a(i5);
            }
        }

        d(int i5) {
            this.f3082a = i5;
        }

        public static d a(int i5) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        return null;
                    }
                    return COLLECTION_GROUP;
                }
                return COLLECTION;
            }
            return QUERY_SCOPE_UNSPECIFIED;
        }

        @Override // com.google.protobuf.d0.c
        public final int b() {
            if (this != UNRECOGNIZED) {
                return this.f3082a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.a0(a.class, aVar);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(c cVar) {
        cVar.getClass();
        h0();
        this.fields_.add(cVar);
    }

    private void h0() {
        d0.i<c> iVar = this.fields_;
        if (iVar.j()) {
            return;
        }
        this.fields_ = z.Q(iVar);
    }

    public static b j0() {
        return DEFAULT_INSTANCE.A();
    }

    public static a k0(byte[] bArr) {
        return (a) z.W(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(d dVar) {
        this.queryScope_ = dVar.b();
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (C0052a.f3057a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(null);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\f\u0003\u001b\u0004\f", new Object[]{"name_", "queryScope_", "fields_", c.class, "state_"});
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

    public List<c> i0() {
        return this.fields_;
    }
}
