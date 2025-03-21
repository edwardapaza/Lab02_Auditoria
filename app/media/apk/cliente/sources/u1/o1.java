package u1;

import android.database.Cursor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o1 implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a3 f7954a;

    /* renamed from: b  reason: collision with root package name */
    private final o f7955b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o1(a3 a3Var, o oVar) {
        this.f7954a = a3Var;
        this.f7955b = oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r1.e g(String str, Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new r1.e(str, cursor.getInt(0), new v1.w(new f1.q(cursor.getLong(1), cursor.getInt(2))), cursor.getInt(3), cursor.getLong(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ r1.j h(String str, Cursor cursor) {
        if (cursor != null) {
            try {
                return new r1.j(str, this.f7955b.a(h2.a.l0(cursor.getBlob(2))), new v1.w(new f1.q(cursor.getLong(0), cursor.getInt(1))));
            } catch (com.google.protobuf.e0 e5) {
                throw z1.b.a("NamedQuery failed to parse: %s", e5);
            }
        }
        return null;
    }

    @Override // u1.a
    public r1.e a(final String str) {
        return (r1.e) this.f7954a.E("SELECT schema_version, create_time_seconds, create_time_nanos, total_documents,  total_bytes FROM bundles WHERE bundle_id = ?").b(str).d(new z1.u() { // from class: u1.m1
            @Override // z1.u
            public final Object apply(Object obj) {
                r1.e g5;
                g5 = o1.g(str, (Cursor) obj);
                return g5;
            }
        });
    }

    @Override // u1.a
    public r1.j b(final String str) {
        return (r1.j) this.f7954a.E("SELECT read_time_seconds, read_time_nanos, bundled_query_proto FROM named_queries WHERE name = ?").b(str).d(new z1.u() { // from class: u1.n1
            @Override // z1.u
            public final Object apply(Object obj) {
                r1.j h5;
                h5 = o1.this.h(str, (Cursor) obj);
                return h5;
            }
        });
    }

    @Override // u1.a
    public void c(r1.j jVar) {
        this.f7954a.v("INSERT OR REPLACE INTO named_queries (name, read_time_seconds, read_time_nanos, bundled_query_proto) VALUES (?, ?, ?, ?)", jVar.b(), Long.valueOf(jVar.c().c().n()), Integer.valueOf(jVar.c().c().h()), this.f7955b.j(jVar.a()).j());
    }

    @Override // u1.a
    public void d(r1.e eVar) {
        this.f7954a.v("INSERT OR REPLACE INTO bundles (bundle_id, schema_version, create_time_seconds, create_time_nanos, total_documents, total_bytes) VALUES (?, ?, ?, ?, ?, ?)", eVar.a(), Integer.valueOf(eVar.c()), Long.valueOf(eVar.b().c().n()), Integer.valueOf(eVar.b().c().h()), Integer.valueOf(eVar.e()), Long.valueOf(eVar.d()));
    }
}
