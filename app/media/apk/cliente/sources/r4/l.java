package r4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f7203a = new l();

    private l() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        List<S> H;
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            H = t3.x.H(ServiceLoader.load(cls, classLoader));
            return H;
        }
    }

    private final List<String> e(URL url) {
        boolean m5;
        String Z;
        String e02;
        String Z2;
        String url2 = url.toString();
        m5 = k4.o.m(url2, "jar", false, 2, null);
        if (!m5) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> f5 = f7203a.f(bufferedReader);
                b4.b.a(bufferedReader, null);
                return f5;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    b4.b.a(bufferedReader, th);
                    throw th2;
                }
            }
        }
        Z = k4.p.Z(url2, "jar:file:", null, 2, null);
        e02 = k4.p.e0(Z, '!', null, 2, null);
        Z2 = k4.p.Z(url2, "!/", null, 2, null);
        JarFile jarFile = new JarFile(e02, false);
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(Z2)), "UTF-8"));
            List<String> f6 = f7203a.f(bufferedReader2);
            b4.b.a(bufferedReader2, null);
            jarFile.close();
            return f6;
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                try {
                    jarFile.close();
                    throw th4;
                } catch (Throwable th5) {
                    s3.b.a(th3, th5);
                    throw th3;
                }
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) {
        List<String> H;
        String f02;
        CharSequence g02;
        boolean z4;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                H = t3.x.H(linkedHashSet);
                return H;
            }
            f02 = k4.p.f0(readLine, "#", null, 2, null);
            g02 = k4.p.g0(f02);
            String obj = g02.toString();
            int i5 = 0;
            while (true) {
                if (i5 >= obj.length()) {
                    z4 = true;
                    break;
                }
                char charAt = obj.charAt(i5);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z4 = false;
                    break;
                }
                i5++;
            }
            if (!z4) {
                throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    public final List<v> c() {
        v vVar;
        if (m.a()) {
            try {
                ArrayList arrayList = new ArrayList(2);
                v vVar2 = null;
                try {
                    vVar = (v) v.class.cast(Class.forName("n4.a", true, v.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException unused) {
                    vVar = null;
                }
                if (vVar != null) {
                    arrayList.add(vVar);
                }
                try {
                    vVar2 = (v) v.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, v.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException unused2) {
                }
                if (vVar2 != null) {
                    arrayList.add(vVar2);
                    return arrayList;
                }
                return arrayList;
            } catch (Throwable unused3) {
                return b(v.class, v.class.getClassLoader());
            }
        }
        return b(v.class, v.class.getClassLoader());
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        Set<String> L;
        int k5;
        ArrayList<URL> list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        e4.k.d(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            t3.u.l(arrayList, f7203a.e(url));
        }
        L = t3.x.L(arrayList);
        if (!L.isEmpty()) {
            k5 = t3.q.k(L, 10);
            ArrayList arrayList2 = new ArrayList(k5);
            for (String str : L) {
                arrayList2.add(f7203a.a(str, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
