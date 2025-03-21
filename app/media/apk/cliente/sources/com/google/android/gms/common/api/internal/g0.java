package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public final class g0<O extends a.d> implements f.a, f.b {

    /* renamed from: b */
    private final a.f f956b;

    /* renamed from: c */
    private final b<O> f957c;

    /* renamed from: d */
    private final w f958d;

    /* renamed from: g */
    private final int f961g;

    /* renamed from: h */
    private final z0 f962h;

    /* renamed from: i */
    private boolean f963i;

    /* renamed from: m */
    final /* synthetic */ f f967m;

    /* renamed from: a */
    private final Queue<h1> f955a = new LinkedList();

    /* renamed from: e */
    private final Set<i1> f959e = new HashSet();

    /* renamed from: f */
    private final Map<j.a<?>, v0> f960f = new HashMap();

    /* renamed from: j */
    private final List<i0> f964j = new ArrayList();

    /* renamed from: k */
    private l0.a f965k = null;

    /* renamed from: l */
    private int f966l = 0;

    public g0(f fVar, com.google.android.gms.common.api.e<O> eVar) {
        Handler handler;
        Context context;
        Handler handler2;
        this.f967m = fVar;
        handler = fVar.f949p;
        a.f zab = eVar.zab(handler.getLooper(), this);
        this.f956b = zab;
        this.f957c = eVar.getApiKey();
        this.f958d = new w();
        this.f961g = eVar.zaa();
        if (!zab.requiresSignIn()) {
            this.f962h = null;
            return;
        }
        context = fVar.f940g;
        handler2 = fVar.f949p;
        this.f962h = eVar.zac(context, handler2);
    }

    public static /* bridge */ /* synthetic */ void B(g0 g0Var, i0 i0Var) {
        if (g0Var.f964j.contains(i0Var) && !g0Var.f963i) {
            if (g0Var.f956b.isConnected()) {
                g0Var.i();
            } else {
                g0Var.E();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void C(g0 g0Var, i0 i0Var) {
        Handler handler;
        Handler handler2;
        l0.c cVar;
        l0.c[] g5;
        if (g0Var.f964j.remove(i0Var)) {
            handler = g0Var.f967m.f949p;
            handler.removeMessages(15, i0Var);
            handler2 = g0Var.f967m.f949p;
            handler2.removeMessages(16, i0Var);
            cVar = i0Var.f972b;
            ArrayList arrayList = new ArrayList(g0Var.f955a.size());
            for (h1 h1Var : g0Var.f955a) {
                if ((h1Var instanceof p0) && (g5 = ((p0) h1Var).g(g0Var)) != null && q0.b.b(g5, cVar)) {
                    arrayList.add(h1Var);
                }
            }
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                h1 h1Var2 = (h1) arrayList.get(i5);
                g0Var.f955a.remove(h1Var2);
                h1Var2.b(new com.google.android.gms.common.api.l(cVar));
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean N(g0 g0Var, boolean z4) {
        return g0Var.q(false);
    }

    private final l0.c d(l0.c[] cVarArr) {
        if (cVarArr != null && cVarArr.length != 0) {
            l0.c[] availableFeatures = this.f956b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new l0.c[0];
            }
            androidx.collection.a aVar = new androidx.collection.a(availableFeatures.length);
            for (l0.c cVar : availableFeatures) {
                aVar.put(cVar.t(), Long.valueOf(cVar.u()));
            }
            for (l0.c cVar2 : cVarArr) {
                Long l5 = (Long) aVar.get(cVar2.t());
                if (l5 == null || l5.longValue() < cVar2.u()) {
                    return cVar2;
                }
            }
        }
        return null;
    }

    private final void e(l0.a aVar) {
        for (i1 i1Var : this.f959e) {
            i1Var.b(this.f957c, aVar, com.google.android.gms.common.internal.p.a(aVar, l0.a.f5864e) ? this.f956b.getEndpointPackageName() : null);
        }
        this.f959e.clear();
    }

    public final void g(Status status) {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        h(status, null, false);
    }

    private final void h(Status status, Exception exc, boolean z4) {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator<h1> it = this.f955a.iterator();
        while (it.hasNext()) {
            h1 next = it.next();
            if (!z4 || next.f970a == 2) {
                if (status != null) {
                    next.a(status);
                } else {
                    next.b(exc);
                }
                it.remove();
            }
        }
    }

    private final void i() {
        ArrayList arrayList = new ArrayList(this.f955a);
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            h1 h1Var = (h1) arrayList.get(i5);
            if (!this.f956b.isConnected()) {
                return;
            }
            if (o(h1Var)) {
                this.f955a.remove(h1Var);
            }
        }
    }

    public final void j() {
        D();
        e(l0.a.f5864e);
        n();
        Iterator<v0> it = this.f960f.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw null;
        }
        i();
        l();
    }

    public final void k(int i5) {
        Handler handler;
        Handler handler2;
        long j5;
        Handler handler3;
        Handler handler4;
        long j6;
        com.google.android.gms.common.internal.i0 i0Var;
        D();
        this.f963i = true;
        this.f958d.e(i5, this.f956b.getLastDisconnectMessage());
        f fVar = this.f967m;
        handler = fVar.f949p;
        handler2 = fVar.f949p;
        Message obtain = Message.obtain(handler2, 9, this.f957c);
        j5 = this.f967m.f934a;
        handler.sendMessageDelayed(obtain, j5);
        f fVar2 = this.f967m;
        handler3 = fVar2.f949p;
        handler4 = fVar2.f949p;
        Message obtain2 = Message.obtain(handler4, 11, this.f957c);
        j6 = this.f967m.f935b;
        handler3.sendMessageDelayed(obtain2, j6);
        i0Var = this.f967m.f942i;
        i0Var.c();
        for (v0 v0Var : this.f960f.values()) {
            v0Var.f1057a.run();
        }
    }

    private final void l() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        long j5;
        handler = this.f967m.f949p;
        handler.removeMessages(12, this.f957c);
        f fVar = this.f967m;
        handler2 = fVar.f949p;
        handler3 = fVar.f949p;
        Message obtainMessage = handler3.obtainMessage(12, this.f957c);
        j5 = this.f967m.f936c;
        handler2.sendMessageDelayed(obtainMessage, j5);
    }

    private final void m(h1 h1Var) {
        h1Var.d(this.f958d, P());
        try {
            h1Var.c(this);
        } catch (DeadObjectException unused) {
            a(1);
            this.f956b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void n() {
        Handler handler;
        Handler handler2;
        if (this.f963i) {
            handler = this.f967m.f949p;
            handler.removeMessages(11, this.f957c);
            handler2 = this.f967m.f949p;
            handler2.removeMessages(9, this.f957c);
            this.f963i = false;
        }
    }

    private final boolean o(h1 h1Var) {
        boolean z4;
        Handler handler;
        Handler handler2;
        long j5;
        Handler handler3;
        Handler handler4;
        long j6;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        long j7;
        if (!(h1Var instanceof p0)) {
            m(h1Var);
            return true;
        }
        p0 p0Var = (p0) h1Var;
        l0.c d5 = d(p0Var.g(this));
        if (d5 == null) {
            m(h1Var);
            return true;
        }
        String name = this.f956b.getClass().getName();
        String t5 = d5.t();
        long u5 = d5.u();
        StringBuilder sb = new StringBuilder(name.length() + 77 + String.valueOf(t5).length());
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(t5);
        sb.append(", ");
        sb.append(u5);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        z4 = this.f967m.f950q;
        if (!z4 || !p0Var.f(this)) {
            p0Var.b(new com.google.android.gms.common.api.l(d5));
            return true;
        }
        i0 i0Var = new i0(this.f957c, d5, null);
        int indexOf = this.f964j.indexOf(i0Var);
        if (indexOf >= 0) {
            i0 i0Var2 = this.f964j.get(indexOf);
            handler5 = this.f967m.f949p;
            handler5.removeMessages(15, i0Var2);
            f fVar = this.f967m;
            handler6 = fVar.f949p;
            handler7 = fVar.f949p;
            Message obtain = Message.obtain(handler7, 15, i0Var2);
            j7 = this.f967m.f934a;
            handler6.sendMessageDelayed(obtain, j7);
            return false;
        }
        this.f964j.add(i0Var);
        f fVar2 = this.f967m;
        handler = fVar2.f949p;
        handler2 = fVar2.f949p;
        Message obtain2 = Message.obtain(handler2, 15, i0Var);
        j5 = this.f967m.f934a;
        handler.sendMessageDelayed(obtain2, j5);
        f fVar3 = this.f967m;
        handler3 = fVar3.f949p;
        handler4 = fVar3.f949p;
        Message obtain3 = Message.obtain(handler4, 16, i0Var);
        j6 = this.f967m.f935b;
        handler3.sendMessageDelayed(obtain3, j6);
        l0.a aVar = new l0.a(2, null);
        if (p(aVar)) {
            return false;
        }
        this.f967m.g(aVar, this.f961g);
        return false;
    }

    private final boolean p(l0.a aVar) {
        Object obj;
        x xVar;
        Set set;
        x xVar2;
        obj = f.f932t;
        synchronized (obj) {
            f fVar = this.f967m;
            xVar = fVar.f946m;
            if (xVar != null) {
                set = fVar.f947n;
                if (set.contains(this.f957c)) {
                    xVar2 = this.f967m.f946m;
                    xVar2.h(aVar, this.f961g);
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean q(boolean z4) {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        if (this.f956b.isConnected() && this.f960f.size() == 0) {
            if (!this.f958d.g()) {
                this.f956b.disconnect("Timing out service connection.");
                return true;
            }
            if (z4) {
                l();
            }
            return false;
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ b w(g0 g0Var) {
        return g0Var.f957c;
    }

    public static /* bridge */ /* synthetic */ void y(g0 g0Var, Status status) {
        g0Var.g(status);
    }

    public final void D() {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        this.f965k = null;
    }

    public final void E() {
        Handler handler;
        l0.a aVar;
        com.google.android.gms.common.internal.i0 i0Var;
        Context context;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        if (this.f956b.isConnected() || this.f956b.isConnecting()) {
            return;
        }
        try {
            f fVar = this.f967m;
            i0Var = fVar.f942i;
            context = fVar.f940g;
            int b5 = i0Var.b(context, this.f956b);
            if (b5 != 0) {
                l0.a aVar2 = new l0.a(b5, null);
                String name = this.f956b.getClass().getName();
                String obj = aVar2.toString();
                StringBuilder sb = new StringBuilder(name.length() + 35 + obj.length());
                sb.append("The service for ");
                sb.append(name);
                sb.append(" is not available: ");
                sb.append(obj);
                Log.w("GoogleApiManager", sb.toString());
                H(aVar2, null);
                return;
            }
            f fVar2 = this.f967m;
            a.f fVar3 = this.f956b;
            k0 k0Var = new k0(fVar2, fVar3, this.f957c);
            if (fVar3.requiresSignIn()) {
                ((z0) com.google.android.gms.common.internal.q.k(this.f962h)).n(k0Var);
            }
            try {
                this.f956b.connect(k0Var);
            } catch (SecurityException e5) {
                e = e5;
                aVar = new l0.a(10);
                H(aVar, e);
            }
        } catch (IllegalStateException e6) {
            e = e6;
            aVar = new l0.a(10);
        }
    }

    public final void F(h1 h1Var) {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        if (this.f956b.isConnected()) {
            if (o(h1Var)) {
                l();
                return;
            } else {
                this.f955a.add(h1Var);
                return;
            }
        }
        this.f955a.add(h1Var);
        l0.a aVar = this.f965k;
        if (aVar == null || !aVar.w()) {
            E();
        } else {
            H(this.f965k, null);
        }
    }

    public final void G() {
        this.f966l++;
    }

    public final void H(l0.a aVar, Exception exc) {
        Handler handler;
        com.google.android.gms.common.internal.i0 i0Var;
        boolean z4;
        Status h5;
        Status h6;
        Status h7;
        Handler handler2;
        Handler handler3;
        long j5;
        Handler handler4;
        Status status;
        Handler handler5;
        Handler handler6;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        z0 z0Var = this.f962h;
        if (z0Var != null) {
            z0Var.o();
        }
        D();
        i0Var = this.f967m.f942i;
        i0Var.c();
        e(aVar);
        if ((this.f956b instanceof n0.e) && aVar.t() != 24) {
            this.f967m.f937d = true;
            f fVar = this.f967m;
            handler5 = fVar.f949p;
            handler6 = fVar.f949p;
            handler5.sendMessageDelayed(handler6.obtainMessage(19), 300000L);
        }
        if (aVar.t() == 4) {
            status = f.f931s;
            g(status);
        } else if (this.f955a.isEmpty()) {
            this.f965k = aVar;
        } else if (exc != null) {
            handler4 = this.f967m.f949p;
            com.google.android.gms.common.internal.q.d(handler4);
            h(null, exc, false);
        } else {
            z4 = this.f967m.f950q;
            if (!z4) {
                h5 = f.h(this.f957c, aVar);
                g(h5);
                return;
            }
            h6 = f.h(this.f957c, aVar);
            h(h6, null, true);
            if (this.f955a.isEmpty() || p(aVar) || this.f967m.g(aVar, this.f961g)) {
                return;
            }
            if (aVar.t() == 18) {
                this.f963i = true;
            }
            if (!this.f963i) {
                h7 = f.h(this.f957c, aVar);
                g(h7);
                return;
            }
            f fVar2 = this.f967m;
            handler2 = fVar2.f949p;
            handler3 = fVar2.f949p;
            Message obtain = Message.obtain(handler3, 9, this.f957c);
            j5 = this.f967m.f934a;
            handler2.sendMessageDelayed(obtain, j5);
        }
    }

    public final void I(l0.a aVar) {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        a.f fVar = this.f956b;
        String name = fVar.getClass().getName();
        String valueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(name.length() + 25 + valueOf.length());
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(valueOf);
        fVar.disconnect(sb.toString());
        H(aVar, null);
    }

    public final void J(i1 i1Var) {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        this.f959e.add(i1Var);
    }

    public final void K() {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        if (this.f963i) {
            E();
        }
    }

    public final void L() {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        g(f.f930r);
        this.f958d.f();
        for (j.a aVar : (j.a[]) this.f960f.keySet().toArray(new j.a[0])) {
            F(new g1(aVar, new TaskCompletionSource()));
        }
        e(new l0.a(4));
        if (this.f956b.isConnected()) {
            this.f956b.onUserSignOut(new f0(this));
        }
    }

    public final void M() {
        Handler handler;
        l0.f fVar;
        Context context;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        if (this.f963i) {
            n();
            f fVar2 = this.f967m;
            fVar = fVar2.f941h;
            context = fVar2.f940g;
            g(fVar.f(context) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f956b.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean O() {
        return this.f956b.isConnected();
    }

    public final boolean P() {
        return this.f956b.requiresSignIn();
    }

    @Override // com.google.android.gms.common.api.internal.e
    public final void a(int i5) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f967m.f949p;
        if (myLooper == handler.getLooper()) {
            k(i5);
            return;
        }
        handler2 = this.f967m.f949p;
        handler2.post(new d0(this, i5));
    }

    @Override // com.google.android.gms.common.api.internal.m
    public final void b(l0.a aVar) {
        H(aVar, null);
    }

    public final boolean c() {
        return q(true);
    }

    @Override // com.google.android.gms.common.api.internal.e
    public final void f(Bundle bundle) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f967m.f949p;
        if (myLooper == handler.getLooper()) {
            j();
            return;
        }
        handler2 = this.f967m.f949p;
        handler2.post(new c0(this));
    }

    public final int r() {
        return this.f961g;
    }

    public final int s() {
        return this.f966l;
    }

    public final l0.a t() {
        Handler handler;
        handler = this.f967m.f949p;
        com.google.android.gms.common.internal.q.d(handler);
        return this.f965k;
    }

    public final a.f v() {
        return this.f956b;
    }

    public final Map<j.a<?>, v0> x() {
        return this.f960f;
    }
}
