package io.grpc.internal;
/* loaded from: classes.dex */
abstract class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final i3.r f5327a;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(i3.r rVar) {
        this.f5327a = rVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        i3.r b5 = this.f5327a.b();
        try {
            a();
        } finally {
            this.f5327a.f(b5);
        }
    }
}
