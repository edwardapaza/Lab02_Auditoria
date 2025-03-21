package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f477a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<f> f478b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<f, a> f479c = new HashMap();

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final androidx.lifecycle.i f480a;

        /* renamed from: b  reason: collision with root package name */
        private androidx.lifecycle.k f481b;

        void a() {
            this.f480a.c(this.f481b);
            this.f481b = null;
        }
    }

    public e(Runnable runnable) {
        this.f477a = runnable;
    }

    public void a(f fVar) {
        this.f478b.add(fVar);
        this.f477a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator<f> it = this.f478b.iterator();
        while (it.hasNext()) {
            it.next().c(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator<f> it = this.f478b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator<f> it = this.f478b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator<f> it = this.f478b.iterator();
        while (it.hasNext()) {
            it.next().d(menu);
        }
    }

    public void f(f fVar) {
        this.f478b.remove(fVar);
        a remove = this.f479c.remove(fVar);
        if (remove != null) {
            remove.a();
        }
        this.f477a.run();
    }
}
