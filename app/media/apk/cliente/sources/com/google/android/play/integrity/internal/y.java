package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class y extends n implements z {
    public static z b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IIntegrityService");
        return queryLocalInterface instanceof z ? (z) queryLocalInterface : new x(iBinder);
    }
}
