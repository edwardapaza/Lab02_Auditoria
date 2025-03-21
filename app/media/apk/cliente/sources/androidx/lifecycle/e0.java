package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
import u.d;
/* loaded from: classes.dex */
public final class e0 implements d.c {

    /* renamed from: a  reason: collision with root package name */
    private final u.d f534a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f535b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f536c;

    /* renamed from: d  reason: collision with root package name */
    private final s3.g f537d;

    /* loaded from: classes.dex */
    static final class a extends e4.l implements d4.a<f0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m0 f538a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(m0 m0Var) {
            super(0);
            this.f538a = m0Var;
        }

        @Override // d4.a
        /* renamed from: a */
        public final f0 b() {
            return d0.b(this.f538a);
        }
    }

    public e0(u.d dVar, m0 m0Var) {
        s3.g a5;
        e4.k.e(dVar, "savedStateRegistry");
        e4.k.e(m0Var, "viewModelStoreOwner");
        this.f534a = dVar;
        a5 = s3.i.a(new a(m0Var));
        this.f537d = a5;
    }

    private final f0 b() {
        return (f0) this.f537d.getValue();
    }

    @Override // u.d.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f536c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, b0> entry : b().d().entrySet()) {
            String key = entry.getKey();
            Bundle a5 = entry.getValue().c().a();
            if (!e4.k.a(a5, Bundle.EMPTY)) {
                bundle.putBundle(key, a5);
            }
        }
        this.f535b = false;
        return bundle;
    }

    public final void c() {
        if (this.f535b) {
            return;
        }
        Bundle b5 = this.f534a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f536c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (b5 != null) {
            bundle.putAll(b5);
        }
        this.f536c = bundle;
        this.f535b = true;
        b();
    }
}
