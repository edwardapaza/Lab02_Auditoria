package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
public final class l implements a.f, ServiceConnection {

    /* renamed from: l  reason: collision with root package name */
    private static final String f995l = l.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final String f996a;

    /* renamed from: b  reason: collision with root package name */
    private final String f997b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f998c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f999d;

    /* renamed from: e  reason: collision with root package name */
    private final e f1000e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f1001f;

    /* renamed from: g  reason: collision with root package name */
    private final m f1002g;

    /* renamed from: h  reason: collision with root package name */
    private IBinder f1003h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1004i;

    /* renamed from: j  reason: collision with root package name */
    private String f1005j;

    /* renamed from: k  reason: collision with root package name */
    private String f1006k;

    private final void e() {
        if (Thread.currentThread() != this.f1001f.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    private final void f(String str) {
        String.valueOf(this.f1003h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.f1004i = false;
        this.f1003h = null;
        f("Disconnected.");
        this.f1000e.a(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(IBinder iBinder) {
        this.f1004i = false;
        this.f1003h = iBinder;
        f("Connected.");
        this.f1000e.f(new Bundle());
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void connect(c.InterfaceC0039c interfaceC0039c) {
        e();
        f("Connect started.");
        if (isConnected()) {
            try {
                disconnect("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f998c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f996a).setAction(this.f997b);
            }
            boolean bindService = this.f999d.bindService(intent, this, com.google.android.gms.common.internal.h.a());
            this.f1004i = bindService;
            if (!bindService) {
                this.f1003h = null;
                this.f1002g.b(new l0.a(16));
            }
            f("Finished connect.");
        } catch (SecurityException e5) {
            this.f1004i = false;
            this.f1003h = null;
            throw e5;
        }
    }

    public final void d(String str) {
        this.f1006k = str;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void disconnect() {
        e();
        f("Disconnect called.");
        try {
            this.f999d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f1004i = false;
        this.f1003h = null;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void disconnect(String str) {
        e();
        this.f1005j = str;
        disconnect();
    }

    @Override // com.google.android.gms.common.api.a.f
    public final l0.c[] getAvailableFeatures() {
        return new l0.c[0];
    }

    @Override // com.google.android.gms.common.api.a.f
    public final String getEndpointPackageName() {
        String str = this.f996a;
        if (str != null) {
            return str;
        }
        com.google.android.gms.common.internal.q.k(this.f998c);
        return this.f998c.getPackageName();
    }

    @Override // com.google.android.gms.common.api.a.f
    public final String getLastDisconnectMessage() {
        return this.f1005j;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void getRemoteService(com.google.android.gms.common.internal.j jVar, Set<Scope> set) {
    }

    @Override // com.google.android.gms.common.api.a.f
    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean isConnected() {
        e();
        return this.f1003h != null;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean isConnecting() {
        e();
        return this.f1004i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        this.f1001f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.t0
            @Override // java.lang.Runnable
            public final void run() {
                l.this.c(iBinder);
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f1001f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.s0
            @Override // java.lang.Runnable
            public final void run() {
                l.this.a();
            }
        });
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void onUserSignOut(c.e eVar) {
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean requiresGooglePlayServices() {
        return false;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean requiresSignIn() {
        return false;
    }
}
