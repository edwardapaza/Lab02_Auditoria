package u1;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import u1.a3;
/* loaded from: classes.dex */
public class v1 implements b {

    /* renamed from: a  reason: collision with root package name */
    private final a3 f8035a;

    /* renamed from: b  reason: collision with root package name */
    private final o f8036b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8037c;

    public v1(a3 a3Var, o oVar, q1.j jVar) {
        this.f8035a = a3Var;
        this.f8036b = oVar;
        this.f8037c = jVar.b() ? jVar.a() : "";
    }

    private w1.k m(byte[] bArr, int i5) {
        try {
            return w1.k.a(i5, this.f8036b.e(i2.e0.A0(bArr)));
        } catch (com.google.protobuf.e0 e5) {
            throw z1.b.a("Overlay failed to parse: %s", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ w1.k n(Cursor cursor) {
        return m(cursor.getBlob(0), cursor.getInt(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int[] iArr, String[] strArr, String[] strArr2, z1.m mVar, Map map, Cursor cursor) {
        iArr[0] = cursor.getInt(1);
        strArr[0] = cursor.getString(2);
        strArr2[0] = cursor.getString(3);
        s(mVar, map, cursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(byte[] bArr, int i5, Map map) {
        w1.k m5 = m(bArr, i5);
        synchronized (map) {
            map.put(m5.b(), m5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.concurrent.Executor] */
    /* renamed from: t */
    public void s(z1.m mVar, final Map<v1.l, w1.k> map, Cursor cursor) {
        final byte[] blob = cursor.getBlob(0);
        final int i5 = cursor.getInt(1);
        z1.m mVar2 = mVar;
        if (cursor.isLast()) {
            mVar2 = z1.p.f8961b;
        }
        mVar2.execute(new Runnable() { // from class: u1.s1
            @Override // java.lang.Runnable
            public final void run() {
                v1.this.r(blob, i5, map);
            }
        });
    }

    private void u(final Map<v1.l, w1.k> map, final z1.m mVar, v1.u uVar, List<Object> list) {
        if (list.isEmpty()) {
            return;
        }
        a3.b bVar = new a3.b(this.f8035a, "SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id IN (", Arrays.asList(this.f8037c, f.c(uVar)), list, ")");
        while (bVar.d()) {
            bVar.e().e(new z1.n() { // from class: u1.q1
                @Override // z1.n
                public final void accept(Object obj) {
                    v1.this.s(mVar, map, (Cursor) obj);
                }
            });
        }
    }

    private void v(int i5, v1.l lVar, w1.f fVar) {
        this.f8035a.v("INSERT OR REPLACE INTO document_overlays (uid, collection_group, collection_path, document_id, largest_batch_id, overlay_mutation) VALUES (?, ?, ?, ?, ?, ?)", this.f8037c, lVar.n(), f.c(lVar.q().r()), lVar.q().k(), Integer.valueOf(i5), this.f8036b.n(fVar).j());
    }

    @Override // u1.b
    public w1.k a(v1.l lVar) {
        return (w1.k) this.f8035a.E("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id = ?").b(this.f8037c, f.c(lVar.q().r()), lVar.q().k()).d(new z1.u() { // from class: u1.p1
            @Override // z1.u
            public final Object apply(Object obj) {
                w1.k n5;
                n5 = v1.this.n((Cursor) obj);
                return n5;
            }
        });
    }

    @Override // u1.b
    public Map<v1.l, w1.k> b(SortedSet<v1.l> sortedSet) {
        z1.b.d(sortedSet.comparator() == null, "getOverlays() requires natural order", new Object[0]);
        HashMap hashMap = new HashMap();
        z1.m mVar = new z1.m();
        v1.u uVar = v1.u.f8153b;
        ArrayList arrayList = new ArrayList();
        for (v1.l lVar : sortedSet) {
            if (!uVar.equals(lVar.o())) {
                u(hashMap, mVar, uVar, arrayList);
                uVar = lVar.o();
                arrayList.clear();
            }
            arrayList.add(lVar.p());
        }
        u(hashMap, mVar, uVar, arrayList);
        mVar.b();
        return hashMap;
    }

    @Override // u1.b
    public void c(int i5) {
        this.f8035a.v("DELETE FROM document_overlays WHERE uid = ? AND largest_batch_id = ?", this.f8037c, Integer.valueOf(i5));
    }

    @Override // u1.b
    public Map<v1.l, w1.k> d(v1.u uVar, int i5) {
        final HashMap hashMap = new HashMap();
        final z1.m mVar = new z1.m();
        this.f8035a.E("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND largest_batch_id > ?").b(this.f8037c, f.c(uVar), Integer.valueOf(i5)).e(new z1.n() { // from class: u1.r1
            @Override // z1.n
            public final void accept(Object obj) {
                v1.this.o(mVar, hashMap, (Cursor) obj);
            }
        });
        mVar.b();
        return hashMap;
    }

    @Override // u1.b
    public void e(int i5, Map<v1.l, w1.f> map) {
        for (Map.Entry<v1.l, w1.f> entry : map.entrySet()) {
            v1.l key = entry.getKey();
            v(i5, key, (w1.f) z1.y.d(entry.getValue(), "null value for key: %s", key));
        }
    }

    @Override // u1.b
    public Map<v1.l, w1.k> f(String str, int i5, int i6) {
        final HashMap hashMap = new HashMap();
        final String[] strArr = new String[1];
        final String[] strArr2 = new String[1];
        final int[] iArr = new int[1];
        final z1.m mVar = new z1.m();
        this.f8035a.E("SELECT overlay_mutation, largest_batch_id, collection_path, document_id  FROM document_overlays WHERE uid = ? AND collection_group = ? AND largest_batch_id > ? ORDER BY largest_batch_id, collection_path, document_id LIMIT ?").b(this.f8037c, str, Integer.valueOf(i5), Integer.valueOf(i6)).e(new z1.n() { // from class: u1.t1
            @Override // z1.n
            public final void accept(Object obj) {
                v1.this.p(iArr, strArr, strArr2, mVar, hashMap, (Cursor) obj);
            }
        });
        if (strArr[0] == null) {
            return hashMap;
        }
        a3.d E = this.f8035a.E("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_group = ? AND (collection_path > ? OR (collection_path = ? AND document_id > ?)) AND largest_batch_id = ?");
        String str2 = strArr[0];
        E.b(this.f8037c, str, str2, str2, strArr2[0], Integer.valueOf(iArr[0])).e(new z1.n() { // from class: u1.u1
            @Override // z1.n
            public final void accept(Object obj) {
                v1.this.q(mVar, hashMap, (Cursor) obj);
            }
        });
        mVar.b();
        return hashMap;
    }
}
