package i3;

import i3.y0;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3499a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    public static final b1.a f3500b = y0.f3589f;

    /* loaded from: classes.dex */
    public interface a<T> extends y0.j<T> {
    }

    public static int a(y0 y0Var) {
        return y0Var.h();
    }

    public static <T> y0.g<T> b(String str, a<T> aVar) {
        boolean z4 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z4 = true;
        }
        return y0.g.g(str, z4, aVar);
    }

    public static y0 c(byte[]... bArr) {
        return new y0(bArr);
    }

    public static byte[][] d(y0 y0Var) {
        return y0Var.q();
    }
}
