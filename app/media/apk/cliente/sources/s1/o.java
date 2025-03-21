package s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s1.e1;
/* loaded from: classes.dex */
public final class o implements e1.c {

    /* renamed from: a  reason: collision with root package name */
    private final e1 f7407a;

    /* renamed from: c  reason: collision with root package name */
    private final Set<com.google.firebase.firestore.o<Void>> f7409c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private y0 f7410d = y0.UNKNOWN;

    /* renamed from: b  reason: collision with root package name */
    private final Map<a1, e> f7408b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7411a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f7412b;

        static {
            int[] iArr = new int[c.values().length];
            f7412b = iArr;
            try {
                iArr[c.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7412b[c.TERMINATE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7412b[c.REQUIRE_WATCH_DISCONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.values().length];
            f7411a = iArr2;
            try {
                iArr2[d.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7411a[d.INITIALIZE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7411a[d.REQUIRE_WATCH_CONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f7413a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7414b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7415c;

        /* renamed from: d  reason: collision with root package name */
        public com.google.firebase.firestore.f0 f7416d = com.google.firebase.firestore.f0.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum c {
        TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION,
        TERMINATE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_DISCONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum d {
        INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION,
        INITIALIZE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_CONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final List<b1> f7427a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private x1 f7428b;

        /* renamed from: c  reason: collision with root package name */
        private int f7429c;

        e() {
        }

        boolean f() {
            for (b1 b1Var : this.f7427a) {
                if (b1Var.b()) {
                    return true;
                }
            }
            return false;
        }
    }

    public o(e1 e1Var) {
        this.f7407a = e1Var;
        e1Var.y(this);
    }

    private void f() {
        for (com.google.firebase.firestore.o<Void> oVar : this.f7409c) {
            oVar.a(null, null);
        }
    }

    @Override // s1.e1.c
    public void a(y0 y0Var) {
        this.f7410d = y0Var;
        boolean z4 = false;
        for (e eVar : this.f7408b.values()) {
            for (b1 b1Var : eVar.f7427a) {
                if (b1Var.d(y0Var)) {
                    z4 = true;
                }
            }
        }
        if (z4) {
            f();
        }
    }

    @Override // s1.e1.c
    public void b(a1 a1Var, i3.j1 j1Var) {
        e eVar = this.f7408b.get(a1Var);
        if (eVar != null) {
            for (b1 b1Var : eVar.f7427a) {
                b1Var.c(z1.h0.t(j1Var));
            }
        }
        this.f7408b.remove(a1Var);
    }

    @Override // s1.e1.c
    public void c(List<x1> list) {
        boolean z4 = false;
        for (x1 x1Var : list) {
            e eVar = this.f7408b.get(x1Var.h());
            if (eVar != null) {
                for (b1 b1Var : eVar.f7427a) {
                    if (b1Var.e(x1Var)) {
                        z4 = true;
                    }
                }
                eVar.f7428b = x1Var;
            }
        }
        if (z4) {
            f();
        }
    }

    public int d(b1 b1Var) {
        int n5;
        a1 a5 = b1Var.a();
        d dVar = d.NO_ACTION_REQUIRED;
        e eVar = this.f7408b.get(a5);
        if (eVar == null) {
            eVar = new e();
            this.f7408b.put(a5, eVar);
            dVar = b1Var.b() ? d.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION : d.INITIALIZE_LOCAL_LISTEN_ONLY;
        } else if (!eVar.f() && b1Var.b()) {
            dVar = d.REQUIRE_WATCH_CONNECTION_ONLY;
        }
        eVar.f7427a.add(b1Var);
        z1.b.d(!b1Var.d(this.f7410d), "onOnlineStateChanged() shouldn't raise an event for brand-new listeners.", new Object[0]);
        if (eVar.f7428b != null && b1Var.e(eVar.f7428b)) {
            f();
        }
        int i5 = a.f7411a[dVar.ordinal()];
        if (i5 == 1) {
            n5 = this.f7407a.n(a5, true);
        } else if (i5 != 2) {
            if (i5 == 3) {
                this.f7407a.o(a5);
            }
            return eVar.f7429c;
        } else {
            n5 = this.f7407a.n(a5, false);
        }
        eVar.f7429c = n5;
        return eVar.f7429c;
    }

    public void e(com.google.firebase.firestore.o<Void> oVar) {
        this.f7409c.add(oVar);
        oVar.a(null, null);
    }

    public void g(b1 b1Var) {
        e1 e1Var;
        a1 a5 = b1Var.a();
        e eVar = this.f7408b.get(a5);
        c cVar = c.NO_ACTION_REQUIRED;
        if (eVar == null) {
            return;
        }
        eVar.f7427a.remove(b1Var);
        if (eVar.f7427a.isEmpty()) {
            cVar = b1Var.b() ? c.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION : c.TERMINATE_LOCAL_LISTEN_ONLY;
        } else if (!eVar.f() && b1Var.b()) {
            cVar = c.REQUIRE_WATCH_DISCONNECTION_ONLY;
        }
        int i5 = a.f7412b[cVar.ordinal()];
        boolean z4 = true;
        if (i5 == 1) {
            this.f7408b.remove(a5);
            e1Var = this.f7407a;
        } else if (i5 != 2) {
            if (i5 != 3) {
                return;
            }
            this.f7407a.A(a5);
            return;
        } else {
            this.f7408b.remove(a5);
            e1Var = this.f7407a;
            z4 = false;
        }
        e1Var.z(a5, z4);
    }

    public void h(com.google.firebase.firestore.o<Void> oVar) {
        this.f7409c.remove(oVar);
    }
}
