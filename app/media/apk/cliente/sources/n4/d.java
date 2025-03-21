package n4;

import android.os.Handler;
import android.os.Looper;
import e4.g;
import e4.k;
import h4.l;
import java.util.concurrent.CancellationException;
import m4.b1;
import m4.h2;
import m4.y1;
import m4.z0;
/* loaded from: classes.dex */
public final class d extends e {
    private volatile d _immediate;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f6343c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6344d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6345e;

    /* renamed from: f  reason: collision with root package name */
    private final d f6346f;

    public d(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ d(Handler handler, String str, int i5, g gVar) {
        this(handler, (i5 & 2) != 0 ? null : str);
    }

    private d(Handler handler, String str, boolean z4) {
        super(null);
        this.f6343c = handler;
        this.f6344d = str;
        this.f6345e = z4;
        this._immediate = z4 ? this : null;
        d dVar = this._immediate;
        if (dVar == null) {
            dVar = new d(handler, str, true);
            this._immediate = dVar;
        }
        this.f6346f = dVar;
    }

    private final void l0(v3.g gVar, Runnable runnable) {
        y1.c(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        z0.b().f0(gVar, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(d dVar, Runnable runnable) {
        dVar.f6343c.removeCallbacks(runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).f6343c == this.f6343c;
    }

    @Override // m4.g0
    public void f0(v3.g gVar, Runnable runnable) {
        if (this.f6343c.post(runnable)) {
            return;
        }
        l0(gVar, runnable);
    }

    @Override // m4.g0
    public boolean g0(v3.g gVar) {
        return (this.f6345e && k.a(Looper.myLooper(), this.f6343c.getLooper())) ? false : true;
    }

    public int hashCode() {
        return System.identityHashCode(this.f6343c);
    }

    @Override // n4.e, m4.s0
    public b1 l(long j5, final Runnable runnable, v3.g gVar) {
        long d5;
        Handler handler = this.f6343c;
        d5 = l.d(j5, 4611686018427387903L);
        if (handler.postDelayed(runnable, d5)) {
            return new b1() { // from class: n4.c
                @Override // m4.b1
                public final void a() {
                    d.n0(d.this, runnable);
                }
            };
        }
        l0(gVar, runnable);
        return h2.f6244a;
    }

    @Override // m4.f2
    /* renamed from: m0 */
    public d i0() {
        return this.f6346f;
    }

    @Override // m4.f2, m4.g0
    public String toString() {
        String j02 = j0();
        if (j02 == null) {
            String str = this.f6344d;
            if (str == null) {
                str = this.f6343c.toString();
            }
            if (this.f6345e) {
                return str + ".immediate";
            }
            return str;
        }
        return j02;
    }
}
