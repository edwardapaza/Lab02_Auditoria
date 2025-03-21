package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class f implements Handler.Callback {

    /* renamed from: r  reason: collision with root package name */
    public static final Status f930r = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: s  reason: collision with root package name */
    private static final Status f931s = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: t  reason: collision with root package name */
    private static final Object f932t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static f f933u;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.gms.common.internal.u f938e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.gms.common.internal.w f939f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f940g;

    /* renamed from: h  reason: collision with root package name */
    private final l0.f f941h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.gms.common.internal.i0 f942i;

    /* renamed from: p  reason: collision with root package name */
    private final Handler f949p;

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f950q;

    /* renamed from: a  reason: collision with root package name */
    private long f934a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private long f935b = 120000;

    /* renamed from: c  reason: collision with root package name */
    private long f936c = 10000;

    /* renamed from: d  reason: collision with root package name */
    private boolean f937d = false;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInteger f943j = new AtomicInteger(1);

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f944k = new AtomicInteger(0);

    /* renamed from: l  reason: collision with root package name */
    private final Map<b<?>, g0<?>> f945l = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: m  reason: collision with root package name */
    private x f946m = null;

    /* renamed from: n  reason: collision with root package name */
    private final Set<b<?>> f947n = new androidx.collection.b();

    /* renamed from: o  reason: collision with root package name */
    private final Set<b<?>> f948o = new androidx.collection.b();

    private f(Context context, Looper looper, l0.f fVar) {
        this.f950q = true;
        this.f940g = context;
        zaq zaqVar = new zaq(looper, this);
        this.f949p = zaqVar;
        this.f941h = fVar;
        this.f942i = new com.google.android.gms.common.internal.i0(fVar);
        if (q0.g.a(context)) {
            this.f950q = false;
        }
        zaqVar.sendMessage(zaqVar.obtainMessage(6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status h(b<?> bVar, l0.a aVar) {
        String b5 = bVar.b();
        String valueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(String.valueOf(b5).length() + 63 + valueOf.length());
        sb.append("API: ");
        sb.append(b5);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(aVar, sb.toString());
    }

    private final g0<?> i(com.google.android.gms.common.api.e<?> eVar) {
        b<?> apiKey = eVar.getApiKey();
        g0<?> g0Var = this.f945l.get(apiKey);
        if (g0Var == null) {
            g0Var = new g0<>(this, eVar);
            this.f945l.put(apiKey, g0Var);
        }
        if (g0Var.P()) {
            this.f948o.add(apiKey);
        }
        g0Var.E();
        return g0Var;
    }

    private final com.google.android.gms.common.internal.w j() {
        if (this.f939f == null) {
            this.f939f = com.google.android.gms.common.internal.v.a(this.f940g);
        }
        return this.f939f;
    }

    private final void k() {
        com.google.android.gms.common.internal.u uVar = this.f938e;
        if (uVar != null) {
            if (uVar.t() > 0 || f()) {
                j().a(uVar);
            }
            this.f938e = null;
        }
    }

    private final <T> void l(TaskCompletionSource<T> taskCompletionSource, int i5, com.google.android.gms.common.api.e eVar) {
        q0 a5;
        if (i5 == 0 || (a5 = q0.a(this, i5, eVar.getApiKey())) == null) {
            return;
        }
        Task<T> task = taskCompletionSource.getTask();
        final Handler handler = this.f949p;
        handler.getClass();
        task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.a0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, a5);
    }

    public static f x(Context context) {
        f fVar;
        synchronized (f932t) {
            if (f933u == null) {
                f933u = new f(context.getApplicationContext(), com.google.android.gms.common.internal.h.c().getLooper(), l0.f.m());
            }
            fVar = f933u;
        }
        return fVar;
    }

    public final <O extends a.d> Task<Boolean> A(com.google.android.gms.common.api.e<O> eVar, j.a aVar, int i5) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        l(taskCompletionSource, i5, eVar);
        g1 g1Var = new g1(aVar, taskCompletionSource);
        Handler handler = this.f949p;
        handler.sendMessage(handler.obtainMessage(13, new u0(g1Var, this.f944k.get(), eVar)));
        return taskCompletionSource.getTask();
    }

    public final <O extends a.d> void F(com.google.android.gms.common.api.e<O> eVar, int i5, d<? extends com.google.android.gms.common.api.j, a.b> dVar) {
        e1 e1Var = new e1(i5, dVar);
        Handler handler = this.f949p;
        handler.sendMessage(handler.obtainMessage(4, new u0(e1Var, this.f944k.get(), eVar)));
    }

    public final <O extends a.d, ResultT> void G(com.google.android.gms.common.api.e<O> eVar, int i5, r<a.b, ResultT> rVar, TaskCompletionSource<ResultT> taskCompletionSource, q qVar) {
        l(taskCompletionSource, rVar.d(), eVar);
        f1 f1Var = new f1(i5, rVar, taskCompletionSource, qVar);
        Handler handler = this.f949p;
        handler.sendMessage(handler.obtainMessage(4, new u0(f1Var, this.f944k.get(), eVar)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(com.google.android.gms.common.internal.o oVar, int i5, long j5, int i6) {
        Handler handler = this.f949p;
        handler.sendMessage(handler.obtainMessage(18, new r0(oVar, i5, j5, i6)));
    }

    public final void I(l0.a aVar, int i5) {
        if (g(aVar, i5)) {
            return;
        }
        Handler handler = this.f949p;
        handler.sendMessage(handler.obtainMessage(5, i5, 0, aVar));
    }

    public final void a() {
        Handler handler = this.f949p;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void b(com.google.android.gms.common.api.e<?> eVar) {
        Handler handler = this.f949p;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void c(x xVar) {
        synchronized (f932t) {
            if (this.f946m != xVar) {
                this.f946m = xVar;
                this.f947n.clear();
            }
            this.f947n.addAll(xVar.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(x xVar) {
        synchronized (f932t) {
            if (this.f946m == xVar) {
                this.f946m = null;
                this.f947n.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        if (this.f937d) {
            return false;
        }
        com.google.android.gms.common.internal.s a5 = com.google.android.gms.common.internal.r.b().a();
        if (a5 == null || a5.v()) {
            int a6 = this.f942i.a(this.f940g, 203400000);
            return a6 == -1 || a6 == 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g(l0.a aVar, int i5) {
        return this.f941h.w(this.f940g, aVar, i5);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        g0<?> g0Var;
        TaskCompletionSource<Boolean> b5;
        Boolean valueOf;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        int i5 = message.what;
        switch (i5) {
            case 1:
                this.f936c = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f949p.removeMessages(12);
                for (b<?> bVar5 : this.f945l.keySet()) {
                    Handler handler = this.f949p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar5), this.f936c);
                }
                break;
            case 2:
                i1 i1Var = (i1) message.obj;
                Iterator<b<?>> it = i1Var.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        b<?> next = it.next();
                        g0<?> g0Var2 = this.f945l.get(next);
                        if (g0Var2 == null) {
                            i1Var.b(next, new l0.a(13), null);
                            break;
                        } else if (g0Var2.O()) {
                            i1Var.b(next, l0.a.f5864e, g0Var2.v().getEndpointPackageName());
                        } else {
                            l0.a t5 = g0Var2.t();
                            if (t5 != null) {
                                i1Var.b(next, t5, null);
                            } else {
                                g0Var2.J(i1Var);
                                g0Var2.E();
                            }
                        }
                    }
                }
            case 3:
                for (g0<?> g0Var3 : this.f945l.values()) {
                    g0Var3.D();
                    g0Var3.E();
                }
                break;
            case 4:
            case 8:
            case 13:
                u0 u0Var = (u0) message.obj;
                g0<?> g0Var4 = this.f945l.get(u0Var.f1050c.getApiKey());
                if (g0Var4 == null) {
                    g0Var4 = i(u0Var.f1050c);
                }
                if (!g0Var4.P() || this.f944k.get() == u0Var.f1049b) {
                    g0Var4.F(u0Var.f1048a);
                    break;
                } else {
                    u0Var.f1048a.a(f930r);
                    g0Var4.L();
                    break;
                }
            case 5:
                int i6 = message.arg1;
                l0.a aVar = (l0.a) message.obj;
                Iterator<g0<?>> it2 = this.f945l.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        g0<?> next2 = it2.next();
                        g0Var = next2.r() == i6 ? next2 : null;
                    }
                }
                if (g0Var != null) {
                    if (aVar.t() == 13) {
                        String d5 = this.f941h.d(aVar.t());
                        String u5 = aVar.u();
                        StringBuilder sb = new StringBuilder(String.valueOf(d5).length() + 69 + String.valueOf(u5).length());
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(d5);
                        sb.append(": ");
                        sb.append(u5);
                        g0.y(g0Var, new Status(17, sb.toString()));
                        break;
                    } else {
                        g0.y(g0Var, h(g0.w(g0Var), aVar));
                        break;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i6);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.f940g.getApplicationContext() instanceof Application) {
                    c.c((Application) this.f940g.getApplicationContext());
                    c.b().a(new b0(this));
                    if (!c.b().e(true)) {
                        this.f936c = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                i((com.google.android.gms.common.api.e) message.obj);
                break;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                if (this.f945l.containsKey(message.obj)) {
                    this.f945l.get(message.obj).K();
                    break;
                }
                break;
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                for (b<?> bVar6 : this.f948o) {
                    g0<?> remove = this.f945l.remove(bVar6);
                    if (remove != null) {
                        remove.L();
                    }
                }
                this.f948o.clear();
                break;
            case 11:
                if (this.f945l.containsKey(message.obj)) {
                    this.f945l.get(message.obj).M();
                    break;
                }
                break;
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                if (this.f945l.containsKey(message.obj)) {
                    this.f945l.get(message.obj).c();
                    break;
                }
                break;
            case 14:
                y yVar = (y) message.obj;
                b<?> a5 = yVar.a();
                if (this.f945l.containsKey(a5)) {
                    boolean N = g0.N(this.f945l.get(a5), false);
                    b5 = yVar.b();
                    valueOf = Boolean.valueOf(N);
                } else {
                    b5 = yVar.b();
                    valueOf = Boolean.FALSE;
                }
                b5.setResult(valueOf);
                break;
            case 15:
                i0 i0Var = (i0) message.obj;
                Map<b<?>, g0<?>> map = this.f945l;
                bVar = i0Var.f971a;
                if (map.containsKey(bVar)) {
                    Map<b<?>, g0<?>> map2 = this.f945l;
                    bVar2 = i0Var.f971a;
                    g0.B(map2.get(bVar2), i0Var);
                    break;
                }
                break;
            case 16:
                i0 i0Var2 = (i0) message.obj;
                Map<b<?>, g0<?>> map3 = this.f945l;
                bVar3 = i0Var2.f971a;
                if (map3.containsKey(bVar3)) {
                    Map<b<?>, g0<?>> map4 = this.f945l;
                    bVar4 = i0Var2.f971a;
                    g0.C(map4.get(bVar4), i0Var2);
                    break;
                }
                break;
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                k();
                break;
            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                r0 r0Var = (r0) message.obj;
                if (r0Var.f1031c == 0) {
                    j().a(new com.google.android.gms.common.internal.u(r0Var.f1030b, Arrays.asList(r0Var.f1029a)));
                    break;
                } else {
                    com.google.android.gms.common.internal.u uVar = this.f938e;
                    if (uVar != null) {
                        List<com.google.android.gms.common.internal.o> u6 = uVar.u();
                        if (uVar.t() != r0Var.f1030b || (u6 != null && u6.size() >= r0Var.f1032d)) {
                            this.f949p.removeMessages(17);
                            k();
                        } else {
                            this.f938e.v(r0Var.f1029a);
                        }
                    }
                    if (this.f938e == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(r0Var.f1029a);
                        this.f938e = new com.google.android.gms.common.internal.u(r0Var.f1030b, arrayList);
                        Handler handler2 = this.f949p;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), r0Var.f1031c);
                        break;
                    }
                }
                break;
            case 19:
                this.f937d = false;
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i5);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    public final int m() {
        return this.f943j.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g0 w(b<?> bVar) {
        return this.f945l.get(bVar);
    }

    public final Task<Boolean> z(com.google.android.gms.common.api.e<?> eVar) {
        y yVar = new y(eVar.getApiKey());
        Handler handler = this.f949p;
        handler.sendMessage(handler.obtainMessage(14, yVar));
        return yVar.b().getTask();
    }
}
