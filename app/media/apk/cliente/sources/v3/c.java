package v3;

import d4.p;
import e4.k;
import e4.l;
import java.io.Serializable;
import v3.g;
/* loaded from: classes.dex */
public final class c implements g, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final g f8169a;

    /* renamed from: b  reason: collision with root package name */
    private final g.b f8170b;

    /* loaded from: classes.dex */
    static final class a extends l implements p<String, g.b, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f8171a = new a();

        a() {
            super(2);
        }

        @Override // d4.p
        /* renamed from: a */
        public final String invoke(String str, g.b bVar) {
            k.e(str, "acc");
            k.e(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public c(g gVar, g.b bVar) {
        k.e(gVar, "left");
        k.e(bVar, "element");
        this.f8169a = gVar;
        this.f8170b = bVar;
    }

    private final boolean a(g.b bVar) {
        return k.a(d(bVar.getKey()), bVar);
    }

    private final boolean b(c cVar) {
        while (a(cVar.f8170b)) {
            g gVar = cVar.f8169a;
            if (!(gVar instanceof c)) {
                k.c(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    private final int e() {
        int i5 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.f8169a;
            cVar = gVar instanceof c ? (c) gVar : null;
            if (cVar == null) {
                return i5;
            }
            i5++;
        }
    }

    @Override // v3.g
    public g J(g gVar) {
        return g.a.a(this, gVar);
    }

    @Override // v3.g
    public g c0(g.c<?> cVar) {
        k.e(cVar, "key");
        if (this.f8170b.d(cVar) != null) {
            return this.f8169a;
        }
        g c02 = this.f8169a.c0(cVar);
        return c02 == this.f8169a ? this : c02 == h.f8175a ? this.f8170b : new c(c02, this.f8170b);
    }

    @Override // v3.g
    public <E extends g.b> E d(g.c<E> cVar) {
        k.e(cVar, "key");
        c cVar2 = this;
        while (true) {
            E e5 = (E) cVar2.f8170b.d(cVar);
            if (e5 != null) {
                return e5;
            }
            g gVar = cVar2.f8169a;
            if (!(gVar instanceof c)) {
                return (E) gVar.d(cVar);
            }
            cVar2 = (c) gVar;
        }
    }

    @Override // v3.g
    public <R> R e0(R r5, p<? super R, ? super g.b, ? extends R> pVar) {
        k.e(pVar, "operation");
        return pVar.invoke((Object) this.f8169a.e0(r5, pVar), this.f8170b);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.e() != e() || !cVar.b(this)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f8169a.hashCode() + this.f8170b.hashCode();
    }

    public String toString() {
        return '[' + ((String) e0("", a.f8171a)) + ']';
    }
}
