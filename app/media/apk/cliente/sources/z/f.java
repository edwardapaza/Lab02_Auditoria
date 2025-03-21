package z;

import java.util.List;
/* loaded from: classes.dex */
final class f<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    private final T f8830b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8831c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8832d;

    /* renamed from: e  reason: collision with root package name */
    private final g f8833e;

    /* renamed from: f  reason: collision with root package name */
    private final j f8834f;

    /* renamed from: g  reason: collision with root package name */
    private final l f8835g;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8836a;

        static {
            int[] iArr = new int[j.values().length];
            try {
                iArr[j.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[j.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[j.QUIET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f8836a = iArr;
        }
    }

    public f(T t5, String str, String str2, g gVar, j jVar) {
        List h5;
        e4.k.e(t5, "value");
        e4.k.e(str, "tag");
        e4.k.e(str2, "message");
        e4.k.e(gVar, "logger");
        e4.k.e(jVar, "verificationMode");
        this.f8830b = t5;
        this.f8831c = str;
        this.f8832d = str2;
        this.f8833e = gVar;
        this.f8834f = jVar;
        l lVar = new l(b(t5, str2));
        StackTraceElement[] stackTrace = lVar.getStackTrace();
        e4.k.d(stackTrace, "stackTrace");
        h5 = t3.k.h(stackTrace, 2);
        lVar.setStackTrace((StackTraceElement[]) h5.toArray(new StackTraceElement[0]));
        this.f8835g = lVar;
    }

    @Override // z.h
    public T a() {
        int i5 = a.f8836a[this.f8834f.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                this.f8833e.a(this.f8831c, b(this.f8830b, this.f8832d));
                return null;
            } else if (i5 == 3) {
                return null;
            } else {
                throw new s3.k();
            }
        }
        throw this.f8835g;
    }

    @Override // z.h
    public h<T> c(String str, d4.l<? super T, Boolean> lVar) {
        e4.k.e(str, "message");
        e4.k.e(lVar, "condition");
        return this;
    }
}
