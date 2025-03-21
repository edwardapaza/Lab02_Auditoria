package h4;

import java.util.NoSuchElementException;
import t3.c0;
/* loaded from: classes.dex */
public final class e extends c0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f3130a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3131b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3132c;

    /* renamed from: d  reason: collision with root package name */
    private int f3133d;

    public e(int i5, int i6, int i7) {
        this.f3130a = i7;
        this.f3131b = i6;
        boolean z4 = true;
        if (i7 <= 0 ? i5 < i6 : i5 > i6) {
            z4 = false;
        }
        this.f3132c = z4;
        this.f3133d = z4 ? i5 : i6;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3132c;
    }

    @Override // t3.c0
    public int nextInt() {
        int i5 = this.f3133d;
        if (i5 != this.f3131b) {
            this.f3133d = this.f3130a + i5;
        } else if (!this.f3132c) {
            throw new NoSuchElementException();
        } else {
            this.f3132c = false;
        }
        return i5;
    }
}
