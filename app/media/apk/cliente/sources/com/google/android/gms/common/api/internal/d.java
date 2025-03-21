package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.j;
/* loaded from: classes.dex */
public abstract class d<R extends com.google.android.gms.common.api.j, A extends a.b> extends BasePendingResult<R> {
    private void n(RemoteException remoteException) {
        o(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
    }

    protected abstract void k(A a5);

    protected void l(R r5) {
    }

    public final void m(A a5) {
        try {
            k(a5);
        } catch (DeadObjectException e5) {
            n(e5);
            throw e5;
        } catch (RemoteException e6) {
            n(e6);
        }
    }

    public final void o(Status status) {
        com.google.android.gms.common.internal.q.b(!status.x(), "Failed result must not be success");
        R b5 = b(status);
        e(b5);
        l(b5);
    }
}
