package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class x extends a implements z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public x(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.integrity.internal.z
    public final void e(Bundle bundle, b0 b0Var) {
        Parcel a5 = a();
        o.c(a5, bundle);
        a5.writeStrongBinder(b0Var);
        b(2, a5);
    }
}
