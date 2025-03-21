package m4;
/* loaded from: classes.dex */
public final class j1 {

    /* renamed from: a  reason: collision with root package name */
    private static final r4.h0 f6245a = new r4.h0("REMOVED_TASK");

    /* renamed from: b  reason: collision with root package name */
    private static final r4.h0 f6246b = new r4.h0("CLOSED_EMPTY");

    public static final long c(long j5) {
        if (j5 <= 0) {
            return 0L;
        }
        if (j5 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j5;
    }
}
