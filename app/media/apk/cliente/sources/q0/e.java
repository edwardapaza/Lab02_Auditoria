package q0;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.q;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6925a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    @ResultIgnorabilityUnspecified
    public static boolean a(Context context, Throwable th) {
        try {
            q.k(context);
            q.k(th);
            return false;
        } catch (Exception e5) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e5);
            return false;
        }
    }
}
