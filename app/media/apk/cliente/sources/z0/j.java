package z0;

import java.util.Locale;
import java.util.logging.Logger;
/* loaded from: classes.dex */
final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f8877a = Logger.getLogger(j.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final i f8878b = b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements i {
        private b() {
        }
    }

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(double d5) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d5));
    }

    private static i b() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(String str) {
        return str == null || str.isEmpty();
    }
}
