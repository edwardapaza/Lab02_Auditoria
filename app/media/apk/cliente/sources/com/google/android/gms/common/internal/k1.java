package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k1 extends h {

    /* renamed from: f  reason: collision with root package name */
    private final HashMap f1157f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Context f1158g;

    /* renamed from: h  reason: collision with root package name */
    private volatile Handler f1159h;

    /* renamed from: i  reason: collision with root package name */
    private final j1 f1160i;

    /* renamed from: j  reason: collision with root package name */
    private final p0.b f1161j;

    /* renamed from: k  reason: collision with root package name */
    private final long f1162k;

    /* renamed from: l  reason: collision with root package name */
    private final long f1163l;

    /* renamed from: m  reason: collision with root package name */
    private volatile Executor f1164m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k1(Context context, Looper looper, Executor executor) {
        j1 j1Var = new j1(this, null);
        this.f1160i = j1Var;
        this.f1158g = context.getApplicationContext();
        this.f1159h = new zzi(looper, j1Var);
        this.f1161j = p0.b.a();
        this.f1162k = 5000L;
        this.f1163l = 300000L;
        this.f1164m = executor;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final void d(f1 f1Var, ServiceConnection serviceConnection, String str) {
        q.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1157f) {
            h1 h1Var = (h1) this.f1157f.get(f1Var);
            if (h1Var == null) {
                String obj = f1Var.toString();
                throw new IllegalStateException("Nonexistent connection status for service config: " + obj);
            } else if (!h1Var.h(serviceConnection)) {
                String obj2 = f1Var.toString();
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj2);
            } else {
                h1Var.f(serviceConnection, str);
                if (h1Var.i()) {
                    this.f1159h.sendMessageDelayed(this.f1159h.obtainMessage(0, f1Var), this.f1162k);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.h
    public final boolean f(f1 f1Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j5;
        q.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1157f) {
            h1 h1Var = (h1) this.f1157f.get(f1Var);
            if (executor == null) {
                executor = this.f1164m;
            }
            if (h1Var == null) {
                h1Var = new h1(this, f1Var);
                h1Var.d(serviceConnection, serviceConnection, str);
                h1Var.e(str, executor);
                this.f1157f.put(f1Var, h1Var);
            } else {
                this.f1159h.removeMessages(0, f1Var);
                if (h1Var.h(serviceConnection)) {
                    String obj = f1Var.toString();
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + obj);
                }
                h1Var.d(serviceConnection, serviceConnection, str);
                int a5 = h1Var.a();
                if (a5 == 1) {
                    serviceConnection.onServiceConnected(h1Var.b(), h1Var.c());
                } else if (a5 == 2) {
                    h1Var.e(str, executor);
                }
            }
            j5 = h1Var.j();
        }
        return j5;
    }
}
