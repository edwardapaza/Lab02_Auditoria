package i3;

import java.util.List;
/* loaded from: classes.dex */
final class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static List<h> f3312a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3313b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized List<h> a() {
        List<h> list;
        synchronized (a0.class) {
            f3313b = true;
            list = f3312a;
        }
        return list;
    }
}
