package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {

    /* renamed from: b  reason: collision with root package name */
    private SidecarDeviceState f706b;

    /* renamed from: d  reason: collision with root package name */
    private final f0.a f708d;

    /* renamed from: e  reason: collision with root package name */
    private final SidecarInterface.SidecarCallback f709e;

    /* renamed from: a  reason: collision with root package name */
    private final Object f705a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Map<IBinder, SidecarWindowLayoutInfo> f707c = new WeakHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DistinctElementSidecarCallback(f0.a aVar, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f708d = aVar;
        this.f709e = sidecarCallback;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.f705a) {
            if (this.f708d.a(this.f706b, sidecarDeviceState)) {
                return;
            }
            this.f706b = sidecarDeviceState;
            this.f709e.onDeviceStateChanged(sidecarDeviceState);
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.f705a) {
            if (this.f708d.d(this.f707c.get(iBinder), sidecarWindowLayoutInfo)) {
                return;
            }
            this.f707c.put(iBinder, sidecarWindowLayoutInfo);
            this.f709e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
        }
    }
}
