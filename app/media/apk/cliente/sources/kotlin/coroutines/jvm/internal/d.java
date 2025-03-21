package kotlin.coroutines.jvm.internal;

import v3.g;
/* loaded from: classes.dex */
public abstract class d extends a {
    private final v3.g _context;
    private transient v3.d<Object> intercepted;

    public d(v3.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    public d(v3.d<Object> dVar, v3.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // v3.d
    public v3.g getContext() {
        v3.g gVar = this._context;
        e4.k.b(gVar);
        return gVar;
    }

    public final v3.d<Object> intercepted() {
        v3.d<Object> dVar = this.intercepted;
        if (dVar == null) {
            v3.e eVar = (v3.e) getContext().d(v3.e.f8172j);
            if (eVar == null || (dVar = eVar.S(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.coroutines.jvm.internal.a
    public void releaseIntercepted() {
        v3.d<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            g.b d5 = getContext().d(v3.e.f8172j);
            e4.k.b(d5);
            ((v3.e) d5).A(dVar);
        }
        this.intercepted = c.f5856a;
    }
}
