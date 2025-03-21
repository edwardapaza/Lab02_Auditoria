package o;

import o.s;
/* loaded from: classes.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    private static final androidx.collection.f<ClassLoader, androidx.collection.f<String, Class<?>>> f6410a = new androidx.collection.f<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return s.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class<?> c(ClassLoader classLoader, String str) {
        androidx.collection.f<ClassLoader, androidx.collection.f<String, Class<?>>> fVar = f6410a;
        androidx.collection.f<String, Class<?>> fVar2 = fVar.get(classLoader);
        if (fVar2 == null) {
            fVar2 = new androidx.collection.f<>();
            fVar.put(classLoader, fVar2);
        }
        Class<?> cls = fVar2.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            fVar2.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    public static Class<? extends s> d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e5) {
            throw new s.h("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e5);
        } catch (ClassNotFoundException e6) {
            throw new s.h("Unable to instantiate fragment " + str + ": make sure class name exists", e6);
        }
    }

    public s a(ClassLoader classLoader, String str) {
        throw null;
    }
}
