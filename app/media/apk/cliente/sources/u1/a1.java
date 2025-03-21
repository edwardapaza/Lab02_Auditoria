package u1;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a1 implements h4 {

    /* renamed from: c  reason: collision with root package name */
    private int f7722c;

    /* renamed from: f  reason: collision with root package name */
    private final y0 f7725f;

    /* renamed from: a  reason: collision with root package name */
    private final Map<s1.f1, i4> f7720a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final k1 f7721b = new k1();

    /* renamed from: d  reason: collision with root package name */
    private v1.w f7723d = v1.w.f8154b;

    /* renamed from: e  reason: collision with root package name */
    private long f7724e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(y0 y0Var) {
        this.f7725f = y0Var;
    }

    @Override // u1.h4
    public i4 a(s1.f1 f1Var) {
        return this.f7720a.get(f1Var);
    }

    @Override // u1.h4
    public void b(i4 i4Var) {
        this.f7720a.put(i4Var.g(), i4Var);
        int h5 = i4Var.h();
        if (h5 > this.f7722c) {
            this.f7722c = h5;
        }
        if (i4Var.e() > this.f7724e) {
            this.f7724e = i4Var.e();
        }
    }

    @Override // u1.h4
    public m1.e<v1.l> c(int i5) {
        return this.f7721b.d(i5);
    }

    @Override // u1.h4
    public v1.w d() {
        return this.f7723d;
    }

    @Override // u1.h4
    public void e(int i5) {
        this.f7721b.h(i5);
    }

    @Override // u1.h4
    public void f(m1.e<v1.l> eVar, int i5) {
        this.f7721b.b(eVar, i5);
        j1 f5 = this.f7725f.f();
        Iterator<v1.l> it = eVar.iterator();
        while (it.hasNext()) {
            f5.o(it.next());
        }
    }

    @Override // u1.h4
    public void g(v1.w wVar) {
        this.f7723d = wVar;
    }

    @Override // u1.h4
    public void h(i4 i4Var) {
        b(i4Var);
    }

    @Override // u1.h4
    public void i(m1.e<v1.l> eVar, int i5) {
        this.f7721b.g(eVar, i5);
        j1 f5 = this.f7725f.f();
        Iterator<v1.l> it = eVar.iterator();
        while (it.hasNext()) {
            f5.e(it.next());
        }
    }

    @Override // u1.h4
    public int j() {
        return this.f7722c;
    }

    public boolean k(v1.l lVar) {
        return this.f7721b.c(lVar);
    }

    public void l(z1.n<i4> nVar) {
        for (i4 i4Var : this.f7720a.values()) {
            nVar.accept(i4Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long m(o oVar) {
        long j5 = 0;
        for (Map.Entry<s1.f1, i4> entry : this.f7720a.entrySet()) {
            j5 += oVar.q(entry.getValue()).a();
        }
        return j5;
    }

    public long n() {
        return this.f7724e;
    }

    public long o() {
        return this.f7720a.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p(long j5, SparseArray<?> sparseArray) {
        Iterator<Map.Entry<s1.f1, i4>> it = this.f7720a.entrySet().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            Map.Entry<s1.f1, i4> next = it.next();
            int h5 = next.getValue().h();
            if (next.getValue().e() <= j5 && sparseArray.get(h5) == null) {
                it.remove();
                e(h5);
                i5++;
            }
        }
        return i5;
    }

    public void q(i4 i4Var) {
        this.f7720a.remove(i4Var.g());
        this.f7721b.h(i4Var.h());
    }
}
