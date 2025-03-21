package i2;

import com.google.protobuf.a0;
import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import i2.j;
import java.util.List;
/* loaded from: classes.dex */
public final class z extends com.google.protobuf.z<z, b> implements x0 {
    private static final z DEFAULT_INSTANCE;
    public static final int END_AT_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 2;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORDER_BY_FIELD_NUMBER = 4;
    private static volatile g1<z> PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 1;
    public static final int START_AT_FIELD_NUMBER = 7;
    public static final int WHERE_FIELD_NUMBER = 3;
    private i2.j endAt_;
    private com.google.protobuf.a0 limit_;
    private int offset_;
    private j select_;
    private i2.j startAt_;
    private h where_;
    private d0.i<c> from_ = com.google.protobuf.z.G();
    private d0.i<i> orderBy_ = com.google.protobuf.z.G();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3261a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3261a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3261a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3261a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3261a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3261a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3261a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3261a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<z, b> implements x0 {
        private b() {
            super(z.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(c.a aVar) {
            w();
            ((z) this.f2203b).k0(aVar.build());
            return this;
        }

        public b F(i iVar) {
            w();
            ((z) this.f2203b).l0(iVar);
            return this;
        }

        public b G(j.b bVar) {
            w();
            ((z) this.f2203b).C0(bVar.build());
            return this;
        }

        public b H(a0.b bVar) {
            w();
            ((z) this.f2203b).D0(bVar.build());
            return this;
        }

        public b I(j.b bVar) {
            w();
            ((z) this.f2203b).E0(bVar.build());
            return this;
        }

        public b J(h hVar) {
            w();
            ((z) this.f2203b).F0(hVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends com.google.protobuf.z<c, a> implements x0 {
        public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
        public static final int COLLECTION_ID_FIELD_NUMBER = 2;
        private static final c DEFAULT_INSTANCE;
        private static volatile g1<c> PARSER;
        private boolean allDescendants_;
        private String collectionId_ = "";

        /* loaded from: classes.dex */
        public static final class a extends z.a<c, a> implements x0 {
            private a() {
                super(c.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(boolean z4) {
                w();
                ((c) this.f2203b).j0(z4);
                return this;
            }

            public a F(String str) {
                w();
                ((c) this.f2203b).k0(str);
                return this;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            com.google.protobuf.z.a0(c.class, cVar);
        }

        private c() {
        }

        public static a i0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j0(boolean z4) {
            this.allDescendants_ = z4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0(String str) {
            str.getClass();
            this.collectionId_ = str;
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3261a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0007", new Object[]{"collectionId_", "allDescendants_"});
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

        public boolean g0() {
            return this.allDescendants_;
        }

        public String h0() {
            return this.collectionId_;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends com.google.protobuf.z<d, a> implements x0 {
        private static final d DEFAULT_INSTANCE;
        public static final int FILTERS_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile g1<d> PARSER;
        private d0.i<h> filters_ = com.google.protobuf.z.G();
        private int op_;

        /* loaded from: classes.dex */
        public static final class a extends z.a<d, a> implements x0 {
            private a() {
                super(d.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(Iterable<? extends h> iterable) {
                w();
                ((d) this.f2203b).g0(iterable);
                return this;
            }

            public a F(b bVar) {
                w();
                ((d) this.f2203b).m0(bVar);
                return this;
            }
        }

        /* loaded from: classes.dex */
        public enum b implements d0.c {
            OPERATOR_UNSPECIFIED(0),
            AND(1),
            OR(2),
            UNRECOGNIZED(-1);
            

            /* renamed from: f  reason: collision with root package name */
            private static final d0.d<b> f3266f = new a();

            /* renamed from: a  reason: collision with root package name */
            private final int f3268a;

            /* loaded from: classes.dex */
            class a implements d0.d<b> {
                a() {
                }

                @Override // com.google.protobuf.d0.d
                /* renamed from: b */
                public b a(int i5) {
                    return b.a(i5);
                }
            }

            b(int i5) {
                this.f3268a = i5;
            }

            public static b a(int i5) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            return null;
                        }
                        return OR;
                    }
                    return AND;
                }
                return OPERATOR_UNSPECIFIED;
            }

            @Override // com.google.protobuf.d0.c
            public final int b() {
                if (this != UNRECOGNIZED) {
                    return this.f3268a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            d dVar = new d();
            DEFAULT_INSTANCE = dVar;
            com.google.protobuf.z.a0(d.class, dVar);
        }

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g0(Iterable<? extends h> iterable) {
            h0();
            com.google.protobuf.a.o(iterable, this.filters_);
        }

        private void h0() {
            d0.i<h> iVar = this.filters_;
            if (iVar.j()) {
                return;
            }
            this.filters_ = com.google.protobuf.z.Q(iVar);
        }

        public static d i0() {
            return DEFAULT_INSTANCE;
        }

        public static a l0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(b bVar) {
            this.op_ = bVar.b();
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3261a[fVar.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002\u001b", new Object[]{"op_", "filters_", h.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<d> g1Var = PARSER;
                    if (g1Var == null) {
                        synchronized (d.class) {
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

        public List<h> j0() {
            return this.filters_;
        }

        public b k0() {
            b a5 = b.a(this.op_);
            return a5 == null ? b.UNRECOGNIZED : a5;
        }
    }

    /* loaded from: classes.dex */
    public enum e implements d0.c {
        DIRECTION_UNSPECIFIED(0),
        ASCENDING(1),
        DESCENDING(2),
        UNRECOGNIZED(-1);
        

        /* renamed from: f  reason: collision with root package name */
        private static final d0.d<e> f3273f = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f3275a;

        /* loaded from: classes.dex */
        class a implements d0.d<e> {
            a() {
            }

            @Override // com.google.protobuf.d0.d
            /* renamed from: b */
            public e a(int i5) {
                return e.a(i5);
            }
        }

        e(int i5) {
            this.f3275a = i5;
        }

        public static e a(int i5) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        return null;
                    }
                    return DESCENDING;
                }
                return ASCENDING;
            }
            return DIRECTION_UNSPECIFIED;
        }

        @Override // com.google.protobuf.d0.c
        public final int b() {
            if (this != UNRECOGNIZED) {
                return this.f3275a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends com.google.protobuf.z<f, a> implements x0 {
        private static final f DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int OP_FIELD_NUMBER = 2;
        private static volatile g1<f> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private g field_;
        private int op_;
        private d0 value_;

        /* loaded from: classes.dex */
        public static final class a extends z.a<f, a> implements x0 {
            private a() {
                super(f.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(g gVar) {
                w();
                ((f) this.f2203b).m0(gVar);
                return this;
            }

            public a F(b bVar) {
                w();
                ((f) this.f2203b).n0(bVar);
                return this;
            }

            public a G(d0 d0Var) {
                w();
                ((f) this.f2203b).o0(d0Var);
                return this;
            }
        }

        /* loaded from: classes.dex */
        public enum b implements d0.c {
            OPERATOR_UNSPECIFIED(0),
            LESS_THAN(1),
            LESS_THAN_OR_EQUAL(2),
            GREATER_THAN(3),
            GREATER_THAN_OR_EQUAL(4),
            EQUAL(5),
            NOT_EQUAL(6),
            ARRAY_CONTAINS(7),
            IN(8),
            ARRAY_CONTAINS_ANY(9),
            NOT_IN(10),
            UNRECOGNIZED(-1);
            

            /* renamed from: r  reason: collision with root package name */
            private static final d0.d<b> f3288r = new a();

            /* renamed from: a  reason: collision with root package name */
            private final int f3290a;

            /* loaded from: classes.dex */
            class a implements d0.d<b> {
                a() {
                }

                @Override // com.google.protobuf.d0.d
                /* renamed from: b */
                public b a(int i5) {
                    return b.a(i5);
                }
            }

            b(int i5) {
                this.f3290a = i5;
            }

            public static b a(int i5) {
                switch (i5) {
                    case 0:
                        return OPERATOR_UNSPECIFIED;
                    case 1:
                        return LESS_THAN;
                    case 2:
                        return LESS_THAN_OR_EQUAL;
                    case 3:
                        return GREATER_THAN;
                    case 4:
                        return GREATER_THAN_OR_EQUAL;
                    case 5:
                        return EQUAL;
                    case 6:
                        return NOT_EQUAL;
                    case 7:
                        return ARRAY_CONTAINS;
                    case 8:
                        return IN;
                    case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        return ARRAY_CONTAINS_ANY;
                    case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        return NOT_IN;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.d0.c
            public final int b() {
                if (this != UNRECOGNIZED) {
                    return this.f3290a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            f fVar = new f();
            DEFAULT_INSTANCE = fVar;
            com.google.protobuf.z.a0(f.class, fVar);
        }

        private f() {
        }

        public static f h0() {
            return DEFAULT_INSTANCE;
        }

        public static a l0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(g gVar) {
            gVar.getClass();
            this.field_ = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(b bVar) {
            this.op_ = bVar.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(d0 d0Var) {
            d0Var.getClass();
            this.value_ = d0Var;
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3261a[fVar.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\f\u0003\t", new Object[]{"field_", "op_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<f> g1Var = PARSER;
                    if (g1Var == null) {
                        synchronized (f.class) {
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

        public g i0() {
            g gVar = this.field_;
            return gVar == null ? g.f0() : gVar;
        }

        public b j0() {
            b a5 = b.a(this.op_);
            return a5 == null ? b.UNRECOGNIZED : a5;
        }

        public d0 k0() {
            d0 d0Var = this.value_;
            return d0Var == null ? d0.s0() : d0Var;
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends com.google.protobuf.z<g, a> implements x0 {
        private static final g DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 2;
        private static volatile g1<g> PARSER;
        private String fieldPath_ = "";

        /* loaded from: classes.dex */
        public static final class a extends z.a<g, a> implements x0 {
            private a() {
                super(g.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(String str) {
                w();
                ((g) this.f2203b).i0(str);
                return this;
            }
        }

        static {
            g gVar = new g();
            DEFAULT_INSTANCE = gVar;
            com.google.protobuf.z.a0(g.class, gVar);
        }

        private g() {
        }

        public static g f0() {
            return DEFAULT_INSTANCE;
        }

        public static a h0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3261a[fVar.ordinal()]) {
                case 1:
                    return new g();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"fieldPath_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<g> g1Var = PARSER;
                    if (g1Var == null) {
                        synchronized (g.class) {
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

        public String g0() {
            return this.fieldPath_;
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends com.google.protobuf.z<h, a> implements x0 {
        public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
        private static final h DEFAULT_INSTANCE;
        public static final int FIELD_FILTER_FIELD_NUMBER = 2;
        private static volatile g1<h> PARSER = null;
        public static final int UNARY_FILTER_FIELD_NUMBER = 3;
        private int filterTypeCase_ = 0;
        private Object filterType_;

        /* loaded from: classes.dex */
        public static final class a extends z.a<h, a> implements x0 {
            private a() {
                super(h.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(d.a aVar) {
                w();
                ((h) this.f2203b).n0(aVar.build());
                return this;
            }

            public a F(f.a aVar) {
                w();
                ((h) this.f2203b).o0(aVar.build());
                return this;
            }

            public a G(k.a aVar) {
                w();
                ((h) this.f2203b).p0(aVar.build());
                return this;
            }
        }

        /* loaded from: classes.dex */
        public enum b {
            COMPOSITE_FILTER(1),
            FIELD_FILTER(2),
            UNARY_FILTER(3),
            FILTERTYPE_NOT_SET(0);
            

            /* renamed from: a  reason: collision with root package name */
            private final int f3296a;

            b(int i5) {
                this.f3296a = i5;
            }

            public static b a(int i5) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                return null;
                            }
                            return UNARY_FILTER;
                        }
                        return FIELD_FILTER;
                    }
                    return COMPOSITE_FILTER;
                }
                return FILTERTYPE_NOT_SET;
            }
        }

        static {
            h hVar = new h();
            DEFAULT_INSTANCE = hVar;
            com.google.protobuf.z.a0(h.class, hVar);
        }

        private h() {
        }

        public static h i0() {
            return DEFAULT_INSTANCE;
        }

        public static a m0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(d dVar) {
            dVar.getClass();
            this.filterType_ = dVar;
            this.filterTypeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(f fVar) {
            fVar.getClass();
            this.filterType_ = fVar;
            this.filterTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(k kVar) {
            kVar.getClass();
            this.filterType_ = kVar;
            this.filterTypeCase_ = 3;
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3261a[fVar.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"filterType_", "filterTypeCase_", d.class, f.class, k.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<h> g1Var = PARSER;
                    if (g1Var == null) {
                        synchronized (h.class) {
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

        public d h0() {
            return this.filterTypeCase_ == 1 ? (d) this.filterType_ : d.i0();
        }

        public f j0() {
            return this.filterTypeCase_ == 2 ? (f) this.filterType_ : f.h0();
        }

        public b k0() {
            return b.a(this.filterTypeCase_);
        }

        public k l0() {
            return this.filterTypeCase_ == 3 ? (k) this.filterType_ : k.g0();
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends com.google.protobuf.z<i, a> implements x0 {
        private static final i DEFAULT_INSTANCE;
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile g1<i> PARSER;
        private int direction_;
        private g field_;

        /* loaded from: classes.dex */
        public static final class a extends z.a<i, a> implements x0 {
            private a() {
                super(i.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(e eVar) {
                w();
                ((i) this.f2203b).j0(eVar);
                return this;
            }

            public a F(g gVar) {
                w();
                ((i) this.f2203b).k0(gVar);
                return this;
            }
        }

        static {
            i iVar = new i();
            DEFAULT_INSTANCE = iVar;
            com.google.protobuf.z.a0(i.class, iVar);
        }

        private i() {
        }

        public static a i0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j0(e eVar) {
            this.direction_ = eVar.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0(g gVar) {
            gVar.getClass();
            this.field_ = gVar;
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3261a[fVar.ordinal()]) {
                case 1:
                    return new i();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\f", new Object[]{"field_", "direction_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<i> g1Var = PARSER;
                    if (g1Var == null) {
                        synchronized (i.class) {
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

        public e g0() {
            e a5 = e.a(this.direction_);
            return a5 == null ? e.UNRECOGNIZED : a5;
        }

        public g h0() {
            g gVar = this.field_;
            return gVar == null ? g.f0() : gVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class j extends com.google.protobuf.z<j, a> implements x0 {
        private static final j DEFAULT_INSTANCE;
        public static final int FIELDS_FIELD_NUMBER = 2;
        private static volatile g1<j> PARSER;
        private d0.i<g> fields_ = com.google.protobuf.z.G();

        /* loaded from: classes.dex */
        public static final class a extends z.a<j, a> implements x0 {
            private a() {
                super(j.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }
        }

        static {
            j jVar = new j();
            DEFAULT_INSTANCE = jVar;
            com.google.protobuf.z.a0(j.class, jVar);
        }

        private j() {
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3261a[fVar.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", new Object[]{"fields_", g.class});
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
    }

    /* loaded from: classes.dex */
    public static final class k extends com.google.protobuf.z<k, a> implements x0 {
        private static final k DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile g1<k> PARSER;
        private int op_;
        private int operandTypeCase_ = 0;
        private Object operandType_;

        /* loaded from: classes.dex */
        public static final class a extends z.a<k, a> implements x0 {
            private a() {
                super(k.DEFAULT_INSTANCE);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a E(g gVar) {
                w();
                ((k) this.f2203b).k0(gVar);
                return this;
            }

            public a F(b bVar) {
                w();
                ((k) this.f2203b).l0(bVar);
                return this;
            }
        }

        /* loaded from: classes.dex */
        public enum b implements d0.c {
            OPERATOR_UNSPECIFIED(0),
            IS_NAN(2),
            IS_NULL(3),
            IS_NOT_NAN(4),
            IS_NOT_NULL(5),
            UNRECOGNIZED(-1);
            

            /* renamed from: l  reason: collision with root package name */
            private static final d0.d<b> f3303l = new a();

            /* renamed from: a  reason: collision with root package name */
            private final int f3305a;

            /* loaded from: classes.dex */
            class a implements d0.d<b> {
                a() {
                }

                @Override // com.google.protobuf.d0.d
                /* renamed from: b */
                public b a(int i5) {
                    return b.a(i5);
                }
            }

            b(int i5) {
                this.f3305a = i5;
            }

            public static b a(int i5) {
                if (i5 != 0) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                if (i5 != 5) {
                                    return null;
                                }
                                return IS_NOT_NULL;
                            }
                            return IS_NOT_NAN;
                        }
                        return IS_NULL;
                    }
                    return IS_NAN;
                }
                return OPERATOR_UNSPECIFIED;
            }

            @Override // com.google.protobuf.d0.c
            public final int b() {
                if (this != UNRECOGNIZED) {
                    return this.f3305a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            k kVar = new k();
            DEFAULT_INSTANCE = kVar;
            com.google.protobuf.z.a0(k.class, kVar);
        }

        private k() {
        }

        public static k g0() {
            return DEFAULT_INSTANCE;
        }

        public static a j0() {
            return DEFAULT_INSTANCE.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0(g gVar) {
            gVar.getClass();
            this.operandType_ = gVar;
            this.operandTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(b bVar) {
            this.op_ = bVar.b();
        }

        @Override // com.google.protobuf.z
        protected final Object E(z.f fVar, Object obj, Object obj2) {
            switch (a.f3261a[fVar.ordinal()]) {
                case 1:
                    return new k();
                case 2:
                    return new a(null);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002<\u0000", new Object[]{"operandType_", "operandTypeCase_", "op_", g.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<k> g1Var = PARSER;
                    if (g1Var == null) {
                        synchronized (k.class) {
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

        public g h0() {
            return this.operandTypeCase_ == 2 ? (g) this.operandType_ : g.f0();
        }

        public b i0() {
            b a5 = b.a(this.op_);
            return a5 == null ? b.UNRECOGNIZED : a5;
        }
    }

    static {
        z zVar = new z();
        DEFAULT_INSTANCE = zVar;
        com.google.protobuf.z.a0(z.class, zVar);
    }

    private z() {
    }

    public static b B0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(i2.j jVar) {
        jVar.getClass();
        this.endAt_ = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(com.google.protobuf.a0 a0Var) {
        a0Var.getClass();
        this.limit_ = a0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(i2.j jVar) {
        jVar.getClass();
        this.startAt_ = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(h hVar) {
        hVar.getClass();
        this.where_ = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(c cVar) {
        cVar.getClass();
        m0();
        this.from_.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(i iVar) {
        iVar.getClass();
        n0();
        this.orderBy_.add(iVar);
    }

    private void m0() {
        d0.i<c> iVar = this.from_;
        if (iVar.j()) {
            return;
        }
        this.from_ = com.google.protobuf.z.Q(iVar);
    }

    private void n0() {
        d0.i<i> iVar = this.orderBy_;
        if (iVar.j()) {
            return;
        }
        this.orderBy_ = com.google.protobuf.z.Q(iVar);
    }

    public static z o0() {
        return DEFAULT_INSTANCE;
    }

    public boolean A0() {
        return this.where_ != null;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3261a[fVar.ordinal()]) {
            case 1:
                return new z();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0002\u0000\u0001\t\u0002\u001b\u0003\t\u0004\u001b\u0005\t\u0006\u0004\u0007\t\b\t", new Object[]{"select_", "from_", c.class, "where_", "orderBy_", i.class, "limit_", "offset_", "startAt_", "endAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<z> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (z.class) {
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

    public i2.j p0() {
        i2.j jVar = this.endAt_;
        return jVar == null ? i2.j.j0() : jVar;
    }

    public c q0(int i5) {
        return this.from_.get(i5);
    }

    public int r0() {
        return this.from_.size();
    }

    public com.google.protobuf.a0 s0() {
        com.google.protobuf.a0 a0Var = this.limit_;
        return a0Var == null ? com.google.protobuf.a0.f0() : a0Var;
    }

    public i t0(int i5) {
        return this.orderBy_.get(i5);
    }

    public int u0() {
        return this.orderBy_.size();
    }

    public i2.j v0() {
        i2.j jVar = this.startAt_;
        return jVar == null ? i2.j.j0() : jVar;
    }

    public h w0() {
        h hVar = this.where_;
        return hVar == null ? h.i0() : hVar;
    }

    public boolean x0() {
        return this.endAt_ != null;
    }

    public boolean y0() {
        return this.limit_ != null;
    }

    public boolean z0() {
        return this.startAt_ != null;
    }
}
