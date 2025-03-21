package h4;

import java.util.NoSuchElementException;
import t3.d0;
/* loaded from: classes.dex */
public final class h extends d0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f3140a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3141b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3142c;

    /* renamed from: d  reason: collision with root package name */
    private long f3143d;

    public h(long j5, long j6, long j7) {
        this.f3140a = j7;
        this.f3141b = j6;
        boolean z4 = true;
        int i5 = (j7 > 0L ? 1 : (j7 == 0L ? 0 : -1));
        int i6 = (j5 > j6 ? 1 : (j5 == j6 ? 0 : -1));
        if (i5 <= 0 ? i6 < 0 : i6 > 0) {
            z4 = false;
        }
        this.f3142c = z4;
        this.f3143d = z4 ? j5 : j6;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3142c;
    }

    @Override // t3.d0
    public long nextLong() {
        long j5 = this.f3143d;
        if (j5 != this.f3141b) {
            this.f3143d = this.f3140a + j5;
        } else if (!this.f3142c) {
            throw new NoSuchElementException();
        } else {
            this.f3142c = false;
        }
        return j5;
    }
}
