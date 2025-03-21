package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f255a = (IconCompat) aVar.v(remoteActionCompat.f255a, 1);
        remoteActionCompat.f256b = aVar.l(remoteActionCompat.f256b, 2);
        remoteActionCompat.f257c = aVar.l(remoteActionCompat.f257c, 3);
        remoteActionCompat.f258d = (PendingIntent) aVar.r(remoteActionCompat.f258d, 4);
        remoteActionCompat.f259e = aVar.h(remoteActionCompat.f259e, 5);
        remoteActionCompat.f260f = aVar.h(remoteActionCompat.f260f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f255a, 1);
        aVar.D(remoteActionCompat.f256b, 2);
        aVar.D(remoteActionCompat.f257c, 3);
        aVar.H(remoteActionCompat.f258d, 4);
        aVar.z(remoteActionCompat.f259e, 5);
        aVar.z(remoteActionCompat.f260f, 6);
    }
}
