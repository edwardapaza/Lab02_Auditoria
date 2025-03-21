package a1;
/* loaded from: classes.dex */
final class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i5) {
        return (int) (Integer.rotateLeft((int) (i5 * (-862048943)), 15) * 461845907);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }
}
