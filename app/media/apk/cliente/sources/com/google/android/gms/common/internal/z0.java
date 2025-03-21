package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.c;
/* loaded from: classes.dex */
public final class z0 extends o0 {

    /* renamed from: g  reason: collision with root package name */
    public final IBinder f1218g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ c f1219h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(c cVar, int i5, IBinder iBinder, Bundle bundle) {
        super(cVar, i5, bundle);
        this.f1219h = cVar;
        this.f1218g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.o0
    protected final void f(l0.a aVar) {
        if (this.f1219h.zzx != null) {
            this.f1219h.zzx.b(aVar);
        }
        this.f1219h.onConnectionFailed(aVar);
    }

    @Override // com.google.android.gms.common.internal.o0
    protected final boolean g() {
        String str;
        String interfaceDescriptor;
        c.a aVar;
        c.a aVar2;
        try {
            IBinder iBinder = this.f1218g;
            q.k(iBinder);
            interfaceDescriptor = iBinder.getInterfaceDescriptor();
        } catch (RemoteException unused) {
            str = "service probably died";
        }
        if (!this.f1219h.getServiceDescriptor().equals(interfaceDescriptor)) {
            str = "service descriptor mismatch: " + this.f1219h.getServiceDescriptor() + " vs. " + interfaceDescriptor;
            Log.w("GmsClient", str);
            return false;
        }
        IInterface createServiceInterface = this.f1219h.createServiceInterface(this.f1218g);
        if (createServiceInterface == null || !(c.zzn(this.f1219h, 2, 4, createServiceInterface) || c.zzn(this.f1219h, 3, 4, createServiceInterface))) {
            return false;
        }
        this.f1219h.zzB = null;
        c cVar = this.f1219h;
        Bundle connectionHint = cVar.getConnectionHint();
        aVar = cVar.zzw;
        if (aVar != null) {
            aVar2 = this.f1219h.zzw;
            aVar2.f(connectionHint);
            return true;
        }
        return true;
    }
}
