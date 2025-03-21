package x0;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;
/* loaded from: classes.dex */
public final class g extends zaa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void a(j jVar, f fVar) {
        Parcel zaa = zaa();
        zac.zac(zaa, jVar);
        zac.zad(zaa, fVar);
        zac(12, zaa);
    }
}
