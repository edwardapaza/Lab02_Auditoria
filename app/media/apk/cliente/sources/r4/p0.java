package r4;

import m4.p2;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    public final v3.g f7222a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f7223b;

    /* renamed from: c  reason: collision with root package name */
    private final p2<Object>[] f7224c;

    /* renamed from: d  reason: collision with root package name */
    private int f7225d;

    public p0(v3.g gVar, int i5) {
        this.f7222a = gVar;
        this.f7223b = new Object[i5];
        this.f7224c = new p2[i5];
    }

    public final void a(p2<?> p2Var, Object obj) {
        Object[] objArr = this.f7223b;
        int i5 = this.f7225d;
        objArr[i5] = obj;
        p2<Object>[] p2VarArr = this.f7224c;
        this.f7225d = i5 + 1;
        e4.k.c(p2Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        p2VarArr[i5] = p2Var;
    }

    public final void b(v3.g gVar) {
        int length = this.f7224c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i5 = length - 1;
            p2<Object> p2Var = this.f7224c[length];
            e4.k.b(p2Var);
            p2Var.X(gVar, this.f7223b[length]);
            if (i5 < 0) {
                return;
            }
            length = i5;
        }
    }
}
