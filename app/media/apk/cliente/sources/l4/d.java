package l4;

import e4.k;
import h4.i;
import h4.l;
/* loaded from: classes.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long d(long j5, int i5) {
        return b.e((j5 << 1) + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e(long j5) {
        return b.e((j5 << 1) + 1);
    }

    private static final long f(long j5) {
        return b.e(j5 << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(long j5) {
        return j5 * 1000000;
    }

    public static final long h(long j5, e eVar) {
        long f5;
        k.e(eVar, "unit");
        e eVar2 = e.NANOSECONDS;
        long b5 = f.b(4611686018426999999L, eVar2, eVar);
        if (new i(-b5, b5).k(j5)) {
            return f(f.b(j5, eVar, eVar2));
        }
        f5 = l.f(f.a(j5, eVar, e.MILLISECONDS), -4611686018427387903L, 4611686018427387903L);
        return e(f5);
    }
}
