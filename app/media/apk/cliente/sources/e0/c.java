package e0;

import android.content.Context;
import c0.j;
import e4.k;
import java.util.List;
import java.util.concurrent.Executor;
import t3.p;
/* loaded from: classes.dex */
public final class c implements d0.a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(k.a aVar) {
        List f5;
        k.e(aVar, "$callback");
        f5 = p.f();
        aVar.accept(new j(f5));
    }

    @Override // d0.a
    public void a(Context context, Executor executor, final k.a<j> aVar) {
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        executor.execute(new Runnable() { // from class: e0.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(k.a.this);
            }
        });
    }

    @Override // d0.a
    public void b(k.a<j> aVar) {
        k.e(aVar, "callback");
    }
}
