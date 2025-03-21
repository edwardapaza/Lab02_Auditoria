package m4;
/* loaded from: classes.dex */
public enum l0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6253a;

        static {
            int[] iArr = new int[l0.values().length];
            try {
                iArr[l0.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[l0.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[l0.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[l0.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f6253a = iArr;
        }
    }

    public final <R, T> void c(d4.p<? super R, ? super v3.d<? super T>, ? extends Object> pVar, R r5, v3.d<? super T> dVar) {
        int i5 = a.f6253a[ordinal()];
        if (i5 == 1) {
            s4.a.d(pVar, r5, dVar, null, 4, null);
        } else if (i5 == 2) {
            v3.f.a(pVar, r5, dVar);
        } else if (i5 == 3) {
            s4.b.a(pVar, r5, dVar);
        } else if (i5 != 4) {
            throw new s3.k();
        }
    }

    public final boolean d() {
        return this == LAZY;
    }
}
