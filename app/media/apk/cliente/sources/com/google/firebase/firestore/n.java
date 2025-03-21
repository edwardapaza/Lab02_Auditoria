package com.google.firebase.firestore;

import java.util.Map;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseFirestore f1746a;

    /* renamed from: b  reason: collision with root package name */
    private final v1.l f1747b;

    /* renamed from: c  reason: collision with root package name */
    private final v1.i f1748c;

    /* renamed from: d  reason: collision with root package name */
    private final c1 f1749d;

    /* loaded from: classes.dex */
    public enum a {
        NONE,
        ESTIMATE,
        PREVIOUS;
        

        /* renamed from: d  reason: collision with root package name */
        static final a f1753d = NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FirebaseFirestore firebaseFirestore, v1.l lVar, v1.i iVar, boolean z4, boolean z5) {
        this.f1746a = (FirebaseFirestore) z1.y.b(firebaseFirestore);
        this.f1747b = (v1.l) z1.y.b(lVar);
        this.f1748c = iVar;
        this.f1749d = new c1(z5, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n b(FirebaseFirestore firebaseFirestore, v1.i iVar, boolean z4, boolean z5) {
        return new n(firebaseFirestore, iVar.getKey(), iVar, z4, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n c(FirebaseFirestore firebaseFirestore, v1.l lVar, boolean z4) {
        return new n(firebaseFirestore, lVar, null, z4, false);
    }

    public boolean a() {
        return this.f1748c != null;
    }

    public Map<String, Object> d() {
        return e(a.f1753d);
    }

    public Map<String, Object> e(a aVar) {
        z1.y.c(aVar, "Provided serverTimestampBehavior value must not be null.");
        j1 j1Var = new j1(this.f1746a, aVar);
        v1.i iVar = this.f1748c;
        if (iVar == null) {
            return null;
        }
        return j1Var.b(iVar.k().m());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.f1746a.equals(nVar.f1746a) && this.f1747b.equals(nVar.f1747b) && this.f1749d.equals(nVar.f1749d)) {
                v1.i iVar = this.f1748c;
                if (iVar == null) {
                    if (nVar.f1748c == null) {
                        return true;
                    }
                } else if (nVar.f1748c != null && iVar.k().equals(nVar.f1748c.k())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public c1 f() {
        return this.f1749d;
    }

    public m g() {
        return new m(this.f1747b, this.f1746a);
    }

    public int hashCode() {
        int hashCode = ((this.f1746a.hashCode() * 31) + this.f1747b.hashCode()) * 31;
        v1.i iVar = this.f1748c;
        int hashCode2 = (hashCode + (iVar != null ? iVar.getKey().hashCode() : 0)) * 31;
        v1.i iVar2 = this.f1748c;
        return ((hashCode2 + (iVar2 != null ? iVar2.k().hashCode() : 0)) * 31) + this.f1749d.hashCode();
    }

    public String toString() {
        return "DocumentSnapshot{key=" + this.f1747b + ", metadata=" + this.f1749d + ", doc=" + this.f1748c + '}';
    }
}
