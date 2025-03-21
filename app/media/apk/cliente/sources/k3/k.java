package k3;

import io.grpc.internal.t0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import l3.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f5794b = Logger.getLogger(k.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final l3.h f5795c = l3.h.e();

    /* renamed from: d  reason: collision with root package name */
    private static k f5796d = d(k.class.getClassLoader());

    /* renamed from: a  reason: collision with root package name */
    protected final l3.h f5797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends k {

        /* renamed from: e  reason: collision with root package name */
        private static final l3.g<Socket> f5798e;

        /* renamed from: f  reason: collision with root package name */
        private static final l3.g<Socket> f5799f;

        /* renamed from: g  reason: collision with root package name */
        private static final l3.g<Socket> f5800g;

        /* renamed from: h  reason: collision with root package name */
        private static final l3.g<Socket> f5801h;

        /* renamed from: i  reason: collision with root package name */
        private static final l3.g<Socket> f5802i;

        /* renamed from: j  reason: collision with root package name */
        private static final l3.g<Socket> f5803j;

        /* renamed from: k  reason: collision with root package name */
        private static final Method f5804k;

        /* renamed from: l  reason: collision with root package name */
        private static final Method f5805l;

        /* renamed from: m  reason: collision with root package name */
        private static final Method f5806m;

        /* renamed from: n  reason: collision with root package name */
        private static final Method f5807n;

        /* renamed from: o  reason: collision with root package name */
        private static final Method f5808o;

        /* renamed from: p  reason: collision with root package name */
        private static final Method f5809p;

        /* renamed from: q  reason: collision with root package name */
        private static final Constructor<?> f5810q;

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Method method5;
            Method method6;
            Class<?> cls;
            Class<?> cls2 = Boolean.TYPE;
            Constructor<?> constructor = null;
            f5798e = new l3.g<>(null, "setUseSessionTickets", cls2);
            f5799f = new l3.g<>(null, "setHostname", String.class);
            f5800g = new l3.g<>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            f5801h = new l3.g<>(null, "setAlpnProtocols", byte[].class);
            f5802i = new l3.g<>(byte[].class, "getNpnSelectedProtocol", new Class[0]);
            f5803j = new l3.g<>(null, "setNpnProtocols", byte[].class);
            try {
                method2 = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                try {
                    method = SSLParameters.class.getMethod("getApplicationProtocols", new Class[0]);
                    try {
                        method3 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                        try {
                            cls = Class.forName("android.net.ssl.SSLSockets");
                            method4 = cls.getMethod("isSupportedSocket", SSLSocket.class);
                        } catch (ClassNotFoundException | NoSuchMethodException e5) {
                            e = e5;
                            method4 = null;
                        }
                    } catch (ClassNotFoundException e6) {
                        e = e6;
                        method3 = null;
                        method4 = method3;
                        k.f5794b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f5806m = method2;
                        f5807n = method;
                        f5808o = method3;
                        f5804k = method4;
                        f5805l = method5;
                        method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                        try {
                            constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        } catch (ClassNotFoundException e7) {
                            e = e7;
                            k.f5794b.log(Level.FINER, "Failed to find Android 7.0+ APIs", e);
                            f5809p = method6;
                            f5810q = constructor;
                        } catch (NoSuchMethodException e8) {
                            e = e8;
                            k.f5794b.log(Level.FINER, "Failed to find Android 7.0+ APIs", e);
                            f5809p = method6;
                            f5810q = constructor;
                        }
                        f5809p = method6;
                        f5810q = constructor;
                    } catch (NoSuchMethodException e9) {
                        e = e9;
                        method3 = null;
                        method4 = method3;
                        k.f5794b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f5806m = method2;
                        f5807n = method;
                        f5808o = method3;
                        f5804k = method4;
                        f5805l = method5;
                        method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        f5809p = method6;
                        f5810q = constructor;
                    }
                    try {
                        method5 = cls.getMethod("setUseSessionTickets", SSLSocket.class, cls2);
                    } catch (ClassNotFoundException e10) {
                        e = e10;
                        k.f5794b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f5806m = method2;
                        f5807n = method;
                        f5808o = method3;
                        f5804k = method4;
                        f5805l = method5;
                        method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        f5809p = method6;
                        f5810q = constructor;
                    } catch (NoSuchMethodException e11) {
                        e = e11;
                        k.f5794b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f5806m = method2;
                        f5807n = method;
                        f5808o = method3;
                        f5804k = method4;
                        f5805l = method5;
                        method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        f5809p = method6;
                        f5810q = constructor;
                    }
                } catch (ClassNotFoundException e12) {
                    e = e12;
                    method = null;
                    method3 = null;
                } catch (NoSuchMethodException e13) {
                    e = e13;
                    method = null;
                    method3 = null;
                }
            } catch (ClassNotFoundException e14) {
                e = e14;
                method = null;
                method2 = null;
                method3 = null;
            } catch (NoSuchMethodException e15) {
                e = e15;
                method = null;
                method2 = null;
                method3 = null;
            }
            f5806m = method2;
            f5807n = method;
            f5808o = method3;
            f5804k = method4;
            f5805l = method5;
            try {
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException | NoSuchMethodException e16) {
                e = e16;
                method6 = null;
            }
            f5809p = method6;
            f5810q = constructor;
        }

        a(l3.h hVar) {
            super(hVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
        @Override // k3.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void c(javax.net.ssl.SSLSocket r9, java.lang.String r10, java.util.List<l3.i> r11) {
            /*
                Method dump skipped, instructions count: 241
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: k3.k.a.c(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
        }

        @Override // k3.k
        public String f(SSLSocket sSLSocket) {
            Method method = f5808o;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, new Object[0]);
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(e5);
                } catch (InvocationTargetException e6) {
                    if (!(e6.getTargetException() instanceof UnsupportedOperationException)) {
                        throw new RuntimeException(e6);
                    }
                    k.f5794b.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                }
            }
            if (this.f5797a.i() == h.EnumC0088h.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f5800g.f(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, l3.l.f6032b);
                    }
                } catch (Exception e7) {
                    k.f5794b.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e7);
                }
            }
            if (this.f5797a.i() != h.EnumC0088h.NONE) {
                try {
                    byte[] bArr2 = (byte[]) f5802i.f(sSLSocket, new Object[0]);
                    if (bArr2 != null) {
                        return new String(bArr2, l3.l.f6032b);
                    }
                    return null;
                } catch (Exception e8) {
                    k.f5794b.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e8);
                    return null;
                }
            }
            return null;
        }

        @Override // k3.k
        public String h(SSLSocket sSLSocket, String str, List<l3.i> list) {
            String f5 = f(sSLSocket);
            return f5 == null ? super.h(sSLSocket, str, list) : f5;
        }
    }

    k(l3.h hVar) {
        this.f5797a = (l3.h) z0.k.o(hVar, "platform");
    }

    static k d(ClassLoader classLoader) {
        boolean z4;
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e5) {
            f5794b.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e5);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e6) {
                f5794b.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e6);
                z4 = false;
            }
        }
        z4 = true;
        return z4 ? new a(f5795c) : new k(f5795c);
    }

    public static k e() {
        return f5796d;
    }

    static boolean g(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            t0.c(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] i(List<l3.i> list) {
        ArrayList arrayList = new ArrayList();
        for (l3.i iVar : list) {
            arrayList.add(iVar.toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    protected void c(SSLSocket sSLSocket, String str, List<l3.i> list) {
        this.f5797a.c(sSLSocket, str, list);
    }

    public String f(SSLSocket sSLSocket) {
        return this.f5797a.h(sSLSocket);
    }

    public String h(SSLSocket sSLSocket, String str, List<l3.i> list) {
        if (list != null) {
            c(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String f5 = f(sSLSocket);
            if (f5 != null) {
                return f5;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } finally {
            this.f5797a.a(sSLSocket);
        }
    }
}
