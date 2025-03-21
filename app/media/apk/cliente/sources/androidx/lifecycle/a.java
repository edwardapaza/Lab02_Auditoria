package androidx.lifecycle;

import androidx.lifecycle.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Deprecated
/* loaded from: classes.dex */
final class a {

    /* renamed from: c  reason: collision with root package name */
    static a f511c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, C0017a> f512a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f513b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0017a {

        /* renamed from: a  reason: collision with root package name */
        final Map<i.a, List<b>> f514a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, i.a> f515b;

        C0017a(Map<b, i.a> map) {
            this.f515b = map;
            for (Map.Entry<b, i.a> entry : map.entrySet()) {
                i.a value = entry.getValue();
                List<b> list = this.f514a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f514a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<b> list, m mVar, i.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(mVar, aVar, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(m mVar, i.a aVar, Object obj) {
            b(this.f514a.get(aVar), mVar, aVar, obj);
            b(this.f514a.get(i.a.ON_ANY), mVar, aVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f516a;

        /* renamed from: b  reason: collision with root package name */
        final Method f517b;

        b(int i5, Method method) {
            this.f516a = i5;
            this.f517b = method;
            method.setAccessible(true);
        }

        void a(m mVar, i.a aVar, Object obj) {
            try {
                int i5 = this.f516a;
                if (i5 == 0) {
                    this.f517b.invoke(obj, new Object[0]);
                } else if (i5 == 1) {
                    this.f517b.invoke(obj, mVar);
                } else if (i5 != 2) {
                } else {
                    this.f517b.invoke(obj, mVar, aVar);
                }
            } catch (IllegalAccessException e5) {
                throw new RuntimeException(e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException("Failed to call observer method", e6.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f516a == bVar.f516a && this.f517b.getName().equals(bVar.f517b.getName());
            }
            return false;
        }

        public int hashCode() {
            return (this.f516a * 31) + this.f517b.getName().hashCode();
        }
    }

    a() {
    }

    private C0017a a(Class<?> cls, Method[] methodArr) {
        int i5;
        C0017a c5;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c5 = c(superclass)) != null) {
            hashMap.putAll(c5.f515b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, i.a> entry : c(cls2).f515b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z4 = false;
        for (Method method : methodArr) {
            u uVar = (u) method.getAnnotation(u.class);
            if (uVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i5 = 0;
                } else if (!m.class.isAssignableFrom(parameterTypes[0])) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i5 = 1;
                }
                i.a value = uVar.value();
                if (parameterTypes.length > 1) {
                    if (!i.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != i.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i5 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new b(i5, method), value, cls);
                z4 = true;
            }
        }
        C0017a c0017a = new C0017a(hashMap);
        this.f512a.put(cls, c0017a);
        this.f513b.put(cls, Boolean.valueOf(z4));
        return c0017a;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e5) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e5);
        }
    }

    private void e(Map<b, i.a> map, b bVar, i.a aVar, Class<?> cls) {
        i.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.f517b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0017a c(Class<?> cls) {
        C0017a c0017a = this.f512a.get(cls);
        return c0017a != null ? c0017a : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f513b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b5 = b(cls);
        for (Method method : b5) {
            if (((u) method.getAnnotation(u.class)) != null) {
                a(cls, b5);
                return true;
            }
        }
        this.f513b.put(cls, Boolean.FALSE);
        return false;
    }
}
