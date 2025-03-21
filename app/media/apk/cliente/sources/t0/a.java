package t0;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.zzb;
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: t0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0115a extends zzb implements a {
        public AbstractBinderC0115a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new c(iBinder);
        }
    }
}
