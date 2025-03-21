package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f141a;

    /* renamed from: b  reason: collision with root package name */
    private final d4.a<s3.t> f142b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f143c;

    /* renamed from: d  reason: collision with root package name */
    private int f144d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f145e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f146f;

    /* renamed from: g  reason: collision with root package name */
    private final List<d4.a<s3.t>> f147g;

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f148h;

    public m(Executor executor, d4.a<s3.t> aVar) {
        e4.k.e(executor, "executor");
        e4.k.e(aVar, "reportFullyDrawn");
        this.f141a = executor;
        this.f142b = aVar;
        this.f143c = new Object();
        this.f147g = new ArrayList();
        this.f148h = new Runnable() { // from class: androidx.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d(m.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(m mVar) {
        e4.k.e(mVar, "this$0");
        synchronized (mVar.f143c) {
            mVar.f145e = false;
            if (mVar.f144d == 0 && !mVar.f146f) {
                mVar.f142b.b();
                mVar.b();
            }
            s3.t tVar = s3.t.f7573a;
        }
    }

    public final void b() {
        synchronized (this.f143c) {
            this.f146f = true;
            Iterator<T> it = this.f147g.iterator();
            while (it.hasNext()) {
                ((d4.a) it.next()).b();
            }
            this.f147g.clear();
            s3.t tVar = s3.t.f7573a;
        }
    }

    public final boolean c() {
        boolean z4;
        synchronized (this.f143c) {
            z4 = this.f146f;
        }
        return z4;
    }
}
