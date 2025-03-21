package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1338a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1339b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.f1338a = iBinder;
        this.f1339b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1339b);
        return obtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1338a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i5, Parcel parcel) {
        try {
            this.f1338a.transact(i5, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
