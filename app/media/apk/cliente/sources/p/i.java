package p;

import android.view.ViewGroup;
import e4.k;
import o.s;
/* loaded from: classes.dex */
public final class i extends h {

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f6874b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(s sVar, ViewGroup viewGroup) {
        super(sVar, "Attempting to add fragment " + sVar + " to container " + viewGroup + " which is not a FragmentContainerView");
        k.e(sVar, "fragment");
        k.e(viewGroup, "container");
        this.f6874b = viewGroup;
    }
}
