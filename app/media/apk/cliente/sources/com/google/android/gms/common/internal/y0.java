package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public final class y0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final int f1216a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f1217b;

    public y0(c cVar, int i5) {
        this.f1217b = cVar;
        this.f1216a = i5;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        c cVar = this.f1217b;
        if (iBinder == null) {
            c.zzk(cVar, 16);
            return;
        }
        obj = cVar.zzq;
        synchronized (obj) {
            c cVar2 = this.f1217b;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            cVar2.zzr = (queryLocalInterface == null || !(queryLocalInterface instanceof m)) ? new r0(iBinder) : (m) queryLocalInterface;
        }
        this.f1217b.zzl(0, null, this.f1216a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.f1217b.zzq;
        synchronized (obj) {
            this.f1217b.zzr = null;
        }
        c cVar = this.f1217b;
        int i5 = this.f1216a;
        Handler handler = cVar.zzb;
        handler.sendMessage(handler.obtainMessage(6, i5, 1));
    }
}
