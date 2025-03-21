package o4;

import r4.h0;
import r4.k0;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final j<Object> f6811a = new j<>(-1, null, null, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final int f6812b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6813c;

    /* renamed from: d  reason: collision with root package name */
    public static final h0 f6814d;

    /* renamed from: e  reason: collision with root package name */
    private static final h0 f6815e;

    /* renamed from: f  reason: collision with root package name */
    private static final h0 f6816f;

    /* renamed from: g  reason: collision with root package name */
    private static final h0 f6817g;

    /* renamed from: h  reason: collision with root package name */
    private static final h0 f6818h;

    /* renamed from: i  reason: collision with root package name */
    private static final h0 f6819i;

    /* renamed from: j  reason: collision with root package name */
    private static final h0 f6820j;

    /* renamed from: k  reason: collision with root package name */
    private static final h0 f6821k;

    /* renamed from: l  reason: collision with root package name */
    private static final h0 f6822l;

    /* renamed from: m  reason: collision with root package name */
    private static final h0 f6823m;

    /* renamed from: n  reason: collision with root package name */
    private static final h0 f6824n;

    /* renamed from: o  reason: collision with root package name */
    private static final h0 f6825o;

    /* renamed from: p  reason: collision with root package name */
    private static final h0 f6826p;

    /* renamed from: q  reason: collision with root package name */
    private static final h0 f6827q;

    /* renamed from: r  reason: collision with root package name */
    private static final h0 f6828r;

    /* renamed from: s  reason: collision with root package name */
    private static final h0 f6829s;

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* loaded from: classes.dex */
    /* synthetic */ class a<E> extends e4.j implements d4.p<Long, j<E>, j<E>> {

        /* renamed from: n  reason: collision with root package name */
        public static final a f6830n = new a();

        a() {
            super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final j<E> i(long j5, j<E> jVar) {
            return c.x(j5, jVar);
        }

        @Override // d4.p
        public /* bridge */ /* synthetic */ Object invoke(Long l5, Object obj) {
            return i(l5.longValue(), (j) obj);
        }
    }

    static {
        int e5;
        int e6;
        e5 = k0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        f6812b = e5;
        e6 = k0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        f6813c = e6;
        f6814d = new h0("BUFFERED");
        f6815e = new h0("SHOULD_BUFFER");
        f6816f = new h0("S_RESUMING_BY_RCV");
        f6817g = new h0("RESUMING_BY_EB");
        f6818h = new h0("POISONED");
        f6819i = new h0("DONE_RCV");
        f6820j = new h0("INTERRUPTED_SEND");
        f6821k = new h0("INTERRUPTED_RCV");
        f6822l = new h0("CHANNEL_CLOSED");
        f6823m = new h0("SUSPEND");
        f6824n = new h0("SUSPEND_NO_WAITER");
        f6825o = new h0("FAILED");
        f6826p = new h0("NO_RECEIVE_RESULT");
        f6827q = new h0("CLOSE_HANDLER_CLOSED");
        f6828r = new h0("CLOSE_HANDLER_INVOKED");
        f6829s = new h0("NO_CLOSE_CAUSE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A(int i5) {
        if (i5 != 0) {
            if (i5 != Integer.MAX_VALUE) {
                return i5;
            }
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean B(m4.l<? super T> lVar, T t5, d4.l<? super Throwable, s3.t> lVar2) {
        Object h5 = lVar.h(t5, null, lVar2);
        if (h5 != null) {
            lVar.s(h5);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean C(m4.l lVar, Object obj, d4.l lVar2, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            lVar2 = null;
        }
        return B(lVar, obj, lVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j5, boolean z4) {
        return (z4 ? 4611686018427387904L : 0L) + j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j5, int i5) {
        return (i5 << 60) + j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> j<E> x(long j5, j<E> jVar) {
        return new j<>(j5, jVar, jVar.u(), 0);
    }

    public static final <E> i4.e<j<E>> y() {
        return a.f6830n;
    }

    public static final h0 z() {
        return f6822l;
    }
}
