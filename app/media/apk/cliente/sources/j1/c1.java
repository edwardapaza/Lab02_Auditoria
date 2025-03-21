package j1;

import com.google.android.gms.common.api.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c1 implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ d1 f5359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1(d1 d1Var) {
        this.f5359a = d1Var;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z4) {
        boolean f5;
        t tVar;
        if (z4) {
            this.f5359a.f5369c = true;
            this.f5359a.b();
            return;
        }
        this.f5359a.f5369c = false;
        f5 = this.f5359a.f();
        if (f5) {
            tVar = this.f5359a.f5368b;
            tVar.c();
        }
    }
}
