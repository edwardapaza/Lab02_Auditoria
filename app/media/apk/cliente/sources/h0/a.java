package h0;

import e4.k;
import i4.b;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3107a = new a();

    private a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
        if (r4 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        r5.append(r4);
        android.util.Log.e("ReflectionGuard", r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r4 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean e(java.lang.String r4, d4.a<java.lang.Boolean> r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "ReflectionGuard"
            java.lang.String r2 = "block"
            e4.k.e(r5, r2)
            r2 = 0
            java.lang.Object r5 = r5.b()     // Catch: java.lang.NoSuchMethodException -> L1d java.lang.ClassNotFoundException -> L2b
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.NoSuchMethodException -> L1d java.lang.ClassNotFoundException -> L2b
            boolean r5 = r5.booleanValue()     // Catch: java.lang.NoSuchMethodException -> L1d java.lang.ClassNotFoundException -> L2b
            if (r5 != 0) goto L1b
            if (r4 == 0) goto L1b
            android.util.Log.e(r1, r4)     // Catch: java.lang.NoSuchMethodException -> L1d java.lang.ClassNotFoundException -> L2b
        L1b:
            r2 = r5
            goto L43
        L1d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r3 = "NoSuchMethod: "
            r5.append(r3)
            if (r4 != 0) goto L39
            goto L38
        L2b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r3 = "ClassNotFound: "
            r5.append(r3)
            if (r4 != 0) goto L39
        L38:
            r4 = r0
        L39:
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.util.Log.e(r1, r4)
        L43:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.a.e(java.lang.String, d4.a):boolean");
    }

    public final boolean a(d4.a<? extends Class<?>> aVar) {
        k.e(aVar, "classLoader");
        try {
            aVar.b();
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean b(Method method, b<?> bVar) {
        k.e(method, "<this>");
        k.e(bVar, "clazz");
        return c(method, c4.a.a(bVar));
    }

    public final boolean c(Method method, Class<?> cls) {
        k.e(method, "<this>");
        k.e(cls, "clazz");
        return method.getReturnType().equals(cls);
    }

    public final boolean d(Method method) {
        k.e(method, "<this>");
        return Modifier.isPublic(method.getModifiers());
    }
}
