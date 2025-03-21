package r4;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private static final h0 f7182a = new h0("CLOSED");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [r4.e] */
    public static final <N extends e<N>> N b(N n5) {
        while (true) {
            Object f5 = n5.f();
            if (f5 == f7182a) {
                return n5;
            }
            ?? r02 = (e) f5;
            if (r02 != 0) {
                n5 = r02;
            } else if (n5.j()) {
                return n5;
            }
        }
    }

    public static final <S extends e0<S>> Object c(S s5, long j5, d4.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s5.f7187c >= j5 && !s5.h()) {
                return f0.a(s5);
            }
            Object f5 = s5.f();
            if (f5 == f7182a) {
                return f0.a(f7182a);
            }
            S s6 = (S) ((e) f5);
            if (s6 == null) {
                s6 = pVar.invoke(Long.valueOf(s5.f7187c + 1), s5);
                if (s5.l(s6)) {
                    if (s5.h()) {
                        s5.k();
                    }
                }
            }
            s5 = s6;
        }
    }
}
