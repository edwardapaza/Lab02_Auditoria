package m4;
/* loaded from: classes.dex */
public abstract class a2 extends b0 implements b1, p1 {

    /* renamed from: d  reason: collision with root package name */
    public b2 f6179d;

    @Override // m4.b1
    public void a() {
        v().H0(this);
    }

    @Override // m4.p1
    public boolean c() {
        return true;
    }

    @Override // m4.p1
    public g2 f() {
        return null;
    }

    @Override // r4.s
    public String toString() {
        return n0.a(this) + '@' + n0.b(this) + "[job@" + n0.b(v()) + ']';
    }

    public final b2 v() {
        b2 b2Var = this.f6179d;
        if (b2Var != null) {
            return b2Var;
        }
        e4.k.o("job");
        return null;
    }

    public final void w(b2 b2Var) {
        this.f6179d = b2Var;
    }
}
