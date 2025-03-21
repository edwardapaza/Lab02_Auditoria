package r4;

import java.util.List;
import m4.f2;
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f7245a = true;

    private static final y a(Throwable th, String str) {
        if (f7245a) {
            return new y(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new s3.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ y b(Throwable th, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            th = null;
        }
        if ((i5 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(f2 f2Var) {
        return f2Var.i0() instanceof y;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final f2 e(v vVar, List<? extends v> list) {
        try {
            return vVar.b(list);
        } catch (Throwable th) {
            return a(th, vVar.a());
        }
    }
}
