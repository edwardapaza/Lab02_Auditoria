package com.google.android.play.integrity.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public class n extends Binder implements IInterface {
    /* JADX INFO: Access modifiers changed from: protected */
    public n(String str) {
        attachInterface(this, str);
    }

    protected boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        throw null;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i5, parcel, parcel2, i6)) {
            return true;
        }
        return a(i5, parcel, parcel2, i6);
    }
}
