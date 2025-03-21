package l3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
/* loaded from: classes.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f5990b = Logger.getLogger(h.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f5991c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* renamed from: d  reason: collision with root package name */
    private static final h f5992d = d();

    /* renamed from: a  reason: collision with root package name */
    private final Provider f5993a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements PrivilegedExceptionAction<Method> {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a */
        public Method run() {
            return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements PrivilegedExceptionAction<Method> {
        b() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a */
        public Method run() {
            return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements PrivilegedExceptionAction<Method> {
        c() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a */
        public Method run() {
            return SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends h {

        /* renamed from: e  reason: collision with root package name */
        private final l3.g<Socket> f5994e;

        /* renamed from: f  reason: collision with root package name */
        private final l3.g<Socket> f5995f;

        /* renamed from: g  reason: collision with root package name */
        private final Method f5996g;

        /* renamed from: h  reason: collision with root package name */
        private final Method f5997h;

        /* renamed from: i  reason: collision with root package name */
        private final l3.g<Socket> f5998i;

        /* renamed from: j  reason: collision with root package name */
        private final l3.g<Socket> f5999j;

        /* renamed from: k  reason: collision with root package name */
        private final EnumC0088h f6000k;

        public d(l3.g<Socket> gVar, l3.g<Socket> gVar2, Method method, Method method2, l3.g<Socket> gVar3, l3.g<Socket> gVar4, Provider provider, EnumC0088h enumC0088h) {
            super(provider);
            this.f5994e = gVar;
            this.f5995f = gVar2;
            this.f5996g = method;
            this.f5997h = method2;
            this.f5998i = gVar3;
            this.f5999j = gVar4;
            this.f6000k = enumC0088h;
        }

        @Override // l3.h
        public void c(SSLSocket sSLSocket, String str, List<i> list) {
            if (str != null) {
                this.f5994e.e(sSLSocket, Boolean.TRUE);
                this.f5995f.e(sSLSocket, str);
            }
            if (this.f5999j.g(sSLSocket)) {
                this.f5999j.f(sSLSocket, h.b(list));
            }
        }

        @Override // l3.h
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            if (this.f5998i.g(sSLSocket) && (bArr = (byte[]) this.f5998i.f(sSLSocket, new Object[0])) != null) {
                return new String(bArr, l.f6032b);
            }
            return null;
        }

        @Override // l3.h
        public EnumC0088h i() {
            return this.f6000k;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends h {

        /* renamed from: e  reason: collision with root package name */
        private final Method f6001e;

        /* renamed from: f  reason: collision with root package name */
        private final Method f6002f;

        private e(Provider provider, Method method, Method method2) {
            super(provider);
            this.f6001e = method;
            this.f6002f = method2;
        }

        /* synthetic */ e(Provider provider, Method method, Method method2, a aVar) {
            this(provider, method, method2);
        }

        @Override // l3.h
        public void c(SSLSocket sSLSocket, String str, List<i> list) {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list.size());
            for (i iVar : list) {
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f6001e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException(e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6);
            }
        }

        @Override // l3.h
        public String h(SSLSocket sSLSocket) {
            try {
                return (String) this.f6002f.invoke(sSLSocket, new Object[0]);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException(e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6);
            }
        }

        @Override // l3.h
        public EnumC0088h i() {
            return EnumC0088h.ALPN_AND_NPN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f extends h {

        /* renamed from: e  reason: collision with root package name */
        private final Method f6003e;

        /* renamed from: f  reason: collision with root package name */
        private final Method f6004f;

        /* renamed from: g  reason: collision with root package name */
        private final Method f6005g;

        /* renamed from: h  reason: collision with root package name */
        private final Class<?> f6006h;

        /* renamed from: i  reason: collision with root package name */
        private final Class<?> f6007i;

        public f(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2, Provider provider) {
            super(provider);
            this.f6003e = method;
            this.f6004f = method2;
            this.f6005g = method3;
            this.f6006h = cls;
            this.f6007i = cls2;
        }

        @Override // l3.h
        public void a(SSLSocket sSLSocket) {
            try {
                this.f6005g.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e5) {
                h.f5990b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e5);
            }
        }

        @Override // l3.h
        public void c(SSLSocket sSLSocket, String str, List<i> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                i iVar = list.get(i5);
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f6003e.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f6006h, this.f6007i}, new g(arrayList)));
            } catch (IllegalAccessException e5) {
                throw new AssertionError(e5);
            } catch (InvocationTargetException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // l3.h
        public String h(SSLSocket sSLSocket) {
            try {
                g gVar = (g) Proxy.getInvocationHandler(this.f6004f.invoke(null, sSLSocket));
                if (!gVar.f6009b && gVar.f6010c == null) {
                    h.f5990b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                } else if (gVar.f6009b) {
                    return null;
                } else {
                    return gVar.f6010c;
                }
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }

        @Override // l3.h
        public EnumC0088h i() {
            return EnumC0088h.ALPN_AND_NPN;
        }
    }

    /* loaded from: classes.dex */
    private static class g implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f6008a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f6009b;

        /* renamed from: c  reason: collision with root package name */
        private String f6010c;

        public g(List<String> list) {
            this.f6008a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l.f6031a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f6009b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f6008a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                    Object obj3 = objArr[0];
                    if (obj3 instanceof List) {
                        List list = (List) obj3;
                        int size = list.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size) {
                                obj2 = this.f6008a.get(0);
                                break;
                            } else if (this.f6008a.contains(list.get(i5))) {
                                obj2 = list.get(i5);
                                break;
                            } else {
                                i5++;
                            }
                        }
                        String str = (String) obj2;
                        this.f6010c = str;
                        return str;
                    }
                }
                if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f6010c = (String) objArr[0];
                    return null;
                }
                return method.invoke(this, objArr);
            }
        }
    }

    /* renamed from: l3.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0088h {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    public h(Provider provider) {
        this.f5993a = provider;
    }

    public static byte[] b(List<i> list) {
        w4.c cVar = new w4.c();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            i iVar = list.get(i5);
            if (iVar != i.HTTP_1_0) {
                cVar.writeByte(iVar.toString().length());
                cVar.b0(iVar.toString());
            }
        }
        return cVar.v();
    }

    private static h d() {
        Method method;
        Method method2;
        Provider f5 = f();
        if (f5 != null) {
            l3.g gVar = new l3.g(null, "setUseSessionTickets", Boolean.TYPE);
            l3.g gVar2 = new l3.g(null, "setHostname", String.class);
            l3.g gVar3 = new l3.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            l3.g gVar4 = new l3.g(null, "setAlpnProtocols", byte[].class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                method = cls.getMethod("tagSocket", Socket.class);
                try {
                    method2 = cls.getMethod("untagSocket", Socket.class);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    method2 = null;
                    return new d(gVar, gVar2, method, method2, gVar3, gVar4, f5, (!f5.getName().equals("GmsCore_OpenSSL") || f5.getName().equals("Conscrypt") || f5.getName().equals("Ssl_Guard") || k()) ? EnumC0088h.ALPN_AND_NPN : j() ? EnumC0088h.NPN : EnumC0088h.NONE);
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                method = null;
            }
            return new d(gVar, gVar2, method, method2, gVar3, gVar4, f5, (!f5.getName().equals("GmsCore_OpenSSL") || f5.getName().equals("Conscrypt") || f5.getName().equals("Ssl_Guard") || k()) ? EnumC0088h.ALPN_AND_NPN : j() ? EnumC0088h.NPN : EnumC0088h.NONE);
        }
        try {
            Provider provider = SSLContext.getDefault().getProvider();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS", provider);
                sSLContext.init(null, null, null);
                ((Method) AccessController.doPrivileged(new a())).invoke(sSLContext.createSSLEngine(), new Object[0]);
                return new e(provider, (Method) AccessController.doPrivileged(new b()), (Method) AccessController.doPrivileged(new c()), null);
            } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused3) {
                try {
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new f(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider);
                } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    return new h(provider);
                }
            }
        } catch (NoSuchAlgorithmException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static h e() {
        return f5992d;
    }

    private static Provider f() {
        Provider[] providers;
        String[] strArr;
        for (Provider provider : Security.getProviders()) {
            for (String str : f5991c) {
                if (str.equals(provider.getClass().getName())) {
                    f5990b.log(Level.FINE, "Found registered provider {0}", str);
                    return provider;
                }
            }
        }
        f5990b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    private static boolean j() {
        try {
            h.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e5) {
            f5990b.log(Level.FINE, "Can't find class", (Throwable) e5);
            return false;
        }
    }

    private static boolean k() {
        try {
            h.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e5) {
            f5990b.log(Level.FINE, "Can't find class", (Throwable) e5);
            return false;
        }
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List<i> list) {
    }

    public Provider g() {
        return this.f5993a;
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public EnumC0088h i() {
        return EnumC0088h.NONE;
    }
}
