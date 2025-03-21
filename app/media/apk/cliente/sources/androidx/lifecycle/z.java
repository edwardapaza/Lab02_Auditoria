package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.i;
/* loaded from: classes.dex */
public class z extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public static final b f613b = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private a f614a;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e4.g gVar) {
            this();
        }

        public final void a(Activity activity, i.a aVar) {
            e4.k.e(activity, "activity");
            e4.k.e(aVar, "event");
            if (activity instanceof o) {
                ((o) activity).a().h(aVar);
            } else if (activity instanceof m) {
                i a5 = ((m) activity).a();
                if (a5 instanceof n) {
                    ((n) a5).h(aVar);
                }
            }
        }

        public final z b(Activity activity) {
            e4.k.e(activity, "<this>");
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            e4.k.c(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (z) findFragmentByTag;
        }

        public final void c(Activity activity) {
            e4.k.e(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new z(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(e4.g gVar) {
                this();
            }

            public final void a(Activity activity) {
                e4.k.e(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            e4.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            e4.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            e4.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            e4.k.e(activity, "activity");
            z.f613b.a(activity, i.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            e4.k.e(activity, "activity");
            z.f613b.a(activity, i.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            e4.k.e(activity, "activity");
            z.f613b.a(activity, i.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            e4.k.e(activity, "activity");
            z.f613b.a(activity, i.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            e4.k.e(activity, "activity");
            z.f613b.a(activity, i.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            e4.k.e(activity, "activity");
            z.f613b.a(activity, i.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            e4.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            e4.k.e(activity, "activity");
            e4.k.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            e4.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            e4.k.e(activity, "activity");
        }
    }

    private final void a(i.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f613b;
            Activity activity = getActivity();
            e4.k.d(activity, "activity");
            bVar.a(activity, aVar);
        }
    }

    private final void b(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void c(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private final void d(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    public static final void e(Activity activity) {
        f613b.c(activity);
    }

    public final void f(a aVar) {
        this.f614a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f614a);
        a(i.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(i.a.ON_DESTROY);
        this.f614a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(i.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f614a);
        a(i.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f614a);
        a(i.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(i.a.ON_STOP);
    }
}
