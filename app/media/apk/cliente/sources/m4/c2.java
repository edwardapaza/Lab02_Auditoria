package m4;
/* loaded from: classes.dex */
public final class c2 {

    /* renamed from: a  reason: collision with root package name */
    private static final r4.h0 f6200a = new r4.h0("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final r4.h0 f6201b = new r4.h0("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c  reason: collision with root package name */
    private static final r4.h0 f6202c = new r4.h0("COMPLETING_RETRY");

    /* renamed from: d  reason: collision with root package name */
    private static final r4.h0 f6203d = new r4.h0("TOO_LATE_TO_CANCEL");

    /* renamed from: e  reason: collision with root package name */
    private static final r4.h0 f6204e = new r4.h0("SEALED");

    /* renamed from: f  reason: collision with root package name */
    private static final e1 f6205f = new e1(false);

    /* renamed from: g  reason: collision with root package name */
    private static final e1 f6206g = new e1(true);

    public static final Object g(Object obj) {
        return obj instanceof p1 ? new q1((p1) obj) : obj;
    }

    public static final Object h(Object obj) {
        p1 p1Var;
        q1 q1Var = obj instanceof q1 ? (q1) obj : null;
        return (q1Var == null || (p1Var = q1Var.f6271a) == null) ? obj : p1Var;
    }
}
