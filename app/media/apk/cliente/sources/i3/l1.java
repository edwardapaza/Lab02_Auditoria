package i3;
/* loaded from: classes.dex */
public class l1 extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final j1 f3487a;

    /* renamed from: b  reason: collision with root package name */
    private final y0 f3488b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3489c;

    public l1(j1 j1Var) {
        this(j1Var, null);
    }

    public l1(j1 j1Var, y0 y0Var) {
        this(j1Var, y0Var, true);
    }

    l1(j1 j1Var, y0 y0Var, boolean z4) {
        super(j1.g(j1Var), j1Var.l());
        this.f3487a = j1Var;
        this.f3488b = y0Var;
        this.f3489c = z4;
        fillInStackTrace();
    }

    public final j1 a() {
        return this.f3487a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f3489c ? super.fillInStackTrace() : this;
    }
}
