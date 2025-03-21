package d;

import android.content.Context;
import android.content.Intent;
import e4.g;
import e4.k;
/* loaded from: classes.dex */
public final class c extends d.a<Intent, c.a> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2248a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Override // d.a
    /* renamed from: d */
    public Intent a(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "input");
        return intent;
    }

    @Override // d.a
    /* renamed from: e */
    public c.a c(int i5, Intent intent) {
        return new c.a(i5, intent);
    }
}
