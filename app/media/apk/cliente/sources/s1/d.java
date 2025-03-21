package s1;

import android.app.Activity;
import android.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<Runnable> f7295a;

        private b() {
            this.f7295a = new ArrayList();
        }

        synchronized void a(Runnable runnable) {
            this.f7295a.add(runnable);
        }

        void b() {
            for (Runnable runnable : this.f7295a) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        b f7296a = new b();

        @Override // android.app.Fragment
        public void onStop() {
            b bVar;
            super.onStop();
            synchronized (this.f7296a) {
                bVar = this.f7296a;
                this.f7296a = new b();
            }
            bVar.b();
        }
    }

    /* renamed from: s1.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0112d extends o.s {

        /* renamed from: i0  reason: collision with root package name */
        b f7297i0 = new b();

        @Override // o.s
        public void M0() {
            b bVar;
            super.M0();
            synchronized (this.f7297i0) {
                bVar = this.f7297i0;
                this.f7297i0 = new b();
            }
            bVar.b();
        }
    }

    public static com.google.firebase.firestore.g0 c(Activity activity, final com.google.firebase.firestore.g0 g0Var) {
        if (activity != null) {
            if (activity instanceof o.x) {
                Objects.requireNonNull(g0Var);
                h((o.x) activity, new Runnable() { // from class: s1.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.firebase.firestore.g0.this.remove();
                    }
                });
            } else {
                Objects.requireNonNull(g0Var);
                g(activity, new Runnable() { // from class: s1.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.firebase.firestore.g0.this.remove();
                    }
                });
            }
        }
        return g0Var;
    }

    private static <T> T d(Class<T> cls, Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Fragment with tag '" + str + "' is a " + obj.getClass().getName() + " but should be a " + cls.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Activity activity, Runnable runnable) {
        c cVar = (c) d(c.class, activity.getFragmentManager().findFragmentByTag("FirestoreOnStopObserverFragment"), "FirestoreOnStopObserverFragment");
        if (cVar == null || cVar.isRemoving()) {
            cVar = new c();
            activity.getFragmentManager().beginTransaction().add(cVar, "FirestoreOnStopObserverFragment").commitAllowingStateLoss();
            activity.getFragmentManager().executePendingTransactions();
        }
        cVar.f7296a.a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(o.x xVar, Runnable runnable) {
        C0112d c0112d = (C0112d) d(C0112d.class, xVar.O().i0("FirestoreOnStopObserverSupportFragment"), "FirestoreOnStopObserverSupportFragment");
        if (c0112d == null || c0112d.e0()) {
            c0112d = new C0112d();
            xVar.O().n().d(c0112d, "FirestoreOnStopObserverSupportFragment").g();
            xVar.O().e0();
        }
        c0112d.f7297i0.a(runnable);
    }

    private static void g(final Activity activity, final Runnable runnable) {
        z1.b.d(!(activity instanceof o.x), "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
        activity.runOnUiThread(new Runnable() { // from class: s1.b
            @Override // java.lang.Runnable
            public final void run() {
                d.e(activity, runnable);
            }
        });
    }

    private static void h(final o.x xVar, final Runnable runnable) {
        xVar.runOnUiThread(new Runnable() { // from class: s1.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(o.x.this, runnable);
            }
        });
    }
}
