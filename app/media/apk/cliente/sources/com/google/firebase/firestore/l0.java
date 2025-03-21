package com.google.firebase.firestore;
/* loaded from: classes.dex */
public final class l0 implements k0 {

    /* renamed from: a  reason: collision with root package name */
    private n0 f1742a;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private n0 f1743a;

        private b() {
            this.f1743a = m0.a().a();
        }

        public l0 a() {
            return new l0(this.f1743a);
        }
    }

    private l0(n0 n0Var) {
        this.f1742a = n0Var;
    }

    public static b b() {
        return new b();
    }

    public n0 a() {
        return this.f1742a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l0.class != obj.getClass()) {
            return false;
        }
        return a().equals(((l0) obj).a());
    }

    public int hashCode() {
        return this.f1742a.hashCode();
    }

    public String toString() {
        return "MemoryCacheSettings{gcSettings=" + a() + "}";
    }
}
