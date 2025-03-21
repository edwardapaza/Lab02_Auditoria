package i3;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
/* loaded from: classes.dex */
public final class c0 extends f1 {

    /* renamed from: a  reason: collision with root package name */
    private final SocketAddress f3366a;

    /* renamed from: b  reason: collision with root package name */
    private final InetSocketAddress f3367b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3368c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3369d;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private SocketAddress f3370a;

        /* renamed from: b  reason: collision with root package name */
        private InetSocketAddress f3371b;

        /* renamed from: c  reason: collision with root package name */
        private String f3372c;

        /* renamed from: d  reason: collision with root package name */
        private String f3373d;

        private b() {
        }

        public c0 a() {
            return new c0(this.f3370a, this.f3371b, this.f3372c, this.f3373d);
        }

        public b b(String str) {
            this.f3373d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f3370a = (SocketAddress) z0.k.o(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f3371b = (InetSocketAddress) z0.k.o(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(String str) {
            this.f3372c = str;
            return this;
        }
    }

    private c0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        z0.k.o(socketAddress, "proxyAddress");
        z0.k.o(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            z0.k.w(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.f3366a = socketAddress;
        this.f3367b = inetSocketAddress;
        this.f3368c = str;
        this.f3369d = str2;
    }

    public static b e() {
        return new b();
    }

    public String a() {
        return this.f3369d;
    }

    public SocketAddress b() {
        return this.f3366a;
    }

    public InetSocketAddress c() {
        return this.f3367b;
    }

    public String d() {
        return this.f3368c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            return z0.g.a(this.f3366a, c0Var.f3366a) && z0.g.a(this.f3367b, c0Var.f3367b) && z0.g.a(this.f3368c, c0Var.f3368c) && z0.g.a(this.f3369d, c0Var.f3369d);
        }
        return false;
    }

    public int hashCode() {
        return z0.g.b(this.f3366a, this.f3367b, this.f3368c, this.f3369d);
    }

    public String toString() {
        return z0.f.b(this).d("proxyAddr", this.f3366a).d("targetAddr", this.f3367b).d("username", this.f3368c).e("hasPassword", this.f3369d != null).toString();
    }
}
