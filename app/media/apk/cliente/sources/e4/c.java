package e4;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class c implements i4.a, Serializable {

    /* renamed from: k  reason: collision with root package name */
    public static final Object f2917k = a.f2924a;

    /* renamed from: a  reason: collision with root package name */
    private transient i4.a f2918a;

    /* renamed from: b  reason: collision with root package name */
    protected final Object f2919b;

    /* renamed from: c  reason: collision with root package name */
    private final Class f2920c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2921d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2922e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2923f;

    /* loaded from: classes.dex */
    private static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private static final a f2924a = new a();

        private a() {
        }
    }

    public c() {
        this(f2917k);
    }

    protected c(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Object obj, Class cls, String str, String str2, boolean z4) {
        this.f2919b = obj;
        this.f2920c = cls;
        this.f2921d = str;
        this.f2922e = str2;
        this.f2923f = z4;
    }

    public i4.a a() {
        i4.a aVar = this.f2918a;
        if (aVar == null) {
            i4.a c5 = c();
            this.f2918a = c5;
            return c5;
        }
        return aVar;
    }

    protected abstract i4.a c();

    public Object e() {
        return this.f2919b;
    }

    public String f() {
        return this.f2921d;
    }

    public i4.d g() {
        Class cls = this.f2920c;
        if (cls == null) {
            return null;
        }
        return this.f2923f ? s.c(cls) : s.b(cls);
    }

    public String h() {
        return this.f2922e;
    }
}
