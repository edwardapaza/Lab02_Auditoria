package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
/* loaded from: classes.dex */
public final class j {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static <T> T a(Context context, Class<T> cls) {
            Object systemService;
            systemService = context.getSystemService(cls);
            return (T) systemService;
        }

        static int b(AppOpsManager appOpsManager, String str, String str2) {
            int noteProxyOp;
            noteProxyOp = appOpsManager.noteProxyOp(str, str2);
            return noteProxyOp;
        }

        static int c(AppOpsManager appOpsManager, String str, String str2) {
            int noteProxyOpNoThrow;
            noteProxyOpNoThrow = appOpsManager.noteProxyOpNoThrow(str, str2);
            return noteProxyOpNoThrow;
        }

        static String d(String str) {
            String permissionToOp;
            permissionToOp = AppOpsManager.permissionToOp(str);
            return permissionToOp;
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static int a(AppOpsManager appOpsManager, String str, int i5, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i5, str2);
        }

        static String b(Context context) {
            String opPackageName;
            opPackageName = context.getOpPackageName();
            return opPackageName;
        }

        static AppOpsManager c(Context context) {
            Object systemService;
            systemService = context.getSystemService(AppOpsManager.class);
            return (AppOpsManager) systemService;
        }
    }

    public static int a(Context context, int i5, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            AppOpsManager c5 = b.c(context);
            int a5 = b.a(c5, str, Binder.getCallingUid(), str2);
            return a5 != 0 ? a5 : b.a(c5, str, i5, b.b(context));
        }
        return b(context, str, str2);
    }

    public static int b(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.c((AppOpsManager) a.a(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    public static String c(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.d(str);
        }
        return null;
    }
}
