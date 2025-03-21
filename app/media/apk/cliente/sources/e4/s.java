package e4;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final t f2940a;

    /* renamed from: b  reason: collision with root package name */
    private static final i4.b[] f2941b;

    static {
        t tVar = null;
        try {
            tVar = (t) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (tVar == null) {
            tVar = new t();
        }
        f2940a = tVar;
        f2941b = new i4.b[0];
    }

    public static i4.e a(i iVar) {
        return f2940a.a(iVar);
    }

    public static i4.b b(Class cls) {
        return f2940a.b(cls);
    }

    public static i4.d c(Class cls) {
        return f2940a.c(cls, "");
    }

    public static i4.f d(n nVar) {
        return f2940a.d(nVar);
    }

    public static String e(h hVar) {
        return f2940a.e(hVar);
    }

    public static String f(l lVar) {
        return f2940a.f(lVar);
    }
}
