package t4;
/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: m  reason: collision with root package name */
    public static final c f7678m = new c();

    private c() {
        super(l.f7691c, l.f7692d, l.f7693e, l.f7689a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // m4.g0
    public String toString() {
        return "Dispatchers.Default";
    }
}
