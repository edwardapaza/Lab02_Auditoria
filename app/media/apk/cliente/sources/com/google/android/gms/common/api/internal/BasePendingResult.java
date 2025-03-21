package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.j;
import com.google.android.gms.internal.base.zaq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.j> extends com.google.android.gms.common.api.g<R> {

    /* renamed from: o */
    static final ThreadLocal<Boolean> f897o = new o1();

    /* renamed from: f */
    private com.google.android.gms.common.api.k<? super R> f903f;

    /* renamed from: h */
    private R f905h;

    /* renamed from: i */
    private Status f906i;

    /* renamed from: j */
    private volatile boolean f907j;

    /* renamed from: k */
    private boolean f908k;

    /* renamed from: l */
    private boolean f909l;

    /* renamed from: m */
    private com.google.android.gms.common.internal.k f910m;
    private q1 mResultGuardian;

    /* renamed from: a */
    private final Object f898a = new Object();

    /* renamed from: d */
    private final CountDownLatch f901d = new CountDownLatch(1);

    /* renamed from: e */
    private final ArrayList<g.a> f902e = new ArrayList<>();

    /* renamed from: g */
    private final AtomicReference<d1> f904g = new AtomicReference<>();

    /* renamed from: n */
    private boolean f911n = false;

    /* renamed from: b */
    protected final a<R> f899b = new a<>(Looper.getMainLooper());

    /* renamed from: c */
    protected final WeakReference<com.google.android.gms.common.api.f> f900c = new WeakReference<>(null);

    /* loaded from: classes.dex */
    public static class a<R extends com.google.android.gms.common.api.j> extends zaq {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(com.google.android.gms.common.api.k<? super R> kVar, R r5) {
            ThreadLocal<Boolean> threadLocal = BasePendingResult.f897o;
            sendMessage(obtainMessage(1, new Pair((com.google.android.gms.common.api.k) com.google.android.gms.common.internal.q.k(kVar), r5)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 1) {
                Pair pair = (Pair) message.obj;
                com.google.android.gms.common.api.k kVar = (com.google.android.gms.common.api.k) pair.first;
                com.google.android.gms.common.api.j jVar = (com.google.android.gms.common.api.j) pair.second;
                try {
                    kVar.a(jVar);
                } catch (RuntimeException e5) {
                    BasePendingResult.j(jVar);
                    throw e5;
                }
            } else if (i5 == 2) {
                ((BasePendingResult) message.obj).c(Status.f879m);
            } else {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i5);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            }
        }
    }

    @Deprecated
    BasePendingResult() {
    }

    private final R f() {
        R r5;
        synchronized (this.f898a) {
            com.google.android.gms.common.internal.q.n(!this.f907j, "Result has already been consumed.");
            com.google.android.gms.common.internal.q.n(d(), "Result is not ready.");
            r5 = this.f905h;
            this.f905h = null;
            this.f903f = null;
            this.f907j = true;
        }
        if (this.f904g.getAndSet(null) == null) {
            return (R) com.google.android.gms.common.internal.q.k(r5);
        }
        throw null;
    }

    private final void g(R r5) {
        this.f905h = r5;
        this.f906i = r5.l();
        this.f910m = null;
        this.f901d.countDown();
        if (this.f908k) {
            this.f903f = null;
        } else {
            com.google.android.gms.common.api.k<? super R> kVar = this.f903f;
            if (kVar != null) {
                this.f899b.removeMessages(2);
                this.f899b.a(kVar, f());
            } else if (this.f905h instanceof com.google.android.gms.common.api.h) {
                this.mResultGuardian = new q1(this, null);
            }
        }
        ArrayList<g.a> arrayList = this.f902e;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.get(i5).a(this.f906i);
        }
        this.f902e.clear();
    }

    public static void j(com.google.android.gms.common.api.j jVar) {
        if (jVar instanceof com.google.android.gms.common.api.h) {
            try {
                ((com.google.android.gms.common.api.h) jVar).release();
            } catch (RuntimeException e5) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(jVar)), e5);
            }
        }
    }

    @Override // com.google.android.gms.common.api.g
    public final void a(g.a aVar) {
        com.google.android.gms.common.internal.q.b(aVar != null, "Callback cannot be null.");
        synchronized (this.f898a) {
            if (d()) {
                aVar.a(this.f906i);
            } else {
                this.f902e.add(aVar);
            }
        }
    }

    public abstract R b(Status status);

    @Deprecated
    public final void c(Status status) {
        synchronized (this.f898a) {
            if (!d()) {
                e(b(status));
                this.f909l = true;
            }
        }
    }

    public final boolean d() {
        return this.f901d.getCount() == 0;
    }

    public final void e(R r5) {
        synchronized (this.f898a) {
            if (this.f909l || this.f908k) {
                j(r5);
                return;
            }
            d();
            com.google.android.gms.common.internal.q.n(!d(), "Results have already been set");
            com.google.android.gms.common.internal.q.n(!this.f907j, "Result has already been consumed");
            g(r5);
        }
    }

    public final void i() {
        boolean z4 = true;
        if (!this.f911n && !f897o.get().booleanValue()) {
            z4 = false;
        }
        this.f911n = z4;
    }
}
