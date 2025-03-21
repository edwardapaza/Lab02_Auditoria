package i3;

import java.security.cert.Certificate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f3381f = Logger.getLogger(d0.class.getName());

    /* renamed from: g  reason: collision with root package name */
    private static final d0 f3382g = new d0();

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentNavigableMap<Long, i0<Object>> f3383a = new ConcurrentSkipListMap();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentNavigableMap<Long, i0<Object>> f3384b = new ConcurrentSkipListMap();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Long, i0<Object>> f3385c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentMap<Long, i0<Object>> f3386d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final ConcurrentMap<Long, Object> f3387e = new ConcurrentHashMap();

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f3388a;

        public b(c cVar) {
            this.f3388a = (c) z0.k.n(cVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f3389a;

        /* renamed from: b  reason: collision with root package name */
        public final Certificate f3390b;

        /* renamed from: c  reason: collision with root package name */
        public final Certificate f3391c;

        public c(SSLSession sSLSession) {
            String cipherSuite = sSLSession.getCipherSuite();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            Certificate certificate = null;
            Certificate certificate2 = localCertificates != null ? localCertificates[0] : null;
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates != null) {
                    certificate = peerCertificates[0];
                }
            } catch (SSLPeerUnverifiedException e5) {
                d0.f3381f.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e5);
            }
            this.f3389a = cipherSuite;
            this.f3390b = certificate2;
            this.f3391c = certificate;
        }
    }

    private static <T extends i0<?>> void b(Map<Long, T> map, T t5) {
        map.put(Long.valueOf(t5.e().d()), t5);
    }

    public static long f(p0 p0Var) {
        return p0Var.e().d();
    }

    public static d0 g() {
        return f3382g;
    }

    private static <T extends i0<?>> void h(Map<Long, T> map, T t5) {
        map.remove(Long.valueOf(f(t5)));
    }

    public void c(i0<Object> i0Var) {
        b(this.f3386d, i0Var);
    }

    public void d(i0<Object> i0Var) {
        b(this.f3384b, i0Var);
    }

    public void e(i0<Object> i0Var) {
        b(this.f3385c, i0Var);
    }

    public void i(i0<Object> i0Var) {
        h(this.f3386d, i0Var);
    }

    public void j(i0<Object> i0Var) {
        h(this.f3384b, i0Var);
    }

    public void k(i0<Object> i0Var) {
        h(this.f3385c, i0Var);
    }
}
