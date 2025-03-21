package e3;

import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.a0;
import com.google.firebase.firestore.c1;
import com.google.firebase.firestore.h;
import com.google.firebase.firestore.j0;
import com.google.firebase.firestore.n;
import com.google.firebase.firestore.r0;
import com.google.firebase.firestore.w0;
import com.google.firebase.firestore.y0;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
class c extends z2.p {

    /* renamed from: d  reason: collision with root package name */
    public static final c f2680d = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2681a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2682b;

        static {
            int[] iArr = new int[j0.a.values().length];
            f2682b = iArr;
            try {
                iArr[j0.a.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2682b[j0.a.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2682b[j0.a.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[h.b.values().length];
            f2681a = iArr2;
            try {
                iArr2[h.b.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2681a[h.b.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2681a[h.b.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (r1.equals("not-in") == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.firebase.firestore.s q(java.util.Map<java.lang.String, java.lang.Object> r7) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.c.q(java.util.Map):com.google.firebase.firestore.s");
    }

    private FirebaseFirestore r(ByteBuffer byteBuffer) {
        String str = (String) f(byteBuffer);
        String str2 = (String) f(byteBuffer);
        com.google.firebase.firestore.a0 a0Var = (com.google.firebase.firestore.a0) f(byteBuffer);
        synchronized (w.f2800h) {
            if (w.a0(str, str2) != null) {
                return w.a0(str, str2);
            }
            FirebaseFirestore u5 = FirebaseFirestore.u(f1.f.p(str), str2);
            u5.J(a0Var);
            w.z0(u5, str2);
            return u5;
        }
    }

    private w0 s(ByteBuffer byteBuffer) {
        try {
            Map map = (Map) f(byteBuffer);
            Object obj = map.get("firestore");
            Objects.requireNonNull(obj);
            FirebaseFirestore firebaseFirestore = (FirebaseFirestore) obj;
            Object obj2 = map.get("path");
            Objects.requireNonNull(obj2);
            String str = (String) obj2;
            boolean booleanValue = ((Boolean) map.get("isCollectionGroup")).booleanValue();
            Map map2 = (Map) map.get("parameters");
            w0 m5 = booleanValue ? firebaseFirestore.m(str) : firebaseFirestore.l(str);
            if (map2 == null) {
                return m5;
            }
            if (map2.containsKey("filters")) {
                Object obj3 = map2.get("filters");
                Objects.requireNonNull(obj3);
                m5 = m5.G(q((Map) obj3));
            }
            Object obj4 = map2.get("where");
            Objects.requireNonNull(obj4);
            for (List list : (List) obj4) {
                com.google.firebase.firestore.q qVar = (com.google.firebase.firestore.q) list.get(0);
                String str2 = (String) list.get(1);
                Object obj5 = list.get(2);
                if ("==".equals(str2)) {
                    m5 = m5.J(qVar, obj5);
                } else if ("!=".equals(str2)) {
                    m5 = m5.P(qVar, obj5);
                } else if ("<".equals(str2)) {
                    m5 = m5.N(qVar, obj5);
                } else if ("<=".equals(str2)) {
                    m5 = m5.O(qVar, obj5);
                } else if (">".equals(str2)) {
                    m5 = m5.K(qVar, obj5);
                } else if (">=".equals(str2)) {
                    m5 = m5.L(qVar, obj5);
                } else if ("array-contains".equals(str2)) {
                    m5 = m5.H(qVar, obj5);
                } else if ("array-contains-any".equals(str2)) {
                    m5 = m5.I(qVar, (List) obj5);
                } else if ("in".equals(str2)) {
                    m5 = m5.M(qVar, (List) obj5);
                } else if ("not-in".equals(str2)) {
                    m5 = m5.Q(qVar, (List) obj5);
                } else {
                    Log.w("FLTFirestoreMsgCodec", "An invalid query operator " + str2 + " was received but not handled.");
                }
            }
            Number number = (Number) map2.get("limit");
            if (number != null) {
                m5 = m5.s(number.longValue());
            }
            Number number2 = (Number) map2.get("limitToLast");
            if (number2 != null) {
                m5 = m5.t(number2.longValue());
            }
            List<List> list2 = (List) map2.get("orderBy");
            if (list2 == null) {
                return m5;
            }
            for (List list3 : list2) {
                m5 = m5.u((com.google.firebase.firestore.q) list3.get(0), ((Boolean) list3.get(1)).booleanValue() ? w0.c.DESCENDING : w0.c.ASCENDING);
            }
            List list4 = (List) map2.get("startAt");
            if (list4 != null) {
                Object[] array = list4.toArray();
                Objects.requireNonNull(array);
                m5 = m5.B(array);
            }
            List list5 = (List) map2.get("startAfter");
            if (list5 != null) {
                Object[] array2 = list5.toArray();
                Objects.requireNonNull(array2);
                m5 = m5.A(array2);
            }
            List list6 = (List) map2.get("endAt");
            if (list6 != null) {
                Object[] array3 = list6.toArray();
                Objects.requireNonNull(array3);
                m5 = m5.i(array3);
            }
            List list7 = (List) map2.get("endBefore");
            if (list7 != null) {
                Object[] array4 = list7.toArray();
                Objects.requireNonNull(array4);
                return m5.j(array4);
            }
            return m5;
        } catch (Exception e5) {
            Log.e("FLTFirestoreMsgCodec", "An error occurred while parsing query arguments, this is most likely an error with this SDK.", e5);
            return null;
        }
    }

    private com.google.firebase.firestore.a0 t(ByteBuffer byteBuffer) {
        com.google.firebase.firestore.k0 a5;
        Map map = (Map) f(byteBuffer);
        a0.b bVar = new a0.b();
        if (map.get("persistenceEnabled") != null) {
            if (Boolean.TRUE.equals((Boolean) map.get("persistenceEnabled"))) {
                r0.b b5 = com.google.firebase.firestore.r0.b();
                if (map.get("cacheSizeBytes") != null) {
                    Long l5 = 104857600L;
                    Object obj = map.get("cacheSizeBytes");
                    if (obj instanceof Long) {
                        l5 = (Long) obj;
                    } else if (obj instanceof Integer) {
                        l5 = Long.valueOf(((Integer) obj).intValue());
                    }
                    if (l5.longValue() == -1) {
                        b5.b(-1L);
                    } else {
                        b5.b(l5.longValue());
                    }
                }
                a5 = b5.a();
            } else {
                a5 = com.google.firebase.firestore.l0.b().a();
            }
            bVar.h(a5);
        }
        if (map.get("host") != null) {
            Object obj2 = map.get("host");
            Objects.requireNonNull(obj2);
            bVar.g((String) obj2);
            if (map.get("sslEnabled") != null) {
                Object obj3 = map.get("sslEnabled");
                Objects.requireNonNull(obj3);
                bVar.i(((Boolean) obj3).booleanValue());
            }
        }
        return bVar.f();
    }

    private Object[] u(Object obj) {
        if (obj instanceof List) {
            return ((List) obj).toArray();
        }
        if (obj == null) {
            return new ArrayList().toArray();
        }
        throw new IllegalArgumentException(String.format("java.util.List was expected, unable to convert '%s' to an object array", obj.getClass().getCanonicalName()));
    }

    private void v(ByteArrayOutputStream byteArrayOutputStream, com.google.firebase.firestore.h hVar) {
        HashMap hashMap = new HashMap();
        int i5 = a.f2681a[hVar.e().ordinal()];
        hashMap.put("type", i5 != 1 ? i5 != 2 ? i5 != 3 ? null : "DocumentChangeType.removed" : "DocumentChangeType.modified" : "DocumentChangeType.added");
        hashMap.put("data", hVar.b().d());
        hashMap.put("path", hVar.b().g().l());
        hashMap.put("oldIndex", Integer.valueOf(hVar.d()));
        hashMap.put("newIndex", Integer.valueOf(hVar.c()));
        hashMap.put("metadata", hVar.b().f());
        p(byteArrayOutputStream, hashMap);
    }

    private void w(ByteArrayOutputStream byteArrayOutputStream, com.google.firebase.firestore.n nVar) {
        Map<String, Object> map;
        HashMap hashMap = new HashMap();
        hashMap.put("path", nVar.g().l());
        if (nVar.a()) {
            n.a aVar = w.f2801i.get(Integer.valueOf(nVar.hashCode()));
            map = aVar != null ? nVar.e(aVar) : nVar.d();
        } else {
            map = null;
        }
        hashMap.put("data", map);
        hashMap.put("metadata", nVar.f());
        w.f2801i.remove(Integer.valueOf(nVar.hashCode()));
        p(byteArrayOutputStream, hashMap);
    }

    private void x(ByteArrayOutputStream byteArrayOutputStream, com.google.firebase.firestore.j0 j0Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("bytesLoaded", Long.valueOf(j0Var.c()));
        hashMap.put("documentsLoaded", Integer.valueOf(j0Var.d()));
        hashMap.put("totalBytes", Long.valueOf(j0Var.f()));
        hashMap.put("totalDocuments", Integer.valueOf(j0Var.g()));
        int i5 = a.f2682b[j0Var.e().ordinal()];
        String str = "running";
        if (i5 != 1) {
            if (i5 == 2) {
                str = "success";
            } else if (i5 == 3) {
                str = "error";
            }
        }
        hashMap.put("taskState", str);
        p(byteArrayOutputStream, hashMap);
    }

    private void y(ByteArrayOutputStream byteArrayOutputStream, y0 y0Var) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        n.a aVar = w.f2801i.get(Integer.valueOf(y0Var.hashCode()));
        for (com.google.firebase.firestore.n nVar : y0Var.l()) {
            arrayList.add(nVar.g().l());
            arrayList2.add(aVar != null ? nVar.e(aVar) : nVar.d());
            arrayList3.add(nVar.f());
        }
        hashMap.put("paths", arrayList);
        hashMap.put("documents", arrayList2);
        hashMap.put("metadatas", arrayList3);
        hashMap.put("documentChanges", y0Var.i());
        hashMap.put("metadata", y0Var.m());
        w.f2801i.remove(Integer.valueOf(y0Var.hashCode()));
        p(byteArrayOutputStream, hashMap);
    }

    private void z(ByteArrayOutputStream byteArrayOutputStream, c1 c1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("hasPendingWrites", Boolean.valueOf(c1Var.a()));
        hashMap.put("isFromCache", Boolean.valueOf(c1Var.b()));
        p(byteArrayOutputStream, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z2.p
    public Object g(byte b5, ByteBuffer byteBuffer) {
        switch (b5) {
            case -76:
                return new Date(byteBuffer.getLong());
            case -75:
                z2.p.c(byteBuffer, 8);
                return new com.google.firebase.firestore.d0(byteBuffer.getDouble(), byteBuffer.getDouble());
            case -74:
                return ((FirebaseFirestore) f(byteBuffer)).o((String) f(byteBuffer));
            case -73:
                return com.google.firebase.firestore.f.d(z2.p.d(byteBuffer));
            case -72:
                return com.google.firebase.firestore.r.b(u(f(byteBuffer)));
            case -71:
                return com.google.firebase.firestore.r.a(u(f(byteBuffer)));
            case -70:
                return com.google.firebase.firestore.r.c();
            case -69:
                return com.google.firebase.firestore.r.g();
            case -68:
                return new f1.q(byteBuffer.getLong(), byteBuffer.getInt());
            case -67:
                return com.google.firebase.firestore.r.e(((Number) f(byteBuffer)).doubleValue());
            case -66:
                return com.google.firebase.firestore.r.f(((Number) f(byteBuffer)).intValue());
            case -65:
                return com.google.firebase.firestore.q.a();
            case -64:
                int e5 = z2.p.e(byteBuffer);
                ArrayList arrayList = new ArrayList(e5);
                for (int i5 = 0; i5 < e5; i5++) {
                    arrayList.add(f(byteBuffer));
                }
                return com.google.firebase.firestore.q.d((String[]) arrayList.toArray(new String[0]));
            case -63:
                return Double.valueOf(Double.NaN);
            case -62:
                return Double.valueOf(Double.POSITIVE_INFINITY);
            case -61:
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            case -60:
                return r(byteBuffer);
            case -59:
                return s(byteBuffer);
            case -58:
                return t(byteBuffer);
            default:
                return super.g(b5, byteBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z2.p
    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i5;
        String a5;
        if (obj instanceof Date) {
            byteArrayOutputStream.write(-76);
            z2.p.n(byteArrayOutputStream, ((Date) obj).getTime());
        } else if (obj instanceof f1.q) {
            byteArrayOutputStream.write(-68);
            f1.q qVar = (f1.q) obj;
            z2.p.n(byteArrayOutputStream, qVar.n());
            z2.p.m(byteArrayOutputStream, qVar.h());
        } else if (obj instanceof com.google.firebase.firestore.d0) {
            byteArrayOutputStream.write(-75);
            z2.p.h(byteArrayOutputStream, 8);
            com.google.firebase.firestore.d0 d0Var = (com.google.firebase.firestore.d0) obj;
            z2.p.k(byteArrayOutputStream, d0Var.c());
            z2.p.k(byteArrayOutputStream, d0Var.d());
        } else if (obj instanceof com.google.firebase.firestore.m) {
            byteArrayOutputStream.write(-74);
            com.google.firebase.firestore.m mVar = (com.google.firebase.firestore.m) obj;
            FirebaseFirestore j5 = mVar.j();
            p(byteArrayOutputStream, j5.r().q());
            p(byteArrayOutputStream, mVar.l());
            synchronized (w.f2800h) {
                a5 = w.Y(j5).a();
            }
            p(byteArrayOutputStream, a5);
        } else if (obj instanceof com.google.firebase.firestore.n) {
            w(byteArrayOutputStream, (com.google.firebase.firestore.n) obj);
        } else if (obj instanceof y0) {
            y(byteArrayOutputStream, (y0) obj);
        } else if (obj instanceof com.google.firebase.firestore.h) {
            v(byteArrayOutputStream, (com.google.firebase.firestore.h) obj);
        } else if (obj instanceof com.google.firebase.firestore.j0) {
            x(byteArrayOutputStream, (com.google.firebase.firestore.j0) obj);
        } else if (obj instanceof c1) {
            z(byteArrayOutputStream, (c1) obj);
        } else if (obj instanceof com.google.firebase.firestore.f) {
            byteArrayOutputStream.write(-73);
            z2.p.i(byteArrayOutputStream, ((com.google.firebase.firestore.f) obj).h());
        } else {
            if (obj instanceof Double) {
                Double d5 = (Double) obj;
                if (Double.isNaN(d5.doubleValue())) {
                    i5 = -63;
                } else if (d5.equals(Double.valueOf(Double.NEGATIVE_INFINITY))) {
                    i5 = -61;
                } else if (d5.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
                    i5 = -62;
                }
                byteArrayOutputStream.write(i5);
                return;
            }
            super.p(byteArrayOutputStream, obj);
        }
    }
}
