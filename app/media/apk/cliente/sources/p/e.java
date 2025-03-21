package p;

import android.view.ViewGroup;
import e4.k;
import o.s;
/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f6872b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(s sVar, ViewGroup viewGroup) {
        super(sVar, "Attempting to use <fragment> tag to add fragment " + sVar + " to container " + viewGroup);
        k.e(sVar, "fragment");
        this.f6872b = viewGroup;
    }
}
