package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: o */
    private static final Map f1342o = new HashMap();

    /* renamed from: a */
    private final Context f1343a;

    /* renamed from: b */
    private final c0 f1344b;

    /* renamed from: c */
    private final String f1345c;

    /* renamed from: g */
    private boolean f1349g;

    /* renamed from: h */
    private final Intent f1350h;

    /* renamed from: i */
    private final j0 f1351i;

    /* renamed from: m */
    private ServiceConnection f1355m;

    /* renamed from: n */
    private IInterface f1356n;

    /* renamed from: d */
    private final List f1346d = new ArrayList();

    /* renamed from: e */
    private final Set f1347e = new HashSet();

    /* renamed from: f */
    private final Object f1348f = new Object();

    /* renamed from: k */
    private final IBinder.DeathRecipient f1353k = new IBinder.DeathRecipient() { // from class: com.google.android.play.integrity.internal.f0
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            d.k(d.this);
        }
    };

    /* renamed from: l */
    private final AtomicInteger f1354l = new AtomicInteger(0);

    /* renamed from: j */
    private final WeakReference f1352j = new WeakReference(null);

    public d(Context context, c0 c0Var, String str, Intent intent, j0 j0Var, i0 i0Var) {
        this.f1343a = context;
        this.f1344b = c0Var;
        this.f1345c = str;
        this.f1350h = intent;
        this.f1351i = j0Var;
    }

    public static /* synthetic */ void k(d dVar) {
        dVar.f1344b.c("reportBinderDeath", new Object[0]);
        i0 i0Var = (i0) dVar.f1352j.get();
        if (i0Var != null) {
            dVar.f1344b.c("calling onBinderDied", new Object[0]);
            i0Var.a();
        } else {
            dVar.f1344b.c("%s : Binder has died.", dVar.f1345c);
            for (d0 d0Var : dVar.f1346d) {
                d0Var.a(dVar.w());
            }
            dVar.f1346d.clear();
        }
        synchronized (dVar.f1348f) {
            dVar.x();
        }
    }

    public static /* bridge */ /* synthetic */ void o(d dVar, final TaskCompletionSource taskCompletionSource) {
        dVar.f1347e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.integrity.internal.e0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                d.this.u(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void q(d dVar, d0 d0Var) {
        if (dVar.f1356n != null || dVar.f1349g) {
            if (!dVar.f1349g) {
                d0Var.run();
                return;
            }
            dVar.f1344b.c("Waiting to bind to the service.", new Object[0]);
            dVar.f1346d.add(d0Var);
            return;
        }
        dVar.f1344b.c("Initiate binding to the service.", new Object[0]);
        dVar.f1346d.add(d0Var);
        c cVar = new c(dVar, null);
        dVar.f1355m = cVar;
        dVar.f1349g = true;
        if (dVar.f1343a.bindService(dVar.f1350h, cVar, 1)) {
            return;
        }
        dVar.f1344b.c("Failed to bind to the service.", new Object[0]);
        dVar.f1349g = false;
        for (d0 d0Var2 : dVar.f1346d) {
            d0Var2.a(new e());
        }
        dVar.f1346d.clear();
    }

    public static /* bridge */ /* synthetic */ void r(d dVar) {
        dVar.f1344b.c("linkToDeath", new Object[0]);
        try {
            dVar.f1356n.asBinder().linkToDeath(dVar.f1353k, 0);
        } catch (RemoteException e5) {
            dVar.f1344b.b(e5, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void s(d dVar) {
        dVar.f1344b.c("unlinkToDeath", new Object[0]);
        dVar.f1356n.asBinder().unlinkToDeath(dVar.f1353k, 0);
    }

    private final RemoteException w() {
        return new RemoteException(String.valueOf(this.f1345c).concat(" : Binder has died."));
    }

    public final void x() {
        for (TaskCompletionSource taskCompletionSource : this.f1347e) {
            taskCompletionSource.trySetException(w());
        }
        this.f1347e.clear();
    }

    public final Handler c() {
        Handler handler;
        Map map = f1342o;
        synchronized (map) {
            if (!map.containsKey(this.f1345c)) {
                HandlerThread handlerThread = new HandlerThread(this.f1345c, 10);
                handlerThread.start();
                map.put(this.f1345c, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.f1345c);
        }
        return handler;
    }

    public final IInterface e() {
        return this.f1356n;
    }

    public final void t(d0 d0Var, TaskCompletionSource taskCompletionSource) {
        c().post(new g0(this, d0Var.c(), taskCompletionSource, d0Var));
    }

    public final /* synthetic */ void u(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f1348f) {
            this.f1347e.remove(taskCompletionSource);
        }
    }

    public final void v(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f1348f) {
            this.f1347e.remove(taskCompletionSource);
        }
        c().post(new h0(this));
    }
}
