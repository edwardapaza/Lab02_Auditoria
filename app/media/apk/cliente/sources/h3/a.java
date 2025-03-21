package h3;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public final class a {
    public static Handler a(Looper looper) {
        Handler createAsync;
        if (Build.VERSION.SDK_INT >= 28) {
            createAsync = Handler.createAsync(looper);
            return createAsync;
        }
        return new Handler(looper);
    }
}
