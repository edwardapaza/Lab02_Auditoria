package o;

import android.util.Log;
import androidx.lifecycle.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o0 extends androidx.lifecycle.h0 {

    /* renamed from: k  reason: collision with root package name */
    private static final i0.b f6541k = new a();

    /* renamed from: g  reason: collision with root package name */
    private final boolean f6545g;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, s> f6542d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, o0> f6543e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, androidx.lifecycle.l0> f6544f = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private boolean f6546h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6547i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6548j = false;

    /* loaded from: classes.dex */
    class a implements i0.b {
        a() {
        }

        @Override // androidx.lifecycle.i0.b
        public <T extends androidx.lifecycle.h0> T a(Class<T> cls) {
            return new o0(true);
        }

        @Override // androidx.lifecycle.i0.b
        public /* synthetic */ androidx.lifecycle.h0 b(Class cls, r.a aVar) {
            return androidx.lifecycle.j0.b(this, cls, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(boolean z4) {
        this.f6545g = z4;
    }

    private void g(String str, boolean z4) {
        o0 o0Var = this.f6543e.get(str);
        if (o0Var != null) {
            if (z4) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(o0Var.f6543e.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    o0Var.e((String) it.next(), true);
                }
            }
            o0Var.c();
            this.f6543e.remove(str);
        }
        androidx.lifecycle.l0 l0Var = this.f6544f.get(str);
        if (l0Var != null) {
            l0Var.a();
            this.f6544f.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o0 j(androidx.lifecycle.l0 l0Var) {
        return (o0) new androidx.lifecycle.i0(l0Var, f6541k).a(o0.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.h0
    public void c() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f6546h = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(s sVar) {
        if (this.f6548j) {
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.f6542d.containsKey(sVar.f6607f)) {
        } else {
            this.f6542d.put(sVar.f6607f, sVar);
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, boolean z4) {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        g(str, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o0.class != obj.getClass()) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return this.f6542d.equals(o0Var.f6542d) && this.f6543e.equals(o0Var.f6543e) && this.f6544f.equals(o0Var.f6544f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(s sVar, boolean z4) {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + sVar);
        }
        g(sVar.f6607f, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s h(String str) {
        return this.f6542d.get(str);
    }

    public int hashCode() {
        return (((this.f6542d.hashCode() * 31) + this.f6543e.hashCode()) * 31) + this.f6544f.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0 i(s sVar) {
        o0 o0Var = this.f6543e.get(sVar.f6607f);
        if (o0Var == null) {
            o0 o0Var2 = new o0(this.f6545g);
            this.f6543e.put(sVar.f6607f, o0Var2);
            return o0Var2;
        }
        return o0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<s> k() {
        return new ArrayList(this.f6542d.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.l0 l(s sVar) {
        androidx.lifecycle.l0 l0Var = this.f6544f.get(sVar.f6607f);
        if (l0Var == null) {
            androidx.lifecycle.l0 l0Var2 = new androidx.lifecycle.l0();
            this.f6544f.put(sVar.f6607f, l0Var2);
            return l0Var2;
        }
        return l0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.f6546h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(s sVar) {
        if (this.f6548j) {
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f6542d.remove(sVar.f6607f) != null) && l0.I0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z4) {
        this.f6548j = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p(s sVar) {
        if (this.f6542d.containsKey(sVar.f6607f)) {
            return this.f6545g ? this.f6546h : !this.f6547i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<s> it = this.f6542d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f6543e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f6544f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
