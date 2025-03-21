package io.grpc.internal;

import i3.c0;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
class w1 implements i3.g1 {

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f5299d = Logger.getLogger(w1.class.getName());

    /* renamed from: e  reason: collision with root package name */
    private static final c f5300e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final z0.o<ProxySelector> f5301f = new b();

    /* renamed from: a  reason: collision with root package name */
    private final z0.o<ProxySelector> f5302a;

    /* renamed from: b  reason: collision with root package name */
    private final c f5303b;

    /* renamed from: c  reason: collision with root package name */
    private final InetSocketAddress f5304c;

    /* loaded from: classes.dex */
    class a implements c {
        a() {
        }

        @Override // io.grpc.internal.w1.c
        public PasswordAuthentication a(String str, InetAddress inetAddress, int i5, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i5, "");
            } catch (MalformedURLException unused) {
                w1.f5299d.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{str2, str});
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i5, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    }

    /* loaded from: classes.dex */
    class b implements z0.o<ProxySelector> {
        b() {
        }

        @Override // z0.o
        /* renamed from: a */
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i5, String str2, String str3, String str4);
    }

    public w1() {
        this(f5301f, f5300e, System.getenv("GRPC_PROXY_EXP"));
    }

    w1(z0.o<ProxySelector> oVar, c cVar, String str) {
        this.f5302a = (z0.o) z0.k.n(oVar);
        this.f5303b = (c) z0.k.n(cVar);
        this.f5304c = str != null ? d(str) : null;
    }

    private i3.f1 c(InetSocketAddress inetSocketAddress) {
        try {
            try {
                URI uri = new URI("https", null, t0.h(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = this.f5302a.get();
                if (proxySelector == null) {
                    f5299d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> select = proxySelector.select(uri);
                if (select.size() > 1) {
                    f5299d.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = select.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication a5 = this.f5303b.a(t0.h(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                c0.b c5 = i3.c0.e().d(inetSocketAddress).c(inetSocketAddress2);
                if (a5 == null) {
                    return c5.a();
                }
                return c5.e(a5.getUserName()).b(a5.getPassword() != null ? new String(a5.getPassword()) : null).a();
            } catch (URISyntaxException e5) {
                f5299d.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e5);
                return null;
            }
        } catch (Throwable th) {
            f5299d.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    private static InetSocketAddress d(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":", 2);
        int parseInt = split.length > 1 ? Integer.parseInt(split[1]) : 80;
        f5299d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(split[0], parseInt);
    }

    @Override // i3.g1
    public i3.f1 a(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            return this.f5304c != null ? i3.c0.e().c(this.f5304c).d((InetSocketAddress) socketAddress).a() : c((InetSocketAddress) socketAddress);
        }
        return null;
    }
}
