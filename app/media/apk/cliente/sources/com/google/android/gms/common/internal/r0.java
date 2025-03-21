package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
final class r0 implements m {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(IBinder iBinder) {
        this.f1193a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1193a;
    }

    @Override // com.google.android.gms.common.internal.m
    public final void d(l lVar, f fVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
            if (fVar != null) {
                obtain.writeInt(1);
                e1.a(fVar, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f1193a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
