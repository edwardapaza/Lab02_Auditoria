package t3;

import java.util.List;
/* loaded from: classes.dex */
public final class n extends x {
    public static /* bridge */ /* synthetic */ int g(List list) {
        return p.g(list);
    }

    public static /* bridge */ /* synthetic */ void j() {
        p.j();
    }

    public static /* bridge */ /* synthetic */ int k(Iterable iterable, int i5) {
        return q.k(iterable, i5);
    }

    public static /* bridge */ /* synthetic */ Appendable u(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l lVar, int i6, Object obj) {
        Appendable t5;
        t5 = x.t(iterable, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i5, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : lVar);
        return t5;
    }

    public static /* bridge */ /* synthetic */ Comparable y(Iterable iterable) {
        return x.y(iterable);
    }
}
