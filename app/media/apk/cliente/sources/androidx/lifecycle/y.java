package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.i;
/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes.dex */
public class y implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Object f611a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0017a f612b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Object obj) {
        this.f611a = obj;
        this.f612b = a.f511c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.k
    public void d(m mVar, i.a aVar) {
        this.f612b.a(mVar, aVar, this.f611a);
    }
}
