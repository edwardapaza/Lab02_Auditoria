package s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import s1.m;
import s1.t0;
import s1.x1;
/* loaded from: classes.dex */
public class v1 {

    /* renamed from: a  reason: collision with root package name */
    private final a1 f7504a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7506c;

    /* renamed from: d  reason: collision with root package name */
    private v1.n f7507d;

    /* renamed from: e  reason: collision with root package name */
    private m1.e<v1.l> f7508e;

    /* renamed from: b  reason: collision with root package name */
    private x1.a f7505b = x1.a.NONE;

    /* renamed from: f  reason: collision with root package name */
    private m1.e<v1.l> f7509f = v1.l.e();

    /* renamed from: g  reason: collision with root package name */
    private m1.e<v1.l> f7510g = v1.l.e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7511a;

        static {
            int[] iArr = new int[m.a.values().length];
            f7511a = iArr;
            try {
                iArr[m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7511a[m.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7511a[m.a.METADATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7511a[m.a.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final v1.n f7512a;

        /* renamed from: b  reason: collision with root package name */
        final n f7513b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f7514c;

        /* renamed from: d  reason: collision with root package name */
        final m1.e<v1.l> f7515d;

        private b(v1.n nVar, n nVar2, m1.e<v1.l> eVar, boolean z4) {
            this.f7512a = nVar;
            this.f7513b = nVar2;
            this.f7515d = eVar;
            this.f7514c = z4;
        }

        /* synthetic */ b(v1.n nVar, n nVar2, m1.e eVar, boolean z4, a aVar) {
            this(nVar, nVar2, eVar, z4);
        }

        public boolean b() {
            return this.f7514c;
        }
    }

    public v1(a1 a1Var, m1.e<v1.l> eVar) {
        this.f7504a = a1Var;
        this.f7507d = v1.n.i(a1Var.c());
        this.f7508e = eVar;
    }

    private void f(y1.v0 v0Var) {
        if (v0Var != null) {
            Iterator<v1.l> it = v0Var.b().iterator();
            while (it.hasNext()) {
                this.f7508e = this.f7508e.i(it.next());
            }
            Iterator<v1.l> it2 = v0Var.c().iterator();
            while (it2.hasNext()) {
                v1.l next = it2.next();
                z1.b.d(this.f7508e.contains(next), "Modified document %s not found in view.", next);
            }
            Iterator<v1.l> it3 = v0Var.d().iterator();
            while (it3.hasNext()) {
                this.f7508e = this.f7508e.l(it3.next());
            }
            this.f7506c = v0Var.f();
        }
    }

    private static int g(m mVar) {
        int i5 = a.f7511a[mVar.c().ordinal()];
        int i6 = 1;
        if (i5 != 1) {
            i6 = 2;
            if (i5 != 2 && i5 != 3) {
                if (i5 == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown change type: " + mVar.c());
            }
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int l(m mVar, m mVar2) {
        int l5 = z1.h0.l(g(mVar), g(mVar2));
        return l5 != 0 ? l5 : this.f7504a.c().compare(mVar.b(), mVar2.b());
    }

    private boolean m(v1.l lVar) {
        v1.i k5;
        return (this.f7508e.contains(lVar) || (k5 = this.f7507d.k(lVar)) == null || k5.d()) ? false : true;
    }

    private boolean n(v1.i iVar, v1.i iVar2) {
        return iVar.d() && iVar2.c() && !iVar2.d();
    }

    private List<t0> o() {
        if (this.f7506c) {
            m1.e<v1.l> eVar = this.f7509f;
            this.f7509f = v1.l.e();
            Iterator<v1.i> it = this.f7507d.iterator();
            while (it.hasNext()) {
                v1.i next = it.next();
                if (m(next.getKey())) {
                    this.f7509f = this.f7509f.i(next.getKey());
                }
            }
            ArrayList arrayList = new ArrayList(eVar.size() + this.f7509f.size());
            Iterator<v1.l> it2 = eVar.iterator();
            while (it2.hasNext()) {
                v1.l next2 = it2.next();
                if (!this.f7509f.contains(next2)) {
                    arrayList.add(new t0(t0.a.REMOVED, next2));
                }
            }
            Iterator<v1.l> it3 = this.f7509f.iterator();
            while (it3.hasNext()) {
                v1.l next3 = it3.next();
                if (!eVar.contains(next3)) {
                    arrayList.add(new t0(t0.a.ADDED, next3));
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public w1 b(b bVar) {
        return c(bVar, null);
    }

    public w1 c(b bVar, y1.v0 v0Var) {
        return d(bVar, v0Var, false);
    }

    public w1 d(b bVar, y1.v0 v0Var, boolean z4) {
        z1.b.d(!bVar.f7514c, "Cannot apply changes that need a refill", new Object[0]);
        v1.n nVar = this.f7507d;
        this.f7507d = bVar.f7512a;
        this.f7510g = bVar.f7515d;
        List<m> b5 = bVar.f7513b.b();
        Collections.sort(b5, new Comparator() { // from class: s1.u1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int l5;
                l5 = v1.this.l((m) obj, (m) obj2);
                return l5;
            }
        });
        f(v0Var);
        List<t0> emptyList = z4 ? Collections.emptyList() : o();
        x1.a aVar = this.f7509f.size() == 0 && this.f7506c && !z4 ? x1.a.SYNCED : x1.a.LOCAL;
        boolean z5 = aVar != this.f7505b;
        this.f7505b = aVar;
        x1 x1Var = null;
        if (b5.size() != 0 || z5) {
            x1Var = new x1(this.f7504a, bVar.f7512a, nVar, b5, aVar == x1.a.LOCAL, bVar.f7515d, z5, false, (v0Var == null || v0Var.e().isEmpty()) ? false : true);
        }
        return new w1(x1Var, emptyList);
    }

    public w1 e(y0 y0Var) {
        if (this.f7506c && y0Var == y0.OFFLINE) {
            this.f7506c = false;
            return b(new b(this.f7507d, new n(), this.f7510g, false, null));
        }
        return new w1(null, Collections.emptyList());
    }

    public b h(m1.c<v1.l, v1.i> cVar) {
        return i(cVar, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
        if (r18.f7504a.c().compare(r6, r4) > 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0102, code lost:
        if (r18.f7504a.c().compare(r6, r7) < 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x012a, code lost:
        if (r7 == null) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s1.v1.b i(m1.c<v1.l, v1.i> r19, s1.v1.b r20) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.v1.i(m1.c, s1.v1$b):s1.v1$b");
    }

    public x1.a j() {
        return this.f7505b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m1.e<v1.l> k() {
        return this.f7508e;
    }
}
