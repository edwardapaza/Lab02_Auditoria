package h;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.core.app.l;
import h.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f3096a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f3097b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<Bundle> f3100c;

        /* renamed from: d  reason: collision with root package name */
        private Bundle f3101d;

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<Bundle> f3102e;

        /* renamed from: f  reason: collision with root package name */
        private SparseArray<Bundle> f3103f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f3104g;

        /* renamed from: a  reason: collision with root package name */
        private final Intent f3098a = new Intent("android.intent.action.VIEW");

        /* renamed from: b  reason: collision with root package name */
        private final a.C0058a f3099b = new a.C0058a();

        /* renamed from: h  reason: collision with root package name */
        private int f3105h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f3106i = true;

        private void b(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            l.a(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f3098a.putExtras(bundle);
        }

        public b a() {
            if (!this.f3098a.hasExtra("android.support.customtabs.extra.SESSION")) {
                b(null, null);
            }
            ArrayList<Bundle> arrayList = this.f3100c;
            if (arrayList != null) {
                this.f3098a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f3102e;
            if (arrayList2 != null) {
                this.f3098a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f3098a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f3106i);
            this.f3098a.putExtras(this.f3099b.a().a());
            Bundle bundle = this.f3104g;
            if (bundle != null) {
                this.f3098a.putExtras(bundle);
            }
            if (this.f3103f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f3103f);
                this.f3098a.putExtras(bundle2);
            }
            this.f3098a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f3105h);
            return new b(this.f3098a, this.f3101d);
        }
    }

    b(Intent intent, Bundle bundle) {
        this.f3096a = intent;
        this.f3097b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f3096a.setData(uri);
        androidx.core.content.a.startActivity(context, this.f3096a, this.f3097b);
    }
}
