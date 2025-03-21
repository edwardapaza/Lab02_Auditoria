package com.google.firebase.firestore;

import com.google.firebase.firestore.n;
import com.google.protobuf.u1;
import i2.d0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j1 {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseFirestore f1731a;

    /* renamed from: b  reason: collision with root package name */
    private final n.a f1732b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1733a;

        static {
            int[] iArr = new int[n.a.values().length];
            f1733a = iArr;
            try {
                iArr[n.a.PREVIOUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1733a[n.a.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public j1(FirebaseFirestore firebaseFirestore, n.a aVar) {
        this.f1731a = firebaseFirestore;
        this.f1732b = aVar;
    }

    private List<Object> a(i2.b bVar) {
        ArrayList arrayList = new ArrayList(bVar.m0());
        for (i2.d0 d0Var : bVar.e()) {
            arrayList.add(f(d0Var));
        }
        return arrayList;
    }

    private Object c(i2.d0 d0Var) {
        v1.f d5 = v1.f.d(d0Var.x0());
        v1.l h5 = v1.l.h(d0Var.x0());
        v1.f t5 = this.f1731a.t();
        if (!d5.equals(t5)) {
            z1.w.e("DocumentSnapshot", "Document %s contains a document reference within a different database (%s/%s) which is not supported. It will be treated as a reference in the current database (%s/%s) instead.", h5.q(), d5.h(), d5.e(), t5.h(), t5.e());
        }
        return new m(h5, this.f1731a);
    }

    private Object d(i2.d0 d0Var) {
        int i5 = a.f1733a[this.f1732b.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                return null;
            }
            return e(v1.v.a(d0Var));
        }
        i2.d0 b5 = v1.v.b(d0Var);
        if (b5 == null) {
            return null;
        }
        return f(b5);
    }

    private Object e(u1 u1Var) {
        return new f1.q(u1Var.i0(), u1Var.h0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> b(Map<String, i2.d0> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, i2.d0> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), f(entry.getValue()));
        }
        return hashMap;
    }

    public Object f(i2.d0 d0Var) {
        switch (v1.z.G(d0Var)) {
            case 0:
                return null;
            case 1:
                return Boolean.valueOf(d0Var.q0());
            case 2:
                return d0Var.A0().equals(d0.c.INTEGER_VALUE) ? Long.valueOf(d0Var.v0()) : Double.valueOf(d0Var.t0());
            case 3:
                return e(d0Var.z0());
            case 4:
                return d(d0Var);
            case 5:
                return d0Var.y0();
            case 6:
                return f.c(d0Var.r0());
            case 7:
                return c(d0Var);
            case 8:
                return new d0(d0Var.u0().h0(), d0Var.u0().i0());
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return a(d0Var.p0());
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return b(d0Var.w0().h0());
            default:
                throw z1.b.a("Unknown value type: " + d0Var.A0(), new Object[0]);
        }
    }
}
