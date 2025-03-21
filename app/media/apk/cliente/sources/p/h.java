package p;

import e4.k;
import o.s;
/* loaded from: classes.dex */
public abstract class h extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final s f6873a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(s sVar, String str) {
        super(str);
        k.e(sVar, "fragment");
        this.f6873a = sVar;
    }

    public final s a() {
        return this.f6873a;
    }
}
