package l0;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
abstract class y extends w {

    /* renamed from: c  reason: collision with root package name */
    private static final WeakReference f5902c = new WeakReference(null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference f5903b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(byte[] bArr) {
        super(bArr);
        this.f5903b = f5902c;
    }

    @Override // l0.w
    final byte[] b() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f5903b.get();
            if (bArr == null) {
                bArr = f();
                this.f5903b = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] f();
}
