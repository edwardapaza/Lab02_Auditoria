package u1;

import android.database.Cursor;
import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import u1.a3;
import v1.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g3 implements l1 {

    /* renamed from: a  reason: collision with root package name */
    private final a3 f7834a;

    /* renamed from: b  reason: collision with root package name */
    private final o f7835b;

    /* renamed from: c  reason: collision with root package name */
    private l f7836c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g3(a3 a3Var, o oVar) {
        this.f7834a = a3Var;
        this.f7835b = oVar;
    }

    private v1.s k(byte[] bArr, int i5, int i6) {
        try {
            return this.f7835b.d(x1.a.o0(bArr)).v(new v1.w(new f1.q(i5, i6)));
        } catch (com.google.protobuf.e0 e5) {
            throw z1.b.a("MaybeDocument failed to parse: %s", e5);
        }
    }

    private Map<v1.l, v1.s> l(List<v1.u> list, q.a aVar, int i5, z1.u<v1.s, Boolean> uVar) {
        return m(list, aVar, i5, uVar, null);
    }

    private Map<v1.l, v1.s> m(List<v1.u> list, q.a aVar, int i5, final z1.u<v1.s, Boolean> uVar, final f1 f1Var) {
        f1.q c5 = aVar.n().c();
        v1.l k5 = aVar.k();
        StringBuilder z4 = z1.h0.z("SELECT contents, read_time_seconds, read_time_nanos, path FROM remote_documents WHERE path >= ? AND path < ? AND path_length = ? AND (read_time_seconds > ? OR ( read_time_seconds = ? AND read_time_nanos > ?) OR ( read_time_seconds = ? AND read_time_nanos = ? and path > ?)) ", list.size(), " UNION ");
        z4.append("ORDER BY read_time_seconds, read_time_nanos, path LIMIT ?");
        Object[] objArr = new Object[(list.size() * 9) + 1];
        int i6 = 0;
        for (v1.u uVar2 : list) {
            String c6 = f.c(uVar2);
            int i7 = i6 + 1;
            objArr[i6] = c6;
            int i8 = i7 + 1;
            objArr[i7] = f.f(c6);
            int i9 = i8 + 1;
            objArr[i8] = Integer.valueOf(uVar2.p() + 1);
            int i10 = i9 + 1;
            objArr[i9] = Long.valueOf(c5.n());
            int i11 = i10 + 1;
            objArr[i10] = Long.valueOf(c5.n());
            int i12 = i11 + 1;
            objArr[i11] = Integer.valueOf(c5.h());
            int i13 = i12 + 1;
            objArr[i12] = Long.valueOf(c5.n());
            int i14 = i13 + 1;
            objArr[i13] = Integer.valueOf(c5.h());
            objArr[i14] = f.c(k5.q());
            i6 = i14 + 1;
        }
        objArr[i6] = Integer.valueOf(i5);
        final z1.m mVar = new z1.m();
        final HashMap hashMap = new HashMap();
        this.f7834a.E(z4.toString()).b(objArr).e(new z1.n() { // from class: u1.e3
            @Override // z1.n
            public final void accept(Object obj) {
                g3.this.o(mVar, hashMap, uVar, f1Var, (Cursor) obj);
            }
        });
        mVar.b();
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(z1.m mVar, Map map, Cursor cursor) {
        r(mVar, map, cursor, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(z1.m mVar, Map map, z1.u uVar, f1 f1Var, Cursor cursor) {
        r(mVar, map, cursor, uVar);
        if (f1Var != null) {
            f1Var.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean p(s1.a1 a1Var, Set set, v1.s sVar) {
        return Boolean.valueOf(a1Var.u(sVar) || set.contains(sVar.getKey()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(byte[] bArr, int i5, int i6, z1.u uVar, Map map) {
        v1.s k5 = k(bArr, i5, i6);
        if (uVar == null || ((Boolean) uVar.apply(k5)).booleanValue()) {
            synchronized (map) {
                map.put(k5.getKey(), k5);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.concurrent.Executor] */
    private void r(z1.m mVar, final Map<v1.l, v1.s> map, Cursor cursor, final z1.u<v1.s, Boolean> uVar) {
        final byte[] blob = cursor.getBlob(0);
        final int i5 = cursor.getInt(1);
        final int i6 = cursor.getInt(2);
        z1.m mVar2 = mVar;
        if (cursor.isLast()) {
            mVar2 = z1.p.f8961b;
        }
        mVar2.execute(new Runnable() { // from class: u1.f3
            @Override // java.lang.Runnable
            public final void run() {
                g3.this.q(blob, i5, i6, uVar, map);
            }
        });
    }

    @Override // u1.l1
    public void a(v1.s sVar, v1.w wVar) {
        z1.b.d(!wVar.equals(v1.w.f8154b), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        v1.l key = sVar.getKey();
        f1.q c5 = wVar.c();
        this.f7834a.v("INSERT OR REPLACE INTO remote_documents (path, path_length, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?, ?)", f.c(key.q()), Integer.valueOf(key.q().p()), Long.valueOf(c5.n()), Integer.valueOf(c5.h()), this.f7835b.m(sVar).j());
        this.f7836c.j(sVar.getKey().o());
    }

    @Override // u1.l1
    public Map<v1.l, v1.s> b(final s1.a1 a1Var, q.a aVar, final Set<v1.l> set, f1 f1Var) {
        return m(Collections.singletonList(a1Var.n()), aVar, a.e.API_PRIORITY_OTHER, new z1.u() { // from class: u1.c3
            @Override // z1.u
            public final Object apply(Object obj) {
                Boolean p5;
                p5 = g3.p(s1.a1.this, set, (v1.s) obj);
                return p5;
            }
        }, f1Var);
    }

    @Override // u1.l1
    public Map<v1.l, v1.s> c(String str, q.a aVar, int i5) {
        List<v1.u> c5 = this.f7836c.c(str);
        ArrayList arrayList = new ArrayList(c5.size());
        for (v1.u uVar : c5) {
            arrayList.add(uVar.a(str));
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyMap();
        }
        if (arrayList.size() * 9 < 900) {
            return l(arrayList, aVar, i5, null);
        }
        HashMap hashMap = new HashMap();
        int i6 = 0;
        while (i6 < arrayList.size()) {
            int i7 = i6 + 100;
            hashMap.putAll(l(arrayList.subList(i6, Math.min(arrayList.size(), i7)), aVar, i5, null));
            i6 = i7;
        }
        return z1.h0.u(hashMap, i5, q.a.f8129b);
    }

    @Override // u1.l1
    public v1.s d(v1.l lVar) {
        return f(Collections.singletonList(lVar)).get(lVar);
    }

    @Override // u1.l1
    public void e(l lVar) {
        this.f7836c = lVar;
    }

    @Override // u1.l1
    public Map<v1.l, v1.s> f(Iterable<v1.l> iterable) {
        final HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (v1.l lVar : iterable) {
            arrayList.add(f.c(lVar.q()));
            hashMap.put(lVar, v1.s.q(lVar));
        }
        a3.b bVar = new a3.b(this.f7834a, "SELECT contents, read_time_seconds, read_time_nanos FROM remote_documents WHERE path IN (", arrayList, ") ORDER BY path");
        final z1.m mVar = new z1.m();
        while (bVar.d()) {
            bVar.e().e(new z1.n() { // from class: u1.d3
                @Override // z1.n
                public final void accept(Object obj) {
                    g3.this.n(mVar, hashMap, (Cursor) obj);
                }
            });
        }
        mVar.b();
        return hashMap;
    }

    @Override // u1.l1
    public void removeAll(Collection<v1.l> collection) {
        if (collection.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        m1.c<v1.l, v1.i> a5 = v1.j.a();
        for (v1.l lVar : collection) {
            arrayList.add(f.c(lVar.q()));
            a5 = a5.m(lVar, v1.s.r(lVar, v1.w.f8154b));
        }
        a3.b bVar = new a3.b(this.f7834a, "DELETE FROM remote_documents WHERE path IN (", arrayList, ")");
        while (bVar.d()) {
            bVar.a();
        }
        this.f7836c.a(a5);
    }
}
