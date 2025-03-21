package u1;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import u1.a3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t2 implements b1 {

    /* renamed from: a  reason: collision with root package name */
    private final a3 f8008a;

    /* renamed from: b  reason: collision with root package name */
    private final o f8009b;

    /* renamed from: c  reason: collision with root package name */
    private final l f8010c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8011d;

    /* renamed from: e  reason: collision with root package name */
    private int f8012e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.protobuf.i f8013f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements z1.n<Cursor> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<com.google.protobuf.i> f8014a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private boolean f8015b = true;

        a(byte[] bArr) {
            c(bArr);
        }

        private void c(byte[] bArr) {
            this.f8014a.add(com.google.protobuf.i.p(bArr));
        }

        @Override // z1.n
        /* renamed from: a */
        public void accept(Cursor cursor) {
            byte[] blob = cursor.getBlob(0);
            c(blob);
            if (blob.length < 1000000) {
                this.f8015b = false;
            }
        }

        int d() {
            return this.f8014a.size();
        }

        com.google.protobuf.i e() {
            return com.google.protobuf.i.o(this.f8014a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t2(a3 a3Var, o oVar, q1.j jVar, l lVar) {
        this.f8008a = a3Var;
        this.f8009b = oVar;
        this.f8011d = jVar.b() ? jVar.a() : "";
        this.f8013f = y1.b1.f8359v;
        this.f8010c = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer A(Cursor cursor) {
        return Integer.valueOf(cursor.getInt(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ w1.g B(Cursor cursor) {
        return v(cursor.getInt(0), cursor.getBlob(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(List list, Cursor cursor) {
        list.add(cursor.getString(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(Cursor cursor) {
        this.f8012e = Math.max(this.f8012e, cursor.getInt(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ w1.g E(int i5, Cursor cursor) {
        return v(i5, cursor.getBlob(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(List list, Cursor cursor) {
        list.add(f.b(cursor.getString(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(Cursor cursor) {
        this.f8013f = com.google.protobuf.i.p(cursor.getBlob(0));
    }

    private void H() {
        final ArrayList arrayList = new ArrayList();
        this.f8008a.E("SELECT uid FROM mutation_queues").e(new z1.n() { // from class: u1.o2
            @Override // z1.n
            public final void accept(Object obj) {
                t2.C(arrayList, (Cursor) obj);
            }
        });
        this.f8012e = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f8008a.E("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").b((String) it.next()).e(new z1.n() { // from class: u1.p2
                @Override // z1.n
                public final void accept(Object obj) {
                    t2.this.D((Cursor) obj);
                }
            });
        }
        this.f8012e++;
    }

    private void I() {
        this.f8008a.v("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", this.f8011d, -1, this.f8013f.G());
    }

    private w1.g v(int i5, byte[] bArr) {
        try {
            if (bArr.length < 1000000) {
                return this.f8009b.f(x1.e.u0(bArr));
            }
            a aVar = new a(bArr);
            while (aVar.f8015b) {
                this.f8008a.E("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").b(Integer.valueOf((aVar.d() * 1000000) + 1), 1000000, this.f8011d, Integer.valueOf(i5)).c(aVar);
            }
            return this.f8009b.f(x1.e.t0(aVar.e()));
        } catch (com.google.protobuf.e0 e5) {
            throw z1.b.a("MutationBatch failed to parse: %s", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(List list, Cursor cursor) {
        list.add(v(cursor.getInt(0), cursor.getBlob(1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Set set, List list, Cursor cursor) {
        int i5 = cursor.getInt(0);
        if (set.contains(Integer.valueOf(i5))) {
            return;
        }
        set.add(Integer.valueOf(i5));
        list.add(v(i5, cursor.getBlob(1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int z(w1.g gVar, w1.g gVar2) {
        return z1.h0.l(gVar.e(), gVar2.e());
    }

    @Override // u1.b1
    public void a() {
        if (w()) {
            final ArrayList arrayList = new ArrayList();
            this.f8008a.E("SELECT path FROM document_mutations WHERE uid = ?").b(this.f8011d).e(new z1.n() { // from class: u1.r2
                @Override // z1.n
                public final void accept(Object obj) {
                    t2.F(arrayList, (Cursor) obj);
                }
            });
            z1.b.d(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", arrayList);
        }
    }

    @Override // u1.b1
    public w1.g b(int i5) {
        return (w1.g) this.f8008a.E("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").b(1000000, this.f8011d, Integer.valueOf(i5 + 1)).d(new z1.u() { // from class: u1.j2
            @Override // z1.u
            public final Object apply(Object obj) {
                w1.g B;
                B = t2.this.B((Cursor) obj);
                return B;
            }
        });
    }

    @Override // u1.b1
    public int c() {
        return ((Integer) this.f8008a.E("SELECT IFNULL(MAX(batch_id), ?) FROM mutations WHERE uid = ?").b(-1, this.f8011d).d(new z1.u() { // from class: u1.s2
            @Override // z1.u
            public final Object apply(Object obj) {
                Integer A;
                A = t2.A((Cursor) obj);
                return A;
            }
        })).intValue();
    }

    @Override // u1.b1
    public List<w1.g> d(Iterable<v1.l> iterable) {
        ArrayList arrayList = new ArrayList();
        for (v1.l lVar : iterable) {
            arrayList.add(f.c(lVar.q()));
        }
        a3.b bVar = new a3.b(this.f8008a, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(1000000, this.f8011d), arrayList, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
        final ArrayList arrayList2 = new ArrayList();
        final HashSet hashSet = new HashSet();
        while (bVar.d()) {
            bVar.e().e(new z1.n() { // from class: u1.m2
                @Override // z1.n
                public final void accept(Object obj) {
                    t2.this.y(hashSet, arrayList2, (Cursor) obj);
                }
            });
        }
        if (bVar.c() > 1) {
            Collections.sort(arrayList2, new Comparator() { // from class: u1.n2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int z4;
                    z4 = t2.z((w1.g) obj, (w1.g) obj2);
                    return z4;
                }
            });
        }
        return arrayList2;
    }

    @Override // u1.b1
    public w1.g e(final int i5) {
        return (w1.g) this.f8008a.E("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").b(1000000, this.f8011d, Integer.valueOf(i5)).d(new z1.u() { // from class: u1.q2
            @Override // z1.u
            public final Object apply(Object obj) {
                w1.g E;
                E = t2.this.E(i5, (Cursor) obj);
                return E;
            }
        });
    }

    @Override // u1.b1
    public void f(w1.g gVar) {
        SQLiteStatement D = this.f8008a.D("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        SQLiteStatement D2 = this.f8008a.D("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
        int e5 = gVar.e();
        z1.b.d(this.f8008a.u(D, this.f8011d, Integer.valueOf(e5)) != 0, "Mutation batch (%s, %d) did not exist", this.f8011d, Integer.valueOf(gVar.e()));
        for (w1.f fVar : gVar.h()) {
            v1.l g5 = fVar.g();
            this.f8008a.u(D2, this.f8011d, f.c(g5.q()), Integer.valueOf(e5));
            this.f8008a.f().m(g5);
        }
    }

    @Override // u1.b1
    public com.google.protobuf.i g() {
        return this.f8013f;
    }

    @Override // u1.b1
    public void h(w1.g gVar, com.google.protobuf.i iVar) {
        this.f8013f = (com.google.protobuf.i) z1.y.b(iVar);
        I();
    }

    @Override // u1.b1
    public void i(com.google.protobuf.i iVar) {
        this.f8013f = (com.google.protobuf.i) z1.y.b(iVar);
        I();
    }

    @Override // u1.b1
    public w1.g j(f1.q qVar, List<w1.f> list, List<w1.f> list2) {
        int i5 = this.f8012e;
        this.f8012e = i5 + 1;
        w1.g gVar = new w1.g(i5, qVar, list, list2);
        this.f8008a.v("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", this.f8011d, Integer.valueOf(i5), this.f8009b.o(gVar).j());
        HashSet hashSet = new HashSet();
        SQLiteStatement D = this.f8008a.D("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
        for (w1.f fVar : list2) {
            v1.l g5 = fVar.g();
            if (hashSet.add(g5)) {
                this.f8008a.u(D, this.f8011d, f.c(g5.q()), Integer.valueOf(i5));
                this.f8010c.j(g5.o());
            }
        }
        return gVar;
    }

    @Override // u1.b1
    public List<w1.g> k() {
        final ArrayList arrayList = new ArrayList();
        this.f8008a.E("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").b(1000000, this.f8011d).e(new z1.n() { // from class: u1.k2
            @Override // z1.n
            public final void accept(Object obj) {
                t2.this.x(arrayList, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // u1.b1
    public void start() {
        H();
        if (this.f8008a.E("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").b(this.f8011d).c(new z1.n() { // from class: u1.l2
            @Override // z1.n
            public final void accept(Object obj) {
                t2.this.G((Cursor) obj);
            }
        }) == 0) {
            I();
        }
    }

    public boolean w() {
        return this.f8008a.E("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").b(this.f8011d).f();
    }
}
