package i3;
/* loaded from: classes.dex */
public class k1 extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final j1 f3483a;

    /* renamed from: b  reason: collision with root package name */
    private final y0 f3484b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3485c;

    public k1(j1 j1Var) {
        this(j1Var, null);
    }

    public k1(j1 j1Var, y0 y0Var) {
        this(j1Var, y0Var, true);
    }

    k1(j1 j1Var, y0 y0Var, boolean z4) {
        super(j1.g(j1Var), j1Var.l());
        this.f3483a = j1Var;
        this.f3484b = y0Var;
        this.f3485c = z4;
        fillInStackTrace();
    }

    public final j1 a() {
        return this.f3483a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f3485c ? super.fillInStackTrace() : this;
    }
}
