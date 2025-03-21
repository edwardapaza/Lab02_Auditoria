package com.google.firebase.firestore;

import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: c  reason: collision with root package name */
    static final a1 f1656c = new a1(false, null);

    /* renamed from: d  reason: collision with root package name */
    private static final a1 f1657d = new a1(true, null);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1658a;

    /* renamed from: b  reason: collision with root package name */
    private final w1.d f1659b;

    private a1(boolean z4, w1.d dVar) {
        z1.y.a(dVar == null || z4, "Cannot specify a fieldMask for non-merge sets()", new Object[0]);
        this.f1658a = z4;
        this.f1659b = dVar;
    }

    public static a1 c() {
        return f1657d;
    }

    public static a1 d(List<q> list) {
        HashSet hashSet = new HashSet();
        for (q qVar : list) {
            hashSet.add(qVar.c());
        }
        return new a1(true, w1.d.b(hashSet));
    }

    public w1.d a() {
        return this.f1659b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f1658a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a1.class != obj.getClass()) {
            return false;
        }
        a1 a1Var = (a1) obj;
        if (this.f1658a != a1Var.f1658a) {
            return false;
        }
        w1.d dVar = this.f1659b;
        w1.d dVar2 = a1Var.f1659b;
        return dVar != null ? dVar.equals(dVar2) : dVar2 == null;
    }

    public int hashCode() {
        int i5 = (this.f1658a ? 1 : 0) * 31;
        w1.d dVar = this.f1659b;
        return i5 + (dVar != null ? dVar.hashCode() : 0);
    }
}
