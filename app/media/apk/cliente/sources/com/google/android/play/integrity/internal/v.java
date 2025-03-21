package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;
/* loaded from: classes.dex */
public abstract class v extends n implements w {
    public v() {
        super("com.google.android.play.core.integrity.protocol.IExpressIntegrityServiceCallback");
    }

    @Override // com.google.android.play.integrity.internal.n
    protected final boolean a(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 2) {
            o.b(parcel);
            e((Bundle) o.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i5 == 3) {
            o.b(parcel);
            c((Bundle) o.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i5 == 4) {
            o.b(parcel);
            d((Bundle) o.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i5 != 5) {
            return false;
        } else {
            o.b(parcel);
            b((Bundle) o.a(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
