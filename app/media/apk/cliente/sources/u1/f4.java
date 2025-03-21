package u1;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;
import java.util.Iterator;
import u1.f4;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f4 implements h4 {

    /* renamed from: a  reason: collision with root package name */
    private final a3 f7812a;

    /* renamed from: b  reason: collision with root package name */
    private final o f7813b;

    /* renamed from: c  reason: collision with root package name */
    private int f7814c;

    /* renamed from: d  reason: collision with root package name */
    private long f7815d;

    /* renamed from: e  reason: collision with root package name */
    private v1.w f7816e = v1.w.f8154b;

    /* renamed from: f  reason: collision with root package name */
    private long f7817f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        m1.e<v1.l> f7818a;

        private b() {
            this.f7818a = v1.l.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        i4 f7819a;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f4(a3 a3Var, o oVar) {
        this.f7812a = a3Var;
        this.f7813b = oVar;
    }

    private void A(i4 i4Var) {
        int h5 = i4Var.h();
        String c5 = i4Var.g().c();
        f1.q c6 = i4Var.f().c();
        this.f7812a.v("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(h5), c5, Long.valueOf(c6.n()), Integer.valueOf(c6.h()), i4Var.d().G(), Long.valueOf(i4Var.e()), this.f7813b.q(i4Var).j());
    }

    private boolean C(i4 i4Var) {
        boolean z4;
        if (i4Var.h() > this.f7814c) {
            this.f7814c = i4Var.h();
            z4 = true;
        } else {
            z4 = false;
        }
        if (i4Var.e() > this.f7815d) {
            this.f7815d = i4Var.e();
            return true;
        }
        return z4;
    }

    private void D() {
        this.f7812a.v("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", Integer.valueOf(this.f7814c), Long.valueOf(this.f7815d), Long.valueOf(this.f7816e.c().n()), Integer.valueOf(this.f7816e.c().h()), Long.valueOf(this.f7817f));
    }

    private i4 p(byte[] bArr) {
        try {
            return this.f7813b.h(x1.c.w0(bArr));
        } catch (com.google.protobuf.e0 e5) {
            throw z1.b.a("TargetData failed to parse: %s", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(z1.n nVar, Cursor cursor) {
        nVar.accept(p(cursor.getBlob(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(b bVar, Cursor cursor) {
        bVar.f7818a = bVar.f7818a.i(v1.l.k(f.b(cursor.getString(0))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(s1.f1 f1Var, c cVar, Cursor cursor) {
        i4 p5 = p(cursor.getBlob(0));
        if (f1Var.equals(p5.g())) {
            cVar.f7819a = p5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(SparseArray sparseArray, int[] iArr, Cursor cursor) {
        int i5 = cursor.getInt(0);
        if (sparseArray.get(i5) == null) {
            z(i5);
            iArr[0] = iArr[0] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(Cursor cursor) {
        this.f7814c = cursor.getInt(0);
        this.f7815d = cursor.getInt(1);
        this.f7816e = new v1.w(new f1.q(cursor.getLong(2), cursor.getInt(3)));
        this.f7817f = cursor.getLong(4);
    }

    private void z(int i5) {
        e(i5);
        this.f7812a.v("DELETE FROM targets WHERE target_id = ?", Integer.valueOf(i5));
        this.f7817f--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        z1.b.d(this.f7812a.E("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").c(new z1.n() { // from class: u1.a4
            @Override // z1.n
            public final void accept(Object obj) {
                f4.this.x((Cursor) obj);
            }
        }) == 1, "Missing target_globals entry", new Object[0]);
    }

    @Override // u1.h4
    public i4 a(final s1.f1 f1Var) {
        String c5 = f1Var.c();
        final c cVar = new c();
        this.f7812a.E("SELECT target_proto FROM targets WHERE canonical_id = ?").b(c5).e(new z1.n() { // from class: u1.b4
            @Override // z1.n
            public final void accept(Object obj) {
                f4.this.v(f1Var, cVar, (Cursor) obj);
            }
        });
        return cVar.f7819a;
    }

    @Override // u1.h4
    public void b(i4 i4Var) {
        A(i4Var);
        C(i4Var);
        this.f7817f++;
        D();
    }

    @Override // u1.h4
    public m1.e<v1.l> c(int i5) {
        final b bVar = new b();
        this.f7812a.E("SELECT path FROM target_documents WHERE target_id = ?").b(Integer.valueOf(i5)).e(new z1.n() { // from class: u1.c4
            @Override // z1.n
            public final void accept(Object obj) {
                f4.u(f4.b.this, (Cursor) obj);
            }
        });
        return bVar.f7818a;
    }

    @Override // u1.h4
    public v1.w d() {
        return this.f7816e;
    }

    @Override // u1.h4
    public void e(int i5) {
        this.f7812a.v("DELETE FROM target_documents WHERE target_id = ?", Integer.valueOf(i5));
    }

    @Override // u1.h4
    public void f(m1.e<v1.l> eVar, int i5) {
        SQLiteStatement D = this.f7812a.D("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
        i2 f5 = this.f7812a.f();
        Iterator<v1.l> it = eVar.iterator();
        while (it.hasNext()) {
            v1.l next = it.next();
            this.f7812a.u(D, Integer.valueOf(i5), f.c(next.q()));
            f5.o(next);
        }
    }

    @Override // u1.h4
    public void g(v1.w wVar) {
        this.f7816e = wVar;
        D();
    }

    @Override // u1.h4
    public void h(i4 i4Var) {
        A(i4Var);
        if (C(i4Var)) {
            D();
        }
    }

    @Override // u1.h4
    public void i(m1.e<v1.l> eVar, int i5) {
        SQLiteStatement D = this.f7812a.D("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
        i2 f5 = this.f7812a.f();
        Iterator<v1.l> it = eVar.iterator();
        while (it.hasNext()) {
            v1.l next = it.next();
            this.f7812a.u(D, Integer.valueOf(i5), f.c(next.q()));
            f5.e(next);
        }
    }

    @Override // u1.h4
    public int j() {
        return this.f7814c;
    }

    public void q(final z1.n<i4> nVar) {
        this.f7812a.E("SELECT target_proto FROM targets").e(new z1.n() { // from class: u1.e4
            @Override // z1.n
            public final void accept(Object obj) {
                f4.this.t(nVar, (Cursor) obj);
            }
        });
    }

    public long r() {
        return this.f7815d;
    }

    public long s() {
        return this.f7817f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y(long j5, final SparseArray<?> sparseArray) {
        final int[] iArr = new int[1];
        this.f7812a.E("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").b(Long.valueOf(j5)).e(new z1.n() { // from class: u1.d4
            @Override // z1.n
            public final void accept(Object obj) {
                f4.this.w(sparseArray, iArr, (Cursor) obj);
            }
        });
        D();
        return iArr[0];
    }
}
