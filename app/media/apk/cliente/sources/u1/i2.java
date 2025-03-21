package u1;

import android.database.Cursor;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import u1.o0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i2 implements j1, k0 {

    /* renamed from: a  reason: collision with root package name */
    private final a3 f7869a;

    /* renamed from: b  reason: collision with root package name */
    private s1.u0 f7870b;

    /* renamed from: c  reason: collision with root package name */
    private long f7871c = -1;

    /* renamed from: d  reason: collision with root package name */
    private final o0 f7872d;

    /* renamed from: e  reason: collision with root package name */
    private k1 f7873e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i2(a3 a3Var, o0.b bVar) {
        this.f7869a = a3Var;
        this.f7872d = new o0(this, bVar);
    }

    private void A(v1.l lVar) {
        this.f7869a.v("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", f.c(lVar.q()), Long.valueOf(n()));
    }

    private boolean t(v1.l lVar) {
        if (this.f7873e.c(lVar)) {
            return true;
        }
        return x(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(z1.n nVar, Cursor cursor) {
        nVar.accept(Long.valueOf(cursor.getLong(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long v(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(int[] iArr, List list, v1.u[] uVarArr, Cursor cursor) {
        v1.u b5 = f.b(cursor.getString(0));
        v1.l k5 = v1.l.k(b5);
        if (!t(k5)) {
            iArr[0] = iArr[0] + 1;
            list.add(k5);
            y(k5);
        }
        uVarArr[0] = b5;
    }

    private boolean x(v1.l lVar) {
        return !this.f7869a.E("SELECT 1 FROM document_mutations WHERE path = ?").b(f.c(lVar.q())).f();
    }

    private void y(v1.l lVar) {
        this.f7869a.v("DELETE FROM target_documents WHERE path = ? AND target_id = 0", f.c(lVar.q()));
    }

    @Override // u1.k0
    public long a() {
        return this.f7869a.h().s() + ((Long) this.f7869a.E("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)").d(new z1.u() { // from class: u1.f2
            @Override // z1.u
            public final Object apply(Object obj) {
                Long v5;
                v5 = i2.v((Cursor) obj);
                return v5;
            }
        })).longValue();
    }

    @Override // u1.k0
    public int b(long j5, SparseArray<?> sparseArray) {
        return this.f7869a.h().y(j5, sparseArray);
    }

    @Override // u1.j1
    public void c(k1 k1Var) {
        this.f7873e = k1Var;
    }

    @Override // u1.k0
    public int d(long j5) {
        final int[] iArr = new int[1];
        final ArrayList arrayList = new ArrayList();
        final v1.u[] uVarArr = {v1.u.f8153b};
        while (true) {
            for (boolean z4 = true; z4; z4 = false) {
                if (this.f7869a.E("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? AND path > ? LIMIT ?").b(Long.valueOf(j5), f.c(uVarArr[0]), 100).e(new z1.n() { // from class: u1.g2
                    @Override // z1.n
                    public final void accept(Object obj) {
                        i2.this.w(iArr, arrayList, uVarArr, (Cursor) obj);
                    }
                }) == 100) {
                    break;
                }
            }
            this.f7869a.g().removeAll(arrayList);
            return iArr[0];
        }
    }

    @Override // u1.j1
    public void e(v1.l lVar) {
        A(lVar);
    }

    @Override // u1.j1
    public void f() {
        z1.b.d(this.f7871c != -1, "Committing a transaction without having started one", new Object[0]);
        this.f7871c = -1L;
    }

    @Override // u1.k0
    public o0 g() {
        return this.f7872d;
    }

    @Override // u1.k0
    public void h(final z1.n<Long> nVar) {
        this.f7869a.E("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0").e(new z1.n() { // from class: u1.h2
            @Override // z1.n
            public final void accept(Object obj) {
                i2.u(z1.n.this, (Cursor) obj);
            }
        });
    }

    @Override // u1.j1
    public void i() {
        z1.b.d(this.f7871c == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.f7871c = this.f7870b.a();
    }

    @Override // u1.j1
    public void j(i4 i4Var) {
        this.f7869a.h().h(i4Var.l(n()));
    }

    @Override // u1.k0
    public long k() {
        return this.f7869a.w();
    }

    @Override // u1.k0
    public void l(z1.n<i4> nVar) {
        this.f7869a.h().q(nVar);
    }

    @Override // u1.j1
    public void m(v1.l lVar) {
        A(lVar);
    }

    @Override // u1.j1
    public long n() {
        z1.b.d(this.f7871c != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.f7871c;
    }

    @Override // u1.j1
    public void o(v1.l lVar) {
        A(lVar);
    }

    @Override // u1.j1
    public void p(v1.l lVar) {
        A(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(long j5) {
        this.f7870b = new s1.u0(j5);
    }
}
