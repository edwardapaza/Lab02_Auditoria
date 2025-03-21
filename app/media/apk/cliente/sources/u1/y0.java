package u1;

import java.util.HashMap;
import java.util.Map;
import u1.o0;
/* loaded from: classes.dex */
public final class y0 extends e1 {

    /* renamed from: i  reason: collision with root package name */
    private j1 f8061i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8062j;

    /* renamed from: c  reason: collision with root package name */
    private final Map<q1.j, w0> f8055c = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final t0 f8057e = new t0();

    /* renamed from: f  reason: collision with root package name */
    private final a1 f8058f = new a1(this);

    /* renamed from: g  reason: collision with root package name */
    private final q0 f8059g = new q0();

    /* renamed from: h  reason: collision with root package name */
    private final z0 f8060h = new z0();

    /* renamed from: d  reason: collision with root package name */
    private final Map<q1.j, r0> f8056d = new HashMap();

    private y0() {
    }

    public static y0 n() {
        y0 y0Var = new y0();
        y0Var.t(new s0(y0Var));
        return y0Var;
    }

    public static y0 o(o0.b bVar, o oVar) {
        y0 y0Var = new y0();
        y0Var.t(new v0(y0Var, bVar, oVar));
        return y0Var;
    }

    private void t(j1 j1Var) {
        this.f8061i = j1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public a a() {
        return this.f8059g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public b b(q1.j jVar) {
        r0 r0Var = this.f8056d.get(jVar);
        if (r0Var == null) {
            r0 r0Var2 = new r0();
            this.f8056d.put(jVar, r0Var2);
            return r0Var2;
        }
        return r0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public b1 d(q1.j jVar, l lVar) {
        w0 w0Var = this.f8055c.get(jVar);
        if (w0Var == null) {
            w0 w0Var2 = new w0(this, jVar);
            this.f8055c.put(jVar, w0Var2);
            return w0Var2;
        }
        return w0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public c1 e() {
        return new x0();
    }

    @Override // u1.e1
    public j1 f() {
        return this.f8061i;
    }

    @Override // u1.e1
    public boolean i() {
        return this.f8062j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public <T> T j(String str, z1.z<T> zVar) {
        this.f8061i.i();
        try {
            return zVar.get();
        } finally {
            this.f8061i.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    public void k(String str, Runnable runnable) {
        this.f8061i.i();
        try {
            runnable.run();
        } finally {
            this.f8061i.f();
        }
    }

    @Override // u1.e1
    public void l() {
        z1.b.d(this.f8062j, "MemoryPersistence shutdown without start", new Object[0]);
        this.f8062j = false;
    }

    @Override // u1.e1
    public void m() {
        z1.b.d(!this.f8062j, "MemoryPersistence double-started!", new Object[0]);
        this.f8062j = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    /* renamed from: p */
    public t0 c(q1.j jVar) {
        return this.f8057e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterable<w0> q() {
        return this.f8055c.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    /* renamed from: r */
    public z0 g() {
        return this.f8060h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u1.e1
    /* renamed from: s */
    public a1 h() {
        return this.f8058f;
    }
}
