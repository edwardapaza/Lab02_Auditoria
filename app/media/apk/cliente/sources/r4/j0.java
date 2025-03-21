package r4;
/* loaded from: classes.dex */
final /* synthetic */ class j0 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7200a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f7200a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
