package r4;
/* loaded from: classes.dex */
public final class i extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final transient v3.g f7194a;

    public i(v3.g gVar) {
        this.f7194a = gVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f7194a.toString();
    }
}
