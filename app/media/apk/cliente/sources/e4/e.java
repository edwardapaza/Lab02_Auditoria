package e4;

import d4.v;
import d4.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import t3.g0;
import t3.h0;
/* loaded from: classes.dex */
public final class e implements i4.b<Object>, d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f2925b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends s3.c<?>>, Integer> f2926c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f2927d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f2928e;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, String> f2929f;

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, String> f2930g;

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f2931a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a(Class<?> cls) {
            String str;
            k.e(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) e.f2929f.get(cls.getName());
                return str3 == null ? cls.getCanonicalName() : str3;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) e.f2929f.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        public final String b(Class<?> cls) {
            String str;
            Method enclosingMethod;
            String Y;
            String Z;
            String Z2;
            k.e(cls, "jClass");
            String str2 = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    if (cls.getEnclosingMethod() != null) {
                        k.d(simpleName, "name");
                        Z2 = k4.p.Z(simpleName, enclosingMethod.getName() + '$', null, 2, null);
                        if (Z2 != null) {
                            return Z2;
                        }
                    }
                    Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                    k.d(simpleName, "name");
                    if (enclosingConstructor == null) {
                        Y = k4.p.Y(simpleName, '$', null, 2, null);
                        return Y;
                    }
                    Z = k4.p.Z(simpleName, enclosingConstructor.getName() + '$', null, 2, null);
                    return Z;
                } else if (!cls.isArray()) {
                    String str3 = (String) e.f2930g.get(cls.getName());
                    return str3 == null ? cls.getSimpleName() : str3;
                } else {
                    Class<?> componentType = cls.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) e.f2930g.get(componentType.getName())) != null) {
                        str2 = str + "Array";
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                }
            }
            return str2;
        }

        public final boolean c(Object obj, Class<?> cls) {
            k.e(cls, "jClass");
            Map map = e.f2926c;
            k.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return u.c(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = c4.a.b(c4.a.c(cls));
            }
            return cls.isInstance(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List h5;
        int k5;
        Map<Class<? extends s3.c<?>>, Integer> j5;
        int a5;
        String b02;
        String b03;
        int i5 = 0;
        h5 = t3.p.h(d4.a.class, d4.l.class, d4.p.class, d4.q.class, d4.r.class, d4.s.class, d4.t.class, d4.u.class, v.class, w.class, d4.b.class, d4.c.class, d4.d.class, d4.e.class, d4.f.class, d4.g.class, d4.h.class, d4.i.class, d4.j.class, d4.k.class, d4.m.class, d4.n.class, d4.o.class);
        k5 = t3.q.k(h5, 10);
        ArrayList arrayList = new ArrayList(k5);
        for (Object obj : h5) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                t3.p.j();
            }
            arrayList.add(s3.p.a((Class) obj, Integer.valueOf(i5)));
            i5 = i6;
        }
        j5 = h0.j(arrayList);
        f2926c = j5;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f2927d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f2928e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        k.d(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            k.d(str, "kotlinName");
            b03 = k4.p.b0(str, '.', null, 2, null);
            sb.append(b03);
            sb.append("CompanionObject");
            s3.l a6 = s3.p.a(sb.toString(), str + ".Companion");
            hashMap3.put(a6.c(), a6.d());
        }
        for (Map.Entry<Class<? extends s3.c<?>>, Integer> entry : f2926c.entrySet()) {
            int intValue = entry.getValue().intValue();
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + intValue);
        }
        f2929f = hashMap3;
        a5 = g0.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a5);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            b02 = k4.p.b0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, b02);
        }
        f2930g = linkedHashMap;
    }

    public e(Class<?> cls) {
        k.e(cls, "jClass");
        this.f2931a = cls;
    }

    @Override // i4.b
    public String a() {
        return f2925b.a(d());
    }

    @Override // i4.b
    public boolean b(Object obj) {
        return f2925b.c(obj, d());
    }

    @Override // i4.b
    public String c() {
        return f2925b.b(d());
    }

    @Override // e4.d
    public Class<?> d() {
        return this.f2931a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && k.a(c4.a.b(this), c4.a.b((i4.b) obj));
    }

    public int hashCode() {
        return c4.a.b(this).hashCode();
    }

    public String toString() {
        return d().toString() + " (Kotlin reflection is not available)";
    }
}
