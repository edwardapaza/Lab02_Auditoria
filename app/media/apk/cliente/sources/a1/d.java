package a1;
/* loaded from: classes.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder a(int i5) {
        c.b(i5, "size");
        return new StringBuilder((int) Math.min(i5 * 8, 1073741824L));
    }
}
