package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;
/* loaded from: classes.dex */
class a {

    /* renamed from: androidx.profileinstaller.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0024a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        static File a(Context context) {
            Context createDeviceProtectedStorageContext;
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            return createDeviceProtectedStorageContext.getCodeCacheDir();
        }
    }

    static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z4 = true;
        for (File file2 : listFiles) {
            z4 = a(file2) && z4;
        }
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, ProfileInstallReceiver.a aVar) {
        int i5 = Build.VERSION.SDK_INT;
        aVar.b(a(i5 >= 24 ? b.a(context) : i5 >= 23 ? C0024a.a(context) : context.getCacheDir()) ? 14 : 15, null);
    }
}
