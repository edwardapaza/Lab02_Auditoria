package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f562a = new j();

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicBoolean f563b = new AtomicBoolean(false);

    /* loaded from: classes.dex */
    public static final class a extends f {
        @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            e4.k.e(activity, "activity");
            z.f613b.c(activity);
        }
    }

    private j() {
    }

    public static final void a(Context context) {
        e4.k.e(context, "context");
        if (f563b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        e4.k.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
