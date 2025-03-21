package m4;
/* loaded from: classes.dex */
public final class o {
    public static final void a(l<?> lVar, b1 b1Var) {
        lVar.t(new c1(b1Var));
    }

    public static final <T> m<T> b(v3.d<? super T> dVar) {
        if (dVar instanceof r4.j) {
            m<T> l5 = ((r4.j) dVar).l();
            if (l5 != null) {
                if (!l5.K()) {
                    l5 = null;
                }
                if (l5 != null) {
                    return l5;
                }
            }
            return new m<>(dVar, 2);
        }
        return new m<>(dVar, 1);
    }
}
