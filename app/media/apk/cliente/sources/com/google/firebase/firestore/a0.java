package com.google.firebase.firestore;

import java.util.Objects;
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final String f1645a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1646b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1647c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1648d;

    /* renamed from: e  reason: collision with root package name */
    private k0 f1649e;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        private k0 f1654e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1655f = false;

        /* renamed from: a  reason: collision with root package name */
        private String f1650a = "firestore.googleapis.com";

        /* renamed from: b  reason: collision with root package name */
        private boolean f1651b = true;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1652c = true;

        /* renamed from: d  reason: collision with root package name */
        private long f1653d = 104857600;

        public a0 f() {
            if (this.f1651b || !this.f1650a.equals("firestore.googleapis.com")) {
                return new a0(this);
            }
            throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
        }

        public b g(String str) {
            this.f1650a = (String) z1.y.c(str, "Provided host must not be null.");
            return this;
        }

        public b h(k0 k0Var) {
            if (this.f1655f) {
                throw new IllegalStateException("Deprecated setPersistenceEnabled() or setCacheSizeBytes() is already used, remove those first.");
            }
            if ((k0Var instanceof l0) || (k0Var instanceof r0)) {
                this.f1654e = k0Var;
                return this;
            }
            throw new IllegalArgumentException("Only MemoryCacheSettings and PersistentCacheSettings are accepted");
        }

        public b i(boolean z4) {
            this.f1651b = z4;
            return this;
        }
    }

    private a0(b bVar) {
        this.f1645a = bVar.f1650a;
        this.f1646b = bVar.f1651b;
        this.f1647c = bVar.f1652c;
        this.f1648d = bVar.f1653d;
        this.f1649e = bVar.f1654e;
    }

    public k0 a() {
        return this.f1649e;
    }

    @Deprecated
    public long b() {
        k0 k0Var = this.f1649e;
        if (k0Var != null) {
            if (k0Var instanceof r0) {
                return ((r0) k0Var).a();
            }
            l0 l0Var = (l0) k0Var;
            if (l0Var.a() instanceof o0) {
                return ((o0) l0Var.a()).a();
            }
            return -1L;
        }
        return this.f1648d;
    }

    public String c() {
        return this.f1645a;
    }

    @Deprecated
    public boolean d() {
        k0 k0Var = this.f1649e;
        return k0Var != null ? k0Var instanceof r0 : this.f1647c;
    }

    public boolean e() {
        return this.f1646b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a0.class != obj.getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        if (this.f1646b == a0Var.f1646b && this.f1647c == a0Var.f1647c && this.f1648d == a0Var.f1648d && this.f1645a.equals(a0Var.f1645a)) {
            return Objects.equals(this.f1649e, a0Var.f1649e);
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f1648d;
        int hashCode = ((((((this.f1645a.hashCode() * 31) + (this.f1646b ? 1 : 0)) * 31) + (this.f1647c ? 1 : 0)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        k0 k0Var = this.f1649e;
        return hashCode + (k0Var != null ? k0Var.hashCode() : 0);
    }

    public String toString() {
        if (("FirebaseFirestoreSettings{host=" + this.f1645a + ", sslEnabled=" + this.f1646b + ", persistenceEnabled=" + this.f1647c + ", cacheSizeBytes=" + this.f1648d + ", cacheSettings=" + this.f1649e) == null) {
            return "null";
        }
        return this.f1649e.toString() + "}";
    }
}
