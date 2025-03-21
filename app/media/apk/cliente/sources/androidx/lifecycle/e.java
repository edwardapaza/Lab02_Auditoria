package androidx.lifecycle;

import androidx.lifecycle.i;
/* loaded from: classes.dex */
public final class e implements k {

    /* renamed from: a  reason: collision with root package name */
    private final d f531a;

    /* renamed from: b  reason: collision with root package name */
    private final k f532b;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f533a;

        static {
            int[] iArr = new int[i.a.values().length];
            try {
                iArr[i.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[i.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[i.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[i.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[i.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[i.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[i.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f533a = iArr;
        }
    }

    public e(d dVar, k kVar) {
        e4.k.e(dVar, "defaultLifecycleObserver");
        this.f531a = dVar;
        this.f532b = kVar;
    }

    @Override // androidx.lifecycle.k
    public void d(m mVar, i.a aVar) {
        e4.k.e(mVar, "source");
        e4.k.e(aVar, "event");
        switch (a.f533a[aVar.ordinal()]) {
            case 1:
                this.f531a.c(mVar);
                break;
            case 2:
                this.f531a.f(mVar);
                break;
            case 3:
                this.f531a.a(mVar);
                break;
            case 4:
                this.f531a.e(mVar);
                break;
            case 5:
                this.f531a.g(mVar);
                break;
            case 6:
                this.f531a.b(mVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        k kVar = this.f532b;
        if (kVar != null) {
            kVar.d(mVar, aVar);
        }
    }
}
