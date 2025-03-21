package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1340a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(d dVar, b bVar) {
        this.f1340a = dVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d.f(this.f1340a).c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f1340a.c().post(new k0(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        d.f(this.f1340a).c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f1340a.c().post(new l0(this));
    }
}
