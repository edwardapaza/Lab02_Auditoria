package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
/* loaded from: classes.dex */
public class m {

    /* loaded from: classes.dex */
    static class a {
        static boolean a(Context context) {
            Object systemService;
            boolean isUserUnlocked;
            systemService = context.getSystemService(UserManager.class);
            isUserUnlocked = ((UserManager) systemService).isUserUnlocked();
            return isUserUnlocked;
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(context);
        }
        return true;
    }
}
