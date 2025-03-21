package p;

import e4.k;
import o.s;
/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: b  reason: collision with root package name */
    private final s f6875b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6876c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(s sVar, s sVar2, int i5) {
        super(sVar, "Attempting to nest fragment " + sVar + " within the view of parent fragment " + sVar2 + " via container with ID " + i5 + " without using parent's childFragmentManager");
        k.e(sVar, "fragment");
        k.e(sVar2, "expectedParentFragment");
        this.f6875b = sVar2;
        this.f6876c = i5;
    }
}
