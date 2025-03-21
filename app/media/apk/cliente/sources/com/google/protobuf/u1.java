package com.google.protobuf;

import com.google.protobuf.z;
/* loaded from: classes.dex */
public final class u1 extends z<u1, b> implements x0 {
    private static final u1 DEFAULT_INSTANCE;
    public static final int NANOS_FIELD_NUMBER = 2;
    private static volatile g1<u1> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 1;
    private int nanos_;
    private long seconds_;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2142a;

        static {
            int[] iArr = new int[z.f.values().length];
            f2142a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2142a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2142a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2142a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2142a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2142a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2142a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<u1, b> implements x0 {
        private b() {
            super(u1.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b E(int i5) {
            w();
            ((u1) this.f2203b).k0(i5);
            return this;
        }

        public b F(long j5) {
            w();
            ((u1) this.f2203b).l0(j5);
            return this;
        }
    }

    static {
        u1 u1Var = new u1();
        DEFAULT_INSTANCE = u1Var;
        z.a0(u1.class, u1Var);
    }

    private u1() {
    }

    public static u1 g0() {
        return DEFAULT_INSTANCE;
    }

    public static b j0() {
        return DEFAULT_INSTANCE.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(int i5) {
        this.nanos_ = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(long j5) {
        this.seconds_ = j5;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f2142a[fVar.ordinal()]) {
            case 1:
                return new u1();
            case 2:
                return new b(null);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"seconds_", "nanos_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<u1> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (u1.class) {
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

    public int h0() {
        return this.nanos_;
    }

    public long i0() {
        return this.seconds_;
    }
}
