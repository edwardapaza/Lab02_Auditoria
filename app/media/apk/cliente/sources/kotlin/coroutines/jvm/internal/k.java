package kotlin.coroutines.jvm.internal;

import e4.s;
/* loaded from: classes.dex */
public abstract class k extends j implements e4.h<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final int f5863a;

    public k(int i5, v3.d<Object> dVar) {
        super(dVar);
        this.f5863a = i5;
    }

    @Override // e4.h
    public int getArity() {
        return this.f5863a;
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
