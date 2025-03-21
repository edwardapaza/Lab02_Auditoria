package p;

import e4.k;
import o.s;
/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: b  reason: collision with root package name */
    private final String f6850b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(s sVar, String str) {
        super(sVar, "Attempting to reuse fragment " + sVar + " with previous ID " + str);
        k.e(sVar, "fragment");
        k.e(str, "previousFragmentId");
        this.f6850b = str;
    }
}
