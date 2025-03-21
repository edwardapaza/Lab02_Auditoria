package u1;

import android.database.Cursor;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class x2 implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final a3 f8051a;

    public x2(a3 a3Var) {
        this.f8051a = a3Var;
    }

    private void d() {
        this.f8051a.k("build overlays", new Runnable() { // from class: u1.u2
            @Override // java.lang.Runnable
            public final void run() {
                x2.this.g();
            }
        });
    }

    private Set<String> e() {
        final HashSet hashSet = new HashSet();
        this.f8051a.E("SELECT DISTINCT uid FROM mutation_queues").e(new z1.n() { // from class: u1.w2
            @Override // z1.n
            public final void accept(Object obj) {
                x2.h(hashSet, (Cursor) obj);
            }
        });
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (f()) {
            Set<String> e5 = e();
            l1 g5 = this.f8051a.g();
            for (String str : e5) {
                q1.j jVar = new q1.j(str);
                a3 a3Var = this.f8051a;
                b1 d5 = a3Var.d(jVar, a3Var.c(jVar));
                HashSet hashSet = new HashSet();
                for (w1.g gVar : d5.k()) {
                    hashSet.addAll(gVar.f());
                }
                new n(g5, d5, this.f8051a.b(jVar), this.f8051a.c(jVar)).o(hashSet);
            }
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Set set, Cursor cursor) {
        set.add(cursor.getString(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Boolean[] boolArr, Cursor cursor) {
        try {
            if (e1.f7783b.equals(cursor.getString(0))) {
                boolArr[0] = Boolean.TRUE;
            }
        } catch (IllegalArgumentException e5) {
            throw z1.b.a("SQLitePersistence.DataMigration failed to parse: %s", e5);
        }
    }

    private void j() {
        this.f8051a.v("DELETE FROM data_migrations WHERE migration_name = ?", e1.f7783b);
    }

    boolean f() {
        final Boolean[] boolArr = {Boolean.FALSE};
        this.f8051a.E("SELECT migration_name FROM data_migrations").e(new z1.n() { // from class: u1.v2
            @Override // z1.n
            public final void accept(Object obj) {
                x2.i(boolArr, (Cursor) obj);
            }
        });
        return boolArr[0].booleanValue();
    }

    @Override // u1.c1
    public void run() {
        d();
    }
}
