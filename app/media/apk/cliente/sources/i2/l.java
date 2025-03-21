package i2;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import java.util.List;
/* loaded from: classes.dex */
public final class l extends com.google.protobuf.z<l, b> implements x0 {
    private static final l DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile g1<l> PARSER = null;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    public static final int TARGET_IDS_FIELD_NUMBER = 5;
    private k document_;
    private int targetIdsMemoizedSerializedSize = -1;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private d0.g targetIds_ = com.google.protobuf.z.F();
    private d0.g removedTargetIds_ = com.google.protobuf.z.F();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3213a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3213a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3213a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3213a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3213a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3213a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3213a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3213a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<l, b> implements x0 {
        private b() {
            super(l.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        l lVar = new l();
        DEFAULT_INSTANCE = lVar;
        com.google.protobuf.z.a0(l.class, lVar);
    }

    private l() {
    }

    public static l e0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    protected final Object E(z.f fVar, Object obj, Object obj2) {
        switch (a.f3213a[fVar.ordinal()]) {
            case 1:
                return new l();
            case 2:
                return new b(null);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0006\u0003\u0000\u0002\u0000\u0001\t\u0005'\u0006'", new Object[]{"document_", "targetIds_", "removedTargetIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<l> g1Var = PARSER;
                if (g1Var == null) {
                    synchronized (l.class) {
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

    public k f0() {
        k kVar = this.document_;
        return kVar == null ? k.h0() : kVar;
    }

    public List<Integer> g0() {
        return this.removedTargetIds_;
    }

    public List<Integer> h0() {
        return this.targetIds_;
    }
}
