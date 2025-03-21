package t4;

import m4.n0;
/* loaded from: classes.dex */
public final class k extends h {

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f7688c;

    public k(Runnable runnable, long j5, i iVar) {
        super(j5, iVar);
        this.f7688c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7688c.run();
        } finally {
            this.f7686b.a();
        }
    }

    public String toString() {
        return "Task[" + n0.a(this.f7688c) + '@' + n0.b(this.f7688c) + ", " + this.f7685a + ", " + this.f7686b + ']';
    }
}
