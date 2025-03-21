package g0;

import android.app.Activity;
import e4.k;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f3052a = new b();

    private b() {
    }

    public final boolean a(Activity activity) {
        boolean isInMultiWindowMode;
        k.e(activity, "activity");
        isInMultiWindowMode = activity.isInMultiWindowMode();
        return isInMultiWindowMode;
    }
}
