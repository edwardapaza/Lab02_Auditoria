package z1;

import android.net.Uri;
import com.google.firebase.firestore.e1;
import com.google.firebase.firestore.s0;
import com.google.firebase.firestore.z0;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<Class<?>, a<?>> f8945a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f8946a;

        /* renamed from: b  reason: collision with root package name */
        private final Constructor<T> f8947b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f8948c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f8949d;

        /* renamed from: e  reason: collision with root package name */
        private final Map<String, String> f8950e = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        private final Map<String, Method> f8952g = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        private final Map<String, Method> f8951f = new HashMap();

        /* renamed from: h  reason: collision with root package name */
        private final Map<String, Field> f8953h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        private final HashSet<String> f8954i = new HashSet<>();

        /* renamed from: j  reason: collision with root package name */
        private final HashSet<String> f8955j = new HashSet<>();

        a(Class<T> cls) {
            Constructor<T> constructor;
            Method[] methods;
            Field[] fields;
            Method[] declaredMethods;
            Field[] declaredFields;
            this.f8946a = cls;
            this.f8948c = cls.isAnnotationPresent(e1.class);
            this.f8949d = !cls.isAnnotationPresent(com.google.firebase.firestore.e0.class);
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                constructor = null;
            }
            this.f8947b = constructor;
            for (Method method : cls.getMethods()) {
                if (n(method)) {
                    String j5 = j(method);
                    b(j5);
                    method.setAccessible(true);
                    if (this.f8951f.containsKey(j5)) {
                        throw new RuntimeException("Found conflicting getters for name " + method.getName() + " on class " + cls.getName());
                    }
                    this.f8951f.put(j5, method);
                    e(method);
                }
            }
            for (Field field : cls.getFields()) {
                if (m(field)) {
                    b(i(field));
                    d(field);
                }
            }
            HashMap hashMap = new HashMap();
            Class<? super T> cls2 = cls;
            do {
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (o(method2)) {
                        String j6 = j(method2);
                        String str = this.f8950e.get(j6.toLowerCase(Locale.US));
                        if (str == null) {
                            continue;
                        } else if (!str.equals(j6)) {
                            throw new RuntimeException("Found setter on " + cls2.getName() + " with invalid case-sensitive name: " + method2.getName());
                        } else if (method2.isBridge()) {
                            hashMap.put(j6, method2);
                        } else {
                            Method method3 = this.f8952g.get(j6);
                            Method method4 = (Method) hashMap.get(j6);
                            if (method3 == null) {
                                method2.setAccessible(true);
                                this.f8952g.put(j6, method2);
                                f(method2);
                            } else if (!h(method2, method3) && (method4 == null || !h(method2, method4))) {
                                if (cls2 == cls) {
                                    throw new RuntimeException("Class " + cls.getName() + " has multiple setter overloads with name " + method2.getName());
                                }
                                throw new RuntimeException("Found conflicting setters with name: " + method2.getName() + " (conflicts with " + method3.getName() + " defined on " + method3.getDeclaringClass().getName() + ")");
                            }
                        }
                    }
                }
                for (Field field2 : cls2.getDeclaredFields()) {
                    String i5 = i(field2);
                    if (this.f8950e.containsKey(i5.toLowerCase(Locale.US)) && !this.f8953h.containsKey(i5)) {
                        field2.setAccessible(true);
                        this.f8953h.put(i5, field2);
                        d(field2);
                    }
                }
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    break;
                }
            } while (!cls2.equals(Object.class));
            if (this.f8950e.isEmpty()) {
                throw new RuntimeException("No properties to serialize found on class " + cls.getName());
            }
            Iterator<String> it = this.f8955j.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.f8952g.containsKey(next) && !this.f8953h.containsKey(next)) {
                    throw new RuntimeException("@DocumentId is annotated on property " + next + " of class " + cls.getName() + " but no field or public setter was found");
                }
            }
        }

        private void b(String str) {
            Map<String, String> map = this.f8950e;
            Locale locale = Locale.US;
            String put = map.put(str.toLowerCase(locale), str);
            if (put == null || str.equals(put)) {
                return;
            }
            throw new RuntimeException("Found two getters or fields with conflicting case sensitivity for property: " + str.toLowerCase(locale));
        }

        private static String c(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(s0.class)) {
                return ((s0) accessibleObject.getAnnotation(s0.class)).value();
            }
            return null;
        }

        private void d(Field field) {
            if (field.isAnnotationPresent(z0.class)) {
                Class<?> type = field.getType();
                if (type != Date.class && type != f1.q.class) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is annotated with @ServerTimestamp but is " + type + " instead of Date or Timestamp.");
                }
                this.f8954i.add(i(field));
            }
            if (field.isAnnotationPresent(com.google.firebase.firestore.i.class)) {
                g("Field", "is", field.getType());
                this.f8955j.add(i(field));
            }
        }

        private void e(Method method) {
            if (method.isAnnotationPresent(z0.class)) {
                Class<?> returnType = method.getReturnType();
                if (returnType != Date.class && returnType != f1.q.class) {
                    throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but returns " + returnType + " instead of Date or Timestamp.");
                }
                this.f8954i.add(j(method));
            }
            if (method.isAnnotationPresent(com.google.firebase.firestore.i.class)) {
                g("Method", "returns", method.getReturnType());
                this.f8955j.add(j(method));
            }
        }

        private void f(Method method) {
            if (method.isAnnotationPresent(z0.class)) {
                throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but should not be. @ServerTimestamp can only be applied to fields and getters, not setters.");
            } else if (method.isAnnotationPresent(com.google.firebase.firestore.i.class)) {
                g("Method", "accepts", method.getParameterTypes()[0]);
                this.f8955j.add(j(method));
            }
        }

        private void g(String str, String str2, Type type) {
            if (type == String.class || type == com.google.firebase.firestore.m.class) {
                return;
            }
            throw new IllegalArgumentException(str + " is annotated with @DocumentId but " + str2 + " " + type + " instead of String or DocumentReference.");
        }

        private static boolean h(Method method, Method method2) {
            o.d(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            o.d(method.getReturnType().equals(Void.TYPE), "Expected void return type");
            o.d(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            o.d(parameterTypes.length == 1, "Expected exactly one parameter");
            o.d(parameterTypes2.length == 1, "Expected exactly one parameter");
            return method.getName().equals(method2.getName()) && parameterTypes[0].equals(parameterTypes2[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String i(Field field) {
            String c5 = c(field);
            return c5 != null ? c5 : field.getName();
        }

        private static String j(Method method) {
            String c5 = c(method);
            return c5 != null ? c5 : l(method.getName());
        }

        private static String l(String str) {
            String[] strArr = {"get", "set", "is"};
            String str2 = null;
            for (int i5 = 0; i5 < 3; i5++) {
                String str3 = strArr[i5];
                if (str.startsWith(str3)) {
                    str2 = str3;
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("Unknown Bean prefix for method: " + str);
            }
            char[] charArray = str.substring(str2.length()).toCharArray();
            for (int i6 = 0; i6 < charArray.length && Character.isUpperCase(charArray[i6]); i6++) {
                charArray[i6] = Character.toLowerCase(charArray[i6]);
            }
            return new String(charArray);
        }

        private static boolean m(Field field) {
            return (field.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(field.getModifiers()) || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || field.isAnnotationPresent(com.google.firebase.firestore.p.class)) ? false : true;
        }

        private static boolean n(Method method) {
            return ((!method.getName().startsWith("get") && !method.getName().startsWith("is")) || method.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.isBridge() || method.isAnnotationPresent(com.google.firebase.firestore.p.class)) ? false : true;
        }

        private static boolean o(Method method) {
            return method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(com.google.firebase.firestore.p.class);
        }

        Map<String, Object> k(T t5, b bVar) {
            Object obj;
            if (!this.f8946a.isAssignableFrom(t5.getClass())) {
                throw new IllegalArgumentException("Can't serialize object of class " + t5.getClass() + " with BeanMapper for class " + this.f8946a);
            }
            HashMap hashMap = new HashMap();
            for (String str : this.f8950e.values()) {
                if (!this.f8955j.contains(str)) {
                    if (this.f8951f.containsKey(str)) {
                        obj = z1.a.a(this.f8951f.get(str), t5, new Object[0]);
                    } else {
                        Field field = this.f8953h.get(str);
                        if (field == null) {
                            throw new IllegalStateException("Bean property without field or getter: " + str);
                        }
                        try {
                            obj = field.get(t5);
                        } catch (IllegalAccessException e5) {
                            throw new RuntimeException(e5);
                        }
                    }
                    hashMap.put(str, (this.f8954i.contains(str) && obj == null) ? com.google.firebase.firestore.r.g() : o.g(obj, bVar.a(str)));
                }
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: d  reason: collision with root package name */
        static final b f8956d = new b(null, null, 0);

        /* renamed from: a  reason: collision with root package name */
        private final int f8957a;

        /* renamed from: b  reason: collision with root package name */
        private final b f8958b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8959c;

        b(b bVar, String str, int i5) {
            this.f8958b = bVar;
            this.f8959c = str;
            this.f8957a = i5;
        }

        b a(String str) {
            return new b(this, str, this.f8957a + 1);
        }

        int b() {
            return this.f8957a;
        }

        public String toString() {
            int i5 = this.f8957a;
            if (i5 == 0) {
                return "";
            }
            if (i5 == 1) {
                return this.f8959c;
            }
            return this.f8958b.toString() + "." + this.f8959c;
        }
    }

    public static Object c(Object obj) {
        return f(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(boolean z4, String str) {
        if (z4) {
            return;
        }
        throw new RuntimeException("Hard assert failed: " + str);
    }

    private static <T> a<T> e(Class<T> cls) {
        ConcurrentMap<Class<?>, a<?>> concurrentMap = f8945a;
        a<?> aVar = concurrentMap.get(cls);
        if (aVar == null) {
            a<T> aVar2 = new a<>(cls);
            concurrentMap.put(cls, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private static <T> Object f(T t5) {
        return g(t5, b.f8956d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> Object g(T t5, b bVar) {
        if (bVar.b() <= 500) {
            if (t5 == null) {
                return null;
            }
            if (t5 instanceof Number) {
                if ((t5 instanceof Long) || (t5 instanceof Integer) || (t5 instanceof Double) || (t5 instanceof Float)) {
                    return t5;
                }
                throw h(bVar, String.format("Numbers of type %s are not supported, please use an int, long, float or double", t5.getClass().getSimpleName()));
            } else if ((t5 instanceof String) || (t5 instanceof Boolean)) {
                return t5;
            } else {
                if (t5 instanceof Character) {
                    throw h(bVar, "Characters are not supported, please use Strings");
                }
                if (t5 instanceof Map) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry : ((Map) t5).entrySet()) {
                        Object key = entry.getKey();
                        if (!(key instanceof String)) {
                            throw h(bVar, "Maps with non-string keys are not supported");
                        }
                        String str = (String) key;
                        hashMap.put(str, g(entry.getValue(), bVar.a(str)));
                    }
                    return hashMap;
                } else if (!(t5 instanceof Collection)) {
                    if (t5.getClass().isArray()) {
                        throw h(bVar, "Serializing Arrays is not supported, please use Lists instead");
                    }
                    if (!(t5 instanceof Enum)) {
                        return ((t5 instanceof Date) || (t5 instanceof f1.q) || (t5 instanceof com.google.firebase.firestore.d0) || (t5 instanceof com.google.firebase.firestore.f) || (t5 instanceof com.google.firebase.firestore.m) || (t5 instanceof com.google.firebase.firestore.r)) ? t5 : ((t5 instanceof Uri) || (t5 instanceof URI) || (t5 instanceof URL)) ? t5.toString() : e(t5.getClass()).k(t5, bVar);
                    }
                    String name = ((Enum) t5).name();
                    try {
                        return a.i(t5.getClass().getField(name));
                    } catch (NoSuchFieldException unused) {
                        return name;
                    }
                } else if (t5 instanceof List) {
                    List list = (List) t5;
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int i5 = 0; i5 < list.size(); i5++) {
                        Object obj = list.get(i5);
                        arrayList.add(g(obj, bVar.a("[" + i5 + "]")));
                    }
                    return arrayList;
                } else {
                    throw h(bVar, "Serializing Collections is not supported, please use Lists instead");
                }
            }
        }
        throw h(bVar, "Exceeded maximum depth of 500, which likely indicates there's an object cycle");
    }

    private static IllegalArgumentException h(b bVar, String str) {
        String str2 = "Could not serialize object. " + str;
        if (bVar.b() > 0) {
            str2 = str2 + " (found in field '" + bVar.toString() + "')";
        }
        return new IllegalArgumentException(str2);
    }
}
