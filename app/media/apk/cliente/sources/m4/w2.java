package m4;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w2<U, T extends U> extends r4.d0<T> implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final long f6288e;

    public w2(long j5, v3.d<? super U> dVar) {
        super(dVar.getContext(), dVar);
        this.f6288e = j5;
    }

    @Override // java.lang.Runnable
    public void run() {
        H(x2.a(this.f6288e, t0.a(getContext()), this));
    }

    @Override // m4.a, m4.b2
    public String y0() {
        return super.y0() + "(timeMillis=" + this.f6288e + ')';
    }
}
