package r4;
/* loaded from: classes.dex */
public final class p {
    public static final void a(int i5) {
        if (i5 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i5).toString());
    }
}
