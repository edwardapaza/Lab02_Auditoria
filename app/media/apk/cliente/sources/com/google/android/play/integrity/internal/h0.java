package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h0 extends d0 {

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ d f1365k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(d dVar) {
        this.f1365k = dVar;
    }

    @Override // com.google.android.play.integrity.internal.d0
    public final void b() {
        Object obj;
        AtomicInteger atomicInteger;
        IInterface iInterface;
        c0 c0Var;
        Context context;
        ServiceConnection serviceConnection;
        AtomicInteger atomicInteger2;
        c0 c0Var2;
        obj = this.f1365k.f1348f;
        synchronized (obj) {
            atomicInteger = this.f1365k.f1354l;
            if (atomicInteger.get() > 0) {
                atomicInteger2 = this.f1365k.f1354l;
                if (atomicInteger2.decrementAndGet() > 0) {
                    c0Var2 = this.f1365k.f1344b;
                    c0Var2.c("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
            }
            d dVar = this.f1365k;
            iInterface = dVar.f1356n;
            if (iInterface != null) {
                c0Var = dVar.f1344b;
                c0Var.c("Unbind from service.", new Object[0]);
                d dVar2 = this.f1365k;
                context = dVar2.f1343a;
                serviceConnection = dVar2.f1355m;
                context.unbindService(serviceConnection);
                this.f1365k.f1349g = false;
                this.f1365k.f1356n = null;
                this.f1365k.f1355m = null;
            }
            this.f1365k.x();
        }
    }
}
