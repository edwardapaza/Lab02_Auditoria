package z1;

import android.util.Log;
/* loaded from: classes.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static b f8974a = b.WARN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8975a;

        static {
            int[] iArr = new int[b.values().length];
            f8975a = iArr;
            try {
                iArr[b.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8975a[b.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8975a[b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        DEBUG,
        WARN,
        NONE
    }

    public static void a(String str, String str2, Object... objArr) {
        b(b.DEBUG, str, str2, objArr);
    }

    private static void b(b bVar, String str, String str2, Object... objArr) {
        if (bVar.ordinal() >= f8974a.ordinal()) {
            String str3 = String.format("(%s) [%s]: ", "24.11.0", str) + String.format(str2, objArr);
            int i5 = a.f8975a[bVar.ordinal()];
            if (i5 == 1) {
                Log.i("Firestore", str3);
            } else if (i5 == 2) {
                Log.w("Firestore", str3);
            } else if (i5 == 3) {
                throw new IllegalStateException("Trying to log something on level NONE");
            }
        }
    }

    public static boolean c() {
        return f8974a.ordinal() >= b.DEBUG.ordinal();
    }

    public static void d(b bVar) {
        f8974a = bVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        b(b.WARN, str, str2, objArr);
    }
}
