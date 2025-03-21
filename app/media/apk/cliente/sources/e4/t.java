package e4;
/* loaded from: classes.dex */
public class t {
    public i4.e a(i iVar) {
        return iVar;
    }

    public i4.b b(Class cls) {
        return new e(cls);
    }

    public i4.d c(Class cls, String str) {
        return new m(cls, str);
    }

    public i4.f d(n nVar) {
        return nVar;
    }

    public String e(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String f(l lVar) {
        return e(lVar);
    }
}
