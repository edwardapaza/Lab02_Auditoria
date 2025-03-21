package y1;

import i3.j1;
import java.util.Locale;
import z1.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m0 {

    /* renamed from: b  reason: collision with root package name */
    private int f8440b;

    /* renamed from: c  reason: collision with root package name */
    private g.b f8441c;

    /* renamed from: e  reason: collision with root package name */
    private final z1.g f8443e;

    /* renamed from: f  reason: collision with root package name */
    private final a f8444f;

    /* renamed from: a  reason: collision with root package name */
    private s1.y0 f8439a = s1.y0.UNKNOWN;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8442d = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(s1.y0 y0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(z1.g gVar, a aVar) {
        this.f8443e = gVar;
        this.f8444f = aVar;
    }

    private void b() {
        g.b bVar = this.f8441c;
        if (bVar != null) {
            bVar.c();
            this.f8441c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f8441c = null;
        z1.b.d(this.f8439a == s1.y0.UNKNOWN, "Timer should be canceled if we transitioned to a different state.", new Object[0]);
        g(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", 10));
        h(s1.y0.OFFLINE);
    }

    private void g(String str) {
        String format = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", str);
        Object[] objArr = new Object[1];
        if (!this.f8442d) {
            objArr[0] = format;
            z1.w.a("OnlineStateTracker", "%s", objArr);
            return;
        }
        objArr[0] = format;
        z1.w.e("OnlineStateTracker", "%s", objArr);
        this.f8442d = false;
    }

    private void h(s1.y0 y0Var) {
        if (y0Var != this.f8439a) {
            this.f8439a = y0Var;
            this.f8444f.a(y0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s1.y0 c() {
        return this.f8439a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(j1 j1Var) {
        if (this.f8439a == s1.y0.ONLINE) {
            h(s1.y0.UNKNOWN);
            z1.b.d(this.f8440b == 0, "watchStreamFailures must be 0", new Object[0]);
            z1.b.d(this.f8441c == null, "onlineStateTimer must be null", new Object[0]);
            return;
        }
        int i5 = this.f8440b + 1;
        this.f8440b = i5;
        if (i5 >= 1) {
            b();
            g(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", 1, j1Var));
            h(s1.y0.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f8440b == 0) {
            h(s1.y0.UNKNOWN);
            z1.b.d(this.f8441c == null, "onlineStateTimer shouldn't be started yet", new Object[0]);
            this.f8441c = this.f8443e.k(g.d.ONLINE_STATE_TIMEOUT, 10000L, new Runnable() { // from class: y1.l0
                @Override // java.lang.Runnable
                public final void run() {
                    m0.this.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(s1.y0 y0Var) {
        b();
        this.f8440b = 0;
        if (y0Var == s1.y0.ONLINE) {
            this.f8442d = false;
        }
        h(y0Var);
    }
}
