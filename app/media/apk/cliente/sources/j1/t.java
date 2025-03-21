package j1;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.internal.p001firebaseauthapi.zzg;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: h  reason: collision with root package name */
    private static o0.a f5474h = new o0.a("TokenRefresher", "FirebaseAuth:");

    /* renamed from: a  reason: collision with root package name */
    private final f1.f f5475a;

    /* renamed from: b  reason: collision with root package name */
    volatile long f5476b;

    /* renamed from: c  reason: collision with root package name */
    volatile long f5477c;

    /* renamed from: d  reason: collision with root package name */
    private long f5478d;

    /* renamed from: e  reason: collision with root package name */
    private HandlerThread f5479e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f5480f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f5481g;

    public t(f1.f fVar) {
        f5474h.g("Initializing TokenRefresher", new Object[0]);
        f1.f fVar2 = (f1.f) com.google.android.gms.common.internal.q.k(fVar);
        this.f5475a = fVar2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.f5479e = handlerThread;
        handlerThread.start();
        this.f5480f = new zzg(this.f5479e.getLooper());
        this.f5481g = new w(this, fVar2.q());
        this.f5478d = 300000L;
    }

    public final void b() {
        this.f5480f.removeCallbacks(this.f5481g);
    }

    public final void c() {
        o0.a aVar = f5474h;
        long j5 = this.f5476b - this.f5478d;
        aVar.g("Scheduling refresh for " + j5, new Object[0]);
        b();
        this.f5477c = Math.max((this.f5476b - q0.f.b().a()) - this.f5478d, 0L) / 1000;
        this.f5480f.postDelayed(this.f5481g, this.f5477c * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        int i5 = (int) this.f5477c;
        this.f5477c = (i5 == 30 || i5 == 60 || i5 == 120 || i5 == 240 || i5 == 480) ? 2 * this.f5477c : i5 != 960 ? 30L : 960L;
        this.f5476b = q0.f.b().a() + (this.f5477c * 1000);
        o0.a aVar = f5474h;
        long j5 = this.f5476b;
        aVar.g("Scheduling refresh for " + j5, new Object[0]);
        this.f5480f.postDelayed(this.f5481g, this.f5477c * 1000);
    }
}
