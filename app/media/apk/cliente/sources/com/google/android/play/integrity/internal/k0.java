package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import java.util.List;
/* loaded from: classes.dex */
final class k0 extends d0 {

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ IBinder f1371k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ c f1372l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(c cVar, IBinder iBinder) {
        this.f1372l = cVar;
        this.f1371k = iBinder;
    }

    @Override // com.google.android.play.integrity.internal.d0
    public final void b() {
        j0 j0Var;
        List<Runnable> list;
        List list2;
        d dVar = this.f1372l.f1340a;
        j0Var = dVar.f1351i;
        dVar.f1356n = (IInterface) j0Var.a(this.f1371k);
        d.r(this.f1372l.f1340a);
        this.f1372l.f1340a.f1349g = false;
        list = this.f1372l.f1340a.f1346d;
        for (Runnable runnable : list) {
            runnable.run();
        }
        list2 = this.f1372l.f1340a.f1346d;
        list2.clear();
    }
}
