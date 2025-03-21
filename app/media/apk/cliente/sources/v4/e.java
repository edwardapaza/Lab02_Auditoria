package v4;

import r4.h0;
import r4.k0;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f8200a;

    /* renamed from: b  reason: collision with root package name */
    private static final h0 f8201b;

    /* renamed from: c  reason: collision with root package name */
    private static final h0 f8202c;

    /* renamed from: d  reason: collision with root package name */
    private static final h0 f8203d;

    /* renamed from: e  reason: collision with root package name */
    private static final h0 f8204e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f8205f;

    static {
        int e5;
        int e6;
        e5 = k0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f8200a = e5;
        f8201b = new h0("PERMIT");
        f8202c = new h0("TAKEN");
        f8203d = new h0("BROKEN");
        f8204e = new h0("CANCELLED");
        e6 = k0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f8205f = e6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f h(long j5, f fVar) {
        return new f(j5, fVar, 0);
    }
}
