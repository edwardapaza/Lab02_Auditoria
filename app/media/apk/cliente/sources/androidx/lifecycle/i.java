package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private AtomicReference<Object> f544a = new AtomicReference<>();

    /* loaded from: classes.dex */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;
        
        public static final C0018a Companion = new C0018a(null);

        /* renamed from: androidx.lifecycle.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0018a {

            /* renamed from: androidx.lifecycle.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public /* synthetic */ class C0019a {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f545a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[b.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f545a = iArr;
                }
            }

            private C0018a() {
            }

            public /* synthetic */ C0018a(e4.g gVar) {
                this();
            }

            public final a a(b bVar) {
                e4.k.e(bVar, "state");
                int i5 = C0019a.f545a[bVar.ordinal()];
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            return null;
                        }
                        return a.ON_PAUSE;
                    }
                    return a.ON_STOP;
                }
                return a.ON_DESTROY;
            }

            public final a b(b bVar) {
                e4.k.e(bVar, "state");
                int i5 = C0019a.f545a[bVar.ordinal()];
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 5) {
                            return null;
                        }
                        return a.ON_CREATE;
                    }
                    return a.ON_RESUME;
                }
                return a.ON_START;
            }
        }

        /* loaded from: classes.dex */
        public /* synthetic */ class b {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f546a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f546a = iArr;
            }
        }

        public final b c() {
            switch (b.f546a[ordinal()]) {
                case 1:
                case 2:
                    return b.CREATED;
                case 3:
                case 4:
                    return b.STARTED;
                case 5:
                    return b.RESUMED;
                case 6:
                    return b.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean c(b bVar) {
            e4.k.e(bVar, "state");
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(l lVar);

    public abstract b b();

    public abstract void c(l lVar);
}
