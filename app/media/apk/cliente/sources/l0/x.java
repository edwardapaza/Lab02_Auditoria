package l0;

import java.util.Arrays;
/* loaded from: classes.dex */
final class x extends w {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f5901b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f5901b = bArr;
    }

    @Override // l0.w
    final byte[] b() {
        return this.f5901b;
    }
}
