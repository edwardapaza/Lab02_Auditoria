package m4;
/* loaded from: classes.dex */
public abstract class f1 extends g0 {

    /* renamed from: c  reason: collision with root package name */
    private long f6229c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6230d;

    /* renamed from: e  reason: collision with root package name */
    private t3.f<w0<?>> f6231e;

    private final long j0(boolean z4) {
        return z4 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void n0(f1 f1Var, boolean z4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        f1Var.m0(z4);
    }

    public final void i0(boolean z4) {
        long j02 = this.f6229c - j0(z4);
        this.f6229c = j02;
        if (j02 <= 0 && this.f6230d) {
            shutdown();
        }
    }

    public final void k0(w0<?> w0Var) {
        t3.f<w0<?>> fVar = this.f6231e;
        if (fVar == null) {
            fVar = new t3.f<>();
            this.f6231e = fVar;
        }
        fVar.addLast(w0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long l0() {
        t3.f<w0<?>> fVar = this.f6231e;
        return (fVar == null || fVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void m0(boolean z4) {
        this.f6229c += j0(z4);
        if (z4) {
            return;
        }
        this.f6230d = true;
    }

    public final boolean o0() {
        return this.f6229c >= j0(true);
    }

    public final boolean p0() {
        t3.f<w0<?>> fVar = this.f6231e;
        if (fVar != null) {
            return fVar.isEmpty();
        }
        return true;
    }

    public final boolean q0() {
        w0<?> q5;
        t3.f<w0<?>> fVar = this.f6231e;
        if (fVar == null || (q5 = fVar.q()) == null) {
            return false;
        }
        q5.run();
        return true;
    }

    public void shutdown() {
    }
}
