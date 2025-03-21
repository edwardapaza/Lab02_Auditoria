package s0;

import android.content.Context;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static final d f7254b = new d();

    /* renamed from: a  reason: collision with root package name */
    private c f7255a = null;

    public static c a(Context context) {
        return f7254b.b(context);
    }

    public final synchronized c b(Context context) {
        if (this.f7255a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f7255a = new c(context);
        }
        return this.f7255a;
    }
}
