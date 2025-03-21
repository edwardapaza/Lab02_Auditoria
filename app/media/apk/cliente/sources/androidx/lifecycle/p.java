package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f577a = new p();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, Integer> f578b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<?>, List<Constructor<? extends g>>> f579c = new HashMap();

    private p() {
    }

    private final g a(Constructor<? extends g> constructor, Object obj) {
        try {
            g newInstance = constructor.newInstance(obj);
            e4.k.d(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return newInstance;
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException(e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    private final Constructor<? extends g> b(Class<?> cls) {
        try {
            Package r02 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r02 != null ? r02.getName() : "";
            e4.k.d(name, "fullPackage");
            if (!(name.length() == 0)) {
                e4.k.d(canonicalName, "name");
                canonicalName = canonicalName.substring(name.length() + 1);
                e4.k.d(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            e4.k.d(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String c5 = c(canonicalName);
            if (!(name.length() == 0)) {
                c5 = name + '.' + c5;
            }
            Class<?> cls2 = Class.forName(c5);
            e4.k.c(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static final String c(String str) {
        String k5;
        e4.k.e(str, "className");
        StringBuilder sb = new StringBuilder();
        k5 = k4.o.k(str, ".", "_", false, 4, null);
        sb.append(k5);
        sb.append("_LifecycleAdapter");
        return sb.toString();
    }

    private final int d(Class<?> cls) {
        Map<Class<?>, Integer> map = f578b;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g5 = g(cls);
        map.put(cls, Integer.valueOf(g5));
        return g5;
    }

    private final boolean e(Class<?> cls) {
        return cls != null && l.class.isAssignableFrom(cls);
    }

    public static final k f(Object obj) {
        e4.k.e(obj, "object");
        boolean z4 = obj instanceof k;
        boolean z5 = obj instanceof d;
        if (z4 && z5) {
            return new e((d) obj, (k) obj);
        }
        if (z5) {
            return new e((d) obj, null);
        }
        if (z4) {
            return (k) obj;
        }
        Class<?> cls = obj.getClass();
        p pVar = f577a;
        if (pVar.d(cls) == 2) {
            List<Constructor<? extends g>> list = f579c.get(cls);
            e4.k.b(list);
            List<Constructor<? extends g>> list2 = list;
            if (list2.size() == 1) {
                return new g0(pVar.a(list2.get(0), obj));
            }
            int size = list2.size();
            g[] gVarArr = new g[size];
            for (int i5 = 0; i5 < size; i5++) {
                gVarArr[i5] = f577a.a(list2.get(i5), obj);
            }
            return new b(gVarArr);
        }
        return new y(obj);
    }

    private final int g(Class<?> cls) {
        List<Constructor<? extends g>> b5;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends g> b6 = b(cls);
        if (b6 != null) {
            Map<Class<?>, List<Constructor<? extends g>>> map = f579c;
            b5 = t3.o.b(b6);
            map.put(cls, b5);
            return 2;
        } else if (a.f511c.d(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (e(superclass)) {
                e4.k.d(superclass, "superclass");
                if (d(superclass) == 1) {
                    return 1;
                }
                List<Constructor<? extends g>> list = f579c.get(superclass);
                e4.k.b(list);
                arrayList = new ArrayList(list);
            }
            Class<?>[] interfaces = cls.getInterfaces();
            e4.k.d(interfaces, "klass.interfaces");
            for (Class<?> cls2 : interfaces) {
                if (e(cls2)) {
                    e4.k.d(cls2, "intrface");
                    if (d(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    List<Constructor<? extends g>> list2 = f579c.get(cls2);
                    e4.k.b(list2);
                    arrayList.addAll(list2);
                }
            }
            if (arrayList != null) {
                f579c.put(cls, arrayList);
                return 2;
            }
            return 1;
        }
    }
}
