package e4;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class l<R> implements h<R>, Serializable {
    private final int arity;

    public l(int i5) {
        this.arity = i5;
    }

    @Override // e4.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String f5 = s.f(this);
        k.d(f5, "renderLambdaToString(this)");
        return f5;
    }
}
