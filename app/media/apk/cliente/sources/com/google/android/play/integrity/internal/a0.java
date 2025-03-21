package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;
/* loaded from: classes.dex */
public abstract class a0 extends n implements b0 {
    public a0() {
        super("com.google.android.play.core.integrity.protocol.IIntegrityServiceCallback");
    }

    @Override // com.google.android.play.integrity.internal.n
    protected final boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 2) {
            o.b(parcel);
            b((Bundle) o.a(parcel, Bundle.CREATOR));
            return true;
        }
        return false;
    }
}
