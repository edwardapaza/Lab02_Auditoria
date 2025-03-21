package io.flutter.plugins.firebase.core;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import f1.n;
import io.flutter.plugins.firebase.core.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s2.a;
/* loaded from: classes.dex */
public class i implements s2.a, p.b, p.a {

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, String> f4123c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private Context f4124a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4125b = false;

    private <T> void A(TaskCompletionSource<T> taskCompletionSource, final p.g<T> gVar) {
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.core.g
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                i.w(p.g.this, task);
            }
        });
    }

    private Task<p.f> p(final f1.f fVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.h
            @Override // java.lang.Runnable
            public final void run() {
                i.this.s(fVar, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private p.e q(f1.n nVar) {
        p.e.a aVar = new p.e.a();
        aVar.b(nVar.b());
        aVar.c(nVar.c());
        if (nVar.f() != null) {
            aVar.e(nVar.f());
        }
        if (nVar.g() != null) {
            aVar.f(nVar.g());
        }
        aVar.d(nVar.d());
        aVar.g(nVar.h());
        aVar.h(nVar.e());
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(String str, TaskCompletionSource taskCompletionSource) {
        try {
            try {
                f1.f.p(str).j();
            } catch (IllegalStateException unused) {
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(f1.f fVar, TaskCompletionSource taskCompletionSource) {
        try {
            p.f.a aVar = new p.f.a();
            aVar.c(fVar.q());
            aVar.d(q(fVar.r()));
            aVar.b(Boolean.valueOf(fVar.x()));
            aVar.e((Map) Tasks.await(FlutterFirebasePluginRegistry.getPluginConstantsForFirebaseApp(fVar)));
            taskCompletionSource.setResult(aVar.a());
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(p.e eVar, String str, TaskCompletionSource taskCompletionSource) {
        try {
            f1.n a5 = new n.b().b(eVar.b()).c(eVar.c()).d(eVar.e()).f(eVar.f()).g(eVar.g()).h(eVar.h()).e(eVar.i()).a();
            try {
                Looper.prepare();
            } catch (Exception unused) {
            }
            if (eVar.d() != null) {
                f4123c.put(str, eVar.d());
            }
            taskCompletionSource.setResult((p.f) Tasks.await(p(f1.f.w(this.f4124a, a5, str))));
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(TaskCompletionSource taskCompletionSource) {
        try {
            if (this.f4125b) {
                Tasks.await(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
            } else {
                this.f4125b = true;
            }
            List<f1.f> n5 = f1.f.n(this.f4124a);
            ArrayList arrayList = new ArrayList(n5.size());
            for (f1.f fVar : n5) {
                arrayList.add((p.f) Tasks.await(p(fVar)));
            }
            taskCompletionSource.setResult(arrayList);
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(p.g gVar, Task task) {
        if (task.isSuccessful()) {
            gVar.a(task.getResult());
        } else {
            gVar.b(task.getException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(TaskCompletionSource taskCompletionSource) {
        try {
            f1.n a5 = f1.n.a(this.f4124a);
            if (a5 == null) {
                taskCompletionSource.setException(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
            } else {
                taskCompletionSource.setResult(q(a5));
            }
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        try {
            f1.f.p(str).F(bool);
            taskCompletionSource.setResult(null);
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        try {
            f1.f.p(str).E(bool.booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    @Override // io.flutter.plugins.firebase.core.p.b
    public void a(final String str, final p.e eVar, p.g<p.f> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.d
            @Override // java.lang.Runnable
            public final void run() {
                i.this.u(eVar, str, taskCompletionSource);
            }
        });
        A(taskCompletionSource, gVar);
    }

    @Override // s2.a
    public void b(a.b bVar) {
        t.e(bVar.b(), this);
        o.e(bVar.b(), this);
        this.f4124a = bVar.a();
    }

    @Override // io.flutter.plugins.firebase.core.p.b
    public void c(p.g<List<p.f>> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.c
            @Override // java.lang.Runnable
            public final void run() {
                i.this.v(taskCompletionSource);
            }
        });
        A(taskCompletionSource, gVar);
    }

    @Override // io.flutter.plugins.firebase.core.p.b
    public void d(p.g<p.e> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.b
            @Override // java.lang.Runnable
            public final void run() {
                i.this.x(taskCompletionSource);
            }
        });
        A(taskCompletionSource, gVar);
    }

    @Override // io.flutter.plugins.firebase.core.p.a
    public void e(final String str, final Boolean bool, p.g<Void> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.e
            @Override // java.lang.Runnable
            public final void run() {
                i.y(str, bool, taskCompletionSource);
            }
        });
        A(taskCompletionSource, gVar);
    }

    @Override // io.flutter.plugins.firebase.core.p.a
    public void f(final String str, final Boolean bool, p.g<Void> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.f
            @Override // java.lang.Runnable
            public final void run() {
                i.z(str, bool, taskCompletionSource);
            }
        });
        A(taskCompletionSource, gVar);
    }

    @Override // io.flutter.plugins.firebase.core.p.a
    public void g(final String str, p.g<Void> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.core.a
            @Override // java.lang.Runnable
            public final void run() {
                i.r(str, taskCompletionSource);
            }
        });
        A(taskCompletionSource, gVar);
    }

    @Override // s2.a
    public void t(a.b bVar) {
        this.f4124a = null;
        t.e(bVar.b(), null);
        o.e(bVar.b(), null);
    }
}
