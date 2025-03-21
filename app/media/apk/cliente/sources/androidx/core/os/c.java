package androidx.core.os;

import android.os.CancellationSignal;
@Deprecated
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f422a;

    /* renamed from: b  reason: collision with root package name */
    private a f423b;

    /* renamed from: c  reason: collision with root package name */
    private Object f424c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f425d;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    public void a() {
        synchronized (this) {
            if (this.f422a) {
                return;
            }
            this.f422a = true;
            this.f425d = true;
            a aVar = this.f423b;
            Object obj = this.f424c;
            if (aVar != null) {
                try {
                    aVar.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f425d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f425d = false;
                notifyAll();
            }
        }
    }
}
