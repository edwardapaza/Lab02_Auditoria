package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public final class EnvironmentCompat {
    @Deprecated
    public static final String MEDIA_UNKNOWN = "unknown";

    public static String getStorageState(File path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getExternalStorageState(path);
        }
        return Environment.getStorageState(path);
    }

    private EnvironmentCompat() {
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static String getExternalStorageState(File path) {
            return Environment.getExternalStorageState(path);
        }
    }
}
