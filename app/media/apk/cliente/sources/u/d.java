package u;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import e4.k;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: f  reason: collision with root package name */
    private static final b f7706f = new b(null);

    /* renamed from: b  reason: collision with root package name */
    private boolean f7708b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f7709c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7710d;

    /* renamed from: a  reason: collision with root package name */
    private final f.b<String, c> f7707a = new f.b<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f7711e = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(f fVar);
    }

    /* loaded from: classes.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(e4.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d dVar, m mVar, i.a aVar) {
        boolean z4;
        k.e(dVar, "this$0");
        k.e(mVar, "<anonymous parameter 0>");
        k.e(aVar, "event");
        if (aVar == i.a.ON_START) {
            z4 = true;
        } else if (aVar != i.a.ON_STOP) {
            return;
        } else {
            z4 = false;
        }
        dVar.f7711e = z4;
    }

    public final Bundle b(String str) {
        k.e(str, "key");
        if (this.f7710d) {
            Bundle bundle = this.f7709c;
            if (bundle != null) {
                Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
                Bundle bundle3 = this.f7709c;
                if (bundle3 != null) {
                    bundle3.remove(str);
                }
                Bundle bundle4 = this.f7709c;
                boolean z4 = false;
                if (bundle4 != null && !bundle4.isEmpty()) {
                    z4 = true;
                }
                if (!z4) {
                    this.f7709c = null;
                }
                return bundle2;
            }
            return null;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final c c(String str) {
        k.e(str, "key");
        Iterator<Map.Entry<String, c>> it = this.f7707a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            k.d(next, "components");
            c value = next.getValue();
            if (k.a(next.getKey(), str)) {
                return value;
            }
        }
        return null;
    }

    public final void e(i iVar) {
        k.e(iVar, "lifecycle");
        if (!(!this.f7708b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        iVar.a(new androidx.lifecycle.k() { // from class: u.c
            @Override // androidx.lifecycle.k
            public final void d(m mVar, i.a aVar) {
                d.d(d.this, mVar, aVar);
            }
        });
        this.f7708b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f7708b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f7710d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f7709c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f7710d = true;
    }

    public final void g(Bundle bundle) {
        k.e(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f7709c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        f.b<String, c>.d i5 = this.f7707a.i();
        k.d(i5, "this.components.iteratorWithAdditions()");
        while (i5.hasNext()) {
            Map.Entry next = i5.next();
            bundle2.putBundle((String) next.getKey(), ((c) next.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, c cVar) {
        k.e(str, "key");
        k.e(cVar, "provider");
        if (!(this.f7707a.m(str, cVar) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }
}
