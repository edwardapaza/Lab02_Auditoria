package o4;

import m4.b3;
import o4.h;
import r4.h0;
import r4.q0;
import r4.z;
/* loaded from: classes.dex */
public class o<E> extends b<E> {

    /* renamed from: q  reason: collision with root package name */
    private final int f6841q;

    /* renamed from: r  reason: collision with root package name */
    private final a f6842r;

    public o(int i5, a aVar, d4.l<? super E, s3.t> lVar) {
        super(i5, lVar);
        this.f6841q = i5;
        this.f6842r = aVar;
        if (!(aVar != a.SUSPEND)) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + e4.s.b(b.class).c() + " instead").toString());
        }
        if (i5 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i5 + " was specified").toString());
    }

    static /* synthetic */ <E> Object B0(o<E> oVar, E e5, v3.d<? super s3.t> dVar) {
        q0 d5;
        Object E0 = oVar.E0(e5, true);
        if (E0 instanceof h.a) {
            h.e(E0);
            d4.l<E, s3.t> lVar = oVar.f6800b;
            if (lVar == null || (d5 = z.d(lVar, e5, null, 2, null)) == null) {
                throw oVar.K();
            }
            s3.b.a(d5, oVar.K());
            throw d5;
        }
        return s3.t.f7573a;
    }

    private final Object C0(E e5, boolean z4) {
        d4.l<E, s3.t> lVar;
        q0 d5;
        Object l5 = super.l(e5);
        if (h.h(l5) || h.g(l5)) {
            return l5;
        }
        if (!z4 || (lVar = this.f6800b) == null || (d5 = z.d(lVar, e5, null, 2, null)) == null) {
            return h.f6835b.c(s3.t.f7573a);
        }
        throw d5;
    }

    private final Object D0(E e5) {
        j jVar;
        h0 h0Var = c.f6814d;
        j jVar2 = (j) b.f6794l.get(this);
        while (true) {
            long andIncrement = b.f6790d.getAndIncrement(this);
            long j5 = andIncrement & 1152921504606846975L;
            boolean U = U(andIncrement);
            int i5 = c.f6812b;
            long j6 = j5 / i5;
            int i6 = (int) (j5 % i5);
            if (jVar2.f7187c != j6) {
                j F = F(j6, jVar2);
                if (F != null) {
                    jVar = F;
                } else if (U) {
                    return h.f6835b.a(K());
                }
            } else {
                jVar = jVar2;
            }
            int w02 = w0(jVar, i6, e5, j5, h0Var, U);
            if (w02 == 0) {
                jVar.b();
                return h.f6835b.c(s3.t.f7573a);
            } else if (w02 == 1) {
                return h.f6835b.c(s3.t.f7573a);
            } else {
                if (w02 == 2) {
                    if (U) {
                        jVar.p();
                        return h.f6835b.a(K());
                    }
                    b3 b3Var = h0Var instanceof b3 ? (b3) h0Var : null;
                    if (b3Var != null) {
                        i0(b3Var, jVar, i6);
                    }
                    B((jVar.f7187c * i5) + i6);
                    return h.f6835b.c(s3.t.f7573a);
                } else if (w02 == 3) {
                    throw new IllegalStateException("unexpected".toString());
                } else {
                    if (w02 == 4) {
                        if (j5 < J()) {
                            jVar.b();
                        }
                        return h.f6835b.a(K());
                    }
                    if (w02 == 5) {
                        jVar.b();
                    }
                    jVar2 = jVar;
                }
            }
        }
    }

    private final Object E0(E e5, boolean z4) {
        return this.f6842r == a.DROP_LATEST ? C0(e5, z4) : D0(e5);
    }

    @Override // o4.b
    protected boolean V() {
        return this.f6842r == a.DROP_OLDEST;
    }

    @Override // o4.b, o4.u
    public Object l(E e5) {
        return E0(e5, false);
    }

    @Override // o4.b, o4.u
    public Object o(E e5, v3.d<? super s3.t> dVar) {
        return B0(this, e5, dVar);
    }
}
