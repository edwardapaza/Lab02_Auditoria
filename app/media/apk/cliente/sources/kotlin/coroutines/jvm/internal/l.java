package kotlin.coroutines.jvm.internal;

import e4.s;
/* loaded from: classes.dex */
public abstract class l extends d implements e4.h<Object> {
    private final int arity;

    public l(int i5) {
        this(i5, null);
    }

    public l(int i5, v3.d<Object> dVar) {
        super(dVar);
        this.arity = i5;
    }

    @Override // e4.h
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public String toString() {
        if (getCompletion() == null) {
            String e5 = s.e(this);
            e4.k.d(e5, "renderLambdaToString(this)");
            return e5;
        }
        return super.toString();
    }
}
