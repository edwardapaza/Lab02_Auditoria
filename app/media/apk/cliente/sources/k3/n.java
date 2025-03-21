package k3;

import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes.dex */
final class n {

    /* renamed from: a  reason: collision with root package name */
    static final List<l3.i> f5812a = Collections.unmodifiableList(Arrays.asList(l3.i.HTTP_2));

    static String a(String str) {
        return (str.startsWith("[") && str.endsWith("]")) ? str.substring(1, str.length() - 1) : str;
    }

    public static SSLSocket b(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i5, l3.b bVar) {
        z0.k.o(sSLSocketFactory, "sslSocketFactory");
        z0.k.o(socket, "socket");
        z0.k.o(bVar, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i5, true);
        bVar.c(sSLSocket, false);
        String h5 = k.e().h(sSLSocket, str, bVar.f() ? f5812a : null);
        List<l3.i> list = f5812a;
        boolean contains = list.contains(l3.i.a(h5));
        z0.k.w(contains, "Only " + list + " are supported, but negotiated protocol is %s", h5);
        if (hostnameVerifier == null) {
            hostnameVerifier = l3.f.f5985a;
        }
        if (hostnameVerifier.verify(a(str), sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
