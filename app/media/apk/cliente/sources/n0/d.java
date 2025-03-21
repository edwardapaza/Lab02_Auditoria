package n0;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
/* loaded from: classes.dex */
public final class d extends com.google.android.gms.common.api.e<x> implements w {

    /* renamed from: a  reason: collision with root package name */
    private static final a.g<e> f6312a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.AbstractC0036a<e, x> f6313b;

    /* renamed from: c  reason: collision with root package name */
    private static final com.google.android.gms.common.api.a<x> f6314c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f6315d = 0;

    static {
        a.g<e> gVar = new a.g<>();
        f6312a = gVar;
        c cVar = new c();
        f6313b = cVar;
        f6314c = new com.google.android.gms.common.api.a<>("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, x xVar) {
        super(context, f6314c, xVar, e.a.f891c);
    }

    @Override // com.google.android.gms.common.internal.w
    public final Task<Void> a(final u uVar) {
        r.a a5 = r.a();
        a5.d(zad.zaa);
        a5.c(false);
        a5.b(new p() { // from class: n0.b
            @Override // com.google.android.gms.common.api.internal.p
            public final void accept(Object obj, Object obj2) {
                u uVar2 = u.this;
                int i5 = d.f6315d;
                ((a) ((e) obj).getService()).a(uVar2);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        });
        return doBestEffortWrite(a5.a());
    }
}
