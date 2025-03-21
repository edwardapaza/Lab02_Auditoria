package io.grpc.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: f  reason: collision with root package name */
    static final b f5059f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final q2 f5060a;

    /* renamed from: b  reason: collision with root package name */
    private final g1 f5061b = h1.a();

    /* renamed from: c  reason: collision with root package name */
    private final g1 f5062c = h1.a();

    /* renamed from: d  reason: collision with root package name */
    private final g1 f5063d = h1.a();

    /* renamed from: e  reason: collision with root package name */
    private volatile long f5064e;

    /* loaded from: classes.dex */
    class a implements b {
        a() {
        }

        @Override // io.grpc.internal.o.b
        public o a() {
            return new o(q2.f5109a);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        o a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(q2 q2Var) {
        this.f5060a = q2Var;
    }

    public void a(boolean z4) {
        (z4 ? this.f5062c : this.f5063d).add(1L);
    }

    public void b() {
        this.f5061b.add(1L);
        this.f5064e = this.f5060a.a();
    }
}
