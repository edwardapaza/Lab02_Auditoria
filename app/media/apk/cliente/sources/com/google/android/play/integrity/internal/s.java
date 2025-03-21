package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class s extends a implements u {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.integrity.internal.u
    public final void c(Bundle bundle, w wVar) {
        Parcel a5 = a();
        o.c(a5, bundle);
        a5.writeStrongBinder(wVar);
        b(2, a5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.integrity.internal.u
    public final void g(Bundle bundle, w wVar) {
        Parcel a5 = a();
        o.c(a5, bundle);
        a5.writeStrongBinder(wVar);
        b(3, a5);
    }
}
