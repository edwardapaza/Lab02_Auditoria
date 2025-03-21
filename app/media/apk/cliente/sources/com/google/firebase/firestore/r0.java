package com.google.firebase.firestore;
/* loaded from: classes.dex */
public final class r0 implements k0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f1767a;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private long f1768a;

        private b() {
            this.f1768a = 104857600L;
        }

        public r0 a() {
            return new r0(this.f1768a);
        }

        public b b(long j5) {
            this.f1768a = j5;
            return this;
        }
    }

    private r0(long j5) {
        this.f1767a = j5;
    }

    public static b b() {
        return new b();
    }

    public long a() {
        return this.f1767a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && r0.class == obj.getClass() && this.f1767a == ((r0) obj).f1767a;
    }

    public int hashCode() {
        long j5 = this.f1767a;
        return (int) (j5 ^ (j5 >>> 32));
    }

    public String toString() {
        return "PersistentCacheSettings{sizeBytes=" + this.f1767a + '}';
    }
}
