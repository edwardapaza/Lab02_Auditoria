package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
final class h1 implements ServiceConnection, l1 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f1141a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f1142b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1143c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f1144d;

    /* renamed from: e  reason: collision with root package name */
    private final f1 f1145e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f1146f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ k1 f1147g;

    public h1(k1 k1Var, f1 f1Var) {
        this.f1147g = k1Var;
        this.f1145e = f1Var;
    }

    public final int a() {
        return this.f1142b;
    }

    public final ComponentName b() {
        return this.f1146f;
    }

    public final IBinder c() {
        return this.f1144d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f1141a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        p0.b bVar;
        Context context;
        Context context2;
        p0.b bVar2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j5;
        StrictMode.VmPolicy.Builder permitUnsafeIntentLaunch;
        this.f1142b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (q0.j.j()) {
            permitUnsafeIntentLaunch = new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch();
            StrictMode.setVmPolicy(permitUnsafeIntentLaunch.build());
        }
        try {
            k1 k1Var = this.f1147g;
            bVar = k1Var.f1161j;
            context = k1Var.f1158g;
            f1 f1Var = this.f1145e;
            context2 = k1Var.f1158g;
            boolean c5 = bVar.c(context, str, f1Var.b(context2), this, 4225, executor);
            this.f1143c = c5;
            if (c5) {
                handler = this.f1147g.f1159h;
                Message obtainMessage = handler.obtainMessage(1, this.f1145e);
                handler2 = this.f1147g.f1159h;
                j5 = this.f1147g.f1163l;
                handler2.sendMessageDelayed(obtainMessage, j5);
            } else {
                this.f1142b = 2;
                try {
                    k1 k1Var2 = this.f1147g;
                    bVar2 = k1Var2.f1161j;
                    context3 = k1Var2.f1158g;
                    bVar2.b(context3, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f1141a.remove(serviceConnection);
    }

    public final void g(String str) {
        Handler handler;
        p0.b bVar;
        Context context;
        f1 f1Var = this.f1145e;
        handler = this.f1147g.f1159h;
        handler.removeMessages(1, f1Var);
        k1 k1Var = this.f1147g;
        bVar = k1Var.f1161j;
        context = k1Var.f1158g;
        bVar.b(context, this);
        this.f1143c = false;
        this.f1142b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f1141a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f1141a.isEmpty();
    }

    public final boolean j() {
        return this.f1143c;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f1147g.f1157f;
        synchronized (hashMap) {
            handler = this.f1147g.f1159h;
            handler.removeMessages(1, this.f1145e);
            this.f1144d = iBinder;
            this.f1146f = componentName;
            for (ServiceConnection serviceConnection : this.f1141a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f1142b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f1147g.f1157f;
        synchronized (hashMap) {
            handler = this.f1147g.f1159h;
            handler.removeMessages(1, this.f1145e);
            this.f1144d = null;
            this.f1146f = componentName;
            for (ServiceConnection serviceConnection : this.f1141a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f1142b = 2;
        }
    }
}
