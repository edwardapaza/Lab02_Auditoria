package v4;

import r4.h0;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final h0 f8188a = new h0("NO_OWNER");

    /* renamed from: b  reason: collision with root package name */
    private static final h0 f8189b = new h0("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z4) {
        return new b(z4);
    }

    public static /* synthetic */ a b(boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        return a(z4);
    }
}
