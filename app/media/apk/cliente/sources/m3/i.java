package m3;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private int f6171a;

    /* renamed from: b  reason: collision with root package name */
    private int f6172b;

    /* renamed from: c  reason: collision with root package name */
    private int f6173c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f6174d = new int[10];

    public int a(int i5) {
        return this.f6174d[i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        if ((this.f6171a & 2) != 0) {
            return this.f6174d[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i5) {
        return (this.f6171a & 32) != 0 ? this.f6174d[5] : i5;
    }

    public boolean d(int i5) {
        return ((1 << i5) & this.f6171a) != 0;
    }

    public i e(int i5, int i6, int i7) {
        int[] iArr = this.f6174d;
        if (i5 >= iArr.length) {
            return this;
        }
        int i8 = 1 << i5;
        this.f6171a |= i8;
        this.f6172b = (i6 & 1) != 0 ? this.f6172b | i8 : this.f6172b & (~i8);
        this.f6173c = (i6 & 2) != 0 ? this.f6173c | i8 : this.f6173c & (~i8);
        iArr[i5] = i7;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return Integer.bitCount(this.f6171a);
    }
}
