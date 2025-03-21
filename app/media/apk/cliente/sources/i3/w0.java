package i3;
/* loaded from: classes.dex */
public abstract class w0 {

    /* loaded from: classes.dex */
    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static w0 d() {
        w0 d5 = x0.b().d();
        if (d5 != null) {
            return d5;
        }
        throw new a("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract v0<?> a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean b();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int c();
}
