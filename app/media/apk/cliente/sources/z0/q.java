package z0;
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private static final q f8892a = new a();

    /* loaded from: classes.dex */
    class a extends q {
        a() {
        }

        @Override // z0.q
        public long a() {
            return System.nanoTime();
        }
    }

    protected q() {
    }

    public static q b() {
        return f8892a;
    }

    public abstract long a();
}
